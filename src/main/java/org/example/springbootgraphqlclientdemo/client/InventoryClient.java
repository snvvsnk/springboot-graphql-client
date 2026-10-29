package org.example.springbootgraphqlclientdemo.client;

import org.example.springbootgraphqlclientdemo.dto.Item;
import org.example.springbootgraphqlclientdemo.dto.ItemRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.GraphQlClient;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class InventoryClient {

    @Autowired
    private HttpGraphQlClient httpGraphQlClient;
    @Autowired
    private GraphQlClient graphQlClient;

    public List<Item> getProducts() {
        String graphQlQUery = "query GetProducts {\n" +
                "  getProducts {\n" +
                "    stock\n" +
                "    name\n" +
                "  }\n" +
                "}";

        Mono<List<Item>> products = graphQlClient.document(graphQlQUery)
                .retrieve("getProducts")
                .toEntityList(Item.class);

        return products.block();
    }

    public List<Item> getItemsByCategory(String category) {
        String graphQlQuery = String.format("query GetProducts {\n" +
                "  getProductsByCategory(category: \"%s\") {\n" +
                "    category\n" +
                "    price\n" +
                "    name\n" +
                "    stock\n" +
                "  }\n" +
                "}", category);

        Mono<List<Item>> productsByCategory = graphQlClient.document(graphQlQuery).retrieve("getProductsByCategory").toEntityList(Item.class);
        return productsByCategory.block();
    }


    public Item updateStock(ItemRequestDto itemRequestDto) {
        String graphQlQuery = String.format("mutation MyMutation {\n" +
                "  updateStock(id: \"%s\", stock: %d) {\n" +
                "    price\n" +
                "    name\n" +
                "    stock\n" +
                "  }\n" +
                "}", itemRequestDto.getId(), itemRequestDto.getStock());

        return graphQlClient.document(graphQlQuery).retrieve("updateStock").toEntity(Item.class).block();

    }
}

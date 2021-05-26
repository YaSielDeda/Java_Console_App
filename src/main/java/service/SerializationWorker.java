package service;

import entities.Category;
import entities.Product;
import entities.Seller;
import entities.Shop;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationWorker {

    public SerializationWorker() {}

    public String SerializeProduct(Product product) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        om.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.ANY);
        String jsonResult = om.writerWithDefaultPrettyPrinter().writeValueAsString(product);
        return jsonResult;
    }

    public String SerializeShop(Shop shop) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        om.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.ANY);
        String jsonResult = om.writerWithDefaultPrettyPrinter().writeValueAsString(shop);
        return jsonResult;
    }

    public String SerializeCategory(Category category) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        om.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.ANY);
        String jsonResult = om.writerWithDefaultPrettyPrinter().writeValueAsString(category);
        return jsonResult;
    }

    public String SerializeSeller(Seller seller) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        om.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.ANY);
        String jsonResult = om.writerWithDefaultPrettyPrinter().writeValueAsString(seller);
        return jsonResult;
    }
}

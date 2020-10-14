package pl.wiktor.testmapping.controller;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.wiktor.testmapping.model.CustomAttribute;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/mapping")
public class MappingController {

    @PostMapping
    @ResponseBody
    public CustomAttribute getCustomAttributeList(@RequestBody String jsonObject) {

        CustomAttributesWrapper attributesWrapper = new GsonBuilder()
                .create()
                .fromJson(jsonObject, CustomAttributesWrapper.class);

        return attributesWrapper.getCustomAttributes().stream()
                .filter(x -> x.getKey().equals("timestamp"))
                .findFirst()
                .orElse(null);
    }


    private static class CustomAttributesWrapper {

        @SerializedName(value = "customAttributes")
        private List<CustomAttribute> customAttributes = new ArrayList<>();

        public List<CustomAttribute> getCustomAttributes() {
            return customAttributes;
        }

        public void setCustomAttributes(List<CustomAttribute> customAttributes) {
            this.customAttributes = customAttributes;
        }
    }


}

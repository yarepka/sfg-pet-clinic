package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;

import java.util.Map;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet().stream()
                .filter(e -> e.getValue().firstName().equals(lastName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }
}

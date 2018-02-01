package com.cuongnt.utils;

import model.Patient;

import java.util.*;

public class CollectionAllowDuplicatedKey<K, V> {

    private final Map<K, Set<V>> mappings = new HashMap<>();

    public Set<V> getValues(K key) {
        return mappings.get(key);
    }

    public Boolean putValue(K key, V value) {
        Set<V> target = mappings.get(key);
        if (target == null) {
            target = new HashSet<V>();
            mappings.put(key, target);
        }
        return target.add(value);
    }

    public List<Patient> searchByName(String inputName) {
        List<Patient> patients = new ArrayList<>();
        inputName = inputName.toLowerCase();
        Set keySet = mappings.keySet();
        for (Iterator<K> patientNames = keySet.iterator(); patientNames.hasNext(); ) {
            String patientName = (String) patientNames.next();
            if (patientName.toLowerCase().contains(inputName)) {
                patients.addAll((Collection<? extends Patient>) mappings.get(patientName));
            }
        }
        return patients;
    }
}

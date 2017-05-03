package com.connectto.mobile.common.util;

import com.connectto.mobile.entity.Channel;
import com.connectto.mobile.entity.FavoriteBlock;
import com.connectto.mobile.entity.XmlTv;

import java.lang.reflect.Field;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by Serozh on 7/12/2016.
 */
public class ContainerHelper {


    private static ContainerHelper containerHelper = new ContainerHelper();

    private Map<String, List<String>> containerFields;
    private Map<String, Map<String, String>> fieldsMap;
    private Map<String, String> tablesMap;
    private List<String> parentContainerFields;

    private Set<String> containers;

    private ContainerHelper() {
        containerFields = new HashMap<>();
        containers = new HashSet<>();
        parentContainerFields = new ArrayList<>();

        //fields and tables mapping
        fieldsMap = new HashMap<>();
        tablesMap = new HashMap<>();

        // load container declared fields
        loadContainerFields();

        // load containers
        initContainers();

        // init entity - table map
        initTablesMap();

        // init entities fields - columns map
        initFieldsMap();
    }

    public static ContainerHelper getInstance() {
        return containerHelper;
    }

    private void initContainers() {
        containers.add(Channel.class.getSimpleName());
        containers.add(XmlTv.class.getSimpleName());
        containers.add(FavoriteBlock.class.getSimpleName());
    }

    private void loadContainerFields() {
        containerFields.put(Channel.class.getSimpleName(),loadContainerFields(Channel.class));
        containerFields.put(XmlTv.class.getSimpleName(),loadContainerFields(XmlTv.class));
        containerFields.put(FavoriteBlock.class.getSimpleName(),loadContainerFields(FavoriteBlock.class));
    }

    private List<String> loadContainerFields(Class clazz) {
        List<String> __fields = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            __fields.add(field.getName());
        }
        return __fields;
    }

    public List<String> getContainerFields(Class clazz) {
        return containerFields.get(clazz.getSimpleName());
    }

    public boolean hasContainerFields(Class clazz, String fieldName) {
        if (containerFields.get(clazz.getSimpleName()) == null) {
            return false;
        }
        return containerFields.get(clazz.getSimpleName()).contains(fieldName);
    }

    public boolean isCommonField(String fieldName) {
        return parentContainerFields.contains(fieldName);
    }

    public List<String> getContainersContainingField(String fieldName) {
        List<String> containers = new ArrayList<>();

        for (Entry<String, List<String>> entry : containerFields.entrySet()) {
            List<String> fields = containerFields.get(entry.getKey());
            if (fields.contains(fieldName)) {
                containers.add(entry.getKey());
            }
        }
        return containers;
    }

    public Set<String> getContainers() {
        return containers;
    }

    public void initTablesMap() {
        Iterator<String> iterator = containers.iterator();
        while (iterator.hasNext()) {
            String entity =  iterator.next();
            String tableName = ReflationUtil.getTableName(entity);
            if (tableName == null) {
                continue;
            }
            tablesMap.put(entity, tableName);
        }
    }

    public void initFieldsMap() {
        Iterator<String> iterator = containers.iterator();
        Map<String, String> fieldMapByContainer;
        while (iterator.hasNext()) {
            String entity =  iterator.next();

            List<String> fields = containerFields.get(entity);
            fieldMapByContainer = fieldsMap.get(entity);
            if (fieldMapByContainer == null) {
                fieldMapByContainer = new HashMap<String, String>();
            }
            for (String field : fields) {
                String fieldName = ReflationUtil.getColumnName(entity, field);
                if (fieldName == null) {
                    continue;
                }
                fieldMapByContainer.put(field, fieldName);
            }
            fieldsMap.put(entity, fieldMapByContainer);
        }
    }

    public Map<String, String> getTablesMap() {
        return tablesMap;
    }

    public Map<String, Map<String, String>> getFieldsMap() {
        return fieldsMap;
    }

    public Map<String, String> getFieldsMap(String container) {
        return fieldsMap.get(container);
    }

}

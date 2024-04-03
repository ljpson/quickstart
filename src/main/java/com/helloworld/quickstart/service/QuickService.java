package com.helloworld.quickstart.service;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.entity.ItemEntity;
import com.helloworld.quickstart.mapper.QuickMapper;
import com.helloworld.quickstart.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuickService {

    private final QuickMapper quickMapper;
    private final ModelMapper modelMapper;
    private final ItemRepository itemRepository;

    public boolean registerItem(ItemDto itemDto) {
        // TODO: DB insert
        // mybatis
//        log.info("service....mybatis");
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id",itemDto.getId());
//        paramMap.put("name",itemDto.getName());
//
//        quickMapper.registerItem(paramMap);

        // JPA
        log.info("service....jpa");
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId())
                .setName(itemDto.getName());
        itemRepository.save(itemEntity);
        return true;
    }

    public ItemDto getItemById(String id){

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        // mybatis
//        log.info("service....mybatis");
//        HashMap<String, Object> res = quickMapper.findById(paramMap);
//
//        ItemDto itemDto = new ItemDto();
//        itemDto.setId((String) res.get("ID"));
//        itemDto.setName((String) res.get("NAME"));
//        return itemDto;

        // JPA
//        log.info("service....jpa");
//        ItemEntity itemEntity = itemRepository.findById(id).get();
//        ItemDto itemDto = new ItemDto();
//        itemDto.setId(itemEntity.getId())
//                .setName(itemEntity.getName());
//        return itemDto;

        // JPA + modelMapper
        log.info("service....jpa...modelmapper");
        ItemEntity itemEntity = itemRepository.findById(id).get();
        return modelMapper.map(itemEntity, ItemDto.class);
    }
}

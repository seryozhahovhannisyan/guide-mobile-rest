package com.connectto.mobile.repository;

import com.connectto.mobile.entity.FavoriteBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface IFavoriteBlockRepository extends JpaRepository<FavoriteBlock, Long> {

    //public void add(FavoriteBlock favoriteBlock);

    //pagination
    public List<FavoriteBlock> getByParams(Map<String, Object> params);

    public Integer getCountByParams(Map<String, Object> params);

    public List<Integer> getIdesByParams(Map<String, Object> params);


    @Modifying
    @Query("Update FavoriteBlock fb SET fb.favorite=:favorite, fb.favorite_date_time=:favoriteDateTime   WHERE fb.id=:id")
    public void updateFavorite(@Param("id") Long id,
                               @Param("favorite") Integer favorite,
                               @Param("favoriteDateTime") Date favoriteDateTime);

    @Modifying
    @Query("Update FavoriteBlock fb SET fb.block=:block, fb.block_date_time=:blockDateTime, fb.block_password=:blockPassword   WHERE fb.id=:id")
    public void updateBlock(@Param("id") Long id,
                            @Param("block") Integer block,
                            @Param("blockPassword") String blockPassword,
                            @Param("blockDateTime") Date blockDateTime);


}
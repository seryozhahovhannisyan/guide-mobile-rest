package com.connectto.mobile.service;

import com.connectto.mobile.common.exception.DataNotFoundException;
import com.connectto.mobile.common.exception.InternalErrorException;
import com.connectto.mobile.common.exception.PermissionDeniedException;
import com.connectto.mobile.entity.FavoriteBlock;

public interface IFavoriteBlockManager {

    public void favorite(FavoriteBlock favoriteBlock) throws InternalErrorException, DataNotFoundException, PermissionDeniedException;

    public void unFavorite(FavoriteBlock favoriteBlock) throws InternalErrorException, DataNotFoundException, PermissionDeniedException;

    public void block(FavoriteBlock favoriteBlock) throws InternalErrorException, DataNotFoundException, PermissionDeniedException;

    public void unblock(FavoriteBlock favoriteBlock) throws InternalErrorException, DataNotFoundException, PermissionDeniedException;

}
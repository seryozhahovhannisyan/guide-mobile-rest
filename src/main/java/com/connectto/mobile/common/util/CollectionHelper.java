package com.connectto.mobile.common.util;

import java.util.List;

/**
 * Created by Seryozha on 4/30/16.
 */
public class CollectionHelper {

	public static boolean isEmpty(List<?> list) {
		return list == null || list.size() == 0;
	}

	public static boolean isNotEmpty(List<?> list) {
		return !isEmpty(list);
	}


}

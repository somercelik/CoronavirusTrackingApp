package com.somercelik.coronavirustracking.utils;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Utils
 *
 * @author s84240320
 * @since 2022-03-31
 */
public class Utils {
    public static String[][] readCsvFile(String csvContent, boolean hasHeader, String delimiter){
        if(StringUtils.hasLength(csvContent) && StringUtils.hasLength(delimiter)){
            String[][] rows = Arrays.stream(csvContent.split("\n"))
                    .map(item -> item.split(delimiter))
                    .collect(Collectors.toList())
                    .toArray(String[][]::new);
            if(hasHeader){
                rows = Arrays.copyOfRange(rows, 1, rows.length);
            }
            return rows;
        }
        return new String[0][0];
    }
}

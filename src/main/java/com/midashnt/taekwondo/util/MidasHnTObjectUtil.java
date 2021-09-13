package com.midashnt.taekwondo.util;

import java.util.Collection;
import java.util.Map;

public class MidasHnTObjectUtil {

    /**
     * 객체가 Null 인지 확인한다.
     * @param object - 확인할 객체
     * @return boolean - 널일경우(true), 널이아닐경우(false)
     */
    public static boolean isNull(Object object) {
        return ((object == null) || object.equals(null));
    }

    public static boolean isNotNull( Object object) {

        return !MidasHnTObjectUtil.isNull( object);
    }

    public static boolean isNotNull( Object[] objects) {

        return (objects != null && objects.length > 0);
    }

    /**
     * 객체가 비어있는 상태인지 확인한다.
     * 스트링 또는 배열객체에 대하여 빈 상태값을 체크한다.
     *
     * @param object
     * @return boolean
     */
    public static boolean isEmpty( Object object) {
        if ( object == null )
            return true;

        if ( object instanceof String) {
            return (( String)object).length() == 0;
        }
        else if ( object instanceof Collection) {
            return ((Collection<?>)object).size() == 0;
        }
        else if ( object instanceof Map) {
            return ((Map<?, ?>)object).size() == 0;
        }
        else if ( object instanceof Object[]){
            return ((Object[])object).length == 0;
        }
        else if ( object instanceof Integer) {
            return (( Integer)object).intValue() == 0;
        }

        return false;
    }

    public static boolean isNotEmpty( Object object) {
        return !MidasHnTObjectUtil.isEmpty( object);
    }

    /*public static void validateExceedLength(String value, int size, String fieldName) {
        if (value != null && value.length() > 0) {
            if (size > 0 && value.length() > size) {
                throw new CustomException(fieldName + "(" + value.length() + ") : Exceeds Length!");
            }
        }
    }

    public static void validateNotNull(Object object, String fieldName) {
        if (object instanceof String) {
            if (object.equals("")) {
                throw new CustomException(fieldName + " : Field is Empty!");
            }
        } else {
            if (object == null) {
                throw new CustomException(fieldName + " : Field is Null!");
            }
        }
    }

    public static void validateFlagValue(int value, int limitValue, String fieldName) {
        if (value <= 0 || value > limitValue) {
            throw new CustomException(fieldName + "(" + value + ") : Exceeds Value!");
        }
    }*/

}

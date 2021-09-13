package com.midashnt.taekwondo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MidasHnTStringUtil {

    public static String[] deduplication (String[] stringArr) {
        stringArr = new HashSet<String>(Arrays.asList(stringArr)).toArray(new String[0]);

        return  stringArr;
    }

    /**
     * szOriginal에서 szOld를 모두 szNew로 바꾼다.
     *
     * @param szOriginal 원래의 문자열.
     * @param szOld 바꾸고자하는 문자열.
     * @param szNew 새로운 문자열.
     * @return szOriginal 문자열에서 모든 szOld 문자열을 szNew 문자열로 대치한 문자열을 넘긴다.
     */
    public static String replace( String szOriginal, String szOld, String szNew )
    {
        return replace( szOriginal, szOld, szNew, 0 );
    }

    /**
     * sszOriginal에서 처음부터 nReplaceCount개만큼 szOld를 szNew로 바꾼다.
     * 만약 nReplaceCount가 0이면 szOld를 모두 szNew로 바꾼다.
     *
     * @param szOriginal 원래의 문자열.
     * @param szOld 바꾸고자하는 문자열.
     * @param szNew 새로운 문자열.
     * @param nReplaceCount szOriginal의 처음부터 몇개까지의 szOld를 szNew로 바꿀지를 결정한다.
     *                      1이면 처음 나타나는 szOld 문자열만을 szNew로 바꾼다.
     *                      0이면 모든 szOld 문자열을 szNew로 바꾼다.
     * @return szOriginal 문자열에서 szOld 문자열을 찾아 nReplaceCount 갯수만큼 szNew 문자열로 대치한 문자열을 넘긴다.
     */
    public static String replace( String szOriginal, String szOld, String szNew, int nReplaceCount )
    {
        if ( szOriginal == null || szOld == null || szNew == null )
        {
            throw new IllegalArgumentException();
        }

        StringBuffer sbResult = new StringBuffer();
        int nFromIndex = 0, nToIndex = 0 ;
        int nOldLength = szOld.length();
        int i = 0;

        while( (nToIndex = szOriginal.indexOf(szOld, nFromIndex)) >= 0 )
        {
            sbResult.append(szOriginal.substring(nFromIndex, nToIndex)).append( szNew );
            nFromIndex = nToIndex + nOldLength;

            if ( nReplaceCount != 0 && ++i == nReplaceCount )
            {
                return sbResult.append(szOriginal.substring(nFromIndex)).toString();
            }
        }

        return sbResult.append(szOriginal.substring(nFromIndex)).toString();
    }

    /**
     * Delimiter 로 구분된 하나의 Source String 을 Delimiter 단위로 분해하여
     * Array 타입의 Strings 결과를 Return한다. <BR>
     * <PRE>
     * @param szSource  : source string
     * @param szDelimiter : delimiter 로 사용할 string
     *
     *      예) szSource: "123|456|789", szDelimiter: "|"
     *              -> Return: Vector {"123", "456", "789"}
     * </PRE>
     */
    public static String[] getTokenizedStringsWithDelimiter(String szSource, String szDelimiter) {
        if (szSource == null || szDelimiter == null) {
            throw new IllegalArgumentException();
        }

        StringTokenizer st = new StringTokenizer(szSource, szDelimiter, false);
        int nTokenNumber = st.countTokens();
        if (nTokenNumber == 0) {
            return null;
        }

        int i = 0;
        String[] arrResult = new String[nTokenNumber];

        while (st.hasMoreTokens()) {
            arrResult[i++] = st.nextToken();
        }

        return arrResult;
    }

    /**
     * Delimiter 로 구분된 하나의 Source String 을 Delimiter 단위로 분해하고, Trim한후
     * Array 타입의 Strings 결과를 Return한다. <BR>
     * <PRE>
     * @param szSource  : source string
     * @param szDelimiter : delimiter 로 사용할 string
     *
     *      예) szSource: "  123 |  456  |  789", szDelimiter: "|"
     *              -> Return: Vector {"123", "456", "789"}
     * </PRE>
     */
    public static String[] getTokenizedTrimmedStringsWithDelimiter( String szSource, String szDelimiter )
    {
        if ( szSource == null || szDelimiter == null )
        {
            throw new IllegalArgumentException();
        }


        StringTokenizer st = new StringTokenizer( szSource, szDelimiter, false );
        int				nTokenNumber = st.countTokens();
        if ( nTokenNumber == 0 )
        {
            return	null;
        }

        int				i = 0;
        String[] arrResult = new String[nTokenNumber];

        while ( st.hasMoreTokens() )
        {
            arrResult[i++] = st.nextToken().trim();
        }

        return		arrResult;
    }

    /**
     * Delimiter 로 구분된 하나의 Source String 을 Delimiter 단위로 분해하여
     * Array 타입의 Strings 결과를 Return한다. <BR>
     * <PRE>
     * @param szSource: source string
     * @param szDelimiter: delimiter 로 사용할 string
     * @param bIncludeNullString: Null String도 Array의 element도 잡는다.
     *
     *      예) szSource: "|123|456||789|", szDelimiter: "|"
     *              -> Return: Vector {"", "123", "456", "", "789", ""}
     * </PRE>
     */
    public static String[] getTokenizedStringsWithDelimiter( String szSource, String szDelimiter, boolean bIncludeNullString )
    {
        if ( szSource == null || szDelimiter == null )
        {
            throw new IllegalArgumentException();
        }

        if ( szSource.length() == 0 )
        {
            return null;
        }

        StringTokenizer st = new StringTokenizer( szSource, szDelimiter, bIncludeNullString );
        ArrayList<String> al = new ArrayList<String>();
        String szTemp = "";
        boolean bNextDelimiter = false;

        while ( st.hasMoreTokens() )
        {
            szTemp = st.nextToken();

            if ( szTemp.equals(szDelimiter) )
            {
                if ( !bNextDelimiter )
                {
                    al.add( "" );
                }

                bNextDelimiter = false;
            }
            else
            {
                al.add( szTemp );
                bNextDelimiter = true;
            }
        }

        if ( !bNextDelimiter )
        {
            al.add( "" );
        }

        return (String[]) al.toArray(new String[0]);
    }

    /**
     * If string is null or empty string, return false. <br>
     * If not, return true.
     *
     * <pre>
     * StringUtil.isNotEmpty('') 		= false
     * StringUtil.isNotEmpty(null) 		= false
     * StringUtil.isNotEmpty('abc') 	= true
     * </pre>
     *
     * @param str original String
     * @return which empty string or not.
     */
    public static boolean isNotEmpty( String str) {
        return isNotEmpty( str, false);
    }

    public static boolean isNotEmpty(String str, boolean isTrim) {

        if( isTrim) {
            return !isEmpty(str, true);
        }
        else {
            return !isEmpty(str);
        }
    }

    /**
     * If string is null or empty string, return true. <br>
     * If not, return false.
     *
     * <pre>
     * StringUtil.isEmpty('') 		= true
     * StringUtil.isEmpty(null) 	= true
     * StringUtil.isEmpty('abc') 	= false
     * </pre>
     *
     * @param str original String
     * @return which empty string or not.
     */
    public static boolean isEmpty(String str) {
        return isEmpty( str, false);
    }
    public static boolean isEmpty(String str, boolean isTrim) {
        if( isTrim) {
            return isEmptyTrimmed( str);
        }
        else {
            return (str == null || str.length() == 0);
        }
    }

    /**
     * Determine whether a (trimmed) string is empty
     *
     * @param foo The text to check.
     * @return Whether empty.
     */
    public static final boolean isEmptyTrimmed(String foo) {
        return (foo == null || foo.trim().length() == 0);
    }

    /**
     * 문자열을 뒤에서 부터 탐색하여 replace 한다.
     *
     * @param text 작업 대상 문자열
     * @param regex 탐색 문자열
     * @param replacement 교체 될 문자열
     */
    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
    }

}
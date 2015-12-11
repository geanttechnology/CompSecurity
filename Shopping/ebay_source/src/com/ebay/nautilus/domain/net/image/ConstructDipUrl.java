// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ConstructDipUrl
{

    private static final String DEFAULT_IMG_PROC_CONSTRAINT = "l";
    private static final String DYNAMIC_IMG_PARAM = "/d/";
    public static final String EPS_PIX_EXTENSION = "_59";
    private static final int FILTER_TRIANGLE = 1;
    public static final String GIF_EPS_IMAGE_FILE_EXTENSION = ".GIF";
    private static final String IMG_FILTER_KEY = "f";
    private static final String IMG_WATERMARK_KEY = "m";
    public static final String JPG_EPS_IMAGE_FILE_EXTENSION = ".JPG";
    public static final String SEARCH_INDEX_1000x1000 = "_32";
    public static final String SEARCH_INDEX_140by140 = "_26";
    public static final String SEARCH_INDEX_1600x1600 = "_57";
    public static final String SEARCH_INDEX_200by200 = "_9";
    public static final String SEARCH_INDEX_400x400 = "_1";
    public static final String SEARCH_INDEX_640x640 = "_58";
    public static final String SEARCH_INDEX_800x800 = "_3";
    private static final String SLASH = "/";
    private static final String UNDERSCORE = "_";
    private static Map imageIdSizeMap;

    public ConstructDipUrl()
    {
    }

    public static String constructDynamicUrl(String s, String s1)
    {
        int i;
        int j;
        if (getWatermarkIdFromBaseUrl(s) >= 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        s1 = (Integer)imageIdSizeMap.get(s1);
        j = s.indexOf("_");
        if (!i || s1 == null || j == -1)
        {
            return null;
        }
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(s.substring(0, j + 1));
        stringbuffer.append("/d/");
        stringbuffer.append("l");
        stringbuffer.append(s1.intValue());
        stringbuffer.append("/");
        stringbuffer.append("m");
        stringbuffer.append(getWatermarkIdFromBaseUrl(s));
        stringbuffer.append("/");
        stringbuffer.append("f");
        stringbuffer.append(1);
        j = s.toUpperCase(Locale.US).indexOf(".JPG");
        i = j;
        if (j == -1)
        {
            i = s.toUpperCase(Locale.US).indexOf(".GIF");
        }
        if (i != -1)
        {
            stringbuffer.append(s.substring(i));
        }
        return stringbuffer.toString();
    }

    private static int getWatermarkIdFromBaseUrl(String s)
    {
        byte byte0 = -1;
        if (s == null)
        {
            return -1;
        }
        int j = s.indexOf("~~");
        int k = s.indexOf("_");
        int i = byte0;
        if (j != -1)
        {
            i = byte0;
            if (k != -1)
            {
                i = byte0;
                if (k > j)
                {
                    String s1 = s.substring(j + 2, k);
                    s = s1;
                    if (TextUtils.isEmpty(s1))
                    {
                        s = "0";
                    }
                    try
                    {
                        i = Integer.parseInt(s);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        return -1;
                    }
                }
            }
        }
        return i;
    }

    static 
    {
        imageIdSizeMap = new HashMap();
        imageIdSizeMap.put("_0", Integer.valueOf(96));
        imageIdSizeMap.put("_1", Integer.valueOf(400));
        imageIdSizeMap.put("_2", Integer.valueOf(200));
        imageIdSizeMap.put("_3", Integer.valueOf(800));
        imageIdSizeMap.put("_6", Integer.valueOf(70));
        imageIdSizeMap.put("_7", Integer.valueOf(150));
        imageIdSizeMap.put("_8", Integer.valueOf(400));
        imageIdSizeMap.put("_9", Integer.valueOf(200));
        imageIdSizeMap.put("_12", Integer.valueOf(500));
        imageIdSizeMap.put("_14", Integer.valueOf(64));
        imageIdSizeMap.put("_17", Integer.valueOf(80));
        imageIdSizeMap.put("_26", Integer.valueOf(140));
        imageIdSizeMap.put("_32", Integer.valueOf(1000));
        imageIdSizeMap.put("_35", Integer.valueOf(300));
        imageIdSizeMap.put("_39", Integer.valueOf(32));
        imageIdSizeMap.put("_57", Integer.valueOf(1600));
        imageIdSizeMap.put("_58", Integer.valueOf(640));
        imageIdSizeMap.put("_59", Integer.valueOf(960));
    }
}

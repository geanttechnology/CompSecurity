// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.adaptive;

import android.text.TextUtils;
import com.amazon.retailsearch.adaptive.framework.AdaptiveTreatmentEnum;
import com.amazon.retailsearch.adaptive.framework.ModelAdapter;
import com.amazon.retailsearch.adaptive.latency.ImageQualityTreatment;
import com.amazon.searchapp.retailsearch.model.Image;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImageAdapter
    implements ModelAdapter
{

    private static final Map LATENCY_TO_TAG_MAP;
    private static final String QL_TAG_REGEX = "_QL\\d{2,3}_";
    private static ImageAdapter instance = null;

    private ImageAdapter()
    {
    }

    public static ImageAdapter getInstance()
    {
        if (instance == null)
        {
            instance = new ImageAdapter();
        }
        return instance;
    }

    public Image adapt(Image image, AdaptiveTreatmentEnum adaptivetreatmentenum)
    {
_L2:
        return image;
        if (image == null || TextUtils.isEmpty(image.getUrl()) || adaptivetreatmentenum == ImageQualityTreatment.HIGH) goto _L2; else goto _L1
_L1:
        adaptivetreatmentenum = (String)LATENCY_TO_TAG_MAP.get(adaptivetreatmentenum);
        if (TextUtils.isEmpty(adaptivetreatmentenum)) goto _L2; else goto _L3
_L3:
        String s = image.getUrl();
        if (!s.matches(".*_QL\\d{2,3}_.*")) goto _L5; else goto _L4
_L4:
        if (s.contains(adaptivetreatmentenum)) goto _L2; else goto _L6
_L6:
        adaptivetreatmentenum = s.replaceFirst("_QL\\d{2,3}_", adaptivetreatmentenum);
_L8:
        image.setUrl(adaptivetreatmentenum);
        return image;
_L5:
        int i = s.lastIndexOf('.');
        adaptivetreatmentenum = (new StringBuilder(s)).insert(i, adaptivetreatmentenum).toString();
        if (true) goto _L8; else goto _L7
_L7:
    }

    public volatile Object adapt(Object obj, AdaptiveTreatmentEnum adaptivetreatmentenum)
    {
        return adapt((Image)obj, adaptivetreatmentenum);
    }

    static 
    {
        HashMap hashmap = new HashMap(3);
        hashmap.put(ImageQualityTreatment.MEDIUM, "QL70_");
        hashmap.put(ImageQualityTreatment.LOW, "QL50_");
        hashmap.put(ImageQualityTreatment.VERY_LOW, "QL10_");
        LATENCY_TO_TAG_MAP = Collections.unmodifiableMap(hashmap);
    }
}

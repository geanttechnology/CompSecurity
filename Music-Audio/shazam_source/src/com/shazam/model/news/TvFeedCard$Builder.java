// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            TvFeedCard

public static class 
{

    public Actions actions;
    public final Map beaconData = new HashMap();
    public String id;
    public String image;
    public float imageRatio;
    public String overlayBody;
    public String overlayDecoration;
    public String overlayImage;
    public float overlayImageRatio;
    public String overlayTitle;
    public long timestamp;

    static long a( )
    {
        return .timestamp;
    }

    public static timestamp a()
    {
        return new <init>();
    }

    static Actions b(<init> <init>1)
    {
        return <init>1.actions;
    }

    static String c(actions actions1)
    {
        return actions1.id;
    }

    static Map d(id id1)
    {
        return id1.beaconData;
    }

    static String e(beaconData beacondata)
    {
        return beacondata.image;
    }

    static String f(image image1)
    {
        return image1.overlayImage;
    }

    static String g(overlayImage overlayimage)
    {
        return overlayimage.overlayTitle;
    }

    static String h(overlayTitle overlaytitle)
    {
        return overlaytitle.overlayBody;
    }

    static float i(overlayBody overlaybody)
    {
        return overlaybody.imageRatio;
    }

    static float j(imageRatio imageratio)
    {
        return imageratio.overlayImageRatio;
    }

    static String k(overlayImageRatio overlayimageratio)
    {
        return overlayimageratio.overlayDecoration;
    }

    public ()
    {
    }
}

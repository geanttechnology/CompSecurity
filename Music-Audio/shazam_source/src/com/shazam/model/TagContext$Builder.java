// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;

import com.shazam.model.audio.Watermark;
import com.shazam.model.gimbal.Gimbal;
import com.shazam.model.ibeacon.IBeacons;
import com.shazam.model.time.Ntp;
import com.shazam.model.visual.Image;

// Referenced classes of package com.shazam.model:
//            TagContext

public static class 
{

    public Gimbal gimbal;
    IBeacons iBeacons;
    public Image image;
    public Ntp ntp;
    public Watermark watermark;

    public static  a()
    {
        return new <init>();
    }

    public static <init> a(<init> <init>1)
    {
        <init> <init>2 = new <init>();
        <init>2.watermark = <init>1.watermark;
        <init>2.ntp = <init>1.ntp;
        <init>2.gimbal = <init>1.gimbal;
        <init>2.iBeacons = <init>1.iBeacons;
        <init>2.image = <init>1.image;
        return <init>2;
    }

    static Watermark b(image image1)
    {
        return image1.watermark;
    }

    static Ntp c(watermark watermark1)
    {
        return watermark1.ntp;
    }

    static Gimbal d(ntp ntp1)
    {
        return ntp1.gimbal;
    }

    static IBeacons e(gimbal gimbal1)
    {
        return gimbal1.iBeacons;
    }

    static Image f(iBeacons ibeacons)
    {
        return ibeacons.image;
    }

    public final TagContext b()
    {
        return new TagContext(this, null);
    }

    public ()
    {
    }
}

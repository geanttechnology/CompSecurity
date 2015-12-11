// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.share;

import java.util.ArrayList;

// Referenced classes of package com.shazam.model.share:
//            ShareData

public static class 
{

    public String beaconKey;
    public String campaign;
    public String screenName;
    public final ArrayList shareDataItems = new ArrayList();
    public String subject;
    public String text;
    public String trackId;
    public String trackStyle;

    public static  a()
    {
        return new <init>();
    }

    public static <init> a(ShareData sharedata)
    {
        <init> <init>1 = new <init>();
        <init>1.subject = ShareData.a(sharedata);
        <init>1.text = ShareData.b(sharedata);
        <init>1.shareDataItems.addAll(ShareData.c(sharedata));
        <init>1.trackId = ShareData.d(sharedata);
        <init>1.beaconKey = ShareData.e(sharedata);
        <init>1.campaign = ShareData.f(sharedata);
        <init>1.trackStyle = ShareData.g(sharedata);
        <init>1.screenName = ShareData.h(sharedata);
        return <init>1;
    }

    static String a(screenName screenname)
    {
        return screenname.subject;
    }

    static String b(subject subject1)
    {
        return subject1.text;
    }

    static ArrayList c(text text1)
    {
        return text1.shareDataItems;
    }

    static String d(shareDataItems sharedataitems)
    {
        return sharedataitems.trackId;
    }

    static String e(trackId trackid)
    {
        return trackid.beaconKey;
    }

    static String f(beaconKey beaconkey)
    {
        return beaconkey.campaign;
    }

    static String g(campaign campaign1)
    {
        return campaign1.trackStyle;
    }

    static String h(trackStyle trackstyle)
    {
        return trackstyle.screenName;
    }

    public final ShareData b()
    {
        return new ShareData(this, null);
    }

    public ()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.preview;

import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.player.PlaylistItem;
import java.util.List;

// Referenced classes of package com.shazam.model.preview:
//            PreviewViewData

public static class 
{

    public String beaconKey;
    public String campaign;
    public String eventId;
    public String matchCategory;
    public List playDataInfo;
    public PlaylistItem playlistItem;
    public ScreenOrigin screenOrigin;
    public String trackId;

    public static  a()
    {
        return new <init>();
    }

    public static <init> a(PreviewViewData previewviewdata)
    {
        <init> <init>1 = new <init>();
        <init>1.beaconKey = previewviewdata.beaconKey;
        <init>1.campaign = previewviewdata.campaign;
        <init>1.eventId = previewviewdata.eventId;
        <init>1.matchCategory = previewviewdata.matchCategory;
        <init>1.screenOrigin = previewviewdata.screenOrigin;
        <init>1.playlistItem = previewviewdata.playlistItem;
        <init>1.playDataInfo = previewviewdata.playDataInfo;
        <init>1.trackId = previewviewdata.trackId;
        return <init>1;
    }

    static String a(trackId trackid)
    {
        return trackid.trackId;
    }

    static String b(trackId trackid)
    {
        return trackid.eventId;
    }

    static ScreenOrigin c(eventId eventid)
    {
        return eventid.screenOrigin;
    }

    static String d(screenOrigin screenorigin)
    {
        return screenorigin.matchCategory;
    }

    static PlaylistItem e(matchCategory matchcategory)
    {
        return matchcategory.playlistItem;
    }

    static List f(playlistItem playlistitem)
    {
        return playlistitem.playDataInfo;
    }

    static String g(playDataInfo playdatainfo)
    {
        return playdatainfo.beaconKey;
    }

    static String h(beaconKey beaconkey)
    {
        return beaconkey.campaign;
    }

    public final PreviewViewData b()
    {
        return new PreviewViewData(this, null);
    }

    public ()
    {
    }
}

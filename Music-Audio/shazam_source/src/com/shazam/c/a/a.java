// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.a;

import com.shazam.server.legacy.track.AdvertisingInfo;

public final class a
    implements com.shazam.b.a.a
{

    public a()
    {
    }

    public static com.shazam.model.advert.AdvertisingInfo a(AdvertisingInfo advertisinginfo)
    {
        com.shazam.model.advert.AdvertisingInfo.Builder builder = com.shazam.model.advert.AdvertisingInfo.Builder.a();
        builder.params = advertisinginfo.getParams();
        builder.siteName = advertisinginfo.getSiteName();
        builder.previewSiteName = advertisinginfo.getPreviewAdSiteName();
        return new com.shazam.model.advert.AdvertisingInfo(builder, null);
    }

    public final volatile Object a(Object obj)
    {
        return a((AdvertisingInfo)obj);
    }
}

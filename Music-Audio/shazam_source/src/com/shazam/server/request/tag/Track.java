// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.tag;


public class Track
{

    public final String artist;
    public final Double frequencyskew;
    public final long id;
    public final Double offset;
    public final Double timeskew;
    public final String title;

    private Track(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        offset = Builder.access._mth000(builder);
        timeskew = Builder.access._mth100(builder);
        frequencyskew = Builder.access._mth200(builder);
        title = Builder.access._mth300(builder);
        id = Builder.access._mth400(builder);
        artist = Builder.access._mth500(builder);
    }

    Track(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}

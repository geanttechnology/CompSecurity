// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.media;


public final class MediaType extends Enum
{

    private static final MediaType $VALUES[];
    public static final MediaType PHOTO;
    public static final MediaType VIDEO;

    private MediaType(String s, int i)
    {
        super(s, i);
    }

    public static MediaType valueOf(String s)
    {
        return (MediaType)Enum.valueOf(com/amazon/gallery/framework/model/media/MediaType, s);
    }

    public static MediaType[] values()
    {
        return (MediaType[])$VALUES.clone();
    }

    static 
    {
        PHOTO = new MediaType("PHOTO", 0);
        VIDEO = new MediaType("VIDEO", 1);
        $VALUES = (new MediaType[] {
            PHOTO, VIDEO
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.senna;

import com.amazon.gallery.framework.model.media.MediaType;

public final class SennaMediaType extends Enum
{

    private static final SennaMediaType $VALUES[];
    public static final SennaMediaType PHOTO;
    public static final SennaMediaType VIDEO;
    private final MediaType mediaType;
    private final String value;

    private SennaMediaType(String s, int i, MediaType mediatype, String s1)
    {
        super(s, i);
        mediaType = mediatype;
        value = s1;
    }

    public static SennaMediaType valueOf(MediaType mediatype)
    {
        SennaMediaType asennamediatype[] = values();
        int j = asennamediatype.length;
        for (int i = 0; i < j; i++)
        {
            SennaMediaType sennamediatype = asennamediatype[i];
            if (sennamediatype.mediaType == mediatype)
            {
                return sennamediatype;
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("Unmatched gallery media type: ").append(mediatype).toString());
    }

    public static SennaMediaType valueOf(String s)
    {
        return (SennaMediaType)Enum.valueOf(com/amazon/gallery/framework/data/senna/SennaMediaType, s);
    }

    public static SennaMediaType[] values()
    {
        return (SennaMediaType[])$VALUES.clone();
    }

    static 
    {
        PHOTO = new SennaMediaType("PHOTO", 0, MediaType.PHOTO, "PHOTO");
        VIDEO = new SennaMediaType("VIDEO", 1, MediaType.VIDEO, "VIDEO");
        $VALUES = (new SennaMediaType[] {
            PHOTO, VIDEO
        });
    }
}

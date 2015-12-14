// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import com.amazon.gallery.framework.model.media.MediaType;

// Referenced classes of package com.amazon.gallery.framework.data.store:
//            Asset

public static final class fileExtension extends Enum
{

    private static final GIF $VALUES[];
    public static final GIF GIF;
    public static final GIF JPG;
    public static final GIF MP4;
    public static final GIF SQUARE_JPG;
    public final String ext;
    private final String fileExtension;

    public static fileExtension getAssetType(MediaType mediatype)
    {
        switch (ap.com.amazon.gallery.framework.model.media.MediaType[mediatype.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("No asset type for ").append(mediatype).append(" is defined.").toString());

        case 1: // '\001'
            return JPG;

        case 2: // '\002'
            return MP4;
        }
    }

    public static MP4 getAssetType(String s)
    {
        if (s.equalsIgnoreCase(".mp4"))
        {
            return MP4;
        }
        if (s.equalsIgnoreCase(".gif"))
        {
            return GIF;
        } else
        {
            return JPG;
        }
    }

    public static JPG valueOf(String s)
    {
        return (JPG)Enum.valueOf(com/amazon/gallery/framework/data/store/Asset$AssetType, s);
    }

    public static JPG[] values()
    {
        return (JPG[])$VALUES.clone();
    }

    public String getFileExtension()
    {
        return fileExtension;
    }

    static 
    {
        JPG = new <init>("JPG", 0, "", ".jpg");
        SQUARE_JPG = new <init>("SQUARE_JPG", 1, "", ".jpg");
        MP4 = new <init>("MP4", 2, ".mp4", ".mp4");
        GIF = new <init>("GIF", 3, ".gif", ".gif");
        $VALUES = (new .VALUES[] {
            JPG, SQUARE_JPG, MP4, GIF
        });
    }

    private (String s, int i, String s1, String s2)
    {
        super(s, i);
        ext = s1;
        fileExtension = s2;
    }
}

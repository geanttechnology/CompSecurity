// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;


// Referenced classes of package com.amazon.gallery.thor.app.service:
//            VideoTranscodeService

public static final class ext extends Enum
{

    private static final FORMAT_MP4 $VALUES[];
    public static final FORMAT_MP4 FORMAT_3GPP;
    public static final FORMAT_MP4 FORMAT_MP4;
    public final int code;
    public final String ext;
    public final String name;

    public static ext getFormat(String s)
    {
        if (FORMAT_3GPP.name.equals(s))
        {
            return FORMAT_3GPP;
        } else
        {
            return FORMAT_MP4;
        }
    }

    public static FORMAT_MP4 valueOf(String s)
    {
        return (FORMAT_MP4)Enum.valueOf(com/amazon/gallery/thor/app/service/VideoTranscodeService$Container, s);
    }

    public static FORMAT_MP4[] values()
    {
        return (FORMAT_MP4[])$VALUES.clone();
    }

    static 
    {
        FORMAT_3GPP = new <init>("FORMAT_3GPP", 0, "3GPP", 1, "3gp");
        FORMAT_MP4 = new <init>("FORMAT_MP4", 1, "MP4", 2, "mp4");
        $VALUES = (new .VALUES[] {
            FORMAT_3GPP, FORMAT_MP4
        });
    }

    private I(String s, int i, String s1, int j, String s2)
    {
        super(s, i);
        name = s1;
        code = j;
        ext = s2;
    }
}

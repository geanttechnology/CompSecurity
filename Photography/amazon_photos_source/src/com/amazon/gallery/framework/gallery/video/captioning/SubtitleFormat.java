// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video.captioning;


public final class SubtitleFormat extends Enum
{

    private static final SubtitleFormat $VALUES[];
    public static final SubtitleFormat VTT;
    private final String extension;
    private final String mimeType;

    private SubtitleFormat(String s, int i, String s1, String s2)
    {
        super(s, i);
        mimeType = s1;
        extension = s2;
    }

    public static SubtitleFormat valueOf(String s)
    {
        return (SubtitleFormat)Enum.valueOf(com/amazon/gallery/framework/gallery/video/captioning/SubtitleFormat, s);
    }

    public static SubtitleFormat[] values()
    {
        return (SubtitleFormat[])$VALUES.clone();
    }

    public String getExtension()
    {
        return extension;
    }

    public String getMimeType()
    {
        return mimeType;
    }

    static 
    {
        VTT = new SubtitleFormat("VTT", 0, "text/vtt", ".vtt");
        $VALUES = (new SubtitleFormat[] {
            VTT
        });
    }
}

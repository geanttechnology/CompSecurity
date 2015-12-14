// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;


// Referenced classes of package com.inmobi.rendering.mraid:
//            MraidMediaProcessor

public static final class  extends Enum
{

    private static final MEDIA_CONTENT_TYPE_AUDIO_VIDEO $VALUES[];
    public static final MEDIA_CONTENT_TYPE_AUDIO_VIDEO MEDIA_CONTENT_TYPE_AUDIO;
    public static final MEDIA_CONTENT_TYPE_AUDIO_VIDEO MEDIA_CONTENT_TYPE_AUDIO_VIDEO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/rendering/mraid/MraidMediaProcessor$MediaContentType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MEDIA_CONTENT_TYPE_AUDIO = new <init>("MEDIA_CONTENT_TYPE_AUDIO", 0);
        MEDIA_CONTENT_TYPE_AUDIO_VIDEO = new <init>("MEDIA_CONTENT_TYPE_AUDIO_VIDEO", 1);
        $VALUES = (new .VALUES[] {
            MEDIA_CONTENT_TYPE_AUDIO, MEDIA_CONTENT_TYPE_AUDIO_VIDEO
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.extractors;


// Referenced classes of package com.rdio.android.audioplayer.extractors:
//            MediaTypeUtil

public static final class  extends Enum
{

    private static final AAC $VALUES[];
    public static final AAC AAC;
    public static final AAC MP3;
    public static final AAC Unknown;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/audioplayer/extractors/MediaTypeUtil$MediaType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Unknown = new <init>("Unknown", 0);
        MP3 = new <init>("MP3", 1);
        AAC = new <init>("AAC", 2);
        $VALUES = (new .VALUES[] {
            Unknown, MP3, AAC
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

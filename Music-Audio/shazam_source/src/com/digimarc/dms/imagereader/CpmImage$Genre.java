// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.imagereader;


// Referenced classes of package com.digimarc.dms.imagereader:
//            CpmImage

public static final class  extends Enum
{

    private static final Chroma $VALUES[];
    public static final Chroma Chroma;
    public static final Chroma Classic;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/digimarc/dms/imagereader/CpmImage$Genre, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Classic = new <init>("Classic", 0);
        Chroma = new <init>("Chroma", 1);
        $VALUES = (new .VALUES[] {
            Classic, Chroma
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

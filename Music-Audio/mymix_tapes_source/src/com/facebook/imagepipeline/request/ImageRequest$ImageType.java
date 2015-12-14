// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.request;


// Referenced classes of package com.facebook.imagepipeline.request:
//            ImageRequest

public static final class  extends Enum
{

    private static final DEFAULT $VALUES[];
    public static final DEFAULT DEFAULT;
    public static final DEFAULT SMALL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/facebook/imagepipeline/request/ImageRequest$ImageType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SMALL = new <init>("SMALL", 0);
        DEFAULT = new <init>("DEFAULT", 1);
        $VALUES = (new .VALUES[] {
            SMALL, DEFAULT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;


// Referenced classes of package com.amazon.gallery.thor.ftue:
//            FacebookScreen

public static final class  extends Enum
{

    private static final FTUE $VALUES[];
    public static final FTUE AddPhotos;
    public static final FTUE FTUE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/ftue/FacebookScreen$Source, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AddPhotos = new <init>("AddPhotos", 0);
        FTUE = new <init>("FTUE", 1);
        $VALUES = (new .VALUES[] {
            AddPhotos, FTUE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

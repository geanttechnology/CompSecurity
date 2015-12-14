// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters;


// Referenced classes of package com.aviary.android.feather.headless.filters:
//            NativeToolFilter

public static final class  extends Enum
{

    private static final Smart $VALUES[];
    public static final Smart Erase;
    public static final Smart Free;
    public static final Smart None;
    public static final Smart Smart;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/headless/filters/NativeToolFilter$BrushMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        Free = new <init>("Free", 1);
        Erase = new <init>("Erase", 2);
        Smart = new <init>("Smart", 3);
        $VALUES = (new .VALUES[] {
            None, Free, Erase, Smart
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

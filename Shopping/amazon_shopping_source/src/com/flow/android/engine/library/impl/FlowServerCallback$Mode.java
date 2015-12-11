// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl;


// Referenced classes of package com.flow.android.engine.library.impl:
//            FlowServerCallback

public static final class  extends Enum
{

    private static final TEXT $VALUES[];
    public static final TEXT IMAGEMATCH;
    public static final TEXT TEXT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/flow/android/engine/library/impl/FlowServerCallback$Mode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IMAGEMATCH = new <init>("IMAGEMATCH", 0);
        TEXT = new <init>("TEXT", 1);
        $VALUES = (new .VALUES[] {
            IMAGEMATCH, TEXT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

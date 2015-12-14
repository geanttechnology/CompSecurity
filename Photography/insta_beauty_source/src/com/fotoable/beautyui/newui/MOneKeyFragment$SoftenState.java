// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;


public final class  extends Enum
{

    private static final IsSel5 $VALUES[];
    public static final IsSel5 IsSel1;
    public static final IsSel5 IsSel2;
    public static final IsSel5 IsSel3;
    public static final IsSel5 IsSel4;
    public static final IsSel5 IsSel5;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/beautyui/newui/MOneKeyFragment$SoftenState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IsSel1 = new <init>("IsSel1", 0);
        IsSel2 = new <init>("IsSel2", 1);
        IsSel3 = new <init>("IsSel3", 2);
        IsSel4 = new <init>("IsSel4", 3);
        IsSel5 = new <init>("IsSel5", 4);
        $VALUES = (new .VALUES[] {
            IsSel1, IsSel2, IsSel3, IsSel4, IsSel5
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

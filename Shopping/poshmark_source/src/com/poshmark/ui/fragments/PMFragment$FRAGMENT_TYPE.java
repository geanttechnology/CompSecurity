// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

static final class  extends Enum
{

    private static final HAS_DRAWER $VALUES[];
    public static final HAS_DRAWER DRAWER;
    public static final HAS_DRAWER HAS_DRAWER;
    public static final HAS_DRAWER REGULAR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        REGULAR = new <init>("REGULAR", 0);
        DRAWER = new <init>("DRAWER", 1);
        HAS_DRAWER = new <init>("HAS_DRAWER", 2);
        $VALUES = (new .VALUES[] {
            REGULAR, DRAWER, HAS_DRAWER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

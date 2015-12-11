// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shipping.a;


public final class g extends Enum
{

    private static final g $VALUES[];
    public static final g ACCOUNT;
    public static final g CHECKOUT;

    private g(String s, int i)
    {
        super(s, i);
    }

    public static g valueOf(String s)
    {
        return (g)Enum.valueOf(com/target/ui/fragment/shipping/a/g, s);
    }

    public static g[] values()
    {
        return (g[])$VALUES.clone();
    }

    static 
    {
        ACCOUNT = new g("ACCOUNT", 0);
        CHECKOUT = new g("CHECKOUT", 1);
        $VALUES = (new g[] {
            ACCOUNT, CHECKOUT
        });
    }
}

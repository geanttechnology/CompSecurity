// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.a;


public final class g extends Enum
{

    private static final g $VALUES[];
    public static final g PICK_UP_IN_STORE;
    public static final g SHIP_TO_STORE;

    private g(String s, int i)
    {
        super(s, i);
    }

    public static g valueOf(String s)
    {
        return (g)Enum.valueOf(com/target/mothership/common/a/g, s);
    }

    public static g[] values()
    {
        return (g[])$VALUES.clone();
    }

    static 
    {
        SHIP_TO_STORE = new g("SHIP_TO_STORE", 0);
        PICK_UP_IN_STORE = new g("PICK_UP_IN_STORE", 1);
        $VALUES = (new g[] {
            SHIP_TO_STORE, PICK_UP_IN_STORE
        });
    }
}

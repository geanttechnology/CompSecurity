// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.a;


public final class h extends Enum
{

    private static final h $VALUES[];
    public static final h NOMINEE;
    public static final h NONE;
    public static final h SELF;
    private String mValue;

    private h(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static h valueOf(String s)
    {
        return (h)Enum.valueOf(com/target/mothership/common/a/h, s);
    }

    public static h[] values()
    {
        return (h[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        SELF = new h("SELF", 0, "self");
        NOMINEE = new h("NOMINEE", 1, "nominee");
        NONE = new h("NONE", 2, "");
        $VALUES = (new h[] {
            SELF, NOMINEE, NONE
        });
    }
}

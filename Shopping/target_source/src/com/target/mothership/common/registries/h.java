// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.registries;


public final class h extends Enum
{

    private static final h $VALUES[];
    public static final h ANDROID;
    public static final h GSTIPAD;
    public static final h IPHONE;
    public static final h MWEB;
    public static final h UNKNOWN;
    private String mValue;

    private h(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static h valueOf(String s)
    {
        return (h)Enum.valueOf(com/target/mothership/common/registries/h, s);
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
        ANDROID = new h("ANDROID", 0, "ANDROID");
        IPHONE = new h("IPHONE", 1, "IPHONE");
        GSTIPAD = new h("GSTIPAD", 2, "GSTIPAD");
        MWEB = new h("MWEB", 3, "MWEB");
        UNKNOWN = new h("UNKNOWN", 4, "");
        $VALUES = (new h[] {
            ANDROID, IPHONE, GSTIPAD, MWEB, UNKNOWN
        });
    }
}

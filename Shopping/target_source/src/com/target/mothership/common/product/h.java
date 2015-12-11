// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class h extends Enum
{

    private static final h $VALUES[];
    public static final h EMAIL;
    public static final h MAIL;
    public static final h MOBILE;
    public static final h UNKNOWN;
    private String mValue;

    private h(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static h valueOf(String s)
    {
        return (h)Enum.valueOf(com/target/mothership/common/product/h, s);
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
        EMAIL = new h("EMAIL", 0, "EMAIL");
        MAIL = new h("MAIL", 1, "MAIL");
        MOBILE = new h("MOBILE", 2, "MOBILE");
        UNKNOWN = new h("UNKNOWN", 3, "");
        $VALUES = (new h[] {
            EMAIL, MAIL, MOBILE, UNKNOWN
        });
    }
}

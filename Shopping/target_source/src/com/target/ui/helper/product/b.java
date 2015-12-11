// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.product;


public final class b extends Enum
{

    private static final b $VALUES[];
    public static final b EMAIL;
    public static final b EXPRESS_CHECKOUT;
    public static final b MAIL;
    public static final b PICK_UP;
    public static final b SHIP;
    public static final b SMS;
    public static final b UNKNOWN;

    private b(String s, int i)
    {
        super(s, i);
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/target/ui/helper/product/b, s);
    }

    public static b[] values()
    {
        return (b[])$VALUES.clone();
    }

    static 
    {
        SMS = new b("SMS", 0);
        MAIL = new b("MAIL", 1);
        EMAIL = new b("EMAIL", 2);
        SHIP = new b("SHIP", 3);
        PICK_UP = new b("PICK_UP", 4);
        EXPRESS_CHECKOUT = new b("EXPRESS_CHECKOUT", 5);
        UNKNOWN = new b("UNKNOWN", 6);
        $VALUES = (new b[] {
            SMS, MAIL, EMAIL, SHIP, PICK_UP, EXPRESS_CHECKOUT, UNKNOWN
        });
    }
}

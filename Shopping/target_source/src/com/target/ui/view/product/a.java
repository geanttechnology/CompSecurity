// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a ADD_TO_LIST;
    public static final a EMAIL;
    public static final a FIND_IN_STORE;
    public static final a MAIL;
    public static final a PICK_UP;
    public static final a SHIP_IT;
    public static final a SMS;
    public static final a UNKNOWN;

    private a(String s, int i)
    {
        super(s, i);
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/ui/view/product/a, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    static 
    {
        EMAIL = new a("EMAIL", 0);
        SMS = new a("SMS", 1);
        SHIP_IT = new a("SHIP_IT", 2);
        PICK_UP = new a("PICK_UP", 3);
        ADD_TO_LIST = new a("ADD_TO_LIST", 4);
        FIND_IN_STORE = new a("FIND_IN_STORE", 5);
        MAIL = new a("MAIL", 6);
        UNKNOWN = new a("UNKNOWN", 7);
        $VALUES = (new a[] {
            EMAIL, SMS, SHIP_IT, PICK_UP, ADD_TO_LIST, FIND_IN_STORE, MAIL, UNKNOWN
        });
    }
}

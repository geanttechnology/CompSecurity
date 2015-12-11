// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.product;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a DEFAULT;
    public static final a DVM;

    private a(String s, int i)
    {
        super(s, i);
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/ui/model/product/a, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    static 
    {
        DVM = new a("DVM", 0);
        DEFAULT = new a("DEFAULT", 1);
        $VALUES = (new a[] {
            DVM, DEFAULT
        });
    }
}

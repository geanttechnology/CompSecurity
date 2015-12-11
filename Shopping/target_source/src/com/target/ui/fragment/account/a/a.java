// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account.a;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a Create;
    public static final a Delete;
    public static final a Update;

    private a(String s, int i)
    {
        super(s, i);
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/ui/fragment/account/a/a, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    static 
    {
        Create = new a("Create", 0);
        Update = new a("Update", 1);
        Delete = new a("Delete", 2);
        $VALUES = (new a[] {
            Create, Update, Delete
        });
    }
}

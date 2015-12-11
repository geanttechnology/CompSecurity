// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;


final class ModulePath extends Enum
{

    private static final ModulePath $VALUES[];
    public static final ModulePath BASIC;
    public static final ModulePath ITEM;
    public static final ModulePath SEARCH;
    private String mPath;

    private ModulePath(String s, int i, String s1)
    {
        super(s, i);
        mPath = s1;
    }

    public static ModulePath valueOf(String s)
    {
        return (ModulePath)Enum.valueOf(com/amazon/avod/sdk/internal/ModulePath, s);
    }

    public static ModulePath[] values()
    {
        return (ModulePath[])$VALUES.clone();
    }

    public String get()
    {
        return mPath;
    }

    static 
    {
        ITEM = new ModulePath("ITEM", 0, "item");
        SEARCH = new ModulePath("SEARCH", 1, "search");
        BASIC = new ModulePath("BASIC", 2, "basic");
        $VALUES = (new ModulePath[] {
            ITEM, SEARCH, BASIC
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.searchads;


// Referenced classes of package com.google.ads.searchads:
//            SearchAdRequest

public static final class a extends Enum
{

    public static final SOLID DASHED;
    public static final SOLID DOTTED;
    public static final SOLID NONE;
    public static final SOLID SOLID;
    private static final SOLID b[];
    private String a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/google/ads/searchads/SearchAdRequest$BorderType, s);
    }

    public static a[] values()
    {
        return (a[])b.clone();
    }

    public String toString()
    {
        return a;
    }

    static 
    {
        NONE = new <init>("NONE", 0, "none");
        DASHED = new <init>("DASHED", 1, "dashed");
        DOTTED = new <init>("DOTTED", 2, "dotted");
        SOLID = new <init>("SOLID", 3, "solid");
        b = (new b[] {
            NONE, DASHED, DOTTED, SOLID
        });
    }

    private _cls9(String s, int i, String s1)
    {
        super(s, i);
        a = s1;
    }
}

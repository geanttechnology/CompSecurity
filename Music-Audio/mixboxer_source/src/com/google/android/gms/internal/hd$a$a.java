// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            hd

public static class mTag
{

    private final String Bc;
    private String Bd;
    private int Be;
    private final String mTag;

    public mTag as(String s)
    {
        Bd = s;
        return this;
    }

    public Bd bd(int i)
    {
        Be = i;
        return this;
    }

    public Be ek()
    {
        return new nit>(0, Bc, mTag, Bd, Be);
    }

    public (String s, String s1)
    {
        Bc = s;
        mTag = s1;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;


// Referenced classes of package com.nuance.nmsp.client.sdk.oem:
//            EndPointerOEM

public static final class d
{

    public static final a a = new <init>(1);
    public static final <init> b = new <init>(2);
    public static final <init> c = new <init>(3);
    private int d;

    public static d a(int i)
    {
        if (b.d == i)
        {
            return b;
        }
        if (c.d == i)
        {
            return c;
        } else
        {
            return a;
        }
    }


    private (int i)
    {
        d = 1;
        d = i;
    }
}

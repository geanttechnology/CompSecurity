// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.g;

import java.util.Locale;

public class c
{

    public String a;
    public int b;
    public int c;
    public int d;
    public String e;

    public c()
    {
    }

    public String toString()
    {
        return String.format(Locale.US, "[AdLinearAsset kbps=%d width=%d height=%d mime=%s url=%s]", new Object[] {
            Integer.valueOf(b), Integer.valueOf(c), Integer.valueOf(d), a, e
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.content.Intent;

public class p extends Exception
{

    private final Intent a;

    public p(String s, Intent intent)
    {
        super(s);
        a = intent;
    }
}

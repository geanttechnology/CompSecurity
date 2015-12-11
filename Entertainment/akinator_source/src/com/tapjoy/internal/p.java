// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.SharedPreferences;

public abstract class p
{

    protected SharedPreferences a;
    protected String b;

    public p(SharedPreferences sharedpreferences, String s)
    {
        a = sharedpreferences;
        b = s;
    }

    public final void c()
    {
        a.edit().remove(b).commit();
    }
}

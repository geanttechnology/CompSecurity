// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.os.Bundle;

public final class fx
{

    final Bundle a;

    private fx()
    {
        a = new Bundle();
    }

    fx(byte byte0)
    {
        this();
    }

    public final fx a()
    {
        a.putBoolean("enable_zoom", true);
        return this;
    }

    public final fx a(String s)
    {
        a.putString("url", s);
        return this;
    }

    public final fx b()
    {
        a.putBoolean("fit_to_width", true);
        return this;
    }
}

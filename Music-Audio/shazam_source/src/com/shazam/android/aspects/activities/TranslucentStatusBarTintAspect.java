// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities;

import android.content.res.Resources;
import android.os.Bundle;
import com.f.a.a;
import com.shazam.android.aspects.b.a.b;
import com.shazam.android.p.c;
import com.shazam.android.p.m;

public class TranslucentStatusBarTintAspect extends b
{

    private final m platformChecker = new c();

    public TranslucentStatusBarTintAspect()
    {
    }

    public void onCreate(com.shazam.android.aspects.c.a.a a1, Bundle bundle)
    {
        bundle = new a(a1);
        bundle.a();
        int i = 0x7f0f0074;
        if (platformChecker.d())
        {
            i = 0x7f0f0076;
        }
        bundle.a(a1.getResources().getColor(i));
    }
}

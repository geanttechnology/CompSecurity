// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public final class ao
{

    protected int a;
    protected float b;
    protected int c;
    protected float d;
    protected int e;
    protected float f;
    protected int g;
    protected float h;

    public ao()
    {
        a = 0;
        b = 0.0F;
        c = 0;
        d = 0.0F;
        e = 0;
        f = 0.0F;
        g = 0;
        h = 0.0F;
    }

    public final Animation a()
    {
        return new TranslateAnimation(a, b, c, d, e, f, g, h);
    }

    public final ao a(float f1)
    {
        a = 1;
        b = f1;
        return this;
    }

    public final ao b(float f1)
    {
        e = 1;
        f = f1;
        return this;
    }
}

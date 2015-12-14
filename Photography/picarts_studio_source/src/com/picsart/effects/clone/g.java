// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.graphics.RectF;

public final class g
{

    boolean a;
    RectF b;
    float c;
    float d;
    int e;

    public g()
    {
        b = new RectF();
    }

    public g(int i, float f, float f1)
    {
        e = i;
        c = f;
        d = f1;
        a = false;
    }

    public g(RectF rectf)
    {
        b = rectf;
        a = true;
    }
}

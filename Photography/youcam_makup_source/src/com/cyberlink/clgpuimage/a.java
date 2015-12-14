// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.PointF;

public class a
{

    public float a;
    public float b;
    public float c;
    public float d;

    public a()
    {
    }

    public float a()
    {
        return c - a;
    }

    public void a(PointF pointf)
    {
        a = Math.min(a, pointf.x);
        b = Math.min(b, pointf.y);
        c = Math.max(c, pointf.x);
        d = Math.max(d, pointf.y);
    }

    public float b()
    {
        return d - b;
    }

    public void c()
    {
        a = 3.402823E+38F;
        b = 3.402823E+38F;
        c = 1.401298E-45F;
        d = 1.401298E-45F;
    }
}

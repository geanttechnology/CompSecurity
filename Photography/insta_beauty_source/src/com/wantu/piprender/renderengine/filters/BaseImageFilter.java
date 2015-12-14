// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender.renderengine.filters;

import android.content.Context;
import android.opengl.GLES20;
import blo;
import blu;
import bmx;
import bnd;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;

public abstract class BaseImageFilter
    implements bmx
{

    private int a;
    private String b;
    private final int c = 4;
    public blu d;
    public int e;
    public int f;
    public int g;
    public int h;
    protected FloatBuffer i;
    public FloatBuffer j;
    protected FloatBuffer k;
    public FloatBuffer l;
    public float m;
    public float n;

    public BaseImageFilter()
    {
    }

    public void a()
    {
    }

    public void a(float f1, float f2)
    {
        m = f1;
        n = f2;
    }

    public abstract void a(int i1);

    public void a(int i1, int j1)
    {
    }

    public void a(Context context, HashMap hashmap)
    {
        a = bnd.a().a(context, b());
        e = GLES20.glGetUniformLocation(a, "videoFrame");
        f = GLES20.glGetUniformLocation(a, "width");
        g = GLES20.glGetUniformLocation(a, "height");
        a(a);
        i = ByteBuffer.allocateDirect(blo.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        j = ByteBuffer.allocateDirect(blo.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        k = ByteBuffer.allocateDirect(blo.c.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        l = ByteBuffer.allocateDirect(blo.d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        i.put(blo.a).position(0);
        j.put(blo.b).position(0);
        k.put(blo.c).position(0);
        l.put(blo.d).position(0);
    }

    public void a(blu blu1)
    {
        d = blu1;
    }

    public void a(String s)
    {
        b = s;
    }

    public String b()
    {
        return b;
    }

    public void b(int i1)
    {
    }

    public int c()
    {
        return a;
    }

    public int c(int i1)
    {
        if (d == null)
        {
            return 0;
        } else
        {
            int j1 = d.a(i1);
            a(j1, i1);
            return d.c(j1);
        }
    }

    public void d(int i1)
    {
        h = i1;
    }
}

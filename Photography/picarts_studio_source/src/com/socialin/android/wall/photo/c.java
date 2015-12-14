// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.wall.photo;

import android.graphics.Paint;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class c
{

    Path a;
    float b;
    float c;
    Paint d;
    Paint e;
    Paint f;
    int g;
    boolean h;
    boolean i;
    int j;
    int k;
    int l;
    float m;
    float n;
    int o;
    float p;
    List q;
    List r;
    float s;
    float t;
    float u;
    int v;
    float w;
    private int x;
    private int y;

    public c(float f1, float f2, int i1)
    {
        x = 10;
        y = 4;
        g = 10;
        h = false;
        i = false;
        j = 40;
        k = 60;
        l = 40;
        o = 0;
        p = 0.0F;
        q = new ArrayList();
        r = new ArrayList();
        u = 1.0F;
        v = 0;
        w = 0.28F;
        Random random = new Random();
        x = x + random.nextInt(x + 5);
        a = new Path();
        d = new Paint();
        d.setAntiAlias(true);
        d.setStrokeWidth(x);
        d.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        d.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        d.setStrokeMiter(180F);
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setColor(i1);
        e = new Paint();
        e.setAntiAlias(true);
        e.setStrokeWidth(x + y);
        e.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        e.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        e.setStrokeMiter(180F);
        e.setStyle(android.graphics.Paint.Style.STROKE);
        e.setColor(-1);
        f = new Paint();
        f.setColor(-1);
        m = f1;
        n = f2;
        a.moveTo(f1, f2);
        q.add(Float.valueOf(f2));
        r.add(Float.valueOf(f1));
        j = j + random.nextInt(j);
        b = m;
        i = false;
        u = x / 3;
        v = random.nextInt(360);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.ArrayMap;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.c;
import com.bumptech.glide.load.resource.bitmap.i;
import com.bumptech.glide.load.resource.bitmap.p;
import com.bumptech.glide.load.resource.bitmap.r;
import java.util.HashMap;
import java.util.Map;
import myobfuscated.ab.d;
import myobfuscated.ab.h;
import myobfuscated.f.m;

public abstract class a
    implements Cloneable
{

    public int a;
    public float b;
    public l c;
    public Priority d;
    public Drawable e;
    public int f;
    public Drawable g;
    public int h;
    public boolean i;
    public int j;
    public int k;
    public b l;
    public boolean m;
    public boolean n;
    public Drawable o;
    public int p;
    public e q;
    public Map r;
    public Class s;
    public boolean t;
    public android.content.res.Resources.Theme u;
    public boolean v;

    public a()
    {
        b = 1.0F;
        c = l.e;
        d = Priority.NORMAL;
        i = true;
        j = -1;
        k = -1;
        l = myobfuscated.ai.a.a();
        n = true;
        q = new e();
        r = new HashMap();
        s = java/lang/Object;
    }

    private a a(com.bumptech.glide.load.c c1, Object obj)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        myobfuscated.f.m.a(c1, "Argument must not be null");
        myobfuscated.f.m.a(obj, "Argument must not be null");
        a1.q.b.put(c1, obj);
        return a1.d();
    }

    private a a(Class class1, com.bumptech.glide.load.h h1)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        myobfuscated.f.m.a(class1, "Argument must not be null");
        myobfuscated.f.m.a(h1, "Argument must not be null");
        a1.r.put(class1, h1);
        a1.a = a1.a | 0x800;
        a1.n = true;
        a1.a = a1.a | 0x10000;
        return a1.d();
    }

    private a b(Context context, com.bumptech.glide.load.h h1)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        a1.a(android/graphics/Bitmap, h1);
        a1.a(android/graphics/drawable/BitmapDrawable, new c(context, h1));
        a1.a(myobfuscated/ab/d, new h(context, h1));
        return a1.d();
    }

    public static boolean b(int i1, int j1)
    {
        return (i1 & j1) != 0;
    }

    public final a a()
    {
        a a1;
        try
        {
            a1 = (a)super.clone();
            a1.q = new e();
            a1.q.a(q);
            a1.r = new HashMap();
            a1.r.putAll(r);
            a1.t = false;
            a1.v = false;
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new RuntimeException(clonenotsupportedexception);
        }
        return a1;
    }

    public final a a(float f1)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        if (f1 < 0.0F || f1 > 1.0F)
        {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        } else
        {
            a1.b = f1;
            a1.a = a1.a | 2;
            return a1.d();
        }
    }

    public final a a(int i1)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        a1.h = i1;
        a1.a = a1.a | 0x80;
        return a1.d();
    }

    public final a a(int i1, int j1)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        a1.k = i1;
        a1.j = j1;
        a1.a = a1.a | 0x200;
        return a1.d();
    }

    public final a a(Context context)
    {
        return b(context, DownsampleStrategy.b, new i(context));
    }

    public final a a(Context context, com.bumptech.glide.load.h h1)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        a1.b(context, h1);
        a1.m = true;
        a1.a = a1.a | 0x20000;
        return a1.d();
    }

    public final a a(Context context, DownsampleStrategy downsamplestrategy, com.bumptech.glide.load.h h1)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        a1.a(downsamplestrategy);
        return a1.b(context, h1);
    }

    public final a a(android.graphics.Bitmap.CompressFormat compressformat)
    {
        return a(com.bumptech.glide.load.resource.bitmap.d.a, myobfuscated.f.m.a(compressformat, "Argument must not be null"));
    }

    public final a a(Drawable drawable)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        a1.g = drawable;
        a1.a = a1.a | 0x40;
        return a1.d();
    }

    public final a a(Priority priority)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        a1.d = (Priority)myobfuscated.f.m.a(priority, "Argument must not be null");
        a1.a = a1.a | 8;
        return a1.d();
    }

    public final a a(l l1)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        a1.c = (l)myobfuscated.f.m.a(l1, "Argument must not be null");
        a1.a = a1.a | 4;
        return a1.d();
    }

    public final a a(DownsampleStrategy downsamplestrategy)
    {
        return a(p.b, myobfuscated.f.m.a(downsamplestrategy, "Argument must not be null"));
    }

    public final a a(boolean flag)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        a1.i = false;
        a1.a = a1.a | 0x100;
        return a1.d();
    }

    public final a b()
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        a1.r.clear();
        a1.a = a1.a & 0xfffff7ff;
        a1.m = false;
        a1.a = a1.a & 0xfffdffff;
        a1.n = false;
        a1.a = a1.a | 0x10000;
        return a1.d();
    }

    public final a b(int i1)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        a1.f = i1;
        a1.a = a1.a | 0x20;
        return a1.d();
    }

    public final a b(Context context)
    {
        return b(context, DownsampleStrategy.a, ((com.bumptech.glide.load.h) (new r(context))));
    }

    final a b(Context context, DownsampleStrategy downsamplestrategy, com.bumptech.glide.load.h h1)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        a1.a(downsamplestrategy);
        return a1.a(context, h1);
    }

    public final a b(Drawable drawable)
    {
        a a1;
        for (a1 = this; a1.v; a1 = a1.a()) { }
        a1.e = drawable;
        a1.a = a1.a | 0x10;
        return a1.d();
    }

    public final a c()
    {
        if (t && !v)
        {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        } else
        {
            v = true;
            t = true;
            return this;
        }
    }

    public final boolean c(int i1)
    {
        return b(a, i1);
    }

    public Object clone()
    {
        return a();
    }

    public a d()
    {
        if (t)
        {
            throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
        } else
        {
            return this;
        }
    }
}

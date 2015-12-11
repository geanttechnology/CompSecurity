// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.a.b.a;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class b extends com.c.a.a.b.b
{

    private final Map a = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));

    public b(int i)
    {
        super(i);
    }

    protected int a(Bitmap bitmap)
    {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public Bitmap a(String s)
    {
        a.get(s);
        return (Bitmap)super.a(s);
    }

    public volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    public volatile boolean a(Object obj, Object obj1)
    {
        return a((String)obj, (Bitmap)obj1);
    }

    public boolean a(String s, Bitmap bitmap)
    {
        if (super.a(s, bitmap))
        {
            a.put(s, bitmap);
            return true;
        } else
        {
            return false;
        }
    }

    protected Reference b(Bitmap bitmap)
    {
        return new WeakReference(bitmap);
    }

    public volatile void b(Object obj)
    {
        b((String)obj);
    }

    public void b(String s)
    {
        a.remove(s);
        super.b(s);
    }

    protected Object c()
    {
        return d();
    }

    protected Reference c(Object obj)
    {
        return b((Bitmap)obj);
    }

    protected int d(Object obj)
    {
        return a((Bitmap)obj);
    }

    protected Bitmap d()
    {
        Bitmap bitmap = null;
        synchronized (a)
        {
            Iterator iterator = a.entrySet().iterator();
            if (iterator.hasNext())
            {
                bitmap = (Bitmap)((java.util.Map.Entry)iterator.next()).getValue();
                iterator.remove();
            }
        }
        return bitmap;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

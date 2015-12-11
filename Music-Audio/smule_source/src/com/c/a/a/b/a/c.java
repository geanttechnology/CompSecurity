// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.a.b.a;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class c
    implements com.c.a.a.b.c
{

    private final LinkedHashMap a;
    private final int b;
    private int c;

    public c(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        } else
        {
            b = i;
            a = new LinkedHashMap(0, 0.75F, true);
            return;
        }
    }

    private void a(int i)
    {
_L1:
        this;
        JVM INSTR monitorenter ;
        if (c < 0 || a.isEmpty() && c != 0)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getName()).append(".sizeOf() is reporting inconsistent results!").toString());
        }
        break MISSING_BLOCK_LABEL_64;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (c > i && !a.isEmpty())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj = (java.util.Map.Entry)a.entrySet().iterator().next();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        String s = (String)((java.util.Map.Entry) (obj)).getKey();
        obj = (Bitmap)((java.util.Map.Entry) (obj)).getValue();
        a.remove(s);
        c = c - b(s, ((Bitmap) (obj)));
        this;
        JVM INSTR monitorexit ;
          goto _L1
    }

    private int b(String s, Bitmap bitmap)
    {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public final Bitmap a(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("key == null");
        }
        this;
        JVM INSTR monitorenter ;
        s = (Bitmap)a.get(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    public Collection a()
    {
        this;
        JVM INSTR monitorenter ;
        HashSet hashset = new HashSet(a.keySet());
        this;
        JVM INSTR monitorexit ;
        return hashset;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile boolean a(Object obj, Object obj1)
    {
        return a((String)obj, (Bitmap)obj1);
    }

    public final boolean a(String s, Bitmap bitmap)
    {
        if (s == null || bitmap == null)
        {
            throw new NullPointerException("key == null || value == null");
        }
        this;
        JVM INSTR monitorenter ;
        c = c + b(s, bitmap);
        bitmap = (Bitmap)a.put(s, bitmap);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        c = c - b(s, bitmap);
        this;
        JVM INSTR monitorexit ;
        a(b);
        return true;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public volatile void b(Object obj)
    {
        b((String)obj);
    }

    public final void b(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("key == null");
        }
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap = (Bitmap)a.remove(s);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        c = c - b(s, bitmap);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final String toString()
    {
        this;
        JVM INSTR monitorenter ;
        String s = String.format("LruCache[maxSize=%d]", new Object[] {
            Integer.valueOf(b)
        });
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }
}

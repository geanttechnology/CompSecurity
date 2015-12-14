// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.a.b.a;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class a
    implements com.nostra13.universalimageloader.a.b.a
{

    private final com.nostra13.universalimageloader.a.b.a a;
    private final Comparator b;

    public a(com.nostra13.universalimageloader.a.b.a a1, Comparator comparator)
    {
        a = a1;
        b = comparator;
    }

    public Bitmap a(String s)
    {
        return a.a(s);
    }

    public Collection a()
    {
        return a.a();
    }

    public boolean a(String s, Bitmap bitmap)
    {
        com.nostra13.universalimageloader.a.b.a a1 = a;
        a1;
        JVM INSTR monitorenter ;
        Iterator iterator = a.a().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s1 = (String)iterator.next();
        if (b.compare(s, s1) != 0) goto _L4; else goto _L3
_L3:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        a.b(s1);
        a1;
        JVM INSTR monitorexit ;
        return a.a(s, bitmap);
        s;
        a1;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        s1 = null;
        if (true) goto _L3; else goto _L5
_L5:
    }

    public Bitmap b(String s)
    {
        return a.b(s);
    }
}

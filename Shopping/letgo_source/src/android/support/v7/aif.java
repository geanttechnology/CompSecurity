// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

// Referenced classes of package android.support.v7:
//            aid

public class aif
    implements aid
{

    private final aid a;
    private final Comparator b;

    public aif(aid aid1, Comparator comparator)
    {
        a = aid1;
        b = comparator;
    }

    public Bitmap a(String s)
    {
        return (Bitmap)a.a(s);
    }

    public volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    public Collection a()
    {
        return a.a();
    }

    public volatile boolean a(Object obj, Object obj1)
    {
        return a((String)obj, (Bitmap)obj1);
    }

    public boolean a(String s, Bitmap bitmap)
    {
        aid aid1 = a;
        aid1;
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
        aid1;
        JVM INSTR monitorexit ;
        return a.a(s, bitmap);
        s;
        aid1;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        s1 = null;
        if (true) goto _L3; else goto _L5
_L5:
    }

    public Bitmap b(String s)
    {
        return (Bitmap)a.b(s);
    }

    public volatile Object b(Object obj)
    {
        return b((String)obj);
    }
}

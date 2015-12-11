// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import com.flurry.android.impl.ads.protocol.v13.ScreenOrientationType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            ci, x, e

public class y
{

    private final Map a = new HashMap();

    public y()
    {
    }

    public a a(String s, ScreenOrientationType screenorientationtype, e e)
    {
        this;
        JVM INSTR monitorenter ;
        b b1;
        b1 = new b(s, screenorientationtype, e);
        e = (a)a.get(b1);
        screenorientationtype = e;
        if (e != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        screenorientationtype = new a();
        a.a(screenorientationtype, new ci(s));
        a.a(screenorientationtype, new x(s));
        a.put(b1, screenorientationtype);
        this;
        JVM INSTR monitorexit ;
        return screenorientationtype;
        s;
        throw s;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        a a1;
        for (Iterator iterator = a.values().iterator(); iterator.hasNext(); a.b(a1).a())
        {
            a1 = (a)iterator.next();
            a.a(a1).a();
        }

        break MISSING_BLOCK_LABEL_58;
        Exception exception;
        exception;
        throw exception;
        a.clear();
        this;
        JVM INSTR monitorexit ;
    }

    private class b
    {

        String a;
        ScreenOrientationType b;
        e c;

        public boolean equals(Object obj)
        {
            if (obj != null && (obj instanceof b))
            {
                if ((a == ((b) (obj = (b)obj)).a || a == null || a.equals(((b) (obj)).a)) && (b == ((b) (obj)).b || b == null || b.equals(((b) (obj)).b)) && (c == ((b) (obj)).c || c == null || c.equals(((b) (obj)).c)))
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            int j = 17;
            if (a != null)
            {
                j = 0x11 ^ a.hashCode();
            }
            int i = j;
            if (b != null)
            {
                i = j ^ b.hashCode();
            }
            j = i;
            if (c != null)
            {
                j = i ^ c.hashCode();
            }
            return j;
        }

        public b(String s, ScreenOrientationType screenorientationtype, e e1)
        {
            a = s;
            b = screenorientationtype;
            if (e1 != null)
            {
                c = e1.copy();
            }
        }
    }


    private class a
    {

        private ci a;
        private x b;

        static ci a(a a1)
        {
            return a1.a;
        }

        static ci a(a a1, ci ci1)
        {
            a1.a = ci1;
            return ci1;
        }

        static x a(a a1, x x1)
        {
            a1.b = x1;
            return x1;
        }

        static x b(a a1)
        {
            return a1.b;
        }

        public ci a()
        {
            return a;
        }

        public x b()
        {
            return b;
        }

        public a()
        {
        }
    }

}

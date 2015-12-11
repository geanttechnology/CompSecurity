// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package RLSDK:
//            w, v, x, r, 
//            n, bp, dc, ba, 
//            ad, cx, p, y

public final class u
    implements w
{

    private Hashtable a;
    private Vector b;

    public u()
    {
    }

    private y b(p p)
        throws v
    {
        int i;
        int j;
        j = b.size();
        i = 0;
_L2:
        Object obj;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (w)b.elementAt(i);
        obj = ((w) (obj)).a(p, a);
        return ((y) (obj));
        x x1;
        x1;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        throw v.a();
    }

    public final y a(p p)
        throws v
    {
        if (b == null)
        {
            a(((Hashtable) (null)));
        }
        return b(p);
    }

    public final y a(p p, Hashtable hashtable)
        throws v
    {
        a(hashtable);
        return b(p);
    }

    public final void a()
    {
        int j = b.size();
        for (int i = 0; i < j; i++)
        {
            ((w)b.elementAt(i)).a();
        }

    }

    public final void a(Hashtable hashtable)
    {
        boolean flag1 = false;
        a = hashtable;
        Vector vector;
        boolean flag;
        if (hashtable != null && hashtable.containsKey(r.d))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (hashtable == null)
        {
            vector = null;
        } else
        {
            vector = (Vector)hashtable.get(r.c);
        }
        b = new Vector();
        if (vector != null)
        {
            if (vector.contains(n.n) || vector.contains(n.o) || vector.contains(n.h) || vector.contains(n.g) || vector.contains(n.b) || vector.contains(n.c) || vector.contains(n.d) || vector.contains(n.e) || vector.contains(n.i) || vector.contains(n.l) || vector.contains(n.m))
            {
                flag1 = true;
            }
            if (flag1 && !flag)
            {
                b.addElement(new bp(hashtable));
            }
            if (vector.contains(n.k))
            {
                b.addElement(new dc());
            }
            if (vector.contains(n.f))
            {
                b.addElement(new ba());
            }
            if (vector.contains(n.a))
            {
                b.addElement(new ad());
            }
            if (vector.contains(n.j))
            {
                b.addElement(new cx());
            }
            if (flag1 && flag)
            {
                b.addElement(new bp(hashtable));
            }
        }
    }
}

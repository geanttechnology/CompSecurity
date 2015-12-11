// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package RLSDK:
//            br, r, n, bq, 
//            bj, bk, bi, bo, 
//            bh, ca, cd, v, 
//            x, w, ag, y

public final class bp extends br
{

    private final Vector a = new Vector();

    public bp(Hashtable hashtable)
    {
        Vector vector;
        boolean flag;
        if (hashtable == null)
        {
            vector = null;
        } else
        {
            vector = (Vector)hashtable.get(r.c);
        }
        if (hashtable != null && hashtable.get(r.g) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (vector != null)
        {
            if (vector.contains(n.h) || vector.contains(n.n) || vector.contains(n.g) || vector.contains(n.o))
            {
                a.addElement(new bq(hashtable));
            }
            if (vector.contains(n.c))
            {
                a.addElement(new bj(flag));
            }
            if (vector.contains(n.d))
            {
                a.addElement(new bk());
            }
            if (vector.contains(n.e))
            {
                a.addElement(new bi());
            }
            if (vector.contains(n.i))
            {
                a.addElement(new bo());
            }
            if (vector.contains(n.b))
            {
                a.addElement(new bh());
            }
            if (vector.contains(n.l))
            {
                a.addElement(new ca());
            }
            if (vector.contains(n.m))
            {
                a.addElement(new cd());
            }
        }
        if (a.isEmpty())
        {
            a.addElement(new bq(hashtable));
            a.addElement(new bj());
            a.addElement(new bk());
            a.addElement(new bi());
            a.addElement(new bo());
            a.addElement(new ca());
            a.addElement(new cd());
        }
    }

    public final y a(int i, ag ag, Hashtable hashtable)
        throws v
    {
        int j;
        int k;
        k = a.size();
        j = 0;
_L2:
        Object obj;
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (br)a.elementAt(j);
        obj = ((br) (obj)).a(i, ag, hashtable);
        return ((y) (obj));
        x x1;
        x1;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        throw v.a();
    }

    public final void a()
    {
        int j = a.size();
        for (int i = 0; i < j; i++)
        {
            ((w)a.elementAt(i)).a();
        }

    }
}

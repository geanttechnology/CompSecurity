// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package RLSDK:
//            br, n, bl, bm, 
//            bv, r, bs, v, 
//            x, bu, y, w, 
//            ag

public final class bq extends br
{

    private final Vector a;

    public bq(Hashtable hashtable)
    {
        if (hashtable == null)
        {
            hashtable = null;
        } else
        {
            hashtable = (Vector)hashtable.get(r.c);
        }
        a = new Vector();
        if (hashtable == null) goto _L2; else goto _L1
_L1:
        if (!hashtable.contains(n.h)) goto _L4; else goto _L3
_L3:
        a.addElement(new bl());
_L6:
        if (hashtable.contains(n.g))
        {
            a.addElement(new bm());
        }
        if (hashtable.contains(n.o))
        {
            a.addElement(new bv());
        }
_L2:
        if (a.isEmpty())
        {
            a.addElement(new bl());
            a.addElement(new bm());
            a.addElement(new bv());
        }
        return;
_L4:
        if (hashtable.contains(n.n))
        {
            a.addElement(new bs());
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final y a(int i, ag ag, Hashtable hashtable)
        throws v
    {
        int ai[];
        int j;
        int k;
        ai = bu.a(ag);
        k = a.size();
        j = 0;
_L2:
        Object obj;
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (bu)a.elementAt(j);
        obj = ((bu) (obj)).a(i, ag, ai, hashtable);
        if (n.h.equals(((y) (obj)).c()) && ((y) (obj)).a().charAt(0) == '0')
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (hashtable == null)
        {
            ag = null;
        } else
        {
            ag = (Vector)hashtable.get(r.c);
        }
        if (ag == null || ag.contains(n.n))
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (i != 0 && j != 0)
        {
            return new y(((y) (obj)).a().substring(1), null, ((y) (obj)).b(), n.n);
        } else
        {
            return ((y) (obj));
        }
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

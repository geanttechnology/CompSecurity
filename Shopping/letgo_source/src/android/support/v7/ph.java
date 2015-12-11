// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package android.support.v7:
//            pg, pi, ul

public class ph
    implements Iterable
{

    private final List a = new LinkedList();

    public ph()
    {
    }

    private pg c(ul ul)
    {
        for (Iterator iterator1 = zzp.zzbK().iterator(); iterator1.hasNext();)
        {
            pg pg1 = (pg)iterator1.next();
            if (pg1.a == ul)
            {
                return pg1;
            }
        }

        return null;
    }

    public void a(pg pg1)
    {
        a.add(pg1);
    }

    public boolean a(ul ul)
    {
        ul = c(ul);
        if (ul != null)
        {
            ((pg) (ul)).b.a();
            return true;
        } else
        {
            return false;
        }
    }

    public void b(pg pg1)
    {
        a.remove(pg1);
    }

    public boolean b(ul ul)
    {
        return c(ul) != null;
    }

    public Iterator iterator()
    {
        return a.iterator();
    }
}

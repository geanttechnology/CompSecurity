// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class btk
    implements bnj, bvz
{

    public final dwq a;
    public List b;
    private List c;

    public btk(dwq dwq1)
    {
        a = (dwq)b.a(dwq1);
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
        Iterator iterator = c().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            if (obj instanceof bnj)
            {
                ((bnj)obj).a(bnk1);
            }
        } while (true);
    }

    public final byte[] a()
    {
        return a.c;
    }

    public final bvz b()
    {
        return null;
    }

    public final List c()
    {
        if (c == null)
        {
            c = new ArrayList(a.a.length);
            dwt adwt[] = a.a;
            int j = adwt.length;
            int i = 0;
            while (i < j) 
            {
                Object obj = adwt[i];
                if (((dwt) (obj)).b != null)
                {
                    c.add(new bsd(((dwt) (obj)).b, this));
                } else
                if (((dwt) (obj)).c != null)
                {
                    c.add(new bse(((dwt) (obj)).c, this));
                } else
                if (((dwt) (obj)).f != null)
                {
                    c.add(new bte(((dwt) (obj)).f, this));
                } else
                if (((dwt) (obj)).e != null)
                {
                    c.add(((dwt) (obj)).e);
                } else
                if (((dwt) (obj)).g != null)
                {
                    c.add(((dwt) (obj)).g);
                } else
                if (((dwt) (obj)).d != null)
                {
                    obj = ((dwt) (obj)).d;
                    if (((dxz) (obj)).b != null && ((dxz) (obj)).b.b != null)
                    {
                        c.add(new bty(((dxz) (obj)), this));
                    } else
                    if (((dxz) (obj)).b != null && ((dxz) (obj)).b.a != null)
                    {
                        c.add(new brv(((dxz) (obj)), this));
                    }
                }
                i++;
            }
        }
        return c;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class btn
{

    private final dlg a;
    private List b;
    private List c;

    public btn(dlg dlg1)
    {
        a = dlg1;
    }

    private List a()
    {
        if (b == null)
        {
            if (a.a != null)
            {
                b = new LinkedList();
                dxi adxi[] = a.a;
                int j = adxi.length;
                int i = 0;
                while (i < j) 
                {
                    dxi dxi1 = adxi[i];
                    if (dxi1.b != null)
                    {
                        b.add(new bsq());
                    } else
                    if (dxi1.c != null)
                    {
                        b.add(new bqu());
                    }
                    i++;
                }
            } else
            {
                b = Collections.emptyList();
            }
        }
        return b;
    }

    private List b()
    {
        if (c == null)
        {
            if (a.b != null)
            {
                c = new LinkedList();
                dsb adsb[] = a.b;
                int j = adsb.length;
                int i = 0;
                while (i < j) 
                {
                    dsb dsb1 = adsb[i];
                    if (dsb1.b != null)
                    {
                        c.add(new bsq());
                    } else
                    if (dsb1.c != null)
                    {
                        c.add(new bqu());
                    }
                    i++;
                }
            } else
            {
                c = Collections.emptyList();
            }
        }
        return c;
    }

    public final boolean equals(Object obj)
    {
        int i;
        int j;
        if (obj instanceof btn)
        {
            obj = (btn)obj;
            i = a().size();
            j = b().size();
            break MISSING_BLOCK_LABEL_32;
        }
        do
        {
            return false;
        } while (i != ((btn) (obj)).a().size() || j != ((btn) (obj)).b().size() || !a().equals(((btn) (obj)).a()) || !b().equals(((btn) (obj)).b()));
        return true;
    }
}

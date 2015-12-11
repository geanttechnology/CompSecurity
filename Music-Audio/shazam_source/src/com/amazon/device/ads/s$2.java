// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.device.ads:
//            s, ad, h, cn, 
//            cl, j, k, at, 
//            a, cm, bg, aj, 
//            ac, ay, aa, ab, 
//            ae, ds

final class a
    implements Runnable
{

    final s a;

    public final void run()
    {
        s s1 = a;
        Iterator iterator = s1.a.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (ad)((java.util.Entry)iterator.next()).getValue();
            if (!((ad) (obj)).b.n())
            {
                s1.d.c("Ad object was destroyed before ad fetching could be finalized. Ad fetching has been aborted.", null);
            } else
            {
                ((ad) (obj)).b.f.c(.h);
                boolean flag;
                if (((ad) (obj)).b.o != null && ((ad) (obj)).b.o.h)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    ((ad) (obj)).b.f.b(.j);
                    if (((ad) (obj)).e != null)
                    {
                        ((ad) (obj)).a(((ad) (obj)).e);
                    } else
                    {
                        ((ad) (obj)).a(new k(d, "Unknown error occurred."));
                    }
                } else
                {
                    ((ad) (obj)).b.f.b(.i);
                    obj = ((ad) (obj)).b;
                    if (((h) (obj)).n())
                    {
                        if ((at.c(((h) (obj)).h, 14) || at.c(((h) (obj)).h, 15)) && ((h) (obj)).o.e.contains(a.k))
                        {
                            obj.D = true;
                        } else
                        {
                            obj.D = false;
                        }
                        if (((h) (obj)).k())
                        {
                            Iterator iterator1;
                            if (!((h) (obj)).u())
                            {
                                float f = ((h) (obj)).g.b.g;
                                obj.y = aj.a((int)((float)((h) (obj)).o.g * f), (int)(f * (float)((h) (obj)).o.f), ((h) (obj)).v, ((h) (obj)).u);
                                if (!((h) (obj)).c.b() && ((h) (obj)).y > 1.0D)
                                {
                                    obj.y = 1.0D;
                                }
                                ((h) (obj)).i();
                            } else
                            {
                                obj.y = -1D;
                            }
                            iterator1 = ((h) (obj)).o.iterator();
                            do
                            {
                                if (!iterator1.hasNext())
                                {
                                    break;
                                }
                                Object obj1 = (a)iterator1.next();
                                obj1 = (Set)((h) (obj)).k.a.get(obj1);
                                if (obj1 != null)
                                {
                                    obj1 = ((Set) (obj1)).iterator();
                                    while (((Iterator) (obj1)).hasNext()) 
                                    {
                                        z z = ((aa)((Iterator) (obj1)).next()).a(((h) (obj)).c());
                                        ((h) (obj)).l.a(z);
                                    }
                                }
                            } while (true);
                            if (((h) (obj)).n())
                            {
                                ((h) (obj)).a(ae.c);
                                ds.b(new <init>(((h) (obj)), ((h) (obj)).o.d));
                            }
                        }
                    }
                }
            }
        } while (true);
    }

    (s s1)
    {
        a = s1;
        super();
    }
}

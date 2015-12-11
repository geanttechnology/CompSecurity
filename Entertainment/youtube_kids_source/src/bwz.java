// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.net.Uri;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bwz
{

    public final cic a;
    public final cnb b;

    public bwz(cic cic1, cnb cnb1)
    {
        a = (cic)b.a(cic1);
        b = (cnb)b.a(cnb1);
    }

    public static dla a(aqj aqj1, aqr aqr1)
    {
        boolean flag1 = false;
        dla dla1 = new dla();
        dla1.b = bxa.a(aqr1.b.a);
        dla1.q = bxa.b(aqr1.b.a);
        dla1.c = aqr1.e.toString();
        dla1.d = aqr1.b.b;
        dla1.e = aqr1.b.e;
        dla1.f = aqr1.b.c;
        dla1.g = aqr1.b.d;
        aqo aqo1 = ((aqp) (aqr1)).d;
        dla1.h = new dvr();
        dla1.h.a = aqo1.a;
        dla1.h.b = (aqo1.a + aqo1.b) - 1L;
        aqo1 = aqr1.g;
        dla1.i = new dvr();
        dla1.i.a = aqo1.a;
        dla1.i.b = (aqo1.a + aqo1.b) - 1L;
        dla1.k = aqr1.f;
        long l;
        if (aqr1.a != -1L)
        {
            l = aqr1.a;
        } else
        {
            l = 0L;
        }
        dla1.j = l;
        if (aqj1.a())
        {
            dla1.n = 2;
            aqr1 = aqj1.c.iterator();
            do
            {
                if (!aqr1.hasNext())
                {
                    break;
                }
                Object obj = (aqk)aqr1.next();
                if (obj instanceof cig)
                {
                    obj = ((cig)obj).a;
                    int i = 0;
                    while (i < ((SparseArray) (obj)).size()) 
                    {
                        int j = ((SparseArray) (obj)).keyAt(i);
                        dla1.r = a.a(dla1.r, new int[] {
                            j
                        });
                        i++;
                    }
                }
            } while (true);
        } else
        {
            dla1.n = 0;
        }
        if (aqj1 instanceof cif)
        {
            aqr1 = (cif)aqj1;
            boolean flag = flag1;
            if (aqj1.a == 1)
            {
                flag = flag1;
                if ("main".equals(((cif) (aqr1)).e))
                {
                    flag = true;
                }
            }
            dla1.p = flag;
            if (((cif) (aqr1)).d != null)
            {
                dla1.o = ((cif) (aqr1)).d;
            }
        }
        return dla1;
    }

    public static List a(aql aql1)
    {
        ArrayList arraylist = new ArrayList();
        for (aql1 = ((aqn)aql1.a.get(0)).a.iterator(); aql1.hasNext();)
        {
            Object obj = (aqj)aql1.next();
            if (((aqj) (obj)).a())
            {
                obj = ((aqj) (obj)).c.iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    Object obj1 = (aqk)((Iterator) (obj)).next();
                    if (obj1 instanceof cig)
                    {
                        obj1 = ((cig)obj1).a;
                        int i = 0;
                        while (i < ((SparseArray) (obj1)).size()) 
                        {
                            int j = ((SparseArray) (obj1)).keyAt(i);
                            dov dov1 = new dov();
                            dov1.b = j;
                            dov1.c = (String)((SparseArray) (obj1)).get(j);
                            arraylist.add(dov1);
                            i++;
                        }
                    }
                }
            }
        }

        return arraylist;
    }

    public bww a(bww bww1)
    {
label0:
        {
label1:
            {
                Object obj = bww1.b();
                if (obj == null || bww1.g)
                {
                    break label1;
                }
                boolean flag;
                if (!bww1.c.isEmpty())
                {
                    cnb cnb1 = b;
                    if (cnb1.d() && cnb1.a.getBoolean("medialib_diagnostic_always_fetch_dash_manifest", false))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        break label1;
                    }
                }
                ArrayList arraylist;
                Iterator iterator;
                aqj aqj1;
                Iterator iterator1;
                aqp aqp1;
                try
                {
                    obj = a.a(((Uri) (obj)), bww1.e);
                }
                catch (mp mp1)
                {
                    return bww1;
                }
                if (obj == null || ((aql) (obj)).a == null || ((aql) (obj)).a.isEmpty())
                {
                    flag = false;
                } else
                {
                    aqn aqn1 = (aqn)((aql) (obj)).a.get(0);
                    if (aqn1 == null || aqn1.a == null)
                    {
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                }
                if (flag)
                {
                    break label0;
                }
            }
            return bww1;
        }
        arraylist = new ArrayList();
        for (iterator = ((aqn)((aql) (obj)).a.get(0)).a.iterator(); iterator.hasNext();)
        {
            aqj1 = (aqj)iterator.next();
            iterator1 = aqj1.b.iterator();
            while (iterator1.hasNext()) 
            {
                aqp1 = (aqp)iterator1.next();
                if (aqp1 instanceof aqr)
                {
                    arraylist.add(a(aqj1, (aqr)aqp1));
                }
            }
        }

        return bww1.a(arraylist, a(((aql) (obj))));
    }
}

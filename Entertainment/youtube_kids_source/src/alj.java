// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class alj extends alm
{

    private bhv a;
    private ali b;

    alj(ali ali1, Void void1, bhv bhv1, bhv bhv2)
    {
        b = ali1;
        a = bhv2;
        super(ali1, null, bhv1);
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (List)obj1;
        if (((List) (obj)).isEmpty())
        {
            a.a(null, Collections.emptyList());
            return;
        }
        if (((List) (obj)).size() == 1 && b.e.i() == amj.b)
        {
            obj1 = b.e.n();
            if (((ame) (obj1)).g() && ((cgc)((List) (obj)).get(0)).equals(obj1))
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add(obj1);
                a.a(null, arraylist);
            }
        }
        obj1 = new ArrayList();
        Object obj2 = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj2)).hasNext())
            {
                break;
            }
            cgc cgc1 = (cgc)((Iterator) (obj2)).next();
            if (cgc1.a == cge.a && !b.a.containsKey(cgc1.c))
            {
                ((List) (obj1)).add(cgc1.c);
            }
        } while (true);
        int j = (int)Math.floor(((double)((List) (obj1)).size() - 1.0D) / 6D);
        for (int i = 0; i < j + 1; i++)
        {
            int k = i * 6;
            int l = Math.min(((List) (obj1)).size(), k + 6);
            b.a.putAll(b.b.a(((List) (obj1)).subList(k, l)));
        }

        obj1 = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            obj2 = (cgc)((Iterator) (obj)).next();
            if (((cgc) (obj2)).a == cge.a)
            {
                if (b.a.containsKey(((cgc) (obj2)).c))
                {
                    ((List) (obj1)).add(((cgc) (obj2)).a((cgj)b.a.get(((cgc) (obj2)).c)));
                }
            } else
            {
                ((List) (obj1)).add(obj2);
            }
        } while (true);
        obj = b.c.a(((java.util.Collection) (obj1)));
        obj2 = new ArrayList();
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            cgc cgc2 = (cgc)((Iterator) (obj1)).next();
            if (((Map) (obj)).containsKey(cgc2))
            {
                ((List) (obj2)).add(new alq(cgc2));
            }
        } while (true);
        if (b.e.i() == amj.b && b.e.n().g() && !((List) (obj2)).contains(b.e.n()))
        {
            ((List) (obj2)).add(b.e.n());
        }
        a.a(null, obj2);
    }
}

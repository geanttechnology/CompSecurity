// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            dg, db, di, dj, 
//            dk, fu, dl, df, 
//            de

public class cy
{

    private int a;
    private List b;
    private boolean c;
    private boolean d;

    private cy()
    {
    }


    static int a(cy cy1, int j)
    {
        cy1.a = j;
        return j;
    }

    public static cy a(cy cy1, cy cy2)
    {
        if (cy1 == null || cy2 == null)
        {
            return null;
        }
        Object obj = cy1.a();
        cy2 = cy2.a();
        if (obj == null || ((List) (obj)).isEmpty() || cy2 == null || cy2.isEmpty())
        {
            return null;
        }
        obj = (dg)((List) (obj)).get(0);
        cy2 = (dg)cy2.get(0);
        Object obj2 = ((dg) (obj)).c();
        cy2 = cy2.c();
        if (obj2 == null || cy2 == null)
        {
            return null;
        }
        if (!db.c.equals(((di) (obj2)).a()) || !db.b.equals(cy2.a()) && !db.c.equals(cy2.a()))
        {
            return null;
        }
        Object obj4 = ((di) (obj2)).g();
        Object obj3 = cy2.g();
        if (obj3 == null || ((List) (obj3)).isEmpty())
        {
            return null;
        }
        Object obj1 = new ArrayList(1);
        Object obj5;
        if (obj4 == null || ((List) (obj4)).isEmpty())
        {
            ((List) (obj1)).addAll(((java.util.Collection) (obj3)));
        } else
        {
            obj4 = (dj)((List) (obj4)).get(0);
            obj3 = (dj)((List) (obj3)).get(0);
            obj4 = ((dj) (obj4)).d();
            obj5 = ((dj) (obj3)).d();
            if (obj4 == null || obj5 == null)
            {
                return null;
            }
            obj4 = dk.a(((dk) (obj4)), ((dk) (obj5)));
            if (obj4 == null)
            {
                return null;
            }
            obj5 = new dj.a();
            ((dj.a) (obj5)).a(((dj) (obj3)).a());
            ((dj.a) (obj5)).a(((dj) (obj3)).b());
            ((dj.a) (obj5)).a(((dj) (obj3)).c());
            ((dj.a) (obj5)).a(((dk) (obj4)));
            ((List) (obj1)).add(((dj.a) (obj5)).a());
        }
        obj3 = new di.a();
        ((di.a) (obj3)).a(db.c);
        ((di.a) (obj3)).a(cy2.b());
        ((di.a) (obj3)).a(((di) (obj2)).c());
        obj4 = new ArrayList();
        obj5 = ((di) (obj2)).d();
        if (obj5 != null)
        {
            ((List) (obj4)).addAll(((java.util.Collection) (obj5)));
        }
        obj5 = cy2.d();
        if (obj5 != null)
        {
            for (Iterator iterator = ((List) (obj5)).iterator(); iterator.hasNext();)
            {
                if (((List) (obj4)).contains((String)iterator.next()))
                {
                    return null;
                }
            }

            ((List) (obj4)).addAll(((java.util.Collection) (obj5)));
        }
        ((di.a) (obj3)).a(((List) (obj4)));
        obj4 = new ArrayList();
        obj5 = ((di) (obj2)).e();
        if (obj5 != null)
        {
            ((List) (obj4)).addAll(((java.util.Collection) (obj5)));
        }
        obj5 = cy2.e();
        if (obj5 != null)
        {
            ((List) (obj4)).addAll(((java.util.Collection) (obj5)));
        }
        ((di.a) (obj3)).b(((List) (obj4)));
        obj4 = new ArrayList();
        obj2 = ((di) (obj2)).f();
        if (obj2 != null)
        {
            ((List) (obj4)).addAll(((java.util.Collection) (obj2)));
        }
        obj2 = cy2.f();
        if (obj2 != null)
        {
            ((List) (obj4)).addAll(((java.util.Collection) (obj2)));
        }
        ((di.a) (obj3)).c(((List) (obj4)));
        ((di.a) (obj3)).d(((List) (obj1)));
        obj1 = ((di.a) (obj3)).a();
        obj2 = new dg.a();
        ((dg.a) (obj2)).a(((dg) (obj)).a());
        ((dg.a) (obj2)).a(((dg) (obj)).b());
        ((dg.a) (obj2)).a(((di) (obj1)));
        obj1 = ((dg.a) (obj2)).a();
        obj = new ArrayList(1);
        ((List) (obj)).add(obj1);
        obj1 = new a();
        ((a) (obj1)).a(((List) (obj)));
        ((a) (obj1)).a(cy1.b());
        ((a) (obj1)).a(db.b.equals(cy2.a()));
        return ((a) (obj1)).b();
    }

    static List a(cy cy1, List list)
    {
        cy1.b = list;
        return list;
    }

    static boolean a(cy cy1, boolean flag)
    {
        cy1.c = flag;
        return flag;
    }

    static boolean b(cy cy1, boolean flag)
    {
        cy1.d = flag;
        return flag;
    }

    public List a()
    {
        return b;
    }

    public List a(de de)
    {
        Object obj = a();
        if (obj != null && !((List) (obj)).isEmpty())
        {
            obj = ((dg)((List) (obj)).get(0)).c();
            if (obj != null)
            {
                obj = ((di) (obj)).g();
                if (obj != null && !((List) (obj)).isEmpty())
                {
                    obj = ((dj)((List) (obj)).get(0)).d();
                    if (obj != null)
                    {
                        obj = ((dk) (obj)).c();
                        if (obj != null)
                        {
                            return ((fu) (obj)).a(de);
                        }
                    }
                }
            }
        }
        return null;
    }

    public List a(df df1)
    {
        ArrayList arraylist = new ArrayList();
        Object obj = a();
        if (obj != null && !((List) (obj)).isEmpty())
        {
            obj = ((dg)((List) (obj)).get(0)).c();
            if (obj != null)
            {
                obj = ((di) (obj)).g();
                if (obj != null && !((List) (obj)).isEmpty())
                {
                    obj = ((dj)((List) (obj)).get(0)).d();
                    if (obj != null)
                    {
                        obj = ((dk) (obj)).d();
                        if (obj != null)
                        {
                            arraylist.addAll(((fu) (obj)).a(df1));
                        }
                    }
                }
            }
        }
        return arraylist;
    }

    public int b()
    {
        return a;
    }

    public boolean c()
    {
        return c;
    }

    public boolean d()
    {
        return d;
    }

    public String e()
    {
        Object obj = a();
        if (obj != null && !((List) (obj)).isEmpty())
        {
            obj = ((dg)((List) (obj)).get(0)).c();
            if (obj != null)
            {
                obj = ((di) (obj)).d();
                if (obj != null && !((List) (obj)).isEmpty())
                {
                    return (String)((List) (obj)).get(((List) (obj)).size() - 1);
                }
            }
        }
        return null;
    }

    public String f()
    {
        Object obj = a();
        if (obj != null && !((List) (obj)).isEmpty())
        {
            obj = ((dg)((List) (obj)).get(0)).c();
            if (obj != null)
            {
                obj = ((di) (obj)).g();
                if (obj != null && !((List) (obj)).isEmpty())
                {
                    obj = ((dj)((List) (obj)).get(0)).d();
                    if (obj != null)
                    {
                        obj = ((dk) (obj)).e();
                        if (obj != null && ((dl) (obj)).a() != null)
                        {
                            return ((dl) (obj)).a();
                        }
                    }
                }
            }
        }
        return null;
    }

    public List g()
    {
        Object obj = a();
        if (obj != null && !((List) (obj)).isEmpty())
        {
            obj = ((dg)((List) (obj)).get(0)).c();
            if (obj != null)
            {
                return ((di) (obj)).f();
            }
        }
        return null;
    }

    public List h()
    {
        Object obj = a();
        if (obj != null && !((List) (obj)).isEmpty())
        {
            obj = ((dg)((List) (obj)).get(0)).c();
            if (obj != null)
            {
                return ((di) (obj)).e();
            }
        }
        return null;
    }

    public String i()
    {
        List list = a(df.b);
        if (list != null && list.size() > 0)
        {
            return (String)list.get(0);
        } else
        {
            return null;
        }
    }

    private class a
    {

        private cy a;

        public a a()
        {
            cy.b(a, true);
            return this;
        }

        public a a(int j)
        {
            cy.a(a, j);
            return this;
        }

        public a a(List list)
        {
            cy.a(a, list);
            return this;
        }

        public a a(boolean flag)
        {
            cy.a(a, flag);
            return this;
        }

        public cy b()
        {
            return a;
        }

        public a()
        {
            a = new cy();
        }
    }

}

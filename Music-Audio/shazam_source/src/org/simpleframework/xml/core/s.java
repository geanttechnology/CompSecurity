// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Iterator;
import org.simpleframework.xml.b.f;
import org.simpleframework.xml.c.ag;
import org.simpleframework.xml.c.o;
import org.simpleframework.xml.c.t;
import org.simpleframework.xml.c.y;

// Referenced classes of package org.simpleframework.xml.core:
//            ak, cr, dg, o, 
//            dt, bx, am, ex, 
//            ai, ew, af, i, 
//            bm, au, an, dy, 
//            cb, e, ep, bq, 
//            dx, bt

final class s
    implements ak
{

    private final cr a;
    private final dg b;
    private final am c;
    private final dt d;
    private final ai e;
    private final f f;

    public s(ai ai1, f f1)
    {
        this(ai1, f1, null);
    }

    public s(ai ai1, f f1, Class class1)
    {
        a = new cr(ai1, f1, class1);
        b = new dg(ai1, f1);
        c = new org.simpleframework.xml.core.o();
        d = new dt();
        e = ai1;
        f = f1;
    }

    private Object a(o o1, Object obj, bx bx1)
    {
        Object obj1 = bx1.getConverter(e);
        if (!bx1.isCollection()) goto _L2; else goto _L1
_L1:
        ex ex1;
        af af1;
        ex1 = c.a(bx1);
        af1 = bx1.getContact();
        if (ex1 == null) goto _L4; else goto _L3
_L3:
        obj1 = ((ak) (obj1)).a(o1, ex1.a);
_L6:
        if (obj1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        o1 = o1.b();
        obj = e.a(f, obj);
        if (bx1.isRequired() && d.a)
        {
            throw new ew("Empty value for %s in %s at %s", new Object[] {
                bx1, obj, o1
            });
        }
        break MISSING_BLOCK_LABEL_207;
_L4:
        if (obj != null)
        {
            Object obj2 = af1.a(obj);
            if (obj2 != null)
            {
                obj1 = ((ak) (obj1)).a(o1, obj2);
                continue; /* Loop/switch isn't completed */
            }
        }
_L2:
        obj1 = ((ak) (obj1)).a(o1);
        if (true) goto _L6; else goto _L5
_L5:
        if (obj1 != bx1.getEmpty(e))
        {
            c.a(bx1, obj1);
        }
        return obj1;
    }

    private Object a(o o1, Object obj, i j)
    {
        Object obj1 = obj;
        if (obj != null)
        {
            org.simpleframework.xml.c.aj aj = o1.b();
            o1 = ((o) (obj));
            if (j.c != null)
            {
                o1 = ((o) (j.c.a(j.d, obj)));
            }
            obj = f.C_();
            j = o1.getClass();
            obj1 = o1;
            if (!((Class) (obj)).isAssignableFrom(j))
            {
                throw new au("Type %s does not match %s at %s", new Object[] {
                    j, obj, aj
                });
            }
        }
        return obj1;
    }

    private void a(ag ag1, Object obj, bx bx1)
    {
        if (obj != null)
        {
            bx1.getDecorator().a(ag1.a(bx1.getName(), a.a(obj)));
        }
    }

    private void a(ag ag1, Object obj, dy dy1)
    {
        Object obj2 = ag1.h();
        Object obj1 = dy1.a();
        if (obj1 != null)
        {
            obj2 = ((t) (obj2)).b(((String) (obj1)));
            if (obj2 == null)
            {
                throw new au("Namespace prefix '%s' in %s is not in scope", new Object[] {
                    obj1, f
                });
            }
            ag1.d(((String) (obj2)));
        }
        bx bx2;
        for (Iterator iterator = dy1.c().iterator(); iterator.hasNext(); a(ag1, obj1, bx2))
        {
            bx2 = (bx)iterator.next();
            Object obj3 = bx2.getContact().a(obj);
            Class class2 = e.a(f, obj);
            obj1 = obj3;
            if (obj3 == null)
            {
                obj1 = bx2.getEmpty(e);
            }
            if (obj1 == null && bx2.isRequired())
            {
                throw new e("Value for %s is null in %s", new Object[] {
                    bx2, class2
                });
            }
        }

        Iterator iterator1 = dy1.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            obj1 = (String)iterator1.next();
            dy dy2 = dy1.d(((String) (obj1)));
            if (dy2 != null)
            {
                a(ag1.c(((String) (obj1))), obj, dy2);
            } else
            {
                bx bx3 = dy1.c(dy1.a(((String) (obj1))));
                Object obj4 = e.a(f, obj);
                if (c.a(bx3) == null)
                {
                    if (bx3 == null)
                    {
                        throw new au("Element '%s' not defined in %s", new Object[] {
                            obj1, obj4
                        });
                    }
                    obj4 = bx3.getContact().a(obj);
                    obj1 = e.a(f, obj);
                    if (obj4 == null && bx3.isRequired())
                    {
                        throw new au("Value for %s is null in %s", new Object[] {
                            bx3, obj1
                        });
                    }
                    obj1 = obj4;
                    if (obj4 != null)
                    {
                        obj1 = obj4.getClass();
                        i j = e.d(((Class) (obj1)));
                        obj1 = obj4;
                        if (j.b != null)
                        {
                            obj1 = j.b.a(j.d, obj4);
                        }
                    }
                    if (obj1 != null && obj1 != null)
                    {
                        Object obj5 = obj1.getClass();
                        bx bx1 = bx3.getLabel(((Class) (obj5)));
                        Object obj6 = bx1.getName();
                        obj5 = bx3.getType(((Class) (obj5)));
                        obj6 = ag1.c(((String) (obj6)));
                        if (!bx1.isInline())
                        {
                            Object obj7 = ((f) (obj5)).C_();
                            obj7 = e.f(((Class) (obj7)));
                            bx1.getDecorator().a(((ag) (obj6)), ((an) (obj7)));
                        }
                        if (bx1.isInline() || !a.a(((f) (obj5)), obj1, ((ag) (obj6))))
                        {
                            ak ak1 = bx1.getConverter(e);
                            ((ag) (obj6)).a(bx1.isData());
                            ak1.a(((ag) (obj6)), obj1);
                        }
                    }
                    c.a(bx3, obj1);
                }
            }
        } while (true);
        obj1 = dy1.b();
        if (obj1 != null)
        {
            dy1 = ((dy) (((bx) (obj1)).getContact().a(obj)));
            Class class1 = e.a(f, obj);
            obj = dy1;
            if (dy1 == null)
            {
                obj = ((bx) (obj1)).getEmpty(e);
            }
            if (obj == null && ((bx) (obj1)).isRequired())
            {
                throw new ep("Value for %s is null in %s", new Object[] {
                    obj1, class1
                });
            }
            if (obj != null && !((bx) (obj1)).isTextList())
            {
                obj = a.a(obj);
                ag1.a(((bx) (obj1)).isData());
                ag1.a(((String) (obj)));
            }
        }
    }

    private void a(o o1, cb cb1, Object obj)
    {
        obj = e.a(f, obj);
        o1 = o1.b();
        cb1 = cb1.iterator();
        do
        {
            if (!cb1.hasNext())
            {
                break;
            }
            bx bx1 = (bx)cb1.next();
            if (bx1.isRequired() && d.a)
            {
                throw new ew("Unable to satisfy %s for %s at %s", new Object[] {
                    bx1, obj, o1
                });
            }
            Object obj1 = bx1.getEmpty(e);
            if (obj1 != null)
            {
                c.a(bx1, obj1);
            }
        } while (true);
    }

    private void d(o o1, Object obj, dy dy1)
    {
        c(o1, obj, dy1);
        a(o1, obj, dy1);
        b(o1, obj, dy1);
    }

    public final Object a(o o1)
    {
        bq bq1 = a.a(o1);
        Object obj = bq1.b();
        if (bq1.c())
        {
            o1 = ((o) (bq1.a()));
        } else
        if (e.a(((Class) (obj))))
        {
            Class class1 = bq1.b();
            obj = b.a(o1, class1);
            o1 = ((o) (obj));
            if (class1 != null)
            {
                bq1.a(obj);
                return obj;
            }
        } else
        {
            obj = e.g(((Class) (obj)));
            i j = ((dx) (obj)).e();
    /* block-local class not found */
    class a {}

    /* block-local class not found */
    class b {}

            if (((dx) (obj)).b().a())
            {
                obj = new a(c, ((dx) (obj)), bq1);
            } else
            {
                obj = new b(this, c, ((dx) (obj)), bq1, (byte)0);
            }
            obj = ((a) (obj)).a(o1);
            j.b(obj);
            j.a(obj);
            bq1.a(obj);
            return a(o1, obj, j);
        }
        return o1;
    }

    public final Object a(o o1, Object obj)
    {
        Object obj1 = obj.getClass();
        obj1 = e.g(((Class) (obj1)));
        i j = ((dx) (obj1)).e();
        dy dy1 = ((dx) (obj1)).f();
        a(o1, obj, ((dx) (obj1)));
        d(o1, obj, dy1);
        c.c(obj);
        j.b(obj);
        j.a(obj);
        return a(o1, obj, j);
    }

    public final void a(ag ag1, Object obj)
    {
        Object obj1;
        Object obj3;
        obj1 = obj.getClass();
        obj3 = e.g(((Class) (obj1)));
        obj1 = ((dx) (obj3)).e();
        if (!((dx) (obj3)).a()) goto _L2; else goto _L1
_L1:
        b.a(ag1, obj);
_L4:
        ((i) (obj1)).c(obj);
        return;
_L2:
        dy dy1;
        Object obj2;
        if (((i) (obj1)).a != null)
        {
            ((i) (obj1)).a.a(((i) (obj1)).d, obj);
        }
        dy1 = ((dx) (obj3)).f();
        obj2 = ((dx) (obj3)).d();
        obj3 = ((dx) (obj3)).c();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        obj2 = Double.valueOf(((org.simpleframework.xml.s) (obj2)).b());
        if (!d.a(obj2, Double.valueOf(1.0D)) || ((bx) (obj3)).isRequired())
        {
            a(ag1, obj2, ((bx) (obj3)));
        }
        a(ag1, obj, dy1);
        if (true) goto _L4; else goto _L3
_L3:
        ag1;
        ((i) (obj1)).c(obj);
        throw ag1;
    }

    final void a(o o1, Object obj, dx dx1)
    {
        Class class1;
label0:
        {
            dx1 = dx1.c();
            class1 = f.C_();
            if (dx1 != null)
            {
                String s1 = dx1.getName();
                o1 = (o)o1.f().b(s1);
                if (o1 == null)
                {
                    break label0;
                }
                o1 = ((o) (a(o1, obj, ((bx) (dx1)))));
                obj = f.C_();
                if (o1 != null)
                {
                    double d1 = e.e(((Class) (obj))).b();
                    if (!o1.equals(d))
                    {
                        d.a(Double.valueOf(d1), o1);
                    }
                }
            }
            return;
        }
        o1 = e.e(class1);
        obj = Double.valueOf(1.0D);
        double d2 = o1.b();
        c.a(dx1, obj);
        d.a(Double.valueOf(d2), obj);
    }

    final void a(o o1, Object obj, dy dy1)
    {
        Object obj1 = o1.f();
        cb cb1 = dy1.c();
        obj1 = ((y) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            Object obj2 = o1.a((String)((Iterator) (obj1)).next());
            if (obj2 != null)
            {
                String s1 = dy1.b(((o) (obj2)).c());
                Object obj3 = cb1.a(s1);
                if (obj3 == null)
                {
                    obj2 = ((o) (obj2)).b();
                    obj3 = e.a(f, obj);
                    if (cb1.a(e) && d.a)
                    {
                        throw new e("Attribute '%s' does not have a match in %s at %s", new Object[] {
                            s1, obj3, obj2
                        });
                    }
                } else
                {
                    a(((o) (obj2)), obj, ((bx) (obj3)));
                }
            }
        } while (true);
        a(o1, cb1, obj);
    }

    final void b(o o1, Object obj, dy dy1)
    {
        cb cb1 = dy1.d();
        Object obj1 = o1.g();
        while (obj1 != null) 
        {
            dy dy2 = dy1.d(((o) (obj1)).c());
            if (dy2 != null)
            {
                d(((o) (obj1)), obj, dy2);
            } else
            {
                String s1 = dy1.a(((o) (obj1)).c());
                Object obj2 = cb1.a(s1);
                if (obj2 == null)
                {
                    obj2 = c.a(s1);
                }
                if (obj2 == null)
                {
                    obj2 = ((o) (obj1)).b();
                    Class class1 = e.a(f, obj);
                    if (cb1.a(e) && d.a)
                    {
                        throw new au("Element '%s' does not have a match in %s at %s", new Object[] {
                            s1, class1, obj2
                        });
                    }
                    ((o) (obj1)).h();
                } else
                {
                    obj1 = a(((o) (obj1)), obj, ((bx) (obj2)));
                    String as[] = ((bx) (obj2)).getPaths();
                    int k = as.length;
                    for (int j = 0; j < k; j++)
                    {
                        cb1.a(as[j]);
                    }

                    if (((bx) (obj2)).isInline())
                    {
                        c.a(((bx) (obj2)), obj1);
                    }
                }
            }
            obj1 = o1.g();
        }
        a(o1, cb1, obj);
    }

    final void c(o o1, Object obj, dy dy1)
    {
        dy1 = dy1.b();
        if (dy1 != null)
        {
            a(o1, obj, dy1);
        }
    }
}

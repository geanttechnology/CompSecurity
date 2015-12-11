// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.a;
import org.simpleframework.xml.c;
import org.simpleframework.xml.d;
import org.simpleframework.xml.e;
import org.simpleframework.xml.f;
import org.simpleframework.xml.g;
import org.simpleframework.xml.h;
import org.simpleframework.xml.i;
import org.simpleframework.xml.j;
import org.simpleframework.xml.q;
import org.simpleframework.xml.r;
import org.simpleframework.xml.s;

// Referenced classes of package org.simpleframework.xml.core:
//            ag, ci, aq, ej, 
//            af, cd, ce, ck, 
//            dp, a, ch, cf

final class cj extends ag
{

    private final ci a;
    private final ej b;
    private final a c;
    private final a d;
    private final aq e;

    public cj(aq aq1, ej ej1)
    {
    /* block-local class not found */
    class a {}

        Object obj;
        a = new ci(aq1, ej1);
        c = new a((byte)0);
        d = new a((byte)0);
        b = ej1;
        e = aq1;
        obj = aq1.k();
        ej1 = aq1.j();
        Object obj4 = aq1.e();
        if (obj4 != null)
        {
            for (obj = b.c(((Class) (obj4)), ((c) (obj))).iterator(); ((Iterator) (obj)).hasNext(); b(((ch) (obj4)), d))
            {
                Object obj6 = (cd)(af)((Iterator) (obj)).next();
                obj4 = ((cd) (obj6)).b;
                obj6 = ((cd) (obj6)).a;
                if (obj6 != null)
                {
                    b(((ch) (obj6)), c);
                }
            }

        }
        obj = aq1.n();
        if (ej1 != c.b) goto _L2; else goto _L1
_L1:
        obj = ((List) (obj)).iterator();
_L4:
        if (((Iterator) (obj)).hasNext())
        {
            ej1 = (ce)((Iterator) (obj)).next();
            Annotation aannotation[] = ((ce) (ej1)).a;
            Method method = ((ce) (ej1)).b;
            if (ci.b(method) != null)
            {
                ci ci1 = a;
                ej1 = org.simpleframework.xml.core.ci.a(method);
                ck ck1;
                Class class1;
                if (ej1 == org.simpleframework.xml.core.ck.c)
                {
                    ej1 = org.simpleframework.xml.core.dp.c(method);
                } else
                if (ej1 == org.simpleframework.xml.core.ck.a)
                {
                    ej1 = org.simpleframework.xml.core.dp.a(method);
                } else
                if (ej1 == ck.b)
                {
                    ej1 = org.simpleframework.xml.core.dp.a(method);
                } else
                {
                    ej1 = null;
                }
                class1 = ci.b(method);
                if (class1 != null)
                {
                    ej1 = ci1.a.a(class1, ej1);
                } else
                {
                    ej1 = null;
                }
                if (ej1 != null)
                {
                    ej1 = org.simpleframework.xml.core.ci.a(method, ej1, aannotation);
                } else
                {
                    ej1 = null;
                }
                ck1 = ej1.g();
                if (ck1 == org.simpleframework.xml.core.ck.a)
                {
                    a(ej1, d);
                }
                if (ck1 == ck.b)
                {
                    a(ej1, d);
                }
                if (ck1 == org.simpleframework.xml.core.ck.c)
                {
                    a(ej1, c);
                }
            }
            continue; /* Loop/switch isn't completed */
        }
_L2:
        for (aq1 = aq1.n().iterator(); aq1.hasNext();)
        {
            Object obj1 = (ce)aq1.next();
            ej1 = ((ce) (obj1)).a;
            obj1 = ((ce) (obj1)).b;
            int l = ej1.length;
            int k = 0;
            while (k < l) 
            {
                Object obj5 = ej1[k];
                if (obj5 instanceof a)
                {
                    a(((Method) (obj1)), ((Annotation) (obj5)), ej1);
                }
                if (obj5 instanceof j)
                {
                    a(((Method) (obj1)), ((Annotation) (obj5)), ej1);
                }
                if (obj5 instanceof g)
                {
                    a(((Method) (obj1)), ((Annotation) (obj5)), ej1);
                }
                if (obj5 instanceof i)
                {
                    a(((Method) (obj1)), ((Annotation) (obj5)), ej1);
                }
                if (obj5 instanceof f)
                {
                    a(((Method) (obj1)), ((Annotation) (obj5)), ej1);
                }
                if (obj5 instanceof e)
                {
                    a(((Method) (obj1)), ((Annotation) (obj5)), ej1);
                }
                if (obj5 instanceof h)
                {
                    a(((Method) (obj1)), ((Annotation) (obj5)), ej1);
                }
                if (obj5 instanceof d)
                {
                    a(((Method) (obj1)), ((Annotation) (obj5)), ej1);
                }
                if (obj5 instanceof s)
                {
                    a(((Method) (obj1)), ((Annotation) (obj5)), ej1);
                }
                if (obj5 instanceof q)
                {
                    a(((Method) (obj1)), ((Annotation) (obj5)), ej1);
                }
                if (obj5 instanceof r)
                {
                    obj5 = org.simpleframework.xml.core.ci.a(((Method) (obj1)), ((Annotation) (obj5)), ej1);
                    ck ck2 = ((ch) (obj5)).g();
                    if (ck2 == org.simpleframework.xml.core.ck.a)
                    {
                        c(((ch) (obj5)), d);
                    }
                    if (ck2 == ck.b)
                    {
                        c(((ch) (obj5)), d);
                    }
                    if (ck2 == org.simpleframework.xml.core.ck.c)
                    {
                        c(((ch) (obj5)), c);
                    }
                }
                k++;
            }
        }

        aq1 = d.iterator();
        do
        {
            if (!aq1.hasNext())
            {
                break;
            }
            Object obj2 = (String)aq1.next();
            ej1 = (ch)d.get(obj2);
            if (ej1 != null)
            {
                obj2 = c.a(((String) (obj2)));
                if (obj2 != null)
                {
                    Object obj7 = ej1.f();
                    String s1 = ej1.a();
                    if (!((ch) (obj2)).f().equals(obj7))
                    {
                        throw new cf("Annotations do not match for '%s' in %s", new Object[] {
                            s1, e
                        });
                    }
                    obj7 = ej1.b();
                    if (obj7 != ((ch) (obj2)).b())
                    {
                        throw new cf("Method types do not match for %s in %s", new Object[] {
                            s1, obj7
                        });
                    }
                    add(new cd(ej1, ((ch) (obj2))));
                } else
                {
                    add(new cd(ej1));
                }
            }
        } while (true);
        for (aq1 = c.iterator(); aq1.hasNext();)
        {
            Object obj3 = (String)aq1.next();
            ej1 = (ch)c.get(obj3);
            if (ej1 != null)
            {
                obj3 = d.a(((String) (obj3)));
                ej1 = ej1.h();
                if (obj3 == null)
                {
                    throw new cf("No matching get method for %s in %s", new Object[] {
                        ej1, e
                    });
                }
            }
        }

        return;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(Method method, Annotation annotation, Annotation aannotation[])
    {
        method = org.simpleframework.xml.core.ci.a(method, annotation, aannotation);
        annotation = method.g();
        if (annotation == org.simpleframework.xml.core.ck.a)
        {
            a(((ch) (method)), d);
        }
        if (annotation == ck.b)
        {
            a(((ch) (method)), d);
        }
        if (annotation == org.simpleframework.xml.core.ck.c)
        {
            a(((ch) (method)), c);
        }
    }

    private static void a(ch ch1, a a1)
    {
        String s1 = ch1.a();
        if (s1 != null)
        {
            a1.put(s1, ch1);
        }
    }

    private static void b(ch ch1, a a1)
    {
        String s1 = ch1.a();
        ch ch3 = (ch)a1.remove(s1);
        ch ch2 = ch1;
        if (ch3 != null)
        {
            boolean flag;
            if (ch1.f() instanceof q)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ch2 = ch1;
            if (flag)
            {
                ch2 = ch3;
            }
        }
        a1.put(s1, ch2);
    }

    private static void c(ch ch1, a a1)
    {
        ch1 = ch1.a();
        if (ch1 != null)
        {
            a1.remove(ch1);
        }
    }
}

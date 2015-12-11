// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.b.d;
import com.google.b.b.h;
import com.google.b.c.a;
import com.google.b.e;
import com.google.b.f;
import com.google.b.u;
import com.google.b.x;
import com.google.b.y;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.b.b.a:
//            d, l

public final class i
    implements y
{
    public static final class a extends x
    {

        private final h a;
        private final Map b;

        public final Object a(com.google.b.d.a a1)
        {
            Object obj;
            if (a1.f() == com.google.b.d.b.i)
            {
                a1.k();
                return null;
            }
            obj = a.a();
            a1.c();
_L1:
            Object obj1;
            if (!a1.e())
            {
                break MISSING_BLOCK_LABEL_103;
            }
            obj1 = a1.h();
            obj1 = (b)b.get(obj1);
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            if (((b) (obj1)).i)
            {
                break MISSING_BLOCK_LABEL_84;
            }
            a1.o();
              goto _L1
            try
            {
                ((b) (obj1)).a(a1, obj);
            }
            // Misplaced declaration of an exception variable
            catch (com.google.b.d.a a1)
            {
                throw new u(a1);
            }
            // Misplaced declaration of an exception variable
            catch (com.google.b.d.a a1)
            {
                throw new AssertionError(a1);
            }
              goto _L1
            a1.d();
            return obj;
        }

        public final void a(com.google.b.d.c c1, Object obj)
        {
            if (obj == null)
            {
                c1.f();
                return;
            }
            c1.d();
            try
            {
                Iterator iterator = b.values().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    b b1 = (b)iterator.next();
                    if (b1.a(obj))
                    {
                        c1.a(b1.g);
                        b1.a(c1, obj);
                    }
                } while (true);
            }
            // Misplaced declaration of an exception variable
            catch (com.google.b.d.c c1)
            {
                throw new AssertionError();
            }
            c1.e();
        }

        private a(h h1, Map map)
        {
            a = h1;
            b = map;
        }

        a(h h1, Map map, byte byte0)
        {
            this(h1, map);
        }
    }

    static abstract class b
    {

        final String g;
        final boolean h;
        final boolean i;

        abstract void a(com.google.b.d.a a1, Object obj);

        abstract void a(com.google.b.d.c c1, Object obj);

        abstract boolean a(Object obj);

        protected b(String s, boolean flag, boolean flag1)
        {
            g = s;
            h = flag;
            i = flag1;
        }
    }


    private final com.google.b.b.c a;
    private final e b;
    private final d c;

    public i(com.google.b.b.c c1, e e1, d d1)
    {
        a = c1;
        b = e1;
        c = d1;
    }

    static x a(i j, f f1, Field field, com.google.b.c.a a1)
    {
        field = (com.google.b.a.b)field.getAnnotation(com/google/b/a/b);
        if (field != null)
        {
            j = com.google.b.b.a.d.a(j.a, f1, a1, field);
            if (j != null)
            {
                return j;
            }
        }
        return f1.a(a1);
    }

    private Map a(f f1, com.google.b.c.a a1, Class class1)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        if (class1.isInterface())
        {
            return linkedhashmap;
        }
        java.lang.reflect.Type type = a1.b;
        for (; class1 != java/lang/Object; class1 = a1.a)
        {
            Field afield[] = class1.getDeclaredFields();
            int k = afield.length;
            Object obj;
            c c1;
            for (int j = 0; j < k; j++)
            {
                Field field = afield[j];
                boolean flag = a(field, true);
                boolean flag1 = a(field, false);
                if (!flag && !flag1)
                {
                    continue;
                }
                field.setAccessible(true);
                Object obj1 = com.google.b.b.b.a(a1.b, class1, field.getGenericType());
                obj = b;
                c1 = (c)field.getAnnotation(com/google/b/a/c);
                if (c1 == null)
                {
                    obj = ((e) (obj)).a(field);
                } else
                {
                    obj = c1.a();
                }
                obj1 = com.google.b.c.a.a(((java.lang.reflect.Type) (obj1)));
                obj = new b(((String) (obj)), flag, flag1, f1, field, ((com.google.b.c.a) (obj1)), com.google.b.b.i.a(((com.google.b.c.a) (obj1)).a)) {

                    final x a;
                    final f b;
                    final Field c;
                    final com.google.b.c.a d;
                    final boolean e;
                    final i f;

                    final void a(com.google.b.d.a a2, Object obj2)
                    {
                        a2 = ((com.google.b.d.a) (a.a(a2)));
                        if (a2 != null || !e)
                        {
                            c.set(obj2, a2);
                        }
                    }

                    final void a(com.google.b.d.c c2, Object obj2)
                    {
                        obj2 = c.get(obj2);
                        (new l(b, a, d.b)).a(c2, obj2);
                    }

                    public final boolean a(Object obj2)
                    {
                        while (!h || c.get(obj2) == obj2) 
                        {
                            return false;
                        }
                        return true;
                    }

            
            {
                f = i.this;
                b = f1;
                c = field;
                d = a1;
                e = flag2;
                super(s, flag, flag1);
                a = com.google.b.b.a.i.a(f, b, c, d);
            }
                };
                obj = (b)linkedhashmap.put(((b) (obj)).g, obj);
                if (obj != null)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append(type).append(" declares multiple JSON fields named ").append(((b) (obj)).g).toString());
                }
            }

            a1 = com.google.b.c.a.a(com.google.b.b.b.a(a1.b, class1, class1.getGenericSuperclass()));
        }

        return linkedhashmap;
    }

    private boolean a(Field field, boolean flag)
    {
        Object obj = c;
        if (((d) (obj)).a(field.getType(), flag)) goto _L2; else goto _L1
_L1:
        if ((((d) (obj)).c & field.getModifiers()) == 0) goto _L4; else goto _L3
_L3:
        boolean flag1 = true;
_L5:
        if (!flag1)
        {
            return true;
        }
        break; /* Loop/switch isn't completed */
_L4:
label0:
        {
            if (((d) (obj)).b != -1D && !((d) (obj)).a((com.google.b.a.d)field.getAnnotation(com/google/b/a/d), (com.google.b.a.e)field.getAnnotation(com/google/b/a/e)))
            {
                flag1 = true;
                continue; /* Loop/switch isn't completed */
            }
            if (field.isSynthetic())
            {
                flag1 = true;
                continue; /* Loop/switch isn't completed */
            }
            if (((d) (obj)).e)
            {
                com.google.b.a.a a1 = (com.google.b.a.a)field.getAnnotation(com/google/b/a/a);
                if (a1 == null || (flag ? !a1.a() : !a1.b()))
                {
                    flag1 = true;
                    continue; /* Loop/switch isn't completed */
                }
            }
            if (!((d) (obj)).d && d.b(field.getType()))
            {
                flag1 = true;
                continue; /* Loop/switch isn't completed */
            }
            if (d.a(field.getType()))
            {
                flag1 = true;
                continue; /* Loop/switch isn't completed */
            }
            if (flag)
            {
                obj = ((d) (obj)).f;
            } else
            {
                obj = ((d) (obj)).g;
            }
            if (((List) (obj)).isEmpty())
            {
                break label0;
            }
            field = new com.google.b.c(field);
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!((com.google.b.b)((Iterator) (obj)).next()).shouldSkipField(field));
            flag1 = true;
            continue; /* Loop/switch isn't completed */
        }
        flag1 = false;
        if (true) goto _L5; else goto _L2
_L2:
        return false;
    }

    public final x a(f f1, com.google.b.c.a a1)
    {
        Class class1 = a1.a;
        if (!java/lang/Object.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            return new a(a.a(a1), a(f1, a1, class1), (byte)0);
        }
    }
}

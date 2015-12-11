// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            is, iu, jm, ia, 
//            jw, jg, iv, hz, 
//            iz, ja, jb, ir, 
//            ju, jx, jz

public final class jr
    implements is
{

    private final ja a;
    private final hz b;
    private final jb c;

    public jr(ja ja1, hz hz1, jb jb1)
    {
        a = ja1;
        b = hz1;
        c = jb1;
    }

    private ir a(ia ia1, Field field, jw jw1)
    {
        field = (iu)field.getAnnotation(com/flurry/sdk/iu);
        if (field != null)
        {
            field = jm.a(a, ia1, jw1, field);
            if (field != null)
            {
                return field;
            }
        }
        return ia1.a(jw1);
    }

    static ir a(jr jr1, ia ia1, Field field, jw jw1)
    {
        return jr1.a(ia1, field, jw1);
    }

    private b a(ia ia1, Field field, String s, jw jw1, boolean flag, boolean flag1)
    {
        return new b(s, flag, flag1, ia1, field, jw1, jg.a(jw1.a())) {
            private class b
            {

                final String g;
                final boolean h;
                final boolean i;

                abstract void a(jx jx, Object obj);

                abstract void a(jz jz, Object obj);

                protected b(String s, boolean flag, boolean flag1)
                {
                    g = s;
                    h = flag;
                    i = flag1;
                }
            }


            final ir a;
            final ia b;
            final Field c;
            final jw d;
            final boolean e;
            final jr f;

            void a(jx jx, Object obj)
            {
                jx = ((jx) (a.b(jx)));
                if (jx != null || !e)
                {
                    c.set(obj, jx);
                }
            }

            void a(jz jz, Object obj)
            {
                obj = c.get(obj);
                (new ju(b, a, d.b())).a(jz, obj);
            }

            
            {
                f = jr.this;
                b = ia1;
                c = field;
                d = jw1;
                e = flag2;
                super(s, flag, flag1);
                a = jr.a(f, b, c, d);
            }
        };
    }

    private String a(Field field)
    {
        iv iv1 = (iv)field.getAnnotation(com/flurry/sdk/iv);
        if (iv1 == null)
        {
            return b.a(field);
        } else
        {
            return iv1.a();
        }
    }

    private Map a(ia ia1, jw jw1, Class class1)
    {
        LinkedHashMap linkedhashmap;
        java.lang.reflect.Type type;
        linkedhashmap = new LinkedHashMap();
        if (class1.isInterface())
        {
            return linkedhashmap;
        }
        type = jw1.b();
_L6:
        Field afield[];
        int i;
        int j;
        if (class1 == java/lang/Object)
        {
            break; /* Loop/switch isn't completed */
        }
        afield = class1.getDeclaredFields();
        j = afield.length;
        i = 0;
_L2:
        Object obj;
        boolean flag;
        boolean flag1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        obj = afield[i];
        flag = a(((Field) (obj)), true);
        flag1 = a(((Field) (obj)), false);
        if (flag || flag1)
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        ((Field) (obj)).setAccessible(true);
        java.lang.reflect.Type type1 = iz.a(jw1.b(), class1, ((Field) (obj)).getGenericType());
        obj = a(ia1, ((Field) (obj)), a(((Field) (obj))), jw.a(type1), flag, flag1);
        obj = (b)linkedhashmap.put(((b) (obj)).g, obj);
        if (obj == null) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append(type).append(" declares multiple JSON fields named ").append(((b) (obj)).g).toString());
        jw1 = jw.a(iz.a(jw1.b(), class1, class1.getGenericSuperclass()));
        class1 = jw1.a();
        if (true) goto _L6; else goto _L5
_L5:
        return linkedhashmap;
    }

    public ir a(ia ia1, jw jw1)
    {
        Class class1 = jw1.a();
        if (!java/lang/Object.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            return new a(a.a(jw1), a(ia1, jw1, class1));
        }
    }

    public boolean a(Field field, boolean flag)
    {
        return !c.a(field.getType(), flag) && !c.a(field, flag);
    }

    private class a extends ir
    {

        private final jf a;
        private final Map b;

        public void a(jz jz1, Object obj)
        {
            if (obj == null)
            {
                jz1.f();
                return;
            }
            jz1.d();
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
                    if (b1.h)
                    {
                        jz1.a(b1.g);
                        b1.a(jz1, obj);
                    }
                } while (true);
            }
            // Misplaced declaration of an exception variable
            catch (jz jz1)
            {
                throw new AssertionError();
            }
            jz1.e();
        }

        public Object b(jx jx1)
        {
            Object obj;
            if (jx1.f() == jy.i)
            {
                jx1.j();
                return null;
            }
            obj = a.a();
            jx1.c();
_L1:
            Object obj1;
            if (!jx1.e())
            {
                break MISSING_BLOCK_LABEL_103;
            }
            obj1 = jx1.g();
            obj1 = (b)b.get(obj1);
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            if (((b) (obj1)).i)
            {
                break MISSING_BLOCK_LABEL_84;
            }
            jx1.n();
              goto _L1
            try
            {
                ((b) (obj1)).a(jx1, obj);
            }
            // Misplaced declaration of an exception variable
            catch (jx jx1)
            {
                throw new io(jx1);
            }
            // Misplaced declaration of an exception variable
            catch (jx jx1)
            {
                throw new AssertionError(jx1);
            }
              goto _L1
            jx1.d();
            return obj;
        }

        private a(jf jf1, Map map)
        {
            a = jf1;
            b = map;
        }

    }

}

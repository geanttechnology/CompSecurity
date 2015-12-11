// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.reflect.Type;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            is, jv, jw, ia, 
//            iz, ja, ir

public final class jp
    implements is
{

    private final ja a;
    private final boolean b;

    public jp(ja ja1, boolean flag)
    {
        a = ja1;
        b = flag;
    }

    private ir a(ia ia1, Type type)
    {
        if (type == Boolean.TYPE || type == java/lang/Boolean)
        {
            return jv.f;
        } else
        {
            return ia1.a(jw.a(type));
        }
    }

    static boolean a(jp jp1)
    {
        return jp1.b;
    }

    public ir a(ia ia1, jw jw1)
    {
        Type type = jw1.b();
        if (!java/util/Map.isAssignableFrom(jw1.a()))
        {
            return null;
        } else
        {
            Type atype[] = iz.b(type, iz.e(type));
            ir ir = a(ia1, atype[0]);
            ir ir1 = ia1.a(jw.a(atype[1]));
            jw1 = a.a(jw1);
            return new a(ia1, atype[0], ir, atype[1], ir1, jw1);
        }
    }

    private class a extends ir
    {

        final jp a;
        private final ir b;
        private final ir c;
        private final jf d;

        private String a(ig ig1)
        {
            if (ig1.i())
            {
                ig1 = ig1.m();
                if (ig1.p())
                {
                    return String.valueOf(ig1.a());
                }
                if (ig1.o())
                {
                    return Boolean.toString(ig1.f());
                }
                if (ig1.q())
                {
                    return ig1.b();
                } else
                {
                    throw new AssertionError();
                }
            }
            if (ig1.j())
            {
                return "null";
            } else
            {
                throw new AssertionError();
            }
        }

        public Map a(jx jx1)
        {
            jy jy1 = jx1.f();
            if (jy1 == jy.i)
            {
                jx1.j();
                return null;
            }
            Map map = (Map)d.a();
            if (jy1 == jy.a)
            {
                jx1.a();
                for (; jx1.e(); jx1.b())
                {
                    jx1.a();
                    Object obj = b.b(jx1);
                    if (map.put(obj, c.b(jx1)) != null)
                    {
                        throw new io((new StringBuilder()).append("duplicate key: ").append(obj).toString());
                    }
                }

                jx1.b();
                return map;
            }
            jx1.c();
            while (jx1.e()) 
            {
                jc.a.a(jx1);
                Object obj1 = b.b(jx1);
                if (map.put(obj1, c.b(jx1)) != null)
                {
                    throw new io((new StringBuilder()).append("duplicate key: ").append(obj1).toString());
                }
            }
            jx1.d();
            return map;
        }

        public volatile void a(jz jz1, Object obj)
        {
            a(jz1, (Map)obj);
        }

        public void a(jz jz1, Map map)
        {
            boolean flag3 = false;
            boolean flag2 = false;
            if (map == null)
            {
                jz1.f();
                return;
            }
            if (!jp.a(a))
            {
                jz1.d();
                java.util.Map.Entry entry;
                for (map = map.entrySet().iterator(); map.hasNext(); c.a(jz1, entry.getValue()))
                {
                    entry = (java.util.Map.Entry)map.next();
                    jz1.a(String.valueOf(entry.getKey()));
                }

                jz1.e();
                return;
            }
            ArrayList arraylist = new ArrayList(map.size());
            ArrayList arraylist1 = new ArrayList(map.size());
            map = map.entrySet().iterator();
            boolean flag = false;
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry1 = (java.util.Map.Entry)map.next();
                ig ig1 = b.a(entry1.getKey());
                arraylist.add(ig1);
                arraylist1.add(entry1.getValue());
                boolean flag1;
                if (ig1.g() || ig1.h())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag = flag1 | flag;
            }
            if (flag)
            {
                jz1.b();
                for (int i = ((flag2) ? 1 : 0); i < arraylist.size(); i++)
                {
                    jz1.b();
                    jh.a((ig)arraylist.get(i), jz1);
                    c.a(jz1, arraylist1.get(i));
                    jz1.c();
                }

                jz1.c();
                return;
            }
            jz1.d();
            for (int j = ((flag3) ? 1 : 0); j < arraylist.size(); j++)
            {
                jz1.a(a((ig)arraylist.get(j)));
                c.a(jz1, arraylist1.get(j));
            }

            jz1.e();
        }

        public Object b(jx jx1)
        {
            return a(jx1);
        }

        public a(ia ia1, Type type, ir ir1, Type type1, ir ir2, jf jf1)
        {
            a = jp.this;
            super();
            b = new ju(ia1, ir1, type);
            c = new ju(ia1, ir2, type1);
            d = jf1;
        }
    }

}

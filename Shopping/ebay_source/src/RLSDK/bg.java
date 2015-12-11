// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package RLSDK:
//            v, av, aa, ar, 
//            ah, ak, ao, al

public final class bg
{
    private static final class a
    {

        private final aa a;
        private final aa b;
        private final int c;

        public final aa a()
        {
            return a;
        }

        public final aa b()
        {
            return b;
        }

        public final int c()
        {
            return c;
        }

        public final String toString()
        {
            return (new StringBuilder()).append(a).append("/").append(b).append('/').append(c).toString();
        }

        private a(aa aa1, aa aa2, int i)
        {
            a = aa1;
            b = aa2;
            c = i;
        }

        a(aa aa1, aa aa2, int i, byte byte0)
        {
            this(aa1, aa2, i);
        }
    }

    private static final class b
        implements al
    {

        public final int a(Object obj, Object obj1)
        {
            return ((a)obj).c() - ((a)obj1).c();
        }

        private b()
        {
        }

        b(byte byte0)
        {
            this();
        }
    }


    private static final Integer a[] = {
        new Integer(0), new Integer(1), new Integer(2), new Integer(3), new Integer(4)
    };
    private final ah b;
    private final av c;

    public bg(ah ah1)
        throws v
    {
        b = ah1;
        c = new av(ah1);
    }

    private static int a(aa aa1, aa aa2)
    {
        return (int)((float)Math.sqrt((aa1.a() - aa2.a()) * (aa1.a() - aa2.a()) + (aa1.b() - aa2.b()) * (aa1.b() - aa2.b())) + 0.5F);
    }

    private static ah a(ah ah1, aa aa1, aa aa2, aa aa3, aa aa4, int i, int j)
        throws v
    {
        return ar.a().a(ah1, i, j, 0.5F, 0.5F, (float)i - 0.5F, 0.5F, (float)i - 0.5F, (float)j - 0.5F, 0.5F, (float)j - 0.5F, aa1.a(), aa1.b(), aa4.a(), aa4.b(), aa3.a(), aa3.b(), aa2.a(), aa2.b());
    }

    private static void a(Hashtable hashtable, aa aa1)
    {
        Integer integer = (Integer)hashtable.get(aa1);
        if (integer == null)
        {
            integer = a[1];
        } else
        {
            integer = a[integer.intValue() + 1];
        }
        hashtable.put(aa1, integer);
    }

    private boolean a(aa aa1)
    {
        return aa1.a() >= 0.0F && aa1.a() < (float)b.a && aa1.b() > 0.0F && aa1.b() < (float)b.b;
    }

    private a b(aa aa1, aa aa2)
    {
        int j = (int)aa1.a();
        int i = (int)aa1.b();
        int k1 = (int)aa2.a();
        int l1 = (int)aa2.b();
        ah ah1;
        int k;
        int i1;
        boolean flag;
        int i2;
        int j2;
        int k2;
        int l2;
        int j3;
        int k3;
        boolean flag1;
        if (Math.abs(l1 - i) > Math.abs(k1 - j))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            int l = k1;
            k1 = l1;
            int j1 = j;
            l1 = l;
            j = i;
            i = j1;
        }
        j3 = Math.abs(l1 - i);
        k3 = Math.abs(k1 - j);
        k2 = -j3;
        if (j < k1)
        {
            i2 = 1;
        } else
        {
            i2 = -1;
        }
        if (i < l1)
        {
            j2 = 1;
        } else
        {
            j2 = -1;
        }
        l2 = 0;
        ah1 = b;
        if (flag)
        {
            k = j;
        } else
        {
            k = i;
        }
        if (flag)
        {
            i1 = i;
        } else
        {
            i1 = j;
        }
        flag1 = ah1.a(k, i1);
        k2 >>= 1;
        k = l2;
        do
        {
            l2 = k;
            if (i == l1)
            {
                break;
            }
            ah ah2 = b;
            int i3;
            boolean flag2;
            boolean flag3;
            if (flag)
            {
                i1 = j;
            } else
            {
                i1 = i;
            }
            if (flag)
            {
                l2 = i;
            } else
            {
                l2 = j;
            }
            flag3 = ah2.a(i1, l2);
            i1 = k;
            flag2 = flag1;
            if (flag3 != flag1)
            {
                i1 = k + 1;
                flag2 = flag3;
            }
            i3 = k2 + k3;
            k = i3;
            k2 = j;
            if (i3 > 0)
            {
                l2 = i1;
                if (j == k1)
                {
                    break;
                }
                k2 = j + i2;
                k = i3 - j3;
            }
            i += j2;
            l2 = k;
            j = k2;
            k = i1;
            flag1 = flag2;
            k2 = l2;
        } while (true);
        return new a(aa1, aa2, l2, (byte)0);
    }

    public final ao a()
        throws v
    {
        aa aaa[] = c.a();
        aa aa2 = aaa[0];
        aa aa3 = aaa[1];
        aa aa4 = aaa[2];
        aa aa5 = aaa[3];
        Object obj1 = new Vector(4);
        ((Vector) (obj1)).addElement(b(aa2, aa3));
        ((Vector) (obj1)).addElement(b(aa2, aa4));
        ((Vector) (obj1)).addElement(b(aa3, aa5));
        ((Vector) (obj1)).addElement(b(aa4, aa5));
        ak.a(((Vector) (obj1)), new b((byte)0));
        Object obj = (a)((Vector) (obj1)).elementAt(0);
        obj1 = (a)((Vector) (obj1)).elementAt(1);
        Hashtable hashtable = new Hashtable();
        a(hashtable, ((a) (obj)).a());
        a(hashtable, ((a) (obj)).b());
        a(hashtable, ((a) (obj1)).a());
        a(hashtable, ((a) (obj1)).b());
        Object obj3 = hashtable.keys();
        Object obj2 = null;
        obj1 = null;
        aa aa1 = null;
        while (((Enumeration) (obj3)).hasMoreElements()) 
        {
            obj = (aa)((Enumeration) (obj3)).nextElement();
            if (((Integer)hashtable.get(obj)).intValue() == 2)
            {
                obj2 = obj;
            } else
            if (obj1 == null)
            {
                obj1 = obj;
            } else
            {
                aa1 = ((aa) (obj));
            }
        }
        if (obj1 == null || obj2 == null || aa1 == null)
        {
            throw v.a();
        }
        obj = new aa[3];
        obj[0] = ((aa) (obj1));
        obj[1] = ((aa) (obj2));
        obj[2] = aa1;
        aa.a(((aa []) (obj)));
        obj3 = obj[0];
        aa aa6 = obj[1];
        aa aa7 = obj[2];
        float f;
        float f1;
        float f2;
        int i;
        int j;
        int k;
        if (!hashtable.containsKey(aa2))
        {
            obj = aa2;
        } else
        if (!hashtable.containsKey(aa3))
        {
            obj = aa3;
        } else
        if (!hashtable.containsKey(aa4))
        {
            obj = aa4;
        } else
        {
            obj = aa5;
        }
        k = b(aa7, ((aa) (obj))).c();
        j = b(((aa) (obj3)), ((aa) (obj))).c();
        i = k;
        if ((k & 1) == 1)
        {
            i = k + 1;
        }
        k = i + 2;
        i = j;
        if ((j & 1) == 1)
        {
            i = j + 1;
        }
        i += 2;
        if (k * 4 < i * 7 && i * 4 < k * 7) goto _L2; else goto _L1
_L1:
        f = (float)a(aa6, ((aa) (obj3))) / (float)k;
        j = a(aa7, ((aa) (obj)));
        f1 = (((aa) (obj)).a() - aa7.a()) / (float)j;
        f2 = (((aa) (obj)).b() - aa7.b()) / (float)j;
        obj2 = new aa(f1 * f + ((aa) (obj)).a(), f * f2 + ((aa) (obj)).b());
        f = (float)a(aa6, aa7) / (float)i;
        j = a(((aa) (obj3)), ((aa) (obj)));
        f1 = (((aa) (obj)).a() - ((aa) (obj3)).a()) / (float)j;
        f2 = (((aa) (obj)).b() - ((aa) (obj3)).b()) / (float)j;
        aa1 = new aa(f1 * f + ((aa) (obj)).a(), f * f2 + ((aa) (obj)).b());
        if (a(((aa) (obj2)))) goto _L4; else goto _L3
_L3:
        if (a(aa1)) goto _L6; else goto _L5
_L5:
        obj1 = null;
_L8:
        obj2 = obj1;
        if (obj1 == null)
        {
            obj2 = obj;
        }
        j = b(aa7, ((aa) (obj2))).c();
        k = b(((aa) (obj3)), ((aa) (obj2))).c();
        i = j;
        if ((j & 1) == 1)
        {
            i = j + 1;
        }
        j = k;
        if ((k & 1) == 1)
        {
            j = k + 1;
        }
        obj = a(b, aa7, aa6, ((aa) (obj3)), ((aa) (obj2)), i, j);
_L13:
        return new ao(((ah) (obj)), new aa[] {
            aa7, aa6, obj3, obj2
        });
_L4:
        obj1 = obj2;
        if (!a(aa1)) goto _L8; else goto _L7
_L7:
        obj1 = obj2;
        if (Math.abs(k - b(aa7, ((aa) (obj2))).c()) + Math.abs(i - b(((aa) (obj3)), ((aa) (obj2))).c()) <= Math.abs(k - b(aa7, aa1).c()) + Math.abs(i - b(((aa) (obj3)), aa1).c())) goto _L8; else goto _L6
_L6:
        obj1 = aa1;
          goto _L8
_L2:
        i = Math.min(i, k);
        f = (float)a(aa6, ((aa) (obj3))) / (float)i;
        j = a(aa7, ((aa) (obj)));
        f1 = (((aa) (obj)).a() - aa7.a()) / (float)j;
        f2 = (((aa) (obj)).b() - aa7.b()) / (float)j;
        obj2 = new aa(f1 * f + ((aa) (obj)).a(), f * f2 + ((aa) (obj)).b());
        f = (float)a(aa6, ((aa) (obj3))) / (float)i;
        i = a(((aa) (obj3)), ((aa) (obj)));
        f1 = (((aa) (obj)).a() - ((aa) (obj3)).a()) / (float)i;
        f2 = (((aa) (obj)).b() - ((aa) (obj3)).b()) / (float)i;
        aa1 = new aa(f1 * f + ((aa) (obj)).a(), f * f2 + ((aa) (obj)).b());
        if (a(((aa) (obj2)))) goto _L10; else goto _L9
_L9:
        if (a(aa1)) goto _L12; else goto _L11
_L11:
        obj1 = null;
_L15:
        obj2 = obj1;
        if (obj1 == null)
        {
            obj2 = obj;
        }
        j = Math.max(b(aa7, ((aa) (obj2))).c(), b(((aa) (obj3)), ((aa) (obj2))).c()) + 1;
        i = j;
        if ((j & 1) == 1)
        {
            i = j + 1;
        }
        obj = a(b, aa7, aa6, ((aa) (obj3)), ((aa) (obj2)), i, i);
          goto _L13
_L10:
        obj1 = obj2;
        if (!a(aa1)) goto _L15; else goto _L14
_L14:
        obj1 = obj2;
        if (Math.abs(b(aa7, ((aa) (obj2))).c() - b(((aa) (obj3)), ((aa) (obj2))).c()) <= Math.abs(b(aa7, aa1).c() - b(((aa) (obj3)), aa1).c())) goto _L15; else goto _L12
_L12:
        obj1 = aa1;
          goto _L15
    }

}

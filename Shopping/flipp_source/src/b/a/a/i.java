// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;

import b.a.a.d.d;
import b.a.a.d.e;
import b.a.a.d.t;
import b.a.a.d.u;
import b.a.a.d.y;
import b.a.a.e.h;
import b.a.a.e.j;
import b.a.a.e.k;
import b.a.a.e.l;
import b.a.a.e.m;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

// Referenced classes of package b.a.a:
//            j

public abstract class i
    implements Serializable
{

    public static final i a;
    public static j b;
    private static k d;
    private static Set e;
    private static volatile i f;
    private static d g;
    private static Map h;
    private static Map i;
    public final String c;

    public i(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Id must not be null");
        } else
        {
            c = s;
            return;
        }
    }

    public static i a()
    {
        Object obj = f;
        if (obj != null) goto _L2; else goto _L1
_L1:
        b/a/a/i;
        JVM INSTR monitorenter ;
        Object obj1 = f;
        obj = obj1;
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        i i1;
        i1 = null;
        obj1 = null;
        obj = i1;
        String s = System.getProperty("user.timezone");
        obj = obj1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        obj = i1;
        i1 = a(s);
        obj = i1;
_L5:
        obj1 = obj;
        if (obj == null)
        {
            try
            {
                obj1 = a(TimeZone.getDefault());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                obj1 = obj;
            }
            finally { }
        }
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        obj = a;
        f = ((i) (obj));
_L4:
        b/a/a/i;
        JVM INSTR monitorexit ;
        return ((i) (obj));
        b/a/a/i;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        obj = obj1;
        if (true) goto _L5; else goto _L2
_L2:
        return ((i) (obj));
    }

    public static i a(int i1)
    {
        if (i1 < 0xfad9a401 || i1 > 0x5265bff)
        {
            throw new IllegalArgumentException((new StringBuilder("Millis out of range: ")).append(i1).toString());
        } else
        {
            return a(b(i1), i1);
        }
    }

    public static i a(String s)
    {
        i i1;
        if (s == null)
        {
            i1 = a();
        } else
        {
            if (s.equals("UTC"))
            {
                return a;
            }
            i j1 = d.a(s);
            i1 = j1;
            if (j1 == null)
            {
                if (s.startsWith("+") || s.startsWith("-"))
                {
                    int k1 = c(s);
                    if ((long)k1 == 0L)
                    {
                        return a;
                    } else
                    {
                        return a(b(k1), k1);
                    }
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder("The datetime zone id '")).append(s).append("' is not recognised").toString());
                }
            }
        }
        return i1;
    }

    private static i a(String s, int i1)
    {
        b/a/a/i;
        JVM INSTR monitorenter ;
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        Object obj = a;
_L4:
        b/a/a/i;
        JVM INSTR monitorexit ;
        return ((i) (obj));
_L2:
        if (h == null)
        {
            h = new HashMap();
        }
        obj = (Reference)h.get(s);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        i j1 = (i)((Reference) (obj)).get();
        obj = j1;
        if (j1 != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new b.a.a.e.i(s, null, i1, i1);
        h.put(s, new SoftReference(obj));
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public static i a(TimeZone timezone)
    {
        i j1;
        if (timezone == null)
        {
            j1 = a();
        } else
        {
            String s = timezone.getID();
            if (s.equals("UTC"))
            {
                return a;
            }
            j1 = null;
            String s1 = b(s);
            if (s1 != null)
            {
                j1 = d.a(s1);
            }
            i i1 = j1;
            if (j1 == null)
            {
                i1 = d.a(s);
            }
            j1 = i1;
            if (i1 == null)
            {
                if (s1 == null)
                {
                    timezone = timezone.getID();
                    if (timezone.startsWith("GMT+") || timezone.startsWith("GMT-"))
                    {
                        int k1 = c(timezone.substring(3));
                        if ((long)k1 == 0L)
                        {
                            return a;
                        } else
                        {
                            return a(b(k1), k1);
                        }
                    }
                }
                throw new IllegalArgumentException((new StringBuilder("The datetime zone id '")).append(s).append("' is not recognised").toString());
            }
        }
        return j1;
    }

    public static String b(int i1)
    {
        StringBuffer stringbuffer = new StringBuffer();
        int j1;
        if (i1 >= 0)
        {
            stringbuffer.append('+');
        } else
        {
            stringbuffer.append('-');
            i1 = -i1;
        }
        j1 = i1 / 0x36ee80;
        y.a(stringbuffer, j1, 2);
        i1 -= j1 * 0x36ee80;
        j1 = i1 / 60000;
        stringbuffer.append(':');
        y.a(stringbuffer, j1, 2);
        i1 -= j1 * 60000;
        if (i1 == 0)
        {
            return stringbuffer.toString();
        }
        j1 = i1 / 1000;
        stringbuffer.append(':');
        y.a(stringbuffer, j1, 2);
        i1 -= j1 * 1000;
        if (i1 == 0)
        {
            return stringbuffer.toString();
        } else
        {
            stringbuffer.append('.');
            y.a(stringbuffer, i1, 3);
            return stringbuffer.toString();
        }
    }

    private static String b(String s)
    {
        b/a/a/i;
        JVM INSTR monitorenter ;
        Map map = i;
        Object obj;
        obj = map;
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_426;
        }
        obj = new HashMap();
        ((Map) (obj)).put("GMT", "UTC");
        ((Map) (obj)).put("WET", "WET");
        ((Map) (obj)).put("CET", "CET");
        ((Map) (obj)).put("MET", "CET");
        ((Map) (obj)).put("ECT", "CET");
        ((Map) (obj)).put("EET", "EET");
        ((Map) (obj)).put("MIT", "Pacific/Apia");
        ((Map) (obj)).put("HST", "Pacific/Honolulu");
        ((Map) (obj)).put("AST", "America/Anchorage");
        ((Map) (obj)).put("PST", "America/Los_Angeles");
        ((Map) (obj)).put("MST", "America/Denver");
        ((Map) (obj)).put("PNT", "America/Phoenix");
        ((Map) (obj)).put("CST", "America/Chicago");
        ((Map) (obj)).put("EST", "America/New_York");
        ((Map) (obj)).put("IET", "America/Indiana/Indianapolis");
        ((Map) (obj)).put("PRT", "America/Puerto_Rico");
        ((Map) (obj)).put("CNT", "America/St_Johns");
        ((Map) (obj)).put("AGT", "America/Argentina/Buenos_Aires");
        ((Map) (obj)).put("BET", "America/Sao_Paulo");
        ((Map) (obj)).put("ART", "Africa/Cairo");
        ((Map) (obj)).put("CAT", "Africa/Harare");
        ((Map) (obj)).put("EAT", "Africa/Addis_Ababa");
        ((Map) (obj)).put("NET", "Asia/Yerevan");
        ((Map) (obj)).put("PLT", "Asia/Karachi");
        ((Map) (obj)).put("IST", "Asia/Kolkata");
        ((Map) (obj)).put("BST", "Asia/Dhaka");
        ((Map) (obj)).put("VST", "Asia/Ho_Chi_Minh");
        ((Map) (obj)).put("CTT", "Asia/Shanghai");
        ((Map) (obj)).put("JST", "Asia/Tokyo");
        ((Map) (obj)).put("ACT", "Australia/Darwin");
        ((Map) (obj)).put("AET", "Australia/Sydney");
        ((Map) (obj)).put("SST", "Pacific/Guadalcanal");
        ((Map) (obj)).put("NST", "Pacific/Auckland");
        i = ((Map) (obj));
        s = (String)((Map) (obj)).get(s);
        b/a/a/i;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public static Set b()
    {
        return e;
    }

    private static int c(String s)
    {
        Object obj1 = new b.a.a.j();
        Object obj = f();
        int i1;
        int j1;
        if (((d) (obj)).e != obj1)
        {
            obj = new d(((d) (obj)).a, ((d) (obj)).b, ((d) (obj)).c, ((d) (obj)).d, ((a) (obj1)), ((d) (obj)).f, ((d) (obj)).g, ((d) (obj)).h);
        }
        obj1 = ((d) (obj)).b();
        obj = new u(((d) (obj)).a(((d) (obj)).e), ((d) (obj)).c, ((d) (obj)).g, ((d) (obj)).h);
        j1 = ((t) (obj1)).a(((u) (obj)), s, 0);
        if (j1 >= 0)
        {
            i1 = j1;
            if (j1 >= s.length())
            {
                return -(int)((u) (obj)).a(s);
            }
        } else
        {
            i1 = ~j1;
        }
        throw new IllegalArgumentException(y.b(s, i1));
    }

    private static k d()
    {
        Object obj1 = null;
        String s = System.getProperty("org.joda.time.DateTimeZone.Provider");
        Object obj;
        obj = obj1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        obj = (k)Class.forName(s).newInstance();
_L1:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        obj1 = new m("org/joda/time/tz/data");
        obj = obj1;
_L2:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = new l();
        }
        return ((k) (obj1));
        obj;
        Thread thread = Thread.currentThread();
        thread.getThreadGroup().uncaughtException(thread, ((Throwable) (obj)));
        obj = obj1;
          goto _L1
        SecurityException securityexception;
        securityexception;
        securityexception = ((SecurityException) (obj1));
          goto _L1
        Exception exception;
        exception;
        Thread thread1 = Thread.currentThread();
        thread1.getThreadGroup().uncaughtException(thread1, exception);
          goto _L2
    }

    private static j e()
    {
        Object obj = System.getProperty("org.joda.time.DateTimeZone.NameProvider");
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = (j)Class.forName(((String) (obj))).newInstance();
_L4:
        Object obj1 = obj;
        if (obj == null)
        {
            obj1 = new h();
        }
        return ((j) (obj1));
        obj;
        Thread thread = Thread.currentThread();
        thread.getThreadGroup().uncaughtException(thread, ((Throwable) (obj)));
_L2:
        obj = null;
        continue; /* Loop/switch isn't completed */
        SecurityException securityexception;
        securityexception;
        securityexception = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static d f()
    {
        b/a/a/i;
        JVM INSTR monitorenter ;
        d d1;
        if (g == null)
        {
            g = (new e()).a(null, true, 4).a();
        }
        d1 = g;
        b/a/a/i;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public final long a(long l1, long l2)
    {
        int i1;
        i1 = b(l2);
        l2 = l1 - (long)i1;
        if (b(l2) != i1) goto _L2; else goto _L1
_L1:
        return l2;
_L2:
        int j1;
        i1 = b(l1);
        j1 = b(l1 - (long)i1);
        if (i1 == j1 || i1 >= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        long l3 = e(l1 - (long)i1);
        l2 = l3;
        if (l3 == l1 - (long)i1)
        {
            l2 = 0x7fffffffffffffffL;
        }
        long l5 = e(l1 - (long)j1);
        l3 = l5;
        if (l5 == l1 - (long)j1)
        {
            l3 = 0x7fffffffffffffffL;
        }
        if (l2 == l3)
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        long l4 = l1 - (long)i1;
        l2 = l4;
        if ((l1 ^ l4) < 0L)
        {
            l2 = l4;
            if (((long)i1 ^ l1) < 0L)
            {
                throw new ArithmeticException("Subtracting time zone offset caused overflow");
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        i1 = j1;
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public abstract String a(long l1);

    public abstract int b(long l1);

    public int c(long l1)
    {
        int i1 = b(l1);
        long l2 = l1 - (long)i1;
        int j1 = b(l2);
        if (i1 != j1)
        {
            if (i1 - j1 < 0 && e(l2) != e(l1 - (long)j1))
            {
                return i1;
            }
        } else
        if (i1 >= 0)
        {
            l1 = f(l2);
            if (l1 < l2)
            {
                int k1 = b(l1);
                if (l2 - l1 <= (long)(k1 - i1))
                {
                    return k1;
                }
            }
        }
        return j1;
    }

    public abstract boolean c();

    public final long d(long l1)
    {
        int i1 = b(l1);
        long l2 = (long)i1 + l1;
        if ((l1 ^ l2) < 0L && ((long)i1 ^ l1) >= 0L)
        {
            throw new ArithmeticException("Adding time zone offset caused overflow");
        } else
        {
            return l2;
        }
    }

    public abstract long e(long l1);

    public abstract boolean equals(Object obj);

    public abstract long f(long l1);

    public int hashCode()
    {
        return c.hashCode() + 57;
    }

    public String toString()
    {
        return c;
    }

    static 
    {
        a = new b.a.a.e.i("UTC", "UTC", 0, 0);
        k k1 = d();
        Set set = k1.a();
        if (set == null || set.size() == 0)
        {
            throw new IllegalArgumentException("The provider doesn't have any available ids");
        }
        if (!set.contains("UTC"))
        {
            throw new IllegalArgumentException("The provider doesn't support UTC");
        }
        if (!a.equals(k1.a("UTC")))
        {
            throw new IllegalArgumentException("Invalid UTC zone provided");
        } else
        {
            d = k1;
            e = set;
            b = e();
        }
    }
}

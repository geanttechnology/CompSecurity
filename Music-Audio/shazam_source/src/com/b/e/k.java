// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.e;

import com.b.a.b;
import com.b.b.c;
import com.b.b.d;
import com.b.e.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.b.e:
//            n, j, e, c, 
//            p, q, v, o, 
//            l

public final class k
{

    public int a;
    public int b;
    public long c;
    public long d;
    public String e;
    protected final b f;
    private int g;
    private final String h;
    private ArrayList i;
    private String j;
    private int k;
    private long l;
    private long m;

    public k(b b1)
    {
        this(b1, "cs_cache_");
    }

    private k(b b1, String s)
    {
        e = null;
        i = null;
        j = null;
        k = 0;
        l = 0L;
        m = 0L;
        f = b1;
        h = s;
        a = 2000;
        a(100);
        b = 10;
        c = 30L;
        d = 31L;
        d();
    }

    private void a(String s, boolean flag)
    {
        if (s != null)
        {
            if (flag)
            {
                n n1 = f.b;
                if (n1.a(s).booleanValue())
                {
                    b(Integer.valueOf(n1.b(s)).intValue());
                }
            }
            com.b.e.j.a(f, s);
            i.remove(s);
        }
    }

    private boolean a(long l1)
    {
        long l2 = System.currentTimeMillis();
        return d * 24L * 60L * 60L * 1000L - (l2 - l1) <= 0L;
    }

    private boolean a(String s, String s1)
    {
        HttpClient httpclient;
        httpclient = com.b.e.e.a();
        s1 = new HttpPost(s1);
        int i1;
        s = new StringEntity(s, "UTF-8");
        s.setContentType("text/xml");
        s1.setHeader("User-Agent", System.getProperty("http.agent"));
        s1.setEntity(s);
        com.b.e.c.a(this);
        f.b.a("lastTransmission", String.valueOf(System.currentTimeMillis()));
        s = httpclient.execute(s1);
        i1 = s.getStatusLine().getStatusCode();
        com.b.e.c.a(this);
        com.b.e.c.a(this);
        s = EntityUtils.toString(s.getEntity());
        if (i1 != 200)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        boolean flag;
        if (!p.f(s))
        {
            break MISSING_BLOCK_LABEL_165;
        }
        flag = s.startsWith("OK");
        if (flag)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_165;
        s;
        com.b.e.c.a(this, (new StringBuilder("Exception in flush:")).append(s.getLocalizedMessage()).toString());
        com.b.e.c.a(s);
        return false;
    }

    private void b(int i1)
    {
        n n1 = f.b;
        int j1 = i1;
        if (n1.a("CACHE_DROPPED_MEASUREMENTS").booleanValue())
        {
            j1 = i1 + Integer.valueOf(n1.b("CACHE_DROPPED_MEASUREMENTS")).intValue();
        }
        n1.a("CACHE_DROPPED_MEASUREMENTS", String.valueOf(j1));
    }

    private void b(String s)
    {
        com.b.e.c.a(this);
        String s1 = (new StringBuilder()).append(h).append(com.b.e.q.a(s, "ns_ts")).toString();
        com.b.e.j.a(f, s1, 0, s);
        if (i == null)
        {
            i = new ArrayList();
        }
        i.add(s1);
        c();
    }

    private int c(String s)
    {
label0:
        {
            n n1 = f.b;
            int i1 = 0;
            if (s != null)
            {
                if (!n1.a(s).booleanValue())
                {
                    break label0;
                }
                i1 = Integer.valueOf(n1.b(s)).intValue();
            }
            return i1;
        }
        return com.b.e.j.a(f.ab, s).length;
    }

    private void c()
    {
        l = 0L;
        if (j != null)
        {
            j = null;
        }
    }

    private void d()
    {
        List list = e();
        boolean flag = false;
        int i1 = list.size();
        while (i1 > 0) 
        {
            long l1 = Long.valueOf(((String)list.get(i1 - 1)).substring(h.length())).longValue();
            if (!flag)
            {
                flag = a(l1);
            } else
            {
                (new StringBuilder("Deleting expired cache file ")).append((String)list.get(i1 - 1));
                com.b.e.c.a(this);
                a((String)list.get(i1 - 1), true);
            }
            i1--;
        }
    }

    private String[] d(String s)
    {
        String as[];
        boolean flag;
        int k1;
        as = com.b.e.j.a(f.ab, s);
        flag = false;
        k1 = 0;
_L2:
        boolean flag1;
        flag1 = flag;
        if (k1 >= as.length)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        flag1 = flag;
        if (!a(Long.parseLong(com.b.e.q.a(as[k1], "ns_ts"))))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        flag1 = flag;
        com.b.e.c.a(this);
        flag1 = flag;
        if (!flag1)
        {
            (new StringBuilder("All events in the file ")).append(s).append(" are expired");
            com.b.e.c.a(this);
            a(s, true);
            return null;
        }
        break; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        k1++;
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
        b(k1);
        int j1 = as.length;
        if (k1 > j1)
        {
            throw new IllegalArgumentException();
        }
        int i1 = as.length;
        if (k1 < 0 || k1 > i1)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j1 -= k1;
            i1 = Math.min(j1, i1 - k1);
            s = new String[j1];
            System.arraycopy(as, k1, s, 0, i1);
            return s;
        }
    }

    private List e()
    {
        if (i == null)
        {
            i = com.b.e.j.a(f.ab);
        }
        return i;
    }

    private String f()
    {
        if (i != null && i.size() > 0)
        {
            return (String)i.get(i.size() - 1);
        } else
        {
            return null;
        }
    }

    public final int a()
    {
        int j1 = c(f());
        List list = e();
        int i1 = j1;
        if (list.size() > 0)
        {
            i1 = j1 + (list.size() - 1) * g;
        }
        return i1;
    }

    public final void a(int i1)
    {
        if (i1 <= 0)
        {
            return;
        } else
        {
            g = i1;
            return;
        }
    }

    public final void a(d d1, HashMap hashmap)
    {
        d1 = com.b.b.c.a(f, d1, hashmap, null);
        f.g.c(d1);
        f.g.b(d1);
        a(((com.b.c.b) (d1)), true);
    }

    public final void a(com.b.c.b b1, boolean flag)
    {
        if (flag)
        {
            f.f.a(new v(this, b1), true);
            return;
        } else
        {
            a(b1.a(f.al));
            return;
        }
    }

    public final void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (f.ak == o.e || f.y() == null || !p.f(com.b.e.q.a(s, "ns_ts"))) goto _L2; else goto _L1
_L1:
        String s1 = f();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        if (c(s1) >= g) goto _L4; else goto _L3
_L3:
        s = (new StringBuilder("\n")).append(s).toString();
        com.b.e.j.a(f, s1, 32768, s);
        c();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        com.b.e.c.a(this);
        if (e().size() < a / g) goto _L6; else goto _L5
_L5:
        (new StringBuilder("reached the cache max (")).append(a).append(") size");
        com.b.e.c.a(this);
        if (i == null || i.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        s1 = (String)i.get(0);
_L7:
        a(s1, true);
_L6:
        b(s);
          goto _L2
        s;
        throw s;
        s1 = null;
          goto _L7
        b(s);
          goto _L2
    }

    public final boolean b()
    {
        this;
        JVM INSTR monitorenter ;
        n n1 = f.b;
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = false;
        long l1;
        d();
        l1 = c * 1000L * 60L - (System.currentTimeMillis() - l);
        if (l1 > 0L) goto _L2; else goto _L1
_L1:
        l = 0L;
_L21:
        Object obj = f.ab;
        if (!com.b.e.e.b()) goto _L4; else goto _L3
_L3:
        obj = Boolean.valueOf(true);
_L28:
        if (!((Boolean) (obj)).booleanValue()) goto _L6; else goto _L5
_L5:
        Object obj1;
        String as[];
        Object obj2;
        String s;
        boolean flag;
        if (a() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag) goto _L6; else goto _L7
_L7:
        if (f.y() == null) goto _L6; else goto _L8
_L8:
        if (k < b) goto _L10; else goto _L9
_L9:
        l1 = c * 1000L * 60L - (System.currentTimeMillis() - m);
        if (l1 > 0L) goto _L12; else goto _L11
_L11:
        k = 0;
        m = 0L;
        flag = true;
_L32:
        flag2 = flag1;
        if (!flag) goto _L14; else goto _L13
_L13:
        (new StringBuilder("Cache is not empty, contains ")).append(i.size()).append(" files");
        com.b.e.c.a(this);
        if (j != null) goto _L16; else goto _L15
_L15:
        obj1 = f();
        com.b.e.c.a(this);
        as = d(((String) (obj1)));
        if (as == null) goto _L18; else goto _L17
_L17:
        if (as.length <= 0) goto _L18; else goto _L19
_L19:
        if (!n1.a("CACHE_DROPPED_MEASUREMENTS").booleanValue())
        {
            break MISSING_BLOCK_LABEL_766;
        }
        obj = n1.b("CACHE_DROPPED_MEASUREMENTS");
_L33:
        j = com.b.e.q.a(as, ((String) (obj)));
          goto _L18
_L31:
        if (j == null || j.length() <= 0) goto _L21; else goto _L20
_L20:
        s = j;
        if (e == null) goto _L23; else goto _L22
_L22:
        obj1 = new StringBuilder(e);
_L29:
        flag = true;
        if (((StringBuilder) (obj1)).indexOf("?") != -1)
        {
            break MISSING_BLOCK_LABEL_332;
        }
        ((StringBuilder) (obj1)).append("?");
        flag = false;
        obj2 = f.y();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_384;
        }
        if (((String) (obj2)).equals(""))
        {
            break MISSING_BLOCK_LABEL_384;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        ((StringBuilder) (obj1)).append("&");
        ((StringBuilder) (obj1)).append("c2=");
        ((StringBuilder) (obj1)).append(((String) (obj2)));
        flag = true;
        obj2 = f;
        if (((b) (obj2)).am != null) goto _L25; else goto _L24
_L24:
        obj2 = "";
_L30:
        obj2 = com.b.e.p.a(String.format("JetportGotAMaskOfThe%sS.D_K-", new Object[] {
            obj2
        }));
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_459;
        }
        if (((String) (obj2)).equals(""))
        {
            break MISSING_BLOCK_LABEL_459;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_445;
        }
        ((StringBuilder) (obj1)).append("&");
        ((StringBuilder) (obj1)).append("s=");
        ((StringBuilder) (obj1)).append(((String) (obj2)));
        flag1 = a(s, ((StringBuilder) (obj1)).toString().toLowerCase(new Locale("en", "US")));
        if (!flag1) goto _L27; else goto _L26
_L26:
        k = k + 1;
        a(((String) (obj)), false);
        c();
        m = System.currentTimeMillis();
        n1.c("CACHE_DROPPED_MEASUREMENTS");
          goto _L21
        obj;
        throw obj;
_L4:
label0:
        {
            if (com.b.e.l.a(((android.content.Context) (obj)), "android.permission.ACCESS_NETWORK_STATE").booleanValue())
            {
                break label0;
            }
            obj = Boolean.valueOf(true);
        }
          goto _L28
label1:
        {
            if (!com.b.e.e.b(((android.content.Context) (obj))))
            {
                break label1;
            }
            obj = Boolean.valueOf(true);
        }
          goto _L28
label2:
        {
            if (!com.b.e.e.c(((android.content.Context) (obj))))
            {
                break label2;
            }
            obj = Boolean.valueOf(true);
        }
          goto _L28
        obj = Boolean.valueOf(false);
          goto _L28
_L12:
        (new StringBuilder("Max flushes in a row (")).append(b).append(") reached. Waiting ").append((double)l1 / 1000D / 60D).append(" minutes");
        com.b.e.c.a(this);
          goto _L6
_L23:
        if (f.ai)
        {
            obj1 = "https://udm.scorecardresearch.com/offline";
        } else
        {
            obj1 = "http://udm.scorecardresearch.com/offline";
        }
        obj1 = new StringBuilder(((String) (obj1)));
          goto _L29
_L25:
        obj2 = ((b) (obj2)).am.a();
          goto _L30
_L27:
        l = System.currentTimeMillis();
        flag2 = flag1;
_L14:
        this;
        JVM INSTR monitorexit ;
        return flag2;
_L2:
        (new StringBuilder("Waiting ")).append((double)l1 / 1000D / 60D).append(" minutes");
        com.b.e.c.a(this);
        if (true) goto _L14; else goto _L16
_L16:
        obj = null;
          goto _L31
_L18:
        obj = obj1;
          goto _L31
_L6:
        flag = false;
          goto _L32
_L10:
        flag = true;
          goto _L32
        obj = "0";
          goto _L33
    }
}

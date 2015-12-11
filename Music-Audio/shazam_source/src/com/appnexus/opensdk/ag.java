// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.d;
import com.appnexus.opensdk.b.e;
import com.appnexus.opensdk.b.j;
import com.appnexus.opensdk.b.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

// Referenced classes of package com.appnexus.opensdk:
//            aq, aa, h, ap, 
//            z, ar

public final class ag
{
    private final class a extends d
    {

        WeakReference a;
        final aq b;
        final ag c;
        private final String d;
        private final HashMap e;
        private final boolean f;
        private final long g;
        private final long h;

        protected final String a()
        {
            StringBuilder stringbuilder = new StringBuilder(d);
            stringbuilder.append("&reason=").append(b.ordinal());
            if (!k.a(j.a().d))
            {
                stringbuilder.append("&aaid=").append(Uri.encode(j.a().d));
            } else
            {
                stringbuilder.append("&md5udid=").append(Uri.encode(j.a().a));
                stringbuilder.append("&sha1udid=").append(Uri.encode(j.a().b));
            }
            if (g > 0L)
            {
                stringbuilder.append("&latency=").append(Uri.encode(String.valueOf(g)));
            }
            if (h > 0L)
            {
                stringbuilder.append("&total_latency=").append(Uri.encode(String.valueOf(h)));
            }
            return stringbuilder.toString();
        }

        protected final void a(e e1)
        {
            if (f)
            {
                com.appnexus.opensdk.b.b.c(com.appnexus.opensdk.b.b.f, com.appnexus.opensdk.b.b.a(an.d.result_cb_ignored));
                return;
            }
            h h1 = (h)a.get();
            if (h1 == null)
            {
                com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.f, com.appnexus.opensdk.b.b.a(an.d.fire_cb_requester_null));
                return;
            }
            ar ar1 = null;
            if (e1 != null && e1.a)
            {
                ar1 = new ar(e1, z.c);
                e1 = ar1;
                if (e.containsKey("ORIENTATION"))
                {
                    ar1.a("ORIENTATION", e.get("ORIENTATION"));
                    e1 = ar1;
                }
            } else
            {
                com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.f, com.appnexus.opensdk.b.b.a(an.d.result_cb_bad_response));
                e1 = ar1;
            }
            h1.a(e1);
        }

        protected final void onPostExecute(Object obj)
        {
            a((e)obj);
        }

        private a(h h1, String s, aq aq1, HashMap hashmap, boolean flag, long l, long l1)
        {
            c = ag.this;
            super();
            a = new WeakReference(h1);
            d = s;
            b = aq1;
            e = hashmap;
            f = flag;
            g = l;
            h = l1;
        }

        a(h h1, String s, aq aq1, HashMap hashmap, boolean flag, long l, long l1, byte byte0)
        {
            this(h1, s, aq1, hashmap, flag, l, l1);
        }
    }

    static final class b extends Handler
    {

        WeakReference a;

        public final void handleMessage(Message message)
        {
            Exception exception;
            message = (ag)a.get();
            if (message == null || ((ag) (message)).d)
            {
                return;
            }
            com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.c, com.appnexus.opensdk.b.b.a(an.d.mediation_timeout));
            try
            {
                message.a(aq.f);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                message.b = null;
                return;
            }
            finally
            {
                message.b = null;
            }
            message.b = null;
            return;
            throw exception;
        }

        public b(ag ag1)
        {
            a = new WeakReference(ag1);
        }
    }


    WeakReference a;
    aa b;
    boolean c;
    boolean d;
    boolean e;
    aq f;
    private final Handler g;
    private long h;
    private long i;

    ag(aa aa1, h h1)
    {
        c = false;
        d = false;
        e = false;
        g = new b(this);
        h = -1L;
        i = -1L;
        if (aa1 != null) goto _L2; else goto _L1
_L1:
        com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.c, com.appnexus.opensdk.b.b.a(an.d.mediated_no_ads));
        f = aq.c;
_L4:
        if (f != null)
        {
            a(f);
        }
        return;
_L2:
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.c, com.appnexus.opensdk.b.b.a(an.d.instantiating_class, aa1.a));
        a = new WeakReference(h1);
        b = aa1;
        if (!c && !d)
        {
            g.sendEmptyMessageDelayed(0, 15000L);
        }
        h = System.currentTimeMillis();
        Class.forName(aa1.a).newInstance();
        if (h1.b() != null)
        {
            h1.b();
            h1.b().g();
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            f = com.appnexus.opensdk.aq.b;
        }
        // Misplaced declaration of an exception variable
        catch (h h1)
        {
            a(h1, aa1.a);
        }
        // Misplaced declaration of an exception variable
        catch (h h1)
        {
            a(h1, aa1.a);
        }
        // Misplaced declaration of an exception variable
        catch (h h1)
        {
            a(h1, aa1.a);
        }
        // Misplaced declaration of an exception variable
        catch (h h1)
        {
            a(h1, aa1.a);
        }
        // Misplaced declaration of an exception variable
        catch (h h1)
        {
            a(h1, aa1.a);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(Throwable throwable, String s)
    {
        com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.c, com.appnexus.opensdk.b.b.a(an.d.mediation_instantiation_failure, throwable.getClass().getSimpleName()));
        if (!k.a(s))
        {
            com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.c, String.format("Adding %s to invalid networks list", new Object[] {
                s
            }));
            j.a().a(z.c, s);
        }
        f = com.appnexus.opensdk.aq.d;
    }

    final void a()
    {
        b = null;
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.c, com.appnexus.opensdk.b.b.a(an.d.mediation_finish));
    }

    public final void a(aq aq1)
    {
        if (c || d)
        {
            return;
        }
        i = System.currentTimeMillis();
        g.removeMessages(0);
        if (d) goto _L2; else goto _L1
_L1:
        h h1 = (h)a.get();
        if (b != null && !k.a(b.f)) goto _L4; else goto _L3
_L3:
        if (aq1 != aq.a)
        {
            com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.c, com.appnexus.opensdk.b.b.a(an.d.fire_cb_result_null));
            if (h1 == null)
            {
                com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.f, com.appnexus.opensdk.b.b.a(an.d.fire_cb_requester_null));
            } else
            {
                h1.a(null);
            }
        }
_L2:
        d = true;
        a();
        return;
_L4:
        boolean flag1 = false;
        boolean flag = flag1;
        Object obj;
        long l;
        long l1;
        if (h1 != null)
        {
            flag = flag1;
            HashMap hashmap;
            if (h1.a() != null)
            {
                if (h1.a().size() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
        }
        if (aq1 == aq.a)
        {
            flag = true;
        }
        obj = b.f;
        hashmap = b.g;
        if (h > 0L && i > 0L)
        {
            l = i - h;
        } else
        {
            l = -1L;
        }
        if (h1 != null && i > 0L)
        {
            l1 = h1.a(i);
        } else
        {
            l1 = -1L;
        }
        obj = new a(h1, ((String) (obj)), aq1, hashmap, flag, l, l1, (byte)0);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            ((a) (obj)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else
        {
            ((a) (obj)).execute(new Void[0]);
        }
        if (flag && aq1 != aq.a && h1 != null)
        {
            h1.a(null);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }
}

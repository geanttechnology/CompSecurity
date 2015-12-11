// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.tapjoy.internal:
//            el, ff, ev, ew

class em extends el
{
    static class a
        implements Runnable
    {

        em b;
        CountDownLatch c;

        public void run()
        {
            throw new NoSuchMethodError();
        }

        public a(em em1, CountDownLatch countdownlatch)
        {
            b = null;
            c = null;
            b = em1;
            c = countdownlatch;
        }
    }


    private static final String i = com/tapjoy/internal/em.getSimpleName();
    private Context j;
    private boolean k;
    private boolean l;
    private ew m;
    private ev n;
    private CountDownLatch o;
    private int p;

    em()
    {
        j = null;
        k = false;
        l = false;
        m = null;
        n = null;
        o = null;
        p = 0;
    }

    static Context a(em em1)
    {
        return em1.j;
    }

    static ev a(em em1, ev ev1)
    {
        em1.n = ev1;
        return ev1;
    }

    private static String a(String s, String s1, ArrayList arraylist)
    {
        Iterator iterator = arraylist.iterator();
        String s2;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_125;
            }
            arraylist = (HashMap)iterator.next();
            s2 = (String)arraylist.get("name");
        } while (s2 == null || !s2.toLowerCase(Locale.US).contains(s.toLowerCase(Locale.US)));
        s = arraylist;
_L1:
        if (s != null)
        {
            arraylist = ((String)s.get("name")).replace("[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY -]", "");
            s = arraylist;
            if (!arraylist.isEmpty())
            {
                s = "true";
            }
        } else
        {
            s = "false";
        }
        return (new StringBuilder()).append(s1).append("^").append(s).append("!").toString();
        s = null;
          goto _L1
    }

    private void a(String s)
    {
        c = s.replaceAll("(<FIELD_SEP>|<REC_SEP>)", "");
        d = ff.b(c);
        Object obj = new ArrayList();
        s = s.split("<REC_SEP>");
        int j1 = s.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            String s1 = s[i1];
            if (Thread.currentThread().isInterrupted())
            {
                return;
            }
            HashMap hashmap = new HashMap();
            String as[] = s1.split("<FIELD_SEP>");
            if (as.length == 4)
            {
                hashmap.put("name", as[0]);
                hashmap.put("description", as[1]);
                hashmap.put("filename", as[2]);
                hashmap.put("length", as[3]);
                ((ArrayList) (obj)).add(hashmap);
            }
        }

        b = Integer.toString(((ArrayList) (obj)).size());
        s = new StringBuilder();
        s.append(a("QuickTime Plug-in", "plugin_quicktime", ((ArrayList) (obj))));
        s.append(a("Adobe Acrobat", "plugin_adobe_acrobat", ((ArrayList) (obj))));
        s.append(a("Java", "plugin_java", ((ArrayList) (obj))));
        s.append(a("SVG Viewer", "plugin_svg_viewer", ((ArrayList) (obj))));
        s.append(a("Flash", "plugin_flash", ((ArrayList) (obj))));
        s.append(a("Windows Media Player", "plugin_windows_media_player", ((ArrayList) (obj))));
        s.append(a("Silverlight", "plugin_silverlight", ((ArrayList) (obj))));
        s.append(a("Real Player", "plugin_realplayer", ((ArrayList) (obj))));
        s.append(a("ShockWave Director", "plugin_shockwave", ((ArrayList) (obj))));
        s.append(a("VLC", "plugin_vlc_player", ((ArrayList) (obj))));
        s.append(a("DevalVR", "plugin_devalvr", ((ArrayList) (obj))));
        a = s.toString();
        s = i;
        obj = (new StringBuilder("Got")).append(b).append(":");
        if (a != null)
        {
            s = a;
        } else
        {
            s = "";
        }
        ((StringBuilder) (obj)).append(s);
    }

    static ew b(em em1)
    {
        return em1.m;
    }

    static boolean c(em em1)
    {
        return em1.k;
    }

    static ev d(em em1)
    {
        return em1.n;
    }

    static String e()
    {
        return i;
    }

    static void e(em em1)
    {
label0:
        {
            if (!Thread.currentThread().isInterrupted())
            {
                if ((em1.p & 0x20) != 0)
                {
                    String s = em1.n.a("(function () { var plugins_string='', i=0; for (p=navigator.plugins[0]; i< navigator.plugins.length;p=navigator.plugins[i++]) {  plugins_string += p.name + '<FIELD_SEP>' + p.description + '<FIELD_SEP>' + p.filename + '<FIELD_SEP>' + p.length.toString() + '<REC_SEP>'; } return plugins_string;})();");
                    if (s != null)
                    {
                        em1.a(s);
                    }
                }
                if (!Thread.currentThread().isInterrupted() && (em1.p & 4) != 0)
                {
                    String s1 = em1.n.a("navigator.mimeTypes.length");
                    if (s1 != null)
                    {
                        try
                        {
                            em1.f = Integer.parseInt(s1);
                        }
                        catch (NumberFormatException numberformatexception)
                        {
                            Log.e(i, "failed to convert", numberformatexception);
                        }
                    }
                    em1.g = em1.n.a("(function () { var mime_string='', i=0; for (var m=navigator.mimeTypes[0]; i< navigator.mimeTypes.length;m=navigator.mimeTypes[i++]) {  mime_string += m.type; } return mime_string;})();");
                    if (em1.g == null)
                    {
                        break label0;
                    }
                    em1.h = ff.b(em1.g);
                    s1 = i;
                    (new StringBuilder("Got:")).append(em1.g);
                }
            }
            return;
        }
        em1.h = "";
    }

    public final String a()
    {
        if (c == null)
        {
            if (n == null || l)
            {
                e = ev.c();
            } else
            {
                e = n.a(j);
            }
        }
        return e;
    }

    final boolean a(Context context, boolean flag, int i1)
    {
label0:
        {
            j = context;
            k = flag;
            p = i1;
            if (!k)
            {
                return false;
            }
            context = i;
            StringBuilder stringbuilder = (new StringBuilder("initJSExecutor: jsProblem = ")).append(l).append(", jsExec = ").append(n).append(", hasBadOptions = ");
            if (n != null)
            {
                context = Boolean.valueOf(n.a(flag));
            } else
            {
                context = "true";
            }
            stringbuilder.append(context);
            if (!l && n == null || n != null && n.a(k))
            {
                CountDownLatch countdownlatch = new CountDownLatch(1);
                Handler handler = new Handler(Looper.getMainLooper());
                if (ev.b() || ev.a())
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                if (i1 != 0)
                {
                    context = countdownlatch;
                } else
                {
                    context = null;
                }
                m = new ew(context);
                context = i;
                (new StringBuilder("Firing off initJSExecutor on UI thread using latch: ")).append(countdownlatch.hashCode()).append(" with count: ").append(countdownlatch.getCount());
                handler.post(new a(this, countdownlatch) {

                    final em a;

                    public final void run()
                    {
                        em.e();
                        em.a(b, new ev(em.a(a), em.b(a), em.c(a)));
                        try
                        {
                            em.d(b).d();
                        }
                        catch (InterruptedException interruptedexception)
                        {
                            Log.e(em.e(), "Interrupted initing js engine");
                        }
                        em.e();
                        if (c != null)
                        {
                            em.e();
                            (new StringBuilder("js exec init countdown using latch: ")).append(c.hashCode()).append(" with count: ").append(c.getCount());
                            c.countDown();
                        }
                    }

            
            {
                a = em.this;
                super(em2, countdownlatch);
            }
                });
                try
                {
                    if (countdownlatch.await(10L, TimeUnit.SECONDS))
                    {
                        break label0;
                    }
                    l = true;
                    Log.e(i, (new StringBuilder("initJSExecutor no response from UI thread before timeout using init latch: ")).append(countdownlatch.hashCode()).append(" with count: ").append(countdownlatch.getCount()).toString());
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Log.e(i, "Interrupted initing js engine");
                    return false;
                }
                return false;
            }
            context = i;
        }
        return true;
    }

    final void b()
    {
        int i1 = 1;
        if (o == null) goto _L2; else goto _L1
_L1:
        String s = i;
        (new StringBuilder("waiting for getBrowserInfo to finished, latch: ")).append(o.getCount()).append(" - ").append(o.hashCode());
        if (!o.await(10L, TimeUnit.SECONDS)) goto _L4; else goto _L3
_L3:
        if (!ev.b() && !ev.a()) goto _L2; else goto _L5
_L5:
        if ((p & 0x20) == 0 || m.c.size() <= 0) goto _L7; else goto _L6
_L6:
        Object obj = (String)m.c.get(0);
        if (obj == null) goto _L9; else goto _L8
_L8:
        if (((String) (obj)).isEmpty()) goto _L9; else goto _L10
_L10:
        a(((String) (obj)));
_L17:
        if (Thread.currentThread().isInterrupted() || (p & 4) == 0 || m.c.size() <= i1) goto _L2; else goto _L11
_L11:
        obj = (String)m.c.get(i1);
        i1++;
        if (obj == null) goto _L13; else goto _L12
_L12:
        StringBuilder stringbuilder;
        boolean flag;
        try
        {
            flag = ((String) (obj)).isEmpty();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(i, "getBrowserInfo interrupted", ((Throwable) (obj)));
            return;
        }
        if (flag) goto _L13; else goto _L14
_L14:
        f = Integer.parseInt(((String) (obj)));
_L18:
        if (f > 0 && m.c.size() > i1)
        {
            g = (String)m.c.get(i1);
        }
        if (g == null) goto _L16; else goto _L15
_L15:
        h = ff.b(g);
        obj = i;
        (new StringBuilder("Got:")).append(g);
_L19:
        obj = i;
        stringbuilder = (new StringBuilder("Got mime ")).append(f).append(":");
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_440;
        }
        obj = g;
_L20:
        stringbuilder.append(((String) (obj)));
        return;
_L9:
        d = "";
          goto _L17
        obj;
        Log.e(i, "failed to convert", ((Throwable) (obj)));
_L13:
        f = 0;
          goto _L18
_L16:
        h = "";
          goto _L19
_L4:
        Log.e(i, (new StringBuilder("getBrowserInfo no response from UI thread before timeout using latch: ")).append(o.hashCode()).append(" with count: ").append(o.getCount()).toString());
        l = true;
        return;
_L7:
        i1 = 0;
          goto _L17
_L2:
        return;
        obj = "";
          goto _L20
    }

    final boolean c()
    {
        boolean flag;
        if (n != null && !l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag && k;
    }

    final void d()
    {
        int i1 = 1;
        byte byte0 = 1;
        Object obj;
        Handler handler;
        ew ew1;
        boolean flag;
        if (ev.b() || ev.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if ((p & 0x20) != 0)
            {
                byte0 = 2;
            }
            i1 = byte0;
            if ((p & 4) != 0)
            {
                i1 = byte0 + 2;
            }
        }
        o = new CountDownLatch(i1);
        handler = new Handler(Looper.getMainLooper());
        obj = i;
        (new StringBuilder("Firing off getBrowserInfo on UI thread using latch: ")).append(o.hashCode()).append(" with count: ").append(i1);
        ew1 = m;
        if (flag)
        {
            obj = o;
        } else
        {
            obj = null;
        }
        ew1.a(((CountDownLatch) (obj)));
        handler.post(new a(this, o) {

            final em a;

            public final void run()
            {
                try
                {
                    em.e();
                    em.e(b);
                }
                catch (InterruptedException interruptedexception)
                {
                    em.e();
                }
                if (c != null)
                {
                    em.e();
                    (new StringBuilder("getBrowserInfo countdown using latch: ")).append(c.hashCode()).append(" with count: ").append(c.getCount());
                    c.countDown();
                }
            }

            
            {
                a = em.this;
                super(em2, countdownlatch);
            }
        });
    }

}

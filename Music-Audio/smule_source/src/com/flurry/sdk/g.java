// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.AdSpaceLayout;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            cp, r, ap, ea, 
//            aw, co, gd, ed, 
//            a, b, ax, cu, 
//            cv, fp, au, hp, 
//            i, f, ba, az, 
//            cd, ce, ay, hq

public class g
{

    private static final String b = com/flurry/sdk/g.getSimpleName();
    cp a;
    private boolean c;

    public g()
    {
        a = new cp();
    }

    private void a(Context context, r r1)
    {
        ap ap1 = r1.k();
        if (ap1.l())
        {
            ea ea1 = new ea();
            co.a(aw.O, Collections.emptyMap(), context, r1, ap1, 0);
            ea1.e = ea.a.b;
            ea1.b();
            return;
        } else
        {
            co.a(aw.O, Collections.emptyMap(), context, r1, ap1, 0);
            return;
        }
    }

    static void a(g g1, Context context, r r1)
    {
        g1.a(context, r1);
    }

    static void a(g g1, r r1, String s, boolean flag, boolean flag1)
    {
        g1.a(r1, s, flag, flag1);
    }

    private void a(r r1, String s, boolean flag, boolean flag1)
    {
        ea ea1 = new ea();
        ea1.e = ea.a.a;
        ea1.a = r1;
        ea1.b = s;
        ea1.c = flag;
        ea1.d = flag1;
        ea1.b();
    }

    static String c()
    {
        return b;
    }

    private void e(a a1, int i1)
    {
        gd.a(3, b, "notify user");
        ed ed1 = new ed();
        ed1.b = a1;
        ed1.c = i1;
        ed1.a = ed.a.a;
        ed1.b();
    }

    private void f(a a1, int i1)
    {
        r r1;
        ap ap1;
        ax ax1;
        Object obj;
        boolean flag;
label0:
        {
            r1 = a1.c().b();
            ap1 = a1.c().c();
            flag = o(a1);
            gd.a(3, b, (new StringBuilder()).append("goToFrame: triggering event = ").append(a1.c().a()).toString());
            if (i1 != ap1.c() && i1 < ap1.a().adFrames.size())
            {
                gd.a(3, b, (new StringBuilder()).append("goToFrame: currentIndex = ").append(ap1.c()).append(" and go to index: ").append(i1).toString());
                obj = (AdFrame)ap1.a().adFrames.get(i1);
                ax1 = ap1.k();
                obj = ((AdFrame) (obj)).adSpaceLayout.format;
                if (((String) (obj)).equalsIgnoreCase(ax1.toString()))
                {
                    break label0;
                }
                gd.a(3, b, (new StringBuilder()).append("goToFrame: Moving now from ").append(ax1.toString()).append(" to format ").append(((String) (obj))).toString());
                if (((String) (obj)).equalsIgnoreCase(ax.b.toString()))
                {
                    ap1.a(i1);
                    cu.a(a1.c().a(), r1, true, flag);
                }
            }
            return;
        }
        gd.a(3, b, (new StringBuilder()).append("goToFrame: Already a takeover Ad, just move to next frame. ").append(ax1.toString()).append(" to format ").append(((String) (obj))).toString());
        ap1.a(i1);
        a(r1, null, true, flag);
    }

    private void i(a a1)
    {
        String s = (String)a1.c().b.get("requiresCallComplete");
        if (!TextUtils.isEmpty(s) && s.equals("true"))
        {
            gd.a(3, b, "Fire call complete");
            ed ed1 = new ed();
            ed1.b = a1;
            ed1.a = ed.a.e;
            ed1.b();
        }
    }

    private void j(a a1)
    {
        boolean flag1 = true;
        Context context = a1.c().a();
        r r1 = a1.c().b();
        ap ap1 = a1.c().c();
        boolean flag2 = o(a1);
        String s = a1.a("url");
        if (!TextUtils.isEmpty(s))
        {
            if (cv.d(s))
            {
                cu.a(context, s);
                return;
            }
            boolean flag3 = "true".equals(a1.a("native"));
            boolean flag;
            if (!"true".equals(a1.a("is_privacy")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag3)
            {
                gd.a(2, b, "Explictly instructed to use native browser");
                cu.a(context, a.a(a1, s), flag2);
                return;
            }
            ap1.a(true);
            if (ap1.r())
            {
                a(r1, s, flag, flag2);
                return;
            }
            if (flag3)
            {
                flag1 = false;
            }
            a(context, s, flag1, r1, flag, flag2);
            return;
        } else
        {
            gd.a(6, b, (new StringBuilder()).append("failed to perform directOpen action: no url in ").append(a1.c().a).toString());
            return;
        }
    }

    private void k(a a1)
    {
        Context context = a1.c().a();
        r r1 = a1.c().b();
        ap ap1 = a1.c().c();
        boolean flag1 = o(a1);
        String s = a1.a("url");
        if (!TextUtils.isEmpty(s))
        {
            if (cv.d(s))
            {
                cu.a(context, s);
                return;
            }
            boolean flag2 = "true".equals(a1.a("native"));
            boolean flag;
            if (!"true".equals(a1.a("is_privacy")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag2)
            {
                gd.a(2, b, "Explictly instructed to use native browser");
                cu.a(context, a.a(a1, s), flag1);
                return;
            }
            ap1.a(true);
            if (ap1.r())
            {
                a(r1, s, flag, flag1);
                return;
            } else
            {
                cu.a(context, r1, s, flag, flag1);
                return;
            }
        } else
        {
            gd.a(6, b, (new StringBuilder()).append("failed to perform directOpen action: no url in ").append(a1.c().a).toString());
            return;
        }
    }

    private void l(a a1)
    {
        gd.a(3, b, "closing ad");
        ed ed1 = new ed();
        ed1.b = a1;
        ed1.c = 0;
        ed1.a = ed.a.d;
        ed1.b();
    }

    private void m(a a1)
    {
        gd.a(3, b, "expanding ad");
        ed ed1 = new ed();
        ed1.b = a1;
        ed1.c = 0;
        ed1.a = ed.a.c;
        ed1.b();
    }

    private void n(a a1)
    {
        gd.a(3, b, "closing ad");
        ed ed1 = new ed();
        ed1.b = a1;
        ed1.c = 0;
        ed1.a = ed.a.b;
        ed1.b();
    }

    private boolean o(a a1)
    {
        boolean flag = false;
        a1 = a1.a("sendYCookies");
        if (!TextUtils.isEmpty(a1))
        {
            try
            {
                flag = Boolean.parseBoolean(a1);
            }
            catch (Exception exception)
            {
                gd.a(6, b, (new StringBuilder()).append("caught Exception with sendYCookies parameter in onProcessRedirect:").append(a1).toString());
                return false;
            }
        }
        return flag;
    }

    public void a()
    {
        c = b(((String) (null)));
    }

    public void a(Context context, String s, boolean flag, r r1)
    {
        if (context == null)
        {
            gd.a(5, b, "Cannot process redirect, null context");
            return;
        } else
        {
            a(context, s, flag, r1, false, false);
            return;
        }
    }

    public void a(Context context, String s, boolean flag, r r1, boolean flag1, boolean flag2)
    {
        if (context == null)
        {
            gd.a(5, b, "Unable to launch url, null context");
            return;
        } else
        {
            fp.a().b(new hq(s, context, flag1, r1, flag2, flag) {

                final String a;
                final Context b;
                final boolean c;
                final r d;
                final boolean e;
                final boolean f;
                final g g;

                public void safeRun()
                {
label0:
                    {
                        String s1;
                        boolean flag4;
label1:
                        {
                            if (TextUtils.isEmpty(a))
                            {
                                break label0;
                            }
                            s1 = cv.a(a);
                            if (!TextUtils.isEmpty(s1))
                            {
                                flag4 = false;
                                if (cv.d(s1))
                                {
                                    flag4 = cu.a(b, s1);
                                }
                                boolean flag3 = flag4;
                                if (!flag4)
                                {
                                    flag3 = flag4;
                                    if (cv.f(s1))
                                    {
                                        flag3 = cu.b(b, s1);
                                    }
                                }
                                flag4 = flag3;
                                if (!flag3)
                                {
                                    flag4 = flag3;
                                    if (cv.e(s1))
                                    {
                                        flag4 = cu.c(b, s1);
                                    }
                                }
                                if (!flag4 || !c)
                                {
                                    break label1;
                                }
                                g.a(g, b, d);
                            }
                            return;
                        }
                        ap ap1 = d.k();
                        if (!flag4 && ap1.r())
                        {
                            g.a(g, d, s1, c, e);
                            return;
                        }
                        if (!flag4 && f)
                        {
                            cu.a(b, d, s1, c, e);
                            return;
                        } else
                        {
                            cu.a(b, s1, e);
                            return;
                        }
                    }
                    gd.a(6, g.c(), (new StringBuilder()).append("Failed to launch: ").append(a).toString());
                }

            
            {
                g = g.this;
                a = s;
                b = context;
                c = flag;
                d = r1;
                e = flag1;
                f = flag2;
                super();
            }
            });
            return;
        }
    }

    void a(a a1)
    {
        boolean flag1 = true;
        Context context = a1.c().a();
        r r1 = a1.c().b();
        ap ap1 = a1.c().c();
        boolean flag2 = o(a1);
        String s = a1.a("url");
        if (!TextUtils.isEmpty(s))
        {
            if (cv.d(s))
            {
                cu.a(context, s);
                return;
            }
            boolean flag3 = "true".equals(a1.a("native"));
            boolean flag;
            if (!"true".equals(a1.a("is_privacy")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag3)
            {
                gd.a(2, b, "Explictly instructed to use native browser");
                cu.a(context, a.a(a1, s), flag2);
                return;
            }
            a1 = a.a(a1, s);
            if (ap1.r())
            {
                a(r1, ((String) (a1)), flag, flag2);
                return;
            }
            if (flag3)
            {
                flag1 = false;
            }
            a(context, ((String) (a1)), flag1, r1, flag, flag2);
            return;
        } else
        {
            gd.a(6, b, (new StringBuilder()).append("failed to perform directOpen action: no url in ").append(a1.c().a).toString());
            return;
        }
    }

    public void a(a a1, int i1)
    {
        aw aw1;
        aw1 = null;
        if (a1.c() != null)
        {
            aw1 = a1.c().a;
        }
        gd.a(3, b, (new StringBuilder()).append("performAction:action=").append(a1.toString()).toString());
        if (i1 > 10)
        {
            gd.a(5, b, (new StringBuilder()).append("Maximum depth for event/action loop exceeded when performing action:").append(a1.toString()).toString());
            return;
        }
        class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[au.values().length];
                try
                {
                    a[au.l.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    a[au.t.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    a[au.u.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    a[au.n.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    a[au.d.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    a[au.h.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    a[au.q.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    a[au.i.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    a[au.j.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[au.c.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[au.e.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[au.f.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[au.o.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[au.p.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[au.g.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[au.b.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[au.r.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[au.s.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2.a[a1.a().ordinal()];
        JVM INSTR tableswitch 1 18: default 180
    //                   1 226
    //                   2 234
    //                   3 242
    //                   4 250
    //                   5 258
    //                   6 266
    //                   7 275
    //                   8 283
    //                   9 291
    //                   10 298
    //                   11 306
    //                   12 314
    //                   13 323
    //                   14 332
    //                   15 340
    //                   16 348
    //                   17 357
    //                   18 365;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L1:
        gd.a(5, b, (new StringBuilder()).append("Unknown action:").append(a1.a()).append(",triggered by:").append(aw1).toString());
_L21:
        i(a1);
        return;
_L2:
        a(a1);
        continue; /* Loop/switch isn't completed */
_L3:
        k(a1);
        continue; /* Loop/switch isn't completed */
_L4:
        j(a1);
        continue; /* Loop/switch isn't completed */
_L5:
        b(a1);
        continue; /* Loop/switch isn't completed */
_L6:
        c(a1);
        continue; /* Loop/switch isn't completed */
_L7:
        b(a1, i1);
        continue; /* Loop/switch isn't completed */
_L8:
        d(a1);
        continue; /* Loop/switch isn't completed */
_L9:
        e(a1);
        continue; /* Loop/switch isn't completed */
_L10:
        b();
        continue; /* Loop/switch isn't completed */
_L11:
        f(a1);
        continue; /* Loop/switch isn't completed */
_L12:
        g(a1);
        continue; /* Loop/switch isn't completed */
_L13:
        c(a1, i1);
        continue; /* Loop/switch isn't completed */
_L14:
        d(a1, i1);
        continue; /* Loop/switch isn't completed */
_L15:
        h(a1);
        continue; /* Loop/switch isn't completed */
_L16:
        n(a1);
        continue; /* Loop/switch isn't completed */
_L17:
        e(a1, i1);
        continue; /* Loop/switch isn't completed */
_L18:
        m(a1);
        continue; /* Loop/switch isn't completed */
_L19:
        l(a1);
        if (true) goto _L21; else goto _L20
_L20:
    }

    boolean a(String s)
    {
        s = fp.a().e().getLaunchIntentForPackage(s);
        return s != null && hp.a(s);
    }

    boolean a(String s, String s1)
    {
        s1 = new Intent(s1);
        s1.setData(Uri.parse(s));
        return hp.a(s1);
    }

    void b()
    {
        com.flurry.sdk.i.a().r();
    }

    void b(a a1)
    {
        r r1 = a1.c().b();
        a1 = a1.a("groupId");
        if (!TextUtils.isEmpty(a1))
        {
            r1.a(a1);
        }
    }

    void b(a a1, int i1)
    {
        Context context = a1.c().a();
        r r1 = a1.c().b();
        ap ap1 = a1.c().c();
        a1 = a1.a("url");
        if (!TextUtils.isEmpty(a1))
        {
            if (a(a1))
            {
                a1 = aw.n;
            } else
            {
                a1 = aw.o;
            }
            com.flurry.sdk.f.a().a(a1.a(), 1);
            co.a(a1, Collections.emptyMap(), context, r1, ap1, i1 + 1);
        }
    }

    boolean b(String s)
    {
        String s2 = fp.a().c().getPackageName();
        String s1 = s;
        if (s == null)
        {
            s1 = (new StringBuilder()).append("market://details?id=").append(s2).toString();
        }
        return a(s1, "android.intent.action.VIEW");
    }

    void c(a a1)
    {
        Context context;
        r r1;
        String s;
        context = a1.c().a();
        r1 = a1.c().b();
        s = a1.a("url");
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        String s1 = a1.a("sendYCookies");
        if (TextUtils.isEmpty(s1)) goto _L4; else goto _L3
_L3:
        boolean flag = Boolean.parseBoolean(s1);
_L5:
        s1 = a1.a("native");
        if (TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_198;
        }
        boolean flag1 = Boolean.parseBoolean(s1);
_L6:
        if (!TextUtils.isEmpty(s))
        {
            a1 = cv.a(a.a(a1, s));
            if (!TextUtils.isEmpty(a1))
            {
                Exception exception;
                if (!flag1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                a(context, a1, flag1, r1, true, flag);
            }
        }
_L2:
        return;
        exception;
        gd.a(6, b, (new StringBuilder()).append("caught Exception with sendYCookies parameter in onProcessRedirect:").append(s1).toString());
_L4:
        flag = false;
          goto _L5
        exception;
        gd.a(6, b, (new StringBuilder()).append("caught Exception with useNative parameter in onProcessRedirect:").append(s1).toString());
        flag1 = false;
          goto _L6
    }

    void c(a a1, int i1)
    {
        if (i1 > 10)
        {
            gd.a(5, b, (new StringBuilder()).append("Maximum depth for event/action loop exceeded when performing action:").append(a1.toString()).toString());
            return;
        }
        String s = a1.a("delay");
        long l2 = 30L;
        long l1 = l2;
        if (!TextUtils.isEmpty(s))
        {
            try
            {
                l1 = Long.parseLong(s);
            }
            catch (Exception exception)
            {
                gd.a(6, b, (new StringBuilder()).append("caught Exception with delay parameter in nextAdUnit:").append(s).toString());
                l1 = l2;
            }
        }
        a1.c().b().a(a1.c().c(), l1 * 1000L);
    }

    void d(a a1)
    {
        Context context = a1.c().a();
        boolean flag = o(a1);
        String s = a1.a("package");
        if (!TextUtils.isEmpty(s))
        {
            cu.a(context, s, a1.c().b(), flag);
        }
    }

    void d(a a1, int i1)
    {
        Context context = a1.c().a();
        String s = a1.a("idHash");
        if (!TextUtils.isEmpty(s))
        {
            ba ba1 = com.flurry.sdk.i.a().k();
            Iterator iterator = ba1.a(s).iterator();
            while (iterator.hasNext()) 
            {
                Object obj2 = (az)iterator.next();
                Object obj1 = aw.C;
                Object obj = obj2;
                if (obj2 != null)
                {
                    obj = obj2;
                    if (ba1.a(((az) (obj2)).e()))
                    {
                        gd.a(4, b, (new StringBuilder()).append("Discarding expired frequency cap info for id=").append(s).toString());
                        ba1.a(((az) (obj2)).b(), s);
                        obj = null;
                    }
                }
                if (obj != null && ((az) (obj)).j() >= ((az) (obj)).g())
                {
                    gd.a(4, b, (new StringBuilder()).append("Frequency cap exhausted for id=").append(s).toString());
                    obj = aw.B;
                } else
                {
                    obj = obj1;
                }
                com.flurry.sdk.f.a().a(((aw) (obj)).a(), 1);
                obj1 = a1.c().b();
                obj2 = a1.c().c();
                co.a(((aw) (obj)), Collections.emptyMap(), context, ((r) (obj1)), ((ap) (obj2)), i1 + 1);
            }
        }
    }

    void e(a a1)
    {
        String s = a1.a("url");
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        String s1;
        long l1;
        long l2;
        l2 = 60000L + System.currentTimeMillis();
        s1 = a1.a("expirationTimeEpochSeconds");
        l1 = l2;
        if (TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_64;
        }
        long l3;
        l1 = System.currentTimeMillis();
        l3 = Long.parseLong(s1);
        l1 += l3 * 1000L;
_L3:
        boolean flag1 = false;
        s1 = a1.a("sendYCookies");
        boolean flag = flag1;
        Exception exception;
        if (!TextUtils.isEmpty(s1))
        {
            try
            {
                flag = Boolean.parseBoolean(s1);
            }
            catch (Exception exception1)
            {
                gd.a(6, b, (new StringBuilder()).append("caught Exception with sendYCookies parameter in onSendUrlAsync:").append(s1).toString());
                flag = flag1;
            }
        }
        a1 = new cd(a1.c().a.a(), a1.c().d().adGuid, a.a(a1, s), l1, flag);
        com.flurry.sdk.i.a().i().b(a1);
_L2:
        return;
        exception;
        gd.a(6, b, (new StringBuilder()).append("caught Exception with expirationTime parameter in onSendUrlAsync:").append(s1).toString());
        l1 = l2;
          goto _L3
    }

    void f(a a1)
    {
        String s;
        aw aw1;
        boolean flag;
        if (a1.b().containsKey("__sendToServer") && a1.a("__sendToServer").equals("true"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a1.b("__sendToServer");
        s = a1.c().c().e();
        aw1 = a1.c().a;
        a1 = a1.b();
        gd.a(3, b, (new StringBuilder()).append("onLogEvent(").append(s).append(", ").append(aw1).append(", ").append(flag).append(", ").append(a1).append(")").toString());
        com.flurry.sdk.i.a().a(s, aw1, flag, a1);
    }

    void g(a a1)
    {
        ap ap1;
        String s;
        int i1;
        int j1;
        ap1 = a1.c().c();
        j1 = ap1.c() + 1;
        s = a1.a("offset");
        i1 = j1;
        if (s == null) goto _L2; else goto _L1
_L1:
        i1 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 64
    //                   3377907: 102
    //                   1126940025: 118;
           goto _L3 _L4 _L5
_L3:
        i1;
        JVM INSTR tableswitch 0 1: default 88
    //                   0 134
    //                   1 101;
           goto _L6 _L7 _L8
_L6:
        try
        {
            i1 = Integer.parseInt(s);
        }
        catch (Exception exception)
        {
            gd.a(6, b, (new StringBuilder()).append("caught: ").append(exception.getMessage()).toString());
            i1 = j1;
        }
_L2:
        f(a1, i1);
_L8:
        return;
_L4:
        if (s.equals("next"))
        {
            i1 = 0;
        }
          goto _L3
_L5:
        if (s.equals("current"))
        {
            i1 = 1;
        }
          goto _L3
_L7:
        i1 = ap1.c() + 1;
          goto _L2
    }

    void h(a a1)
    {
        Object obj = a1.a("idHash");
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj = com.flurry.sdk.i.a().k().a(((String) (obj))).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                az az1 = (az)((Iterator) (obj)).next();
                az1.a();
                gd.a(4, b, (new StringBuilder()).append("updateViewCount:capType=").append(az1.b()).append(",id=").append(az1.c()).append(",capRemaining=").append(az1.g()).append(",totalCap=").append(az1.h()).append(",views=").append(az1.j()).toString());
                if (az1.j() >= az1.g())
                {
                    Object obj1 = a1.c().e().adSpace;
                    if (az1.j() > az1.g())
                    {
                        gd.a(6, b, (new StringBuilder()).append("FlurryAdAction: !! rendering a capped object for id: ").append(az1.c()).append(" for adspace: ").append(((String) (obj1))).toString());
                    } else
                    {
                        gd.a(4, b, (new StringBuilder()).append("FlurryAdAction: hit cap for id: ").append(az1.c()).append(" for adspace: ").append(((String) (obj1))).toString());
                    }
                    obj1 = new ay();
                    obj1.a = az1;
                    ((ay) (obj1)).b();
                }
            } while (true);
        }
    }

}

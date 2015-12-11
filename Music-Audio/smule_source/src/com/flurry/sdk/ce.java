// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            go, fw, fp, cd, 
//            i, aw, gd, gk, 
//            n, fn, hp, gn, 
//            ha, gw, gx, cv

public class ce extends go
{

    private static final String a = com/flurry/sdk/ce.getSimpleName();
    private final fw b = new fw(fp.a().c().getFileStreamPath(".yflurryreporter"), ".yflurryreporter", 2, new ha() {

        final ce a;

        public gx a(int j)
        {
            if (j > 1)
            {
                return new gw(new cd.a());
            } else
            {
                return new gw(new cd.b());
            }
        }

            
            {
                a = ce.this;
                super();
            }
    });

    public ce()
    {
    }

    static String a()
    {
        return a;
    }

    private void a(cd cd1, int j)
    {
        if (cd1 == null)
        {
            return;
        } else
        {
            HashMap hashmap = new HashMap();
            hashmap.put("event", cd1.a());
            hashmap.put("url", cd1.g());
            hashmap.put("response", (new StringBuilder()).append(j).append("").toString());
            i.a().a(cd1.b(), aw.J, true, hashmap);
            return;
        }
    }

    static void a(ce ce1, cd cd1, int j)
    {
        ce1.a(cd1, j);
    }

    static void a(ce ce1, gn gn)
    {
        ce1.c(gn);
    }

    static void b(ce ce1, gn gn)
    {
        ce1.c(gn);
    }

    static void c(ce ce1, gn gn)
    {
        ce1.d(gn);
    }

    protected void a(cd cd1)
    {
        gd.a(3, a, (new StringBuilder()).append("Sending next report for original url: ").append(cd1.g()).append(" to current url:").append(cd1.h()).toString());
        gk gk1 = new gk();
        gk1.a(cd1.h());
        gk1.a(0x186a0);
        gk1.a(gl.a.b);
        gk1.a(false);
        if (cd1.c())
        {
            gk1.a("Cookie", i.a().h().d());
        }
        gk1.a(new gk.a(cd1) {

            final cd a;
            final ce b;

            public volatile void a(gk gk2, Object obj)
            {
                a(gk2, (Void)obj);
            }

            public void a(gk gk2, Void void1)
            {
                gd.a(3, ce.a(), (new StringBuilder()).append("AsyncReportInfo request: HTTP status code is:").append(gk2.e()).toString());
                int j = gk2.e();
                if (j >= 200 && j < 300)
                {
                    gd.a(3, ce.a(), (new StringBuilder()).append("Send report successful to url: ").append(gk2.a()).toString());
                    ce.a(b, a);
                    if (gd.c() <= 3 && gd.d())
                    {
                        fp.a().a(new Runnable(this, gk2) {

                            final gk a;
                            final _cls2 b;

                            public void run()
                            {
                                Toast.makeText(fp.a().c(), (new StringBuilder()).append("ADS AR HTTP Response Code: ").append(a.e()).append(" for url: ").append(a.a()).toString(), 1).show();
                            }

            
            {
                b = _pcls2;
                a = gk1;
                super();
            }
                        });
                    }
                    ce.a(b, a, j);
                } else
                {
                    if (j >= 300 && j < 400)
                    {
                        Object obj = null;
                        List list = gk2.b("Location");
                        void1 = obj;
                        if (list != null)
                        {
                            void1 = obj;
                            if (list.size() > 0)
                            {
                                void1 = cv.b((String)list.get(0), a.h());
                            }
                        }
                        if (TextUtils.isEmpty(void1))
                        {
                            gd.a(3, ce.a(), (new StringBuilder()).append("Send report successful to url: ").append(gk2.a()).toString());
                            ce.b(b, a);
                            if (gd.c() <= 3 && gd.d())
                            {
                                fp.a().a(new Runnable(this, gk2) {

                                    final gk a;
                                    final _cls2 b;

                                    public void run()
                                    {
                                        Toast.makeText(fp.a().c(), (new StringBuilder()).append("ADS AR HTTP Response Code: ").append(a.e()).append(" for url: ").append(a.a()).toString(), 1).show();
                                    }

            
            {
                b = _pcls2;
                a = gk1;
                super();
            }
                                });
                            }
                            ce.a(b, a, j);
                            return;
                        } else
                        {
                            gd.a(3, ce.a(), (new StringBuilder()).append("Send report redirecting to url: ").append(void1).toString());
                            a.c(void1);
                            b.a(a);
                            return;
                        }
                    }
                    gd.a(3, ce.a(), (new StringBuilder()).append("Send report failed to url: ").append(gk2.a()).toString());
                    ce.c(b, a);
                    if (a.f() == 0)
                    {
                        ce.a(b, a, j);
                        return;
                    }
                }
            }

            
            {
                b = ce.this;
                a = cd1;
                super();
            }
        });
        fn.a().a(this, gk1);
    }

    protected volatile void a(gn gn)
    {
        a((cd)gn);
    }

    protected void a(List list)
    {
        this;
        JVM INSTR monitorenter ;
        List list1;
        hp.b();
        list1 = (List)b.a();
        if (list1 == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        list.addAll(list1);
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        throw list;
    }

    protected void b(List list)
    {
        this;
        JVM INSTR monitorenter ;
        hp.b();
        list = new ArrayList(list);
        b.a(list);
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        throw list;
    }

}

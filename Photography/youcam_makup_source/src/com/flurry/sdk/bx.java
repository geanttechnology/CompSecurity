// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.flurry.android.FlurryAgent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            fd, fe, eq, ex, 
//            eh, ei, ep, cd, 
//            cl, en

public class bx
    implements cl.a, ei.a, fd, Thread.UncaughtExceptionHandler
{

    private static final String a = com/flurry/sdk/bx.getSimpleName();
    private static bx b;
    private String c;
    private boolean d;
    private cl e;
    private Map f;
    private cd g;

    private bx()
    {
        c = "";
        f = new HashMap();
        fe.a().a(this);
        eq.a().a(this);
        p();
    }

    public static bx a()
    {
        if (b == null)
        {
            b = new bx();
        }
        return b;
    }

    private Map b(Context context)
    {
        Object obj = null;
        HashMap hashmap = obj;
        if (context instanceof Activity)
        {
            Bundle bundle = ((Activity)context).getIntent().getExtras();
            hashmap = obj;
            if (bundle != null)
            {
                ex.a(3, a, (new StringBuilder()).append("Launch Options Bundle is present ").append(bundle.toString()).toString());
                hashmap = new HashMap();
                Iterator iterator = bundle.keySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s = (String)iterator.next();
                    if (s != null)
                    {
                        context = ((Context) (bundle.get(s)));
                        if (context != null)
                        {
                            context = context.toString();
                        } else
                        {
                            context = "null";
                        }
                        hashmap.put(s, new ArrayList(Arrays.asList(new String[] {
                            context
                        })));
                        ex.a(3, a, (new StringBuilder()).append("Launch options Key: ").append(s).append(". Its value: ").append(context).toString());
                    }
                } while (true);
            }
        }
        return hashmap;
    }

    public static int m()
    {
        return 0;
    }

    private void p()
    {
        ei ei1 = eh.a();
        d = ((Boolean)ei1.a("CaptureUncaughtExceptions")).booleanValue();
        ei1.a("CaptureUncaughtExceptions", this);
        ex.a(4, a, (new StringBuilder()).append("initSettings, CrashReportingEnabled = ").append(d).toString());
        String s = (String)ei1.a("VesionName");
        ei1.a("VesionName", this);
        ep.a(s);
        ex.a(4, a, (new StringBuilder()).append("initSettings, VersionName = ").append(s).toString());
    }

    private void q()
    {
        if (g == null)
        {
            g = new cd();
        }
    }

    public void a(Context context)
    {
        context = h();
        if (context != null)
        {
            context.d();
        }
    }

    public void a(Context context, String s)
    {
        fe.a().b();
        en.a().b();
        q();
        if (f.isEmpty())
        {
            en.a().c();
        }
        if (f.containsKey(s))
        {
            context = (cl)f.get(s);
        } else
        {
            cl cl1 = new cl(context, s, this);
            cl1.a(b(context));
            f.put(s, cl1);
            context = cl1;
        }
        context.c();
        a(((cl) (context)));
    }

    void a(cl cl1)
    {
        e = cl1;
    }

    public void a(String s)
    {
        cl cl1 = h();
        if (cl1 != null)
        {
            cl1.a(s, null, false);
        }
    }

    public void a(String s, Object obj)
    {
        if (s.equals("CaptureUncaughtExceptions"))
        {
            d = ((Boolean)obj).booleanValue();
            ex.a(4, a, (new StringBuilder()).append("onSettingUpdate, CrashReportingEnabled = ").append(d).toString());
            return;
        }
        if (s.equals("VesionName"))
        {
            s = (String)obj;
            ep.a(s);
            ex.a(4, a, (new StringBuilder()).append("onSettingUpdate, VersionName = ").append(s).toString());
            return;
        } else
        {
            ex.a(6, a, "onSettingUpdate internal error!");
            return;
        }
    }

    public void a(String s, String s1, String s2)
    {
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        if (astacktraceelement != null && astacktraceelement.length > 2)
        {
            StackTraceElement astacktraceelement1[] = new StackTraceElement[astacktraceelement.length - 2];
            System.arraycopy(astacktraceelement, 2, astacktraceelement1, 0, astacktraceelement1.length);
            astacktraceelement = astacktraceelement1;
        }
        Throwable throwable = new Throwable(s1);
        throwable.setStackTrace(astacktraceelement);
        cl cl1 = h();
        if (cl1 != null)
        {
            cl1.a(s, s1, s2, throwable);
        }
    }

    public void a(String s, String s1, Throwable throwable)
    {
        cl cl1 = h();
        if (cl1 != null)
        {
            cl1.a(s, s1, throwable.getClass().getName(), throwable);
        }
    }

    public void a(String s, Map map)
    {
        cl cl1 = h();
        if (cl1 != null)
        {
            cl1.a(s, map, false);
        }
    }

    public void a(String s, Map map, boolean flag)
    {
        cl cl1 = h();
        if (cl1 != null)
        {
            cl1.a(s, map, flag);
        }
    }

    public void a(String s, boolean flag)
    {
        cl cl1 = h();
        if (cl1 != null)
        {
            cl1.a(s, null, flag);
        }
    }

    public void a(boolean flag)
    {
        ex.a(flag);
    }

    public int b()
    {
        int i1 = ((Integer)eh.a().a("AgentVersion")).intValue();
        ex.a(4, a, (new StringBuilder()).append("getAgentVersion() = ").append(i1).toString());
        return i1;
    }

    public void b(String s)
    {
        cl cl1 = h();
        if (cl1 != null)
        {
            cl1.a(s, null);
        }
    }

    public void b(String s, Map map)
    {
        cl cl1 = h();
        if (cl1 != null)
        {
            cl1.a(s, map);
        }
    }

    public void b(boolean flag)
    {
    }

    int c()
    {
        return 3;
    }

    public void c(String s)
    {
        cl cl1 = h();
        if (cl1 != null)
        {
            cl1.a(s, null, false);
        }
    }

    public void c(String s, Map map)
    {
        cl cl1 = h();
        if (cl1 != null)
        {
            cl1.a(s, map, false);
        }
    }

    int d()
    {
        return 3;
    }

    public void d(String s)
    {
        if (!f.containsKey(s))
        {
            ex.a(6, a, "Ended session is not in the session map! Maybe it was already destroyed.");
        } else
        {
            cl cl1 = h();
            if (cl1 != null && TextUtils.equals(cl1.k(), s))
            {
                a(((cl) (null)));
            }
            f.remove(s);
        }
        if (f.isEmpty())
        {
            ex.a(5, a, "LocationProvider is going to be unsubscribed");
            en.a().d();
        }
    }

    int e()
    {
        return 4;
    }

    String f()
    {
        return c;
    }

    public String g()
    {
        String s;
        if (f().length() > 0)
        {
            s = ".";
        } else
        {
            s = "";
        }
        return String.format(Locale.getDefault(), "Flurry_Android_%d_%d.%d.%d%s%s", new Object[] {
            Integer.valueOf(b()), Integer.valueOf(c()), Integer.valueOf(d()), Integer.valueOf(e()), s, f()
        });
    }

    public cl h()
    {
        return e;
    }

    public void i()
    {
        cl cl1 = h();
        if (cl1 != null)
        {
            cl1.g();
        }
    }

    public String j()
    {
        String s = null;
        cl cl1 = h();
        if (cl1 != null)
        {
            s = cl1.k();
        }
        return s;
    }

    public String k()
    {
        String s = null;
        cl cl1 = h();
        if (cl1 != null)
        {
            s = cl1.l();
        }
        return s;
    }

    public String l()
    {
        String s = null;
        cl cl1 = h();
        if (cl1 != null)
        {
            s = cl1.m();
        }
        return s;
    }

    public Location n()
    {
        return en.a().e();
    }

    public cd o()
    {
        return g;
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        throwable.printStackTrace();
        if (!d) goto _L2; else goto _L1
_L1:
        StackTraceElement astacktraceelement[];
        thread = "";
        astacktraceelement = throwable.getStackTrace();
        if (astacktraceelement == null || astacktraceelement.length <= 0) goto _L4; else goto _L3
_L3:
        thread = new StringBuilder();
        if (throwable.getMessage() != null)
        {
            thread.append((new StringBuilder()).append(" (").append(throwable.getMessage()).append(")\n").toString());
        }
        thread = thread.toString();
_L6:
        FlurryAgent.onError("uncaught", thread, throwable);
_L2:
        thread = (new HashMap(f)).values().iterator();
        do
        {
            if (!thread.hasNext())
            {
                break;
            }
            throwable = (cl)thread.next();
            if (throwable != null)
            {
                throwable.d();
                throwable.e();
            }
        } while (true);
        break; /* Loop/switch isn't completed */
_L4:
        if (throwable.getMessage() != null)
        {
            thread = throwable.getMessage();
        }
        if (true) goto _L6; else goto _L5
_L5:
        en.a().f();
        return;
    }

}

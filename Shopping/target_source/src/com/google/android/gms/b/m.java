// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.b;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.b:
//            j, cj, k, bq, 
//            l, dj

public class m extends Thread
{
    class a
    {

        final int a;
        final int b;
        final m c;

        a(int i1, int j1)
        {
            c = m.this;
            super();
            a = i1;
            b = j1;
        }
    }


    private boolean a;
    private boolean b;
    private final Object c;
    private final l d;
    private final k e;
    private final bq f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;

    a a(View view, j j1)
    {
        int i1 = 0;
        if (view == null)
        {
            return new a(0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText))
        {
            view = ((TextView)view).getText();
            if (!TextUtils.isEmpty(view))
            {
                j1.b(view.toString());
                return new a(1, 0);
            } else
            {
                return new a(0, 0);
            }
        }
        if ((view instanceof WebView) && !(view instanceof cj))
        {
            j1.d();
            if (a((WebView)view, j1))
            {
                return new a(0, 1);
            } else
            {
                return new a(0, 0);
            }
        }
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int k1 = 0;
            int l1 = 0;
            for (; i1 < view.getChildCount(); i1++)
            {
                a a1 = a(view.getChildAt(i1), j1);
                l1 += a1.a;
                k1 += a1.b;
            }

            return new a(l1, k1);
        } else
        {
            return new a(0, 0);
        }
    }

    void a(Activity activity)
    {
        if (activity != null)
        {
            Object obj = null;
            View view = obj;
            if (activity.getWindow() != null)
            {
                view = obj;
                if (activity.getWindow().getDecorView() != null)
                {
                    view = activity.getWindow().getDecorView().findViewById(0x1020002);
                }
            }
            if (view != null)
            {
                a(view);
                return;
            }
        }
    }

    void a(j j1, WebView webview, String s)
    {
        j1.c();
        if (!TextUtils.isEmpty(s))
        {
            s = JSONObjectInstrumentation.init(s).optString("text");
            if (TextUtils.isEmpty(webview.getTitle()))
            {
                break MISSING_BLOCK_LABEL_78;
            }
            j1.a((new StringBuilder()).append(webview.getTitle()).append("\n").append(s).toString());
        }
_L2:
        if (j1.a())
        {
            e.b(j1);
            return;
        }
        break MISSING_BLOCK_LABEL_109;
        j1.a(s);
        if (true) goto _L2; else goto _L1
_L1:
        j1;
        com.google.android.gms.ads.internal.util.client.b.a("Json string may be malformed.");
        return;
        j1;
        com.google.android.gms.ads.internal.util.client.b.a("Failed to get webview content.", j1);
        f.a(j1, true);
    }

    boolean a()
    {
        Context context;
        KeyguardManager keyguardmanager;
        Object obj;
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
        boolean flag;
        try
        {
            context = d.b();
        }
        catch (Throwable throwable)
        {
            return false;
        }
        if (context == null)
        {
            return false;
        }
        obj = (ActivityManager)context.getSystemService("activity");
        keyguardmanager = (KeyguardManager)context.getSystemService("keyguard");
        if (obj == null || keyguardmanager == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        obj = ((ActivityManager) (obj)).getRunningAppProcesses();
        if (obj == null)
        {
            return false;
        }
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_124;
            }
            runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
        } while (Process.myPid() != runningappprocessinfo.pid);
        if (!a(runningappprocessinfo) || keyguardmanager.inKeyguardRestrictedInputMode())
        {
            break MISSING_BLOCK_LABEL_124;
        }
        flag = a(context);
        if (flag)
        {
            return true;
        }
        return false;
        return false;
    }

    boolean a(android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo)
    {
        return runningappprocessinfo.importance == 100;
    }

    boolean a(Context context)
    {
        context = (PowerManager)context.getSystemService("power");
        if (context == null)
        {
            return false;
        } else
        {
            return context.isScreenOn();
        }
    }

    boolean a(View view)
    {
        if (view == null)
        {
            return false;
        } else
        {
            view.post(new _cls1(view));
            return true;
        }
    }

    boolean a(WebView webview, j j1)
    {
        if (!dj.e())
        {
            return false;
        } else
        {
            j1.d();
            webview.post(new _cls2(j1, webview));
            return true;
        }
    }

    public void b()
    {
        synchronized (c)
        {
            a = true;
            com.google.android.gms.ads.internal.util.client.b.a((new StringBuilder()).append("ContentFetchThread: paused, mPause = ").append(a).toString());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void b(View view)
    {
        j j1;
        j1 = new j(h, i, j, k);
        view = a(view, j1);
        j1.e();
        if (((a) (view)).a == 0 && ((a) (view)).b == 0)
        {
            return;
        }
        try
        {
            if ((((a) (view)).b != 0 || j1.f() != 0) && (((a) (view)).b != 0 || !e.a(j1)))
            {
                e.c(j1);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            com.google.android.gms.ads.internal.util.client.b.b("Exception in fetchContentOnUIThread", view);
            f.a(view, true);
        }
        return;
    }

    public void run()
    {
_L11:
        if (b)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!a()) goto _L2; else goto _L1
_L1:
        Object obj = d.a();
        if (obj != null) goto _L4; else goto _L3
_L3:
        try
        {
            com.google.android.gms.ads.internal.util.client.b.a("ContentFetchThread: no activity");
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.google.android.gms.ads.internal.util.client.b.b("Error in ContentFetchTask", ((Throwable) (obj)));
            f.a(((Throwable) (obj)), true);
        }
_L8:
        obj = c;
        obj;
        JVM INSTR monitorenter ;
_L7:
        boolean flag = a;
        if (!flag) goto _L6; else goto _L5
_L5:
        Exception exception;
        try
        {
            com.google.android.gms.ads.internal.util.client.b.a("ContentFetchTask: waiting");
            c.wait();
        }
        catch (InterruptedException interruptedexception) { }
        finally { }
        if (true) goto _L7; else goto _L6
_L4:
        a(((Activity) (obj)));
_L9:
        Thread.sleep(g * 1000);
          goto _L8
_L2:
        com.google.android.gms.ads.internal.util.client.b.a("ContentFetchTask: sleeping");
        b();
          goto _L9
_L6:
        obj;
        JVM INSTR monitorexit ;
        if (true) goto _L11; else goto _L10
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L10:
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}

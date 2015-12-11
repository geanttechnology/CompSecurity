// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.internal.gu;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class sy extends Thread
{

    private boolean a;
    private boolean b;
    private boolean c;
    private final Object d = new Object();
    private final sx e;
    private final sw f;
    private final ze g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;

    public sy(sx sx1, sw sw1, Bundle bundle, ze ze1)
    {
        a = false;
        b = false;
        c = false;
        e = sx1;
        f = sw1;
        g = ze1;
        i = bundle.getInt(ug.j.a());
        j = bundle.getInt(ug.k.a());
        k = bundle.getInt(ug.l.a());
        l = bundle.getInt(ug.m.a());
        h = bundle.getInt(ug.n.a(), 10);
        setName("ContentFetchTask");
    }

    private void a(Activity activity)
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

    private boolean a(WebView webview, sv sv1)
    {
        if (!aej.d())
        {
            return false;
        } else
        {
            sv1.e();
            webview.post(new Runnable(sv1, webview) {

                ValueCallback a;
                final sv b;
                final WebView c;
                final sy d;

                public void run()
                {
                    if (c.getSettings().getJavaScriptEnabled())
                    {
                        c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", a);
                    }
                }

            
            {
                d = sy.this;
                b = sv1;
                c = webview;
                super();
                a = new _cls1(this);
            }
            });
            return true;
        }
    }

    private boolean f()
    {
        KeyguardManager keyguardmanager;
        Object obj;
        Object obj1;
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
        boolean flag;
        try
        {
            obj = e.b();
        }
        catch (Throwable throwable)
        {
            return false;
        }
        if (obj == null)
        {
            return false;
        }
        obj1 = (ActivityManager)((Context) (obj)).getSystemService("activity");
        keyguardmanager = (KeyguardManager)((Context) (obj)).getSystemService("keyguard");
        obj = (PowerManager)((Context) (obj)).getSystemService("power");
        if (obj1 == null || keyguardmanager == null || obj == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        obj1 = ((ActivityManager) (obj1)).getRunningAppProcesses();
        if (obj1 == null)
        {
            return false;
        }
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break MISSING_BLOCK_LABEL_138;
            }
            runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj1)).next();
        } while (Process.myPid() != runningappprocessinfo.pid);
        if (runningappprocessinfo.importance != 100 || keyguardmanager.inKeyguardRestrictedInputMode())
        {
            break MISSING_BLOCK_LABEL_138;
        }
        flag = ((PowerManager) (obj)).isScreenOn();
        if (flag)
        {
            return true;
        }
        return false;
        return false;
    }

    sz a(View view, sv sv1)
    {
        int i1 = 0;
        if (view == null)
        {
            return new sz(this, 0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText))
        {
            sv1.b(((TextView)view).getText().toString());
            return new sz(this, 1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof gu))
        {
            sv1.e();
            if (a((WebView)view, sv1))
            {
                return new sz(this, 0, 1);
            } else
            {
                return new sz(this, 0, 0);
            }
        }
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int j1 = 0;
            int k1 = 0;
            for (; i1 < view.getChildCount(); i1++)
            {
                sz sz1 = a(view.getChildAt(i1), sv1);
                k1 += sz1.a;
                j1 += sz1.b;
            }

            return new sz(this, k1, j1);
        } else
        {
            return new sz(this, 0, 0);
        }
    }

    public void a()
    {
label0:
        {
            synchronized (d)
            {
                if (!a)
                {
                    break label0;
                }
                acb.a("Content hash thread already started, quiting...");
            }
            return;
        }
        a = true;
        obj;
        JVM INSTR monitorexit ;
        start();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void a(sv sv1, WebView webview, String s)
    {
        sv1.d();
        if (!TextUtils.isEmpty(s))
        {
            s = (new JSONObject(s)).optString("text");
            if (TextUtils.isEmpty(webview.getTitle()))
            {
                break MISSING_BLOCK_LABEL_84;
            }
            sv1.a((new StringBuilder()).append(webview.getTitle()).append("\n").append(s).toString());
        }
_L2:
        if (sv1.a())
        {
            f.b(sv1);
            return;
        }
        break MISSING_BLOCK_LABEL_116;
        sv1.a(s);
        if (true) goto _L2; else goto _L1
_L1:
        sv1;
        acb.a("Json string may be malformed.");
        return;
        sv1;
        acb.a("Failed to get webview content.", sv1);
        g.b(sv1);
    }

    boolean a(View view)
    {
        if (view == null)
        {
            return false;
        } else
        {
            view.post(new Runnable(view) {

                final View a;
                final sy b;

                public void run()
                {
                    b.b(a);
                }

            
            {
                b = sy.this;
                a = view;
                super();
            }
            });
            return true;
        }
    }

    public sv b()
    {
        return f.a();
    }

    void b(View view)
    {
        sv sv1;
        sv1 = new sv(i, j, k, l);
        view = a(view, sv1);
        sv1.f();
        if (((sz) (view)).a == 0 && ((sz) (view)).b == 0)
        {
            return;
        }
        try
        {
            if ((((sz) (view)).b != 0 || sv1.h() != 0) && (((sz) (view)).b != 0 || !f.a(sv1)))
            {
                f.c(sv1);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            acb.b("Exception in fetchContentOnUIThread", view);
            g.b(view);
        }
        return;
    }

    public void c()
    {
        synchronized (d)
        {
            b = false;
            d.notifyAll();
            acb.a("ContentFetchThread: wakeup");
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void d()
    {
        synchronized (d)
        {
            b = true;
            acb.a((new StringBuilder()).append("ContentFetchThread: paused, mPause = ").append(b).toString());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean e()
    {
        return b;
    }

    public void run()
    {
_L11:
        if (c)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!f()) goto _L2; else goto _L1
_L1:
        Object obj = e.a();
        if (obj != null) goto _L4; else goto _L3
_L3:
        try
        {
            acb.a("ContentFetchThread: no activity");
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            acb.b("Error in ContentFetchTask", ((Throwable) (obj)));
            g.b(((Throwable) (obj)));
        }
_L8:
        obj = d;
        obj;
        JVM INSTR monitorenter ;
_L7:
        boolean flag = b;
        if (!flag) goto _L6; else goto _L5
_L5:
        Exception exception;
        try
        {
            acb.a("ContentFetchTask: waiting");
            d.wait();
        }
        catch (InterruptedException interruptedexception) { }
        finally { }
        if (true) goto _L7; else goto _L6
_L4:
        a(((Activity) (obj)));
_L9:
        Thread.sleep(h * 1000);
          goto _L8
_L2:
        acb.a("ContentFetchTask: sleeping");
        d();
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

    // Unreferenced inner class sy$2$1

/* anonymous class */
    class _cls1
        implements ValueCallback
    {

        final _cls2 a;

        public void a(String s)
        {
            a.d.a(a.b, a.c, s);
        }

        public void onReceiveValue(Object obj)
        {
            a((String)obj);
        }

            
            {
                a = _pcls2;
                super();
            }
    }

}

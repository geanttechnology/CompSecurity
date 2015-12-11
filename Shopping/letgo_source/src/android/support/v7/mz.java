// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            nn, nj, mw, ul, 
//            mx, sd, vs, my

public class mz extends Thread
{
    class a
    {

        final int a;
        final int b;
        final mz c;

        a(int i1, int j1)
        {
            c = mz.this;
            super();
            a = i1;
            b = j1;
        }
    }


    private boolean a;
    private boolean b;
    private boolean c;
    private final Object d = new Object();
    private final my e;
    private final mx f;
    private final sd g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;

    public mz(my my1, mx mx1, sd sd1)
    {
        a = false;
        b = false;
        c = false;
        e = my1;
        f = mx1;
        g = sd1;
        i = ((Integer)nn.K.c()).intValue();
        j = ((Integer)nn.L.c()).intValue();
        k = ((Integer)nn.M.c()).intValue();
        l = ((Integer)nn.N.c()).intValue();
        h = ((Integer)nn.O.c()).intValue();
        setName("ContentFetchTask");
    }

    a a(View view, mw mw1)
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
                mw1.b(view.toString());
                return new a(1, 0);
            } else
            {
                return new a(0, 0);
            }
        }
        if ((view instanceof WebView) && !(view instanceof ul))
        {
            mw1.e();
            if (a((WebView)view, mw1))
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
            int j1 = 0;
            int k1 = 0;
            for (; i1 < view.getChildCount(); i1++)
            {
                a a1 = a(view.getChildAt(i1), mw1);
                k1 += a1.a;
                j1 += a1.b;
            }

            return new a(k1, j1);
        } else
        {
            return new a(0, 0);
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
                zzb.zzaC("Content hash thread already started, quiting...");
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

    void a(mw mw1, WebView webview, String s)
    {
        mw1.d();
        if (!TextUtils.isEmpty(s))
        {
            s = (new JSONObject(s)).optString("text");
            if (TextUtils.isEmpty(webview.getTitle()))
            {
                break MISSING_BLOCK_LABEL_82;
            }
            mw1.a((new StringBuilder()).append(webview.getTitle()).append("\n").append(s).toString());
        }
_L2:
        if (mw1.a())
        {
            f.b(mw1);
            return;
        }
        break MISSING_BLOCK_LABEL_113;
        mw1.a(s);
        if (true) goto _L2; else goto _L1
_L1:
        mw1;
        zzb.zzaC("Json string may be malformed.");
        return;
        mw1;
        zzb.zza("Failed to get webview content.", mw1);
        g.a(mw1, true);
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
            view.post(new Runnable(view) {

                final View a;
                final mz b;

                public void run()
                {
                    b.b(a);
                }

            
            {
                b = mz.this;
                a = view;
                super();
            }
            });
            return true;
        }
    }

    boolean a(WebView webview, mw mw1)
    {
        if (!vs.g())
        {
            return false;
        } else
        {
            mw1.e();
            webview.post(new Runnable(mw1, webview) {

                ValueCallback a;
                final mw b;
                final WebView c;
                final mz d;

                public void run()
                {
                    if (!c.getSettings().getJavaScriptEnabled())
                    {
                        break MISSING_BLOCK_LABEL_26;
                    }
                    c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", a);
                    return;
                    Throwable throwable;
                    throwable;
                    a.onReceiveValue("");
                    return;
                }

            
            {
                d = mz.this;
                b = mw1;
                c = webview;
                super();
                a = new _cls1(this);
            }
            });
            return true;
        }
    }

    void b(View view)
    {
        mw mw1;
        mw1 = new mw(i, j, k, l);
        view = a(view, mw1);
        mw1.f();
        if (((a) (view)).a == 0 && ((a) (view)).b == 0)
        {
            return;
        }
        try
        {
            if ((((a) (view)).b != 0 || mw1.h() != 0) && (((a) (view)).b != 0 || !f.a(mw1)))
            {
                f.c(mw1);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            zzb.zzb("Exception in fetchContentOnUIThread", view);
            g.a(view, true);
        }
        return;
    }

    boolean b()
    {
        Context context;
        KeyguardManager keyguardmanager;
        Object obj;
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
        boolean flag;
        try
        {
            context = e.b();
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
            break MISSING_BLOCK_LABEL_131;
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
                break MISSING_BLOCK_LABEL_126;
            }
            runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
        } while (Process.myPid() != runningappprocessinfo.pid);
        if (!a(runningappprocessinfo) || keyguardmanager.inKeyguardRestrictedInputMode())
        {
            break MISSING_BLOCK_LABEL_126;
        }
        flag = a(context);
        if (flag)
        {
            return true;
        }
        return false;
        return false;
    }

    public mw c()
    {
        return f.a();
    }

    public void d()
    {
        synchronized (d)
        {
            b = false;
            d.notifyAll();
            zzb.zzaC("ContentFetchThread: wakeup");
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void e()
    {
        synchronized (d)
        {
            b = true;
            zzb.zzaC((new StringBuilder()).append("ContentFetchThread: paused, mPause = ").append(b).toString());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean f()
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
        if (!b()) goto _L2; else goto _L1
_L1:
        Object obj = e.a();
        if (obj != null) goto _L4; else goto _L3
_L3:
        try
        {
            zzb.zzaC("ContentFetchThread: no activity");
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzb.zzb("Error in ContentFetchTask", ((Throwable) (obj)));
            g.a(((Throwable) (obj)), true);
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
            zzb.zzaC("ContentFetchTask: waiting");
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
        zzb.zzaC("ContentFetchTask: sleeping");
        e();
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

    // Unreferenced inner class android/support/v7/mz$2$1

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

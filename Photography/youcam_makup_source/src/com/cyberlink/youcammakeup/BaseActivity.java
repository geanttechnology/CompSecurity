// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.view.Window;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.StorageMonitor;
import com.cyberlink.youcammakeup.utility.bm;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.r;
import com.facebook.AppEventsLogger;
import com.pf.common.utility.m;
import java.io.File;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import w.a.b;

// Referenced classes of package com.cyberlink.youcammakeup:
//            Globals, DisplayBroadcastReceiver

public class BaseActivity extends Activity
    implements bm
{

    private Runnable a;
    private boolean b;
    private boolean c;
    private final Queue d = new ConcurrentLinkedQueue();
    private boolean e;
    private int f;
    private b g;

    public BaseActivity()
    {
        a = null;
        b = false;
        c = false;
    }

    private void a(String s)
    {
        runOnUiThread(new Runnable(s) {

            final String a;
            final BaseActivity b;

            public void run()
            {
                Globals.d().i().a(new r(this) {

                    final _cls2 a;

                    public void a()
                    {
                        Globals.d().H();
                        a.b.finish();
                        Process.killProcess(Process.myPid());
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
                Globals.d().i().a(b, null, a, true);
            }

            
            {
                b = BaseActivity.this;
                a = s;
                super();
            }
        });
    }

    public static void a(Queue queue)
    {
        do
        {
            Runnable runnable = (Runnable)queue.poll();
            if (runnable != null)
            {
                runnable.run();
            } else
            {
                return;
            }
        } while (true);
    }

    private String j()
    {
        Globals.d();
        if (!Globals.S())
        {
            return getString(0x7f0703cb);
        } else
        {
            return "";
        }
    }

    private boolean k()
    {
        return g != null;
    }

    public Runnable a()
    {
        Runnable runnable = new Runnable() {

            final BaseActivity a;

            public void run()
            {
                if (!a.isFinishing())
                {
                    a.finish();
                }
            }

            
            {
                a = BaseActivity.this;
                super();
            }
        };
        a = runnable;
        return runnable;
    }

    public void a(long l)
    {
        a(l, StatusManager.j().r());
    }

    public void a(long l, MakeupMode makeupmode)
    {
        a(true, l, makeupmode);
    }

    public void a(Uri uri)
    {
        File file;
        if (uri != null)
        {
            if ((uri = uri.getPath()) != null && ((file = Environment.getExternalStorageDirectory()) == null || uri.equalsIgnoreCase(file.getAbsolutePath())))
            {
                m.b("BaseActivity", (new StringBuilder()).append("ExternalStorage: ").append(uri).append(" unavailable!").toString());
                a(getString(0x7f0703cb));
                return;
            }
        }
    }

    public void a(MakeupMode makeupmode)
    {
        a(true, 1000L, makeupmode);
    }

    protected void a(boolean flag)
    {
        b = flag;
    }

    public void a(boolean flag, long l, MakeupMode makeupmode)
    {
        if (k())
        {
            f = f + 1;
            return;
        } else
        {
            g = new b(this, flag);
            g.a(l);
            g.a(makeupmode);
            g.getWindow().getAttributes().windowAnimations = 0x7f0a01f7;
            g.show();
            f = f + 1;
            return;
        }
    }

    public boolean a(Runnable runnable)
    {
        if (c())
        {
            d.add(runnable);
            return false;
        } else
        {
            runnable.run();
            return true;
        }
    }

    public boolean b()
    {
        return c;
    }

    public boolean c()
    {
        return b;
    }

    public boolean d()
    {
        return false;
    }

    public boolean e()
    {
        return false;
    }

    public boolean f()
    {
        boolean flag2 = true;
        boolean flag = false;
        if (d())
        {
            flag = true;
        }
        boolean flag1 = flag2;
        if (!flag)
        {
            flag1 = flag2;
            if (isTaskRoot())
            {
                flag1 = e();
            }
        }
        if (flag1)
        {
            finish();
        }
        return flag1;
    }

    public boolean g()
    {
        return e;
    }

    public void h()
    {
        a(StatusManager.j().r());
    }

    public void i()
    {
        if (k())
        {
            f = f - 1;
            if (f == 0)
            {
                g.dismiss();
                g = null;
            }
        }
    }

    public boolean isTaskRoot()
    {
        return Globals.d().c(this);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Globals.d().a(this);
        bundle = a();
        if (bundle != null)
        {
            Globals.d().a(bundle);
        }
    }

    protected void onDestroy()
    {
        c = true;
        Globals.d().b(this);
        if (a != null)
        {
            Globals.d().b(a);
            a = null;
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        Globals.d().g().b();
        StorageMonitor.a().b(this);
        a(true);
    }

    protected void onResume()
    {
        super.onResume();
        e = false;
        Object obj = Globals.d();
        ((Globals) (obj)).g().a();
        StorageMonitor.a().a(this);
        Globals.d();
        if (!Globals.u())
        {
            String s = com.cyberlink.youcammakeup.Globals.a(((android.content.Context) (obj)), "com.facebook.sdk.ApplicationId");
            if (s != null && !s.isEmpty())
            {
                AppEventsLogger.activateApp(((android.content.Context) (obj)), s);
            }
        }
        a(false);
        a(d);
        obj = j();
        if (((String) (obj)).length() != 0)
        {
            a(((String) (obj)));
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        e = true;
    }

    protected void onStart()
    {
        super.onStart();
        com.cyberlink.youcammakeup.clflurry.b.b();
        com.cyberlink.youcammakeup.flurry.a.a(this);
        com.cyberlink.youcammakeup.flurry.a.a();
        long l = Runtime.getRuntime().totalMemory();
        m.e(getClass().getSimpleName(), (new StringBuilder()).append("totalMemory:").append(l).toString());
        l = Runtime.getRuntime().totalMemory();
        long l1 = Runtime.getRuntime().freeMemory();
        m.e(getClass().getSimpleName(), (new StringBuilder()).append("totalMemory (in-used):").append(l - l1).toString());
        m.e(getClass().getSimpleName(), (new StringBuilder()).append("nativeHeapAllocatedSize:").append(Debug.getNativeHeapAllocatedSize()).toString());
        m.e(getClass().getSimpleName(), (new StringBuilder()).append("nativeHeapSize:").append(Debug.getNativeHeapSize()).toString());
    }

    protected void onStop()
    {
        com.cyberlink.youcammakeup.clflurry.b.c();
        super.onStop();
        com.cyberlink.youcammakeup.flurry.a.b(this);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.flurry.sdk:
//            hk, gd, r, ap, 
//            co, aw, cn, fy, 
//            at, fp, hj, fx, 
//            hq

public abstract class ec extends RelativeLayout
    implements android.content.DialogInterface.OnKeyListener
{

    private static final String a = com/flurry/sdk/ec.getSimpleName();
    private final r b;
    private final a c;
    private ProgressDialog d;
    private AtomicBoolean e;
    private long f;
    private final fy g = new fy() {

        final ec a;

        public void a(hj hj1)
        {
            if (System.currentTimeMillis() - ec.a(a) > 8000L)
            {
                fp.a().a(new hq(this) {

                    final _cls1 a;

                    public void safeRun()
                    {
                        gd.a(3, ec.f(), "Failed to load view in 8 seconds.");
                        a.a.dismissProgressDialog();
                        a.a.removeTimerListener();
                        a.a.onViewLoadTimeout();
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }
        }

        public void notify(fx fx)
        {
            a((hj)fx);
        }

            
            {
                a = ec.this;
                super();
            }
    };

    public ec(Context context, r r1, a a1)
    {
        super(context);
        e = new AtomicBoolean(false);
        f = 0x8000000000000000L;
        b = r1;
        c = a1;
    }

    static long a(ec ec1)
    {
        return ec1.f;
    }

    static String f()
    {
        return a;
    }

    public void addTimerListener()
    {
        f = System.currentTimeMillis();
        hk.a().a(g);
    }

    public void cleanupLayout()
    {
        removeTimerListener();
    }

    protected void dismissProgressDialog()
    {
        if (d != null && d.isShowing())
        {
            d.dismiss();
            d = null;
        }
        gd.a(3, a, "Dismiss progress bar.");
        f = 0x8000000000000000L;
        removeTimerListener();
    }

    public ap getAdController()
    {
        return b.k();
    }

    public int getAdFrameIndex()
    {
        return b.k().c();
    }

    public at getAdLog()
    {
        return b.k().b();
    }

    public at getAdLog(String s)
    {
        return b.k().a(s);
    }

    public r getAdObject()
    {
        return b;
    }

    public AdUnit getAdUnit()
    {
        return b.k().a();
    }

    public void initLayout()
    {
    }

    protected boolean isViewAttachedToActivity()
    {
        gd.a(3, a, (new StringBuilder()).append("fViewAttachedToWindow ").append(e.get()).toString());
        return e.get();
    }

    public void onActivityDestroy()
    {
    }

    public void onActivityPause()
    {
    }

    public void onActivityResume()
    {
    }

    public void onActivityStart()
    {
    }

    public void onActivityStop()
    {
        dismissProgressDialog();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        e.set(true);
    }

    public boolean onBackKey()
    {
        return false;
    }

    public void onConfigurationChanged()
    {
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        e.set(false);
    }

    public void onEvent(aw aw1, Map map)
    {
        co.a(aw1, map, getContext(), b, b.k(), 0);
    }

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        gd.a(3, a, (new StringBuilder()).append("onkey,keycode=").append(i).append(",event=").append(keyevent.getAction()).toString());
        if (dialoginterface == d && i == 4 && keyevent.getAction() == 1)
        {
            onEvent(aw.s, Collections.emptyMap());
            dialoginterface.dismiss();
            return true;
        } else
        {
            return false;
        }
    }

    protected void onViewBack()
    {
        if (c != null)
        {
            c.a();
        }
    }

    protected void onViewClose()
    {
        if (c != null)
        {
            c.b();
        }
    }

    protected void onViewError()
    {
        if (c != null)
        {
            c.c();
        }
    }

    protected void onViewLoadTimeout()
    {
    }

    public void removeTimerListener()
    {
        f = 0x8000000000000000L;
        hk.a().b(g);
    }

    public void setAdFrameIndex(int i)
    {
        b.k().a(i);
    }

    protected void setOrientation(int i)
    {
        if (getContext() instanceof Activity)
        {
            Activity activity = (Activity)getContext();
            if (getAdController().l())
            {
                cn.a(activity, i, true);
                return;
            }
        }
    }

    protected void showProgressDialog()
    {
        if (getAdController().l())
        {
            Context context = getContext();
            if (d == null)
            {
                if (context != null)
                {
                    gd.a(3, a, "Create and show progress bar");
                    d = new ProgressDialog(context);
                    d.setProgressStyle(0);
                    d.setMessage("Loading...");
                    d.setCancelable(true);
                    d.setCanceledOnTouchOutside(false);
                    d.setOnKeyListener(this);
                    d.show();
                    addTimerListener();
                    return;
                } else
                {
                    gd.a(3, a, "Context is null, cannot create progress dialog.");
                    return;
                }
            }
            if (!d.isShowing())
            {
                gd.a(3, a, "Show progress bar.");
                d.show();
                addTimerListener();
                return;
            }
        }
    }


    private class a
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();
    }

}

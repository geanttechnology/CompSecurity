// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            ec, dx, du, ap, 
//            dt, aw, ea, cn, 
//            gd, co, av, i, 
//            aa, r

public abstract class dq extends ec
    implements dx
{

    private static final String b = com/flurry/sdk/dq.getSimpleName();
    protected du a;
    private boolean c;
    private boolean d;

    protected dq(Context context, r r, ec.a a1)
    {
        super(context, r, a1);
        c = true;
        d = false;
        a = new du(context);
        a.a(this);
        k();
        showProgressDialog();
    }

    private void a(float f, float f1)
    {
        if (a != null)
        {
            dt dt1 = getAdController().m();
            if (f1 >= 0.0F && !dt1.b())
            {
                dt1.a(true);
                a(aw.i, Collections.emptyMap());
            }
            f = f1 / f;
            if (f >= 0.25F && !dt1.d())
            {
                dt1.c(true);
                a(aw.E, Collections.emptyMap());
            }
            if (f >= 0.5F && !dt1.e())
            {
                dt1.d(true);
                a(aw.F, Collections.emptyMap());
            }
            if (f >= 0.75F && !dt1.f())
            {
                dt1.e(true);
                a(aw.G, Collections.emptyMap());
                return;
            }
        }
    }

    private boolean g()
    {
        return getAdFrameIndex() == getAdUnit().adFrames.size() - 1;
    }

    private void h()
    {
        ea ea1 = new ea();
        ea1.e = ea.a.b;
        ea1.b();
    }

    private void i()
    {
        dt dt1 = getAdController().m();
        int i1 = a.c();
        if (i1 > 0)
        {
            dt1.a(i1);
            getAdController().a(dt1);
        }
    }

    private void j()
    {
        getAdController().m().b(getViewParams());
    }

    private void k()
    {
        if (cn.a(getContext()))
        {
            setOrientation(4);
            return;
        } else
        {
            setOrientation(6);
            return;
        }
    }

    private void l()
    {
        setOrientation(4);
    }

    public void a()
    {
        gd.a(3, b, "Video Close clicked: ");
        a(aw.s, Collections.emptyMap());
        onViewClose();
    }

    public void a(int i1)
    {
        if (a != null)
        {
            if (a.a())
            {
                dismissProgressDialog();
                a.a(i1);
            } else
            {
                showProgressDialog();
            }
            a.b(getViewParams());
            d = false;
        }
    }

    protected void a(aw aw1, Map map)
    {
        co.a(aw1, map, getContext(), getAdObject(), getAdController(), 0);
    }

    public void a(String s)
    {
        gd.a(3, b, (new StringBuilder()).append("Video Completed: ").append(s).toString());
        boolean flag = g();
        a(aw.j, Collections.emptyMap());
        l();
        if (flag)
        {
            h();
        }
    }

    public void a(String s, float f, float f1)
    {
        a(f, f1);
        if (a != null)
        {
            a.b(getViewParams());
        }
    }

    public void a(String s, int i1, int j1, int k1)
    {
        gd.a(3, b, (new StringBuilder()).append("Video Error: ").append(s).toString());
        if (a != null)
        {
            a.d();
        }
        onViewError();
        s = new HashMap();
        s.put("errorCode", Integer.toString(av.r.a()));
        s.put("frameworkError", Integer.toString(j1));
        s.put("implError", Integer.toString(k1));
        a(aw.g, ((Map) (s)));
        dismissProgressDialog();
        l();
    }

    public void b()
    {
        gd.a(3, b, "Video Play clicked: ");
        a(0);
    }

    public void b(String s)
    {
        gd.a(3, b, (new StringBuilder()).append("Video Prepared: ").append(s).toString());
        if (a != null)
        {
            a.b(getViewParams());
        }
        if (d)
        {
            dismissProgressDialog();
            return;
        }
        s = getAdController().m();
        int i1 = s.a();
        if (a != null && (c || i1 > 3))
        {
            a(i1);
        }
        a(aw.f, Collections.emptyMap());
        s.h(true);
        dismissProgressDialog();
    }

    protected Uri c(String s)
    {
        Uri uri = null;
        File file;
        gd.a(3, b, (new StringBuilder()).append("Precaching: Getting video from cache: ").append(s).toString());
        file = com.flurry.sdk.i.a().l().a(getAdObject(), s);
        Object obj = uri;
        if (file != null)
        {
            try
            {
                obj = Uri.parse((new StringBuilder()).append("file://").append(file.getAbsolutePath()).toString());
            }
            catch (Exception exception)
            {
                gd.a(3, b, "Precaching: Error accessing cached file.", exception);
                exception = uri;
            }
        }
        uri = ((Uri) (obj));
        if (obj == null)
        {
            gd.a(3, b, (new StringBuilder()).append("Precaching: Error using cached file. Loading with url: ").append(s).toString());
            uri = Uri.parse(s);
        }
        return uri;
    }

    public void c()
    {
        if (a != null)
        {
            gd.a(3, b, "Video pause: ");
            i();
            j();
            a.b();
            d = true;
        }
    }

    public void cleanupLayout()
    {
        d();
        dismissProgressDialog();
        if (a != null)
        {
            a.j();
            a = null;
        }
    }

    public void d()
    {
        if (a != null)
        {
            gd.a(3, b, "Video suspend: ");
            c();
            a.d();
        }
    }

    public void e()
    {
        gd.a(3, b, "Video More Info clicked: ");
        a(aw.h, Collections.emptyMap());
    }

    protected abstract int getViewParams();

    public void initLayout()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        addView(a.e(), layoutparams);
        showProgressDialog();
    }

    public void onActivityDestroy()
    {
        super.onActivityDestroy();
        com.flurry.sdk.i.a().l().a(getAdObject());
        com.flurry.sdk.i.a().l().g();
    }

    public void onActivityPause()
    {
        super.onActivityPause();
        c();
    }

    public void onActivityResume()
    {
        super.onActivityResume();
        int i1 = getAdController().m().a();
        if (a != null && (c || i1 > 3))
        {
            a(i1);
        }
    }

    public void onActivityStop()
    {
        super.onActivityStop();
        d();
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        k();
    }

    protected void onViewLoadTimeout()
    {
        a(aw.s, Collections.emptyMap());
    }

    public void setAutoPlay(boolean flag)
    {
        gd.a(3, b, (new StringBuilder()).append("Video setAutoPlay: ").append(flag).toString());
        c = flag;
    }

    public void setVideoUri(Uri uri)
    {
        gd.a(3, b, (new StringBuilder()).append("Video set video uri: ").append(uri).toString());
        if (a != null)
        {
            dt dt1 = getAdController().m();
            int i1;
            if (dt1.a() > a.f())
            {
                i1 = dt1.a();
            } else
            {
                i1 = a.f();
            }
            a.a(uri, i1);
        }
    }

}

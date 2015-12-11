// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.gu;
import org.json.JSONException;
import org.json.JSONObject;

public class wz
{

    DisplayMetrics a;
    int b;
    int c;
    private final gu d;
    private final Context e;
    private final WindowManager f;
    private final ue g;
    private float h;
    private int i;
    private int j;
    private int k;
    private int l[];

    public wz(gu gu1, Context context, ue ue1)
    {
        b = -1;
        c = -1;
        j = -1;
        k = -1;
        l = new int[2];
        d = gu1;
        e = context;
        g = ue1;
        f = (WindowManager)context.getSystemService("window");
        g();
        a();
        h();
    }

    private void g()
    {
        a = new DisplayMetrics();
        Display display = f.getDefaultDisplay();
        display.getMetrics(a);
        h = a.density;
        i = display.getRotation();
    }

    private void h()
    {
        d.getLocationOnScreen(l);
        d.measure(0, 0);
        float f1 = 160F / (float)a.densityDpi;
        j = Math.round((float)d.getMeasuredWidth() * f1);
        k = Math.round(f1 * (float)d.getMeasuredHeight());
    }

    private wx i()
    {
        return (new wy()).b(g.a()).a(g.b()).c(g.f()).d(g.c()).e(g.d()).a();
    }

    void a()
    {
        int i1 = abq.c(e);
        float f1 = 160F / (float)a.densityDpi;
        b = Math.round((float)a.widthPixels * f1);
        c = Math.round((float)(a.heightPixels - i1) * f1);
    }

    public void b()
    {
        e();
        f();
        d();
        c();
    }

    public void c()
    {
        if (acb.a(2))
        {
            acb.c("Dispatching Ready Event.");
        }
        d.b("onReadyEventReceived", new JSONObject());
    }

    public void d()
    {
        try
        {
            JSONObject jsonobject = (new JSONObject()).put("x", l[0]).put("y", l[1]).put("width", j).put("height", k);
            d.b("onDefaultPositionReceived", jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            acb.b("Error occured while dispatching default position.", jsonexception);
        }
    }

    public void e()
    {
        try
        {
            JSONObject jsonobject = (new JSONObject()).put("width", b).put("height", c).put("density", h).put("rotation", i);
            d.b("onScreenInfoChanged", jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            acb.b("Error occured while obtaining screen information.", jsonexception);
        }
    }

    public void f()
    {
        wx wx1 = i();
        d.b("onDeviceFeaturesReceived", wx1.a());
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.gu;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class wv
{

    static final Set a = new HashSet(Arrays.asList(new String[] {
        "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"
    }));
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private String g;
    private final gu h;
    private final Map i;
    private final Context j;

    public wv(gu gu1, Map map)
    {
        b = -1;
        c = -1;
        d = 0;
        e = 0;
        f = true;
        g = "top-right";
        h = gu1;
        i = map;
        j = gu1.k();
    }

    private void e()
    {
        int ai[] = abq.d(j);
        if (!TextUtils.isEmpty((CharSequence)i.get("width")))
        {
            int k = abq.b((String)i.get("width"));
            if (a(k, ai[0]))
            {
                b = k;
            }
        }
        if (!TextUtils.isEmpty((CharSequence)i.get("height")))
        {
            int l = abq.b((String)i.get("height"));
            if (b(l, ai[1]))
            {
                c = l;
            }
        }
        if (!TextUtils.isEmpty((CharSequence)i.get("offsetX")))
        {
            d = abq.b((String)i.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence)i.get("offsetY")))
        {
            e = abq.b((String)i.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence)i.get("allowOffscreen")))
        {
            f = Boolean.parseBoolean((String)i.get("allowOffscreen"));
        }
        String s = (String)i.get("customClosePosition");
        if (!TextUtils.isEmpty(s) && a.contains(s))
        {
            g = s;
        }
    }

    boolean a()
    {
        return b > -1 && c > -1;
    }

    boolean a(int k, int l)
    {
        return k >= 50 && k < l;
    }

    public void b()
    {
        acb.c("PLEASE IMPLEMENT mraid.resize()");
        if (j == null)
        {
            acb.e("Not an activity context. Cannot resize.");
            return;
        }
        if (h.e().e)
        {
            acb.e("Is interstitial. Cannot resize an interstitial.");
            return;
        }
        if (h.j())
        {
            acb.e("Is expanded. Cannot resize an expanded banner.");
            return;
        }
        e();
        if (!a())
        {
            acb.e("Invalid width and height options. Cannot resize.");
            return;
        }
        Object obj = (WindowManager)j.getSystemService("window");
        Object obj1 = new DisplayMetrics();
        ((WindowManager) (obj)).getDefaultDisplay().getMetrics(((DisplayMetrics) (obj1)));
        int k = aca.a(((DisplayMetrics) (obj1)), b);
        int l = aca.a(((DisplayMetrics) (obj1)), c);
        obj = h.getParent();
        if (obj != null && (obj instanceof ViewGroup))
        {
            ((ViewGroup)obj).removeView(h);
        }
        obj = new LinearLayout(j);
        ((LinearLayout) (obj)).setBackgroundColor(0);
        obj1 = new PopupWindow(j);
        ((PopupWindow) (obj1)).setHeight(l + 16);
        ((PopupWindow) (obj1)).setWidth(k + 16);
        boolean flag;
        if (!f)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((PopupWindow) (obj1)).setClippingEnabled(flag);
        ((PopupWindow) (obj1)).setContentView(((android.view.View) (obj)));
        ((LinearLayout) (obj)).addView(h, -1, -1);
        ((PopupWindow) (obj1)).showAtLocation(((Activity)j).getWindow().getDecorView(), 0, d, e);
        h.a(new ay(j, new oo(b, c)));
        c();
        d();
    }

    boolean b(int k, int l)
    {
        return k >= 50 && k < l;
    }

    void c()
    {
        try
        {
            JSONObject jsonobject = (new JSONObject()).put("x", d).put("y", e).put("width", b).put("height", c);
            h.b("onSizeChanged", jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            acb.b("Error occured while dispatching size change.", jsonexception);
        }
    }

    void d()
    {
        try
        {
            JSONObject jsonobject = (new JSONObject()).put("state", "resized");
            h.b("onStateChanged", jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            acb.b("Error occured while dispatching state change.", jsonexception);
        }
    }

}

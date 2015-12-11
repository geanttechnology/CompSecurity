// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.j.a.c;
import com.j.a.e.a;
import com.j.a.e.az;
import com.j.a.f.e;
import com.j.a.g.a.b;
import com.j.a.g.a.d;
import com.j.a.g.m;
import com.j.a.g.o;
import com.j.a.g.t;
import com.j.a.g.w;
import com.j.a.g.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.j.a.d:
//            e, m, p, l, 
//            n, o, ab, v, 
//            w

public class ag
{

    private static ag n;
    boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private ImageView f;
    private t g;
    private String h;
    private String i;
    private JSONObject j;
    private JSONObject k;
    private com.j.a.f.d l;
    private e m;
    private ViewGroup o;
    private Map p;
    private int q;
    private c r;

    public ag()
    {
        e = false;
        g = t.a;
        o = null;
        p = new HashMap();
        a = false;
        q = 500;
    }

    static ViewGroup a(ag ag1)
    {
        return ag1.o;
    }

    static ImageView a(ag ag1, ImageView imageview)
    {
        ag1.f = imageview;
        return imageview;
    }

    static com.j.a.f.d a(ag ag1, com.j.a.f.d d1)
    {
        ag1.l = d1;
        return d1;
    }

    static e a(ag ag1, e e1)
    {
        ag1.m = e1;
        return e1;
    }

    static String a(ag ag1, String s)
    {
        ag1.h = s;
        return s;
    }

    private JSONArray a(float f1, float f2, ViewGroup viewgroup)
    {
        JSONArray jsonarray = new JSONArray();
        try
        {
            for (viewgroup = com.j.a.g.o.a(f1, f2, viewgroup).iterator(); viewgroup.hasNext(); jsonarray.put(com.j.a.g.o.a((View)viewgroup.next()))) { }
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            w.b("Err: vw jsn. ", viewgroup);
        }
        return jsonarray;
    }

    static JSONArray a(ag ag1, float f1, float f2, ViewGroup viewgroup)
    {
        return ag1.a(f1, f2, viewgroup);
    }

    static boolean a(ag ag1, boolean flag)
    {
        ag1.b = flag;
        return flag;
    }

    static String b(ag ag1)
    {
        return ag1.h;
    }

    static String b(ag ag1, String s)
    {
        ag1.i = s;
        return s;
    }

    static boolean b(ag ag1, boolean flag)
    {
        ag1.c = flag;
        return flag;
    }

    public static ag c()
    {
        if (n != null)
        {
            return n;
        } else
        {
            n = new ag();
            return n;
        }
    }

    static String c(ag ag1)
    {
        return ag1.i;
    }

    static t d(ag ag1)
    {
        return ag1.g;
    }

    static com.j.a.f.d e(ag ag1)
    {
        return ag1.l;
    }

    static android.view.View.OnTouchListener f(ag ag1)
    {
        return ag1.q();
    }

    static void g(ag ag1)
    {
        ag1.p();
    }

    static e h(ag ag1)
    {
        return ag1.m;
    }

    static boolean i(ag ag1)
    {
        return ag1.b;
    }

    static boolean j(ag ag1)
    {
        return ag1.c;
    }

    private void o()
    {
        if (r != null)
        {
            r.a();
            r = null;
            e = true;
        }
        n();
    }

    private void p()
    {
        try
        {
            if (com.j.a.d.e.e().g() && com.j.a.d.e.e().p() != null && com.j.a.d.e.e().i())
            {
                com.j.a.d.e.e().p().runOnUiThread(new com.j.a.d.m(this));
            }
            return;
        }
        catch (Exception exception)
        {
            w.b(getClass().toString(), exception);
        }
    }

    private android.view.View.OnTouchListener q()
    {
        return new p(this);
    }

    public t a()
    {
        return g;
    }

    public void a(ViewGroup viewgroup)
    {
        boolean flag1 = false;
        o = viewgroup;
        com.j.a.g.o.a(viewgroup, false);
        boolean flag = flag1;
        if (com.j.a.d.e.e().p() != null)
        {
            flag = flag1;
            if (!com.j.a.d.e.e().p().getIntent().getBooleanExtra("TLRefreshed", false))
            {
                flag = true;
            }
        }
        a = flag;
        if (com.j.a.d.e.e().k() == null) goto _L2; else goto _L1
_L1:
        e();
_L4:
        if (d)
        {
            g();
        } else
        {
            j();
        }
        h();
        return;
_L2:
        if (com.j.a.d.e.e().d().d() == b.a) goto _L4; else goto _L3
_L3:
        com.j.a.d.e.e().d().a(new l(this));
          goto _L4
        viewgroup;
        w.b("setcurrentviewgroup err", viewgroup);
          goto _L4
    }

    public void a(String s, String s1)
    {
        if (com.j.a.d.e.e().g())
        {
            if (!s.equals(i) || !s1.equals(h))
            {
                h = s1;
                i = s;
                a = true;
                p();
            }
            g();
        }
    }

    public void a(String s, byte abyte0[])
    {
        p.put(s, abyte0);
    }

    public void a(JSONObject jsonobject)
    {
        j = jsonobject;
        if (jsonobject.optBoolean("chooseButton"))
        {
            jsonobject = t.d;
        } else
        {
            jsonobject = t.b;
        }
        g = jsonobject;
        g();
        az.a().a("enteredTapMode", j);
    }

    public void a(boolean flag)
    {
        d = flag;
    }

    public JSONObject b()
    {
        return j;
    }

    public void b(JSONObject jsonobject)
    {
        if (jsonobject != null)
        {
            g = t.c;
            g();
            k = jsonobject;
            az.a().a("enteredPickViewMode", jsonobject);
        }
    }

    public ViewGroup d()
    {
        return o;
    }

    public void e()
    {
        if (!com.j.a.d.e.e().g() || !com.j.a.g.o.a(o) || i == null || !com.j.a.d.e.e().j() || com.j.a.g.m.a(com.j.a.g.b.k))
        {
            break MISSING_BLOCK_LABEL_121;
        }
        if (a && com.j.a.d.e.e().i())
        {
            Activity activity = com.j.a.d.e.e().p();
            Intent intent = activity.getIntent();
            intent.putExtra("TLRefreshed", true);
            activity.finish();
            activity.overridePendingTransition(0, 0);
            activity.startActivity(intent);
            return;
        }
        try
        {
            p();
            com.j.a.g.o.c(o);
            o();
            return;
        }
        catch (JSONException jsonexception)
        {
            w.b("Err: setprp", jsonexception);
        }
        return;
        com.j.a.g.o.c(o);
        o();
        return;
    }

    public void f()
    {
        j = null;
        g = t.a;
        g();
    }

    public void g()
    {
        try
        {
            if (com.j.a.d.e.e().g() && com.j.a.d.e.e().p() != null && com.j.a.d.e.e().i())
            {
                com.j.a.d.e.e().p().runOnUiThread(new n(this));
                d = true;
            }
            return;
        }
        catch (Exception exception)
        {
            w.b("app bd", exception);
        }
    }

    public void h()
    {
        if (com.j.a.d.e.e().p() != null && com.j.a.d.e.e().i())
        {
            com.j.a.d.e.e().p().runOnUiThread(new com.j.a.d.o(this));
        }
    }

    public void i()
    {
        m = null;
    }

    public void j()
    {
        try
        {
            if (com.j.a.d.e.e().g() && com.j.a.d.e.e().p() != null && com.j.a.d.e.e().i() && o.findViewById(com.j.a.f.b.b()) != null)
            {
                o.removeView(o.findViewById(com.j.a.f.b.b()));
            }
            return;
        }
        catch (Exception exception)
        {
            w.b("rem bd", exception);
        }
    }

    public void k()
    {
        if (k == null)
        {
            return;
        }
        Object obj;
        k.put("viewKey", com.j.a.d.e.e().p().getClass().getSimpleName());
        obj = y.a(o.getChildAt(0));
        k.put("imgFileName", obj);
        obj = new JSONArray();
        for (Iterator iterator = com.j.a.d.ab.a().b().entrySet().iterator(); iterator.hasNext(); ((JSONArray) (obj)).put(((Pair)((java.util.Map.Entry)iterator.next()).getValue()).second)) { }
          goto _L1
        obj;
        w.b("Getting Found Activity", ((Exception) (obj)));
        k = null;
_L3:
        l();
        return;
_L1:
        k.put("fragments", obj);
        k.put("isAndroid", true);
        com.j.a.d.e.e().l().a(k, new v(this));
        k = null;
        if (true) goto _L3; else goto _L2
_L2:
        Exception exception;
        exception;
        k = null;
        throw exception;
    }

    public void l()
    {
        g = t.a;
        g();
    }

    public Map m()
    {
        HashMap hashmap = new HashMap(p);
        p.clear();
        return hashmap;
    }

    public void n()
    {
        try
        {
            if (f != null)
            {
                AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
                alphaanimation.setDuration((long)(float)q);
                f.startAnimation(alphaanimation);
                alphaanimation.setFillAfter(true);
                alphaanimation.setAnimationListener(new com.j.a.d.w(this));
                w.a("delay image hidden");
                e = true;
            }
            return;
        }
        catch (Exception exception)
        {
            w.b("Delay view error", exception);
        }
    }
}

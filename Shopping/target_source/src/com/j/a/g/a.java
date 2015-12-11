// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.j.a.a.d;
import com.j.a.d.ab;
import com.j.a.d.ag;
import com.j.a.d.e;
import com.j.a.f.h;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.j.a.g:
//            o, b, m, w, 
//            z, x

public class a
{

    private static HashMap a = new HashMap();

    public static int a()
    {
        return 0x17ccbc36;
    }

    public static int a(View view)
    {
        int i;
        view = o.c(view);
        if (view == ag.c().d())
        {
            break MISSING_BLOCK_LABEL_47;
        }
        if (ab.a().b().containsKey(Integer.valueOf(view.getId())))
        {
            return view.getId();
        }
        i = a(view);
        return i;
        view;
        return -2;
    }

    static int a(ViewGroup viewgroup)
    {
        return b(viewgroup);
    }

    public static void a(int i)
    {
        Pair pair;
        boolean flag;
        try
        {
            flag = ab.a().b().containsKey(Integer.valueOf(i));
            pair = (Pair)ab.a().b().remove(Integer.valueOf(i));
        }
        catch (Exception exception)
        {
            w.b("VP remove:", exception);
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        (new JSONObject()).putOpt("fragment", Boolean.valueOf(true));
        if (!m.a(b.a))
        {
            e.e().n().a("viewDisappeared", ((Pair)com.j.a.a.d.c().get(Integer.valueOf(i))).first, null);
            com.j.a.a.d.a(i);
        }
        ab.a().c().add(pair.second);
    }

    public static void a(int i, ViewGroup viewgroup, Object obj)
    {
        h h1 = new h(e.e().o());
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(0, 0);
        h1.setId(i);
        if (obj != null)
        {
            h1.setTag(obj);
        }
        h1.setLayoutParams(layoutparams);
        viewgroup.addView(h1);
    }

    static void a(int i, Object obj, String s)
    {
        d(i, obj, s);
    }

    public static void a(ViewGroup viewgroup, ViewGroup viewgroup1, int i, String s, String s1, boolean flag, boolean flag1)
    {
        if (viewgroup1.findViewWithTag(s) != null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (a.containsKey(s) && a.get(s) == Boolean.valueOf(true))
        {
            return;
        }
        try
        {
            a.put(s, Boolean.valueOf(true));
            (new Handler()).postDelayed(new z(viewgroup1, s, i, s1), 10L);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            return;
        }
        if (viewgroup1.getVisibility() != 8 && !flag)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        if (viewgroup.getParent() instanceof ViewGroup)
        {
            a(i, true);
            a((ViewGroup)viewgroup.getParent(), true);
            return;
        }
        if (!flag1 || flag)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        if ((viewgroup.getParent() instanceof ViewGroup) && a(((ViewGroup)viewgroup.getParent()).getId(), true))
        {
            c(i, s, s1);
        }
    }

    static void a(Object obj, String s)
    {
        b(obj, s);
    }

    public static boolean a(int i, boolean flag)
    {
        try
        {
            if (!ab.a().b().containsKey(Integer.valueOf(i)))
            {
                break MISSING_BLOCK_LABEL_111;
            }
        }
        catch (Exception exception)
        {
            w.b("fragment removal:", exception);
            return false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        ab.a().b().remove(Integer.valueOf(i));
        if (com.j.a.a.d.c().containsKey(Integer.valueOf(i)))
        {
            (new JSONObject()).putOpt("fragment", Boolean.valueOf(true));
            if (!m.a(b.a))
            {
                e.e().n().a("viewDisappeared", ((Pair)com.j.a.a.d.c().get(Integer.valueOf(i))).first, null);
                com.j.a.a.d.a(i);
            }
        }
        return true;
        return false;
    }

    public static boolean a(ViewGroup viewgroup, boolean flag)
    {
        if (!e.e().c())
        {
            break MISSING_BLOCK_LABEL_296;
        }
        if (e.e().p() == null || viewgroup.findViewById(b(viewgroup)) != null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        if (android.os.Build.VERSION.SDK_INT < 11 || m.a(b.p) || e.e().p().getFragmentManager().findFragmentById(viewgroup.getId()) == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        viewgroup.removeOnLayoutChangeListener(ab.a().d());
        viewgroup.addOnLayoutChangeListener(ab.a().d());
        o.c(viewgroup);
        return false;
        if (m.a(b.n) || m.a(b.o) || !Class.forName("android.support.v4.view.ViewPager").isInstance(viewgroup))
        {
            break MISSING_BLOCK_LABEL_151;
        }
        ViewPager viewpager = (ViewPager)viewgroup;
        android.support.v4.view.ac ac = viewpager.getAdapter();
        viewgroup.getViewTreeObserver().addOnGlobalLayoutListener(new x(viewpager, ac, viewgroup));
        return false;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        flag = m.a(b.o);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        android.support.v4.app.h h1 = (android.support.v4.app.h)e.e().p().getClass().getMethod("getSupportFragmentManager", new Class[0]).invoke(e.e().p(), new Object[0]);
        if (h1 == null)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        try
        {
            h1.b();
        }
        catch (Throwable throwable) { }
        try
        {
            if (h1.a(viewgroup.getId()) == null)
            {
                break MISSING_BLOCK_LABEL_294;
            }
            viewgroup.removeOnLayoutChangeListener(ab.a().e());
            viewgroup.addOnLayoutChangeListener(ab.a().e());
            o.c(viewgroup);
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            return true;
        }
        return false;
        return true;
        viewgroup;
        if (!(viewgroup instanceof Exception))
        {
            break MISSING_BLOCK_LABEL_275;
        }
        viewgroup = (Exception)viewgroup;
_L1:
        w.b("F sup: ", viewgroup);
        return false;
        viewgroup = new Exception();
          goto _L1
        viewgroup;
        w.b("fragstuff", viewgroup);
        return false;
        return false;
    }

    public static int b()
    {
        return 0x17ccbc37;
    }

    private static int b(ViewGroup viewgroup)
    {
        int i;
        int j;
        i = 0;
        j = i;
        if (viewgroup.getId() <= 0) goto _L2; else goto _L1
_L1:
        j = i;
        if (0x7fffffff - viewgroup.getId() <= 1000) goto _L3; else goto _L2
_L2:
        j = i;
        i = viewgroup.getId() + 1000;
_L4:
        int k;
        j = i;
        k = i;
        if (viewgroup.findViewById(i) == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        j = i;
        k = i;
        if (viewgroup.findViewById(i) instanceof h)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        k = i;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        i--;
          goto _L4
_L3:
        j = i;
        i = viewgroup.getId();
        i -= 1000;
          goto _L4
        viewgroup;
        k = j;
        return k;
    }

    static void b(int i, Object obj, String s)
    {
        c(i, obj, s);
    }

    private static void b(Object obj, String s)
    {
        int i = 1;
        while (i < ((ViewGroup)obj).getChildCount()) 
        {
            Object obj1 = ((ViewGroup)obj).getChildAt(i);
            if (!(obj1 instanceof ViewGroup) || ((View) (obj1)).getId() == b())
            {
                continue;
            }
            obj1 = (ViewGroup)obj1;
            if (((ViewGroup) (obj1)).findViewById(a()) == null)
            {
                a(0x17ccbc36, ((ViewGroup) (obj1)), s);
                try
                {
                    o.c((ViewGroup)((ViewGroup) (obj1)).getParent());
                }
                catch (Exception exception) { }
            }
            i++;
        }
    }

    static HashMap c()
    {
        return a;
    }

    private static void c(int i, Object obj, String s)
    {
        HashMap hashmap;
        String s1;
        StringBuilder stringbuilder;
        if (ab.a().b().containsKey(Integer.valueOf(i)) && (!ab.a().b().containsKey(Integer.valueOf(i)) || ((String)((Pair)ab.a().b().get(Integer.valueOf(i))).second).equals(obj)))
        {
            break MISSING_BLOCK_LABEL_241;
        }
        hashmap = ab.a().b();
        s1 = e.e().p().getClass().getSimpleName();
        stringbuilder = (new StringBuilder()).append(s);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        obj = "";
_L1:
        try
        {
            hashmap.put(Integer.valueOf(i), new Pair(s1, stringbuilder.append(((String) (obj))).toString()));
            obj = new JSONObject();
            ((JSONObject) (obj)).putOpt("fragment", Boolean.valueOf(true));
            if (!m.a(b.a))
            {
                e.e().n().a("viewAppeared", s, ((JSONObject) (obj)));
            }
            e.e().t();
            com.j.a.a.d.c().put(Integer.valueOf(i), new Pair(s, Long.valueOf(System.currentTimeMillis())));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            w.b("adding f: ", ((Exception) (obj)));
        }
        break MISSING_BLOCK_LABEL_241;
        obj = (new StringBuilder()).append("_").append(obj.toString()).toString();
          goto _L1
    }

    private static void d(int i, Object obj, String s)
    {
        try
        {
            if (!ab.a().b().containsKey(Integer.valueOf(i)) || ab.a().b().containsKey(Integer.valueOf(i)) && !((String)((Pair)ab.a().b().get(Integer.valueOf(i))).second).equals(obj))
            {
                ab.a().b().put(Integer.valueOf(i), new Pair(e.e().p().getClass().getSimpleName(), obj));
                JSONObject jsonobject = new JSONObject();
                jsonobject.putOpt("fragment", Boolean.valueOf(true));
                if (!m.a(b.a))
                {
                    e.e().n().a("viewAppeared", s, jsonobject);
                }
                e.e().t();
                ab.a().c().add((String)obj);
                com.j.a.a.d.c().put(Integer.valueOf(i), new Pair(s, Long.valueOf(System.currentTimeMillis())));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            w.b("adding vp: ", ((Exception) (obj)));
        }
    }

}

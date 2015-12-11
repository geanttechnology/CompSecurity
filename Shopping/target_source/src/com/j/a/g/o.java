// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.j.a.d.ab;
import com.j.a.d.ag;
import com.j.a.d.e;
import com.j.a.d.i;
import com.j.a.f.b;
import com.j.a.f.d;
import com.j.a.f.f;
import com.j.a.h;
import com.j.a.k;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.j.a.g:
//            t, s, w, u, 
//            a, y, b, m, 
//            p, r

public class o
{

    public static float a(float f1, float f2, float f3, float f4)
    {
        f1 -= f3;
        f2 -= f4;
        return (float)b((float)Math.sqrt(f1 * f1 + f2 * f2));
    }

    public static int a()
    {
        return 0x17ccbc3b;
    }

    public static int a(float f1)
    {
        return Math.round(((float)com.j.a.d.e.e().o().getResources().getDisplayMetrics().densityDpi / 160F) * f1);
    }

    public static int a(Context context)
    {
        int l = 0;
        int i1 = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i1 > 0)
        {
            l = context.getResources().getDimensionPixelSize(i1);
        }
        return l;
    }

    private static int a(RecyclerView recyclerview, View view)
    {
        View view1;
        int l;
        view1 = view;
        l = -1;
_L1:
        if (l != -1 || view1 == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        int i1 = recyclerview.c(view1);
        l = i1;
          goto _L1
        Exception exception;
        exception;
        boolean flag;
        try
        {
            view1 = (View)view1.getParent();
            if (view instanceof RecyclerView)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = view1 instanceof RecyclerView;
        }
        // Misplaced declaration of an exception variable
        catch (RecyclerView recyclerview)
        {
            return -1;
        }
        if (!flag) goto _L1; else goto _L2
_L2:
        return -1;
        return l;
    }

    private static int a(AbsListView abslistview, View view)
    {
        int l = abslistview.getPositionForView(view);
        if (l == -1)
        {
            try
            {
                l = a(abslistview, ((View) (c(view))));
            }
            // Misplaced declaration of an exception variable
            catch (AbsListView abslistview)
            {
                return -1;
            }
            return l;
        } else
        {
            return l;
        }
    }

    public static android.app.AlertDialog.Builder a(String s1, String as[], android.content.DialogInterface.OnClickListener onclicklistener)
    {
        return (new android.app.AlertDialog.Builder(com.j.a.d.e.e().p())).setTitle(s1).setItems(as, onclicklistener).setCancelable(true);
    }

    public static View a(int l, RecyclerView recyclerview)
    {
        android.support.v7.widget.RecyclerView.h h1 = recyclerview.getLayoutManager();
        if (!(h1 instanceof LinearLayoutManager)) goto _L2; else goto _L1
_L1:
        int i1 = ((LinearLayoutManager)h1).i();
_L4:
        i1 = l - i1;
        if (i1 < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (l < recyclerview.getChildCount())
        {
            try
            {
                recyclerview = recyclerview.getChildAt(i1);
            }
            // Misplaced declaration of an exception variable
            catch (RecyclerView recyclerview)
            {
                return null;
            }
            return recyclerview;
        }
        break; /* Loop/switch isn't completed */
_L2:
        i1 = 0;
        if (true) goto _L4; else goto _L3
_L3:
        return null;
    }

    public static View a(int l, ListView listview)
    {
        l -= listview.getFirstVisiblePosition() - listview.getHeaderViewsCount();
        if (l < 0)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        if (l >= listview.getChildCount())
        {
            return null;
        }
        listview = listview.getChildAt(l);
        return listview;
        listview;
        return null;
    }

    public static RelativeLayout a(t t1, String s1, String s2)
    {
        RelativeLayout relativelayout;
        LinearLayout linearlayout;
        LinearLayout linearlayout1;
        LinearLayout linearlayout2;
        relativelayout = new RelativeLayout(com.j.a.d.e.e().o());
        linearlayout = new LinearLayout(com.j.a.d.e.e().o());
        linearlayout1 = new LinearLayout(com.j.a.d.e.e().o());
        linearlayout2 = new LinearLayout(com.j.a.d.e.e().o());
        linearlayout.setOrientation(1);
        if (!t1.equals(t.a)) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder;
label0:
        {
            stringbuilder = (new StringBuilder()).append("Experiment: ");
            if (s1 != null)
            {
                t1 = s1;
                if (!s1.equals(""))
                {
                    break label0;
                }
            }
            t1 = "loading...";
        }
label1:
        {
            s1 = stringbuilder.append(t1).toString();
            stringbuilder = (new StringBuilder()).append("Variation: ");
            if (s2 != null)
            {
                t1 = s2;
                if (!s2.equals(""))
                {
                    break label1;
                }
            }
            t1 = "loading...";
        }
        t1 = stringbuilder.append(t1).toString();
        linearlayout.setOnLongClickListener(new s());
_L4:
        if (com.j.a.d.e.e().h())
        {
            s2 = a("Taplytics SDK\nUpdate Available", 0, 0, a(2.0F), 0);
            s2.setGravity(17);
            s2.setTextSize(2, 8F);
            linearlayout2.addView(s2);
            linearlayout2.setGravity(0x800005);
        }
        s1 = a(s1, com.j.a.f.b.d(), -8, 0, 0);
        t1 = a(((String) (t1)), com.j.a.f.b.c(), 0, 0, 0);
        linearlayout.addView(s1);
        linearlayout.addView(t1);
        t1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        t1.addRule(13);
        linearlayout.setLayoutParams(t1);
        t1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        t1.addRule(11);
        t1.addRule(15);
        linearlayout2.setLayoutParams(t1);
        relativelayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, a(35F)));
        relativelayout.addView(linearlayout1);
        relativelayout.addView(linearlayout);
        relativelayout.addView(linearlayout2);
        return relativelayout;
_L2:
        s1 = com.j.a.f.b.a(t1);
        t1 = com.j.a.f.b.b(t1);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static TextView a(String s1, int l, int i1, int j1, int k1)
    {
        TextView textview = new TextView(com.j.a.d.e.e().p());
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams.setMargins(k1, 0, j1, i1);
        textview.setText(s1);
        textview.setTextColor(-1);
        textview.setGravity(1);
        textview.setId(l);
        layoutparams.gravity = 49;
        textview.setLayoutParams(layoutparams);
        return textview;
    }

    public static d a(t t1)
    {
        d d1 = new d(com.j.a.d.e.e().o());
        android.widget.FrameLayout.LayoutParams layoutparams;
        layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutparams.setMargins(0, a(com.j.a.d.e.e().o()), 0, 0);
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        d1.setBackground(new b(com.j.a.f.f.a(t1), 2.0F));
_L1:
        d1.setLayoutParams(layoutparams);
        d1.setId(com.j.a.f.b.b());
        d1.setTag(t1.name());
        return d1;
        try
        {
            d1.setBackgroundDrawable(new b(com.j.a.f.f.a(t1), 2.0F));
        }
        // Misplaced declaration of an exception variable
        catch (t t1)
        {
            com.j.a.g.w.b("border", t1);
            return d1;
        }
          goto _L1
    }

    private static Class a(Class class1)
    {
        Class class2 = null;
        if (i.a().d().contains(class1.getSimpleName()))
        {
            return class1;
        }
        if (!class1.getSimpleName().equals("Object"))
        {
            class2 = a(class1.getSuperclass());
        }
        return class2;
    }

    public static ArrayList a(float f1, float f2, ViewGroup viewgroup)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        viewgroup = b(viewgroup).listIterator();
_L14:
        if (!viewgroup.hasNext()) goto _L2; else goto _L1
_L1:
        View view;
        int ai[];
        view = (View)viewgroup.next();
        if (arraylist.contains(view))
        {
            continue; /* Loop/switch isn't completed */
        }
        ai = new int[2];
        view.getLocationOnScreen(ai);
        int l;
        int i1;
        l = ai[0];
        i1 = ai[1];
        if (f1 <= (float)l)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (f1 >= (float)(l + view.getWidth()) || f2 <= (float)i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (f2 >= (float)(i1 + view.getHeight()) || view.getId() == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!(view instanceof AbsListView)) goto _L4; else goto _L3
_L3:
        int ai1[];
        ai1 = new int[2];
        i1 = ((AbsListView)view).getChildCount();
        l = 0;
_L12:
        if (l >= i1) goto _L4; else goto _L5
_L5:
        Object obj;
        View view1;
        obj = ((AbsListView)view).getChildAt(l);
        view1 = new View(com.j.a.d.e.e().p());
        ((View) (obj)).getLocationOnScreen(ai1);
        int j1;
        int k1;
        j1 = ai1[0];
        k1 = ai1[1];
        if (f1 <= (float)j1) goto _L7; else goto _L6
_L6:
        if (f1 >= (float)(j1 + view.getWidth()) || f2 <= (float)k1) goto _L7; else goto _L8
_L8:
        if (f2 >= (float)(view.getHeight() + k1)) goto _L7; else goto _L9
_L9:
        if (!(obj instanceof ViewGroup)) goto _L11; else goto _L10
_L10:
        ArrayList arraylist1 = b((ViewGroup)obj);
        view1.setTag(Integer.valueOf(l));
        view1.setId(a());
        ((ViewGroup)obj).addView(view1);
        for (obj = arraylist1.iterator(); ((Iterator) (obj)).hasNext(); viewgroup.add((View)((Iterator) (obj)).next())) { }
          goto _L4
_L11:
        viewgroup.add(obj);
_L4:
        if (!arraylist.contains(view))
        {
            arraylist.add(view);
        }
        continue; /* Loop/switch isn't completed */
_L7:
        l++;
        if (true) goto _L12; else goto _L2
_L2:
        Collections.reverse(arraylist);
        return arraylist;
        Throwable throwable;
        throwable;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public static JSONObject a(View view)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        Object obj;
        Object obj1;
        Object obj2;
        String as[];
        android.content.res.Resources.NotFoundException notfoundexception;
        int l;
        try
        {
            jsonobject.put("id", view.getId());
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return jsonobject;
        }
        obj = "";
        obj2 = com.j.a.d.e.e().o().getResources().getResourceEntryName(view.getId());
        obj = obj2;
_L5:
        jsonobject.put("identifier", obj);
        obj = a(view.getClass());
        obj2 = view.getClass().getSimpleName();
        jsonobject.put("baseClass", ((Class) (obj)).getSimpleName());
        if (!((Class) (obj)).getSimpleName().equals(obj2))
        {
            jsonobject.put("class", obj2);
        }
        jsonobject.put("subClasses", b(view));
        if (com.j.a.d.e.e().p() != null)
        {
            jsonobject.put("activity", com.j.a.d.e.e().p().getClass().getSimpleName());
        }
        jsonobject.put("methodInfo", u.a(view.getClass(), view));
        jsonobject.put("position", d(view));
        l = com.j.a.g.a.a(view);
        if (l == -2)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        jsonobject.put("fragId", l);
        obj2 = (String)((Pair)ab.a().b().get(Integer.valueOf(l))).second;
        jsonobject.put("fragIdentifier", obj2);
        if (((String) (obj2)).contains("_viewpager_"))
        {
            obj = new JSONObject();
            as = ((String) (obj2)).split("_");
            if (as.length > 0)
            {
                ((JSONObject) (obj)).put("position", Integer.valueOf(as[as.length - 1]));
                jsonobject.put("cellInfo", obj);
            }
        }
_L1:
        obj = e(view);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_338;
        }
        jsonobject.put("isInListView", true);
        if (a(((AbsListView) (obj)), view) != -1)
        {
            as = new JSONObject();
            as.put("position", a(((AbsListView) (obj)), view));
            jsonobject.put("cellInfo", as);
        }
        obj = f(view);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_395;
        }
        jsonobject.put("isInRecycler", true);
        if (a(((RecyclerView) (obj)), view) != -1)
        {
            as = new JSONObject();
            as.put("position", a(((RecyclerView) (obj)), view));
            jsonobject.put("cellInfo", as);
        }
_L2:
        jsonobject.put("imgFileName", y.a(view));
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            jsonobject.put("hasOnClick", view.hasOnClickListeners());
        }
        break MISSING_BLOCK_LABEL_472;
        obj1;
        w.a("error setting viewpager fragment id");
          goto _L1
        obj1;
        if (!(obj1 instanceof Exception))
        {
            break MISSING_BLOCK_LABEL_463;
        }
        obj1 = (Exception)obj1;
_L3:
        com.j.a.g.w.b("recview err", ((Exception) (obj1)));
          goto _L2
        obj1 = null;
          goto _L3
        notfoundexception;
        if (true) goto _L5; else goto _L4
_L4:
        return jsonobject;
    }

    static void a(int l, ViewGroup viewgroup, int i1, JSONObject jsonobject)
    {
        d(l, viewgroup, i1, jsonobject);
    }

    public static void a(AlertDialog alertdialog, int l)
    {
        alertdialog = alertdialog.getWindow();
        android.view.WindowManager.LayoutParams layoutparams = alertdialog.getAttributes();
        layoutparams.gravity = l;
        layoutparams.flags = layoutparams.flags & -3;
        alertdialog.setAttributes(layoutparams);
    }

    private static void a(ViewGroup viewgroup, int l, String s1, JSONObject jsonobject)
    {
        Object obj = viewgroup;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        obj = viewgroup;
        if (s1.equals("")) goto _L2; else goto _L3
_L3:
        obj = viewgroup;
        if (!s1.contains("_viewpager_")) goto _L2; else goto _L4
_L4:
        if (!(viewgroup instanceof ViewPager)) goto _L6; else goto _L5
_L5:
        obj = (ViewPager)viewgroup;
_L14:
        int i1;
        obj = ((ViewPager) (obj)).getAdapter();
        s1 = s1.split("_");
        i1 = Integer.valueOf(s1[s1.length - 1]).intValue();
        if (!(obj instanceof j)) goto _L8; else goto _L7
_L7:
        s1 = ((j)obj).a(i1);
_L15:
        if (s1 == null) goto _L10; else goto _L9
_L9:
        if (s1.getView() == null || !(s1.getView() instanceof ViewGroup)) goto _L10; else goto _L11
_L11:
        obj = (ViewGroup)s1.getView();
_L2:
        if (obj != null)
        {
            viewgroup = ((ViewGroup) (obj)).findViewById(l);
            if (viewgroup != null)
            {
                w.a((new StringBuilder()).append("Found View: ").append(viewgroup.getClass().getSimpleName()).toString());
                a(jsonobject, ((View) (viewgroup)));
            }
        }
_L10:
        return;
_L6:
        obj = viewgroup.findViewById(com.j.a.g.a.b());
        if (obj == null) goto _L10; else goto _L12
_L12:
        if (!(((View) (obj)).getParent() instanceof ViewPager)) goto _L10; else goto _L13
_L13:
        obj = (ViewPager)((View) (obj)).getParent();
          goto _L14
_L8:
        if (ab.a().f() == null)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        s1 = (Fragment)ab.a().f().invoke(obj, new Object[] {
            Integer.valueOf(i1)
        });
          goto _L15
        s1;
        obj = viewgroup;
          goto _L2
        s1 = null;
          goto _L15
    }

    static void a(ViewGroup viewgroup, int l, JSONObject jsonobject)
    {
        b(viewgroup, l, jsonobject);
    }

    public static void a(ViewGroup viewgroup, boolean flag)
    {
        Object obj;
        Object obj2;
        int l;
        int i1;
        boolean flag1;
        boolean flag2;
        try
        {
            if (!com.j.a.d.e.e().j())
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            com.j.a.g.w.b("Attaching listeners:", viewgroup);
            return;
        }
        i1 = viewgroup.getChildCount();
        l = 0;
_L12:
        if (l >= i1) goto _L2; else goto _L1
_L1:
        flag1 = flag;
        obj = viewgroup.getChildAt(l);
        flag2 = flag;
        flag1 = flag;
        if (!(obj instanceof ViewGroup))
        {
            break MISSING_BLOCK_LABEL_114;
        }
        flag2 = flag;
        flag1 = flag;
        if (((View) (obj)).getId() == com.j.a.f.b.a())
        {
            break MISSING_BLOCK_LABEL_114;
        }
        flag2 = flag;
        flag1 = flag;
        if (((View) (obj)).getId() == com.j.a.f.b.b())
        {
            break MISSING_BLOCK_LABEL_114;
        }
        flag2 = flag;
        flag1 = flag;
        if (com.j.a.g.a.a((ViewGroup)obj, flag))
        {
            flag2 = true;
        }
        flag1 = flag2;
        a((ViewGroup)obj, flag2);
        flag1 = flag2;
        if (!(obj instanceof AbsListView)) goto _L4; else goto _L3
_L3:
        flag1 = flag2;
        if (m.a(com.j.a.g.b.i)) goto _L4; else goto _L5
_L5:
        flag1 = flag2;
        obj2 = (AbsListView)obj;
        obj = null;
_L6:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        if (((Class) (obj)).getSimpleName().equals("View") || ((Class) (obj)).getSimpleName().equals("AbsListView"))
        {
            break MISSING_BLOCK_LABEL_199;
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        obj = obj2.getClass();
          goto _L6
        obj = ((Class) (obj)).getSuperclass();
          goto _L6
        obj = ((Class) (obj)).getDeclaredField("mOnScrollListener");
        ((Field) (obj)).setAccessible(true);
        android.widget.AbsListView.OnScrollListener onscrolllistener = (android.widget.AbsListView.OnScrollListener)((Field) (obj)).get(obj2);
        if (!(onscrolllistener instanceof h))
        {
            ((Field) (obj)).set(obj2, new h(onscrolllistener));
        }
_L10:
        flag = flag2;
_L7:
        l++;
        continue; /* Loop/switch isn't completed */
        obj;
        flag1 = flag2;
        try
        {
            com.j.a.g.w.b("Problem getting OnScrollListener for ListView", ((Exception) (obj)));
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            flag = flag1;
        }
        com.j.a.g.w.b("Attaching listeners:", ((Exception) (obj)));
        if (true) goto _L7; else goto _L4
_L4:
        flag1 = flag2;
        if (!(obj instanceof RecyclerView))
        {
            continue; /* Loop/switch isn't completed */
        }
        flag1 = flag2;
        if (m.a(com.j.a.g.b.j))
        {
            continue; /* Loop/switch isn't completed */
        }
        flag1 = flag2;
        obj2 = (RecyclerView)obj;
        obj = null;
_L9:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_359;
        }
        if (((Class) (obj)).getSimpleName().equals("View") || ((Class) (obj)).getSimpleName().equals("RecyclerView"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_371;
        }
        obj = obj2.getClass();
        continue; /* Loop/switch isn't completed */
        obj = ((Class) (obj)).getSuperclass();
        if (true) goto _L9; else goto _L8
_L8:
        obj = ((Class) (obj)).getDeclaredField("mScrollListener");
        ((Field) (obj)).setAccessible(true);
        android.support.v7.widget.RecyclerView.k k1 = (android.support.v7.widget.RecyclerView.k)((Field) (obj)).get(obj2);
        if (!(k1 instanceof k))
        {
            ((Field) (obj)).set(obj2, new k(k1));
        }
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        flag1 = flag2;
        com.j.a.g.w.b("Problem getting OnScrollListener for RecyclerView", ((Exception) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L10; else goto _L2
_L2:
        return;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private static void a(JSONObject jsonobject, View view)
    {
        jsonobject = jsonobject.optJSONObject("anProperties");
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = jsonobject.keys();
_L3:
        String s1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (String)iterator.next();
        try
        {
            if (jsonobject.get(s1) instanceof JSONObject)
            {
                JSONObject jsonobject1 = jsonobject.optJSONObject(s1);
                u.a(view, s1, jsonobject1.opt("value"), jsonobject1.optString("type"));
            }
        }
        catch (JSONException jsonexception) { }
        if (true) goto _L3; else goto _L2
        jsonobject;
        if (jsonobject instanceof Exception)
        {
            jsonobject = (Exception)jsonobject;
        } else
        {
            jsonobject = new Exception();
        }
        w.a("Problem applying methods", jsonobject);
_L2:
    }

    public static boolean a(AlertDialog alertdialog)
    {
        return alertdialog != null && alertdialog.isShowing();
    }

    public static boolean a(ViewGroup viewgroup)
    {
        return viewgroup != null && viewgroup.findViewById(com.j.a.f.b.b()) != null;
    }

    public static int b(float f1)
    {
        return Math.round(f1 / ((float)com.j.a.d.e.e().o().getResources().getDisplayMetrics().densityDpi / 160F));
    }

    public static Button b(float f1, float f2, ViewGroup viewgroup)
    {
        for (viewgroup = b(viewgroup).iterator(); viewgroup.hasNext();)
        {
            View view = (View)viewgroup.next();
            if (view instanceof Button)
            {
                int ai[] = new int[2];
                view.getLocationOnScreen(ai);
                int l = ai[0];
                int i1 = ai[1];
                if (f1 > (float)l && f1 < (float)(l + view.getWidth()) && f2 > (float)i1 && f2 < (float)(i1 + view.getHeight()) && view.getId() != -1)
                {
                    return (Button)view;
                }
            }
        }

        return null;
    }

    public static com.j.a.f.e b()
    {
        com.j.a.f.e e1 = new com.j.a.f.e(com.j.a.d.e.e().o());
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutparams.setMargins(0, a(com.j.a.d.e.e().o()), 0, 0);
        e1.setLayoutParams(layoutparams);
        e1.setId(com.j.a.f.b.a());
        return e1;
    }

    public static ArrayList b(ViewGroup viewgroup)
    {
        ArrayList arraylist = new ArrayList();
        int i1;
        if (!viewgroup.getClass().getName().contains("DecorView"))
        {
            arraylist.add(viewgroup);
        }
        i1 = viewgroup.getChildCount();
        int l = 0;
_L2:
        if (l >= i1)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        View view = viewgroup.getChildAt(l);
        if ((view instanceof ViewGroup) && view.getId() != com.j.a.f.b.a() && view.getId() != com.j.a.f.b.b())
        {
            arraylist.addAll(b((ViewGroup)view));
            break MISSING_BLOCK_LABEL_142;
        }
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        try
        {
            if (!(view instanceof ViewStub) && view.getId() != com.j.a.f.b.a() && view.getId() != com.j.a.f.b.b())
            {
                arraylist.add(view);
            }
            break MISSING_BLOCK_LABEL_142;
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            com.j.a.g.w.b("Finding all views: ", viewgroup);
        }
        return arraylist;
        l++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static JSONArray b(View view)
    {
        JSONArray jsonarray = new JSONArray();
        try
        {
            view = view.getClass();
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            com.j.a.g.w.b("Class hierarchy: ", view);
            return jsonarray;
        }
        if (view == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (view.getSimpleName().equals("View"))
        {
            break; /* Loop/switch isn't completed */
        }
        jsonarray.put(view.getSimpleName());
        view = view.getSuperclass();
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_13;
_L1:
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        jsonarray.put(view.getSimpleName());
        return jsonarray;
    }

    static void b(int l, ViewGroup viewgroup, int i1, JSONObject jsonobject)
    {
        c(l, viewgroup, i1, jsonobject);
    }

    private static void b(ViewGroup viewgroup, int l, JSONObject jsonobject)
    {
        if (!(viewgroup instanceof AbsListView)) goto _L2; else goto _L1
_L1:
        if (!m.a(com.j.a.g.b.i)) goto _L4; else goto _L3
_L3:
        return;
_L2:
        boolean flag = viewgroup instanceof RecyclerView;
        if (flag) goto _L3; else goto _L4
_L4:
        ArrayList arraylist = new ArrayList();
_L6:
        if (viewgroup.findViewById(l) == null)
        {
            break; /* Loop/switch isn't completed */
        }
        View view = viewgroup.findViewById(l);
        if (view != null)
        {
            try
            {
                a(jsonobject, view);
                arraylist.add(new Pair(view, Integer.valueOf(view.getId())));
                view.setId(0);
            }
            catch (Throwable throwable) { }
        }
        if (true) goto _L6; else goto _L5
_L5:
        viewgroup = arraylist.iterator();
        while (viewgroup.hasNext()) 
        {
            jsonobject = (Pair)viewgroup.next();
            try
            {
                ((View)((Pair) (jsonobject)).first).setId(((Integer)((Pair) (jsonobject)).second).intValue());
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject) { }
        }
          goto _L3
        Exception exception;
        exception;
          goto _L4
    }

    public static ViewGroup c(View view)
    {
        return (ViewGroup)view.getParent();
    }

    private static void c(int l, ViewGroup viewgroup, int i1, JSONObject jsonobject)
    {
        if (m.a(com.j.a.g.b.i))
        {
            return;
        }
        viewgroup = viewgroup.findViewById(i1);
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        viewgroup = (ListView)e(viewgroup);
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        viewgroup = a(l, viewgroup);
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        viewgroup = viewgroup.findViewById(i1);
        if (viewgroup != null)
        {
            try
            {
                a(jsonobject, viewgroup);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup) { }
        }
    }

    public static void c(ViewGroup viewgroup)
        throws JSONException
    {
        if (m.a(com.j.a.g.b.k) || com.j.a.d.e.e().k() == null || !com.j.a.d.e.e().j()) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        HashMap hashmap;
        w.a((new StringBuilder()).append("Setting properties to view: ").append(viewgroup.getClass().getSimpleName()).toString());
        jsonarray = com.j.a.d.e.e().k().j();
        hashmap = com.j.a.d.e.e().k().a();
        if (jsonarray == null) goto _L2; else goto _L3
_L3:
        int l = 0;
_L19:
        if (l >= jsonarray.length()) goto _L2; else goto _L4
_L4:
        Object obj;
        Object obj1;
        Object obj2;
        String s1;
        JSONObject jsonobject;
        int i1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        obj = (JSONObject)jsonarray.opt(l);
        obj1 = ((JSONObject) (obj)).optJSONObject("initProperties");
        obj2 = ((JSONObject) (obj)).optString("_view");
        i1 = ((JSONObject) (obj1)).optInt("fragId");
        s1 = ((JSONObject) (obj1)).optString("fragIdentifier");
        flag = ((JSONObject) (obj1)).has("isInListView");
        flag1 = ((JSONObject) (obj1)).has("isInRecycler");
        flag2 = ((JSONObject) (obj)).optBoolean("cellElement");
        jsonobject = ((JSONObject) (obj1)).optJSONObject("cellInfo");
        if (!hashmap.containsKey(obj2) || !((String)hashmap.get(obj2)).equals(com.j.a.d.e.e().p().getClass().getSimpleName())) goto _L6; else goto _L5
_L5:
        if (i1 == 0) goto _L8; else goto _L7
_L7:
        if (s1 == null) goto _L10; else goto _L9
_L9:
        if (ab.a().b().containsKey(Integer.valueOf(i1)) && ((String)((Pair)ab.a().b().get(Integer.valueOf(i1))).second).equals(s1)) goto _L8; else goto _L10
_L10:
        if (!ab.a().b().containsKey(Integer.valueOf(i1)) || ab.a().c().isEmpty()) goto _L6; else goto _L8
_L8:
        int j1 = ((JSONObject) (obj1)).optInt("anID");
        if (!flag && !flag1 || !flag2) goto _L12; else goto _L11
_L11:
        obj1 = new Handler(Looper.getMainLooper());
        obj2 = new p(viewgroup, j1, ((JSONObject) (obj)));
        int k1;
        long l1;
        if (i1 == 0)
        {
            l1 = 10L;
        } else
        {
            l1 = 285L;
        }
        ((Handler) (obj1)).postDelayed(((Runnable) (obj2)), l1);
        b(viewgroup, j1, ((JSONObject) (obj)));
          goto _L6
_L20:
        if (jsonobject == null) goto _L14; else goto _L13
_L13:
        if (jsonobject.length() <= 0) goto _L14; else goto _L15
_L15:
        k1 = jsonobject.optInt("position");
        if (k1 == -1)
        {
            break MISSING_BLOCK_LABEL_460;
        }
        obj1 = new Handler(Looper.getMainLooper());
        obj2 = new r(flag1, k1, viewgroup, j1, ((JSONObject) (obj)));
        if (i1 == 0)
        {
            l1 = 10L;
        } else
        {
            l1 = 285L;
        }
        ((Handler) (obj1)).postDelayed(((Runnable) (obj2)), l1);
        c(k1, viewgroup, j1, ((JSONObject) (obj)));
        d(k1, viewgroup, j1, ((JSONObject) (obj)));
          goto _L6
        obj;
        com.j.a.g.w.b("Some issues with lists or something", ((Exception) (obj)));
          goto _L6
        viewgroup;
        com.j.a.g.w.b("Critical: SetProps didn't work", viewgroup);
_L2:
        return;
_L14:
        if (s1 == null) goto _L17; else goto _L16
_L16:
        if (s1.equals("")) goto _L17; else goto _L18
_L18:
        a(viewgroup, j1, s1, ((JSONObject) (obj)));
          goto _L6
_L17:
        c(viewgroup, j1, ((JSONObject) (obj)));
_L6:
        l++;
          goto _L19
_L12:
        if (!flag && !flag1) goto _L14; else goto _L20
    }

    private static void c(ViewGroup viewgroup, int l, JSONObject jsonobject)
    {
        if (viewgroup != null)
        {
            viewgroup = viewgroup.findViewById(l);
            if (viewgroup != null)
            {
                w.a((new StringBuilder()).append("Found View: ").append(viewgroup.getClass().getSimpleName()).toString());
                a(jsonobject, viewgroup);
            }
        }
    }

    private static JSONObject d(View view)
        throws JSONException
    {
        JSONObject jsonobject;
        JSONObject jsonobject1;
        jsonobject = new JSONObject();
        jsonobject1 = new JSONObject();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        jsonobject.put("startX", ai[0]);
        jsonobject.put("startY", ai[1]);
        jsonobject.put("endX", ai[0] + view.getWidth());
        jsonobject.put("endY", ai[1] + view.getHeight());
        if (com.j.a.d.e.e().p() == null) goto _L2; else goto _L1
_L1:
        Object obj;
        view = com.j.a.d.e.e().p().getWindowManager().getDefaultDisplay();
        obj = new DisplayMetrics();
        view.getMetrics(((DisplayMetrics) (obj)));
        int l = ((DisplayMetrics) (obj)).widthPixels;
        int k1 = ((DisplayMetrics) (obj)).heightPixels;
        int i1 = l;
_L3:
        int j1;
        j1 = k1;
        l = i1;
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        j1 = k1;
        l = i1;
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        l = i1;
        i1 = ((Integer)android/view/Display.getMethod("getRawWidth", new Class[0]).invoke(view, new Object[0])).intValue();
        l = i1;
        j1 = ((Integer)android/view/Display.getMethod("getRawHeight", new Class[0]).invoke(view, new Object[0])).intValue();
        l = i1;
_L4:
        k1 = j1;
        i1 = l;
        if (android.os.Build.VERSION.SDK_INT < 17)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        i1 = l;
        obj = new Point();
        i1 = l;
        android/view/Display.getMethod("getRealSize", new Class[] {
            android/graphics/Point
        }).invoke(view, new Object[] {
            obj
        });
        i1 = l;
        l = ((Point) (obj)).x;
        i1 = l;
        k1 = ((Point) (obj)).y;
        i1 = l;
_L5:
        jsonobject1.put("width", i1);
        jsonobject1.put("height", k1);
_L2:
        jsonobject.put("screenDimensions", jsonobject1);
        Exception exception;
        if (!(jsonobject instanceof JSONObject))
        {
            view = jsonobject.toString();
        } else
        {
            view = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        w.a(view);
        return jsonobject;
        exception;
        l = 0;
_L6:
        k1 = 0;
        i1 = l;
          goto _L3
        exception;
        com.j.a.g.w.b("getting screen dimensions, but probably fine to ignore", exception);
        j1 = k1;
          goto _L4
        view;
        k1 = j1;
          goto _L5
        Exception exception1;
        exception1;
          goto _L6
    }

    private static void d(int l, ViewGroup viewgroup, int i1, JSONObject jsonobject)
    {
        if (m.a(com.j.a.g.b.j))
        {
            return;
        }
        viewgroup = viewgroup.findViewById(i1);
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        viewgroup = f(viewgroup);
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        viewgroup = a(l, viewgroup);
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        viewgroup = viewgroup.findViewById(i1);
        if (viewgroup != null)
        {
            try
            {
                a(jsonobject, viewgroup);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup) { }
        }
    }

    private static AbsListView e(View view)
    {
        view = c(view);
        if (view != ag.c().d() && (view instanceof AbsListView))
        {
            return (AbsListView)view;
        }
        if (view != ag.c().d() && view != null)
        {
            try
            {
                view = e(view);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return null;
            }
            return view;
        } else
        {
            return null;
        }
    }

    private static RecyclerView f(View view)
    {
        view = c(view);
        if (view != ag.c().d() && (view instanceof RecyclerView))
        {
            return (RecyclerView)view;
        }
        if (view != ag.c().d() && view != null)
        {
            try
            {
                view = f(view);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return null;
            }
            return view;
        } else
        {
            return null;
        }
    }
}

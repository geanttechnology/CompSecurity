// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.instagram;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import com.socialin.android.activity.FragmentActionsListener;
import com.socialin.android.util.Utils;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.bx.a;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.instagram:
//            c, h

public abstract class d extends Fragment
{

    private static final String c = com/socialin/android/instagram/d.getSimpleName();
    a a;
    int b;
    private int d;
    private GridView e;
    private ProgressBar f;
    private View g;
    private List h;
    private FragmentActionsListener i;
    private int j;
    private volatile boolean k;

    public d()
    {
        d = 3;
        j = -1;
        k = false;
        b = 0x7f03013c;
    }

    static a a(d d1, a a1)
    {
        d1.a = a1;
        return a1;
    }

    static void a(d d1, int i1)
    {
        Object obj = (a)d1.e.getAdapter();
        int k1 = ((a) (obj)).getCount();
        if (k1 != 0)
        {
            c c1 = (c)((a) (obj)).getItem(i1);
            String as[] = new String[k1];
            String as1[] = new String[k1];
            for (int j1 = 0; j1 < k1; j1++)
            {
                as[j1] = ((c)((a) (obj)).getItem(j1)).c;
                as1[j1] = ((c)((a) (obj)).getItem(j1)).b;
            }

            obj = new JSONArray();
            d1.i.onFragmentImageSelected(c1.c, false, as, as1, i1, ((JSONArray) (obj)));
        }
    }

    static void a(d d1, List list)
    {
        d1.getActivity().runOnUiThread(d1. new Runnable(list) {

            private List a;
            private d b;

            public final void run()
            {
                if (b.getActivity() == null || b.getActivity().isFinishing())
                {
                    return;
                }
                d d2 = b;
                android.widget.ListAdapter listadapter;
                if (d.b(b).getAdapter() instanceof a)
                {
                    listadapter = d.b(b).getAdapter();
                } else
                {
                    listadapter = null;
                }
                com.socialin.android.instagram.d.a(d2, (a)listadapter);
                if (d.i(b) == null)
                {
                    d.j(b);
                    com.socialin.android.instagram.d.a(b, new a(b.getActivity().getApplicationContext(), a, d.k(b)));
                    d.l(b);
                }
                d.i(b).notifyDataSetChanged();
            }

            
            {
                b = d.this;
                a = list;
                super();
            }
        });
    }

    static boolean a(d d1)
    {
        return d1.k;
    }

    static boolean a(d d1, boolean flag)
    {
        d1.k = flag;
        return flag;
    }

    static GridView b(d d1)
    {
        return d1.e;
    }

    static void c(d d1)
    {
        d1.i();
    }

    static void d(d d1)
    {
        if (d1.getActivity() != null && !d1.getActivity().isFinishing())
        {
            d1.getActivity().runOnUiThread(d1. new Runnable() {

                private d a;

                public final void run()
                {
                    d.m(a).setVisibility(0);
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
    }

    static void e(d d1)
    {
        if (d1.getActivity() != null && !d1.getActivity().isFinishing())
        {
            d1.getActivity().runOnUiThread(d1. new Runnable() {

                private d a;

                public final void run()
                {
                    d.n(a).setVisibility(8);
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
    }

    static String f()
    {
        return c;
    }

    static List f(d d1)
    {
        return d1.h;
    }

    private void g()
    {
        if (getActivity() != null)
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            j = displaymetrics.widthPixels / Utils.a(displaymetrics) - d;
        }
    }

    static void g(d d1)
    {
        if (d1.getActivity() != null && !d1.getActivity().isFinishing())
        {
            d1.getActivity().runOnUiThread(d1. new Runnable() {

                private d a;

                public final void run()
                {
                    d.n(a).setVisibility(0);
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
    }

    private void h()
    {
        e.setColumnWidth(j);
        e.setAdapter(a);
        e.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private d a;

            public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                com.socialin.android.instagram.d.a(a, i1);
            }

            
            {
                a = d.this;
                super();
            }
        });
        e.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            private d a;

            public final void onScroll(AbsListView abslistview, int i1, int j1, int k1)
            {
                if (!com.socialin.android.instagram.d.a(a) && d.b(a).getAdapter() != null && (i1 + j1) - 1 == d.b(a).getCount() - 1)
                {
                    d.c(a);
                }
            }

            public final void onScrollStateChanged(AbsListView abslistview, int i1)
            {
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    static void h(d d1)
    {
        if (d1.getActivity() != null && !d1.getActivity().isFinishing())
        {
            d1.getActivity().runOnUiThread(d1. new Runnable() {

                private d a;

                public final void run()
                {
                    d.m(a).setVisibility(8);
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
    }

    static a i(d d1)
    {
        return d1.a;
    }

    private void i()
    {
        (new Thread() {

            private d a;

            public final void run()
            {
                List list;
                d.d(a);
                d.e(a);
                com.socialin.android.instagram.d.a(a, true);
                list = a.a();
                if (list == null)
                {
                    break MISSING_BLOCK_LABEL_46;
                }
                int i1 = list.size();
                if (i1 != 0)
                {
                    break MISSING_BLOCK_LABEL_54;
                }
                d.h(a);
                return;
                d.f(a).addAll(list);
                com.socialin.android.instagram.d.a(a, d.f(a));
                com.socialin.android.instagram.d.a(a, false);
                d.h(a);
                return;
                Object obj;
                obj;
                d.g(a);
                com.socialin.android.d.b(d.f(), new Object[] {
                    "loadPhotos", obj
                });
                d.h(a);
                return;
                obj;
                d.h(a);
                throw obj;
            }

            
            {
                a = d.this;
                super();
            }
        }).start();
    }

    static void j(d d1)
    {
        d1.g();
    }

    static int k(d d1)
    {
        return d1.j;
    }

    static void l(d d1)
    {
        d1.h();
    }

    static ProgressBar m(d d1)
    {
        return d1.f;
    }

    static View n(d d1)
    {
        return d1.g;
    }

    public final c a(JSONObject jsonobject)
    {
        String s = jsonobject.get("id").toString();
        if (!com.socialin.android.instagram.h.a(s, h))
        {
            JSONObject jsonobject2 = jsonobject.getJSONObject("images");
            jsonobject = jsonobject2.getJSONObject("thumbnail");
            JSONObject jsonobject1 = jsonobject2.getJSONObject("low_resolution");
            jsonobject2 = jsonobject2.getJSONObject("standard_resolution");
            c c1 = new c();
            c1.a = s;
            c1.b = jsonobject.get("url").toString();
            jsonobject1.get("url").toString();
            c1.c = jsonobject2.get("url").toString();
            return c1;
        } else
        {
            return null;
        }
    }

    abstract List a();

    public final void a(int i1)
    {
        f.setVisibility(i1);
        e.setVisibility(i1);
    }

    abstract void b();

    public void c()
    {
        d();
        e();
    }

    public final void d()
    {
        a(0);
        d = (int)Utils.a(1.0F, getActivity().getApplicationContext()) + 1;
        if (getActivity() instanceof FragmentActionsListener)
        {
            i = (FragmentActionsListener)getActivity();
        }
        if (h == null)
        {
            h = new ArrayList();
        }
    }

    public final void e()
    {
        if (a != null)
        {
            g();
            a a1 = a;
            a1.b = j;
            WindowManager windowmanager = (WindowManager)a1.a.getSystemService("window");
            DisplayMetrics displaymetrics = new DisplayMetrics();
            windowmanager.getDefaultDisplay().getMetrics(displaymetrics);
            a1.c = displaymetrics.widthPixels / a1.b;
            h();
            return;
        } else
        {
            i();
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setRetainInstance(true);
        c();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        c();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(b, null);
        e = (GridView)layoutinflater.findViewById(0x7f10068e);
        f = (ProgressBar)layoutinflater.findViewById(0x7f1003fe);
        g = layoutinflater.findViewById(0x7f10068f);
        b();
        return layoutinflater;
    }

}

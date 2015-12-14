// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cx;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.socialin.android.activity.FragmentActionsListener;
import com.socialin.android.util.Utils;
import java.util.List;
import myobfuscated.cv.b;
import myobfuscated.cw.a;
import org.json.JSONArray;

// Referenced classes of package myobfuscated.cx:
//            e

public abstract class d extends Fragment
{

    public static final String a = myobfuscated/cx/d.getSimpleName();
    public int b;
    public int c;
    public int d;
    public boolean e;
    private FragmentActionsListener f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private TextView l;
    private View m;
    private int n;
    private int o;
    private boolean p;
    private String q;
    private View r;
    private GridView s;
    private a t;

    public d()
    {
        g = 1;
        h = 60;
        i = 3;
        j = false;
        k = false;
        b = 8;
        n = 1;
        o = -1;
        c = 0;
        d = 0;
        e = false;
        p = false;
        q = "";
        t = null;
    }

    static void a(d d1)
    {
        View view = d1.getView().findViewById(0x7f100a64);
        view.startAnimation(AnimationUtils.loadAnimation(d1.getActivity(), 0x7f050000));
        view.setVisibility(8);
        if (d1.getActivity() != null && d1.getView() != null)
        {
            d1.j = true;
            com.socialin.android.d.b(a, new Object[] {
                "multiple check- enabled"
            });
        }
    }

    static void a(d d1, int i1)
    {
        Object obj;
        int k1;
        k1 = 0;
        obj = null;
        a a1 = (a)d1.s.getAdapter();
        int j1 = a1.getCount();
_L3:
        if (a1 != null && j1 != 0) goto _L2; else goto _L1
_L1:
        return;
        Exception exception;
        exception;
        a1 = ((a) (obj));
        obj = exception;
_L5:
        com.socialin.android.d.a(a, ((Throwable) (obj)));
        j1 = 0;
          goto _L3
_L2:
        Object obj1;
        String as[];
        String as1[];
        obj = (b)a1.getItem(i1);
        if (!d1.j && d1.f != null)
        {
            try
            {
                d1.f.showFragmentProgressDialog("", d1.getString(0x7f08043d), true);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                com.socialin.android.d.b(a, new Object[] {
                    obj1
                });
            }
        }
        if (d1.f == null) goto _L1; else goto _L4
_L4:
        obj1 = new JSONArray();
        ((JSONArray) (obj1)).put(myobfuscated.cy.d.a(d1.getActivity(), ((b) (obj)).a));
        as = new String[j1];
        as1 = new String[j1];
        do
        {
            if (k1 >= j1)
            {
                break;
            }
            try
            {
                as1[k1] = ((b)a1.getItem(k1)).d;
                as[k1] = ((b)a1.getItem(k1)).c;
            }
            catch (IndexOutOfBoundsException indexoutofboundsexception)
            {
                if (d1.f != null)
                {
                    d1.f.dismissFragmentProgressDialog();
                }
                com.socialin.android.d.a(a, indexoutofboundsexception);
                return;
            }
            k1++;
        } while (true);
        d1.f.onFragmentImageSelected(((b) (obj)).c, true, as, as1, i1, ((JSONArray) (obj1)));
        return;
        obj;
          goto _L5
    }

    static void a(d d1, List list, boolean flag)
    {
        if (!(d1.s.getAdapter() instanceof a)) goto _L2; else goto _L1
_L1:
        android.widget.ListAdapter listadapter = d1.s.getAdapter();
_L3:
        d1.t = (a)listadapter;
        if (d1.t == null)
        {
            d1.t = new a(d1.getActivity(), list, d1.h, d1.k);
            d1.t.b = d1.i;
            d1.s.setColumnWidth(d1.h);
            d1.s.setNumColumns(d1.i);
            d1.s.setHorizontalSpacing(d1.n);
            d1.s.setVerticalSpacing(d1.n);
            d1.s.setAdapter(d1.t);
            d1.s.setOnItemClickListener(d1. new android.widget.AdapterView.OnItemClickListener() {

                private d a;

                public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
                {
                    myobfuscated.cx.d.a(a, i1);
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        d1.t.addAll(list);
_L4:
        d1.t.notifyDataSetChanged();
        if (d1.t.getCount() == d1.d)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            d1.e = flag;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            com.socialin.android.d.a(a, list);
        }
        d1.p = false;
        d1.s.setVisibility(0);
        return;
_L2:
        listadapter = null;
          goto _L3
        d1.t.clear();
        d1.t.addAll(list);
          goto _L4
    }

    static void a(d d1, boolean flag)
    {
        Object obj;
        try
        {
            obj = d1.a(d1.q);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(a, "requestData", ((Throwable) (obj)));
            d1.e();
            if (!flag)
            {
                d1.b(d1.getString(0x7f08024e));
            }
            d1.p = false;
            return;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((List) (obj)).isEmpty()) goto _L2; else goto _L3
_L3:
        if (d1.getActivity() == null) goto _L5; else goto _L4
_L4:
        if (d1.getActivity().isFinishing())
        {
            return;
        }
        d1.e();
        if (d1.s == null)
        {
            d1.s = (GridView)d1.getView().findViewById(0x7f100a62);
        }
        if (!((List) (obj)).isEmpty() || flag) goto _L7; else goto _L6
_L6:
        d1.b(d1.getString(0x7f0803f9));
_L8:
        d1.getActivity().runOnUiThread(d1. new Runnable(((List) (obj)), flag) {

            private List a;
            private boolean b;
            private d c;

            public final void run()
            {
                myobfuscated.cx.d.a(c, a, b);
            }

            
            {
                c = d.this;
                a = list;
                b = flag;
                super();
            }
        });
        return;
_L7:
        int i1;
        if (d1.getActivity() != null)
        {
            d1.getActivity().runOnUiThread(d1. new Runnable() {

                private d a;

                public final void run()
                {
                    if (d.c(a) != null)
                    {
                        d.c(a).setVisibility(8);
                    }
                    if (d.d(a) != null)
                    {
                        d.d(a).setVisibility(8);
                    }
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
        if (d1.t == null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        i1 = d1.t.getCount();
_L9:
        boolean flag1;
        if (((List) (obj)).size() < d1.b && i1 < d1.d)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        d1.e = flag1;
          goto _L8
_L2:
        d1.e();
        d1.p = false;
_L5:
        return;
        i1 = 0;
          goto _L9
    }

    private void a(boolean flag)
    {
        if (p || getActivity() == null || getView() == null)
        {
            return;
        }
        if (c > d)
        {
            e();
            p = false;
            return;
        }
        if (!flag)
        {
            b(false);
            b(getString(0x7f0803d8));
        } else
        {
            d();
        }
        p = true;
        a();
        (new Thread(new Runnable(flag) {

            private boolean a;
            private d b;

            public final void run()
            {
                myobfuscated.cx.d.a(b, a);
            }

            
            {
                b = d.this;
                a = flag;
                super();
            }
        })).start();
    }

    static int b(d d1, int i1)
    {
        d1.o = i1;
        return i1;
    }

    private void b(String s1)
    {
        if (getActivity() != null)
        {
            getActivity().runOnUiThread(new Runnable(s1) {

                private String a;
                private d b;

                public final void run()
                {
                    if (d.c(b) != null)
                    {
                        d.c(b).setText(a);
                        d.c(b).setVisibility(0);
                    }
                    if (d.d(b) != null)
                    {
                        d.d(b).setVisibility(8);
                    }
                }

            
            {
                b = d.this;
                a = s1;
                super();
            }
            });
        }
    }

    static void b(d d1)
    {
        d1.c();
        d1.t.a = d1.h;
        d1.t.b = d1.i;
        d1.t.notifyDataSetChanged();
        d1.s.setNumColumns(d1.i);
        d1.s.setColumnWidth(d1.h);
        d1.s.setHorizontalSpacing(d1.n);
        d1.s.setVerticalSpacing(d1.n);
        try
        {
            ((a)d1.s.getAdapter()).b = d1.i;
            if (d1.o >= 0)
            {
                d1.s.setSelection(d1.o);
            }
        }
        catch (Exception exception)
        {
            com.socialin.android.d.a(a, exception);
        }
        d1.s.invalidate();
    }

    private void b(boolean flag)
    {
        if (getActivity() == null || getActivity().isFinishing() || s.getAdapter() == null || !(s.getAdapter() instanceof a))
        {
            break MISSING_BLOCK_LABEL_101;
        }
        a a1;
        try
        {
            ((a)s.getAdapter()).clear();
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(a, "clearData", exception);
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        a1 = (a)s.getAdapter();
        if (com.bumptech.glide.b.a(a1.getContext()) != null)
        {
            com.bumptech.glide.b.a(a1.getContext()).a();
        }
        ((a)s.getAdapter()).notifyDataSetChanged();
    }

    static TextView c(d d1)
    {
        return d1.l;
    }

    private void c()
    {
        if (getActivity() != null)
        {
            int i1 = 3;
            double d1 = g;
            DisplayMetrics displaymetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            int j1 = Math.min(displaymetrics.widthPixels, displaymetrics.heightPixels);
            float f1 = (float)j1 / getResources().getDisplayMetrics().density;
            if (f1 >= 400F)
            {
                i1 = 4;
            }
            if (f1 >= 750F)
            {
                i1 = 5;
            }
            h = (int)(((double)j1 - d1) / (double)i1 - (double)g);
            i1 = displaymetrics.widthPixels / h;
            h = (int)(((double)displaymetrics.widthPixels - d1) / (double)i1 - (double)g);
            i = displaymetrics.widthPixels / h;
        }
    }

    static View d(d d1)
    {
        return d1.m;
    }

    private void d()
    {
        if (getActivity() != null && r != null)
        {
            getActivity().runOnUiThread(new Runnable() {

                private d a;

                public final void run()
                {
                    d.e(a).setVisibility(0);
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
    }

    static View e(d d1)
    {
        return d1.r;
    }

    private void e()
    {
        if (getActivity() != null && r != null)
        {
            getActivity().runOnUiThread(new Runnable() {

                private d a;

                public final void run()
                {
                    d.e(a).setVisibility(8);
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
    }

    static GridView f(d d1)
    {
        return d1.s;
    }

    static boolean g(d d1)
    {
        return d1.e;
    }

    static boolean h(d d1)
    {
        return d1.p;
    }

    static void i(d d1)
    {
        GridView gridview = d1.s;
        gridview;
        JVM INSTR monitorenter ;
        if (d1.c >= d1.d)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        d1.d();
        d1.a(true);
_L2:
        return;
        d1.p = false;
        d1.e();
        if (true) goto _L2; else goto _L1
_L1:
        d1;
        gridview;
        JVM INSTR monitorexit ;
        throw d1;
    }

    public abstract List a(String s1);

    public void a()
    {
        c = c + b;
    }

    public final void a(int i1)
    {
        com.socialin.android.d.a(a, (new StringBuilder("setStartIndex: ")).append(i1).toString());
        c = i1;
    }

    public final void b(int i1)
    {
        com.socialin.android.d.a(a, (new StringBuilder("setTotalResult: ")).append(i1).toString());
        d = i1;
    }

    public final boolean b()
    {
        return TextUtils.isEmpty(q) || "interesting".equals(q);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        g = (int)Utils.a(1.0F, getActivity());
        n = (int)Utils.a(1.0F, getActivity().getApplicationContext());
        bundle = getActivity().getIntent();
        if (bundle.hasExtra("fromApp"))
        {
            k = "viewer".equals(bundle.getStringExtra("fromApp"));
        }
        if (bundle.hasExtra("multipleCheckMode"))
        {
            j = bundle.getBooleanExtra("multipleCheckMode", false);
        }
        l = (TextView)getView().findViewById(0x7f100a61);
        l.setVisibility(8);
        r = getView().findViewById(0x7f100a63);
        r.setVisibility(8);
        m = getView().findViewById(0x7f100a60);
        m.setVisibility(8);
        c();
        s = (GridView)getView().findViewById(0x7f100a62);
        s.setOnScrollListener(new e(this, (byte)0));
        ((RelativeLayout)getView().findViewById(0x7f100128)).setVisibility(8);
        ((TextView)getView().findViewById(0x7f100a66)).setText(q);
        if (!k)
        {
            getView().findViewById(0x7f100a64).setVisibility(8);
        } else
        {
            getView().findViewById(0x7f100a64).setVisibility(0);
            getView().findViewById(0x7f100a67).setOnClickListener(new android.view.View.OnClickListener() {

                private d a;

                public final void onClick(View view)
                {
                    myobfuscated.cx.d.a(a);
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
        ((FragmentActionsListener)getActivity()).onFragmentLoaded();
        bundle = getActivity();
        if (bundle != null)
        {
            bundle.runOnUiThread(new Runnable(bundle) {

                private Activity a;

                public final void run()
                {
                    if (a.getCurrentFocus() == null)
                    {
                        a.getWindow().setSoftInputMode(3);
                        return;
                    }
                    try
                    {
                        ((InputMethodManager)a.getSystemService("input_method")).hideSoftInputFromWindow(a.getCurrentFocus().getWindowToken(), 2);
                        return;
                    }
                    catch (Exception exception)
                    {
                        com.socialin.android.d.b(myobfuscated.cx.d.a, "hide Keayboard", exception);
                    }
                    return;
                }

            
            {
                a = activity;
                super();
            }
            });
        }
        if (t != null)
        {
            t.a = h;
            t.notifyDataSetChanged();
        }
        a(false);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            f = (FragmentActionsListener)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            com.socialin.android.d.b(a, "onAttach", classcastexception);
        }
        throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement FragmentActionsListener").toString());
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (getActivity() != null && s != null && s.getAdapter() != null)
        {
            getActivity().runOnUiThread(new Runnable() {

                private d a;

                public final void run()
                {
                    myobfuscated.cx.d.b(a);
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            bundle = getArguments();
        }
        if (bundle == null)
        {
            bundle = null;
        } else
        {
            bundle = bundle.getString("tag");
        }
        q = bundle;
        if (TextUtils.isEmpty(q))
        {
            q = "interesting";
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030243, null);
    }

    public void onDestroy()
    {
        super.onDestroy();
        b(true);
    }

    public void onDetach()
    {
        super.onDetach();
        f = null;
    }

}

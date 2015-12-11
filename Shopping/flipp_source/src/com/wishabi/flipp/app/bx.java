// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wishabi.flipp.b.aa;
import com.wishabi.flipp.b.ab;
import com.wishabi.flipp.content.FlyerInfo;
import com.wishabi.flipp.content.bb;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.q;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.wishabi.flipp.app:
//            dl, ca, cb, cc, 
//            by

public class bx extends dl
{

    private static final String a = com/wishabi/flipp/app/bx.getSimpleName();
    private ScrollView c;
    private ProgressBar d;
    private LinearLayout e;
    private TextView f;
    private LinearLayout g;
    private TextView h;
    private LinearLayout i;
    private TextView j;
    private TextView k;
    private TextView l;
    private int m;
    private String n;
    private boolean o;
    private boolean p;
    private FlyerInfo q;
    private String r;
    private boolean s;
    private boolean t;
    private ab u;
    private aa v;
    private boolean w;

    public bx()
    {
    }

    static int a(bx bx1)
    {
        return bx1.m;
    }

    public static Bundle a(int i1, String s1, boolean flag, boolean flag1)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("flyer_id", i1);
        bundle.putString("merchant_name", s1);
        bundle.putBoolean("web_indexed", flag);
        bundle.putBoolean("no_prices", flag1);
        return bundle;
    }

    public static bx a(Bundle bundle)
    {
        bx bx1 = new bx();
        bx1.setArguments(bundle);
        return bx1;
    }

    static void a(bx bx1, FlyerInfo flyerinfo)
    {
        bx1.a(flyerinfo);
    }

    static void a(bx bx1, String s1)
    {
        bx1.a(s1);
    }

    private void a(FlyerInfo flyerinfo)
    {
        LayoutInflater layoutinflater;
        q = flyerinfo;
        layoutinflater = getActivity().getLayoutInflater();
        if (q.a.isEmpty()) goto _L2; else goto _L1
_L1:
        int i1;
        if (q.a.size() == 1)
        {
            i1 = 0x7f0e0121;
        } else
        {
            i1 = 0x7f0e0122;
        }
        if (Locale.getDefault().getLanguage().equalsIgnoreCase("fr"))
        {
            flyerinfo = com.wishabi.flipp.util.q.a();
        } else
        {
            flyerinfo = com.wishabi.flipp.util.q.a(com.wishabi.flipp.util.q.a());
        }
        flyerinfo = getString(i1, new Object[] {
            flyerinfo, r
        });
        a(q.a, ((ViewGroup) (e)), f, layoutinflater, ((String) (flyerinfo)));
        if (e.getChildCount() <= 0) goto _L2; else goto _L3
_L3:
        i1 = 1;
_L5:
        int j1 = i1;
        if (!q.b.isEmpty())
        {
            if (q.b.size() == 1)
            {
                j1 = 0x7f0e00e3;
            } else
            {
                j1 = 0x7f0e00e4;
            }
            flyerinfo = getString(j1);
            a(q.b, ((ViewGroup) (g)), h, layoutinflater, ((String) (flyerinfo)));
            j1 = i1;
            if (g.getChildCount() > 0)
            {
                j1 = 1;
            }
        }
        if (q.c != null)
        {
            i.setVisibility(0);
            i.setOnClickListener(new ca(this));
        }
        if (o)
        {
            flyerinfo = new StringBuilder();
            if (p)
            {
                flyerinfo.append(getResources().getString(0x7f0e0090));
                flyerinfo.append("\n\n");
            }
            flyerinfo.append(getResources().getString(0x7f0e0091));
            j.setText(flyerinfo);
            j.setVisibility(0);
        }
        if (!s)
        {
            l.setVisibility(0);
            if (j1 != 0)
            {
                l.setText(0x7f0e00d0);
            } else
            {
                l.setText(0x7f0e00cf);
            }
        } else
        if (j1 != 0 && !t)
        {
            l.setVisibility(0);
            l.setText(getString(0x7f0e00d1));
        }
        if (f.getVisibility() != 0 && h.getVisibility() != 0 && i.getVisibility() != 0 && j.getVisibility() != 0 && l.getVisibility() != 0)
        {
            a(getString(0x7f0e00d2, new Object[] {
                com.wishabi.flipp.util.q.a()
            }));
            return;
        } else
        {
            i1 = getResources().getInteger(0x10e0000);
            c.setVisibility(0);
            c.animate().alpha(1.0F).setDuration(i1);
            d.animate().alpha(0.0F).setDuration(i1).setListener(new cb(this));
            return;
        }
_L2:
        i1 = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void a(String s1)
    {
        k.setVisibility(0);
        k.setText(s1);
        d.setVisibility(8);
    }

    private void a(ArrayList arraylist, ViewGroup viewgroup, TextView textview, LayoutInflater layoutinflater, String s1)
    {
        Iterator iterator;
        boolean flag;
        iterator = arraylist.iterator();
        flag = false;
_L2:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = (bb)iterator.next();
        String s2;
        String s3;
        String s4;
        Object obj1;
        View view;
        TextView textview1;
        TextView textview2;
        TextView textview3;
        if (((bb) (obj)).e != null)
        {
            arraylist = ((bb) (obj)).e;
        } else
        {
            arraylist = "";
        }
        if (((bb) (obj)).a != null)
        {
            s2 = ((bb) (obj)).a;
        } else
        {
            s2 = "";
        }
        if (((bb) (obj)).b != null)
        {
            s3 = ((bb) (obj)).b;
        } else
        {
            s3 = "";
        }
        if (((bb) (obj)).c != null)
        {
            s4 = ((bb) (obj)).c;
        } else
        {
            s4 = "";
        }
        if (((bb) (obj)).d != null)
        {
            obj = ((bb) (obj)).d;
        } else
        {
            obj = "";
        }
        if (s2.equals("") || s3.equals(""))
        {
            continue; /* Loop/switch isn't completed */
        }
        view = layoutinflater.inflate(0x7f03002d, viewgroup, true);
        textview1 = (TextView)view.findViewById(0x7f0b00be);
        textview2 = (TextView)view.findViewById(0x7f0b00bf);
        textview3 = (TextView)view.findViewById(0x7f0b00c0);
        ((FrameLayout)view.findViewById(0x7f0b00c1)).setVisibility(8);
        obj1 = arraylist;
        if (arraylist.equals(""))
        {
            obj1 = n;
        }
        textview1.setText(((CharSequence) (obj1)));
        textview2.setText(s2);
        textview3.setText(s3);
        arraylist = String.format("%s, %s, %s, %s", new Object[] {
            s2, s3, s4, obj
        });
        s2 = URLEncoder.encode(arraylist, "UTF-8");
        arraylist = s2;
_L3:
        view.setOnClickListener(new cc(this, arraylist));
        flag = true;
        if (true) goto _L2; else goto _L1
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        String.format("Can't URL encode address: %s", new Object[] {
            arraylist
        });
          goto _L3
_L1:
        if (flag)
        {
            textview.setVisibility(0);
            textview.setText(s1);
            viewgroup.setVisibility(0);
        }
        return;
    }

    static boolean a(bx bx1, boolean flag)
    {
        bx1.t = flag;
        return flag;
    }

    static String b(bx bx1)
    {
        return bx1.r;
    }

    private void b()
    {
        c.setVisibility(8);
        c.setAlpha(0.0F);
        d.setVisibility(0);
        d.setAlpha(1.0F);
        l.setVisibility(8);
        f.setVisibility(8);
        e.removeAllViews();
        e.setVisibility(8);
        h.setVisibility(8);
        g.removeAllViews();
        g.setVisibility(8);
        i.setVisibility(8);
        j.setVisibility(8);
        k.setVisibility(8);
    }

    static boolean b(bx bx1, boolean flag)
    {
        bx1.s = flag;
        return flag;
    }

    static ab c(bx bx1)
    {
        bx1.u = null;
        return null;
    }

    private void c()
    {
        if (u != null)
        {
            u.a();
            u = null;
        }
        if (v != null)
        {
            v.cancel(true);
            v = null;
        }
    }

    static aa d(bx bx1)
    {
        bx1.v = null;
        return null;
    }

    static FlyerInfo e(bx bx1)
    {
        return bx1.q;
    }

    static ProgressBar f(bx bx1)
    {
        return bx1.d;
    }

    static boolean g(bx bx1)
    {
        return bx1.w;
    }

    static boolean h(bx bx1)
    {
        bx1.w = true;
        return true;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            bundle = getArguments();
        }
        if (bundle != null)
        {
            m = bundle.getInt("flyer_id");
            n = bundle.getString("merchant_name");
            o = bundle.getBoolean("web_indexed");
            p = bundle.getBoolean("no_prices");
            s = bundle.getBoolean("location_services_on");
            t = bundle.getBoolean("found_lat_lon");
            q = (FlyerInfo)bundle.getParcelable("flyer_info");
        }
        r = com.wishabi.flipp.util.k.a(null);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03002c, viewgroup, false);
        if (layoutinflater == null)
        {
            return null;
        } else
        {
            c = (ScrollView)layoutinflater.findViewById(0x7f0b00b4);
            d = (ProgressBar)layoutinflater.findViewById(0x7f0b00bc);
            l = (TextView)layoutinflater.findViewById(0x7f0b00b5);
            e = (LinearLayout)layoutinflater.findViewById(0x7f0b00b7);
            f = (TextView)layoutinflater.findViewById(0x7f0b00b6);
            g = (LinearLayout)layoutinflater.findViewById(0x7f0b00b9);
            h = (TextView)layoutinflater.findViewById(0x7f0b00b8);
            i = (LinearLayout)layoutinflater.findViewById(0x7f0b00ba);
            j = (TextView)layoutinflater.findViewById(0x7f0b00bb);
            k = (TextView)layoutinflater.findViewById(0x7f0b00bd);
            return layoutinflater;
        }
    }

    public void onResume()
    {
        super.onResume();
        w = false;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("flyer_id", m);
        bundle.putString("merchant_name", n);
        bundle.putBoolean("web_indexed", o);
        bundle.putBoolean("no_prices", p);
        bundle.putBoolean("location_services_on", s);
        bundle.putBoolean("found_lat_lon", t);
        bundle.putParcelable("flyer_info", q);
    }

    public void onStart()
    {
label0:
        {
            super.onStart();
            if (q == null)
            {
                b();
                if (getActivity() != null && r != null)
                {
                    break label0;
                }
                a(getString(0x7f0e00ce, new Object[] {
                    com.wishabi.flipp.util.q.a()
                }));
            }
            return;
        }
        c();
        u = new by(this, getActivity());
        u.a(0x927c0L);
    }

    public void onStop()
    {
        super.onStop();
        c();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        b(getString(0x7f0e00bd));
        if (q != null)
        {
            b();
            a(q);
        }
    }

}

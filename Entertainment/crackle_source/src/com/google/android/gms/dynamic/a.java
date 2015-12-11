// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.dynamic:
//            LifecycleDelegate, d

public abstract class com.google.android.gms.dynamic.a
{
    private static interface a
    {

        public abstract void b(LifecycleDelegate lifecycledelegate);

        public abstract int getState();
    }


    private LifecycleDelegate ss;
    private Bundle st;
    private LinkedList su;
    private final d sv = new d() {

        final com.google.android.gms.dynamic.a sw;

        public void a(LifecycleDelegate lifecycledelegate)
        {
            com.google.android.gms.dynamic.a.a(sw, lifecycledelegate);
            for (lifecycledelegate = com.google.android.gms.dynamic.a.a(sw).iterator(); lifecycledelegate.hasNext(); ((a)lifecycledelegate.next()).b(com.google.android.gms.dynamic.a.b(sw))) { }
            com.google.android.gms.dynamic.a.a(sw).clear();
            com.google.android.gms.dynamic.a.a(sw, null);
        }

            
            {
                sw = com.google.android.gms.dynamic.a.this;
                super();
            }
    };

    public com.google.android.gms.dynamic.a()
    {
    }

    static Bundle a(com.google.android.gms.dynamic.a a1, Bundle bundle)
    {
        a1.st = bundle;
        return bundle;
    }

    static LifecycleDelegate a(com.google.android.gms.dynamic.a a1, LifecycleDelegate lifecycledelegate)
    {
        a1.ss = lifecycledelegate;
        return lifecycledelegate;
    }

    static LinkedList a(com.google.android.gms.dynamic.a a1)
    {
        return a1.su;
    }

    private void a(Bundle bundle, a a1)
    {
        if (ss != null)
        {
            a1.b(ss);
            return;
        }
        if (su == null)
        {
            su = new LinkedList();
        }
        su.add(a1);
        if (bundle != null)
        {
            if (st == null)
            {
                st = (Bundle)bundle.clone();
            } else
            {
                st.putAll(bundle);
            }
        }
        a(sv);
    }

    private void ay(int i)
    {
        for (; !su.isEmpty() && ((a)su.getLast()).getState() >= i; su.removeLast()) { }
    }

    static LifecycleDelegate b(com.google.android.gms.dynamic.a a1)
    {
        return a1.ss;
    }

    public void a(FrameLayout framelayout)
    {
        Context context = framelayout.getContext();
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String s1 = GooglePlayServicesUtil.b(context, i, -1);
        String s = GooglePlayServicesUtil.b(context, i);
        LinearLayout linearlayout = new LinearLayout(framelayout.getContext());
        linearlayout.setOrientation(1);
        linearlayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
        framelayout.addView(linearlayout);
        framelayout = new TextView(framelayout.getContext());
        framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
        framelayout.setText(s1);
        linearlayout.addView(framelayout);
        if (s != null)
        {
            framelayout = new Button(context);
            framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
            framelayout.setText(s);
            linearlayout.addView(framelayout);
            framelayout.setOnClickListener(new android.view.View.OnClickListener(context, i) {

                final Context hF;
                final int sD;
                final com.google.android.gms.dynamic.a sw;

                public void onClick(View view)
                {
                    hF.startActivity(GooglePlayServicesUtil.a(hF, sD, -1));
                }

            
            {
                sw = com.google.android.gms.dynamic.a.this;
                hF = context;
                sD = i;
                super();
            }
            });
        }
    }

    protected abstract void a(d d);

    public LifecycleDelegate cZ()
    {
        return ss;
    }

    public void onCreate(Bundle bundle)
    {
        a(bundle, new a(bundle) {

            final com.google.android.gms.dynamic.a sw;
            final Bundle sz;

            public void b(LifecycleDelegate lifecycledelegate)
            {
                com.google.android.gms.dynamic.a.b(sw).onCreate(sz);
            }

            public int getState()
            {
                return 1;
            }

            
            {
                sw = com.google.android.gms.dynamic.a.this;
                sz = bundle;
                super();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        FrameLayout framelayout = new FrameLayout(layoutinflater.getContext());
        a(bundle, new a(framelayout, layoutinflater, viewgroup, bundle) {

            final FrameLayout sA;
            final LayoutInflater sB;
            final ViewGroup sC;
            final com.google.android.gms.dynamic.a sw;
            final Bundle sz;

            public void b(LifecycleDelegate lifecycledelegate)
            {
                sA.removeAllViews();
                sA.addView(com.google.android.gms.dynamic.a.b(sw).onCreateView(sB, sC, sz));
            }

            public int getState()
            {
                return 2;
            }

            
            {
                sw = com.google.android.gms.dynamic.a.this;
                sA = framelayout;
                sB = layoutinflater;
                sC = viewgroup;
                sz = bundle;
                super();
            }
        });
        if (ss == null)
        {
            a(framelayout);
        }
        return framelayout;
    }

    public void onDestroy()
    {
        if (ss != null)
        {
            ss.onDestroy();
            return;
        } else
        {
            ay(1);
            return;
        }
    }

    public void onDestroyView()
    {
        if (ss != null)
        {
            ss.onDestroyView();
            return;
        } else
        {
            ay(2);
            return;
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
    {
        a(bundle1, new a(activity, bundle, bundle1) {

            final com.google.android.gms.dynamic.a sw;
            final Activity sx;
            final Bundle sy;
            final Bundle sz;

            public void b(LifecycleDelegate lifecycledelegate)
            {
                com.google.android.gms.dynamic.a.b(sw).onInflate(sx, sy, sz);
            }

            public int getState()
            {
                return 0;
            }

            
            {
                sw = com.google.android.gms.dynamic.a.this;
                sx = activity;
                sy = bundle;
                sz = bundle1;
                super();
            }
        });
    }

    public void onLowMemory()
    {
        if (ss != null)
        {
            ss.onLowMemory();
        }
    }

    public void onPause()
    {
        if (ss != null)
        {
            ss.onPause();
            return;
        } else
        {
            ay(3);
            return;
        }
    }

    public void onResume()
    {
        a(((Bundle) (null)), new a() {

            final com.google.android.gms.dynamic.a sw;

            public void b(LifecycleDelegate lifecycledelegate)
            {
                com.google.android.gms.dynamic.a.b(sw).onResume();
            }

            public int getState()
            {
                return 3;
            }

            
            {
                sw = com.google.android.gms.dynamic.a.this;
                super();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (ss != null)
        {
            ss.onSaveInstanceState(bundle);
        } else
        if (st != null)
        {
            bundle.putAll(st);
            return;
        }
    }
}

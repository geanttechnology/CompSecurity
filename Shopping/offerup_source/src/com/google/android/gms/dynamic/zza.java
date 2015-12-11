// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzg;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.dynamic:
//            LifecycleDelegate, zzf

public abstract class zza
{

    private LifecycleDelegate zzapn;
    private Bundle zzapo;
    private LinkedList zzapp;
    private final zzf zzapq = new _cls1();

    public zza()
    {
    }

    static Bundle zza(zza zza1, Bundle bundle)
    {
        zza1.zzapo = bundle;
        return bundle;
    }

    static LifecycleDelegate zza(zza zza1, LifecycleDelegate lifecycledelegate)
    {
        zza1.zzapn = lifecycledelegate;
        return lifecycledelegate;
    }

    static LinkedList zza(zza zza1)
    {
        return zza1.zzapp;
    }

    private void zza(Bundle bundle, zza zza1)
    {
        if (zzapn != null)
        {
            zza1.zzb(zzapn);
            return;
        }
        if (zzapp == null)
        {
            zzapp = new LinkedList();
        }
        zzapp.add(zza1);
        if (bundle != null)
        {
            if (zzapo == null)
            {
                zzapo = (Bundle)bundle.clone();
            } else
            {
                zzapo.putAll(bundle);
            }
        }
        zza(zzapq);
    }

    static LifecycleDelegate zzb(com.google.android.gms.dynamic.zza zza1)
    {
        return zza1.zzapn;
    }

    public static void zzb(FrameLayout framelayout)
    {
        Context context = framelayout.getContext();
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String s1 = zzg.zzc(context, i, GooglePlayServicesUtil.zzaf(context));
        String s = zzg.zzh(context, i);
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
            framelayout.setOnClickListener(new _cls5(context, i));
        }
    }

    private void zzer(int i)
    {
        for (; !zzapp.isEmpty() && ((zza)zzapp.getLast()).getState() >= i; zzapp.removeLast()) { }
    }

    public void onCreate(Bundle bundle)
    {
        zza(bundle, new _cls3(bundle));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        FrameLayout framelayout = new FrameLayout(layoutinflater.getContext());
        zza(bundle, new _cls4(framelayout, layoutinflater, viewgroup, bundle));
        if (zzapn == null)
        {
            zza(framelayout);
        }
        return framelayout;
    }

    public void onDestroy()
    {
        if (zzapn != null)
        {
            zzapn.onDestroy();
            return;
        } else
        {
            zzer(1);
            return;
        }
    }

    public void onDestroyView()
    {
        if (zzapn != null)
        {
            zzapn.onDestroyView();
            return;
        } else
        {
            zzer(2);
            return;
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
    {
        zza(bundle1, new _cls2(activity, bundle, bundle1));
    }

    public void onLowMemory()
    {
        if (zzapn != null)
        {
            zzapn.onLowMemory();
        }
    }

    public void onPause()
    {
        if (zzapn != null)
        {
            zzapn.onPause();
            return;
        } else
        {
            zzer(5);
            return;
        }
    }

    public void onResume()
    {
        zza(((Bundle) (null)), new _cls7());
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (zzapn != null)
        {
            zzapn.onSaveInstanceState(bundle);
        } else
        if (zzapo != null)
        {
            bundle.putAll(zzapo);
            return;
        }
    }

    public void onStart()
    {
        zza(((Bundle) (null)), new _cls6());
    }

    public void onStop()
    {
        if (zzapn != null)
        {
            zzapn.onStop();
            return;
        } else
        {
            zzer(4);
            return;
        }
    }

    protected void zza(FrameLayout framelayout)
    {
        zzb(framelayout);
    }

    protected abstract void zza(zzf zzf);

    public LifecycleDelegate zzrZ()
    {
        return zzapn;
    }

    private class _cls1
        implements zzf
    {

        final com.google.android.gms.dynamic.zza zzapr;

        public void zza(LifecycleDelegate lifecycledelegate)
        {
            com.google.android.gms.dynamic.zza.zza(zzapr, lifecycledelegate);
            for (lifecycledelegate = com.google.android.gms.dynamic.zza.zza(zzapr).iterator(); lifecycledelegate.hasNext(); ((zza)lifecycledelegate.next()).zzb(com.google.android.gms.dynamic.zza.zzb(zzapr))) { }
            com.google.android.gms.dynamic.zza.zza(zzapr).clear();
            com.google.android.gms.dynamic.zza.zza(zzapr, null);
        }

        _cls1()
        {
            zzapr = zza.this;
            super();
        }
    }


    private class zza
    {

        public abstract int getState();

        public abstract void zzb(LifecycleDelegate lifecycledelegate);
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final int zzapy;
        final Context zzry;

        public final void onClick(View view)
        {
            zzry.startActivity(GooglePlayServicesUtil.zzbj(zzapy));
        }

        _cls5(Context context, int i)
        {
            zzry = context;
            zzapy = i;
            super();
        }
    }


    private class _cls3
        implements zza
    {

        final com.google.android.gms.dynamic.zza zzapr;
        final Bundle zzapu;

        public int getState()
        {
            return 1;
        }

        public void zzb(LifecycleDelegate lifecycledelegate)
        {
            com.google.android.gms.dynamic.zza.zzb(zzapr).onCreate(zzapu);
        }

        _cls3(Bundle bundle)
        {
            zzapr = com.google.android.gms.dynamic.zza.this;
            zzapu = bundle;
            super();
        }
    }


    private class _cls4
        implements zza
    {

        final com.google.android.gms.dynamic.zza zzapr;
        final Bundle zzapu;
        final FrameLayout zzapv;
        final LayoutInflater zzapw;
        final ViewGroup zzapx;

        public int getState()
        {
            return 2;
        }

        public void zzb(LifecycleDelegate lifecycledelegate)
        {
            zzapv.removeAllViews();
            zzapv.addView(com.google.android.gms.dynamic.zza.zzb(zzapr).onCreateView(zzapw, zzapx, zzapu));
        }

        _cls4(FrameLayout framelayout, LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            zzapr = com.google.android.gms.dynamic.zza.this;
            zzapv = framelayout;
            zzapw = layoutinflater;
            zzapx = viewgroup;
            zzapu = bundle;
            super();
        }
    }


    private class _cls2
        implements zza
    {

        final com.google.android.gms.dynamic.zza zzapr;
        final Activity zzaps;
        final Bundle zzapt;
        final Bundle zzapu;

        public int getState()
        {
            return 0;
        }

        public void zzb(LifecycleDelegate lifecycledelegate)
        {
            com.google.android.gms.dynamic.zza.zzb(zzapr).onInflate(zzaps, zzapt, zzapu);
        }

        _cls2(Activity activity, Bundle bundle, Bundle bundle1)
        {
            zzapr = com.google.android.gms.dynamic.zza.this;
            zzaps = activity;
            zzapt = bundle;
            zzapu = bundle1;
            super();
        }
    }


    private class _cls7
        implements zza
    {

        final com.google.android.gms.dynamic.zza zzapr;

        public int getState()
        {
            return 5;
        }

        public void zzb(LifecycleDelegate lifecycledelegate)
        {
            com.google.android.gms.dynamic.zza.zzb(zzapr).onResume();
        }

        _cls7()
        {
            zzapr = com.google.android.gms.dynamic.zza.this;
            super();
        }
    }


    private class _cls6
        implements zza
    {

        final com.google.android.gms.dynamic.zza zzapr;

        public int getState()
        {
            return 4;
        }

        public void zzb(LifecycleDelegate lifecycledelegate)
        {
            com.google.android.gms.dynamic.zza.zzb(zzapr).onStart();
        }

        _cls6()
        {
            zzapr = com.google.android.gms.dynamic.zza.this;
            super();
        }
    }

}

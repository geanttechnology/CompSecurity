// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.global;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.application.PIPCameraApplication;
import eh;
import kd;

public class NewAlertDialogFragment extends DialogFragment
{

    private Button a;
    private Button b;
    private TextView c;
    private TextView d;
    private String e;
    private String f;
    private String g;
    private String h;
    private kd i;
    private View j;
    private RelativeLayout k;

    public NewAlertDialogFragment()
    {
    }

    static kd a(NewAlertDialogFragment newalertdialogfragment)
    {
        return newalertdialogfragment.i;
    }

    public void a()
    {
        android.view.animation.Animation animation = AnimationUtils.loadAnimation(PIPCameraApplication.a, 0x7f040012);
        android.view.animation.Animation animation1 = AnimationUtils.loadAnimation(PIPCameraApplication.a, 0x7f04001e);
        j.startAnimation(animation);
        k.startAnimation(animation1);
    }

    public void a(eh eh1)
    {
        if (eh1 == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if (eh1.i() != null && !eh1.i().isEmpty())
        {
            e = eh1.i();
            if (a != null)
            {
                a.setText(e);
            }
        }
        if (eh1.h() != null && !eh1.h().isEmpty())
        {
            f = eh1.h();
            if (b != null)
            {
                b.setText(f);
            }
        }
        g = eh1.f();
        if (c != null)
        {
            c.setText(g);
        }
        h = eh1.g();
        if (d != null)
        {
            d.setText(h);
        }
        return;
        eh1;
        Crashlytics.logException(eh1);
        return;
    }

    public void a(kd kd)
    {
        i = kd;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(1, 0x1030011);
        setCancelable(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030038, viewgroup, false);
        j = layoutinflater.findViewById(0x7f0c0118);
        k = (RelativeLayout)layoutinflater.findViewById(0x7f0c0119);
        a = (Button)layoutinflater.findViewById(0x7f0c0122);
        if (e != null && !e.isEmpty())
        {
            a.setText(e);
        }
        b = (Button)layoutinflater.findViewById(0x7f0c0120);
        if (f != null && !f.isEmpty())
        {
            b.setText(f);
        }
        c = (TextView)layoutinflater.findViewById(0x7f0c011b);
        if (g != null && !g.isEmpty())
        {
            c.setText(g);
        }
        d = (TextView)layoutinflater.findViewById(0x7f0c011d);
        if (h != null && !h.isEmpty())
        {
            d.setText(h);
        }
        a.setOnClickListener(new android.view.View.OnClickListener() {

            final NewAlertDialogFragment a;

            public void onClick(View view)
            {
                if (NewAlertDialogFragment.a(a) != null)
                {
                    NewAlertDialogFragment.a(a).b();
                }
            }

            
            {
                a = NewAlertDialogFragment.this;
                super();
            }
        });
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final NewAlertDialogFragment a;

            public void onClick(View view)
            {
                if (NewAlertDialogFragment.a(a) != null)
                {
                    NewAlertDialogFragment.a(a).a();
                }
            }

            
            {
                a = NewAlertDialogFragment.this;
                super();
            }
        });
        a();
        return layoutinflater;
    }
}

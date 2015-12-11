// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.u;
import com.wishabi.flipp.util.g;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.q;

// Referenced classes of package com.wishabi.flipp.app:
//            co, cv, cp, cq, 
//            cr, cu

public final class cn extends Fragment
{

    cv a;
    String b;
    private Button c;
    private EditText d;
    private ProgressBar e;

    public cn()
    {
    }

    static ProgressBar a(cn cn1)
    {
        return cn1.e;
    }

    static cv b(cn cn1)
    {
        return cn1.a;
    }

    static Button c(cn cn1)
    {
        return cn1.c;
    }

    static void d(cn cn1)
    {
        if (cn1.d != null)
        {
            Object obj = a.a.b.getSharedPreferences("com.wishabi.flipp.preferences", 0);
            if (((SharedPreferences) (obj)).getString("tutorialComplete", "no").equals("no"))
            {
                ((SharedPreferences) (obj)).edit().putString("tutorialComplete", "yes").commit();
            }
            obj = cn1.d.getText();
            if (obj != null)
            {
                obj = ((CharSequence) (obj)).toString().toUpperCase().replaceAll("\\s", "");
                if (k.d(((String) (obj))))
                {
                    Activity activity = cn1.getActivity();
                    if (activity != null)
                    {
                        g.a(activity);
                        cn1.e.setVisibility(0);
                        u.a.a(((String) (obj)), new co(cn1, ((String) (obj))));
                        if (cn1.a != null)
                        {
                            cn1.a.a();
                        }
                    }
                }
            }
        }
    }

    static EditText e(cn cn1)
    {
        return cn1.d;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        bundle = getActivity();
        if (bundle == null)
        {
            return null;
        }
        int i;
        if (com.google.android.gms.common.g.a(bundle) == 0)
        {
            i = 0x7f030043;
        } else
        {
            i = 0x7f030042;
        }
        viewgroup = layoutinflater.inflate(i, viewgroup, false);
        if (viewgroup == null)
        {
            return null;
        }
        ((TextView)viewgroup.findViewById(0x7f0b00f9)).setText(bundle.getString(0x7f0e00c3, new Object[] {
            q.b()
        }));
        e = (ProgressBar)viewgroup.findViewById(0x7f0b00fc);
        if (e == null)
        {
            return null;
        }
        d = (EditText)viewgroup.findViewById(0x7f0b00fa);
        if (d == null)
        {
            return null;
        }
        d.setImeOptions(0x12000002);
        layoutinflater = bundle.getSharedPreferences("com.wishabi.flipp.preferences", 0).getString("postal_code", null);
        if (layoutinflater == null)
        {
            layoutinflater = b;
        }
        d.setText(layoutinflater);
        d.addTextChangedListener(new cp(this));
        d.setOnEditorActionListener(new cq(this));
        bundle = (Button)viewgroup.findViewById(0x7f0b00fd);
        if (bundle != null)
        {
            bundle.setOnClickListener(new cr(this));
        }
        c = (Button)viewgroup.findViewById(0x7f0b00fb);
        if (c == null)
        {
            return null;
        } else
        {
            c.setOnClickListener(new cu(this));
            c.setEnabled(k.d(layoutinflater));
            return viewgroup;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.p;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.b.a.a.j;
import com.offerup.android.activities.a;
import com.offerup.android.d.d;
import com.offerup.android.d.e;
import com.offerup.android.utils.n;

// Referenced classes of package com.offerup.android.g.b:
//            af, ae, aa, ab, 
//            ac, ad

public final class z extends p
{

    private EditText a;
    private EditText b;
    private EditText c;
    private ProgressDialog d;
    private d e;
    private e f;
    private a g;
    private af h;
    private j i;

    public z()
    {
        i = j.a();
    }

    static EditText a(z z1)
    {
        return z1.b;
    }

    public static z a()
    {
        return new z();
    }

    static void a(z z1, String s, String s1)
    {
        n.a(z1.d);
        try
        {
            z1.d = ProgressDialog.show(z1.getActivity(), s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (z z1)
        {
            return;
        }
    }

    static EditText b(z z1)
    {
        return z1.c;
    }

    static EditText c(z z1)
    {
        return z1.a;
    }

    static d d(z z1)
    {
        return z1.e;
    }

    static a e(z z1)
    {
        return z1.g;
    }

    static ProgressDialog f(z z1)
    {
        return z1.d;
    }

    static j g(z z1)
    {
        return z1.i;
    }

    static af h(z z1)
    {
        return z1.h;
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        h = (af)activity;
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        bundle.getWindow().requestFeature(1);
        bundle.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        bundle.setCanceledOnTouchOutside(false);
        setStyle(2, 0x7f0c00f4);
        return bundle;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f04009e, viewgroup, false);
        f = new ae(this);
        e = new d(f);
        g = new a(getActivity());
        viewgroup = (Button)layoutinflater.findViewById(0x7f10027b);
        a = (EditText)layoutinflater.findViewById(0x7f10027c);
        b = (EditText)layoutinflater.findViewById(0x7f10027e);
        c = (EditText)layoutinflater.findViewById(0x7f100280);
        c.setOnEditorActionListener(new aa(this, viewgroup));
        c.setInputType(129);
        viewgroup.setOnClickListener(new ab(this, viewgroup));
        viewgroup = (TextView)layoutinflater.findViewById(0x7f100228);
        bundle = viewgroup.getText().toString();
        String s = getString(0x7f09014c);
        int k = bundle.indexOf(s);
        int l = s.length();
        s = getString(0x7f09014a);
        int i1 = bundle.indexOf(s);
        int j1 = s.length();
        bundle = new SpannableString(bundle);
        bundle.setSpan(new ac(this), k, l + k, 0);
        bundle.setSpan(new ad(this), i1, j1 + i1, 0);
        viewgroup.setText(bundle);
        viewgroup.setMovementMethod(new LinkMovementMethod());
        com.offerup.android.tracker.a.a("register");
        return layoutinflater;
    }

    public final void onDetach()
    {
        h = null;
        super.onDetach();
    }
}

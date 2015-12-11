// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.p;
import android.text.Html;
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
import com.offerup.android.d.c;
import com.offerup.android.dto.response.UserResponse;
import com.offerup.android.network.b;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.n;

// Referenced classes of package com.offerup.android.g.b:
//            i, h, b, c, 
//            d, e, f, g

public final class a extends p
{

    private com.offerup.android.d.a a;
    private c b;
    private com.offerup.android.activities.a c;
    private i d;
    private EditText e;
    private EditText f;
    private Dialog g;

    public a()
    {
    }

    static EditText a(a a1)
    {
        return a1.e;
    }

    public static a a()
    {
        return new a();
    }

    static void a(a a1, UserResponse userresponse)
    {
        com.offerup.android.network.b.a();
        userresponse = userresponse.getUser();
        ba.a(a1.getContext(), userresponse);
        if (a1.d != null)
        {
            a1.d.d();
        }
        j.a().o(false);
    }

    static void a(a a1, String s, String s1)
    {
        n.a(a1.g);
        try
        {
            a1.g = ProgressDialog.show(a1.getActivity(), s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            return;
        }
    }

    static EditText b(a a1)
    {
        return a1.f;
    }

    static com.offerup.android.d.a c(a a1)
    {
        return a1.a;
    }

    static com.offerup.android.activities.a d(a a1)
    {
        return a1.c;
    }

    static Dialog e(a a1)
    {
        return a1.g;
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (i)activity;
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
        layoutinflater = layoutinflater.inflate(0x7f040091, viewgroup, false);
        b = new h(this, (byte)0);
        a = new com.offerup.android.d.a(b);
        c = new com.offerup.android.activities.a(getActivity());
        viewgroup = (Button)layoutinflater.findViewById(0x7f10022b);
        e = (EditText)layoutinflater.findViewById(0x7f100224);
        f = (EditText)layoutinflater.findViewById(0x7f100226);
        bundle = (TextView)layoutinflater.findViewById(0x7f100227);
        String s = getResources().getString(0x7f0901d5);
        bundle.setOnClickListener(new com.offerup.android.g.b.b(this));
        bundle.setText(Html.fromHtml(String.format(s, new Object[] {
            "https://offerupnow.com/"
        })));
        bundle.setMovementMethod(LinkMovementMethod.getInstance());
        bundle.setGravity(17);
        bundle = (Button)layoutinflater.findViewById(0x7f10022a);
        f.setOnEditorActionListener(new com.offerup.android.g.b.c(this, viewgroup));
        f.setInputType(129);
        viewgroup.setOnClickListener(new d(this, viewgroup));
        bundle.setOnClickListener(new e(this));
        viewgroup = (TextView)layoutinflater.findViewById(0x7f100228);
        bundle = viewgroup.getText().toString();
        s = getString(0x7f09014c);
        int k = bundle.indexOf(s);
        int l = s.length();
        s = getString(0x7f09014a);
        int i1 = bundle.indexOf(s);
        int j1 = s.length();
        bundle = new SpannableString(bundle);
        bundle.setSpan(new f(this), k, l + k, 33);
        bundle.setSpan(new g(this), i1, j1 + i1, 33);
        viewgroup.setText(bundle);
        viewgroup.setMovementMethod(LinkMovementMethod.getInstance());
        com.offerup.android.tracker.a.a("login");
        return layoutinflater;
    }

    public final void onDetach()
    {
        d = null;
        super.onDetach();
    }
}

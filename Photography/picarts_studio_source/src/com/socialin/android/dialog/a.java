// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.dialog:
//            d, c

public class a extends d
{

    public static final String d = com/socialin/android/dialog/a.getSimpleName();
    private android.content.DialogInterface.OnCancelListener a;
    private String b;
    private String c;
    public android.view.View.OnClickListener e;
    public android.view.View.OnClickListener f;
    private String g;
    private String h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private c q;

    public a()
    {
        e = null;
        f = null;
        a = null;
        b = "";
        c = "";
        g = null;
        h = null;
        i = 0;
        j = 0;
        k = true;
        l = true;
        m = false;
        n = true;
        o = 0x7f0c0181;
        p = 1;
    }

    public a(String s, int i1, String s1, int j1, boolean flag, boolean flag1, android.view.View.OnClickListener onclicklistener, 
            android.view.View.OnClickListener onclicklistener1, android.content.DialogInterface.OnCancelListener oncancellistener, int k1, int l1, c c1, String s2, String s3, 
            boolean flag2)
    {
        e = null;
        f = null;
        a = null;
        b = "";
        c = "";
        g = null;
        h = null;
        i = 0;
        j = 0;
        k = true;
        l = true;
        m = false;
        n = true;
        o = 0x7f0c0181;
        p = 1;
        b = s;
        c = s1;
        k = flag;
        n = flag1;
        e = onclicklistener;
        f = onclicklistener1;
        a = oncancellistener;
        o = l1;
        p = k1;
        j = j1;
        q = c1;
        g = s2;
        h = s3;
        i = i1;
        l = flag2;
    }

    protected a(String s, int i1, String s1, int j1, boolean flag, boolean flag1, android.view.View.OnClickListener onclicklistener, 
            android.view.View.OnClickListener onclicklistener1, android.content.DialogInterface.OnCancelListener oncancellistener, int k1, int l1, c c1, String s2, String s3, 
            boolean flag2, boolean flag3)
    {
        this(s, i1, s1, j1, flag, flag1, onclicklistener, onclicklistener1, oncancellistener, k1, l1, c1, s2, s3, flag2);
        m = flag3;
    }

    static android.view.View.OnClickListener a(a a1)
    {
        return a1.e;
    }

    static android.view.View.OnClickListener b(a a1)
    {
        return a1.f;
    }

    public final void a(c c1)
    {
        q = c1;
        if (c1 != null)
        {
            View view = getView();
            if (view != null)
            {
                c1.onViewCreated(view, this);
            }
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        if (a != null)
        {
            a.onCancel(getDialog());
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(null);
        if (bundle != null)
        {
            b = bundle.getString("title");
            i = bundle.getInt("icon");
            c = bundle.getString("message");
            g = bundle.getString("negativeBtnTxt");
            h = bundle.getString("positiveBtnTxt");
            j = bundle.getInt("contentRes", j);
            k = bundle.getBoolean("showPositiveBtn");
            n = bundle.getBoolean("showNegativBtn");
            o = bundle.getInt("theme");
            p = bundle.getInt("style");
        }
        setStyle(p, o);
        setCancelable(l);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (m)
        {
            getDialog().requestWindowFeature(1);
        }
        viewgroup = layoutinflater.inflate(0x7f0301e3, viewgroup, false);
        if (p != 1 && !TextUtils.isEmpty(b))
        {
            ((ViewStub)viewgroup.findViewById(0x7f1008ae)).inflate();
            bundle = myobfuscated.f.m.b(viewgroup);
            bundle.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
            bundle.setText(b);
        }
        bundle = (TextView)viewgroup.findViewById(0x7f10067e);
        if (TextUtils.isEmpty(c))
        {
            bundle.setVisibility(8);
        } else
        {
            bundle.setText(c);
            bundle.setVisibility(0);
        }
        bundle = (FrameLayout)viewgroup.findViewById(0x7f1008af);
        if (j != 0)
        {
            layoutinflater.inflate(j, bundle);
        } else
        {
            bundle.setVisibility(8);
        }
        layoutinflater = viewgroup.findViewById(0x7f10067f);
        if (k)
        {
            layoutinflater.setVisibility(0);
            if (h != null)
            {
                ((Button)layoutinflater).setText(h);
            }
            layoutinflater.setOnClickListener(new android.view.View.OnClickListener() {

                private a a;

                public final void onClick(View view)
                {
                    try
                    {
                        a.dismiss();
                    }
                    catch (IllegalStateException illegalstateexception)
                    {
                        illegalstateexception.printStackTrace();
                    }
                    if (a.a(a) != null)
                    {
                        a.a(a).onClick(view);
                    }
                }

            
            {
                a = a.this;
                super();
            }
            });
        } else
        {
            layoutinflater.setVisibility(8);
        }
        layoutinflater = viewgroup.findViewById(0x7f1008b0);
        if (n)
        {
            layoutinflater.setVisibility(0);
            if (g != null)
            {
                ((Button)layoutinflater).setText(g);
            }
            layoutinflater.setOnClickListener(new android.view.View.OnClickListener() {

                private a a;

                public final void onClick(View view)
                {
                    try
                    {
                        a.dismiss();
                    }
                    catch (IllegalStateException illegalstateexception)
                    {
                        illegalstateexception.printStackTrace();
                    }
                    if (a.b(a) != null)
                    {
                        a.b(a).onClick(view);
                    }
                }

            
            {
                a = a.this;
                super();
            }
            });
        } else
        {
            layoutinflater.setVisibility(8);
        }
        if (q != null)
        {
            q.onViewCreated(viewgroup, this);
        }
        return viewgroup;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("title", b);
        bundle.putInt("icon", i);
        bundle.putString("message", c);
        if (g != null)
        {
            bundle.putString("negativeBtnTxt", g);
        }
        if (h != null)
        {
            bundle.putString("positiveBtnTxt", h);
        }
        bundle.putInt("contentRes", j);
        bundle.putBoolean("showPositiveBtn", k);
        bundle.putBoolean("showNegativBtn", n);
        bundle.putInt("theme", o);
        bundle.putInt("style", p);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.cyberlink.youcammakeup.a;
import com.cyberlink.youcammakeup.widgetpool.common.OnSizeChangedFrameLayout;
import com.cyberlink.youcammakeup.widgetpool.common.aj;

public class l extends a
{

    private OnSizeChangedFrameLayout a;
    private View b;
    private boolean c;
    private aj d;

    public l()
    {
        d = new aj() {

            final l a;
            private int b[];

            private void a()
            {
                com.cyberlink.youcammakeup.utility.l.a(a).getLocationOnScreen(b);
                Object obj = a.getDialog();
                if (obj != null)
                {
                    obj = ((Dialog) (obj)).getWindow();
                    android.view.WindowManager.LayoutParams layoutparams = ((Window) (obj)).getAttributes();
                    layoutparams.height = b[1];
                    layoutparams.gravity = 48;
                    ((Window) (obj)).setAttributes(layoutparams);
                }
            }

            public void a(int i, int j, int k, int i1)
            {
                if (com.cyberlink.youcammakeup.utility.l.a(a) != null)
                {
                    a();
                }
            }

            
            {
                a = l.this;
                super();
                b = new int[2];
            }
        };
    }

    static View a(l l1)
    {
        return l1.b;
    }

    public void a(View view)
    {
        b = view;
    }

    public void a(boolean flag)
    {
        c = flag;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a.setOnSizeChangedListener(d);
        a.setOnClickListener(new android.view.View.OnClickListener() {

            final l a;

            public void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = l.this;
                super();
            }
        });
        getDialog().getWindow().setWindowAnimations(0);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = (OnSizeChangedFrameLayout)layoutinflater.inflate(0x7f030113, viewgroup);
        return a;
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        getDialog().getWindow().addFlags(8);
        if (c)
        {
            getDialog().getWindow().addFlags(1024);
        }
    }
}

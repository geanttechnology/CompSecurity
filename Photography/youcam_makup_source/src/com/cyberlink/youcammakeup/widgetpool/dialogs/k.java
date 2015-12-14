// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class k extends Fragment
{

    private View a;
    private android.view.View.OnClickListener b;
    private String c;

    public k()
    {
        c = null;
    }

    static android.view.View.OnClickListener a(k k1)
    {
        return k1.b;
    }

    public void a(android.view.View.OnClickListener onclicklistener)
    {
        b = onclicklistener;
    }

    public void a(String s)
    {
        c = s;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a.findViewById(0x7f0c0599).setOnClickListener(new android.view.View.OnClickListener() {

            final k a;

            public void onClick(View view)
            {
                if (k.a(a) != null)
                {
                    k.a(a).onClick(view);
                }
            }

            
            {
                a = k.this;
                super();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f03011a, viewgroup, false);
        if (c != null && !c.isEmpty())
        {
            ((TextView)a.findViewById(0x7f0c0597)).setText(c);
        }
        return a;
    }
}

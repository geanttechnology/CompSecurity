// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ac extends Fragment
{

    private String a;
    private String b;
    private Boolean c;
    private View d;
    private ProgressBar e;
    private TextView f;
    private TextView g;
    private TextView h;

    public ac()
    {
        a = "";
        b = "";
        c = Boolean.valueOf(true);
    }

    public void a(int i)
    {
        if (e != null && h != null)
        {
            e.setProgress(i);
            h.setText((new StringBuilder()).append(Integer.toString(i)).append("%").toString());
        }
    }

    public void a(String s)
    {
        a = s;
    }

    public void b(String s)
    {
        b = s;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        d = layoutinflater.inflate(0x7f030187, viewgroup, false);
        e = (ProgressBar)d.findViewById(0x7f0c06b5);
        f = (TextView)d.findViewById(0x7f0c06b6);
        g = (TextView)d.findViewById(0x7f0c06b7);
        h = (TextView)d.findViewById(0x7f0c06b8);
        return d;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
    }

    public void onStart()
    {
        super.onStart();
        f.setText(a);
        g.setText(b);
        e.setProgress(0);
        h.setText("0%");
    }
}

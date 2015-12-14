// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui;

import ama;
import amb;
import amc;
import amd;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FontPreViewDialog extends DialogFragment
{

    private static FontPreViewDialog k;
    public amd a;
    public View b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public Button h;
    public Button i;
    public ama j;

    public FontPreViewDialog()
    {
    }

    public static FontPreViewDialog a()
    {
        if (k == null)
        {
            k = new FontPreViewDialog();
            new Bundle();
        }
        return k;
    }

    public void a(ama ama1)
    {
        j = ama1;
    }

    public void a(amd amd1)
    {
        a = amd1;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(1, 0x1030011);
        setCancelable(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        b = layoutinflater.inflate(0x7f030128, viewgroup, false);
        d = (TextView)b.findViewById(0x7f0d043d);
        e = (TextView)b.findViewById(0x7f0d043e);
        f = (TextView)b.findViewById(0x7f0d043f);
        g = (TextView)b.findViewById(0x7f0d0440);
        c = (ImageView)b.findViewById(0x7f0d0441);
        c.setBackgroundResource(j.d);
        d.setText((new StringBuilder()).append(getActivity().getResources().getString(0x7f0602a3)).append(": ").append(j.g).toString());
        layoutinflater = (new StringBuilder()).append(j.h).append("M").toString();
        if ((double)j.h < 0.10000000000000001D)
        {
            layoutinflater = (new StringBuilder()).append((int)(j.h * 1000F)).append("K").toString();
        }
        e.setText((new StringBuilder()).append(getActivity().getResources().getString(0x7f0602a5)).append(": ").append(layoutinflater).toString());
        f.setText((new StringBuilder()).append("(").append(getActivity().getResources().getString(0x7f0602a6)).append(")").toString());
        g.setText((new StringBuilder()).append(getActivity().getResources().getString(0x7f0602a4)).append("\uFF1A").toString());
        i = (Button)b.findViewById(0x7f0d0442);
        i.setOnClickListener(new amb(this));
        h = (Button)b.findViewById(0x7f0d0443);
        h.setOnClickListener(new amc(this));
        return b;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        if (a != null)
        {
            a.i();
        }
    }
}

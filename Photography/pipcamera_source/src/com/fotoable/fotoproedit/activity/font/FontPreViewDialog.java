// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

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
import hb;
import hd;

public class FontPreViewDialog extends DialogFragment
{

    private static FontPreViewDialog k;
    hd a;
    public View b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public Button h;
    public Button i;
    public hb j;

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

    public void a(hb hb1)
    {
        j = hb1;
    }

    public void a(hd hd1)
    {
        a = hd1;
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
        b = layoutinflater.inflate(0x7f0300d2, viewgroup, false);
        d = (TextView)b.findViewById(0x7f0c0329);
        e = (TextView)b.findViewById(0x7f0c032a);
        f = (TextView)b.findViewById(0x7f0c032b);
        g = (TextView)b.findViewById(0x7f0c032c);
        c = (ImageView)b.findViewById(0x7f0c032d);
        c.setBackgroundResource(j.d);
        d.setText((new StringBuilder()).append(getActivity().getResources().getString(0x7f06026d)).append(": ").append(j.g).toString());
        layoutinflater = (new StringBuilder()).append(j.h).append("M").toString();
        if ((double)j.h < 0.10000000000000001D)
        {
            layoutinflater = (new StringBuilder()).append((int)(j.h * 1000F)).append("K").toString();
        }
        e.setText((new StringBuilder()).append(getActivity().getResources().getString(0x7f06026f)).append(": ").append(layoutinflater).toString());
        f.setText((new StringBuilder()).append("(").append(getActivity().getResources().getString(0x7f060270)).append(")").toString());
        g.setText((new StringBuilder()).append(getActivity().getResources().getString(0x7f06026e)).append("\uFF1A").toString());
        i = (Button)b.findViewById(0x7f0c032e);
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final FontPreViewDialog a;

            public void onClick(View view)
            {
                if (a.a != null)
                {
                    a.a.a(Boolean.valueOf(true));
                }
            }

            
            {
                a = FontPreViewDialog.this;
                super();
            }
        });
        h = (Button)b.findViewById(0x7f0c032f);
        h.setOnClickListener(new android.view.View.OnClickListener() {

            final FontPreViewDialog a;

            public void onClick(View view)
            {
                if (a.a != null)
                {
                    a.a.b(a.j);
                }
            }

            
            {
                a = FontPreViewDialog.this;
                super();
            }
        });
        return b;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        if (a != null)
        {
            a.h();
        }
    }
}

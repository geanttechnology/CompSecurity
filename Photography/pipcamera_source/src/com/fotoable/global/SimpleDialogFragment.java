// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.global;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pipcamera.application.PIPCameraApplication;
import ke;

public class SimpleDialogFragment extends DialogFragment
{

    ke a;
    public View b;
    public View c;
    public RelativeLayout d;
    public TextView e;
    public TextView f;
    public Button g;
    public Button h;
    private boolean i;
    private String j;
    private String k;
    private String l;
    private String m;

    public SimpleDialogFragment()
    {
        i = false;
        j = "";
        k = "";
        l = "";
        m = "";
    }

    public void a(String s)
    {
        j = s;
        if (e != null)
        {
            e.setText(s);
        }
    }

    public void a(ke ke1)
    {
        a = ke1;
    }

    public void a(boolean flag)
    {
label0:
        {
            i = flag;
            if (e != null)
            {
                if (!flag)
                {
                    break label0;
                }
                e.setVisibility(8);
            }
            return;
        }
        e.setVisibility(0);
    }

    public void b(String s)
    {
        k = s;
        if (f != null)
        {
            f.setText(s);
        }
    }

    public void c(String s)
    {
        l = s;
        if (g != null)
        {
            g.setText(s);
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        if (a != null)
        {
            a.b();
        }
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
        b = layoutinflater.inflate(0x7f0300d6, viewgroup, false);
        c = b.findViewById(0x7f0c0118);
        d = (RelativeLayout)b.findViewById(0x7f0c0345);
        d.setVisibility(4);
        e = (TextView)b.findViewById(0x7f0c0346);
        e.setText(j);
        if (i)
        {
            e.setVisibility(8);
        }
        f = (TextView)b.findViewById(0x7f0c0347);
        f.setText(k);
        h = (Button)b.findViewById(0x7f0c032e);
        if (m != null && m.length() > 0)
        {
            h.setText(m);
        }
        h.setOnClickListener(new android.view.View.OnClickListener() {

            final SimpleDialogFragment a;

            public void onClick(View view)
            {
                if (a.a != null)
                {
                    a.a.b();
                }
            }

            
            {
                a = SimpleDialogFragment.this;
                super();
            }
        });
        g = (Button)b.findViewById(0x7f0c032f);
        if (l != null && l.length() > 0)
        {
            g.setText(l);
        }
        g.setOnClickListener(new android.view.View.OnClickListener() {

            final SimpleDialogFragment a;

            public void onClick(View view)
            {
                if (a.a != null)
                {
                    a.a.a();
                }
            }

            
            {
                a = SimpleDialogFragment.this;
                super();
            }
        });
        return b;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
    }

    public void onResume()
    {
        super.onResume();
        Animation animation = AnimationUtils.loadAnimation(PIPCameraApplication.a, 0x7f040012);
        if (c != null)
        {
            c.startAnimation(animation);
            (new Handler()).postDelayed(new Runnable() {

                final SimpleDialogFragment a;

                public void run()
                {
                    a.d.setVisibility(0);
                }

            
            {
                a = SimpleDialogFragment.this;
                super();
            }
            }, animation.getDuration());
            return;
        } else
        {
            d.setVisibility(0);
            return;
        }
    }
}

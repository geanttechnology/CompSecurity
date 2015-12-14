// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.cyberlink.youcammakeup.a;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            m

public class l extends a
{

    private EditText a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private m g;

    public l()
    {
    }

    static m a(l l1)
    {
        return l1.g;
    }

    static EditText b(l l1)
    {
        return l1.a;
    }

    protected void a()
    {
        setStyle(2, 0);
    }

    public void a(int i)
    {
        d = i;
    }

    public void a(m m)
    {
        g = m;
    }

    public void a(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        b = s1;
    }

    public void b(int i)
    {
        c = i;
    }

    public void c(int i)
    {
        e = i;
    }

    public void d(int i)
    {
        f = i;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getView();
        ((TextView)bundle.findViewById(0x7f0c05ce)).setText(d);
        a = (EditText)bundle.findViewById(0x7f0c05cf);
        if (c > 0)
        {
            a.setFilters(new InputFilter[] {
                new android.text.InputFilter.LengthFilter(c)
            });
        }
        ((TextView)bundle.findViewById(0x7f0c05d1)).setText(e);
        bundle.findViewById(0x7f0c05d0).setOnClickListener(new android.view.View.OnClickListener() {

            final l a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.widgetpool.dialogs.l.a(a) != null && !com.cyberlink.youcammakeup.widgetpool.dialogs.l.a(a).a(view, l.b(a).getText().toString()))
                {
                    return;
                } else
                {
                    a.dismiss();
                    return;
                }
            }

            
            {
                a = l.this;
                super();
            }
        });
        ((TextView)bundle.findViewById(0x7f0c05d3)).setText(f);
        bundle.findViewById(0x7f0c05d2).setOnClickListener(new android.view.View.OnClickListener() {

            final l a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.widgetpool.dialogs.l.a(a) != null && !com.cyberlink.youcammakeup.widgetpool.dialogs.l.a(a).b(view, l.b(a).getText().toString()))
                {
                    return;
                } else
                {
                    a.dismiss();
                    return;
                }
            }

            
            {
                a = l.this;
                super();
            }
        });
        bundle.findViewById(0x7f0c05cd).setOnTouchListener(new android.view.View.OnTouchListener() {

            final l a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = l.this;
                super();
            }
        });
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            final l a;

            public void onClick(View view)
            {
                if (com.cyberlink.youcammakeup.widgetpool.dialogs.l.a(a) != null && !com.cyberlink.youcammakeup.widgetpool.dialogs.l.a(a).c(view, l.b(a).getText().toString()))
                {
                    return;
                } else
                {
                    a.dismiss();
                    return;
                }
            }

            
            {
                a = l.this;
                super();
            }
        });
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        Window window = bundle.getWindow();
        window.requestFeature(1);
        window.setBackgroundDrawableResource(0x106000d);
        return bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030125, viewgroup);
    }

    public void onDestroyView()
    {
        a(0);
        a("");
        c(0);
        d(0);
        a(((m) (null)));
        super.onDestroyView();
    }

    public void onPause()
    {
        b = a.getText().toString();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        a.setText(b);
        a.selectAll();
    }

    public void onStart()
    {
        super.onStart();
        Window window = getDialog().getWindow();
        android.view.WindowManager.LayoutParams layoutparams = window.getAttributes();
        layoutparams.width = -1;
        layoutparams.height = -1;
        layoutparams.gravity = 17;
        window.setAttributes(layoutparams);
        window.setSoftInputMode(53);
    }
}

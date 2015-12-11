// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import b.a.a.a.a;
import b.a.a.a.b;
import b.a.a.a.c;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ad

public final class PauseDialogActivity_ extends ad
    implements a, b
{

    private final c h = new c();

    public PauseDialogActivity_()
    {
    }

    private void a(Bundle bundle)
    {
        c.a(this);
    }

    public void a(a a1)
    {
        f = (SeekBar)a1.findViewById(0x7f0a019d);
        e = a1.findViewById(0x7f0a0198);
        g = (Button)a1.findViewById(0x7f0a01a0);
        a = a1.findViewById(0x7f0a018e);
        b = a1.findViewById(0x7f0a0192);
        c = a1.findViewById(0x7f0a0194);
        d = a1.findViewById(0x7f0a0196);
        if (e != null)
        {
            e.setOnClickListener(new android.view.View.OnClickListener() {

                final PauseDialogActivity_ a;

                public void onClick(View view)
                {
                    a.d();
                }

            
            {
                a = PauseDialogActivity_.this;
                super();
            }
            });
        }
        if (g != null)
        {
            g.setOnClickListener(new android.view.View.OnClickListener() {

                final PauseDialogActivity_ a;

                public void onClick(View view)
                {
                    a.e();
                }

            
            {
                a = PauseDialogActivity_.this;
                super();
            }
            });
        }
        c();
    }

    public void onCreate(Bundle bundle)
    {
        c c1 = c.a(h);
        a(bundle);
        super.onCreate(bundle);
        c.a(c1);
        setContentView(0x7f03004e);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (a() < 5 && i == 4 && keyevent.getRepeatCount() == 0)
        {
            onBackPressed();
        }
        return super.onKeyDown(i, keyevent);
    }

    public void setContentView(int i)
    {
        super.setContentView(i);
        h.a(this);
    }

    public void setContentView(View view)
    {
        super.setContentView(view);
        h.a(this);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.setContentView(view, layoutparams);
        h.a(this);
    }
}

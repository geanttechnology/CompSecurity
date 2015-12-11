// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.apps.youtube.kids.application.KidsApplication;

public final class zl extends vy
{

    private static acr h;
    TextView f;
    SeekBar g;
    private int i;
    private View j;
    private View k;
    private android.view.View.OnTouchListener l;

    public zl()
    {
        l = new zm(this);
    }

    static long a(zl zl1, long l1)
    {
        return (long)zl1.i + l1;
    }

    public final void a()
    {
        View view = getActivity().getLayoutInflater().inflate(0x7f040065, c);
        SeekBar seekbar;
        int i1;
        long l1;
        if (a.e(getActivity()))
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        i = i1;
        h = ((KidsApplication)getActivity().getApplicationContext()).d;
        f = (TextView)view.findViewById(0x7f1001b8);
        f.setText(Long.toString(h.a()));
        g = (SeekBar)view.findViewById(0x7f1001b5);
        g.setOnSeekBarChangeListener(new zn(this));
        g.setMax(120 - i);
        seekbar = g;
        if (h.f)
        {
            l1 = 30L;
        } else
        {
            l1 = h.a();
        }
        if (l1 >= (long)i)
        {
            l1 -= i;
        } else
        {
            l1 = 0L;
        }
        seekbar.setProgress((int)l1);
        k = view.findViewById(0x7f1001b6);
        k.setOnClickListener(new zo(this));
        k.setOnTouchListener(l);
        j = view.findViewById(0x7f1001b4);
        j.setOnClickListener(new zp(this));
        j.setOnTouchListener(l);
        if (h.e)
        {
            a.setText(getText(0x7f0b0190));
            b.setText(getText(0x7f0b018d));
            d.setText(getText(0x7f0b0191));
            e.setText(getText(0x7f0b0195));
            return;
        }
        if (h.f)
        {
            a.setText(getText(0x7f0b0192));
            b.setText(getText(0x7f0b0193));
            d.setText(getText(0x7f0b0194));
            e.setText(getText(0x7f0b0195));
            return;
        } else
        {
            a.setText(getText(0x7f0b018c));
            b.setText(getText(0x7f0b018d));
            d.setText(getText(0x7f0b018f));
            e.setText(getText(0x7f0b00db));
            return;
        }
    }

    protected final boolean b()
    {
        acr acr1 = h;
        long l1 = ((long)g.getProgress() + (long)i) * 60000L;
        acr1.b();
        acr1.b = l1;
        acr1.c = acr1.b;
        acr1.e = true;
        acr1.f = false;
        bw.a(acr1.d).a(new Intent("time_limit_start_intent"));
        acr1.a = (new acs(acr1, l1, 1000L)).start();
        return super.b();
    }

    protected final boolean c()
    {
        h.b();
        return super.c();
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        if (getActivity() != null)
        {
            getActivity().finish();
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.ui;

import acr;
import agh;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import bw;
import com.google.android.apps.youtube.kids.application.KidsApplication;

public class TimeLimitProgressBar extends ProgressBar
{

    private Context a;
    private acr b;
    private boolean c;
    private BroadcastReceiver d;

    public TimeLimitProgressBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d = new agh(this);
        a = context;
        c = false;
        if (context.getApplicationContext() instanceof KidsApplication)
        {
            b = ((KidsApplication)context.getApplicationContext()).d;
        }
    }

    public static boolean a(TimeLimitProgressBar timelimitprogressbar)
    {
        return timelimitprogressbar.c;
    }

    private void b()
    {
label0:
        {
            if (b != null)
            {
                setMax((int)b.b);
                setProgress((int)b.c);
                if (getVisibility() == 8 && b.e)
                {
                    setAnimation(AnimationUtils.loadAnimation(a, 0x7f05000a));
                }
                if (b == null || !b.e || c)
                {
                    break label0;
                }
                setVisibility(0);
            }
            return;
        }
        super.setVisibility(8);
    }

    public static void b(TimeLimitProgressBar timelimitprogressbar)
    {
        timelimitprogressbar.b();
    }

    public final void a()
    {
        setProgressDrawable(getResources().getDrawable(0x7f020239));
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("time_limit_start_intent");
        intentfilter.addAction("time_limit_update_intent");
        intentfilter.addAction("time_limit_cancel_intent");
        intentfilter.addAction("time_limit_expired_intent");
        bw.a(a).a(d, intentfilter);
        b();
    }

    protected void onDetachedFromWindow()
    {
        bw.a(a).a(d);
        super.onDetachedFromWindow();
    }

    public void setVisibility(int i)
    {
        if (i == 0)
        {
            c = false;
            if (b != null && !b.e)
            {
                return;
            }
        } else
        {
            c = true;
        }
        super.setVisibility(i);
    }
}

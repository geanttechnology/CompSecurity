// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.apps.youtube.kids.ui.TimeLimitProgressBar;

public final class agh extends BroadcastReceiver
{

    private TimeLimitProgressBar a;

    public agh(TimeLimitProgressBar timelimitprogressbar)
    {
        a = timelimitprogressbar;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("time_limit_start_intent") && !TimeLimitProgressBar.a(a))
        {
            a.setVisibility(0);
        }
        TimeLimitProgressBar.b(a);
    }
}

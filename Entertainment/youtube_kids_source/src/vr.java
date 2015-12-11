// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.apps.youtube.kids.activities.ParentalControlActivity;
import com.google.android.apps.youtube.kids.activities.TimeLimitExpiredActivity;
import java.util.concurrent.TimeUnit;

final class vr extends BroadcastReceiver
{

    private vq a;

    vr(vq vq1)
    {
        a = vq1;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        int i = (int)(vq.a(a).c / 60000L);
        long l = TimeUnit.MINUTES.toMillis(2L);
        boolean flag;
        if (vq.a(a).c < 1000L + l && vq.a(a).c >= l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (intent.getAction().equals("time_limit_start_intent"))
        {
            if (i == 1)
            {
                vq.b(a).setText(a.getString(0x7f0b01f6, new Object[] {
                    Integer.valueOf(i)
                }));
            } else
            {
                vq.b(a).setText(a.getString(0x7f0b01f7, new Object[] {
                    Integer.valueOf(i)
                }));
            }
            vq.c(a).show();
        } else
        {
            if (intent.getAction().equals("time_limit_update_intent") && flag)
            {
                vq.b(a).setText(a.getString(0x7f0b01f8, new Object[] {
                    Integer.valueOf(i)
                }));
                vq.d(a);
                return;
            }
            if (intent.getAction().equals("time_limit_cancel_intent"))
            {
                vq.b(a).setText(a.getString(0x7f0b01f9));
                vq.c(a).show();
                return;
            }
            if (intent.getAction().equals("time_limit_expired_intent") && !(a instanceof ParentalControlActivity))
            {
                a.startActivity(new Intent(a, com/google/android/apps/youtube/kids/activities/TimeLimitExpiredActivity));
                return;
            }
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import net.hockeyapp.android.c.a;
import net.hockeyapp.android.c.d;
import net.hockeyapp.android.e.e;
import net.hockeyapp.android.e.f;

// Referenced classes of package net.hockeyapp.android:
//            FeedbackActivity, m

final class l extends Handler
{

    final FeedbackActivity a;

    l(FeedbackActivity feedbackactivity)
    {
        a = feedbackactivity;
        super();
    }

    public final void handleMessage(Message message)
    {
        net.hockeyapp.android.FeedbackActivity.a(a, new a());
        if (message == null || message.getData() == null) goto _L2; else goto _L1
_L1:
        message = (d)message.getData().getSerializable("parse_feedback_response");
        if (message == null) goto _L2; else goto _L3
_L3:
        boolean flag;
        if (((d) (message)).a.equalsIgnoreCase("success"))
        {
            if (((d) (message)).c != null)
            {
                f.a.a(FeedbackActivity.c(a), ((d) (message)).c);
                net.hockeyapp.android.FeedbackActivity.a(a, message);
                net.hockeyapp.android.FeedbackActivity.d(a);
                flag = true;
            } else
            {
                flag = true;
            }
        } else
        {
            flag = false;
        }
_L5:
        if (!flag)
        {
            a.runOnUiThread(new m(this));
        }
        a.b(true);
        return;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import net.hockeyapp.android.c.a;

// Referenced classes of package net.hockeyapp.android:
//            FeedbackActivity, k

final class j extends Handler
{

    final FeedbackActivity a;

    j(FeedbackActivity feedbackactivity)
    {
        a = feedbackactivity;
        super();
    }

    public final void handleMessage(Message message)
    {
        boolean flag = false;
        net.hockeyapp.android.FeedbackActivity.a(a, new a());
        if (message != null && message.getData() != null)
        {
            Object obj = message.getData();
            message = ((Bundle) (obj)).getString("feedback_response");
            String s = ((Bundle) (obj)).getString("feedback_status");
            obj = ((Bundle) (obj)).getString("request_type");
            if (((String) (obj)).equals("send") && (message == null || Integer.parseInt(s) != 201))
            {
                net.hockeyapp.android.FeedbackActivity.a(a).a = "Message couldn't be posted. Please check your input values and your connection, then try again.";
            } else
            if (((String) (obj)).equals("fetch") && s != null && (Integer.parseInt(s) == 404 || Integer.parseInt(s) == 422))
            {
                FeedbackActivity.b(a);
                flag = true;
            } else
            if (message != null)
            {
                net.hockeyapp.android.FeedbackActivity.a(a, message);
                flag = true;
            } else
            {
                net.hockeyapp.android.FeedbackActivity.a(a).a = "No response from server. Please check your connection, then try again.";
            }
        } else
        {
            net.hockeyapp.android.FeedbackActivity.a(a).a = "Message couldn't be posted. Please check your input values and your connection, then try again.";
        }
        if (!flag)
        {
            a.runOnUiThread(new k(this));
        }
    }
}

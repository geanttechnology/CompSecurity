// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import net.hockeyapp.android.objects.ErrorObject;

// Referenced classes of package net.hockeyapp.android:
//            FeedbackActivity

class this._cls0 extends Handler
{

    final FeedbackActivity this$0;

    public void handleMessage(Message message)
    {
        boolean flag = false;
        FeedbackActivity.access$002(FeedbackActivity.this, new ErrorObject());
        if (message != null && message.getData() != null)
        {
            Object obj = message.getData();
            message = ((Bundle) (obj)).getString("feedback_response");
            String s = ((Bundle) (obj)).getString("feedback_status");
            obj = ((Bundle) (obj)).getString("request_type");
            if (((String) (obj)).equals("send") && (message == null || Integer.parseInt(s) != 201))
            {
                FeedbackActivity.access$000(FeedbackActivity.this).setMessage("Message couldn't be posted. Please check your input values and try again.");
            } else
            if (((String) (obj)).equals("fetch") && (Integer.parseInt(s) == 404 || Integer.parseInt(s) == 422))
            {
                FeedbackActivity.access$100(FeedbackActivity.this);
                flag = true;
            } else
            {
                FeedbackActivity.access$200(FeedbackActivity.this, message);
                flag = true;
            }
        } else
        {
            FeedbackActivity.access$000(FeedbackActivity.this).setMessage("Message couldn't be posted. Please check your input values and try again.");
        }
        if (!flag)
        {
            runOnUiThread(new Runnable() {

                final FeedbackActivity._cls2 this$1;

                public void run()
                {
                    enableDisableSendFeedbackButton(true);
                    showDialog(0);
                }

            
            {
                this$1 = FeedbackActivity._cls2.this;
                super();
            }
            });
        }
    }

    _cls1.this._cls1()
    {
        this$0 = FeedbackActivity.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.Random;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            Onboarding

class mActivity extends Handler
{

    WeakReference mActivity;

    public void handleMessage(Message message)
    {
        Onboarding onboarding = (Onboarding)mActivity.get();
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            message = new Random();
            break;
        }
        if (message.nextInt(2) % 2 == 0)
        {
            onboarding.ivS1.setVisibility(0);
        } else
        {
            onboarding.ivS1.setVisibility(4);
        }
        if (message.nextInt(2) % 2 == 0)
        {
            onboarding.ivS2.setVisibility(0);
        } else
        {
            onboarding.ivS2.setVisibility(4);
        }
        if (message.nextInt(2) % 2 == 0)
        {
            onboarding.ivS3.setVisibility(0);
        } else
        {
            onboarding.ivS3.setVisibility(4);
        }
        removeMessages(1);
        sendEmptyMessageDelayed(1, 500L);
    }

    (Onboarding onboarding)
    {
        mActivity = new WeakReference(onboarding);
    }
}

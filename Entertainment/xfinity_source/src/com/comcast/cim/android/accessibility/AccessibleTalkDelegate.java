// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.Window;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            DefaultTalkDelegate, AccessibilityUtil

public class AccessibleTalkDelegate extends DefaultTalkDelegate
{
    private class SpeakDelayRunnable
        implements Runnable
    {

        final String sayWhat;
        final AccessibleTalkDelegate this$0;

        public void run()
        {
            speakNow(sayWhat);
        }

        public SpeakDelayRunnable(String s)
        {
            this$0 = AccessibleTalkDelegate.this;
            super();
            sayWhat = s;
        }
    }


    protected final View accessibilityView;
    final Handler handler = new Handler();

    public AccessibleTalkDelegate(Activity activity, View view, AccessibilityUtil accessibilityutil)
    {
        super(activity, true);
        View view1 = view;
        if (view == null)
        {
            view1 = activity.getWindow().getDecorView().getRootView();
            accessibilityutil.setImportantForAccessibility(view1, 1);
        }
        accessibilityView = view1;
    }

    public void onDestroy()
    {
        handler.removeCallbacksAndMessages(null);
    }

    public void speak(String s, int i)
    {
        handler.postDelayed(new SpeakDelayRunnable(s), 200L);
    }

    public void speakNow(String s)
    {
        if (accessibilityView != null)
        {
            accessibilityView.announceForAccessibility(s);
        }
    }

    public void stopSpeaking()
    {
        accessibilityView.announceForAccessibility("");
    }
}

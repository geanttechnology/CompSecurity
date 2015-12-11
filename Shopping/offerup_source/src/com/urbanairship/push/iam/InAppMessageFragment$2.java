// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import android.view.View;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.Analytics;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessageFragment, Timer, ResolutionEvent

class this._cls0
    implements com.urbanairship.push.iam.view.Listener
{

    final InAppMessageFragment this$0;

    public void onDismissed(View view)
    {
        dismiss(false);
        view = ResolutionEvent.createUserDismissedResolutionEvent(InAppMessageFragment.access$000(InAppMessageFragment.this), InAppMessageFragment.access$100(InAppMessageFragment.this).getRunTime());
        UAirship.shared().getAnalytics().addEvent(view);
    }

    public void onDragStateChanged(View view, int i)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            InAppMessageFragment.access$100(InAppMessageFragment.this).stop();
            return;

        case 0: // '\0'
            InAppMessageFragment.access$100(InAppMessageFragment.this).start();
            return;
        }
    }

    yout.Listener()
    {
        this$0 = InAppMessageFragment.this;
        super();
    }
}

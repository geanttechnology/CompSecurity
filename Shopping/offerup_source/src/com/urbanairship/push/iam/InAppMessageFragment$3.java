// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import android.view.View;
import com.urbanairship.UAirship;
import com.urbanairship.actions.Situation;
import com.urbanairship.analytics.Analytics;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessageFragment, InAppMessage, Timer, ResolutionEvent

class this._cls0
    implements android.view.geFragment._cls3
{

    final InAppMessageFragment this$0;

    public void onClick(View view)
    {
        dismiss(true);
        InAppMessageFragment.access$200(InAppMessageFragment.this, InAppMessageFragment.access$000(InAppMessageFragment.this).getClickActionValues(), Situation.FOREGROUND_NOTIFICATION_ACTION_BUTTON);
        view = ResolutionEvent.createClickedResolutionEvent(InAppMessageFragment.access$000(InAppMessageFragment.this), InAppMessageFragment.access$100(InAppMessageFragment.this).getRunTime());
        UAirship.shared().getAnalytics().addEvent(view);
    }

    ()
    {
        this$0 = InAppMessageFragment.this;
        super();
    }
}

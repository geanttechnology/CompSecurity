// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import com.urbanairship.UAirship;
import com.urbanairship.analytics.Analytics;

// Referenced classes of package com.urbanairship.push.iam:
//            Timer, InAppMessageFragment, ResolutionEvent

class this._cls0 extends Timer
{

    final InAppMessageFragment this$0;

    protected void onFinish()
    {
        dismiss(true);
        ResolutionEvent resolutionevent = ResolutionEvent.createTimedOutResolutionEvent(InAppMessageFragment.access$000(InAppMessageFragment.this), InAppMessageFragment.access$100(InAppMessageFragment.this).getRunTime());
        UAirship.shared().getAnalytics().addEvent(resolutionevent);
    }

    (long l)
    {
        this$0 = InAppMessageFragment.this;
        super(l);
    }
}

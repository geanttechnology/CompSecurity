// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import com.urbanairship.UAirship;
import com.urbanairship.analytics.Analytics;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessageFragment, Timer, ResolutionEvent

class this._cls0
    implements com.urbanairship.push.iam.view.stener
{

    final InAppMessageFragment this$0;

    public void onDismissClick()
    {
        dismiss(true);
        ResolutionEvent resolutionevent = ResolutionEvent.createUserDismissedResolutionEvent(InAppMessageFragment.access$000(InAppMessageFragment.this), InAppMessageFragment.access$100(InAppMessageFragment.this).getRunTime());
        UAirship.shared().getAnalytics().addEvent(resolutionevent);
    }

    ickListener()
    {
        this$0 = InAppMessageFragment.this;
        super();
    }
}

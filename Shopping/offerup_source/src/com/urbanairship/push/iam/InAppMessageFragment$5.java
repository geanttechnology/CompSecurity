// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.actions.Situation;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.push.notifications.NotificationActionButton;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessageFragment, InAppMessage, Timer, ResolutionEvent

class this._cls0
    implements com.urbanairship.push.iam.view.tener
{

    final InAppMessageFragment this$0;

    public void onActionClick(NotificationActionButton notificationactionbutton)
    {
        Logger.info((new StringBuilder("In-app message button clicked: ")).append(notificationactionbutton.getId()).toString());
        dismiss(true);
        Situation situation;
        if (notificationactionbutton.isForegroundAction())
        {
            situation = Situation.FOREGROUND_NOTIFICATION_ACTION_BUTTON;
        } else
        {
            situation = Situation.BACKGROUND_NOTIFICATION_ACTION_BUTTON;
        }
        InAppMessageFragment.access$200(InAppMessageFragment.this, InAppMessageFragment.access$000(InAppMessageFragment.this).getButtonActionValues(notificationactionbutton.getId()), situation);
        notificationactionbutton = ResolutionEvent.createButtonClickedResolutionEvent(getActivity(), InAppMessageFragment.access$000(InAppMessageFragment.this), notificationactionbutton, InAppMessageFragment.access$100(InAppMessageFragment.this).getRunTime());
        UAirship.shared().getAnalytics().addEvent(notificationactionbutton);
    }

    ctionButton()
    {
        this$0 = InAppMessageFragment.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.os.Bundle;
import android.view.View;
import com.poshmark.notifications.PMNotificationManager;

// Referenced classes of package com.poshmark.ui.customviews:
//            ListingsFilterWidget

class val.filter_action
    implements android.view.t.ButtonInfo._cls1
{

    final ion this$1;
    final int val$filter_action;
    final ListingsFilterWidget val$this$0;

    public void onClick(View view)
    {
        view = new Bundle();
        view.putInt("FILTER_ACTION", val$filter_action);
        PMNotificationManager.fireNotification("com.poshmark.intents.FILTER_SELECTION_ACTION", view);
    }

    ()
    {
        this$1 = final_;
        val$this$0 = listingsfilterwidget;
        val$filter_action = I.this;
        super();
    }
}

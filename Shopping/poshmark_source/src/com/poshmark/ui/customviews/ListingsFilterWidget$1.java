// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.os.Bundle;
import android.view.View;
import com.poshmark.notifications.PMNotificationManager;

// Referenced classes of package com.poshmark.ui.customviews:
//            ListingsFilterWidget

class this._cls0
    implements android.view.FilterWidget._cls1
{

    final ListingsFilterWidget this$0;

    public void onClick(View view)
    {
        view = new Bundle();
        view.putInt("FILTER_ACTION", 16);
        PMNotificationManager.fireNotification("com.poshmark.intents.FILTER_SELECTION_ACTION", view);
    }

    ()
    {
        this$0 = ListingsFilterWidget.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.DialogInterface;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;

// Referenced classes of package com.bitstrips.imoji.ui:
//            IntentCreatorService

class this._cls0
    implements android.content.Listener
{

    final IntentCreatorService this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        analyticsService.sendEvent(Category.DOWNLOAD_FACEBOOK_MESSENGER, Action.NO_MESSENGER, null);
    }

    ()
    {
        this$0 = IntentCreatorService.this;
        super();
    }
}

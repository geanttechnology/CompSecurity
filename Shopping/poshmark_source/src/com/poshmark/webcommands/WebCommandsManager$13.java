// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import com.poshmark.notifications.ListingNotificationManager;

// Referenced classes of package com.poshmark.webcommands:
//            WebCommandsManager

class val.listingId
    implements com.poshmark.utils.er._cls13
{

    final WebCommandsManager this$0;
    final String val$listingId;

    public void runOnUIThread(Object obj)
    {
        ListingNotificationManager.getListingNotificationManager().fireListingEditedMessage(val$listingId);
    }

    anager()
    {
        this$0 = final_webcommandsmanager;
        val$listingId = String.this;
        super();
    }
}

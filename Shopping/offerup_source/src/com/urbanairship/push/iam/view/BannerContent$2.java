// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam.view;

import android.view.View;
import com.urbanairship.push.notifications.NotificationActionButton;

// Referenced classes of package com.urbanairship.push.iam.view:
//            BannerContent

class nActionButton
    implements android.view.ener
{

    final BannerContent this$0;
    final NotificationActionButton val$actionButton;

    public void onClick(View view)
    {
        if (BannerContent.access$100(BannerContent.this) != null)
        {
            BannerContent.access$100(BannerContent.this).onActionClick(val$actionButton);
        }
    }

    nActionButton()
    {
        this$0 = final_bannercontent;
        val$actionButton = NotificationActionButton.this;
        super();
    }
}

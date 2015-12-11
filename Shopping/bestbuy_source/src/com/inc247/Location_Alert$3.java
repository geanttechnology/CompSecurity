// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.inc247.ApplicationStatusModel.ApplicationLocationAlerts;

// Referenced classes of package com.inc247:
//            Location_Alert, ChatSDK

class ace
    implements android.content.nClickListener
{

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        ChatSDK.getSDKInstance().activity.startActivity(dialoginterface);
        ApplicationLocationAlerts.setLocationAlertShowingOrNot(false);
    }

    ace()
    {
    }
}

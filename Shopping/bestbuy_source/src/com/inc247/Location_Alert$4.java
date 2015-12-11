// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.content.DialogInterface;
import com.inc247.ApplicationStatusModel.ApplicationLocationAlerts;
import com.inc247.bridge.ChatSDKNativeToJSBridge;
import com.inc247.constants.ChatSDKConstants;

// Referenced classes of package com.inc247:
//            Location_Alert

class ace
    implements android.content.nClickListener
{

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ChatSDKNativeToJSBridge.data = null;
        ChatSDKConstants.isUserPermitGps = false;
        ApplicationLocationAlerts.setLocationAlertShowingOrNot(false);
        dialoginterface.cancel();
    }

    ace()
    {
    }
}

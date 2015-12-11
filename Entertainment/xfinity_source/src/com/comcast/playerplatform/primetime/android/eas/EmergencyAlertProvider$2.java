// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import com.comcast.playerplatform.util.android.XrestHelper;
import java.net.URI;

// Referenced classes of package com.comcast.playerplatform.primetime.android.eas:
//            EmergencyAlertProvider

class this._cls0
    implements com.comcast.playerplatform.util.android.ovider._cls2
{

    final EmergencyAlertProvider this$0;

    public void onTick(String s)
    {
        EmergencyAlertProvider.access$700(EmergencyAlertProvider.this);
        ThreadManager.getInstance().executeRunnable(new XrestHelper("", EmergencyAlertProvider.access$800(EmergencyAlertProvider.this).toString(), "GET", EmergencyAlertProvider.access$900(EmergencyAlertProvider.this), EmergencyAlertProvider.access$1000(EmergencyAlertProvider.this), EmergencyAlertProvider.access$1100(EmergencyAlertProvider.this), null));
    }

    ()
    {
        this$0 = EmergencyAlertProvider.this;
        super();
    }
}

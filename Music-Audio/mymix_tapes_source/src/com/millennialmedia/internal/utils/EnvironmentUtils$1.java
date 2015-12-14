// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import com.millennialmedia.MMLog;

// Referenced classes of package com.millennialmedia.internal.utils:
//            EnvironmentUtils

static final class  extends PhoneStateListener
{

    public void onSignalStrengthsChanged(SignalStrength signalstrength)
    {
        super.onSignalStrengthsChanged(signalstrength);
        if (signalstrength.isGsm())
        {
            Integer _tmp = EnvironmentUtils.access$002(Integer.valueOf(signalstrength.getGsmSignalStrength() * 2 - 113));
        } else
        {
            Integer _tmp1 = EnvironmentUtils.access$002(Integer.valueOf(signalstrength.getCdmaDbm()));
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(EnvironmentUtils.access$100(), (new StringBuilder()).append("Cell signal DBM updated to: ").append(EnvironmentUtils.access$000()).toString());
        }
    }

    ()
    {
    }
}

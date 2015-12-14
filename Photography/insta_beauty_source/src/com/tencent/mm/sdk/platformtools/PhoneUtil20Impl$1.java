// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            PhoneUtil20Impl

class aQ extends PhoneStateListener
{

    final PhoneUtil20Impl aQ;

    public void onSignalStrengthsChanged(SignalStrength signalstrength)
    {
        super.onSignalStrengthsChanged(signalstrength);
        if (PhoneUtil20Impl.a(aQ) == 2)
        {
            PhoneUtil20Impl.c(signalstrength.getCdmaDbm());
        }
        if (PhoneUtil20Impl.a(aQ) == 1)
        {
            PhoneUtil20Impl.c(signalstrength.getGsmSignalStrength() * 2 - 113);
        }
        if (PhoneUtil20Impl.b(aQ) != null)
        {
            PhoneUtil20Impl.b(aQ).listen(PhoneUtil20Impl.c(aQ), 0);
        }
    }

    (PhoneUtil20Impl phoneutil20impl)
    {
        aQ = phoneutil20impl;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            PhoneUtil16Impl

class aO extends PhoneStateListener
{

    final PhoneUtil16Impl aO;

    public void onSignalStrengthChanged(int i)
    {
        super.onSignalStrengthChanged(i);
        PhoneUtil16Impl.b(i * 2 - 113);
        if (PhoneUtil16Impl.a(aO) != null)
        {
            PhoneUtil16Impl.a(aO).listen(PhoneUtil16Impl.b(aO), 0);
        }
    }

    (PhoneUtil16Impl phoneutil16impl)
    {
        aO = phoneutil16impl;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;

// Referenced classes of package com.arellomobile.android.push:
//            GeoLocationService

class this._cls0 extends PhoneStateListener
{

    final GeoLocationService this$0;

    public void onCellLocationChanged(CellLocation celllocation)
    {
        onCellLocationChange(celllocation);
    }

    ()
    {
        this$0 = GeoLocationService.this;
        super();
    }
}

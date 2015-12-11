// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon;

import com.radiusnetworks.ibeacon.client.DataProviderException;

// Referenced classes of package com.radiusnetworks.ibeacon:
//            IBeacon, IBeaconData

public interface IBeaconDataNotifier
{

    public abstract void iBeaconDataUpdate(IBeacon ibeacon, IBeaconData ibeacondata, DataProviderException dataproviderexception);
}

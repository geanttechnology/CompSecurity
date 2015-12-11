// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, k, j

public class s
    implements i
{

    public s()
    {
    }

    public void a(Context context, j j1)
    {
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        if (telephonymanager != null)
        {
            if (k.a("android.permission.ACCESS_COARSE_LOCATION", context))
            {
                Object obj;
                CdmaCellLocation cdmacelllocation;
                try
                {
                    obj = (GsmCellLocation)telephonymanager.getCellLocation();
                }
                catch (ClassCastException classcastexception)
                {
                    classcastexception = null;
                }
                try
                {
                    cdmacelllocation = (CdmaCellLocation)telephonymanager.getCellLocation();
                }
                catch (ClassCastException classcastexception1)
                {
                    classcastexception1 = null;
                }
                if (obj != null)
                {
                    int l = ((GsmCellLocation) (obj)).getCid();
                    int k1 = ((GsmCellLocation) (obj)).getLac();
                    if (l != -1)
                    {
                        j1.a("CID", Integer.toString(l));
                    }
                    if (k1 != -1)
                    {
                        j1.a("LAC", Integer.toString(k1));
                    }
                }
                if (cdmacelllocation != null)
                {
                    int i1 = cdmacelllocation.getBaseStationId();
                    if (i1 != -1)
                    {
                        j1.a("CID", Integer.toString(i1));
                    }
                }
            }
            j1.a("CARCC", telephonymanager.getSimCountryIso());
            obj = telephonymanager.getSimOperator();
            if (obj != null && obj != "" && ((String) (obj)).length() > 0)
            {
                j1.a("CARNC", ((String) (obj)).substring(3));
                j1.a("CARMC", ((String) (obj)).substring(0, 3));
            }
            j1.a("CARN", telephonymanager.getSimOperatorName());
            j1.a("CARID", telephonymanager.getNetworkOperator());
            j1.a("ARGCC", telephonymanager.getNetworkCountryIso());
            obj = telephonymanager.getNetworkOperator();
            if (obj != null && obj != "" && ((String) (obj)).length() > 0)
            {
                j1.a("ARGNC", ((String) (obj)).substring(3));
                j1.a("ARGMC", ((String) (obj)).substring(0, 3));
            }
            j1.a("ARGN", telephonymanager.getNetworkOperatorName());
            if (k.a("android.permission.READ_PHONE_STATE", context))
            {
                j1.a("ANID", telephonymanager.getDeviceId());
                j1.a("ASSN", telephonymanager.getSimSerialNumber());
                j1.a("APH1", telephonymanager.getLine1Number());
                j1.a("ASID", telephonymanager.getSubscriberId());
                return;
            }
        }
    }
}

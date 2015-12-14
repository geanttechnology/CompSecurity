// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log

class PhoneUtil20Impl
{

    private static int aK = 10000;
    private static int aL = 10000;
    private TelephonyManager aM;
    private PhoneStateListener aN;
    private int aP;

    PhoneUtil20Impl()
    {
        aN = new _cls1();
    }

    static int a(PhoneUtil20Impl phoneutil20impl)
    {
        return phoneutil20impl.aP;
    }

    static TelephonyManager b(PhoneUtil20Impl phoneutil20impl)
    {
        return phoneutil20impl.aM;
    }

    static int c(int i)
    {
        aL = i;
        return i;
    }

    static PhoneStateListener c(PhoneUtil20Impl phoneutil20impl)
    {
        return phoneutil20impl.aN;
    }

    public List getCellInfoList(Context context)
    {
        Object obj;
        Object obj1;
        LinkedList linkedlist;
        Object obj3;
        obj3 = (TelephonyManager)context.getSystemService("phone");
        linkedlist = new LinkedList();
        obj1 = "460";
        Object obj2 = "";
        String s1;
        try
        {
            obj = ((TelephonyManager) (obj3)).getNetworkOperator();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return linkedlist;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((String) (obj)).equals("")) goto _L2; else goto _L3
_L3:
        context = ((String) (obj)).substring(0, 3);
        obj = ((String) (obj)).substring(3, 5);
_L11:
        if (((TelephonyManager) (obj3)).getPhoneType() != 2) goto _L5; else goto _L4
_L4:
        obj2 = (CdmaCellLocation)((TelephonyManager) (obj3)).getCellLocation();
        if (obj2 == null) goto _L7; else goto _L6
_L6:
        if (aL != aK) goto _L9; else goto _L8
_L8:
        obj1 = "";
_L13:
        if (((CdmaCellLocation) (obj2)).getBaseStationId() != -1 && ((CdmaCellLocation) (obj2)).getNetworkId() != -1 && ((CdmaCellLocation) (obj2)).getSystemId() != -1)
        {
            linkedlist.add(new PhoneUtil.CellInfo(context, ((String) (obj)), "", "", ((String) (obj1)), "cdma", (new StringBuilder()).append(((CdmaCellLocation) (obj2)).getBaseStationId()).toString(), (new StringBuilder()).append(((CdmaCellLocation) (obj2)).getNetworkId()).toString(), (new StringBuilder()).append(((CdmaCellLocation) (obj2)).getSystemId()).toString()));
        }
_L7:
        return linkedlist;
_L2:
        s1 = ((TelephonyManager) (obj3)).getSimOperator();
        obj = obj2;
        context = ((Context) (obj1));
        if (s1 == null) goto _L11; else goto _L10
_L10:
        obj = obj2;
        context = ((Context) (obj1));
        if (s1.equals("")) goto _L11; else goto _L12
_L12:
        context = s1.substring(0, 3);
        obj = s1.substring(3, 5);
          goto _L11
_L9:
        obj1 = (new StringBuilder()).append(aL).toString();
          goto _L13
        Exception exception;
        exception;
        exception = (GsmCellLocation)((TelephonyManager) (obj3)).getCellLocation();
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        int i;
        int j;
        i = exception.getCid();
        j = exception.getLac();
        if (j < 65535 && j != -1 && i != -1)
        {
            try
            {
                linkedlist.add(new PhoneUtil.CellInfo(context, ((String) (obj)), String.valueOf(j), String.valueOf(i), "", "gsm", "", "", ""));
            }
            catch (Exception exception1)
            {
                exception1.printStackTrace();
            }
        }
        exception = ((TelephonyManager) (obj3)).getNeighboringCellInfo();
        if (exception != null && exception.size() > 0)
        {
            exception = exception.iterator();
            while (exception.hasNext()) 
            {
                NeighboringCellInfo neighboringcellinfo = (NeighboringCellInfo)exception.next();
                if (neighboringcellinfo.getCid() != -1 && neighboringcellinfo.getLac() <= 65535 && neighboringcellinfo.getLac() != -1)
                {
                    obj3 = (new StringBuilder()).append(neighboringcellinfo.getRssi() * 2 - 113).toString();
                    linkedlist.add(new PhoneUtil.CellInfo(context, ((String) (obj)), (new StringBuilder()).append(neighboringcellinfo.getLac()).toString(), (new StringBuilder()).append(neighboringcellinfo.getCid()).toString(), ((String) (obj3)), "gsm", "", "", ""));
                }
            }
        }
          goto _L7
_L5:
        exception1 = (GsmCellLocation)((TelephonyManager) (obj3)).getCellLocation();
        if (exception1 == null) goto _L15; else goto _L14
_L14:
        i = exception1.getCid();
        j = exception1.getLac();
        if (j >= 65535 || j == -1 || i == -1) goto _L15; else goto _L16
_L16:
        if (aL != aK)
        {
            break MISSING_BLOCK_LABEL_834;
        }
        exception1 = "";
_L17:
        try
        {
            linkedlist.add(new PhoneUtil.CellInfo(context, ((String) (obj)), String.valueOf(j), String.valueOf(i), exception1, "gsm", "", "", ""));
        }
        catch (Exception exception2)
        {
            exception2.printStackTrace();
        }
_L15:
        exception1 = ((TelephonyManager) (obj3)).getNeighboringCellInfo();
        if (exception1 != null && exception1.size() > 0)
        {
            exception1 = exception1.iterator();
            while (exception1.hasNext()) 
            {
                NeighboringCellInfo neighboringcellinfo1 = (NeighboringCellInfo)exception1.next();
                if (neighboringcellinfo1.getCid() != -1 && neighboringcellinfo1.getLac() <= 65535)
                {
                    String s = (new StringBuilder()).append(neighboringcellinfo1.getRssi() * 2 - 113).toString();
                    Log.v("checked", (new StringBuilder("lac:")).append(neighboringcellinfo1.getLac()).append("  cid:").append(neighboringcellinfo1.getCid()).append(" dbm:").append(s).toString());
                    linkedlist.add(new PhoneUtil.CellInfo(context, ((String) (obj)), (new StringBuilder()).append(neighboringcellinfo1.getLac()).toString(), (new StringBuilder()).append(neighboringcellinfo1.getCid()).toString(), s, "gsm", "", "", ""));
                }
            }
        }
          goto _L7
        exception1 = (new StringBuilder()).append(aL).toString();
          goto _L17
    }

    public void getSignalStrength(Context context)
    {
        aM = (TelephonyManager)context.getSystemService("phone");
        aM.listen(aN, 256);
        aP = aM.getPhoneType();
    }


    private class _cls1 extends PhoneStateListener
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

        _cls1()
        {
            aQ = PhoneUtil20Impl.this;
            super();
        }
    }

}

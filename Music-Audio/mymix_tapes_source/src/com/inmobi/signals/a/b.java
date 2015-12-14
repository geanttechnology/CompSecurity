// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals.a;

import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import com.inmobi.commons.core.utilities.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{

    private static final String a = com/inmobi/signals/a/b.getSimpleName();
    private String b;
    private int c;
    private int d;

    public b()
    {
    }

    public b(CellInfo cellinfo, String s, String s1, int i)
    {
        if (!(cellinfo instanceof CellInfoGsm)) goto _L2; else goto _L1
_L1:
        d = i;
        cellinfo = (CellInfoGsm)cellinfo;
        c = cellinfo.getCellSignalStrength().getDbm();
        cellinfo = cellinfo.getCellIdentity();
        b = a(s, s1, cellinfo.getLac(), cellinfo.getCid(), -1, 0x7fffffff);
_L4:
        return;
_L2:
        if (cellinfo instanceof CellInfoCdma)
        {
            d = i;
            cellinfo = (CellInfoCdma)cellinfo;
            c = cellinfo.getCellSignalStrength().getDbm();
            cellinfo = cellinfo.getCellIdentity();
            b = a(s, cellinfo.getSystemId(), cellinfo.getNetworkId(), cellinfo.getBasestationId());
            return;
        }
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!(cellinfo instanceof CellInfoWcdma)) goto _L4; else goto _L3
_L3:
        d = i;
        cellinfo = (CellInfoWcdma)cellinfo;
        c = cellinfo.getCellSignalStrength().getDbm();
        cellinfo = cellinfo.getCellIdentity();
        b = a(s, s1, cellinfo.getLac(), cellinfo.getCid(), cellinfo.getPsc(), 0x7fffffff);
        return;
        if (!(cellinfo instanceof CellInfoLte)) goto _L4; else goto _L5
_L5:
        d = i;
        cellinfo = (CellInfoLte)cellinfo;
        c = cellinfo.getCellSignalStrength().getDbm();
        cellinfo = cellinfo.getCellIdentity();
        b = a(s, s1, cellinfo.getTac(), cellinfo.getCi(), -1, cellinfo.getPci());
        return;
    }

    public String a(String s, int i, int j, int k)
    {
        return (new StringBuilder()).append(s).append("#").append(i).append("#").append(j).append("#").append(k).toString();
    }

    public String a(String s, String s1, int i, int j, int k, int l)
    {
        s1 = (new StringBuilder()).append(s).append("#").append(s1).append("#").append(i).append("#").append(j).append("#");
        if (k == -1)
        {
            s = "";
        } else
        {
            s = Integer.valueOf(k);
        }
        s1 = s1.append(s).append("#");
        if (l == 0x7fffffff)
        {
            s = "";
        } else
        {
            s = Integer.valueOf(l);
        }
        return s1.append(s).toString();
    }

    public JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", b);
            if (c != 0x7fffffff)
            {
                jsonobject.put("ss", c);
            }
            jsonobject.put("nt", d);
        }
        catch (JSONException jsonexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while converting CellTowerInfo to string.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public void a(int i)
    {
        d = i;
    }

    public void a(String s)
    {
        b = s;
    }

    public void b(int i)
    {
        c = i;
    }

}

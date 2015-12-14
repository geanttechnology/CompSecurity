// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            MTimerHandler, PhoneUtil, Log, Util

public class LBSManager extends BroadcastReceiver
{

    public static final String FILTER_GPS = "filter_gps";
    public static final int INVALID_ACC = -1000;
    public static final float INVALID_LAT = -1000F;
    public static final float INVALID_LNG = -1000F;
    public static final int MM_SOURCE_HARDWARE = 0;
    public static final int MM_SOURCE_NET = 1;
    public static final int MM_SOURCE_REPORT_HARWARE = 3;
    public static final int MM_SOURCE_REPORT_NETWORK = 4;
    private static LocationCache ab;
    private Context R;
    private OnLocationGotListener ac;
    private LocationManager ad;
    private PendingIntent ae;
    private boolean af;
    boolean ag;
    boolean ah;
    boolean ai;
    int aj;
    private MTimerHandler ak;

    public LBSManager(Context context, OnLocationGotListener onlocationgotlistener)
    {
        af = false;
        ah = false;
        ai = false;
        ak = new MTimerHandler(new _cls1(), false);
        ac = onlocationgotlistener;
        ag = false;
        aj = 0;
        R = context;
        PhoneUtil.getSignalStrength(context);
        ad = (LocationManager)context.getSystemService("location");
        b();
        ae = PendingIntent.getBroadcast(context, 0, new Intent("filter_gps"), 0x8000000);
    }

    static boolean a(LBSManager lbsmanager)
    {
        lbsmanager.af = false;
        return false;
    }

    private boolean b()
    {
        boolean flag = false;
        if (ad != null)
        {
            try
            {
                ad.sendExtraCommand("gps", "force_xtra_injection", null);
                ad.sendExtraCommand("gps", "force_time_injection", null);
            }
            catch (Exception exception)
            {
                return false;
            }
            flag = true;
        }
        return flag;
    }

    private void c()
    {
        ak.stopTimer();
        ag = true;
    }

    public static void setLocationCache(float f, float f1, int i, int j)
    {
        if (i == 0)
        {
            return;
        }
        Log.v("MicroMsg.LBSManager", (new StringBuilder("setLocationCache [")).append(f).append(",").append(f1).append("] acc:").append(i).append(" source:").append(j).toString());
        if (ab == null)
        {
            ab = new LocationCache();
        }
        ab.am = f;
        ab.an = f1;
        ab.ao = i;
        ab.time = System.currentTimeMillis();
        ab.I = j;
    }

    public String getTelLocation()
    {
        return PhoneUtil.getCellXml(PhoneUtil.getCellInfoList(R));
    }

    public String getWIFILocation()
    {
        Object obj = (WifiManager)R.getSystemService("wifi");
        if (obj == null)
        {
            Log.e("MicroMsg.LBSManager", "no wifi service");
            return "";
        }
        if (((WifiManager) (obj)).getConnectionInfo() == null)
        {
            Log.e("MicroMsg.LBSManager", "WIFILocation wifi info null");
            return "";
        }
        LinkedList linkedlist = new LinkedList();
        obj = ((WifiManager) (obj)).getScanResults();
        if (obj != null)
        {
            for (int i = 0; i < ((List) (obj)).size(); i++)
            {
                linkedlist.add(new PhoneUtil.MacInfo(((ScanResult)((List) (obj)).get(i)).BSSID, (new StringBuilder()).append(((ScanResult)((List) (obj)).get(i)).level).toString()));
            }

        }
        return PhoneUtil.getMacXml(linkedlist);
    }

    public boolean isGpsEnable()
    {
        boolean flag;
        try
        {
            flag = ad.isProviderEnabled("gps");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        return flag;
    }

    public boolean isNetworkPrividerEnable()
    {
        boolean flag;
        try
        {
            flag = ad.isProviderEnabled("network");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        return flag;
    }

    public void onReceive(Context context, Intent intent)
    {
        context = (Location)intent.getExtras().get("location");
        aj = aj + 1;
        if (context != null)
        {
            boolean flag = "gps".equals(context.getProvider());
            if ((flag && context.getAccuracy() <= 200F || !flag && context.getAccuracy() <= 1000F) && context.getAccuracy() > 0.0F)
            {
                int i;
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = 1;
                }
                setLocationCache((float)context.getLatitude(), (float)context.getLongitude(), (int)context.getAccuracy(), i);
                if (ac != null && (!ag || !ah || !ai))
                {
                    intent = Util.nullAsNil(getWIFILocation());
                    String s = Util.nullAsNil(getTelLocation());
                    if (!ag)
                    {
                        c();
                        ag = true;
                        Log.v("MicroMsg.LBSManager", (new StringBuilder("location by provider ok:[")).append(context.getLatitude()).append(" , ").append(context.getLongitude()).append("]  accuracy:").append(context.getAccuracy()).append("  retry count:").append(aj).append(" isGpsProvider:").append(flag).toString());
                        ac.onLocationGot((float)context.getLatitude(), (float)context.getLongitude(), (int)context.getAccuracy(), i, intent, s, true);
                    } else
                    {
                        if (!ah && i == 0)
                        {
                            ah = true;
                            Log.v("MicroMsg.LBSManager", (new StringBuilder("report location by GPS ok:[")).append(context.getLatitude()).append(" , ").append(context.getLongitude()).append("]  accuracy:").append(context.getAccuracy()).append("  retry count:").append(aj).append(" isGpsProvider:").append(flag).toString());
                            ac.onLocationGot((float)context.getLatitude(), (float)context.getLongitude(), (int)context.getAccuracy(), 3, intent, s, true);
                            return;
                        }
                        if (!ai && i == 1)
                        {
                            ai = true;
                            Log.v("MicroMsg.LBSManager", (new StringBuilder("report location by Network ok:[")).append(context.getLatitude()).append(" , ").append(context.getLongitude()).append("]  accuracy:").append(context.getAccuracy()).append("  retry count:").append(aj).append(" isGpsProvider:").append(flag).toString());
                            ac.onLocationGot((float)context.getLatitude(), (float)context.getLongitude(), (int)context.getAccuracy(), 4, intent, s, true);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void removeGpsUpdate()
    {
        Log.v("MicroMsg.LBSManager", "removed gps update");
        if (ad != null)
        {
            ad.removeUpdates(ae);
        }
        try
        {
            R.unregisterReceiver(this);
            return;
        }
        catch (Exception exception)
        {
            Log.v("MicroMsg.LBSManager", "location receiver has already unregistered");
        }
    }

    public void removeListener()
    {
        Log.v("MicroMsg.LBSManager", "removed gps update on destroy");
        removeGpsUpdate();
        if (ak != null)
        {
            c();
        }
        ac = null;
        R = null;
        ak = null;
        ad = null;
    }

    public void requestGpsUpdate()
    {
        if (isGpsEnable() || isNetworkPrividerEnable())
        {
            Log.v("MicroMsg.LBSManager", "requested gps update");
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("filter_gps");
            R.registerReceiver(this, intentfilter);
            if (isGpsEnable())
            {
                ad.requestLocationUpdates("gps", 500L, 0.0F, ae);
            }
            if (isNetworkPrividerEnable())
            {
                ad.requestLocationUpdates("network", 500L, 0.0F, ae);
                return;
            }
        }
    }

    public void start()
    {
        String s;
        String s1;
        s = Util.nullAsNil(getWIFILocation());
        s1 = Util.nullAsNil(getTelLocation());
        boolean flag;
        if (isGpsEnable() || isNetworkPrividerEnable())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag || af) goto _L2; else goto _L1
_L1:
        af = true;
        aj = 0;
        requestGpsUpdate();
        ak.startTimer(3000L);
_L4:
        return;
_L2:
        boolean flag1;
        if (ab == null)
        {
            flag1 = false;
        } else
        if (System.currentTimeMillis() - ab.time > 0x2bf20L || ab.ao <= 0)
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        if (!flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (ac != null)
        {
            ag = true;
            Log.v("MicroMsg.LBSManager", (new StringBuilder("location by GPS cache ok:[")).append(ab.am).append(" , ").append(ab.an).append("]  accuracy:").append(ab.ao).append(" source:").append(ab.I).toString());
            ac.onLocationGot(ab.am, ab.an, ab.ao, ab.I, s, s1, true);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        ag = true;
        if (!s.equals("") || !s1.equals(""))
        {
            break; /* Loop/switch isn't completed */
        }
        Log.v("MicroMsg.LBSManager", "get location by network failed");
        if (ac != null)
        {
            ac.onLocationGot(-1000F, -1000F, -1000, 0, "", "", false);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        Log.v("MicroMsg.LBSManager", (new StringBuilder("get location by network ok, macs : ")).append(s).append(" cell ids :").append(s1).toString());
        if (ac != null)
        {
            ac.onLocationGot(-1000F, -1000F, -1000, 0, s, s1, true);
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    private class _cls1
        implements MTimerHandler.CallBack
    {

        final LBSManager al;

        public boolean onTimerExpired()
        {
            Log.v("MicroMsg.LBSManager", "get location by GPS failed.");
            al.ag = true;
            al.start();
            LBSManager.a(al);
            return false;
        }

        _cls1()
        {
            al = LBSManager.this;
            super();
        }
    }


    private class LocationCache
    {

        int I;
        float am;
        float an;
        int ao;
        long time;

        LocationCache()
        {
            am = -1000F;
            an = -1000F;
            ao = -1000;
            I = 1;
        }
    }


    private class OnLocationGotListener
    {

        public abstract void onLocationGot(float f, float f1, int i, int j, String s, String s1, boolean flag);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.ContentValues;
import android.content.Context;
import android.drm.DrmInfo;
import android.drm.DrmInfoEvent;
import android.drm.DrmInfoRequest;
import android.drm.DrmManagerClient;
import com.gotv.crackle.util.Log;
import java.util.EventListener;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.gotv.crackle:
//            Application

public class WidevineDrm
{
    static interface WidevineDrmLogEventListener
        extends EventListener
    {

        public abstract void logUpdated();
    }


    private static final long DEVICE_IS_PROVISIONED = 0L;
    private static final long DEVICE_IS_PROVISIONED_SD_ONLY = 2L;
    private static final long seconds_per_day = 0x15180L;
    private static final long seconds_per_hour = 3600L;
    private static final long seconds_per_minute = 60L;
    public StringBuffer logBuffer;
    private DrmManagerClient mDrmManager;
    private long mWVDrmInfoRequestStatusKey;

    public WidevineDrm(Context context)
    {
        mWVDrmInfoRequestStatusKey = 0L;
        logBuffer = new StringBuffer();
        mDrmManager = new DrmManagerClient(context);
        mDrmManager.setOnInfoListener(new android.drm.DrmManagerClient.OnInfoListener() {

            final WidevineDrm this$0;

            public void onInfo(DrmManagerClient drmmanagerclient, DrmInfoEvent drminfoevent)
            {
                if (drminfoevent.getType() == 3)
                {
                    logMessage("Rights installed\n");
                }
            }

            
            {
                this$0 = WidevineDrm.this;
                super();
            }
        });
    }

    private String SecondsToDHMS(long l)
    {
        int i = (int)(l / 0x15180L);
        l -= (long)i * 0x15180L;
        int j = (int)(l / 3600L);
        l -= (long)j * 3600L;
        int k = (int)(l / 60L);
        long l1 = k;
        return (new StringBuilder()).append(Integer.toString(i)).append("d ").append(Integer.toString(j)).append("h ").append(Integer.toString(k)).append("m ").append(Long.toString(l - l1 * 60L)).append("s").toString();
    }

    private String licenseResolution(int i)
    {
        switch (i)
        {
        default:
            return "Unknown";

        case 1: // '\001'
            return "SD only";

        case 2: // '\002'
            return "HD or SD content";
        }
    }

    private String licenseType(int i)
    {
        switch (i)
        {
        default:
            return "Unknown";

        case 1: // '\001'
            return "Streaming";

        case 2: // '\002'
            return "Offline";

        case 3: // '\003'
            return "Both";
        }
    }

    private void logContentValues(ContentValues contentvalues, String s)
    {
        if (contentvalues != null)
        {
            for (s = contentvalues.keySet().iterator(); s.hasNext();)
            {
                String s1 = (String)s.next();
                if (s1.toLowerCase(Locale.US).contains("time"))
                {
                    logMessage((new StringBuilder()).append(s1).append(" = ").append(SecondsToDHMS(contentvalues.getAsLong(s1).longValue())).append("\n").toString());
                } else
                if (s1.toLowerCase(Locale.US).contains("licensetype"))
                {
                    logMessage((new StringBuilder()).append(s1).append(" = ").append(licenseType(contentvalues.getAsInteger(s1).intValue())).append("\n").toString());
                } else
                if (s1.toLowerCase(Locale.US).contains("licensedresolution"))
                {
                    logMessage((new StringBuilder()).append(s1).append(" = ").append(licenseResolution(contentvalues.getAsInteger(s1).intValue())).append("\n").toString());
                } else
                {
                    logMessage((new StringBuilder()).append(s1).append(" = ").append(contentvalues.get(s1)).append("\n").toString());
                }
            }

        } else
        {
            logMessage((new StringBuilder()).append(s).append("\n").toString());
        }
    }

    private void logMessage(String s)
    {
        Log.d("WidevineDrm", s);
    }

    public int acquireRights(String s)
    {
        int i = mDrmManager.acquireRights(getDrmInfoRequest(s));
        logMessage((new StringBuilder()).append("acquireRights = ").append(i).append("\n").toString());
        return i;
    }

    public int checkRightsStatus(String s)
    {
        mDrmManager.acquireDrmInfo(getDrmInfoRequest(s));
        int i = mDrmManager.checkRightsStatus(s);
        logMessage((new StringBuilder()).append("checkRightsStatus  = ").append(i).append("\n").toString());
        return i;
    }

    public void getConstraints(String s)
    {
        logContentValues(mDrmManager.getConstraints(s, 1), "No Contraints");
    }

    public DrmInfoRequest getDrmInfoRequest(String s)
    {
        DrmInfoRequest drminforequest = new DrmInfoRequest(3, "video/wvm");
        drminforequest.put("WVDRMServerKey", "http://www.crackle.com/widevine/widevineproxy.ashx");
        drminforequest.put("WVDeviceIDKey", android.provider.Settings.Secure.getString(Application.getInstance().getContentResolver(), "android_id"));
        drminforequest.put("WVAssetURIKey", s);
        drminforequest.put("WVPortalKey", "crackle");
        drminforequest.put("WVLicenseTypeKey", "1");
        return drminforequest;
    }

    public boolean isProvisionedDevice()
    {
        return mWVDrmInfoRequestStatusKey == 0L || mWVDrmInfoRequestStatusKey == 2L;
    }

    public void registerPortal(String s)
    {
        DrmInfoRequest drminforequest = new DrmInfoRequest(1, "video/wvm");
        drminforequest.put("WVPortalKey", s);
        s = (String)mDrmManager.acquireDrmInfo(drminforequest).get("WVDrmInfoRequestStatusKey");
        if (s != null && !s.equals(""))
        {
            mWVDrmInfoRequestStatusKey = Long.parseLong(s);
        }
    }

    public int removeAllRights()
    {
        int i = mDrmManager.removeAllRights();
        logMessage((new StringBuilder()).append("removeAllRights = ").append(i).append("\n").toString());
        return i;
    }

    public int removeRights(String s)
    {
        mDrmManager.acquireDrmInfo(getDrmInfoRequest(s));
        int i = mDrmManager.removeRights(s);
        logMessage((new StringBuilder()).append("removeRights = ").append(i).append("\n").toString());
        return i;
    }

    public void setOnErrorListener(android.drm.DrmManagerClient.OnErrorListener onerrorlistener)
    {
        mDrmManager.setOnErrorListener(onerrorlistener);
    }

    public void setOnEventListener(android.drm.DrmManagerClient.OnEventListener oneventlistener)
    {
        mDrmManager.setOnEventListener(oneventlistener);
    }

    public void showRights(String s)
    {
        logMessage("showRights\n");
        mDrmManager.acquireDrmInfo(getDrmInfoRequest(s));
        logContentValues(mDrmManager.getConstraints(s, 1), "No Rights");
    }

}

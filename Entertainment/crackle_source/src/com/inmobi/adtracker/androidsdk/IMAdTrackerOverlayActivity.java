// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.adtracker.androidsdk;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants;
import com.inmobi.adtracker.androidsdk.impl.Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class IMAdTrackerOverlayActivity extends Activity
{

    public IMAdTrackerOverlayActivity()
    {
    }

    private void processParams(String s)
    {
        String s1;
        HashMap hashmap;
        String as[];
        as = s.split("&");
        s = (String[])null;
        hashmap = new HashMap();
        s1 = s;
        if (as == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L6:
        if (i < as.length) goto _L4; else goto _L3
_L3:
        s1 = s;
_L2:
        if (s1.equals(null))
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
            {
                Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Failed to receive response from server");
            }
            Utils.resetStatus();
        } else
        {
            s = hashmap.keySet().iterator();
            while (s.hasNext()) 
            {
                String s2 = (String)s.next();
                String s3 = (String)hashmap.get(s2);
                if (IMAdTrackerAnalyticsConstants.IMAdTracker_RESULT.equals(s2))
                {
                    if (IMAdTrackerAnalyticsConstants.FAILURE.equals(s3))
                    {
                        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
                        {
                            Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Failure response from Download Server");
                        }
                        Utils.resetStatus();
                    } else
                    if (IMAdTrackerAnalyticsConstants.SUCCESS.equals(s3))
                    {
                        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
                        {
                            Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Successful uploaded install goal ");
                        }
                        Utils.updateStatus();
                    }
                } else
                if (IMAdTrackerAnalyticsConstants.IMAdTracker_UUID.equals(s2) && "" != s3 && s3 != null)
                {
                    Utils.setPreferences(IMAdTrackerAnalyticsConstants.IMAdTracker_UUID, s3);
                } else
                if (IMAdTrackerAnalyticsConstants.IMAdTracker_ERROR.equals(s2) && "" != s3 && s3 != null && IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
                {
                    Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, (new StringBuilder("Error: ")).append(Uri.decode(s3)).toString());
                }
            }
        }
        return;
_L4:
        s = as[i].split("=");
        if (2 == s.length)
        {
            hashmap.put(s[0], s[1]);
        }
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        processParams(getIntent().getData().getEncodedQuery());
        IMAdTrackerAnalyticsConstants.INSTALL_REQ_IN_PROGRESS = Boolean.valueOf(false);
        moveTaskToBack(true);
        finish();
    }
}

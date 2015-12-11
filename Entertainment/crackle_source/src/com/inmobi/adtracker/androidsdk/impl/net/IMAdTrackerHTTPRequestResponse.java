// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.adtracker.androidsdk.impl.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import com.inmobi.adtracker.androidsdk.IMAdTrackerUtil;
import com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants;
import com.inmobi.adtracker.androidsdk.impl.Utils;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

class IMAdTrackerHTTPRequestResponse
{

    IMAdTrackerHTTPRequestResponse()
    {
    }

    private static String formHTTPRequest(String s, String s1, String s2, int i, String s3)
    {
        String s4 = Utils.getPreferences(IMAdTrackerAnalyticsConstants.IMAdTracker_UUID);
        Object obj = null;
        LinkedList linkedlist = new LinkedList();
        if (s != null)
        {
            linkedlist.add(new BasicNameValuePair(IMAdTrackerAnalyticsConstants.APP_ID, s));
        }
        if (s1 != null)
        {
            linkedlist.add(new BasicNameValuePair(IMAdTrackerAnalyticsConstants.ODIN1, s1));
        }
        if (s2 != null)
        {
            linkedlist.add(new BasicNameValuePair(IMAdTrackerAnalyticsConstants.GOALNAME, s2));
        }
        linkedlist.add(new BasicNameValuePair(IMAdTrackerAnalyticsConstants.SOURCE, "and"));
        linkedlist.add(new BasicNameValuePair(IMAdTrackerAnalyticsConstants.EVENTCOUNT, Integer.toString(i)));
        linkedlist.add(new BasicNameValuePair(IMAdTrackerAnalyticsConstants.SDKVER, IMAdTrackerUtil.getSDKVersion()));
        try
        {
            s = Utils.getAppContext().getPackageManager().getPackageInfo(Utils.getAppContext().getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = obj;
        }
        if (s != null)
        {
            linkedlist.add(new BasicNameValuePair(IMAdTrackerAnalyticsConstants.APPVER, s));
        }
        if (s4 != null && s3 == null)
        {
            linkedlist.add(new BasicNameValuePair(IMAdTrackerAnalyticsConstants.IMAdTracker_UUID, s4));
        }
        if (s3 == null && "install".equals(s2))
        {
            linkedlist.add(new BasicNameValuePair(IMAdTrackerAnalyticsConstants.INSTALLFLAG, "1"));
        }
        linkedlist.add(new BasicNameValuePair(IMAdTrackerAnalyticsConstants.TIMESTAMP, Long.toString(SystemClock.uptimeMillis())));
        return URLEncodedUtils.format(linkedlist, "utf-8");
    }

    public static com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode sendHTTPRequest(String s, String s1, String s2, int i)
    {
        Object obj;
        com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode statuscode;
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
        {
            Log.i(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Sending HTTP Request");
        }
        statuscode = com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
        obj = statuscode;
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        obj = statuscode;
        String s4 = Utils.getPreferences(IMAdTrackerAnalyticsConstants.MARKET_REFERRER);
        String s3;
        Object obj1;
        Object obj2;
        obj2 = null;
        s3 = null;
        obj1 = null;
        obj = statuscode;
        s = formHTTPRequest(s, s1, s2, i, s4);
        if (s4 != null) goto _L2; else goto _L1
_L1:
        obj = statuscode;
        s = (new StringBuilder(String.valueOf(IMAdTrackerAnalyticsConstants.UploadURL))).append(s).toString();
_L7:
        obj = statuscode;
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() < com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
        {
            break MISSING_BLOCK_LABEL_138;
        }
        obj = statuscode;
        Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, s);
        obj = statuscode;
        s = defaulthttpclient.execute(new HttpGet(s));
        obj = statuscode;
        s1 = statuscode;
        if (s.getStatusLine().getStatusCode() != 200) goto _L4; else goto _L3
_L3:
        obj = statuscode;
        s1 = EntityUtils.toString(s.getEntity());
        obj = statuscode;
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() < com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
        {
            break MISSING_BLOCK_LABEL_242;
        }
        obj = statuscode;
        Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, (new StringBuilder("RESPONSE: ")).append(s1).toString());
        s1 = obj2;
        obj = statuscode;
        if (s.getFirstHeader("sdt-result") == null)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        obj = statuscode;
        s1 = s.getFirstHeader("sdt-result").getValue();
        obj = statuscode;
        if (s.getFirstHeader("sdt-error") == null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        obj = statuscode;
        s3 = s.getFirstHeader("sdt-error").getValue();
        s2 = obj1;
        obj = statuscode;
        if (s.getFirstHeader("sdt-uuid") == null)
        {
            break MISSING_BLOCK_LABEL_348;
        }
        obj = statuscode;
        s2 = s.getFirstHeader("sdt-uuid").getValue();
        obj = statuscode;
        if (!s1.equals(null)) goto _L6; else goto _L5
_L2:
        obj = statuscode;
        s = (new StringBuilder(String.valueOf(IMAdTrackerAnalyticsConstants.UploadURL))).append(s).append("&").append(s4).toString();
          goto _L7
_L6:
        obj = statuscode;
        if (!IMAdTrackerAnalyticsConstants.SUCCESS.equals(s1)) goto _L9; else goto _L8
_L8:
        obj = statuscode;
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() < com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
        {
            break MISSING_BLOCK_LABEL_452;
        }
        obj = statuscode;
        Log.i(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Successfully uploaded Goal Ping");
        obj = statuscode;
        s = com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS;
_L10:
        s1 = s;
        if (s2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = s;
        s1 = s;
        if ("" == s2.trim())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = s;
        Utils.setPreferences(IMAdTrackerAnalyticsConstants.IMAdTracker_UUID, s2);
        s1 = s;
        break; /* Loop/switch isn't completed */
_L9:
        s = statuscode;
        obj = statuscode;
        if (!IMAdTrackerAnalyticsConstants.FAILURE.equals(s1))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_583;
        }
        obj = statuscode;
        if ("" == s3.trim())
        {
            break MISSING_BLOCK_LABEL_583;
        }
        obj = statuscode;
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() < com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
        {
            break MISSING_BLOCK_LABEL_583;
        }
        obj = statuscode;
        Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, (new StringBuilder("Error uploading ping ")).append(Uri.decode(s3)).toString());
        obj = statuscode;
        s = com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
        if (true) goto _L10; else goto _L4
_L5:
        obj = statuscode;
        try
        {
            return com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s1 = ((String) (obj));
        }
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
        {
            Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Error uploading Download data");
            s.printStackTrace();
            s1 = ((String) (obj));
        }
_L4:
        return s1;
    }

    public static boolean serverReachable(String s)
    {
        int i = (new DefaultHttpClient()).execute(new HttpGet(s)).getStatusLine().getStatusCode();
        if (i == 200)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_66;
        s;
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.DEBUG.getValue())
        {
            Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Server not reachable..Logging events");
        }
        return false;
    }
}

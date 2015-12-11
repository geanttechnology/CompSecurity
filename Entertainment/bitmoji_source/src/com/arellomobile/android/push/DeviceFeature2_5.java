// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import android.location.Location;
import com.arellomobile.android.push.data.PushZoneLocation;
import com.arellomobile.android.push.request.AppOpenRequest;
import com.arellomobile.android.push.request.AppRemovedRequest;
import com.arellomobile.android.push.request.ApplicationEventRequest;
import com.arellomobile.android.push.request.GetBeaconsRequest;
import com.arellomobile.android.push.request.GetNearestZoneRequest;
import com.arellomobile.android.push.request.GetTagsRequest;
import com.arellomobile.android.push.request.MessageDeliveredRequest;
import com.arellomobile.android.push.request.ProcessBeaconRequest;
import com.arellomobile.android.push.request.PushStatRequest;
import com.arellomobile.android.push.request.RequestManager;
import com.arellomobile.android.push.request.SetTagsRequest;
import com.arellomobile.android.push.request.TrackInAppRequest;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeviceFeature2_5
{

    public DeviceFeature2_5()
    {
    }

    public static JSONObject getBeacons(Context context)
        throws Exception
    {
        GetBeaconsRequest getbeaconsrequest = new GetBeaconsRequest();
        RequestManager.sendRequest(context, getbeaconsrequest);
        return getbeaconsrequest.getResponse();
    }

    public static PushZoneLocation getNearestZone(Context context, Location location)
        throws Exception
    {
        location = new GetNearestZoneRequest(location);
        RequestManager.sendRequest(context, location);
        return location.getNearestLocation();
    }

    public static Map getTags(Context context)
        throws Exception
    {
        GetTagsRequest gettagsrequest = new GetTagsRequest();
        RequestManager.sendRequest(context, gettagsrequest);
        return gettagsrequest.getTags();
    }

    public static void processBeacon(Context context, String s, String s1, String s2, String s3)
        throws Exception
    {
        RequestManager.sendRequest(context, new ProcessBeaconRequest(s, s1, s2, s3));
    }

    public static void sendAppOpen(Context context)
        throws Exception
    {
        RequestManager.sendRequest(context, new AppOpenRequest());
    }

    public static void sendAppRemovedData(Context context, String s)
        throws Exception
    {
        RequestManager.sendRequest(context, new AppRemovedRequest(s));
    }

    public static void sendGoalAchieved(Context context, String s, Integer integer)
        throws Exception
    {
        RequestManager.sendRequest(context, new ApplicationEventRequest(s, integer));
    }

    public static void sendMessageDeliveryEvent(Context context, String s)
        throws Exception
    {
        RequestManager.sendRequest(context, new MessageDeliveredRequest(s));
    }

    public static void sendPushStat(Context context, String s)
        throws Exception
    {
        RequestManager.sendRequest(context, new PushStatRequest(s));
    }

    public static JSONArray sendTags(Context context, Map map)
        throws Exception
    {
        map = new SetTagsRequest(map);
        RequestManager.sendRequest(context, map);
        return map.getSkippedTags();
    }

    public static void trackInAppRequest(Context context, String s, String s1, long l)
        throws Exception
    {
        RequestManager.sendRequest(context, new TrackInAppRequest(s, s1, l));
    }
}

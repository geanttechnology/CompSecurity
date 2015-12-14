// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.model:
//            Response, NotificationResponse

public class NewsResponse extends Response
{

    public JSONArray response;

    public NewsResponse()
    {
    }

    public static NotificationResponse toNotificationResponse(NewsResponse newsresponse)
    {
        NotificationResponse notificationresponse;
        SimpleDateFormat simpledateformat;
        notificationresponse = new NotificationResponse();
        notificationresponse.status = newsresponse.status;
        notificationresponse.reason = newsresponse.reason;
        notificationresponse.message = newsresponse.message;
        newsresponse = newsresponse.response;
        simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        if (newsresponse == null || newsresponse.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_396;
        }
        notificationresponse.response = new ArrayList();
        int i = 0;
_L5:
        NotificationResponse.NotificationItem notificationitem;
        Object obj;
        Object obj1;
        if (i >= newsresponse.length())
        {
            break MISSING_BLOCK_LABEL_396;
        }
        obj = newsresponse.getJSONObject(i);
        obj1 = ((JSONObject) (obj)).getJSONObject("data");
        notificationitem = new NotificationResponse.NotificationItem();
        notificationitem.id = ((JSONObject) (obj)).optString("id");
        notificationitem.type = ((JSONObject) (obj1)).optString("type");
        notificationitem.message = ((JSONObject) (obj1)).optString("message");
        notificationitem.lastLowVersion = ((JSONObject) (obj1)).optInt("latest_low_version");
        notificationitem.lastHighVersion = ((JSONObject) (obj1)).optInt("latest_high_version");
        notificationitem.action = ((JSONObject) (obj1)).optString("action");
        notificationitem.createdAt = simpledateformat.parse(((JSONObject) (obj)).getString("created"));
        if (!((JSONObject) (obj1)).has("params"))
        {
            break MISSING_BLOCK_LABEL_373;
        }
        obj1 = ((JSONObject) (obj1)).getJSONObject("params");
        obj = new BannersResponse.BannerItem();
        obj.activityName = ((JSONObject) (obj1)).optString("act_name", null);
        obj.actionUrl = ((JSONObject) (obj1)).optString("url", null);
        if (!((JSONObject) (obj1)).has("act_params")) goto _L2; else goto _L1
_L1:
        obj1 = ((JSONObject) (obj1)).getJSONArray("act_params");
        if (((JSONArray) (obj1)).length() <= 0) goto _L2; else goto _L3
_L3:
        obj.activityParams = new ArrayList();
        int j = 0;
_L4:
        if (j >= ((JSONArray) (obj1)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        BannersResponse.ActivityParams activityparams = new BannersResponse.ActivityParams();
        JSONObject jsonobject = ((JSONArray) (obj1)).getJSONObject(j);
        activityparams.name = jsonobject.getString("name");
        activityparams.type = jsonobject.getString("type");
        activityparams.value = jsonobject.getString("value");
        ((BannersResponse.BannerItem) (obj)).activityParams.add(activityparams);
        j++;
        if (true) goto _L4; else goto _L2
_L2:
        notificationitem.sysParams = ((BannersResponse.BannerItem) (obj));
        notificationresponse.response.add(notificationitem);
        i++;
          goto _L5
        newsresponse;
        newsresponse.printStackTrace();
        return notificationresponse;
        newsresponse;
        newsresponse.printStackTrace();
        return notificationresponse;
    }

    public String toString()
    {
        return toNotificationResponse(this).toString();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import android.app.Application;
import android.content.SharedPreferences;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.NewsResponse;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class PicsartNewsController extends BaseSocialinApiRequestController
{

    private static String TAG = com/socialin/android/apiv3/controllers/PicsartNewsController.getSimpleName();
    private static long validPeriod = 0x5265c00L;
    int requestId;
    private String sinceId;

    public PicsartNewsController()
    {
        requestId = -1;
        sinceId = SocialinV3.getInstance().getContext().getSharedPreferences("news.since.id", 0).getString("since_id", null);
    }

    public void doRequest(String s, RequestParams requestparams)
    {
        params = requestparams;
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().getPicsartNews(sinceId, null, SocialinV3.market, this, cacheConfig, validPeriod);
            return;
        }
    }

    public int getRequestId()
    {
        return requestId;
    }

    public void onFailure(Exception exception, Request request)
    {
        if (request.g.a == 2)
        {
            status = -1;
            cacheConfig = 3;
            doRequest();
            cacheConfig = 2;
            return;
        } else
        {
            super.onFailure(exception, request);
            return;
        }
    }

    public void onSuccess(NewsResponse newsresponse, Request request)
    {
        super.onSuccess(newsresponse, request);
        if (newsresponse != null && !"error".equals(newsresponse.status)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (request.g.a == 2 && !request.g.e && "success".equals(newsresponse.status))
        {
            SocialinApiV3.getInstance().getPicsartNews(sinceId, null, SocialinV3.market, this, 3, validPeriod);
            return;
        }
        if (!"success".equals(newsresponse.status) || request.g.a != 3 || newsresponse.response == null || newsresponse.response.length() <= 0) goto _L1; else goto _L3
_L3:
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        int i;
        long l;
        i = 0;
        request = null;
        l = 0L;
_L5:
        JSONObject jsonobject;
        Date date;
        if (i >= newsresponse.response.length())
        {
            break MISSING_BLOCK_LABEL_204;
        }
        jsonobject = newsresponse.response.getJSONObject(i);
        date = simpledateformat.parse(jsonobject.getString("created"));
        long l1 = l;
        if (date.getTime() > l)
        {
            l1 = date.getTime();
            request = jsonobject.getString("id");
        }
        break MISSING_BLOCK_LABEL_247;
        try
        {
            SocialinV3.getInstance().getContext().getSharedPreferences("news.since.id", 0).edit().putString("since_id", request).commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (NewsResponse newsresponse) { }
        // Misplaced declaration of an exception variable
        catch (NewsResponse newsresponse) { }
        newsresponse.getMessage();
        return;
        i++;
        l = l1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((NewsResponse)response, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((NewsResponse)obj, request);
    }

}

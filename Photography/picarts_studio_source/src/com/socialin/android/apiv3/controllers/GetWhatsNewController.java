// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.WhatsNewResponse;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.android.apiv3.request.WhatsNewParams;
import com.socialin.android.d;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.a;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetWhatsNewController extends BaseSocialinApiRequestController
{

    private static long validPeriod = 0x1b7740L;
    int requestId;

    public GetWhatsNewController()
    {
        requestId = -1;
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (WhatsNewParams)requestparams);
    }

    public void doRequest(String s, WhatsNewParams whatsnewparams)
    {
        long l = 0L;
        params = whatsnewparams;
        if (status == 0)
        {
            return;
        }
        status = 0;
        if (d.b)
        {
            cacheConfig = 3;
            validPeriod = 0L;
        }
        SocialinApiV3 socialinapiv3 = SocialinApiV3.getInstance();
        String s1 = SocialinV3.market;
        if (whatsnewparams != null)
        {
            l = whatsnewparams.lastId;
        }
        if (whatsnewparams != null)
        {
            whatsnewparams = whatsnewparams.version;
        } else
        {
            whatsnewparams = null;
        }
        requestId = socialinapiv3.whatsNew("com.picsart.studio", s1, s, l, whatsnewparams, this, cacheConfig, validPeriod);
    }

    public int getCacheConfig()
    {
        return cacheConfig;
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
            if (!d.b)
            {
                cacheConfig = 2;
            }
            return;
        } else
        {
            super.onFailure(exception, request);
            return;
        }
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((WhatsNewResponse)response, request);
    }

    public void onSuccess(WhatsNewResponse whatsnewresponse, Request request)
    {
        if (whatsnewresponse != null && whatsnewresponse.response != null)
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = whatsnewresponse.response.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem whatsnewitem = (com.socialin.android.apiv3.model.WhatsNewResponse.WhatsNewItem)iterator.next();
                if (whatsnewitem.getDataType().equals("whats_new"))
                {
                    arraylist.add(whatsnewitem);
                }
            } while (true);
            whatsnewresponse.response.clear();
            whatsnewresponse.response.addAll(arraylist);
        }
        super.onSuccess(whatsnewresponse, request);
        while (whatsnewresponse == null || "error".equals(whatsnewresponse.status) || !"success".equals(whatsnewresponse.status) || request.g.a != 2 || request.g.e) 
        {
            return;
        }
        SocialinApiV3.getInstance().whatsNew("com.picsart.studio", SocialinV3.market, null, 0L, null, null, 3, validPeriod);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((WhatsNewResponse)obj, request);
    }

    public void setCacheConfig(int i)
    {
        cacheConfig = i;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import android.text.TextUtils;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.ConnectionsResponse;
import com.socialin.android.apiv3.model.FbConnection;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.TwitterConnection;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.UserConnection;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetOwnerConnectionsController extends BaseSocialinApiRequestController
{

    private int requestId;

    public GetOwnerConnectionsController()
    {
        requestId = -1;
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
            requestId = SocialinApiV3.getInstance().getOwnerConnections(s, this);
            return;
        }
    }

    public int getRequestId()
    {
        return requestId;
    }

    public void onSuccess(ConnectionsResponse connectionsresponse, Request request)
    {
        if (connectionsresponse != null)
        {
            com.socialin.android.apiv3.model.User.UserConnections userconnections = SocialinV3.getInstance().getUser().connections;
            if (userconnections == null)
            {
                userconnections = new com.socialin.android.apiv3.model.User.UserConnections();
            }
            Object obj = connectionsresponse.connections;
            if (obj != null && !((ArrayList) (obj)).isEmpty())
            {
                obj = ((ArrayList) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    UserConnection userconnection = (UserConnection)((Iterator) (obj)).next();
                    if (userconnection != null && !TextUtils.isEmpty(userconnection.provider))
                    {
                        if ("facebook".equals(userconnection.provider))
                        {
                            userconnections.connectToFb(new FbConnection(userconnection.data));
                        }
                        if ("twitter".equals(userconnection.provider))
                        {
                            userconnections.connectToTwitter(new TwitterConnection(userconnection.data));
                        }
                    }
                } while (true);
            }
        }
        super.onSuccess(connectionsresponse, request);
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((ConnectionsResponse)response, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((ConnectionsResponse)obj, request);
    }
}

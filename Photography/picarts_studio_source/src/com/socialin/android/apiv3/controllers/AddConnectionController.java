// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import android.text.TextUtils;
import com.socialin.android.a;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.FbConnection;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.StatusObj;
import com.socialin.android.apiv3.model.TwitterConnection;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.UserConnection;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class AddConnectionController extends BaseSocialinApiRequestController
{

    private a addControllerListener;
    int requestId;

    public AddConnectionController()
    {
        requestId = -1;
    }

    public void doRequest(String s, UserConnection userconnection)
    {
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        String s9;
        params = userconnection;
        if (status == 0)
        {
            return;
        }
        status = 0;
        s1 = (new JSONObject()).toString();
        s9 = String.valueOf(userconnection.connectionId);
        s6 = userconnection.token;
        s7 = s6;
        s5 = s9;
        s3 = s1;
        s4 = s6;
        s2 = s1;
        if (userconnection.data == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        s4 = s6;
        s2 = s1;
        String s8 = userconnection.data.toJson().toString();
        s1 = s6;
        s4 = s6;
        s2 = s8;
        if (!TextUtils.isEmpty(s6))
        {
            break MISSING_BLOCK_LABEL_123;
        }
        s4 = s6;
        s2 = s8;
        s1 = userconnection.data.token;
        s7 = s1;
        s5 = s9;
        s3 = s8;
        if (s9 != null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        s7 = s1;
        s5 = s9;
        s3 = s8;
        s4 = s1;
        s2 = s8;
        if (TextUtils.isEmpty(userconnection.data.id))
        {
            break MISSING_BLOCK_LABEL_193;
        }
        s4 = s1;
        s2 = s8;
        s5 = userconnection.data.id;
        s3 = s8;
        s7 = s1;
        s2 = s3;
        s4 = s7;
_L2:
        requestId = SocialinApiV3.getInstance().addConnection(s, this, s5, userconnection.provider, s4, s2);
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        s5 = "12";
        if (true) goto _L2; else goto _L1
_L1:
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (UserConnection)requestparams);
    }

    public int getRequestId()
    {
        return requestId;
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((StatusObj)response, request);
    }

    public void onSuccess(StatusObj statusobj, Request request)
    {
        if (!SocialinV3.getInstance().isRegistered()) goto _L2; else goto _L1
_L1:
        if (SocialinV3.getInstance().getUser().connections == null)
        {
            SocialinV3.getInstance().getUser().connections = new com.socialin.android.apiv3.model.User.UserConnections();
        }
        if (!((UserConnection)params).provider.equals("facebook")) goto _L4; else goto _L3
_L3:
        FbConnection fbconnection;
        if (((UserConnection)params).data == null)
        {
            fbconnection = new FbConnection();
        } else
        {
            fbconnection = new FbConnection(((UserConnection)params).data);
        }
        fbconnection.connectionId = ((UserConnection)params).connectionId;
        fbconnection.token = ((UserConnection)params).token;
        SocialinV3.getInstance().getUser().connections.connectToFb(fbconnection);
        SocialinV3.getInstance().writeUser();
_L6:
        if (addControllerListener != null)
        {
            addControllerListener.a();
        }
_L2:
        super.onSuccess(statusobj, request);
        return;
_L4:
        if (((UserConnection)params).provider.equals("twitter"))
        {
            TwitterConnection twitterconnection;
            if (((UserConnection)params).data == null)
            {
                twitterconnection = new TwitterConnection();
            } else
            {
                twitterconnection = new TwitterConnection(((UserConnection)params).data);
            }
            twitterconnection.connectionId = ((UserConnection)params).connectionId;
            twitterconnection.token = ((UserConnection)params).token;
            SocialinV3.getInstance().getUser().connections.connectToTwitter(twitterconnection);
            SocialinV3.getInstance().writeUser();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((StatusObj)obj, request);
    }

    public void setAddControllerListener(a a1)
    {
        addControllerListener = a1;
    }
}

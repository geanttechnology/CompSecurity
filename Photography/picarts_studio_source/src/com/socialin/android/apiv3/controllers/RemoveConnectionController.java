// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.StatusObj;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.UserConnection;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.android.util.b;
import com.socialin.asyncnet.Request;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class RemoveConnectionController extends BaseSocialinApiRequestController
{

    private int requestId;

    public RemoveConnectionController()
    {
        requestId = -1;
    }

    public void doRequest(String s, UserConnection userconnection)
    {
        params = userconnection;
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().removeConnection(s, this, userconnection.provider);
            return;
        }
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
        com.socialin.android.apiv3.model.User.UserConnections userconnections;
        String s;
        byte byte0;
        if (SocialinV3.getInstance().isRegistered())
        {
            userconnections = SocialinV3.getInstance().getUser().connections;
        } else
        {
            userconnections = null;
        }
        if (userconnections == null) goto _L2; else goto _L1
_L1:
        s = ((UserConnection)params).provider;
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 76
    //                   -916346253: 132
    //                   28903346: 148
    //                   497130182: 116;
           goto _L3 _L4 _L5 _L6
_L3:
        byte0;
        JVM INSTR tableswitch 0 2: default 104
    //                   0 164
    //                   1 177
    //                   2 190;
           goto _L2 _L7 _L8 _L9
_L2:
        super.onSuccess(statusobj, request);
        return;
_L6:
        if (s.equals("facebook"))
        {
            byte0 = 0;
        }
          goto _L3
_L4:
        if (s.equals("twitter"))
        {
            byte0 = 1;
        }
          goto _L3
_L5:
        if (s.equals("instagram"))
        {
            byte0 = 2;
        }
          goto _L3
_L7:
        userconnections.disconnectFb();
        SocialinV3.getInstance().writeUser();
          goto _L2
_L8:
        userconnections.disconnectTwitter();
        SocialinV3.getInstance().writeUser();
          goto _L2
_L9:
        if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
        {
            b.a(SocialinV3.getInstance().getContext()).a("Connected Instagram", false);
        }
          goto _L2
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((StatusObj)obj, request);
    }
}

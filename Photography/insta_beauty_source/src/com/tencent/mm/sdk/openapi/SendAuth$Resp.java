// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            BaseResp

public class fromBundle extends BaseResp
{

    public int expireDate;
    public String resultUrl;
    public String state;
    public String token;
    public String userName;

    final boolean checkArgs()
    {
        if (state != null && state.length() > 1024)
        {
            Log.e("MicroMsg.SDK.SendAuth.Resp", "checkArgs fail, state is invalid");
            return false;
        } else
        {
            return true;
        }
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
        userName = bundle.getString("_wxapi_sendauth_resp_userName");
        token = bundle.getString("_wxapi_sendauth_resp_token");
        expireDate = bundle.getInt("_wxapi_sendauth_resp_expireDate", 0);
        state = bundle.getString("_wxapi_sendauth_resp_state");
    }

    public int getType()
    {
        return 1;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putString("_wxapi_sendauth_resp_userName", userName);
        bundle.putString("_wxapi_sendauth_resp_token", token);
        bundle.putInt("_wxapi_sendauth_resp_expireDate", expireDate);
        bundle.putString("_wxapi_sendauth_resp_state", state);
    }

    public ()
    {
    }

    public (Bundle bundle)
    {
        fromBundle(bundle);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.request;

import com.socialin.android.apiv3.model.Adress;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.request:
//            ParamWithUserData

public class SignupParams extends ParamWithUserData
{

    public Adress adress;
    public String email;
    public JSONObject fbData;
    public String fbEmail;
    public String fbId;
    public String fbName;
    public String fbToken;
    public String fbUrl;
    public JSONObject googlePlusData;
    public String gpEmail;
    public String gpImgUrl;
    public String gpUrl;
    public String gpUserId;
    public String gpUserName;
    public String gpUserScreenName;
    public String gpUserToken;
    public String name;
    public String password;
    public String photoPath;
    public String photoUrl;
    public String provider;
    public String twUserId;
    public String twUserName;
    public String twUserScreenName;
    public String twUserToken;
    public String twUserTokenSecret;
    public JSONObject twitterData;

    public SignupParams()
    {
    }
}

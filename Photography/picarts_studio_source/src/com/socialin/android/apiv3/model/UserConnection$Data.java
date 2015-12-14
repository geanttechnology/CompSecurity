// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import com.socialin.android.c;
import com.socialin.gson.Gson;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.model:
//            UserConnection

public class cover
{

    public String cover;
    public String email;
    public String id;
    public String name;
    public String profileImgUrl;
    public String profileUrl;
    public String screenName;
    final UserConnection this$0;
    public String token;
    public long tokenExpired;
    public String tokenSecret;

    public JSONObject toJson()
    {
        return new JSONObject(c.a().toJson(this));
    }

    public ()
    {
        this$0 = UserConnection.this;
        super();
        tokenExpired = 0L;
    }

    public tokenExpired(JSONObject jsonobject)
    {
        this$0 = UserConnection.this;
        super();
        tokenExpired = 0L;
        if (jsonobject == null)
        {
            return;
        } else
        {
            token = jsonobject.optString("token");
            tokenSecret = jsonobject.optString("token_secret");
            tokenExpired = jsonobject.optLong("token_expired");
            profileUrl = jsonobject.optString("profile_url");
            profileImgUrl = jsonobject.optString("profile_img_url");
            name = jsonobject.optString("name");
            screenName = jsonobject.optString("screen_name");
            email = jsonobject.optString("email");
            id = jsonobject.optString("id");
            cover = jsonobject.optString("cover");
            return;
        }
    }
}

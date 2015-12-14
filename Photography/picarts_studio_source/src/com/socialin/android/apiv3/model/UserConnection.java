// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import com.socialin.android.apiv3.request.RequestParams;

public class UserConnection extends RequestParams
{

    public String connectionId;
    public Data data;
    public String provider;
    public Settings settings;
    public String token;

    public UserConnection()
    {
        data = new Data();
        settings = new Settings();
    }

    private class Data
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

        public Data()
        {
            this$0 = UserConnection.this;
            super();
            tokenExpired = 0L;
        }

        public Data(JSONObject jsonobject)
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


    private class Settings
    {

        public boolean actionAdd;
        public boolean actionAll;
        public boolean actionComment;
        public boolean actionFollow;
        public boolean actionLike;
        final UserConnection this$0;

        public Settings()
        {
            this$0 = UserConnection.this;
            super();
            actionFollow = true;
            actionAdd = true;
            actionComment = true;
            actionLike = true;
            actionAll = true;
        }
    }

}

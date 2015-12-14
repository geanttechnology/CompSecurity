// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.model:
//            UserConnection

public class InstagramConnection extends UserConnection
{

    public InstagramConnection()
    {
        provider = "instagram";
    }

    public InstagramConnection(UserConnection.Data data)
    {
        provider = "instagram";
        this.data = data;
    }

    public InstagramConnection(JSONObject jsonobject)
    {
        provider = "instagram";
        setData(jsonobject);
    }

    public String getProfileImgUrl()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.profileImgUrl;
        }
    }

    public String getTokenSecret()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.tokenSecret;
        }
    }

    public String getUserName()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.name;
        }
    }

    public String getUserScreenName()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.screenName;
        }
    }

    public void setData(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        data = new UserConnection.Data(this, jsonobject);
        return;
        jsonobject;
        jsonobject.printStackTrace();
        return;
    }

    public void setProfileImgUrl(String s)
    {
        if (data == null)
        {
            data = new UserConnection.Data(this);
        }
        data.profileImgUrl = s;
    }

    public void setToken(String s)
    {
        if (data == null)
        {
            data = new UserConnection.Data(this);
        }
        data.token = s;
    }

    public void setTokenSecret(String s)
    {
        if (data == null)
        {
            data = new UserConnection.Data(this);
        }
        data.tokenSecret = s;
    }

    public void setUserName(String s)
    {
        if (data == null)
        {
            data = new UserConnection.Data(this);
        }
        data.name = s;
    }

    public void setUserScreenName(String s)
    {
        if (data == null)
        {
            data = new UserConnection.Data(this);
        }
        data.screenName = s;
    }
}

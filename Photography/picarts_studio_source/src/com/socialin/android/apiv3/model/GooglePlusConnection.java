// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.model:
//            UserConnection

public class GooglePlusConnection extends UserConnection
{

    public GooglePlusConnection()
    {
        provider = "google";
    }

    public GooglePlusConnection(UserConnection.Data data)
    {
        provider = "google";
        this.data = data;
    }

    public GooglePlusConnection(JSONObject jsonobject)
    {
        provider = "google";
        setData(jsonobject);
    }

    public String getGooglePlusEmail()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.email;
        }
    }

    public String getGooglePlusProfileImgUrl()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.profileImgUrl;
        }
    }

    public String getGooglePlusProfileUrl()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.profileUrl;
        }
    }

    public String getGooglePlusToken()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.token;
        }
    }

    public String getGooglePlusUserName()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.name;
        }
    }

    public String getGooglePlusUserScreenName()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.screenName;
        }
    }

    public boolean isEmpty()
    {
        return equals(new GooglePlusConnection());
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

    public void setGooglePlusEmail(String s)
    {
        if (data == null)
        {
            data = new UserConnection.Data(this);
        }
        data.email = s;
    }

    public void setGooglePlusProfileImgUrl(String s)
    {
        if (data == null)
        {
            data = new UserConnection.Data(this);
        }
        data.profileImgUrl = s;
    }

    public void setGooglePlusProfileUrl(String s)
    {
        if (data == null)
        {
            data = new UserConnection.Data(this);
        }
        data.profileUrl = s;
    }

    public void setGooglePlusToken(String s)
    {
        if (data == null)
        {
            data = new UserConnection.Data(this);
        }
        data.token = s;
    }

    public void setGooglePlusUserName(String s)
    {
        if (data == null)
        {
            data = new UserConnection.Data(this);
        }
        data.name = s;
    }

    public void setGooglePlusUserScreenName(String s)
    {
        if (data == null)
        {
            data = new UserConnection.Data(this);
        }
        data.screenName = s;
    }
}

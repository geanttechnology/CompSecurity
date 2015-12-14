// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.model:
//            UserConnection

public class FbConnection extends UserConnection
{

    public FbConnection()
    {
        provider = "facebook";
    }

    public FbConnection(UserConnection.Data data)
    {
        provider = "facebook";
        this.data = data;
    }

    public FbConnection(JSONObject jsonobject)
    {
        provider = "facebook";
        setData(jsonobject);
    }

    public String getFbEmail()
    {
        if (data == null)
        {
            return "";
        } else
        {
            return data.email;
        }
    }

    public String getFbName()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.screenName;
        }
    }

    public String getFbToken()
    {
        if (data != null)
        {
            return data.token;
        } else
        {
            return "";
        }
    }

    public String getFbUrl()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.profileUrl;
        }
    }

    public String getId()
    {
        if (data != null)
        {
            return data.id;
        } else
        {
            return "";
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

    public void setFbToken(String s)
    {
        if (data == null)
        {
            data = new UserConnection.Data(this);
        }
        data.token = s;
    }
}

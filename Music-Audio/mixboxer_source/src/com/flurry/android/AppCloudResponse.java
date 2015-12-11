// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            AppCloudObject, AppCloudUser

public class AppCloudResponse
{

    private AppCloudObject bW;
    AppCloudUser bX;
    JSONObject bY;

    public AppCloudResponse(JSONObject jsonobject)
    {
        bY = jsonobject;
    }

    public int getHTTPResponseCode()
    {
label0:
        {
            int i;
            try
            {
                if (bY == null)
                {
                    break label0;
                }
                i = bY.getInt("code");
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
                return 0;
            }
            return i;
        }
        return 400;
    }

    public AppCloudObject getObject()
    {
        return bW;
    }

    public JSONObject getResponse()
    {
        return bY;
    }

    public String getResponseMessage()
    {
        String s;
        if (bY == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        s = bY.get("note").toString();
        return s;
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        return "";
    }

    public AppCloudUser getUser()
    {
        return bX;
    }

    public boolean isSuccessful()
    {
label0:
        {
label1:
            {
                boolean flag1 = false;
                boolean flag = flag1;
                int i;
                try
                {
                    if (bY == null)
                    {
                        break label0;
                    }
                    if (bY.getInt("code") == 200)
                    {
                        break label1;
                    }
                    i = bY.getInt("code");
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                    return false;
                }
                flag = flag1;
                if (i != 201)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public void setObject(AppCloudObject appcloudobject)
    {
        bW = appcloudobject;
    }

    public void setUser(AppCloudUser appclouduser)
    {
        bX = appclouduser;
    }
}

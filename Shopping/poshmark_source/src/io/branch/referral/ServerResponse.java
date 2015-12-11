// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            BranchLinkData

class ServerResponse
{

    private BranchLinkData linkData_;
    private Object post_;
    private int statusCode_;
    private String tag_;

    public ServerResponse(String s, int i)
    {
        this(s, i, null);
    }

    public ServerResponse(String s, int i, BranchLinkData branchlinkdata)
    {
        tag_ = s;
        statusCode_ = i;
        linkData_ = branchlinkdata;
    }

    public JSONArray getArray()
    {
        if (post_ instanceof JSONArray)
        {
            return (JSONArray)post_;
        } else
        {
            return null;
        }
    }

    public String getFailReason()
    {
        String s2 = "";
        String s1 = s2;
        String s;
        JSONObject jsonobject;
        try
        {
            jsonobject = getObject();
        }
        catch (Exception exception)
        {
            return s1;
        }
        s = s2;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s = s2;
        s1 = s2;
        if (!jsonobject.has("error"))
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s = s2;
        s1 = s2;
        if (!jsonobject.getJSONObject("error").has("message"))
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s1 = s2;
        s2 = jsonobject.getJSONObject("error").getString("message");
        s = s2;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s = s2;
        s1 = s2;
        if (s2.trim().length() <= 0)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s1 = s2;
        s = (new StringBuilder()).append(s2).append(".").toString();
        return s;
    }

    public BranchLinkData getLinkData()
    {
        return linkData_;
    }

    public JSONObject getObject()
    {
        if (post_ instanceof JSONObject)
        {
            return (JSONObject)post_;
        } else
        {
            return null;
        }
    }

    public int getStatusCode()
    {
        return statusCode_;
    }

    public String getTag()
    {
        return tag_;
    }

    public void setPost(Object obj)
    {
        post_ = obj;
    }
}

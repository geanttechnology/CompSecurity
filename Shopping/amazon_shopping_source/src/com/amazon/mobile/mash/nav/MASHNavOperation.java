// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import android.util.Log;
import com.amazon.mobile.mash.util.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class MASHNavOperation
{
    public static class MASHNavRequest
    {

        private String mMethod;
        private JSONObject mParams;
        private String mUrl;

        public String getMethod()
        {
            return mMethod;
        }

        public JSONObject getParams()
        {
            return mParams;
        }

        public String getUrl()
        {
            return mUrl;
        }

        public void setMethod(String s)
        {
            mMethod = s;
        }

        public void setParams(JSONObject jsonobject)
        {
            mParams = jsonobject;
        }

        public void setUrl(String s)
        {
            mUrl = s;
        }

        public MASHNavRequest()
        {
        }
    }


    private int mBackAmount;
    private String mBookmark;
    private String mOperation;
    private MASHNavRequest mRequest;

    public MASHNavOperation()
    {
    }

    public int getBackAmount()
    {
        return mBackAmount;
    }

    public String getBookmark()
    {
        return mBookmark;
    }

    public String getOperation()
    {
        return mOperation;
    }

    public MASHNavRequest getRequest()
    {
        return mRequest;
    }

    public void setBackAmount(int i)
    {
        mBackAmount = i;
    }

    public void setBookmark(String s)
    {
        mBookmark = s;
    }

    public void setOperation(String s)
    {
        mOperation = s;
    }

    public void setRequest(MASHNavRequest mashnavrequest)
    {
        mRequest = mashnavrequest;
    }

    public String toJSONString()
    {
        JSONObject jsonobject = new JSONObject();
        JSONObject jsonobject1;
        jsonobject.put("op", mOperation);
        if (!Util.isEmpty(mBookmark))
        {
            jsonobject.put("bookmark", mBookmark);
        }
        if (mBackAmount > 0)
        {
            jsonobject.put("backAmount", mBackAmount);
        }
        if (mRequest == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        jsonobject.put("url", mRequest.getUrl());
        if (!Util.isEmpty(mRequest.getMethod()))
        {
            jsonobject.put("method", mRequest.getMethod());
        }
        jsonobject1 = mRequest.getParams();
        if (jsonobject1 != null)
        {
            try
            {
                jsonobject.put("parameters", jsonobject1);
            }
            catch (JSONException jsonexception)
            {
                Log.e("MASHNavOperation", (new StringBuilder()).append("Created a bad JSON object. Error : ").append(jsonexception.getMessage()).toString());
            }
        }
        return jsonobject.toString();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.request;

import org.json.JSONObject;

// Referenced classes of package com.arellomobile.android.push.request:
//            RequestManager

public static class mResultData
{

    private int mPushwooshCode;
    private int mResultCode;
    private JSONObject mResultData;

    public int getPushwooshCode()
    {
        return mPushwooshCode;
    }

    public int getResultCode()
    {
        return mResultCode;
    }

    public JSONObject getResultData()
    {
        return mResultData;
    }

    public void setCode(int i)
    {
        mResultCode = i;
    }

    public void setData(JSONObject jsonobject)
    {
        mResultData = jsonobject;
    }

    public void setPushwooshCode(int i)
    {
        mPushwooshCode = i;
    }

    public (int i, int j, JSONObject jsonobject)
    {
        mResultCode = i;
        mPushwooshCode = j;
        mResultData = jsonobject;
    }
}

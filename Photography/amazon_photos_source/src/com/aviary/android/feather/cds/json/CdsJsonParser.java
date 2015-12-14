// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds.json;

import com.aviary.android.feather.common.utils.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class CdsJsonParser
{

    public static final int CODE_INVALID = -1;
    public static final int CODE_NOERROR = 0;
    protected int mCode;
    protected String mStatus;

    public CdsJsonParser()
    {
    }

    public final int getCode()
    {
        return mCode;
    }

    public final String getStatus()
    {
        return mStatus;
    }

    protected abstract void onParseJson(JSONObject jsonobject)
        throws JSONException;

    public int parse(InputStream inputstream)
        throws IOException, JSONException
    {
        return parse(IOUtils.readFully(inputstream));
    }

    public int parse(String s)
        throws JSONException
    {
        return parse(new JSONObject(s));
    }

    public int parse(JSONObject jsonobject)
        throws JSONException
    {
        mCode = jsonobject.optInt("code", -1);
        mStatus = jsonobject.optString("status", "none");
        if (mCode == 0)
        {
            onParseJson(jsonobject);
        }
        return mCode;
    }
}

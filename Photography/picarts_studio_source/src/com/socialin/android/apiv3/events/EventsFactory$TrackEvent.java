// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import android.text.TextUtils;
import com.socialin.android.constants.EventParam;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class id
{

    protected final String id;
    protected final JSONObject jsonParams = new JSONObject();
    protected final HashMap params = new HashMap();

    protected void addParam(EventParam eventparam, Object obj)
    {
        if (TextUtils.isEmpty(eventparam.getName()) || obj == null || TextUtils.isEmpty(obj.toString()))
        {
            break MISSING_BLOCK_LABEL_53;
        }
        params.put(eventparam.getName(), obj.toString());
        jsonParams.put(eventparam.getName(), obj);
        return;
        eventparam;
        eventparam.printStackTrace();
        return;
    }

    protected void addParam(EventParam eventparam, String s)
    {
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(eventparam.getName()))
        {
            break MISSING_BLOCK_LABEL_43;
        }
        params.put(eventparam.getName(), s);
        jsonParams.put(eventparam.getName(), s);
        return;
        eventparam;
        eventparam.printStackTrace();
        return;
    }

    protected void addParam(String s, Object obj)
    {
        if (TextUtils.isEmpty(s) || obj == null || TextUtils.isEmpty(obj.toString()))
        {
            break MISSING_BLOCK_LABEL_44;
        }
        params.put(s, obj.toString());
        jsonParams.put(s, obj);
        return;
        s;
        s.printStackTrace();
        return;
    }

    public String getId()
    {
        return id;
    }

    public String getJsonParams()
    {
        if (jsonParams == null)
        {
            return "";
        } else
        {
            return jsonParams.toString();
        }
    }

    public HashMap getParams()
    {
        return params;
    }

    protected (String s)
    {
        if (s != null)
        {
            s = s.toLowerCase();
        } else
        {
            s = null;
        }
        id = s;
    }
}

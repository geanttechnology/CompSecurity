// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.android.pdk;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

public class PDKException extends Exception
{

    static final long serialVersionUID = 1L;
    protected String _baseUrl;
    private String _detailMessage;
    protected String _method;
    private int _stausCode;

    public PDKException()
    {
        _stausCode = -1;
        _detailMessage = "";
    }

    public PDKException(VolleyError volleyerror)
    {
        String s;
        _stausCode = -1;
        _detailMessage = "";
        String s1 = "";
        s = s1;
        if (volleyerror != null)
        {
            s = s1;
            if (volleyerror.networkResponse != null)
            {
                s = s1;
                if (volleyerror.networkResponse.data != null)
                {
                    s = new String(volleyerror.networkResponse.data);
                    _detailMessage = s;
                }
            }
        }
        if (s.length() <= 0 || !s.startsWith("{"))
        {
            break MISSING_BLOCK_LABEL_124;
        }
        volleyerror = JSONObjectInstrumentation.init(s);
        if (volleyerror.has("status"))
        {
            _stausCode = volleyerror.getInt("status");
        }
        if (volleyerror.has("messsage"))
        {
            _detailMessage = volleyerror.getString("message");
        }
        return;
        volleyerror;
        volleyerror.printStackTrace();
        return;
    }

    public PDKException(String s)
    {
        super(s);
        _stausCode = -1;
        _detailMessage = "";
        _detailMessage = s;
    }

    public PDKException(String s, Throwable throwable)
    {
        super(s, throwable);
        _stausCode = -1;
        _detailMessage = "";
    }

    public String getDetailMessage()
    {
        return _detailMessage;
    }

    public int getStausCode()
    {
        return _stausCode;
    }

    public void setDetailMessage(String s)
    {
        _detailMessage = s;
    }

    public void setStausCode(int i)
    {
        _stausCode = i;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.Message;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler

public class JsonHttpResponseHandler extends AsyncHttpResponseHandler
{

    protected static final int SUCCESS_JSON_MESSAGE = 100;

    public JsonHttpResponseHandler()
    {
    }

    protected void handleFailureMessage(Throwable throwable, String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        Object obj;
        try
        {
            obj = parseResponse(s);
            if (obj instanceof JSONObject)
            {
                onFailure(throwable, (JSONObject)obj);
                return;
            }
        }
        catch (JSONException jsonexception)
        {
            onFailure(throwable, s);
            return;
        }
        if (obj instanceof JSONArray)
        {
            onFailure(throwable, (JSONArray)obj);
            return;
        }
        onFailure(throwable, s);
        return;
        onFailure(throwable, "");
        return;
    }

    protected void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            super.handleMessage(message);
            return;

        case 100: // 'd'
            message = ((Message) ((Object[])(Object[])message.obj));
            break;
        }
        handleSuccessJsonMessage(((Integer)message[0]).intValue(), message[1]);
    }

    protected void handleSuccessJsonMessage(int i, Object obj)
    {
        if (obj instanceof JSONObject)
        {
            onSuccess(i, (JSONObject)obj);
            return;
        }
        if (obj instanceof JSONArray)
        {
            onSuccess(i, (JSONArray)obj);
            return;
        } else
        {
            onFailure(new JSONException((new StringBuilder()).append("Unexpected type ").append(obj.getClass().getName()).toString()), (JSONObject)null);
            return;
        }
    }

    public void onFailure(Throwable throwable, JSONArray jsonarray)
    {
    }

    public void onFailure(Throwable throwable, JSONObject jsonobject)
    {
    }

    public void onSuccess(int i, JSONArray jsonarray)
    {
        onSuccess(jsonarray);
    }

    public void onSuccess(int i, JSONObject jsonobject)
    {
        onSuccess(jsonobject);
    }

    public void onSuccess(JSONArray jsonarray)
    {
    }

    public void onSuccess(JSONObject jsonobject)
    {
    }

    protected Object parseResponse(String s)
        throws JSONException
    {
        String s1;
label0:
        {
            Object obj = null;
            s1 = s.trim();
            if (!s1.startsWith("{"))
            {
                s = obj;
                if (!s1.startsWith("["))
                {
                    break label0;
                }
            }
            s = ((String) ((new JSONTokener(s1)).nextValue()));
        }
        if (s == null)
        {
            return s1;
        } else
        {
            return s;
        }
    }

    protected void sendSuccessMessage(int i, String s)
    {
        if (i != 204)
        {
            try
            {
                sendMessage(obtainMessage(100, ((Object) (new Object[] {
                    Integer.valueOf(i), parseResponse(s)
                }))));
                return;
            }
            catch (JSONException jsonexception)
            {
                sendFailureMessage(jsonexception, s);
            }
            return;
        } else
        {
            sendMessage(obtainMessage(100, ((Object) (new Object[] {
                Integer.valueOf(i), new JSONObject()
            }))));
            return;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            WebRequest, Log

public class logTag
{

    private String body;
    private String httpStatus;
    private int httpStatusCode;
    private InputStream inputStream;
    private boolean logEnabled;
    private String logTag;
    final WebRequest this$0;

    protected void enableLog(boolean flag)
    {
        logEnabled = flag;
    }

    public String getBody()
    {
        if (body == null)
        {
            readResponseString();
        }
        return body;
    }

    public String getHttpStatus()
    {
        return httpStatus;
    }

    public int getHttpStatusCode()
    {
        return httpStatusCode;
    }

    public JSONObject getJSONObjectBody()
    {
        if (getBody() == null)
        {
            return null;
        }
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject(getBody());
        }
        catch (JSONException jsonexception)
        {
            Log.e(getLogTag(), "Unable to parse the body into a JSONObject.");
            return null;
        }
        return jsonobject;
    }

    public boolean isHttpStatusCodeOK()
    {
        return getHttpStatusCode() == 200;
    }

    protected void readResponseString()
    {
        if (inputStream == null) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder;
        byte abyte0[];
        stringbuilder = new StringBuilder();
        abyte0 = new byte[4096];
_L5:
        int i = inputStream.read(abyte0);
        if (i == -1) goto _L4; else goto _L3
_L3:
        stringbuilder.append(new String(abyte0, 0, i));
          goto _L5
        Object obj;
        obj;
        Log.e(logTag, "Unable to read the stream from the network.");
        try
        {
            inputStream.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(logTag, "IOException while trying to close the stream");
        }
        setBody(stringbuilder.toString());
        if (logEnabled)
        {
            Log.d(WebRequest.access$000(), "Response: %s", new Object[] {
                getBody()
            });
        }
_L2:
        return;
_L4:
        try
        {
            inputStream.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(logTag, "IOException while trying to close the stream");
        }
        setBody(stringbuilder.toString());
        if (!logEnabled) goto _L2; else goto _L6
_L6:
        Log.d(WebRequest.access$000(), "Response: %s", new Object[] {
            getBody()
        });
        return;
        obj;
        try
        {
            inputStream.close();
        }
        catch (IOException ioexception)
        {
            Log.e(logTag, "IOException while trying to close the stream");
        }
        setBody(stringbuilder.toString());
        if (logEnabled)
        {
            Log.d(WebRequest.access$000(), "Response: %s", new Object[] {
                getBody()
            });
        }
        throw obj;
    }

    protected void setBody(String s)
    {
        body = s;
    }

    protected void setHttpStatus(String s)
    {
        httpStatus = s;
    }

    protected void setHttpStatusCode(int i)
    {
        httpStatusCode = i;
    }

    protected void setInputStream(InputStream inputstream)
    {
        inputStream = inputstream;
    }

    protected void setLogTag(String s)
    {
        logTag = s;
    }

    protected ()
    {
        this$0 = WebRequest.this;
        super();
        logTag = WebRequest.access$000();
    }
}

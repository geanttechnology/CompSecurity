// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.log.appenders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.analytics.log.appenders:
//            AvailabilityAppender

static class timestamp
{

    private Throwable exception;
    private com.amazon.device.analytics.log.ogMessage.exception level;
    private String message;
    private Long timestamp;

    private String getThrowableAsString(Throwable throwable)
    {
        PrintStream printstream;
        String s;
        Object obj1;
        Object obj2;
        Object obj3;
        s = "";
        obj1 = null;
        obj2 = null;
        obj3 = null;
        printstream = null;
        Object obj = new ByteArrayOutputStream();
        printstream = new PrintStream(((java.io.OutputStream) (obj)));
        throwable.printStackTrace(printstream);
        printstream.close();
        throwable = ((ByteArrayOutputStream) (obj)).toString("UTF-8");
        if (printstream != null)
        {
            printstream.close();
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        try
        {
            ((ByteArrayOutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return throwable;
        }
        obj = throwable;
_L2:
        return ((String) (obj));
        throwable;
        obj = obj2;
        throwable = printstream;
_L5:
        if (obj != null)
        {
            ((PrintStream) (obj)).close();
        }
        obj = s;
        if (throwable == null) goto _L2; else goto _L1
_L1:
        try
        {
            throwable.close();
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            return "";
        }
        return "";
        obj;
        printstream = obj1;
        throwable = obj3;
_L4:
        if (printstream != null)
        {
            printstream.close();
        }
        if (throwable != null)
        {
            try
            {
                throwable.close();
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable) { }
        }
        throw obj;
        Exception exception1;
        exception1;
        throwable = ((Throwable) (obj));
        printstream = obj1;
        obj = exception1;
        continue; /* Loop/switch isn't completed */
        exception1;
        throwable = ((Throwable) (obj));
        obj = exception1;
        if (true) goto _L4; else goto _L3
_L3:
        throwable;
        throwable = ((Throwable) (obj));
        obj = obj2;
          goto _L5
        throwable;
        throwable = ((Throwable) (obj));
        obj = printstream;
          goto _L5
        return throwable;
    }

    public JSONObject toJSON()
    {
        JSONObject jsonobject = new JSONObject();
        if (level != null)
        {
            try
            {
                jsonobject.put("logLevel", level.level());
            }
            catch (JSONException jsonexception3) { }
        }
        try
        {
            jsonobject.put("timestamp", timestamp);
        }
        catch (JSONException jsonexception2) { }
        if (message != null)
        {
            try
            {
                jsonobject.put("message", message);
            }
            catch (JSONException jsonexception1) { }
        }
        if (exception != null)
        {
            try
            {
                jsonobject.put("exception", getThrowableAsString(exception));
            }
            catch (JSONException jsonexception)
            {
                return jsonobject;
            }
        }
        return jsonobject;
    }

    public (com.amazon.device.analytics.log.ogMessage ogmessage, String s, Throwable throwable)
    {
        message = null;
        exception = null;
        timestamp = null;
        level = null;
        level = ogmessage;
        message = s;
        exception = throwable;
        timestamp = Long.valueOf(System.currentTimeMillis());
    }
}

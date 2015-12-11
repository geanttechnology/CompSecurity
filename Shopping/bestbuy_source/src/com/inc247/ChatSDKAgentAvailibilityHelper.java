// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.os.AsyncTask;
import com.inc247.bridge.ChatSDKNativeToJSBridge;
import com.inc247.errors.ChatSDKError;
import com.inc247.errors.ChatSDKErrorCodes;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.UnknownHostException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import p;

// Referenced classes of package com.inc247:
//            ChatSDKEventsCallback, ChatSDKUtil

class ChatSDKAgentAvailibilityHelper extends AsyncTask
{

    ChatSDKAgentAvailibilityHelper()
    {
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        as = as[0];
        try
        {
            as = p.a(new DefaultHttpClient(), new HttpGet(as));
            if (as.getStatusLine().getStatusCode() == 200)
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                as.getEntity().writeTo(bytearrayoutputstream);
                bytearrayoutputstream.close();
                return bytearrayoutputstream.toString();
            }
            as.getEntity().getContent().close();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            ChatSDKEventsCallback.getInstance().sendonChatErrorEvent(new ChatSDKError(ChatSDKErrorCodes.ChatSDKNetworkError));
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            ChatSDKEventsCallback.getInstance().sendonChatErrorEvent(new ChatSDKError(ChatSDKErrorCodes.ChatSDKUnknownError));
            return null;
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        ChatSDKEventsCallback chatsdkeventscallback;
        try
        {
            s = new JSONObject(s);
            chatsdkeventscallback = ChatSDKEventsCallback.getInstance();
            if (s.getJSONObject("data").getString("caStatus").equalsIgnoreCase("true"))
            {
                chatsdkeventscallback.sendonChatAgentAvailabilityEvent(true);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ChatSDKEventsCallback.getInstance().sendonChatErrorEvent(new ChatSDKError(ChatSDKErrorCodes.ChatSDKUnknownError));
            ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(s).append("'}").toString()));
            return;
        }
        if (s.getJSONObject("data").getString("caStatus").equalsIgnoreCase("false"))
        {
            chatsdkeventscallback.sendonChatAgentAvailabilityEvent(false);
            return;
        }
        chatsdkeventscallback.sendonChatErrorEvent(new ChatSDKError(ChatSDKErrorCodes.ChatSDKUnknownError));
        return;
    }
}

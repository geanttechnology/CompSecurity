// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247.bridge;

import android.os.Handler;
import android.os.Looper;
import com.inc247.ChatSDK;
import com.inc247.ChatSDKEventsCallback;
import com.inc247.ChatSDKResources;
import com.inc247.ChatSDKUtil;
import java.lang.reflect.Method;
import org.json.JSONObject;

// Referenced classes of package com.inc247.bridge:
//            ChatSDKNativeToJSBridge

public final class ChatSDKJSToNativeBridge
{

    public ChatSDKJSToNativeBridge()
    {
    }

    public static void getLocation(JSONObject jsonobject)
    {
        Object obj = "";
        jsonobject = jsonobject.getString("id");
        obj = jsonobject;
        if (ChatSDKNativeToJSBridge.data != null)
        {
            obj = jsonobject;
            try
            {
                ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(jsonobject, "true", "true", ChatSDKNativeToJSBridge.data));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(((String) (obj)), "false", "true", (new StringBuilder("{'Error':'")).append(jsonobject).append("'}").toString()));
            }
            break MISSING_BLOCK_LABEL_84;
        }
        obj = jsonobject;
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(jsonobject, "false", "true", "{'Oops!!':'Current Location Not Found!!Check GPS'}"));
        return;
    }

    public void chatStarted(JSONObject jsonobject)
    {
        String s = "";
        String s1 = jsonobject.getString("id");
        s = s1;
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(s1, "true", "true", "{}"));
        s = s1;
        try
        {
            ChatSDKEventsCallback.getInstance().sendOnChatStartedEvent(jsonobject.getJSONObject("data"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(s, "false", "true", (new StringBuilder("{'Error':'")).append(jsonobject).append("'}").toString()));
        return;
    }

    public void endChat(JSONObject jsonobject)
    {
        try
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable() {

                final ChatSDKJSToNativeBridge this$0;

                public void run()
                {
                    ChatSDK.getSDKInstance().endChat();
                }

            
            {
                this$0 = ChatSDKJSToNativeBridge.this;
                super();
            }
            });
            ChatSDKEventsCallback.getInstance().sendonChatEndedEvent(new JSONObject());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(jsonobject).append("'}").toString()));
    }

    public void exec(String s, String s1)
    {
        String s2;
        String s3;
        s3 = "";
        s2 = s3;
        JSONObject jsonobject = new JSONObject(s1);
        s2 = s3;
        s1 = jsonobject.getString("id");
        s2 = s1;
        if (jsonobject.length() > 0)
        {
            s2 = s1;
            try
            {
                com/inc247/bridge/ChatSDKJSToNativeBridge.getDeclaredMethod(s, new Class[] {
                    org/json/JSONObject
                }).invoke(this, new Object[] {
                    jsonobject
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_97;
        }
        s2 = s1;
        com/inc247/bridge/ChatSDKJSToNativeBridge.getDeclaredMethod(s, new Class[0]).invoke(this, new Object[0]);
        return;
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(s2, "false", "true", (new StringBuilder("{'Error':'")).append(s).append("'}").toString()));
        return;
    }

    public void getContext(JSONObject jsonobject)
    {
        Object obj = "";
        jsonobject = jsonobject.getString("id");
        obj = jsonobject;
        if (ChatSDK.getSDKInstance().contextInfo != null)
        {
            obj = jsonobject;
            try
            {
                ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(jsonobject, "true", "true", ChatSDK.getSDKInstance().contextInfo));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_62;
        }
        obj = jsonobject;
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(jsonobject, "false", "true", "{'Error':'Chat has not been started yet'}"));
        return;
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(((String) (obj)), "false", "true", (new StringBuilder("{'Error':'")).append(jsonobject).append("'}").toString()));
        return;
    }

    public void getQueueId(JSONObject jsonobject)
    {
        Object obj = "";
        jsonobject = jsonobject.getString("id");
        obj = jsonobject;
        if (ChatSDK.getSDKInstance().queueIdFromAppDeveloper != null)
        {
            obj = jsonobject;
            try
            {
                ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(jsonobject, "true", "true", ChatSDK.getSDKInstance().queueIdFromAppDeveloper));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_62;
        }
        obj = jsonobject;
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(jsonobject, "false", "true", "{'Error':'Chat has not been started yet'}"));
        return;
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(((String) (obj)), "false", "true", (new StringBuilder("{'Error':'")).append(jsonobject).append("'}").toString()));
        return;
    }

    public void minimizeChat(JSONObject jsonobject)
    {
        Object obj = "";
        jsonobject = jsonobject.getString("id");
        obj = jsonobject;
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final ChatSDKJSToNativeBridge this$0;

            public void run()
            {
                ChatSDK.getSDKInstance().minimizeChat();
            }

            
            {
                this$0 = ChatSDKJSToNativeBridge.this;
                super();
            }
        });
        obj = jsonobject;
        if (ChatSDKResources.CUSTOM_MINIMIZE_STATE.equalsIgnoreCase("false"))
        {
            obj = jsonobject;
            try
            {
                ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(jsonobject, "true", "true", "{}"));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_84;
        }
        obj = jsonobject;
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(jsonobject, "true", "false", "{}"));
        return;
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(((String) (obj)), "false", "true", (new StringBuilder("{'Error':'")).append(jsonobject).append("'}").toString()));
        return;
    }

    public void onAgentMessage(JSONObject jsonobject)
    {
        String s = "";
        String s1 = jsonobject.getString("id");
        s = s1;
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final ChatSDKJSToNativeBridge this$0;

            public void run()
            {
                ChatSDK.getSDKInstance().incrementBadge();
            }

            
            {
                this$0 = ChatSDKJSToNativeBridge.this;
                super();
            }
        });
        s = s1;
        try
        {
            ChatSDKEventsCallback.getInstance().sendonAgentMessageEvent(jsonobject.getJSONObject("data"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString(s, "false", "true", (new StringBuilder("{'Error':'")).append(jsonobject).append("'}").toString()));
        return;
    }
}

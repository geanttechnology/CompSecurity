// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.internal;

import com.boldchat.visitor.api.json.JSONArray;
import com.boldchat.visitor.api.json.JSONObject;
import java.io.PrintStream;
import java.util.HashMap;

// Referenced classes of package com.boldchat.visitor.api.internal:
//            ResultListener, VisitorMessageListener

public abstract class VisitorMessageProcessor
{

    private String lastMessageID;
    private VisitorMessageListener listener;
    private final boolean respondToHeartbeats;
    private HashMap resultListeners;

    public VisitorMessageProcessor(VisitorMessageListener visitormessagelistener, boolean flag)
    {
        resultListeners = new HashMap();
        listener = visitormessagelistener;
        respondToHeartbeats = flag;
    }

    public void addResultListener(String s, ResultListener resultlistener)
    {
        resultListeners.put(s, resultlistener);
    }

    public abstract boolean close();

    public String getLastMessageID()
    {
        return lastMessageID;
    }

    public VisitorMessageListener getVisitorMessageListener()
    {
        return listener;
    }

    public void processMessage(JSONObject jsonobject)
    {
        Object obj;
        String s1;
        s1 = jsonobject.optString("method", null);
        obj = jsonobject.optString("result", null);
        if (obj == null || ((String) (obj)).length() <= 0) goto _L2; else goto _L1
_L1:
        obj = (ResultListener)resultListeners.get(jsonobject.optString("id"));
        if (obj == null) goto _L4; else goto _L3
_L3:
        JSONObject jsonobject1 = jsonobject.optJSONObject("result");
        if (!"success".equals(jsonobject1.getString("Status"))) goto _L6; else goto _L5
_L5:
        ((ResultListener) (obj)).success(jsonobject.optJSONObject("result"));
_L4:
        return;
_L6:
        ((ResultListener) (obj)).failure(jsonobject1.optInt("Code", -1), jsonobject1.optString("Message"), jsonobject1);
        return;
_L2:
        if (s1 != null)
        {
            Object obj1 = jsonobject.optString("id");
            if (obj1 != null && ((String) (obj1)).length() > 0 && !"0".equals(obj1))
            {
                lastMessageID = ((String) (obj1));
            }
            JSONArray jsonarray = jsonobject.optJSONArray("params");
            Object obj2 = null;
            obj1 = obj2;
            if (jsonarray != null)
            {
                obj1 = obj2;
                if (jsonarray.length() > 0)
                {
                    obj1 = jsonarray.getJSONObject(0);
                }
            }
            if ("redirect".equals(s1) && obj1 != null)
            {
                setCloseExpected(true);
                jsonobject = ((JSONObject) (obj1)).optString("WebSocketURL");
                obj1 = ((JSONObject) (obj1)).optString("LongPOllURL");
                VisitorMessageListener visitormessagelistener = listener;
                if (jsonobject == null)
                {
                    jsonobject = ((JSONObject) (obj1));
                }
                visitormessagelistener.redirect(jsonobject, this);
                return;
            }
            if ("heartbeat".equals(s1))
            {
                if (respondToHeartbeats)
                {
                    obj1 = new JSONObject();
                    JSONObject jsonobject2 = new JSONObject();
                    jsonobject2.put("Response", "ack");
                    ((JSONObject) (obj1)).put("result", jsonobject2);
                    ((JSONObject) (obj1)).put("error", (String)null);
                    ((JSONObject) (obj1)).put("id", jsonobject.optString("id", null));
                    sendMessage(((JSONObject) (obj1)).toString());
                }
                listener.heartbeat();
                return;
            }
            if ("reconnect".equals(s1))
            {
                reconnect();
                return;
            }
            if ("reset".equals(s1))
            {
                setCloseExpected(true);
                listener.reset(this);
                return;
            }
            if ("updateChat".equals(s1) && obj1 != null)
            {
                long l = ((JSONObject) (obj1)).optLong("ChatID");
                listener.updateChat(l, ((JSONObject) (obj1)).optJSONObject("Values"));
                return;
            }
            if ("updateTyper".equals(s1) && obj1 != null)
            {
                long l1 = ((JSONObject) (obj1)).optLong("PersonID");
                listener.updateTyper(l1, ((JSONObject) (obj1)).optJSONObject("Values"));
                return;
            }
            if ("addMessage".equals(s1) && obj1 != null)
            {
                long l2 = ((JSONObject) (obj1)).optLong("MessageID");
                listener.addMessage(l2, ((JSONObject) (obj1)).optJSONObject("Values"));
                return;
            }
            if ("updateBusy".equals(s1) && obj1 != null)
            {
                listener.updateBusy(((JSONObject) (obj1)));
                return;
            }
            if ("closed".equals(s1))
            {
                setCloseExpected(true);
                listener.chatClosed(this);
                return;
            }
            if ("beginActiveAssist".equals(s1))
            {
                listener.beginActiveAssist(((JSONObject) (obj1)));
                return;
            }
            if ("updateActiveAssist".equals(s1))
            {
                long l3 = ((JSONObject) (obj1)).optLong("ActiveAssistID");
                listener.updateActiveAssist(l3, ((JSONObject) (obj1)).optJSONObject("Values"));
                return;
            }
            if ("autoMessage".equals(s1))
            {
                listener.autoMessage(((JSONObject) (obj1)).optString("Text", ""));
                return;
            }
        } else
        {
            ResultListener resultlistener = (ResultListener)resultListeners.get(jsonobject.optString("id"));
            String s = jsonobject.optString("error", null);
            if (resultlistener != null && s != null && s.length() > 0)
            {
                resultlistener.failure(-1, s, jsonobject);
                return;
            } else
            {
                System.err.println((new StringBuilder()).append("Unable to process message: ").append(jsonobject.toString(3)).toString());
                return;
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public abstract boolean reconnect();

    public abstract boolean sendMessage(String s);

    public abstract void setCloseExpected(boolean flag);
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import com.exacttarget.etpushsdk.util.m;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.exacttarget.etpushsdk.event:
//            IEventFactory

public class AnalyticPiItemEvent
    implements IEventFactory
{

    public static final String JF_SESSION_ID = "session_id";
    public static final String JF_USER_ID = "user_id";
    private static final String TAG = "~!AnalyticPiItemEvent";
    private static final long serialVersionUID = 1L;
    private List databaseIds;
    private String sessionId;
    private String userId;

    public AnalyticPiItemEvent()
    {
    }

    public AnalyticPiItemEvent fromJson(String s)
    {
        try
        {
            s = new JSONObject(s);
            setUserId(s.getString("user_id"));
            setSessionId(s.getString("session_id"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.c("~!AnalyticPiItemEvent", s.getMessage(), s);
            return null;
        }
        return this;
    }

    public volatile Object fromJson(String s)
    {
        return fromJson(s);
    }

    public List getDatabaseIds()
    {
        return databaseIds;
    }

    public String getSessionId()
    {
        return sessionId;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setDatabaseIds(AnalyticPiItemEvent analyticpiitemevent, List list)
    {
        analyticpiitemevent.setDatabaseIds(list);
    }

    public volatile void setDatabaseIds(Object obj, List list)
    {
        setDatabaseIds((AnalyticPiItemEvent)obj, list);
    }

    public void setDatabaseIds(List list)
    {
        databaseIds = list;
    }

    public void setSessionId(String s)
    {
        sessionId = s;
    }

    public void setUserId(String s)
    {
        userId = s;
    }
}

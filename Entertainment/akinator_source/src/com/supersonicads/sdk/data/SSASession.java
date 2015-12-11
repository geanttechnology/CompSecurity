// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;

import android.content.Context;
import com.supersonicads.sdk.utils.SDKUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class SSASession
{
    public static final class SessionType extends Enum
    {

        private static final SessionType $VALUES[];
        public static final SessionType backFromBG;
        public static final SessionType launched;

        public static SessionType valueOf(String s)
        {
            return (SessionType)Enum.valueOf(com/supersonicads/sdk/data/SSASession$SessionType, s);
        }

        public static SessionType[] values()
        {
            return (SessionType[])$VALUES.clone();
        }

        static 
        {
            launched = new SessionType("launched", 0);
            backFromBG = new SessionType("backFromBG", 1);
            $VALUES = (new SessionType[] {
                launched, backFromBG
            });
        }

        private SessionType(String s, int i)
        {
            super(s, i);
        }
    }


    public final String CONNECTIVITY;
    public final String SESSION_END_TIME;
    public final String SESSION_START_TIME;
    public final String SESSION_TYPE;
    private String connectivity;
    private long sessionEndTime;
    private long sessionStartTime;
    private SessionType sessionType;

    public SSASession(Context context, SessionType sessiontype)
    {
        SESSION_START_TIME = "sessionStartTime";
        SESSION_END_TIME = "sessionEndTime";
        SESSION_TYPE = "sessionType";
        CONNECTIVITY = "connectivity";
        setSessionStartTime(SDKUtils.getCurrentTimeMillis().longValue());
        setSessionType(sessiontype);
        setConnectivity(SDKUtils.getConnectionType(context));
    }

    public SSASession(JSONObject jsonobject)
    {
        SESSION_START_TIME = "sessionStartTime";
        SESSION_END_TIME = "sessionEndTime";
        SESSION_TYPE = "sessionType";
        CONNECTIVITY = "connectivity";
        try
        {
            jsonobject.get("sessionStartTime");
            jsonobject.get("sessionEndTime");
            jsonobject.get("sessionType");
            jsonobject.get("connectivity");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return;
        }
    }

    public void endSession()
    {
        setSessionEndTime(SDKUtils.getCurrentTimeMillis().longValue());
    }

    public String getConnectivity()
    {
        return connectivity;
    }

    public long getSessionEndTime()
    {
        return sessionEndTime;
    }

    public long getSessionStartTime()
    {
        return sessionStartTime;
    }

    public SessionType getSessionType()
    {
        return sessionType;
    }

    public void setConnectivity(String s)
    {
        connectivity = s;
    }

    public void setSessionEndTime(long l)
    {
        sessionEndTime = l;
    }

    public void setSessionStartTime(long l)
    {
        sessionStartTime = l;
    }

    public void setSessionType(SessionType sessiontype)
    {
        sessionType = sessiontype;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.session;

import com.amazon.insights.InsightsCredentials;
import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.idresolver.Id;
import com.amazon.insights.core.util.JSONBuilder;
import com.amazon.insights.core.util.JSONSerializable;
import com.amazon.insights.core.util.Preconditions;
import com.amazon.insights.core.util.StringUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class Session
    implements JSONSerializable
{

    private final String sessionID;
    private final DateFormat sessionIdTimeFormat;
    private final long startTime;
    private Long stopTime;

    protected Session(InsightsContext insightscontext)
    {
        stopTime = null;
        Preconditions.checkNotNull(insightscontext, "A valid InsightsContext must be provided!");
        sessionIdTimeFormat = new SimpleDateFormat("yyyyMMdd-HHmmssSSS", Locale.US);
        sessionIdTimeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        startTime = System.currentTimeMillis();
        stopTime = null;
        sessionID = generateSessionID(insightscontext);
    }

    protected Session(String s, String s1, String s2)
    {
        stopTime = null;
        sessionIdTimeFormat = new SimpleDateFormat("yyyyMMdd-HHmmssSSS", Locale.US);
        sessionIdTimeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        startTime = (new Scanner(s1)).nextLong();
        stopTime = Long.valueOf((new Scanner(s2)).nextLong());
        sessionID = s;
        if (stopTime.longValue() == 0x8000000000000000L)
        {
            stopTime = null;
        }
    }

    public static Session getSessionFromSerializedSession(String s)
    {
        Object obj = null;
        if (StringUtil.isBlank(s))
        {
            return null;
        }
        try
        {
            s = new JSONObject(s);
            s = new Session(s.getString("session_id"), s.getString("start_time"), s.getString("stop_time"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = obj;
        }
        return s;
    }

    public static Session newInstance(InsightsContext insightscontext)
    {
        return new Session(insightscontext);
    }

    public String generateSessionID(InsightsContext insightscontext)
    {
        String s = insightscontext.getCredentials().getApplicationKey();
        insightscontext = insightscontext.getUniqueId().getValue();
        String s1 = sessionIdTimeFormat.format(Long.valueOf(startTime));
        return (new StringBuilder()).append(StringUtil.trimOrPadString(s, 8, '_')).append('-').append(StringUtil.trimOrPadString(insightscontext, 8, '_')).append('-').append(s1).toString();
    }

    public Number getSessionDuration()
    {
        Long long2 = stopTime;
        Long long1 = long2;
        if (long2 == null)
        {
            long1 = Long.valueOf(System.currentTimeMillis());
        }
        if (long1.longValue() < startTime)
        {
            return Long.valueOf(0L);
        } else
        {
            return Long.valueOf(long1.longValue() - startTime);
        }
    }

    public String getSessionID()
    {
        return sessionID;
    }

    public long getStartTime()
    {
        return startTime;
    }

    public Long getStopTime()
    {
        return stopTime;
    }

    public boolean isPaused()
    {
        return stopTime != null;
    }

    public void pause()
    {
        if (!isPaused())
        {
            stopTime = Long.valueOf(System.currentTimeMillis());
        }
    }

    public void resume()
    {
        stopTime = null;
    }

    public JSONObject toJSONObject()
    {
        Object obj = stopTime;
        Long long1 = ((Long) (obj));
        if (obj == null)
        {
            long1 = Long.valueOf(0x8000000000000000L);
        }
        obj = new JSONBuilder(this);
        ((JSONBuilder) (obj)).withAttribute("session_id", sessionID);
        ((JSONBuilder) (obj)).withAttribute("start_time", Long.valueOf(startTime));
        ((JSONBuilder) (obj)).withAttribute("stop_time", long1);
        return ((JSONBuilder) (obj)).toJSONObject();
    }

    public String toString()
    {
        JSONObject jsonobject = toJSONObject();
        String s;
        try
        {
            s = jsonobject.toString(4);
        }
        catch (JSONException jsonexception)
        {
            return jsonobject.toString();
        }
        return s;
    }
}

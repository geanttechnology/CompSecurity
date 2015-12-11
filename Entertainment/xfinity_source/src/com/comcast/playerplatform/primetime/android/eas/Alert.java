// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import com.comcast.playerplatform.util.android.StringUtil;
import java.util.HashMap;

public class Alert
{

    private String areaDescription;
    private String description;
    private String effective;
    private String event;
    private String eventCode;
    private String expires;
    private String identifier;
    private String instruction;
    private String replaceContentUri;

    public Alert(HashMap hashmap)
    {
        identifier = (String)hashmap.get("identifier");
        event = (String)hashmap.get("event");
        eventCode = (String)hashmap.get("eventCode");
        effective = decorateTime((String)hashmap.get("effective"));
        expires = decorateTime((String)hashmap.get("expires"));
        areaDescription = (String)hashmap.get("areaDesc");
        if (hashmap.containsKey("description"))
        {
            description = (String)hashmap.get("description");
        }
        if (hashmap.containsKey("instruction"))
        {
            instruction = (String)hashmap.get("instruction");
        }
        if (hashmap.containsKey("resource"))
        {
            replaceContentUri = (String)hashmap.get("resource");
        }
    }

    private String decorateTime(String s)
    {
        return s;
    }

    public String getAlertMessage()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("A ");
        stringbuffer.append(event);
        stringbuffer.append(" has been issued for the following counties: ");
        stringbuffer.append(areaDescription);
        stringbuffer.append(" effective ");
        stringbuffer.append(effective);
        stringbuffer.append(" until ");
        stringbuffer.append(expires);
        stringbuffer.append(". ");
        if (StringUtil.isNotNullOrEmpty(description))
        {
            stringbuffer.append(description);
            stringbuffer.append(". ");
        }
        if (StringUtil.isNotNullOrEmpty(instruction))
        {
            stringbuffer.append(instruction);
            stringbuffer.append(". ");
        }
        return stringbuffer.toString();
    }

    public String getDescription()
    {
        return description;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public String getReplaceContentUri()
    {
        if (!replaceContentUri.contains(".m3u8"))
        {
            return (new StringBuilder()).append(replaceContentUri).append(".m3u8").toString();
        } else
        {
            return replaceContentUri;
        }
    }

    public boolean hasMediaUrl()
    {
        return StringUtil.isNotNullOrEmpty(replaceContentUri) && !replaceContentUri.contains(".wav");
    }

    public boolean isEmergencyActionNotification()
    {
        if (StringUtil.isNotNullOrEmpty(eventCode))
        {
            return eventCode.equals("EAN");
        } else
        {
            return false;
        }
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setIdentifier(String s)
    {
        identifier = s;
    }

    public void setReplaceContentUri(String s)
    {
        replaceContentUri = s;
    }
}

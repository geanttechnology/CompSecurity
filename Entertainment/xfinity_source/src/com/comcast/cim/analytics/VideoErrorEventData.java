// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.analytics;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.comcast.cim.analytics:
//            XfinityEventData

public class VideoErrorEventData extends XfinityEventData
{

    public VideoErrorEventData(String s, String s1, String s2)
    {
        super(s);
        setOmnitureTrackingKey(s1);
        setAppVersion(s2);
    }

    private String convertLanguagesListToCsv(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (list != null)
        {
            String s;
            for (list = list.iterator(); list.hasNext(); stringbuilder.append(s))
            {
                s = (String)list.next();
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(",");
                }
            }

        }
        return stringbuilder.toString();
    }

    public void setAppVersion(String s)
    {
        addData("appVersion", s);
    }

    public void setBitrate(long l)
    {
        addData("bitrate", String.valueOf(l));
    }

    public void setCc(boolean flag)
    {
        addData("cc", String.valueOf(flag));
    }

    public void setCurrentPlaybackPosition(long l)
    {
        addData("playbackPosition", String.valueOf(l));
    }

    public void setErrorCodes(String s)
    {
        s = s.split("\\.");
        setEventType(s[0]);
        if (s.length == 2)
        {
            setMinorErrorCode(s[1]);
        }
    }

    public void setErrorMessage(String s)
    {
        addData("errorMessage", s);
    }

    public void setErrorTitle(String s)
    {
        addData("errorTitle", s);
    }

    public void setEventType(String s)
    {
        addData("eventType", s);
    }

    public void setInAd(boolean flag)
    {
        addData("inAd", String.valueOf(flag));
    }

    public void setLanguages(List list)
    {
        addData("languages", convertLanguagesListToCsv(list));
    }

    public void setMinorErrorCode(String s)
    {
        addData("errorMinorCode", s);
    }

    public void setOmnitureTrackingKey(String s)
    {
        addData("omnitureTrackingKey", s);
    }

    public void setPid(String s)
    {
        addData("pid", s);
    }

    public void setReleaseUrl(String s)
    {
        addData("release_url", s);
    }

    public void setVideoTitle(String s)
    {
        addData("videoTitle", s);
    }
}

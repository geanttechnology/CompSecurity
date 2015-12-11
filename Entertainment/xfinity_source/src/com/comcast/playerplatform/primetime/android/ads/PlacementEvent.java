// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;

import com.comcast.playerplatform.util.android.StringUtil;
import java.util.UUID;

public abstract class PlacementEvent
{

    private static String sessionUUID;
    private String psn;

    public PlacementEvent()
    {
    }

    public static String getSessionUUID()
    {
        return sessionUUID;
    }

    public static String refreshSessionUUID()
    {
        sessionUUID = String.valueOf(UUID.randomUUID());
        return sessionUUID;
    }

    public void buildEvent(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        if (!StringUtil.isNotNullOrEmpty(s2))
        {
            String.valueOf(UUID.randomUUID());
        }
        s2 = s3;
        if (!StringUtil.isNotNullOrEmpty(s3))
        {
            s2 = String.valueOf(UUID.randomUUID());
        }
        s3 = new StringBuffer();
        s3.append(String.format("<PlacementStatusNotification identity=\"%s\" version=\"1.1\" messageId=\"%s\" system=\"IP_Player\" xmlns=\"http://www.scte.org/schemas/130-3/2008a/adm\" xmlns:core=\"http://www.scte.org/schemas/130-2/2008a/core\">", new Object[] {
            "86CF2E98-AEBA-4C3A-A3D4-616CF7D74A79", s2
        }));
        s3.append("<PlayData >");
        s3.append("<SystemContext>");
        s3.append(String.format("<Session>%s</Session>", new Object[] {
            sessionUUID
        }));
        s3.append("</SystemContext>");
        s3.append("<Client>");
        s3.append(String.format("<TerminalAddress type=\"DEVICEID\">%s</TerminalAddress>", new Object[] {
            s1
        }));
        s3.append("</Client>");
        if (!isEndAll().booleanValue())
        {
            s3.append("<SpotScopedEvents>");
            s3.append("<Spot>");
            s3.append("<core:Content>");
            if (StringUtil.isNotNullOrEmpty(s4) && StringUtil.isNotNullOrEmpty(s5))
            {
                s3.append(String.format("<core:AssetRef assetID=\"%s\" providerID=\"%s\"/>", new Object[] {
                    s4, s5
                }));
            }
            s3.append(String.format("<core:Tracking>%s</core:Tracking>", new Object[] {
                s
            }));
            s3.append("</core:Content>");
            s3.append("</Spot>");
        }
        s3.append("<Events>");
        getEventData(s3, s6);
        s3.append("</Events>");
        if (!isEndAll().booleanValue())
        {
            s3.append("</SpotScopedEvents>");
        }
        s3.append("</PlayData>");
        s3.append("</PlacementStatusNotification>");
        psn = s3.toString();
    }

    public abstract void getEventData(StringBuffer stringbuffer, String s);

    public String getPsn()
    {
        return psn;
    }

    public abstract Boolean isEndAll();
}

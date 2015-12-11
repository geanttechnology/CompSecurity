// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.util;

import android.content.Context;
import android.content.res.Resources;
import com.adobe.mediacore.metadata.Metadata;
import com.adobe.mediacore.metadata.MetadataNode;
import com.comcast.playerplatform.util.android.ConfigurationManager;
import com.comcast.playerplatform.util.android.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationHelper
{

    private Context appContext;
    private ConfigurationManager configurationManager;

    public ConfigurationHelper()
    {
        if (configurationManager == null)
        {
            configurationManager = ConfigurationManager.getInstance();
        }
    }

    public ConfigurationHelper(Context context)
    {
        this();
        appContext = context;
    }

    private Metadata parseConfigString(String s)
    {
        Object obj = null;
        if (StringUtil.isNotNullOrEmpty(s))
        {
            MetadataNode metadatanode = new MetadataNode();
            s = s.split(";");
            int j = s.length;
            int i = 0;
            do
            {
                obj = metadatanode;
                if (i >= j)
                {
                    break;
                }
                obj = s[i].split("=");
                if (obj.length == 2 && StringUtil.isNotNullOrEmpty(obj[0]))
                {
                    if (obj[0].equals("device") && appContext != null)
                    {
                        if (appContext.getResources().getBoolean(com.comcast.playerplatform.primetime.android.R.bool.isTablet))
                        {
                            metadatanode.setValue(obj[0], "androidtablet");
                        } else
                        {
                            metadatanode.setValue(obj[0], "android");
                        }
                    } else
                    {
                        metadatanode.setValue(obj[0], obj[1]);
                    }
                }
                i++;
            } while (true);
        }
        return ((Metadata) (obj));
    }

    public String getAbrPolicy()
    {
        return getValue("AbrPolicy");
    }

    public long getAlertPollingInterval()
    {
        return Long.parseLong(getValue("EasUpdateInterval"));
    }

    public String getAlertServiceURL()
    {
        return getValue("AlertServiceEndPoint");
    }

    public String getAuditudeDomain()
    {
        return getValue("DomainId");
    }

    public Metadata getAuditudeParameters()
    {
        return parseConfigString(getValue("CustomParams"));
    }

    public String getAuditudeZone()
    {
        return getValue("ZoneId");
    }

    public Map getComscoreParameters()
    {
        HashMap hashmap = new HashMap();
        String s = getValue("ComscoreParams");
        if (StringUtil.isNotNullOrEmpty(s))
        {
            String as[] = s.split(";");
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String as1[] = as[i].split("=");
                if (as1.length == 2 && StringUtil.isNotNullOrEmpty(as1[0]))
                {
                    hashmap.put(as1[0], as1[1]);
                }
            }

        }
        return hashmap;
    }

    public int getHeartBeatInterval()
    {
        return Integer.parseInt(getValue("HeartbeatInterval"));
    }

    public int getInitialBitrate()
    {
        return Integer.parseInt(getValue("InitialBitrate"));
    }

    public long getInitialBuffer()
    {
        return Long.parseLong(getValue("InitialBuffer"));
    }

    public String getLinearBuffer()
    {
        return getValue("PlayingLinearBufferTime");
    }

    public int getMaxBitrate()
    {
        return Integer.parseInt(getValue("MaximumBitrate"));
    }

    public int getMinBitrate()
    {
        return Integer.parseInt(getValue("MinimumBitrate"));
    }

    public String getPartnerId()
    {
        return getValue("PartnerId");
    }

    public long getPlaybackBuffer()
    {
        return Long.parseLong(getValue("PlaybackBuffer"));
    }

    public String getValue(String s)
    {
        if (configurationManager.isReady() && configurationManager.containsKey(s))
        {
            return configurationManager.getConfigValue(s);
        } else
        {
            return null;
        }
    }

    public String getZipsToFipsURL()
    {
        return getValue("ZipToFipsEndPoint");
    }

    public boolean isEspnReady()
    {
        return configurationManager.isEspnReady();
    }
}

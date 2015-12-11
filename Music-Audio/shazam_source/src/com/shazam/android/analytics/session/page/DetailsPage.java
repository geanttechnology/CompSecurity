// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.page;

import android.net.Uri;
import com.shazam.android.k.f.r;
import com.shazam.android.k.f.s;
import com.shazam.i.e.a;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.analytics.event.EventParameterKey;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.shazam.android.analytics.session.page:
//            Page

public class DetailsPage
    implements Page
{

    private String adProvider;
    private Map analyticsInfoParameters;
    private String beaconKey;
    private String campaign;
    private String chartTitle;
    private String eventId;
    private String pageName;
    private ScreenOrigin screenOrigin;
    private String tagId;
    private String tagResultVersion;
    private String trackCategory;
    private String trackId;

    public DetailsPage()
    {
    }

    private void setBeaconKeyIfNotNull(String s1)
    {
        if (s1 != null)
        {
            setBeaconKey(s1);
        }
    }

    private void setCampaignIfNotNull(String s1)
    {
        if (s1 != null)
        {
            setCampaign(s1);
        }
    }

    private void setChartTitle(String s1)
    {
        chartTitle = s1;
    }

    private void setChartTitleIfNotNull(String s1)
    {
        if (s1 != null)
        {
            setChartTitle(s1);
        }
    }

    private void setEventIdIfNotNull(String s1)
    {
        if (s1 != null)
        {
            setEventId(s1);
        }
    }

    private void setScreenOriginIfNotNull(ScreenOrigin screenorigin)
    {
        if (screenorigin != null)
        {
            setScreenOrigin(screenorigin);
        }
    }

    private void setTagIdIfNotNull(String s1)
    {
        if (s1 != null)
        {
            setTagId(s1);
        }
    }

    private void setTrackIdIfNotNull(String s1)
    {
        if (s1 != null)
        {
            setTrackId(s1);
        }
    }

    protected void addEventParameterIfNotNull(Map map, EventParameterKey eventparameterkey, String s1)
    {
        if (s1 != null)
        {
            map.put(eventparameterkey.getParameterKey(), s1);
        }
    }

    public Map getAdditionalEventParameters()
    {
        Map map = a.a(0);
        addEventParameterIfNotNull(map, DefinedEventParameterKey.TRACK_ID, trackId);
        addEventParameterIfNotNull(map, DefinedEventParameterKey.CAMPAIGN, campaign);
        addEventParameterIfNotNull(map, DefinedEventParameterKey.TRACK_KEY, beaconKey);
        addEventParameterIfNotNull(map, DefinedEventParameterKey.MATCH_CATEGORY, trackCategory);
        addEventParameterIfNotNull(map, DefinedEventParameterKey.TAG_ID, tagId);
        addEventParameterIfNotNull(map, DefinedEventParameterKey.EVENT_ID, eventId);
        addEventParameterIfNotNull(map, DefinedEventParameterKey.SCREEN_ORIGIN, ScreenOrigin.a(screenOrigin));
        addEventParameterIfNotNull(map, DefinedEventParameterKey.CHART_TITLE, chartTitle);
        addEventParameterIfNotNull(map, DefinedEventParameterKey.TAG_RESULT_VERSION, tagResultVersion);
        addEventParameterIfNotNull(map, DefinedEventParameterKey.AD_PROVIDER, adProvider);
        if (analyticsInfoParameters != null)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = analyticsInfoParameters.entrySet().iterator(); iterator.hasNext(); addEventParameterIfNotNull(map, (EventParameterKey)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        return map;
    }

    public String getPageName()
    {
        return pageName;
    }

    public void populateFromAnalyticsInfo(AnalyticsInfo analyticsinfo)
    {
        analyticsInfoParameters = analyticsinfo.eventParameters;
    }

    public void populateFromDataUri(Uri uri)
    {
        String s1 = uri.getQueryParameter("screenorigin");
        if (s1 == null)
        {
            if ("http".equals(uri.getScheme()))
            {
                setScreenOrigin(ScreenOrigin.HTTP_DEEPLINK);
            }
            return;
        } else
        {
            setScreenOrigin(ScreenOrigin.a(s1));
            return;
        }
    }

    public void populateFromShazamUri(r r1)
    {
        if (r1 == null)
        {
            r1 = null;
        } else
        {
            r1 = r1.c;
        }
        if (r1 != null)
        {
            setScreenOriginIfNotNull(((s) (r1)).e);
            setTrackIdIfNotNull(((s) (r1)).b);
            setBeaconKeyIfNotNull(((s) (r1)).g);
            setCampaignIfNotNull(((s) (r1)).i);
            setTagIdIfNotNull(((s) (r1)).d);
            setEventIdIfNotNull(((s) (r1)).c);
            setChartTitleIfNotNull(((s) (r1)).f);
        }
    }

    public void setAdProvider(String s1)
    {
        adProvider = s1;
    }

    public void setAdProviderIfNotNull(String s1)
    {
        if (s1 != null)
        {
            setAdProvider(s1);
        }
    }

    public void setBeaconKey(String s1)
    {
        beaconKey = s1;
    }

    public void setCampaign(String s1)
    {
        campaign = s1;
    }

    public void setEventId(String s1)
    {
        eventId = s1;
    }

    public void setPageName(String s1)
    {
        pageName = s1;
    }

    public void setScreenOrigin(ScreenOrigin screenorigin)
    {
        screenOrigin = screenorigin;
    }

    public void setTagId(String s1)
    {
        tagId = s1;
    }

    public void setTagResultVersion(String s1)
    {
        tagResultVersion = s1;
    }

    public void setTrackCategory(String s1)
    {
        trackCategory = s1;
    }

    public void setTrackId(String s1)
    {
        trackId = s1;
    }
}

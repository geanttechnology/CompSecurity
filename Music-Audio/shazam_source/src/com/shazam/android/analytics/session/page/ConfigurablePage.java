// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.page;

import com.shazam.model.analytics.event.DefinedEventParameterKey;
import java.util.Map;

// Referenced classes of package com.shazam.android.analytics.session.page:
//            SimplePageWithName

public class ConfigurablePage extends SimplePageWithName
{

    private String eventId;
    private String pageName;
    private String screenOrigin;

    public ConfigurablePage()
    {
    }

    protected void addEventParameterIfNotNull(Map map, DefinedEventParameterKey definedeventparameterkey, String s)
    {
        if (s != null)
        {
            map.put(definedeventparameterkey.getParameterKey(), s);
        }
    }

    public Map getAdditionalEventParameters()
    {
        Map map = super.getAdditionalEventParameters();
        addEventParameterIfNotNull(map, DefinedEventParameterKey.SCREEN_ORIGIN, getScreenOrigin());
        addEventParameterIfNotNull(map, DefinedEventParameterKey.EVENT_ID, eventId);
        return map;
    }

    public String getPageName()
    {
        return pageName;
    }

    public String getScreenOrigin()
    {
        return screenOrigin;
    }

    public void setEventId(String s)
    {
        eventId = s;
    }

    public void setPageName(String s)
    {
        pageName = s;
    }

    public void setScreenOrigin(String s)
    {
        screenOrigin = s;
    }
}

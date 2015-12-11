// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.page;

import com.shazam.model.analytics.event.DefinedEventParameterKey;
import java.util.Map;

// Referenced classes of package com.shazam.android.analytics.session.page:
//            ConfigurablePage

public class ArtistProfilePage extends ConfigurablePage
{

    private String artistId;
    private Boolean isVerified;

    public ArtistProfilePage()
    {
    }

    public Map getAdditionalEventParameters()
    {
        Map map = super.getAdditionalEventParameters();
        map.put(DefinedEventParameterKey.ARTIST_ID.getParameterKey(), artistId);
        if (isVerified != null)
        {
            String s1 = DefinedEventParameterKey.IS_VERIFIED.getParameterKey();
            String s;
            if (isVerified.booleanValue())
            {
                s = "1";
            } else
            {
                s = "0";
            }
            map.put(s1, s);
        }
        return map;
    }

    public String getPageName()
    {
        return "artist";
    }

    public void setArtistId(String s)
    {
        artistId = s;
    }

    public void setIsVerified(boolean flag)
    {
        isVerified = Boolean.valueOf(flag);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;
import com.damnhandy.uri.template.UriTemplate;
import com.damnhandy.uri.template.impl.ExpressionParseException;
import com.xfinity.playerlib.model.HalUtils;
import java.net.URI;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.model.consumable.hal:
//            HalLiveStreamParseable

public class HalLiveStream extends HalLiveStreamParseable
{

    private boolean isAdultContent;
    private String networkLogoUrl;
    private List providerCodes;
    private String scm;
    private String streamId;

    public HalLiveStream()
    {
    }

    public static String getArtworkUrl(String s, int i, int j)
    {
        String s1;
        try
        {
            s1 = UriTemplate.fromTemplate(s).set("width", Integer.toString(i)).set("height", Integer.toString(j)).expand();
        }
        catch (ExpressionParseException expressionparseexception)
        {
            return s;
        }
        return s1;
    }

    private String getScheme()
    {
        return URI.create(getPlaybackLink()).getScheme();
    }

    public String getNetworkLogoUrl()
    {
        return networkLogoUrl;
    }

    public List getProviderCodes()
    {
        return providerCodes;
    }

    public String getSchemeSpecificPart()
    {
        return URI.create(getPlaybackLink()).getSchemeSpecificPart();
    }

    public String getScm()
    {
        return scm;
    }

    public String getStreamId()
    {
        return streamId;
    }

    public boolean isAdultContent()
    {
        return isAdultContent;
    }

    public boolean isDisney()
    {
        return getScheme().contains("disney");
    }

    public boolean isEspn()
    {
        return getScheme().contains("espn");
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        super.parseHalContent(microdatapropertyresolver);
        networkLogoUrl = HalUtils.resolveOptionalLink("networkLogo", microdatapropertyresolver);
        scm = microdatapropertyresolver.fetchString("scm");
        providerCodes = microdatapropertyresolver.fetchList("providerCodes");
        streamId = microdatapropertyresolver.fetchString("id");
    }

    public void setArtworkLink(String s)
    {
        artworkLink = s;
    }

    public void setStreamId(String s)
    {
        streamId = s;
    }
}

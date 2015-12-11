// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import com.comcast.cim.cmasl.hal.model.HalParseable;
import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;
import com.comcast.cim.microdata.exception.PropertyNotFoundException;
import com.comcast.cim.microdata.model.MicrodataItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.consumable.hal:
//            HalLiveStream

public class HalLiveStreamResource
    implements HalParseable
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource);
    private Map liveStreamMap;

    public HalLiveStreamResource()
    {
        liveStreamMap = new LinkedHashMap();
    }

    public HalLiveStream getLiveStream(String s)
    {
        return (HalLiveStream)liveStreamMap.get(s);
    }

    public List getLiveStreams()
    {
        return new ArrayList(liveStreamMap.values());
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        Iterator iterator = microdatapropertyresolver.fetchList("streams").iterator();
_L2:
        MicrodataItem microdataitem;
        HalLiveStream hallivestream;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        microdataitem = (MicrodataItem)iterator.next();
        hallivestream = new HalLiveStream();
        hallivestream.parseHalContent(microdatapropertyresolver.copy(microdataitem));
        liveStreamMap.put(hallivestream.getStreamId(), hallivestream);
        continue; /* Loop/switch isn't completed */
        PropertyNotFoundException propertynotfoundexception;
        propertynotfoundexception;
        LOG.error((new StringBuilder()).append("Failed to parse Live Stream: ").append(microdataitem.toString()).toString(), propertynotfoundexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

}

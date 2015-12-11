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
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.consumable.hal:
//            HalLiveFeaturedContent

public class HalLiveFeaturedContentResource
    implements HalParseable
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource);
    private List liveFeaturedContentList;

    public HalLiveFeaturedContentResource()
    {
        liveFeaturedContentList = new ArrayList();
    }

    public List getLiveFeaturedContent()
    {
        return liveFeaturedContentList;
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        for (Iterator iterator = microdatapropertyresolver.fetchList("resources").iterator(); iterator.hasNext();)
        {
            MicrodataItem microdataitem = (MicrodataItem)iterator.next();
            HalLiveFeaturedContent hallivefeaturedcontent = new HalLiveFeaturedContent();
            try
            {
                hallivefeaturedcontent.parseHalContent(microdatapropertyresolver.copy(microdataitem));
                liveFeaturedContentList.add(hallivefeaturedcontent);
            }
            catch (PropertyNotFoundException propertynotfoundexception)
            {
                LOG.error((new StringBuilder()).append("Failed to parse Featured Content: ").append(microdataitem.toString()).toString(), propertynotfoundexception);
            }
        }

    }

}

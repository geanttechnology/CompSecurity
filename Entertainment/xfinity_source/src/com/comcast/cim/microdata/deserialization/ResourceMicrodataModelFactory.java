// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.deserialization;

import com.comcast.cim.microdata.client.HypermediaClient;
import com.comcast.cim.microdata.model.MicrodataContext;
import com.comcast.cim.microdata.model.MicrodataItem;
import com.comcast.cim.microdata.model.MicrodataLink;
import com.comcast.cim.microdata.model.MicrodataLinkValue;
import com.comcast.cim.microdata.model.MicrodataResource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.comcast.cim.microdata.deserialization:
//            DefaultMicrodataModelFactory

public class ResourceMicrodataModelFactory extends DefaultMicrodataModelFactory
{

    public ResourceMicrodataModelFactory(HypermediaClient hypermediaclient, String s)
    {
        context = new MicrodataContext(hypermediaclient, s, this, new HashMap());
    }

    private MicrodataItem createResource(String s, String s1, List list, List list1, List list2, boolean flag)
    {
        s = new MicrodataResource(s);
        s.setId(s1);
        s.addProperties(list2);
        s.addForms(list1);
        s.addLinks(list);
        s.setContext(context);
        s.setCanonical(flag);
        return s;
    }

    private MicrodataLink getSelfLink(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            MicrodataLink microdatalink = (MicrodataLink)list.next();
            if ("self".equals(microdatalink.getRelation()))
            {
                return microdatalink;
            }
        }

        return null;
    }

    private boolean isTag(MicrodataLink microdatalink)
    {
        return microdatalink.getValue().getHref().startsWith("tag:");
    }

    public MicrodataItem createMicrodataItem(String s, String s1, List list, List list1, List list2)
    {
        return createMicrodataItem(s, s1, list, list1, list2, false);
    }

    public MicrodataItem createMicrodataItem(String s, String s1, List list, List list1, List list2, boolean flag)
    {
        MicrodataLink microdatalink = getSelfLink(list);
        if (microdatalink != null)
        {
            if (flag || isTag(microdatalink))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s = createResource(s, s1, list, list1, list2, flag);
            s1 = microdatalink.getValue().getHref();
            context.getItemMap().put(s1, s);
            return s;
        } else
        {
            return super.createMicrodataItem(s, s1, list, list1, list2);
        }
    }
}

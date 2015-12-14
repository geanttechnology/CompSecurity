// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import com.amazon.clouddrive.model.NodeListingResponse;
import java.util.List;

// Referenced classes of package com.amazon.mixtape.service:
//            NodeExtractors

static final class nse
    implements deExtractor
{

    public List getNodes(NodeListingResponse nodelistingresponse)
    {
        return nodelistingresponse.getData();
    }

    public volatile List getNodes(Object obj)
    {
        return getNodes((NodeListingResponse)obj);
    }

    nse()
    {
    }
}

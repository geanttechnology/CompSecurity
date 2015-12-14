// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import com.amazon.clouddrive.extended.model.NodeExtended;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.mixtape.service:
//            NodeExtractors

static final class ended
    implements deExtractor
{

    public List getNodes(NodeExtended nodeextended)
    {
        return Collections.singletonList(nodeextended);
    }

    public volatile List getNodes(Object obj)
    {
        return getNodes((NodeExtended)obj);
    }

    ended()
    {
    }
}

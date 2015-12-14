// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import com.amazon.clouddrive.extended.model.GetChangesExtendedResponse;
import com.amazon.clouddrive.extended.model.NodeExtended;
import com.amazon.clouddrive.model.NodeListingResponse;
import java.util.Collections;
import java.util.List;

class NodeExtractors
{
    static interface NodeExtractor
    {

        public abstract List getNodes(Object obj);
    }


    public static final NodeExtractor CHANGES_NODE_EXTRACTOR = new NodeExtractor() {

        public List getNodes(GetChangesExtendedResponse getchangesextendedresponse)
        {
            return getchangesextendedresponse.getNodes();
        }

        public volatile List getNodes(Object obj)
        {
            return getNodes((GetChangesExtendedResponse)obj);
        }

    };
    public static final NodeExtractor LIST_NODE_RESPONSE_EXTRACTOR = new NodeExtractor() {

        public List getNodes(NodeListingResponse nodelistingresponse)
        {
            return nodelistingresponse.getData();
        }

        public volatile List getNodes(Object obj)
        {
            return getNodes((NodeListingResponse)obj);
        }

    };
    public static final NodeExtractor NODE_RESPONSE_EXTRACTOR = new NodeExtractor() {

        public List getNodes(NodeExtended nodeextended)
        {
            return Collections.singletonList(nodeextended);
        }

        public volatile List getNodes(Object obj)
        {
            return getNodes((NodeExtended)obj);
        }

    };

}

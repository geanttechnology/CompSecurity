// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

// Referenced classes of package com.mopub.mobileads:
//            VastCompanionAdXmlManager, VastTracker, VastLinearXmlManager

abstract class VastBaseInLineWrapperXmlManager
{

    private static final String COMPANION = "Companion";
    private static final String COMPANION_ADS = "CompanionAds";
    private static final String CREATIVE = "Creative";
    private static final String CREATIVES = "Creatives";
    private static final String ERROR = "Error";
    private static final String IMPRESSION_TRACKER = "Impression";
    private static final String LINEAR = "Linear";
    protected final Node mNode;

    VastBaseInLineWrapperXmlManager(Node node)
    {
        Preconditions.checkNotNull(node);
        mNode = node;
    }

    List getCompanionAdXmlManagers()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = XmlUtils.getFirstMatchingChildNode(mNode, "Creatives");
        if (obj != null)
        {
            if ((obj = XmlUtils.getMatchingChildNodes(((Node) (obj)), "Creative")) != null)
            {
                obj = ((List) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    Object obj1 = XmlUtils.getFirstMatchingChildNode((Node)((Iterator) (obj)).next(), "CompanionAds");
                    if (obj1 != null)
                    {
                        obj1 = XmlUtils.getMatchingChildNodes(((Node) (obj1)), "Companion");
                        if (obj1 != null)
                        {
                            obj1 = ((List) (obj1)).iterator();
                            while (((Iterator) (obj1)).hasNext()) 
                            {
                                arraylist.add(new VastCompanionAdXmlManager((Node)((Iterator) (obj1)).next()));
                            }
                        }
                    }
                }
            }
        }
        return arraylist;
    }

    List getErrorTrackers()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = XmlUtils.getMatchingChildNodes(mNode, "Error");
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                String s = XmlUtils.getNodeValue((Node)((Iterator) (obj)).next());
                if (!TextUtils.isEmpty(s))
                {
                    arraylist.add(new VastTracker(s, true));
                }
            }
        }
        return arraylist;
    }

    List getImpressionTrackers()
    {
        Object obj = XmlUtils.getMatchingChildNodes(mNode, "Impression");
        ArrayList arraylist = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = XmlUtils.getNodeValue((Node)((Iterator) (obj)).next());
            if (!TextUtils.isEmpty(s))
            {
                arraylist.add(new VastTracker(s));
            }
        } while (true);
        return arraylist;
    }

    List getLinearXmlManagers()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = XmlUtils.getFirstMatchingChildNode(mNode, "Creatives");
        if (obj != null)
        {
            if ((obj = XmlUtils.getMatchingChildNodes(((Node) (obj)), "Creative")) != null)
            {
                obj = ((List) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    Node node = XmlUtils.getFirstMatchingChildNode((Node)((Iterator) (obj)).next(), "Linear");
                    if (node != null)
                    {
                        arraylist.add(new VastLinearXmlManager(node));
                    }
                }
            }
        }
        return arraylist;
    }
}

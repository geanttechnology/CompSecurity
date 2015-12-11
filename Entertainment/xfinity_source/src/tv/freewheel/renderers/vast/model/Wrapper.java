// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.model;

import android.webkit.URLUtil;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.utils.XMLHandler;

// Referenced classes of package tv.freewheel.renderers.vast.model:
//            AbstractAd, Util

public class Wrapper extends AbstractAd
{

    public String vastAdTagUri;

    public Wrapper()
    {
    }

    public boolean isValid(ISlot islot, IConstants iconstants)
    {
        return !Util.isNullOrEmptyString(vastAdTagUri) && URLUtil.isValidUrl(vastAdTagUri);
    }

    public void parse(Element element)
    {
        super.parse(element);
        element = element.getChildNodes();
        int j = element.getLength();
        for (int i = 0; i < j; i++)
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1 && node.getNodeName().equals("VASTAdTagURI"))
            {
                vastAdTagUri = XMLHandler.getTextNodeValue(node).trim();
            }
        }

    }
}

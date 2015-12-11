// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad;

import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad:
//            AdContextScoped, Creative, AdContext

public class Ad extends AdContextScoped
{

    public int adId;
    public String adUnit;
    public ArrayList creatives;
    public boolean isRequiredToShow;
    public boolean noLoad;

    public Ad(AdContext adcontext)
    {
        super(adcontext);
        creatives = new ArrayList();
        adId = 0;
        adUnit = null;
        noLoad = false;
        isRequiredToShow = false;
    }

    private void parseCreatives(Element element)
    {
        element = element.getChildNodes();
        int i = 0;
        while (i < element.getLength()) 
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1)
            {
                Object obj = node.getNodeName();
                logger.verbose((new StringBuilder()).append("parse(), name: ").append(((String) (obj))).toString());
                if (((String) (obj)).equals("creative"))
                {
                    obj = new Creative(context);
                    ((Creative) (obj)).parse((Element)node);
                    creatives.add(obj);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(((String) (obj))).toString());
                }
            }
            i++;
        }
    }

    public Ad cloneForTranslation()
    {
        Ad ad = new Ad(context);
        ad.adId = adId;
        ad.adUnit = adUnit;
        ad.isRequiredToShow = isRequiredToShow;
        for (int i = 0; i < creatives.size(); i++)
        {
            ad.creatives.add(((Creative)creatives.get(i)).cloneForTranslation());
        }

        return ad;
    }

    public Creative getCreative(int i)
    {
        for (Iterator iterator = creatives.iterator(); iterator.hasNext();)
        {
            Creative creative = (Creative)iterator.next();
            if (creative.creativeId == i)
            {
                return creative;
            }
        }

        return null;
    }

    public void parse(Element element)
    {
        adId = tryParseInt(element.getAttribute("adId"));
        adUnit = element.getAttribute("adUnit");
        noLoad = tryParseBoolean(element.getAttribute("noLoad"), false);
        if (element.hasAttribute("required"))
        {
            isRequiredToShow = element.getAttribute("required").equalsIgnoreCase("true");
        }
        element = element.getChildNodes();
        int i = 0;
        while (i < element.getLength()) 
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1)
            {
                String s = node.getNodeName();
                logger.verbose((new StringBuilder()).append("parse(), name: ").append(s).toString());
                if (s.equals("creatives"))
                {
                    parseCreatives((Element)node);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(s).toString());
                }
            }
            i++;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.model;

import android.webkit.URLUtil;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.renderers.vast.util.StringUtils;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.XMLHandler;

// Referenced classes of package tv.freewheel.renderers.vast.model:
//            AbstractCreativeRendition, Util, FWVastContentTransform

abstract class AbstractNonMediaFile extends AbstractCreativeRendition
{

    Integer expandedHeight;
    Integer expandedWidth;
    String htmlResource;
    String iframeResource;
    String staticResource;

    AbstractNonMediaFile()
    {
    }

    private String getResource()
    {
        if (staticResource != null)
        {
            return (new StringBuilder()).append("staticResource='").append(staticResource).append("'").toString();
        }
        if (iframeResource != null)
        {
            return (new StringBuilder()).append("iframeResource='").append(iframeResource).append("'").toString();
        }
        if (htmlResource != null)
        {
            return (new StringBuilder()).append("htmlResource='").append(htmlResource).append("'").toString();
        } else
        {
            return "no resource";
        }
    }

    public void parse(Element element)
    {
        super.parse(element);
        expandedWidth = Integer.valueOf(StringUtils.parseInt(element.getAttribute("expandedWidth")));
        expandedHeight = Integer.valueOf(StringUtils.parseInt(element.getAttribute("expandedHeight")));
        element = element.getChildNodes();
        int i = 0;
        while (i < element.getLength()) 
        {
            Object obj = element.item(i);
            if (((Node) (obj)).getNodeType() == 1)
            {
                String s = ((Node) (obj)).getNodeName();
                if (s.equals("AdParameters"))
                {
                    adParameters = XMLHandler.getTextNodeValue(((Node) (obj)));
                } else
                if (s.equals("StaticResource"))
                {
                    staticResource = XMLHandler.getTextNodeValue(((Node) (obj)));
                    obj = ((Element)obj).getAttribute("creativeType");
                    if (!Util.isNullOrEmptyString(((String) (obj))))
                    {
                        type = ((String) (obj)).trim();
                        if (!Util.isNullOrEmptyString(staticResource) && URLUtil.isValidUrl(staticResource.trim()) && !super.isSetAssetContentSuccessfully(staticResource))
                        {
                            assetURL = staticResource.trim();
                            if (type.equalsIgnoreCase("text/html"))
                            {
                                type = "text/html_doc_ref";
                            }
                        }
                    }
                } else
                if (s.equals("IFrameResource"))
                {
                    iframeResource = XMLHandler.getTextNodeValue(((Node) (obj)));
                    if (!Util.isNullOrEmptyString(iframeResource) && URLUtil.isValidUrl(iframeResource.trim()))
                    {
                        logger.debug((new StringBuilder()).append("selected IFrameResource :").append(iframeResource).toString());
                        assetURL = iframeResource.trim();
                        type = "text/html_doc_ref";
                    }
                } else
                if (s.equals("HTMLResource"))
                {
                    htmlResource = XMLHandler.getTextNodeValue(((Node) (obj)));
                    if (!Util.isNullOrEmptyString(htmlResource))
                    {
                        logger.debug((new StringBuilder()).append("selected HTMLResource :").append(htmlResource).toString());
                        assetContent = FWVastContentTransform.text_html_TO_text_html_doc_lit_mobile(htmlResource);
                    }
                    type = "text/html_doc_lit_mobile";
                }
            }
            i++;
        }
    }

    public String toString()
    {
        return String.format("[%s resource=%s adParameters='%s' expandedWidth=%d expandedHeight=%d]", new Object[] {
            super.toString(), getResource(), adParameters, expandedWidth, expandedHeight
        });
    }

    public void translateToFWCreativeRendition(ICreativeRendition icreativerendition, IAdInstance iadinstance, IAdInstance iadinstance1, IConstants iconstants)
    {
        String s = getClickThroughURL();
        if (s != null)
        {
            iadinstance.setClickThroughURL(s, iconstants.EVENT_AD_CLICK());
        }
        super.translateToFWCreativeRendition(icreativerendition, iadinstance, iadinstance1, iconstants);
    }
}

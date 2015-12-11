// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.w3c.dom.Element;
import tv.freewheel.hybrid.ad.interfaces.IAdInstance;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.ICreativeRendition;
import tv.freewheel.hybrid.ad.interfaces.ICreativeRenditionAsset;
import tv.freewheel.hybrid.ad.interfaces.ISlot;
import tv.freewheel.hybrid.renderers.vast.util.StringUtils;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast.model:
//            IVastValidation, FWVastContentTypeTransform, FWVastContentTransform

public abstract class AbstractCreativeRendition
    implements IVastValidation
{

    String adParameters;
    String apiFramework;
    String assetContent;
    String assetURL;
    public Integer height;
    public String id;
    protected Logger logger;
    private boolean shouldInjectCallback;
    String type;
    public Integer width;

    protected AbstractCreativeRendition()
    {
        shouldInjectCallback = false;
        logger = Logger.getLogger(this);
    }

    String getAltText()
    {
        return null;
    }

    abstract String getClickThroughURL();

    public String getContentType()
    {
        if (type != null)
        {
            return FWVastContentTypeTransform.transform(type);
        } else
        {
            return null;
        }
    }

    public boolean isSetAssetContentSuccessfully(String s)
    {
        if (type.contains("image"))
        {
            shouldInjectCallback = true;
            assetContent = FWVastContentTransform.image_TO_text_html_doc_lit_mobile(s, width.intValue(), height.intValue(), getAltText());
            return true;
        }
        if (type.contains("javascript"))
        {
            assetContent = FWVastContentTransform.text_js_ref_TO_text_html_doc_lit_mobile(s);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean isValid(ISlot islot, IConstants iconstants)
    {
        return width != null && (double)width.intValue() > 0.0D && height != null && (double)height.intValue() > 0.0D && type != null && (assetURL != null || assetContent != null);
    }

    public void parse(Element element)
    {
        id = element.getAttribute("id");
        width = Integer.valueOf(StringUtils.parseInt(element.getAttribute("width")));
        height = Integer.valueOf(StringUtils.parseInt(element.getAttribute("height")));
        apiFramework = element.getAttribute("apiFramework");
    }

    public String toString()
    {
        return String.format("[[%s] id=%s assetURL=%s assetContent=%s  width=%d height=%d type=%s apiFramework=%s]", new Object[] {
            super.toString(), id, assetURL, assetContent, width, height, type, apiFramework
        });
    }

    public void translateToFWCreativeRendition(ICreativeRendition icreativerendition, IAdInstance iadinstance, IAdInstance iadinstance1, IConstants iconstants)
    {
        icreativerendition.setContentType(getContentType());
        if (apiFramework != null && apiFramework.equalsIgnoreCase("MRAID"))
        {
            icreativerendition.setCreativeAPI("MRAID-1.0");
        } else
        if (apiFramework != null && apiFramework.equalsIgnoreCase("VPAID"))
        {
            icreativerendition.setCreativeAPI("VPAID");
        }
        if (adParameters != null)
        {
            try
            {
                NameValuePair namevaluepair;
                for (iadinstance1 = URLEncodedUtils.parse(URI.create((new StringBuilder()).append("http://fakehost?").append(adParameters).toString()), "UTF-8").iterator(); iadinstance1.hasNext(); icreativerendition.setParameter(namevaluepair.getName(), namevaluepair.getValue()))
                {
                    namevaluepair = (NameValuePair)iadinstance1.next();
                }

            }
            // Misplaced declaration of an exception variable
            catch (IAdInstance iadinstance1)
            {
                logger.debug((new StringBuilder()).append("Invalid adParameters:").append(adParameters).toString());
            }
        }
        icreativerendition.setWidth(width.intValue());
        icreativerendition.setHeight(height.intValue());
        if (icreativerendition.getWrapperURL() == null)
        {
            ICreativeRenditionAsset icreativerenditionasset = icreativerendition.createCreativeRenditionAssetForTranslation(id, true);
            icreativerenditionasset.setContentType(getContentType());
            icreativerenditionasset.setMimeType(type);
            if (assetURL != null)
            {
                icreativerenditionasset.setURL(assetURL);
            } else
            {
                if (shouldInjectCallback)
                {
                    Object obj = null;
                    Object obj1 = getClickThroughURL();
                    iadinstance1 = obj;
                    if (obj1 != null)
                    {
                        iadinstance.setClickThroughURL(((String) (obj1)), iconstants.EVENT_AD_CLICK());
                        obj1 = iadinstance.getEventCallbackURLs(iconstants.EVENT_AD_CLICK(), iconstants.EVENT_TYPE_CLICK());
                        iadinstance1 = obj;
                        if (obj1 != null)
                        {
                            iadinstance1 = obj;
                            if (((ArrayList) (obj1)).size() > 0)
                            {
                                iadinstance1 = (String)((ArrayList) (obj1)).get(0);
                            }
                        }
                    }
                    obj1 = iadinstance.getEventCallbackURLs(iconstants.EVENT_AD_CLICK(), iconstants.EVENT_TYPE_CLICK_TRACKING());
                    logger.debug((new StringBuilder()).append("injected tracking urls:").append(((ArrayList) (obj1)).toString()).toString());
                    obj = null;
                    iconstants = obj;
                    if (iadinstance != null)
                    {
                        iconstants = obj;
                        if (iadinstance.getSlot() != null)
                        {
                            iconstants = iadinstance.getSlot().getCustomId();
                        }
                    }
                    assetContent = FWVastContentTransform.injectCallback(assetContent, iadinstance1, ((ArrayList) (obj1)), iconstants);
                }
                icreativerenditionasset.setContent(assetContent);
            }
            translateToFWCreativeRenditionAsset(icreativerenditionasset);
            logger.debug((new StringBuilder()).append("translate to asset (content type:").append(icreativerenditionasset.getContentType()).append(",mime type:").append(icreativerenditionasset.getMimeType()).append(", url:").append(icreativerenditionasset.getURL()).append(",content:").append(icreativerenditionasset.getContent()).toString());
        }
        logger.debug((new StringBuilder()).append("translate to content type:").append(icreativerendition.getContentType()).toString());
        logger.debug((new StringBuilder()).append("translate to width:").append(icreativerendition.getWidth()).append(",height=").append(icreativerendition.getHeight()).toString());
    }

    public void translateToFWCreativeRenditionAsset(ICreativeRenditionAsset icreativerenditionasset)
    {
    }
}

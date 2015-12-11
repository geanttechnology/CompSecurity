// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tv.freewheel.ad.slot.NonTemporalSlot;
import tv.freewheel.ad.state.VideoInitState;
import tv.freewheel.ad.state.VideoPendingState;
import tv.freewheel.ad.state.VideoPlayingState;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.XMLHandler;

// Referenced classes of package tv.freewheel.ad:
//            EventCallbackHolder, VideoAsset, AdRenderer, AdContext, 
//            AdRequest, Ad, Capabilities, Visitor, 
//            ParametersHolder

public class AdResponse extends EventCallbackHolder
{
    public static final class IllegalAdResponseException extends Exception
    {

        private static final long serialVersionUID = 0x3d96ac5c93766f3L;

        public IllegalAdResponseException(String s)
        {
            super(s);
        }
    }


    public ArrayList ads;
    public ArrayList nonTemporalSlots;
    public HashMap profileParameters;
    public ArrayList temporalSlots;
    public VideoAsset videoAsset;

    public AdResponse(AdContext adcontext)
    {
        super(adcontext);
        ads = new ArrayList();
        temporalSlots = new ArrayList();
        nonTemporalSlots = new ArrayList();
        videoAsset = new VideoAsset(adcontext);
        profileParameters = new HashMap();
    }

    private void parseAdRendererNode(Element element)
    {
        element = element.getChildNodes();
        for (int i = 0; i < element.getLength(); i++)
        {
            Node node = element.item(i);
            if (node.getNodeType() != 1)
            {
                continue;
            }
            String s = node.getNodeName();
            logger.verbose((new StringBuilder()).append("parseAdRendererNode, name: ").append(s).toString());
            if (s.equals("adRenderer"))
            {
                AdRenderer adrenderer = new AdRenderer(context);
                adrenderer.parse((Element)node);
                context.adRenderers.add(adrenderer);
            }
        }

    }

    private void parseAdRenderers(Element element)
    {
        NodeList nodelist = element.getChildNodes();
        element = "";
        for (int i = 0; i < nodelist.getLength();)
        {
            Node node = nodelist.item(i);
            Object obj = element;
            if (node.getNodeType() == 3)
            {
                obj = (new StringBuilder()).append(element).append(node.getNodeValue()).toString();
            }
            i++;
            element = ((Element) (obj));
        }

        logger.verbose((new StringBuilder()).append("parseAdRenderers: ").append(element).toString());
        try
        {
            parseAdRendererNode(XMLHandler.getXMLElementFromString(element, "adRenderers"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Element element)
        {
            logger.warn("parseAdRenderers failed");
        }
        element.printStackTrace();
    }

    private void parseAdSlots(Element element, int i)
        throws IllegalAdResponseException
    {
        NodeList nodelist = element.getChildNodes();
        int j = 0;
        while (j < nodelist.getLength()) 
        {
            Node node = nodelist.item(j);
            if (node.getNodeType() == 1)
            {
                element = node.getNodeName();
                logger.verbose((new StringBuilder()).append("parseAdSlots, name: ").append(element).toString());
                if (element.equals("adSlot"))
                {
                    String s = ((Element)node).getAttribute("customId");
                    NonTemporalSlot nontemporalslot = (NonTemporalSlot)context.getSlotByCustomId(s);
                    element = nontemporalslot;
                    if (nontemporalslot == null)
                    {
                        element = (NonTemporalSlot)getAdRequest().getSlotByCustomId(s);
                        if (element != null)
                        {
                            element = element.copy();
                        } else
                        {
                            element = new NonTemporalSlot(context, i);
                            element.init(s, 0, 0, null, null, true, null, null, 0, null);
                        }
                        nonTemporalSlots.add(element);
                    }
                    element.parse((Element)node);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(element).toString());
                }
            }
            j++;
        }
    }

    private void parseAds(Element element)
    {
        element = element.getChildNodes();
        int i = 0;
        while (i < element.getLength()) 
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1)
            {
                Object obj = node.getNodeName();
                logger.verbose((new StringBuilder()).append("parseAds, name: ").append(((String) (obj))).toString());
                if (((String) (obj)).equals("ad"))
                {
                    obj = new Ad(context);
                    ((Ad) (obj)).parse((Element)node);
                    ads.add(obj);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(((String) (obj))).toString());
                }
            }
            i++;
        }
    }

    private void parseSiteSection(Element element)
        throws IllegalAdResponseException
    {
        element = element.getChildNodes();
        for (int i = 0; i < element.getLength(); i++)
        {
            Node node = element.item(i);
            if (node.getNodeType() != 1)
            {
                continue;
            }
            String s = node.getNodeName();
            if (!s.equals("adSlots"))
            {
                continue;
            }
            logger.verbose((new StringBuilder()).append("parseSiteSection, name: ").append(s).toString());
            if (context.capabilities.getCapability("skipsAdSelection") == 1)
            {
                parseAdSlots((Element)node, 2);
            }
        }

        int j = 0;
        while (j < element.getLength()) 
        {
            Node node1 = element.item(j);
            if (node1.getNodeType() == 1)
            {
                String s1 = node1.getNodeName();
                if (s1.equals("videoPlayer"))
                {
                    logger.verbose((new StringBuilder()).append("parseSiteSection, name: ").append(s1).toString());
                    parseVideoPlayer((Element)node1);
                } else
                if (!s1.equals("adSlots"))
                {
                    logger.warn((new StringBuilder()).append("parseSiteSection, ignore node: ").append(s1).toString());
                }
            }
            j++;
        }
    }

    private void parseVideoPlayer(Element element)
        throws IllegalAdResponseException
    {
        element = element.getChildNodes();
        for (int i = 0; i < element.getLength(); i++)
        {
            Node node = element.item(i);
            if (node.getNodeType() != 1)
            {
                continue;
            }
            String s = node.getNodeName();
            if (!s.equals("adSlots"))
            {
                continue;
            }
            logger.verbose((new StringBuilder()).append("parseVideoPlayer, name: ").append(s).toString());
            if (context.capabilities.getCapability("skipsAdSelection") == 1)
            {
                parseAdSlots((Element)node, 1);
            }
        }

        int j = 0;
        while (j < element.getLength()) 
        {
            Node node1 = element.item(j);
            if (node1.getNodeType() == 1)
            {
                String s1 = node1.getNodeName();
                if (s1.equals("videoAsset"))
                {
                    logger.verbose((new StringBuilder()).append("parseVideoPlayer, name: ").append(s1).toString());
                    videoAsset.parse((Element)node1);
                } else
                if (!s1.equals("adSlots"))
                {
                    logger.warn((new StringBuilder()).append("parseVideoPlayer, ignore node: ").append(s1).toString());
                }
            }
            j++;
        }
    }

    private void parseXmlDocument(Document document)
        throws IllegalAdResponseException
    {
        document = document.getElementsByTagName("adResponse");
        if (document.getLength() == 0)
        {
            throw new IllegalAdResponseException("no root nodeadResponse found in document");
        }
        document = ((Element)document.item(0)).getChildNodes();
        int j = document.getLength();
        int i = 0;
        while (i < j) 
        {
            Node node = document.item(i);
            if (node.getNodeType() == 1)
            {
                logger.verbose((new StringBuilder()).append("parseXMLString: name: ").append(node.getNodeName()).toString());
                String s = node.getNodeName();
                if (s.equals("ads"))
                {
                    if (context.capabilities.getCapability("skipsAdSelection") == 1)
                    {
                        parseAds((Element)node);
                    }
                } else
                if (s.equals("siteSection"))
                {
                    parseSiteSection((Element)node);
                } else
                if (s.equals("eventCallbacks"))
                {
                    if (context.capabilities.getCapability("skipsAdSelection") == 1)
                    {
                        parseEventCallbacks((Element)node);
                    }
                } else
                if (s.equals("rendererManifest"))
                {
                    parseAdRenderers((Element)node);
                } else
                if (s.equals("visitor"))
                {
                    context.visitor.parse((Element)node);
                } else
                if (s.equals("parameters"))
                {
                    profileParameters = ParametersHolder.parseParameters((Element)node);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(s).toString());
                }
            }
            i++;
        }
    }

    public Ad getAd(int i)
    {
        for (Iterator iterator = ads.iterator(); iterator.hasNext();)
        {
            Ad ad = (Ad)iterator.next();
            if (ad.adId == i)
            {
                return ad;
            }
        }

        return null;
    }

    public void onVideoAssetChanged()
    {
        logger.debug("onVideoAssetChanged");
        context.adRequest.videoViewCallbackRequested = false;
        if (videoAsset.state == VideoInitState.Instance())
        {
            videoAsset = new VideoAsset(context);
        } else
        {
            boolean flag = false;
            if (videoAsset.state == VideoPlayingState.Instance() || videoAsset.state == VideoPendingState.Instance())
            {
                flag = true;
                videoAsset.complete();
            }
            videoAsset = new VideoAsset(context);
            if (flag)
            {
                videoAsset.play();
                return;
            }
        }
    }

    public void parse(InputStream inputstream)
        throws IllegalAdResponseException
    {
        Object obj = DocumentBuilderFactory.newInstance();
        try
        {
            obj = ((DocumentBuilderFactory) (obj)).newDocumentBuilder();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IllegalAdResponseException("new DocumentBuilder failed");
        }
        try
        {
            inputstream = ((DocumentBuilder) (obj)).parse(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IllegalAdResponseException("parse xml failed");
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IllegalAdResponseException("IO Error occurred");
        }
        if (context.getActivity() != null)
        {
            parseXmlDocument(inputstream);
            return;
        } else
        {
            logger.warn("host activity is null, won't parse response");
            return;
        }
    }

    public void parse(String s)
        throws IllegalAdResponseException
    {
        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(s.getBytes("UTF-8"));
        s = bytearrayinputstream;
_L2:
        parse(((InputStream) (s)));
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        s = new ByteArrayInputStream(s.getBytes());
        if (true) goto _L2; else goto _L1
_L1:
    }
}

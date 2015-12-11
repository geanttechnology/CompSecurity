// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import tv.freewheel.hybrid.ad.interfaces.IEvent;
import tv.freewheel.hybrid.ad.interfaces.IEventListener;
import tv.freewheel.hybrid.ad.slot.NonTemporalSlot;
import tv.freewheel.hybrid.ad.slot.Slot;
import tv.freewheel.hybrid.ad.slot.TemporalSlot;
import tv.freewheel.hybrid.utils.Logger;
import tv.freewheel.hybrid.utils.URLLoader;
import tv.freewheel.hybrid.utils.XMLElement;
import tv.freewheel.hybrid.utils.XMLHandler;

// Referenced classes of package tv.freewheel.hybrid.ad:
//            AdContextScoped, AdContext, Capabilities, Visitor, 
//            AdResponse, VideoAsset

public class AdRequest extends AdContextScoped
{

    public HashMap globalLevelParameters;
    private TreeMap keyValues;
    private ArrayList nonTemporalSlots;
    public HashMap overrideLevelParameters;
    private double requestDuration;
    private String requestMode;
    private String ssCustomId;
    private int ssFallbackId;
    private String ssId;
    private int ssNetworkId;
    private int ssPageViewRandom;
    private int subsessionToken;
    private ArrayList temporalSlots;
    private int vaAutoPlayType;
    private String vaCustomId;
    private double vaDuration;
    private String vaDurationType;
    private int vaFallbackId;
    private String vaId;
    protected String vaMediaLocation;
    private int vaNetworkId;
    private double vaVideoAssetCurrentTimePosition;
    private int vaVideoPlayRandom;
    protected boolean videoViewCallbackRequested;
    private IEventListener videoViewCompleteListener;
    private IEventListener videoViewTestListener;
    private int vpNetworkId;

    public AdRequest(AdContext adcontext)
    {
        super(adcontext);
        requestMode = "";
        vaDurationType = "";
        vaAutoPlayType = 1;
        videoViewCallbackRequested = false;
        videoViewTestListener = null;
        videoViewCompleteListener = new IEventListener() {

            final AdRequest this$0;

            public void run(IEvent ievent)
            {
                Object obj = (String)ievent.getData().get("message");
                logger.verbose((new StringBuilder()).append("got response: ").append(((String) (obj))).toString());
                try
                {
                    AdResponse adresponse = new AdResponse(context);
                    adresponse.parse(((String) (obj)));
                    context.adResponse.videoAsset.callbackHandler = adresponse.videoAsset.callbackHandler;
                    adresponse.videoAsset.callbackHandler = null;
                    context.adResponse.videoAsset.play();
                    obj = videoViewTestListener;
                }
                // Misplaced declaration of an exception variable
                catch (IEvent ievent)
                {
                    logger.error("failed to parse response for videoView request");
                    return;
                }
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_130;
                }
                ((IEventListener) (obj)).run(ievent);
            }

            
            {
                this$0 = AdRequest.this;
                super();
            }
        };
        keyValues = new TreeMap();
        temporalSlots = new ArrayList();
        nonTemporalSlots = new ArrayList();
        globalLevelParameters = new HashMap();
        overrideLevelParameters = new HashMap();
    }

    private XMLElement buildKeyValuesElement()
    {
        XMLElement xmlelement = new XMLElement("keyValues");
        for (Iterator iterator = keyValues.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            Iterator iterator1 = ((TreeSet)keyValues.get(s)).iterator();
            while (iterator1.hasNext()) 
            {
                XMLElement xmlelement1 = new XMLElement("keyValue");
                xmlelement1.setAttribute("key", s);
                xmlelement1.setAttribute("value", (String)iterator1.next());
                xmlelement.appendChild(xmlelement1);
            }
        }

        return xmlelement;
    }

    private XMLElement buildSiteSectionElement()
    {
        XMLElement xmlelement = new XMLElement("siteSection");
        xmlelement.setAttribute("customId", ssCustomId);
        xmlelement.setAttribute("id", ssId);
        xmlelement.setAttribute("fallbackId", ssFallbackId, true);
        xmlelement.setAttribute("pageViewRandom", ssPageViewRandom, true);
        xmlelement.setAttribute("siteSectionNetworkId", ssNetworkId, true);
        XMLElement xmlelement1 = new XMLElement("videoPlayer");
        xmlelement1.setAttribute("videoPlayerNetworkId", vpNetworkId, true);
        xmlelement1.appendChild(buildVideoAssetElement());
        XMLElement xmlelement2 = new XMLElement("adSlots");
        xmlelement2.setAttribute("defaultSlotProfile", context.defaultVideoPlayerSlotProfile);
        if (context.capabilities.getCapability("skipsAdSelection") == 1)
        {
            Iterator iterator1 = nonTemporalSlots.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                NonTemporalSlot nontemporalslot1 = (NonTemporalSlot)iterator1.next();
                if (nontemporalslot1.type == 1)
                {
                    xmlelement2.appendChild(nontemporalslot1.buildXMLElement());
                }
            } while (true);
        }
        xmlelement1.appendChild(xmlelement2);
        xmlelement.appendChild(xmlelement1);
        xmlelement1 = new XMLElement("adSlots");
        xmlelement1.setAttribute("defaultSlotProfile", context.defaultSiteSectionSlotProfile);
        if (context.capabilities.getCapability("skipsAdSelection") == 1)
        {
            Iterator iterator = nonTemporalSlots.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                NonTemporalSlot nontemporalslot = (NonTemporalSlot)iterator.next();
                if (nontemporalslot.type == 2)
                {
                    xmlelement1.appendChild(nontemporalslot.buildXMLElement());
                }
            } while (true);
        }
        xmlelement.appendChild(xmlelement1);
        return xmlelement;
    }

    private XMLElement buildVideoAssetElement()
    {
        XMLElement xmlelement = new XMLElement("videoAsset");
        xmlelement.setAttribute("customId", vaCustomId);
        xmlelement.setAttribute("id", vaId);
        xmlelement.setAttribute("fallbackId", vaFallbackId, true);
        xmlelement.setAttribute("mediaLocation", vaMediaLocation);
        xmlelement.setAttribute("duration", vaDuration, true);
        xmlelement.setAttribute("videoAssetNetworkId", vaNetworkId, true);
        xmlelement.setAttribute("videoPlayRandom", vaVideoPlayRandom, true);
        XMLElement xmlelement1;
        boolean flag;
        if (vaAutoPlayType != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        xmlelement.setAttribute("autoPlay", flag);
        xmlelement.setAttribute("currentTimePosition", vaVideoAssetCurrentTimePosition, true);
        xmlelement.setAttribute("requestDuration", requestDuration, true);
        if (vaDurationType != null && vaDurationType.length() != 0)
        {
            xmlelement.setAttribute("durationType", vaDurationType);
        }
        if (vaAutoPlayType == 2)
        {
            xmlelement.setAttribute("unattendedPlay", true);
        }
        xmlelement1 = new XMLElement("adSlots");
        xmlelement1.setAttribute("defaultSlotProfile", context.defaultTemporalSlotProfile);
        xmlelement1.setAttribute("compatibleDimensions", context.getScreenDimensionStr());
        if (context.capabilities.getCapability("skipsAdSelection") == 1)
        {
            for (Iterator iterator = temporalSlots.iterator(); iterator.hasNext(); xmlelement1.appendChild(((TemporalSlot)iterator.next()).buildXMLElement())) { }
            xmlelement.appendChild(xmlelement1);
        }
        return xmlelement;
    }

    public void addKeyValue(String s, String s1)
    {
        if (s == null || s.trim().length() == 0 || s1 == null)
        {
            return;
        }
        TreeSet treeset1 = (TreeSet)keyValues.get(s);
        TreeSet treeset = treeset1;
        if (treeset1 == null)
        {
            treeset = new TreeSet();
            keyValues.put(s, treeset);
        }
        treeset.add(s1);
    }

    public XMLElement buildXMLElement()
    {
        XMLElement xmlelement = new XMLElement("adRequest");
        xmlelement.setAttribute("networkId", context.networkId);
        xmlelement.setAttribute("version", "1");
        xmlelement.setAttribute("profile", context.playerProfile);
        if (requestMode != null && requestMode.length() != 0)
        {
            xmlelement.setAttribute("mode", requestMode);
        }
        if (subsessionToken > 0)
        {
            xmlelement.setAttribute("subsessionToken", subsessionToken);
        }
        xmlelement.appendChild(context.capabilities.buildXMLElement());
        xmlelement.appendChild(context.visitor.buildXMLElement());
        xmlelement.appendChild(buildKeyValuesElement());
        xmlelement.appendChild(buildSiteSectionElement());
        return xmlelement;
    }

    public Slot getSlotByCustomId(String s)
    {
        for (Iterator iterator = temporalSlots.iterator(); iterator.hasNext();)
        {
            Slot slot = (Slot)iterator.next();
            if (s.equals(slot.customId))
            {
                return slot;
            }
        }

        for (Iterator iterator1 = nonTemporalSlots.iterator(); iterator1.hasNext();)
        {
            Slot slot1 = (Slot)iterator1.next();
            if (s.equals(slot1.customId))
            {
                return slot1;
            }
        }

        return null;
    }

    public boolean hasSetVideoAssetId()
    {
        return vaId != null || vaCustomId != null;
    }

    public boolean hasVideoAsset()
    {
        return vaId != null || vaCustomId != null;
    }

    public void requestVideoView()
    {
        logger.debug("will send videoView request");
        if (!videoViewCallbackRequested)
        {
            videoViewCallbackRequested = true;
            context.setCapability("skipsAdSelection", 0);
            context.setCapability("requiresVideoCallbackUrl", 0);
            if (!context.serverUrl.matches("^\\w+:.*"))
            {
                logger.verbose((new StringBuilder()).append("requestVideoView: ").append(context.serverUrl).toString());
                (new Thread() {

                    final AdRequest this$0;

                    public void run()
                    {
                        Object obj;
                        try
                        {
                            obj = new FileInputStream(new File(context.serverUrl));
                            AdResponse adresponse = new AdResponse(context);
                            adresponse.parse(((java.io.InputStream) (obj)));
                            context.adResponse.videoAsset.callbackHandler = adresponse.videoAsset.callbackHandler;
                            adresponse.videoAsset.callbackHandler = null;
                            context.adResponse.videoAsset.play();
                            obj = videoViewTestListener;
                        }
                        catch (FileNotFoundException filenotfoundexception)
                        {
                            logger.error("file not found");
                            return;
                        }
                        catch (AdResponse.IllegalAdResponseException illegaladresponseexception)
                        {
                            logger.error((new StringBuilder()).append("file not well formatted ").append(illegaladresponseexception.getMessage()).toString());
                            return;
                        }
                        if (obj == null)
                        {
                            break MISSING_BLOCK_LABEL_111;
                        }
                        ((IEventListener) (obj)).run(null);
                    }

            
            {
                this$0 = AdRequest.this;
                super();
            }
                }).start();
                return;
            }
            tv.freewheel.hybrid.utils.URLRequest urlrequest = context.buildRequest();
            if (urlrequest != null)
            {
                URLLoader urlloader = new URLLoader();
                urlloader.addEventListener("URLLoader.Load.Complete", videoViewCompleteListener);
                urlloader.load(urlrequest);
                return;
            }
        }
    }

    public void setAdRequest(AdRequest adrequest)
    {
        requestMode = adrequest.requestMode;
        requestDuration = adrequest.requestDuration;
        subsessionToken = adrequest.subsessionToken;
        ssId = adrequest.ssId;
        ssCustomId = adrequest.ssCustomId;
        ssPageViewRandom = adrequest.ssPageViewRandom;
        ssNetworkId = adrequest.ssNetworkId;
        ssFallbackId = adrequest.ssFallbackId;
        vaId = adrequest.vaId;
        vaCustomId = adrequest.vaCustomId;
        vaFallbackId = adrequest.vaFallbackId;
        vaMediaLocation = adrequest.vaMediaLocation;
        vaDuration = adrequest.vaDuration;
        vaNetworkId = adrequest.vaNetworkId;
        vaVideoPlayRandom = adrequest.vaVideoPlayRandom;
        vaAutoPlayType = adrequest.vaAutoPlayType;
        vaDurationType = adrequest.vaDurationType;
        vaVideoAssetCurrentTimePosition = adrequest.vaVideoAssetCurrentTimePosition;
        vpNetworkId = adrequest.vpNetworkId;
        videoViewCallbackRequested = adrequest.videoViewCallbackRequested;
    }

    public void setParameter(String s, Object obj, int i)
    {
        HashMap hashmap;
        if (s == null)
        {
            return;
        }
        switch (i)
        {
        default:
            logger.warn((new StringBuilder()).append("can not set parameter for level ").append(i).toString());
            return;

        case 5: // '\005'
            break MISSING_BLOCK_LABEL_78;

        case 1: // '\001'
            hashmap = globalLevelParameters;
            break;
        }
_L1:
        if (obj == null)
        {
            hashmap.remove(s);
            return;
        } else
        {
            hashmap.put(s, obj);
            return;
        }
        hashmap = overrideLevelParameters;
          goto _L1
    }

    public String toXML()
        throws IllegalArgumentException, IllegalStateException, IOException
    {
        return XMLHandler.createXMLDocument(buildXMLElement());
    }

}

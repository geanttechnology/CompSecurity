// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad;

import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.hybrid.ad.handler.VideoViewCallbackHandler;
import tv.freewheel.hybrid.ad.slot.TemporalSlot;
import tv.freewheel.hybrid.ad.state.VideoInitState;
import tv.freewheel.hybrid.ad.state.VideoState;
import tv.freewheel.hybrid.utils.Logger;
import tv.freewheel.hybrid.utils.RecordTimer;

// Referenced classes of package tv.freewheel.hybrid.ad:
//            EventCallbackHolder, AdContext, AdRequest, Capabilities, 
//            AdResponse

public class VideoAsset extends EventCallbackHolder
{

    public VideoViewCallbackHandler callbackHandler;
    public VideoState state;
    public RecordTimer timer;

    public VideoAsset(AdContext adcontext)
    {
        super(adcontext);
        state = VideoInitState.Instance();
    }

    public boolean isReadyToStart()
    {
        if (callbackHandler == null)
        {
            timer = new RecordTimer();
            if (context.adRequest.hasSetVideoAssetId())
            {
                context.adRequest.requestVideoView();
            }
            return false;
        } else
        {
            return true;
        }
    }

    public void onResumePlay()
    {
        logger.debug("onResumePlay");
        if (callbackHandler == null)
        {
            timer.resume();
            return;
        } else
        {
            callbackHandler.resume();
            return;
        }
    }

    public void onStartPlay()
    {
        logger.debug("onStartPlay");
        long l = 0L;
        if (timer != null)
        {
            l = timer.tick();
        }
        callbackHandler.start(l);
    }

    public void parse(Element element)
        throws AdResponse.IllegalAdResponseException
    {
        element = element.getChildNodes();
        int i = 0;
        while (i < element.getLength()) 
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1)
            {
                String s = node.getNodeName();
                logger.verbose((new StringBuilder()).append("parse(), name: ").append(s).toString());
                if (s.equals("adSlots"))
                {
                    if (context.capabilities.getCapability("skipsAdSelection") == 1)
                    {
                        parseTemporalAdSlots((Element)node);
                    }
                } else
                if (s.equals("eventCallbacks"))
                {
                    parseEventCallbacks((Element)node);
                    if (callbackHandler == null)
                    {
                        callbackHandler = (VideoViewCallbackHandler)createEventHandler("videoView", "IMPRESSION", false);
                    }
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(s).toString());
                }
            }
            i++;
        }
    }

    public void parseTemporalAdSlots(Element element)
        throws AdResponse.IllegalAdResponseException
    {
        NodeList nodelist = element.getChildNodes();
        int i = 0;
        while (i < nodelist.getLength()) 
        {
            element = nodelist.item(i);
            if (element.getNodeType() == 1)
            {
                Object obj = element.getNodeName();
                logger.verbose((new StringBuilder()).append("parseTemporalAdSlots(), name: ").append(((String) (obj))).toString());
                if (((String) (obj)).equals("temporalAdSlot"))
                {
                    obj = (Element)element;
                    element = ((Element) (obj)).getAttribute("customId");
                    logger.debug((new StringBuilder()).append("adding new TemporalSlot:").append(element).append(" to collection:").append(getAdResponse().temporalSlots.toString()).append(", context: ").append(context.toString()).toString());
                    element = (TemporalSlot)getAdRequest().getSlotByCustomId(element);
                    if (element != null)
                    {
                        element = element.copy();
                    } else
                    {
                        element = new TemporalSlot(context, 0);
                    }
                    element.parse(((Element) (obj)));
                    getAdResponse().temporalSlots.add(element);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(((String) (obj))).toString());
                }
            }
            i++;
        }
    }

    public void play()
    {
        logger.debug("play");
        state.play(this);
    }
}

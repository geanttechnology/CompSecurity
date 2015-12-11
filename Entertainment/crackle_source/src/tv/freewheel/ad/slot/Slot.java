// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.slot;

import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.ad.AdChain;
import tv.freewheel.ad.AdContext;
import tv.freewheel.ad.AdInstance;
import tv.freewheel.ad.EventCallbackHolder;
import tv.freewheel.ad.XMLObject;
import tv.freewheel.ad.handler.SlotImpressionCallbackHandler;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.ad.state.SlotEndedState;
import tv.freewheel.ad.state.SlotInitState;
import tv.freewheel.ad.state.SlotPauseState;
import tv.freewheel.ad.state.SlotPlayingState;
import tv.freewheel.ad.state.SlotPreloadingState;
import tv.freewheel.ad.state.SlotState;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.XMLElement;
import tv.freewheel.utils.events.Event;

public class Slot extends EventCallbackHolder
    implements XMLObject, ISlot
{

    public String acceptContentType;
    public String acceptPrimaryContentType;
    public ArrayList adChains;
    public String adUnit;
    public SlotImpressionCallbackHandler callbackHandler;
    public AdInstance currentPlayingAdInstance;
    public String customId;
    protected ViewGroup displayBase;
    public int height;
    private double lastPlayheadTime;
    public HashMap parameters;
    public boolean requestContentPause;
    public String slotProfile;
    public SlotState state;
    public int timePositionClass;
    public int type;
    public int width;

    public Slot(AdContext adcontext, int i)
    {
        super(adcontext);
        lastPlayheadTime = 0.0D;
        type = i;
        parameters = new HashMap();
        state = SlotInitState.Instance();
        requestContentPause = false;
        adChains = new ArrayList();
    }

    protected static XMLElement buildContentTypeElement(String as[], String as1[])
    {
        XMLElement xmlelement = new XMLElement("contentTypes");
        int k = as.length;
        for (int i = 0; i < k; i++)
        {
            XMLElement xmlelement1 = new XMLElement("acceptPrimaryContentType");
            xmlelement1.setAttribute("contentTypeId", as[i].trim());
            xmlelement.appendChild(xmlelement1);
        }

        k = as1.length;
        for (int j = 0; j < k; j++)
        {
            as = new XMLElement("acceptContentType");
            as.setAttribute("contentTypeId", as1[j].trim());
            xmlelement.appendChild(as);
        }

        return xmlelement;
    }

    private AdInstance findNextPlayableAd(AdInstance adinstance)
    {
        logger.debug((new StringBuilder()).append(this).append(" findNextPlayableAd() from:").append(adinstance).toString());
        AdInstance adinstance1 = null;
        int i;
        if (adinstance != null)
        {
            i = adChains.indexOf(adinstance.adChain);
        } else
        {
            i = 0;
        }
        logger.debug((new StringBuilder()).append(this).append(" findNextPlayableAd() look from chain index ").append(i).append(" chain size:").append(adChains.size()).toString());
        do
        {
label0:
            {
                if (i < adChains.size())
                {
                    adinstance1 = ((AdChain)adChains.get(i)).findNextPlayableAd(adinstance);
                    if (adinstance1 == null)
                    {
                        break label0;
                    }
                }
                logger.debug((new StringBuilder()).append(this).append(" findNextPlayableAd() returning ").append(adinstance1).toString());
                return adinstance1;
            }
            i++;
        } while (true);
    }

    private void parseSelectedAds(Element element)
        throws tv.freewheel.ad.AdResponse.IllegalAdResponseException
    {
        element = element.getChildNodes();
        int i = 0;
        while (i < element.getLength()) 
        {
            Object obj = element.item(i);
            if (((Node) (obj)).getNodeType() == 1)
            {
                Object obj1 = ((Node) (obj)).getNodeName();
                logger.verbose((new StringBuilder()).append("parse(), name: ").append(((String) (obj1))).toString());
                if (((String) (obj1)).equals("adReference"))
                {
                    obj1 = new AdInstance(context);
                    obj1.slot = this;
                    ((AdInstance) (obj1)).parse((Element)obj);
                    obj = ((AdInstance) (obj1)).buildAdChain();
                    adChains.add(obj);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(((String) (obj1))).toString());
                }
            }
            i++;
        }
    }

    public static String slotTypeString(int i)
    {
        switch (i)
        {
        default:
            return "";

        case 1: // '\001'
            return "preroll";

        case 2: // '\002'
            return "midroll";

        case 3: // '\003'
            return "postroll";

        case 4: // '\004'
            return "overlay";

        case 5: // '\005'
            return "display";

        case 6: // '\006'
            return "pause_midroll";
        }
    }

    public XMLElement buildXMLElement()
    {
        return null;
    }

    protected XMLElement buildXMLElement(XMLElement xmlelement)
    {
        xmlelement.setAttribute("slotProfile", slotProfile);
        xmlelement.setAttribute("customId", customId);
        if (!adUnit.equals("UNKNOWN"))
        {
            xmlelement.setAttribute("adUnit", adUnit);
        }
        String as1[] = new String[0];
        String as[] = as1;
        if ((acceptPrimaryContentType == null || acceptPrimaryContentType.equals("")) && (context.playerProfile == null || context.playerProfile.equals("")) && (type == 1 && (context.defaultVideoPlayerSlotProfile == null || context.defaultVideoPlayerSlotProfile.equals("")) || type == 2 && (context.defaultSiteSectionSlotProfile == null || context.defaultSiteSectionSlotProfile.equals(""))))
        {
            acceptPrimaryContentType = "text/html_doc_lit_mobile";
        }
        if (acceptPrimaryContentType != null)
        {
            as1 = acceptPrimaryContentType.split(",");
        }
        if (acceptContentType != null)
        {
            as = acceptContentType.split(",");
        }
        if (as1.length > 0 || as.length > 0)
        {
            xmlelement.appendChild(buildContentTypeElement(as1, as));
        }
        return xmlelement;
    }

    public Slot copy()
    {
        Slot slot = null;
        Slot slot1 = (Slot)getClass().getConstructor(new Class[] {
            tv/freewheel/ad/AdContext, Integer.TYPE
        }).newInstance(new Object[] {
            context, Integer.valueOf(type)
        });
        slot = slot1;
_L2:
        slot.width = width;
        slot.height = height;
        slot.customId = customId;
        slot.adUnit = adUnit;
        slot.slotProfile = slotProfile;
        slot.timePositionClass = timePositionClass;
        slot.acceptContentType = acceptContentType;
        slot.acceptPrimaryContentType = acceptPrimaryContentType;
        return slot;
        Exception exception;
        exception;
        exception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void dispatchSlotEvent(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("message", customId);
        hashmap.put("customId", customId);
        context.dispatchEvent(new Event(s, hashmap));
    }

    protected AdInstance findNextAdToWork(AdInstance adinstance)
    {
        logger.debug((new StringBuilder()).append(this).append(" findNextAdToWork() from:").append(adinstance).toString());
        if (adinstance == null)
        {
            return findNextPlayableAd(null);
        }
        if (adinstance.slot != this)
        {
            logger.error((new StringBuilder()).append(this).append("findNextAdToWork() AdInstance ").append(adinstance).append(" does not belong to slot ").append(this).toString());
            return null;
        }
        AdInstance adinstance1 = null;
        if (state == adinstance.adChain.relatedSlotState())
        {
            adinstance1 = adinstance;
            if (adinstance.adChain.isChainStopper(adinstance))
            {
                logger.debug((new StringBuilder()).append(this).append(" findNextAdToWork() met chain stopper ").append(adinstance).toString());
                adinstance1 = adinstance.adChain.getLastAdInstanceInChain();
            }
            adinstance = findNextPlayableAd(adinstance1);
        } else
        {
            logger.debug((new StringBuilder()).append(this).append("findNextAdToWork() slot state is not ").append(adinstance.adChain.relatedSlotState()).append(", so won't continue").toString());
            adinstance = adinstance1;
        }
        logger.debug((new StringBuilder()).append(this).append("findNextAdToWork() returning ").append(adinstance).toString());
        return adinstance;
    }

    public ArrayList getAdInstances()
    {
        return new ArrayList();
    }

    public ArrayList getAdInstancesInPlayPlan()
    {
        return getAdInstancesInPlayPlan(false);
    }

    public ArrayList getAdInstancesInPlayPlan(boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = adChains.iterator();
        do
        {
            boolean flag1 = false;
            if (iterator.hasNext())
            {
                Iterator iterator1 = ((AdChain)iterator.next()).adInstances.iterator();
                while (iterator1.hasNext()) 
                {
                    AdInstance adinstance = (AdInstance)iterator1.next();
                    boolean flag2 = flag1;
                    if (!flag1)
                    {
                        flag2 = flag1;
                        if (adinstance.isPlayable())
                        {
                            flag2 = flag1;
                            if (!adinstance.scheduledDrivingAd)
                            {
                                arraylist.add(adinstance);
                                flag2 = true;
                            }
                        }
                    }
                    flag1 = flag2;
                    if (flag)
                    {
                        flag1 = flag2;
                        if (adinstance.scheduledDrivingAd)
                        {
                            arraylist.add(adinstance);
                            flag1 = flag2;
                        }
                    }
                }
            } else
            {
                logger.debug((new StringBuilder()).append(this).append(" getAdInstancesInPlayPlan() withTranslator:").append(flag).append(", returning ").append(arraylist).toString());
                return arraylist;
            }
        } while (true);
    }

    public ViewGroup getBase()
    {
        return null;
    }

    public String getCustomId()
    {
        return customId;
    }

    public double getEmbeddedAdsDuration()
    {
        return -1D;
    }

    public double getEndTimePosition()
    {
        return -1D;
    }

    public int getHeight()
    {
        return height;
    }

    public double getPlayheadTime()
    {
        if (state != SlotInitState.Instance()) goto _L2; else goto _L1
_L1:
        lastPlayheadTime = 0.0D;
_L4:
        return lastPlayheadTime;
_L2:
        double d;
        double d2;
        Iterator iterator;
        if (state == SlotEndedState.Instance())
        {
            lastPlayheadTime = getTotalDuration();
            continue; /* Loop/switch isn't completed */
        }
        if (currentPlayingAdInstance == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        d2 = currentPlayingAdInstance.getPlayheadTime();
        d = 0.0D;
        iterator = getAdInstancesInPlayPlan().iterator();
_L5:
        AdInstance adinstance;
label0:
        {
            if (iterator.hasNext())
            {
                adinstance = (AdInstance)iterator.next();
                if (adinstance != currentPlayingAdInstance)
                {
                    break label0;
                }
            }
            double d1 = getTotalDuration();
            d += d2;
            if (d > d1)
            {
                d = d1;
            }
            lastPlayheadTime = d;
        }
        if (true) goto _L4; else goto _L3
_L3:
        d += adinstance.getDuration();
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public double getTimePosition()
    {
        return -1D;
    }

    public int getTimePositionClass()
    {
        return timePositionClass;
    }

    public double getTotalDuration()
    {
        double d = 0.0D;
        for (Iterator iterator = getAdInstancesInPlayPlan().iterator(); iterator.hasNext();)
        {
            d += ((AdInstance)iterator.next()).getDuration();
        }

        return d;
    }

    public int getType()
    {
        return type;
    }

    public int getWidth()
    {
        return width;
    }

    public void init(String s, String s1, String s2, String s3, String s4)
    {
        customId = s;
        adUnit = s1;
        slotProfile = s2;
        acceptContentType = s3;
        acceptPrimaryContentType = s4;
        if (adUnit == null)
        {
            adUnit = "UNKNOWN";
        }
        setTimePositionClass(adUnit);
    }

    public boolean isPauseMidroll()
    {
        return timePositionClass == 6;
    }

    public boolean isPlaying()
    {
        return state == SlotPlayingState.Instance();
    }

    public void notifyAdDone(AdInstance adinstance)
    {
        AdInstance adinstance1;
        logger.debug((new StringBuilder()).append(this).append(" notifyAdDone() ").append(adinstance).toString());
        adinstance1 = findNextAdToWork(adinstance);
        if (adinstance1 == null) goto _L2; else goto _L1
_L1:
        logger.debug((new StringBuilder()).append(this).append(" notifyAdDone() found next ad ").append(adinstance1).toString());
        if (state != SlotPreloadingState.Instance()) goto _L4; else goto _L3
_L3:
        adinstance1.preload();
_L6:
        return;
_L4:
        if (state == SlotPlayingState.Instance())
        {
            currentPlayingAdInstance = adinstance1;
            adinstance1.play();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        logger.debug((new StringBuilder()).append(this).append(" notifyAdDone() no more ad to work on").toString());
        if (state == SlotPreloadingState.Instance())
        {
            dispatchSlotEvent("slotPreloaded");
            return;
        }
        if ((state == SlotPlayingState.Instance() || state == SlotPauseState.Instance() || state == SlotEndedState.Instance()) && adinstance.adChain.relatedSlotState() == SlotPlayingState.Instance())
        {
            state.complete(this);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onComplete()
    {
        logger.info("onComplete");
        currentPlayingAdInstance = null;
        dispatchSlotEvent("slotEnded");
    }

    public void onPausePlay()
    {
        logger.info("onPausePlay");
        if (currentPlayingAdInstance != null)
        {
            currentPlayingAdInstance.pause();
        }
    }

    public void onPreloading()
    {
        logger.debug("onPreloading");
        AdInstance adinstance = findNextAdToWork(null);
        if (adinstance != null)
        {
            adinstance.preload();
            return;
        } else
        {
            dispatchSlotEvent("slotPreloaded");
            return;
        }
    }

    public void onResumePlay()
    {
        logger.info("onResumePlay");
        if (currentPlayingAdInstance != null)
        {
            currentPlayingAdInstance.resume();
        }
    }

    public void onStartPlay()
    {
        logger.info("onStartPlay");
        if (callbackHandler != null)
        {
            callbackHandler.send();
        }
        dispatchSlotEvent("slotStarted");
        playAd();
    }

    public void onStopPlay()
    {
        logger.info("onStopPlay");
        if (currentPlayingAdInstance != null)
        {
            currentPlayingAdInstance.stop();
        }
    }

    public void parse(Element element)
        throws tv.freewheel.ad.AdResponse.IllegalAdResponseException
    {
        customId = element.getAttribute("customId");
        adUnit = element.getAttribute("adUnit");
        element = element.getChildNodes();
        int i = 0;
        while (i < element.getLength()) 
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1)
            {
                String s = node.getNodeName();
                if (s.equals("selectedAds"))
                {
                    parseSelectedAds((Element)node);
                } else
                if (s.equals("eventCallbacks"))
                {
                    parseEventCallbacks((Element)node);
                    callbackHandler = (SlotImpressionCallbackHandler)createEventHandler("slotImpression", "IMPRESSION", false);
                    callbackHandler.setSlot(this);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(s).toString());
                }
            }
            i++;
        }
    }

    public void pause()
    {
        logger.debug("pause");
    }

    public void play()
    {
        state.play(this);
    }

    public void playAd()
    {
        logger.info("playAd");
        currentPlayingAdInstance = findNextAdToWork(null);
        if (currentPlayingAdInstance != null)
        {
            currentPlayingAdInstance.play();
            return;
        } else
        {
            logger.warn("no playable ad");
            state.complete(this);
            return;
        }
    }

    public void preload()
    {
        state.preload(this);
    }

    public void resume()
    {
        logger.debug("resume");
    }

    public void setParameter(String s, Object obj)
    {
        logger.debug((new StringBuilder()).append("setParameter(name:").append(s).append(" value:").append(obj).append(") ").append(this).toString());
        if (s == null)
        {
            return;
        }
        if (obj == null)
        {
            parameters.remove(s);
            return;
        } else
        {
            parameters.put(s, obj);
            return;
        }
    }

    protected void setTimePositionClass(String s)
    {
    }

    public void stop()
    {
        state.stop(this);
    }

    public String toString()
    {
        return (new StringBuilder()).append("[Slot:").append(customId).append(", timePositionClass: ").append(timePositionClass).append(", state: ").append(state).append("]").toString();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.ad.handler.ClickCallbackHandler;
import tv.freewheel.ad.handler.ErrorCallbackHandler;
import tv.freewheel.ad.handler.EventCallbackHandler;
import tv.freewheel.ad.handler.QuartileCallbackHandler;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.ad.interfaces.ICreativeRenditionAsset;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.ad.slot.NonTemporalSlot;
import tv.freewheel.ad.slot.Slot;
import tv.freewheel.ad.state.AdFailedState;
import tv.freewheel.ad.state.AdInitState;
import tv.freewheel.ad.state.AdLoadedState;
import tv.freewheel.ad.state.AdState;
import tv.freewheel.ad.state.RendererInitState;
import tv.freewheel.ad.state.RendererState;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.events.Event;

// Referenced classes of package tv.freewheel.ad:
//            EventCallbackHolder, CallbackManager, AdRenderer, AdChain, 
//            CreativeRendition, Ad, AdContext, AdRequest, 
//            AdResponse, EventCallback, Creative, ChainBehavior, 
//            InternalConstants

public class AdInstance extends EventCallbackHolder
    implements IAdInstance, IRendererContext
{

    public Ad ad;
    public AdChain adChain;
    private AdRenderer adRenderer;
    private String additionalErrorInfo;
    public CallbackManager callbackManager;
    public ArrayList companionAds;
    public Creative creative;
    public int creativeRenditionId;
    private double duration;
    private ArrayList fallbackAds;
    public boolean imprSent;
    public boolean isCompanionAdOfPauseAd;
    private int metrValue;
    public boolean pauseWhenLoading;
    private CreativeRendition primaryCreativeRendition;
    public IRenderer renderer;
    protected final Handler rendererLoadHandler = new Handler(getActivity().getMainLooper()) {

        final AdInstance this$0;

        public void handleMessage(Message message)
        {
            String s = message.getData().getString("CODE");
            message = message.getData().getString("MSG");
            logger.debug((new StringBuilder()).append("renderer load complete code:").append(s).append(" msg:").append(message).toString());
            if (s.equals("ERROR"))
            {
                additionalErrorInfo = message;
            }
            state.notifyRendererModuleLoaded(AdInstance.this);
        }

            
            {
                this$0 = AdInstance.this;
                super(looper);
            }
    };
    public RendererState rendererState;
    public int replicaId;
    private boolean resellerNoAdDispatched;
    public boolean scheduledDrivingAd;
    public Slot slot;
    public AdState state;
    private ArrayList translatedAds;

    public AdInstance(AdContext adcontext)
    {
        super(adcontext);
        isCompanionAdOfPauseAd = false;
        additionalErrorInfo = "";
        duration = -1D;
        resellerNoAdDispatched = false;
        imprSent = false;
        scheduledDrivingAd = false;
        pauseWhenLoading = false;
        state = AdInitState.Instance();
        companionAds = new ArrayList();
        fallbackAds = new ArrayList();
        metrValue = 0;
        callbackManager = new CallbackManager(this);
    }

    private void commitAdInstances()
    {
        Object obj2;
label0:
        {
            logger.debug((new StringBuilder()).append(this).append(" commitAdInstances()").toString());
            if (translatedAds == null || translatedAds.size() == 0)
            {
                logger.debug((new StringBuilder()).append(this).append("commitAdInstances() nothing to commit, translatedAds is empty.").toString());
                return;
            }
            Object obj = null;
            obj2 = obj;
            if (!adRenderer.isTranslator())
            {
                break label0;
            }
            Iterator iterator = translatedAds.iterator();
            do
            {
                obj2 = obj;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                obj2 = (AdInstance)iterator.next();
            } while (((AdInstance) (obj2)).getSlot() != getSlot());
            logger.debug((new StringBuilder()).append("committing driving ad ").append(obj2).toString());
            adChain.insertAfter(((AdInstance) (obj2)), this);
            scheduledDrivingAd = true;
        }
        Object obj1 = obj2;
        if (obj2 == null)
        {
            if (adRenderer.isTranslator())
            {
                obj2 = (AdInstance)cloneForTranslation();
                obj1 = (CreativeRendition)((AdInstance) (obj2)).createCreativeRenditionForTranslation();
                ((CreativeRendition) (obj1)).setContentType("null/null");
                obj2.primaryCreativeRendition = ((CreativeRendition) (obj1));
                adChain.insertAfter(((AdInstance) (obj2)), this);
                obj1 = obj2;
                scheduledDrivingAd = true;
                logger.debug((new StringBuilder()).append("committing empty driving ad ").append(((AdInstance) (obj2)).ad.noLoad).toString());
            } else
            {
                obj1 = this;
            }
        }
        obj2 = translatedAds.iterator();
        do
        {
            if (!((Iterator) (obj2)).hasNext())
            {
                break;
            }
            AdInstance adinstance1 = (AdInstance)((Iterator) (obj2)).next();
            if (obj1 != adinstance1)
            {
                if (adinstance1.slot.getType() != 0)
                {
                    logger.debug((new StringBuilder()).append("commitAdInstances: committing companion ad: ").append(adinstance1).toString());
                    if (adinstance1.getAllCreativeRenditions().isEmpty())
                    {
                        adinstance1.ad.noLoad = true;
                    }
                    ((AdInstance) (obj1)).companionAds.add(adinstance1);
                } else
                {
                    logger.error("commitAdInstances: got a translated ad which is neither driving nor nontemporal.");
                }
            }
        } while (true);
        for (int i = 0; i < companionAds.size(); i++)
        {
            AdInstance adinstance = (AdInstance)companionAds.get(i);
            if (!containsAd(((AdInstance) (obj1)).companionAds, adinstance))
            {
                ((AdInstance) (obj1)).companionAds.add(adinstance);
            }
        }

        translatedAds = null;
    }

    private boolean containsAd(ArrayList arraylist, AdInstance adinstance)
    {
        for (int i = 0; i < arraylist.size(); i++)
        {
            if (adinstance.getAdId() == ((AdInstance)arraylist.get(i)).getAdId())
            {
                return true;
            }
        }

        return false;
    }

    private void dispatchEvent(final IEvent eventRef)
    {
        String s;
        if (context.getActivity() == null)
        {
            logger.warn("Activity not registered. Run dispatchEvent on current thread.");
        } else
        if (Looper.myLooper() != context.getActivity().getMainLooper())
        {
            logger.warn((new StringBuilder()).append("Re-dispatchEvent ").append(eventRef.getType()).append(" to main UI thread.").toString());
            (new Handler(context.getActivity().getMainLooper())).post(new Runnable() {

                final AdInstance this$0;
                final IEvent val$eventRef;

                public void run()
                {
                    dispatchEvent(eventRef);
                }

            
            {
                this$0 = AdInstance.this;
                eventRef = ievent;
                super();
            }
            });
            return;
        }
        s = eventRef.getType();
        logger.debug((new StringBuilder()).append("process ad event:").append(s).toString());
        if (!s.equals("loaded")) goto _L2; else goto _L1
_L1:
        rendererState.notifyLoaded(this, eventRef);
_L4:
        return;
_L2:
        if (s.equals("started"))
        {
            rendererState.notifyStarted(this, eventRef);
            return;
        }
        if (s.equals("stopped"))
        {
            rendererState.notifyStopped(this, eventRef);
            return;
        }
        if (s.equals("_e_unknown"))
        {
            onRendererError(eventRef);
            return;
        }
        if (s.equals("defaultClick"))
        {
            onRendererClicked(eventRef);
            dispatchAdEvent(s);
            return;
        }
        if (!s.equals("requestContentVideoPause"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!slot.requestContentPause)
        {
            context.requestContentPause(slot);
            slot.requestContentPause = true;
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (s.equals("requestContentVideoResume"))
        {
            if (slot.requestContentPause)
            {
                slot.requestContentPause = false;
                context.requestContentResume(slot);
                return;
            }
        } else
        {
            if (s.equals("bufferingStart") || s.equals("bufferingEnd"))
            {
                dispatchAdEvent(s);
                return;
            }
            if (s.equals("firstQuartile") || s.equals("midPoint") || s.equals("thirdQuartile") || s.equals("complete"))
            {
                if (!((QuartileCallbackHandler)callbackManager.getEventCallbackHandler(s, "IMPRESSION")).imprSent)
                {
                    dispatchAdEvent(s);
                }
            } else
            {
                dispatchAdEvent(s);
            }
            callbackManager.callback(s);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private AdRenderer findRenderer(String s, String s1, String s2, int i, String s3, String s4)
    {
        logger.debug((new StringBuilder()).append(this).append(" findRenderer(adUnit:").append(s).append(",soAdUnit:").append(s1).append(",contentType:").append(s2).append(",slotType:").append(i).append(",creativeAPI:").append(s3).append(",wrapperType:").append(s4).toString());
        for (Iterator iterator = context.adRenderers.iterator(); iterator.hasNext();)
        {
            AdRenderer adrenderer = (AdRenderer)iterator.next();
            if (adrenderer.match(s, s1, s2, Slot.slotTypeString(i), s3, s4))
            {
                return adrenderer;
            }
        }

        return null;
    }

    private int getAdRenderer()
    {
        byte byte1 = -1;
        ArrayList arraylist = getAllCreativeRenditions();
        int i = 0;
        do
        {
            ICreativeRendition icreativerendition;
            String s;
label0:
            {
                byte byte0 = byte1;
                if (i < arraylist.size())
                {
                    icreativerendition = (ICreativeRendition)arraylist.get(i);
                    s = icreativerendition.getContentType();
                    if (s == null || !s.equals("null/null") && !s.equals("test/ad"))
                    {
                        break label0;
                    }
                    if (adRenderer == null)
                    {
                        adRenderer = new AdRenderer(context);
                        adRenderer.name = s;
                    }
                    byte0 = 0;
                }
                return byte0;
            }
            adRenderer = findRenderer(icreativerendition.getBaseUnit(), ad.adUnit, s, slot.timePositionClass, icreativerendition.getCreativeAPI(), icreativerendition.getWrapperType());
            if (adRenderer != null)
            {
                if (icreativerendition != primaryCreativeRendition)
                {
                    setActiveCreativeRendition(icreativerendition);
                }
                return 1;
            }
            i++;
        } while (true);
    }

    private void onRendererClicked(IEvent ievent)
    {
        logger.debug("onRendererClicked");
        Object obj = (Bundle)ievent.getData().get("extraInfo");
        ievent = ((IEvent) (obj));
        if (obj == null)
        {
            ievent = new Bundle();
        }
        obj = ievent.getString("message");
        if (obj == null || ((String) (obj)).equals("defaultClick"))
        {
            if (callbackManager.defaultClickHandler != null)
            {
                callbackManager.defaultClickHandler.send(ievent);
                return;
            } else
            {
                logger.warn("no default click callback");
                return;
            }
        } else
        {
            callbackManager.callback(((String) (obj)), ievent);
            return;
        }
    }

    private void onRendererError(IEvent ievent)
    {
        logger.debug("onRendererError");
        Bundle bundle = (Bundle)ievent.getData().get("extraInfo");
        sendResellerNoAd(bundle.getString("errorCode"));
        if (adRenderer != null)
        {
            ievent = adRenderer.url;
        } else
        {
            ievent = renderer.getClass().getName();
        }
        bundle.putString("errorModule", ievent);
        callbackManager.errorHandler.send(bundle);
        rendererState.fail(this);
        state.fail(this);
    }

    private void parseCompanionAds(Element element)
        throws AdResponse.IllegalAdResponseException
    {
        NodeList nodelist = element.getChildNodes();
        int i = 0;
        while (i < nodelist.getLength()) 
        {
            Node node = nodelist.item(i);
            if (node.getNodeType() == 1)
            {
                element = node.getNodeName();
                logger.verbose((new StringBuilder()).append("parse(), name: ").append(element).toString());
                if (element.equals("adReference"))
                {
                    AdInstance adinstance = new AdInstance(context);
                    String s = ((Element)node).getAttribute("adSlotCustomId");
                    NonTemporalSlot nontemporalslot = (NonTemporalSlot)context.getSlotByCustomId(s);
                    element = nontemporalslot;
                    if (nontemporalslot == null)
                    {
                        NonTemporalSlot nontemporalslot1 = (NonTemporalSlot)context.adRequest.getSlotByCustomId(s);
                        element = nontemporalslot1;
                        if (nontemporalslot1 != null)
                        {
                            element = nontemporalslot1.copy();
                            context.adResponse.nonTemporalSlots.add(element);
                        }
                    }
                    if (element != null)
                    {
                        adinstance.slot = element;
                        adinstance.parse((Element)node);
                        companionAds.add(adinstance);
                    }
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(element).toString());
                }
            }
            i++;
        }
    }

    private void parseFallbackAds(Element element)
        throws AdResponse.IllegalAdResponseException
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
                if (((String) (obj)).equals("adReference"))
                {
                    obj = new AdInstance(context);
                    obj.slot = slot;
                    ((AdInstance) (obj)).parse((Element)node);
                    fallbackAds.add(obj);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(((String) (obj))).toString());
                }
            }
            i++;
        }
    }

    private void playCompanionAds()
    {
        logger.debug((new StringBuilder()).append(this).append(" playCompanionAds()").toString());
        for (int i = 0; i < companionAds.size(); i++)
        {
            AdInstance adinstance = (AdInstance)companionAds.get(i);
            adinstance.isCompanionAdOfPauseAd = slot.isPauseMidroll();
            if (!adinstance.ad.noLoad)
            {
                ((NonTemporalSlot)adinstance.slot).playCompanionAdInstance(adinstance);
            }
        }

    }

    private void sendResellerNoAd(String s)
    {
        if (s.equals("_e_3p-comp") || s.equals("_e_parse") || s.equals("_e_no-ad"))
        {
            callbackManager.callback("resellerNoAd");
            if (!resellerNoAdDispatched)
            {
                resellerNoAdDispatched = true;
                dispatchAdEvent("resellerNoAd");
            }
        }
    }

    public void adFailed(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("errorCode", s);
        bundle.putString("errorInfo", s1);
        if (adRenderer != null && adRenderer.url != null)
        {
            s = adRenderer.url;
        } else
        {
            s = "unknown";
        }
        bundle.putString("errorModule", s);
        callbackManager.errorHandler.send(bundle);
        state.fail(this);
    }

    public void addEventCallbackURLs(String s, String s1, ArrayList arraylist)
    {
        logger.debug((new StringBuilder()).append("eventName:").append(s).append(" eventType:").append(s1).append(" ").append(arraylist).toString());
        Object obj = EventCallback.validate(s, s1, arraylist);
        if (((ArrayList) (obj)).size() == 0)
        {
            obj = s1;
            if (s1.equals("CLICKTRACKING"))
            {
                obj = "CLICK";
            }
            callbackManager.getEventCallbackHandler(s, ((String) (obj))).addExternalTrackingURLs(arraylist);
            return;
        } else
        {
            logger.error(((ArrayList) (obj)).toString());
            return;
        }
    }

    public void addOnActivityCallbackListener(IActivityCallbackListener iactivitycallbacklistener)
    {
        context.addOnActivityCallbackListener(iactivitycallbacklistener);
    }

    public AdChain buildAdChain()
    {
        AdChain adchain = new AdChain(this);
        logger.debug((new StringBuilder()).append(this).append(" build add chain ").append(adchain).toString());
        AdInstance adinstance;
        for (Iterator iterator = fallbackAds.iterator(); iterator.hasNext(); adChain.append(adinstance))
        {
            adinstance = (AdInstance)iterator.next();
        }

        fallbackAds.clear();
        return adchain;
    }

    public IAdInstance cloneForTranslation()
    {
        logger.debug("cloneForTranslation()");
        AdInstance adinstance = new AdInstance(context);
        adinstance.ad = ad.cloneForTranslation();
        adinstance.creative = creative.cloneForTranslation();
        int i;
        if (primaryCreativeRendition != null)
        {
            i = primaryCreativeRendition.creativeRenditionId;
        } else
        {
            i = creativeRenditionId;
        }
        adinstance.creativeRenditionId = i;
        adinstance.replicaId = replicaId;
        adinstance.slot = slot;
        adinstance.eventCallbacks.clear();
        for (Iterator iterator = eventCallbacks.iterator(); iterator.hasNext(); adinstance.eventCallbacks.add(((EventCallback)iterator.next()).cloneForTranslation())) { }
        adinstance.callbackManager.copyOtherHandlers(callbackManager);
        return adinstance;
    }

    public ICreativeRendition createCreativeRenditionForTranslation()
    {
        logger.debug("createCreativeRenditionForTranslation()");
        CreativeRendition creativerendition = creative.createCreativeRendition();
        creativerendition.creativeRenditionId = creativeRenditionId;
        logger.debug((new StringBuilder()).append("createCreativeRenditionForTranslation(): returning ").append(creativerendition).toString());
        return creativerendition;
    }

    public void dispatchAdEvent(String s)
    {
        s = new Event(s);
        ((Event) (s)).data.put("adId", Integer.valueOf(getAdId()));
        ((Event) (s)).data.put("creativeId", Integer.valueOf(creative.creativeId));
        ((Event) (s)).data.put("customId", slot.customId);
        context.dispatchEvent(s);
    }

    public void dispatchEvent(String s)
    {
        logger.debug((new StringBuilder()).append("dispatchEvent(eventName=").append(s).append(")").toString());
        dispatchEvent(((IEvent) (new Event(s))));
    }

    public void dispatchEvent(String s, HashMap hashmap)
    {
        s = new Event(s);
        s.data = hashmap;
        dispatchEvent(((IEvent) (s)));
    }

    public CreativeRendition getActiveCreativeRendition()
    {
        return primaryCreativeRendition;
    }

    public volatile ICreativeRendition getActiveCreativeRendition()
    {
        return getActiveCreativeRendition();
    }

    public Activity getActivity()
    {
        return context.getActivity();
    }

    public int getAdId()
    {
        return ad.adId;
    }

    public IAdInstance getAdInstance()
    {
        return this;
    }

    public ArrayList getAllCreativeRenditions()
    {
        Collections.sort(creative.creativeRenditions);
        ArrayList arraylist = (ArrayList)creative.creativeRenditions.clone();
        if (primaryCreativeRendition != null)
        {
            arraylist.remove(primaryCreativeRendition);
            arraylist.add(0, primaryCreativeRendition);
        }
        return arraylist;
    }

    public ArrayList getCompanionSlots()
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < companionAds.size(); i++)
        {
            AdInstance adinstance = (AdInstance)companionAds.get(i);
            if (adinstance.ad.noLoad)
            {
                arraylist.add(adinstance.slot);
            }
        }

        logger.debug((new StringBuilder()).append("getCompanionSlots(").append(arraylist).append(")").toString());
        return arraylist;
    }

    public IConstants getConstants()
    {
        return context.getConstants();
    }

    public double getDuration()
    {
        if (!scheduledDrivingAd)
        {
            double d = -1D;
            if (renderer != null)
            {
                try
                {
                    d = renderer.getDuration();
                }
                catch (NoSuchMethodError nosuchmethoderror)
                {
                    d = -1D;
                    logger.warn("The renderer has no getDuration implemented.");
                }
                catch (AbstractMethodError abstractmethoderror)
                {
                    d = -1D;
                    logger.warn("The renderer has no getDuration implemented.");
                }
            }
            if (d >= 0.0D)
            {
                duration = d;
                return duration;
            }
            if (duration >= 0.0D)
            {
                return duration;
            }
            d = -1D;
            if (primaryCreativeRendition != null)
            {
                d = primaryCreativeRendition.getDuration();
            }
            if (d >= 0.0D)
            {
                duration = d;
                return duration;
            }
        }
        return 0.0D;
    }

    public ArrayList getEventCallbackURLs(String s, String s1)
    {
        ArrayList arraylist;
        logger.debug((new StringBuilder()).append("getEventCallbackURLs(").append(s).append(",").append(s1).append(")").toString());
        arraylist = new ArrayList();
        s = callbackManager.getEventCallbackHandler(s, s1);
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s1.equals("ERROR")) goto _L4; else goto _L3
_L3:
        arraylist.add(s.getInternalUrl());
_L6:
        logger.debug((new StringBuilder()).append("getEventCallbackURLs() Returning ").append(arraylist).toString());
        return arraylist;
_L4:
        if (s1.equals("CLICK"))
        {
            if (callbackManager.defaultClickHandler.isShowBrowser())
            {
                arraylist.add(s.getInternalUrl());
            }
        } else
        if (s1.equals("CLICKTRACKING"))
        {
            if (!callbackManager.defaultClickHandler.isShowBrowser())
            {
                arraylist.add(s.getInternalUrl());
            }
            arraylist.addAll(s.getTrackingURLs());
        } else
        {
            arraylist.add(s.getInternalUrl());
            arraylist.addAll(s.getTrackingURLs());
        }
        continue; /* Loop/switch isn't completed */
_L2:
        logger.warn("getEventCallbackURLs: failed to get event callback handler!");
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int getMetrValue()
    {
        return metrValue;
    }

    public Object getParameter(String s)
    {
        Object obj = null;
        ArrayList arraylist = new ArrayList();
        arraylist.add(context.adRequest.overrideLevelParameters);
        if (primaryCreativeRendition != null)
        {
            arraylist.add(primaryCreativeRendition.parameters);
        }
        if (creative != null)
        {
            arraylist.add(creative.parameters);
        }
        if (slot != null)
        {
            arraylist.add(slot.parameters);
        }
        arraylist.add(context.adResponse.profileParameters);
        arraylist.add(context.adRequest.globalLevelParameters);
        if (adRenderer != null)
        {
            arraylist.add(adRenderer.parameters);
        }
        Iterator iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj1 = ((HashMap)iterator.next()).get(s);
            obj = obj1;
            if (obj1 == null)
            {
                continue;
            }
            obj = obj1;
            break;
        } while (true);
        logger.debug((new StringBuilder()).append("getParameter:").append(s).append(":").append(obj).toString());
        return obj;
    }

    public ArrayList getRenderableCreativeRenditions()
    {
        Collections.sort(creative.creativeRenditions);
        ArrayList arraylist = new ArrayList();
        Iterator iterator = creative.creativeRenditions.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ICreativeRendition icreativerendition = (ICreativeRendition)iterator.next();
            if (adRenderer == null || adRenderer.match(icreativerendition.getBaseUnit(), ad.adUnit, icreativerendition.getContentType(), Slot.slotTypeString(slot.timePositionClass), icreativerendition.getCreativeAPI(), icreativerendition.getWrapperType()))
            {
                arraylist.add(icreativerendition);
            }
        } while (true);
        if (primaryCreativeRendition != null && arraylist.remove(primaryCreativeRendition))
        {
            arraylist.add(0, primaryCreativeRendition);
        }
        return arraylist;
    }

    public ISlot getSlot()
    {
        return slot;
    }

    public int getVersion()
    {
        return context.version;
    }

    public boolean isPlayable()
    {
        boolean flag;
        if (true && (state != AdFailedState.Instance() || imprSent))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            logger.debug((new StringBuilder()).append(this).append(" isPlayable returning false because adState is ").append(state).append(" and imprSent is ").append(imprSent).toString());
            return flag;
        }
        if (flag && (!scheduledDrivingAd || scheduledDrivingAd && state == AdLoadedState.Instance()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            logger.debug((new StringBuilder()).append(this).append(" isPlayable returning false becasue scheduledDrivingAd is true").toString());
            return flag;
        } else
        {
            logger.debug((new StringBuilder()).append(this).append(" isPlayable returning ").append(flag).toString());
            return flag;
        }
    }

    public void loadRenderer()
    {
        logger.debug("loadRenderer()");
        if (adRenderer == null)
        {
            getAdRenderer();
        }
        if (adRenderer != null)
        {
            onRendererModuleLoaded();
            return;
        } else
        {
            adFailed("_e_no-renderer", "no renderer matched");
            return;
        }
    }

    public void onRendererLoaded(IEvent ievent)
    {
        logger.debug("onRendererLoaded");
        state.notifyAdLoaded(this);
        commitAdInstances();
        if (adChain.chainBehavior.isDestState(state))
        {
            slot.notifyAdDone(this);
            return;
        }
        if (!pauseWhenLoading)
        {
            state.play(this);
            return;
        } else
        {
            logger.debug("player pause when loaing, ad pause");
            pauseWhenLoading = false;
            return;
        }
    }

    public void onRendererModuleLoaded()
    {
        ICreativeRenditionAsset icreativerenditionasset = primaryCreativeRendition.getPrimaryCreativRenditionAsset();
        if (icreativerenditionasset != null)
        {
            logger.debug((new StringBuilder()).append("startPlay: ").append(icreativerenditionasset.getURL()).toString());
        } else
        {
            logger.debug("startPlay: no assets");
        }
        try
        {
            renderer = AdRenderer.getRenderer(adRenderer);
            if (renderer == null)
            {
                logger.error("can not find a renderer to play");
                adFailed("_e_renderer-load", additionalErrorInfo);
                return;
            }
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            logger.error("IllegalAccessException");
            illegalaccessexception.printStackTrace();
            adFailed("_e_renderer-load", illegalaccessexception.getMessage());
            return;
        }
        catch (InstantiationException instantiationexception)
        {
            logger.error("InstantiationException");
            instantiationexception.printStackTrace();
            adFailed("_e_renderer-load", instantiationexception.getMessage());
            return;
        }
        rendererState = RendererInitState.Instance();
        rendererState.load(this);
        return;
    }

    public void onRendererStarted(IEvent ievent)
    {
        logger.debug((new StringBuilder()).append(this).append(" onRendererStarted()").toString());
        commitAdInstances();
        if (!scheduledDrivingAd)
        {
            callbackManager.sendDefaultImpression(false);
            playCompanionAds();
        }
    }

    public void onRendererStopped(IEvent ievent)
    {
        logger.debug("onRendererStopped");
        if (!scheduledDrivingAd)
        {
            callbackManager.sendDefaultImpression(true);
        }
        rendererState.dispose(this);
        state.complete(this);
    }

    public void onStartPlay()
    {
        logger.debug("onStartPlay()");
        rendererState.start(this);
    }

    public void onStopPlay()
    {
        logger.debug("onStopPlay");
        if (rendererState != null)
        {
            rendererState.stop(this);
        }
    }

    public void parse(Element element)
        throws AdResponse.IllegalAdResponseException
    {
        int i = tryParseInt(element.getAttribute("adId"));
        int j = tryParseInt(element.getAttribute("creativeId"));
        creativeRenditionId = tryParseInt(element.getAttribute("creativeRenditionId"));
        replicaId = tryParseInt(element.getAttribute("replicaId"), -1);
        ad = getAdResponse().getAd(i);
        if (ad == null)
        {
            throw new AdResponse.IllegalAdResponseException((new StringBuilder()).append("bad adId: ").append(i).toString());
        }
        creative = ad.getCreative(j);
        if (creative == null)
        {
            throw new AdResponse.IllegalAdResponseException((new StringBuilder()).append("bad creativeId: ").append(j).toString());
        }
        primaryCreativeRendition = creative.getRendition(creativeRenditionId, replicaId);
        element = element.getChildNodes();
        i = 0;
        while (i < element.getLength()) 
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1)
            {
                String s = node.getNodeName();
                logger.verbose((new StringBuilder()).append("parse(), name: ").append(s).toString());
                if (s.equals("eventCallbacks"))
                {
                    parseEventCallbacks((Element)node);
                    callbackManager.init();
                } else
                if (s.equals("companionAds"))
                {
                    parseCompanionAds((Element)node);
                } else
                if (s.equals("fallbackAds"))
                {
                    parseFallbackAds((Element)node);
                } else
                {
                    logger.warn((new StringBuilder()).append("ignore node: ").append(s).toString());
                }
            }
            i++;
        }
    }

    public void play()
    {
        logger.debug((new StringBuilder()).append(this).append(" play()").toString());
        adChain.chainBehavior = ChainBehavior.getPlayBehavior();
        state.play(this);
    }

    public void preload()
    {
        logger.debug((new StringBuilder()).append(this).append(" preload()").toString());
        adChain.chainBehavior = ChainBehavior.getPreloadBehavior();
        state.load(this);
    }

    public void resume()
    {
        logger.debug("resume");
        state.play(this);
    }

    public ArrayList scheduleAdInstances(ArrayList arraylist)
    {
        logger.debug((new StringBuilder()).append("scheduleAdInstances(").append(arraylist).append(")").toString());
        translatedAds = new ArrayList();
        int i = 0;
        while (i < arraylist.size()) 
        {
            ISlot islot = (ISlot)arraylist.get(i);
            if (slot == islot)
            {
                translatedAds.add(cloneForTranslation());
            } else
            {
                int j = 0;
                while (j < companionAds.size()) 
                {
                    AdInstance adinstance = (AdInstance)companionAds.get(j);
                    if (islot == adinstance.getSlot() && adinstance.ad.noLoad)
                    {
                        translatedAds.add(adinstance.cloneForTranslation());
                    }
                    j++;
                }
            }
            if (translatedAds.size() <= i)
            {
                logger.error((new StringBuilder()).append(this).append(".scheduleAd: bad slot: ").append(islot.getCustomId()).toString());
                translatedAds.add(null);
            }
            i++;
        }
        logger.debug((new StringBuilder()).append("scheduleAdInstances(): returning ").append(translatedAds).toString());
        return translatedAds;
    }

    public void setActiveCreativeRendition(ICreativeRendition icreativerendition)
    {
        if (icreativerendition == null)
        {
            primaryCreativeRendition = null;
            return;
        } else
        {
            primaryCreativeRendition = (CreativeRendition)icreativerendition;
            return;
        }
    }

    public void setClickThroughURL(String s, String s1)
    {
        String s2;
label0:
        {
            logger.debug((new StringBuilder()).append("setClickThroughURL(").append(s).append(",").append(s1).append(")").toString());
            if (s1 != null)
            {
                s2 = s1;
                if (!s1.equals(""))
                {
                    break label0;
                }
            }
            s2 = "defaultClick";
        }
        s1 = fetchEventCallback(s2, "CLICK", true);
        ClickCallbackHandler clickcallbackhandler = (ClickCallbackHandler)callbackManager.getEventCallbackHandler(s2, "CLICK");
        if (clickcallbackhandler != null)
        {
            clickcallbackhandler.setShowBrowserValue(true);
            clickcallbackhandler.setParameter("cr", s);
            return;
        }
        if (s1 != null)
        {
            if (((EventCallback) (s1)).type == "GENERIC")
            {
                s1 = s1.cloneForTranslation();
                s1.type = "CLICK";
                s1.name = s2;
                s1.showBrowser = true;
                eventCallbacks.add(s1);
            } else
            {
                s1.showBrowser = true;
            }
            s1 = (ClickCallbackHandler)createEventHandler(s2, "CLICK", true);
            s1.setParameter("cr", s);
            callbackManager.addEventCallbackHandler(s2, "CLICK", s1);
            return;
        } else
        {
            logger.warn("Failed to find generic callback for template.");
            return;
        }
    }

    public void setRendererCapability(String s, int i)
    {
        Integer integer = (Integer)InternalConstants.METR_MAP.get(s);
        if (integer == null)
        {
            return;
        }
        int j = i;
        if (s.equals("defaultClick"))
        {
            if (i == 0)
            {
                j = 1;
            } else
            {
                j = 0;
            }
        }
        if (j == 0)
        {
            metrValue = metrValue | integer.intValue();
        } else
        {
            metrValue = metrValue & ~-integer.intValue();
        }
        logger.debug((new StringBuilder()).append("setRendererCapability metrValue is ").append(metrValue).toString());
    }

    public void stop()
    {
        logger.debug((new StringBuilder()).append(this).append(" stop()").toString());
        state.stop(this);
    }

    public String toString()
    {
        return (new StringBuilder()).append("[AdInst adId:").append(getAdId()).append(" replicaId:").append(replicaId).append(" ").append(state).append("]").toString();
    }



/*
    static String access$102(AdInstance adinstance, String s)
    {
        adinstance.additionalErrorInfo = s;
        return s;
    }

*/
}

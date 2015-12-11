// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.webkit.URLUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.ad.interfaces.ICreativeRenditionAsset;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.renderers.vast.model.AbstractAd;
import tv.freewheel.renderers.vast.model.AbstractCreativeRendition;
import tv.freewheel.renderers.vast.model.Companion;
import tv.freewheel.renderers.vast.model.Creative;
import tv.freewheel.renderers.vast.model.Impression;
import tv.freewheel.renderers.vast.model.InLine;
import tv.freewheel.renderers.vast.model.Linear;
import tv.freewheel.renderers.vast.model.Tracking;
import tv.freewheel.renderers.vast.model.Vast;
import tv.freewheel.renderers.vast.model.VideoClick;
import tv.freewheel.renderers.vast.model.Wrapper;
import tv.freewheel.renderers.vast.util.StringUtils;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.URLLoader;
import tv.freewheel.utils.URLRequest;
import tv.freewheel.utils.renderer.ParamParser;

public class VastTranslator
    implements IRenderer
{

    private IConstants constants;
    private IRendererContext context;
    private URLLoader httpLoader;
    private IEventListener loadCompleteListener;
    private IEventListener loadFailedListener;
    private Logger logger;
    private ICreativeRendition originalActiveRendition;
    private ParamParser paramParser;
    private AtomicBoolean stopped;
    private Vast vast;
    private String vastURL;

    public VastTranslator()
    {
        stopped = new AtomicBoolean(false);
        loadCompleteListener = new IEventListener() {

            final VastTranslator this$0;

            public void run(IEvent ievent)
            {
                httpLoader.removeAllListeners();
                ievent = (String)ievent.getData().get(constants.INFO_KEY_MESSAGE());
                parseVastResponse(ievent);
            }

            
            {
                this$0 = VastTranslator.this;
                super();
            }
        };
        loadFailedListener = new IEventListener() {

            final VastTranslator this$0;

            public void run(IEvent ievent)
            {
                httpLoader.removeAllListeners();
                ievent = (String)ievent.getData().get(constants.INFO_KEY_MESSAGE());
                logger.verbose((new StringBuilder()).append("request failed: ").append(ievent).toString());
                failWithError(constants.ERROR_IO(), (new StringBuilder()).append("Failed to load VAST document ").append(ievent).append(".").toString());
            }

            
            {
                this$0 = VastTranslator.this;
                super();
            }
        };
        logger = Logger.getLogger(this, true);
        httpLoader = new URLLoader();
        httpLoader.addEventListener("URLLoader.Load.Complete", loadCompleteListener);
        httpLoader.addEventListener("URLLoader.Load.Error", loadFailedListener);
    }

    private void _stop()
    {
        if (stopped.get())
        {
            return;
        } else
        {
            stopped.set(true);
            (new Handler(context.getActivity().getMainLooper())).post(new Runnable() {

                final VastTranslator this$0;

                public void run()
                {
                    httpLoader.removeAllListeners();
                    httpLoader.close();
                    context.dispatchEvent(constants.EVENT_AD_STOPPED());
                }

            
            {
                this$0 = VastTranslator.this;
                super();
            }
            });
            return;
        }
    }

    private boolean checkCompatibilityWithSDK()
    {
        try
        {
            context.getVersion();
        }
        catch (NoSuchMethodError nosuchmethoderror)
        {
            failWithError(constants.ERROR_RENDERER_INIT(), "VastTranslator only compatible with SDK version >= 4.1");
            return false;
        }
        return true;
    }

    private void configureCreative(IAdInstance iadinstance, AbstractAd abstractad, int i, ArrayList arraylist)
    {
label0:
        {
            logger.debug((new StringBuilder()).append("configureCreative(").append(iadinstance).append(", type:").append(i).append(")").toString());
            Creative creative;
            for (abstractad = abstractad.creatives.iterator(); abstractad.hasNext(); configureTracking(iadinstance, creative.getTrackingEvents(context.getAdInstance().getSlot(), constants)))
            {
                creative = (Creative)abstractad.next();
                if (creative.linear != null && (i == 1 && iadinstance.getSlot().getTimePositionClass() != constants.TIME_POSITION_CLASS_OVERLAY() || i == 0 && creative.linear.isValid(context.getAdInstance().getSlot(), constants)))
                {
                    configureVideoClicks(iadinstance, creative.linear);
                }
            }

            if (i == 0)
            {
                for (i = 0; i < arraylist.size(); i++)
                {
                    abstractad = iadinstance.createCreativeRenditionForTranslation();
                    AbstractCreativeRendition abstractcreativerendition = (AbstractCreativeRendition)arraylist.get(i);
                    abstractcreativerendition.translateToFWCreativeRendition(abstractad, iadinstance, context.getAdInstance(), constants);
                    printMultilineLog("Translated vast rendition(InLine)  ", abstractcreativerendition.toString());
                }

            } else
            {
                abstractad = iadinstance.createCreativeRenditionForTranslation();
                abstractad.setWrapperType("external/vast-2");
                abstractad.setWrapperURL(vast.wrapper.vastAdTagUri);
                if (arraylist.size() <= 0)
                {
                    break label0;
                }
                arraylist = (AbstractCreativeRendition)arraylist.get(0);
                arraylist.translateToFWCreativeRendition(abstractad, iadinstance, context.getAdInstance(), constants);
                printMultilineLog("Translated vast rendition(Wrapper)  ", arraylist.toString());
            }
            return;
        }
        if (originalActiveRendition != null)
        {
            abstractad.setWidth(originalActiveRendition.getWidth());
            abstractad.setHeight(originalActiveRendition.getHeight());
            abstractad.setContentType(originalActiveRendition.getContentType());
            abstractad.setCreativeAPI(originalActiveRendition.getCreativeAPI());
            iadinstance = originalActiveRendition.getPrimaryCreativRenditionAsset();
            arraylist = abstractad.createCreativeRenditionAssetForTranslation("VAST_generated_placeholder_asset", true);
            if (iadinstance != null)
            {
                arraylist.setContentType(iadinstance.getContentType());
                arraylist.setMimeType(iadinstance.getMimeType());
            } else
            {
                arraylist.setContentType(originalActiveRendition.getContentType());
            }
        }
        printMultilineLog("Translated rendition(empty Wrapper)  ", abstractad.toString());
    }

    private void configureDrivingAdInstance(IAdInstance iadinstance, ArrayList arraylist)
    {
        logger.debug((new StringBuilder()).append("configureAdInstance(").append(iadinstance).append(") other").toString());
_L2:
        return;
        logger.debug((new StringBuilder()).append("configureDrivingAdInstance(").append(iadinstance).append(")").toString());
        Object obj;
        Object obj1;
        int i;
        if (vast.inLine != null)
        {
            logger.debug((new StringBuilder()).append("configureAdInstance(").append(iadinstance).append(") inline").toString());
            obj1 = vast.inLine.impressions;
            i = 0;
            obj = vast.inLine;
        } else
        {
label0:
            {
                if (vast.wrapper == null)
                {
                    break label0;
                }
                logger.debug((new StringBuilder()).append("configureAdInstance(").append(iadinstance).append(") wrapper").toString());
                obj1 = vast.wrapper.impressions;
                i = 1;
                obj = vast.wrapper;
            }
        }
        if (obj1 != null)
        {
            ArrayList arraylist1 = new ArrayList();
            obj1 = ((ArrayList) (obj1)).iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                Impression impression = (Impression)((Iterator) (obj1)).next();
                if (impression.isValid())
                {
                    arraylist1.add(impression.url);
                }
            } while (true);
            if (arraylist1.size() > 0)
            {
                iadinstance.addEventCallbackURLs(constants.EVENT_AD_IMPRESSION(), constants.EVENT_TYPE_IMPRESSION(), arraylist1);
            }
        }
        if (i != -1)
        {
            configureCreative(iadinstance, ((AbstractAd) (obj)), i, arraylist);
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void configureTracking(IAdInstance iadinstance, ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        logger.debug((new StringBuilder()).append("trackings:").append(arraylist.toString()).toString());
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                break;
            }
            Tracking tracking = (Tracking)arraylist.next();
            if (tracking.isValid())
            {
                arraylist1.clear();
                arraylist1.add(tracking.url);
                if (tracking.event.equals("creativeView") || tracking.event.equals("start"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_IMPRESSION(), constants.EVENT_TYPE_IMPRESSION(), arraylist1);
                } else
                if (tracking.event.equals("midpoint"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_MIDPOINT(), constants.EVENT_TYPE_IMPRESSION(), arraylist1);
                } else
                if (tracking.event.equals("firstQuartile"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_FIRST_QUARTILE(), constants.EVENT_TYPE_IMPRESSION(), arraylist1);
                } else
                if (tracking.event.equals("thirdQuartile"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_THIRD_QUARTILE(), constants.EVENT_TYPE_IMPRESSION(), arraylist1);
                } else
                if (tracking.event.equals("complete"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_COMPLETE(), constants.EVENT_TYPE_IMPRESSION(), arraylist1);
                } else
                if (tracking.event.equals("mute"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_MUTE(), constants.EVENT_TYPE_STANDARD(), arraylist1);
                } else
                if (tracking.event.equals("unmute"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_UNMUTE(), constants.EVENT_TYPE_STANDARD(), arraylist1);
                } else
                if (tracking.event.equals("pause"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_PAUSE(), constants.EVENT_TYPE_STANDARD(), arraylist1);
                } else
                if (tracking.event.equals("resume"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_RESUME(), constants.EVENT_TYPE_STANDARD(), arraylist1);
                } else
                if (tracking.event.equals("rewind"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_REWIND(), constants.EVENT_TYPE_STANDARD(), arraylist1);
                } else
                if (tracking.event.equals("expand"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_EXPAND(), constants.EVENT_TYPE_STANDARD(), arraylist1);
                } else
                if (tracking.event.equals("fullscreen"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_EXPAND(), constants.EVENT_TYPE_STANDARD(), arraylist1);
                } else
                if (tracking.event.equals("collapse"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_COLLAPSE(), constants.EVENT_TYPE_STANDARD(), arraylist1);
                } else
                if (tracking.event.equals("acceptInvitation"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_ACCEPT_INVITATION(), constants.EVENT_TYPE_STANDARD(), arraylist1);
                } else
                if (tracking.event.equals("close"))
                {
                    iadinstance.addEventCallbackURLs(constants.EVENT_AD_CLOSE(), constants.EVENT_TYPE_STANDARD(), arraylist1);
                }
            }
        } while (true);
    }

    private void configureVideoClicks(IAdInstance iadinstance, Linear linear)
    {
        logger.debug("configureEventCallbacks()");
        ArrayList arraylist = new ArrayList();
        linear = linear.videoClicks.iterator();
        do
        {
            if (!linear.hasNext())
            {
                break;
            }
            VideoClick videoclick = (VideoClick)linear.next();
            if (videoclick.isValid())
            {
                if (videoclick.type.equals("ClickThrough"))
                {
                    iadinstance.setClickThroughURL(videoclick.url, constants.EVENT_AD_CLICK());
                } else
                if (videoclick.type.equals("ClickTracking"))
                {
                    arraylist.add(videoclick.url);
                } else
                if (videoclick.type.equals("CustomClick"))
                {
                    ArrayList arraylist1 = new ArrayList();
                    arraylist1.add(videoclick.url);
                    iadinstance.addEventCallbackURLs(videoclick.id, constants.EVENT_TYPE_CLICK_TRACKING(), arraylist1);
                }
            }
        } while (true);
        if (arraylist.size() > 0)
        {
            iadinstance.addEventCallbackURLs(constants.EVENT_AD_CLICK(), constants.EVENT_TYPE_CLICK_TRACKING(), arraylist);
        }
    }

    private void failWithError(final String map, String s)
    {
        logger.debug((new StringBuilder()).append("failWithError(").append(map).append(", ").append(s).append(")").toString());
        Bundle bundle = new Bundle();
        bundle.putString(constants.INFO_KEY_ERROR_CODE(), map);
        bundle.putString(constants.INFO_KEY_ERROR_INFO(), (new StringBuilder()).append(s).append(" wrapperURL: ").append(vastURL).toString());
        map = new HashMap();
        map.put(constants.INFO_KEY_EXTRA_INFO(), bundle);
        (new Handler(context.getActivity().getMainLooper())).post(new Runnable() {

            final VastTranslator this$0;
            final HashMap val$map;

            public void run()
            {
                context.dispatchEvent(constants.EVENT_ERROR(), map);
            }

            
            {
                this$0 = VastTranslator.this;
                map = hashmap;
                super();
            }
        });
    }

    private void parseVastResponse(String s)
    {
        vast = new Vast(context);
        if (vast.parse(s))
        {
            logger.debug((new StringBuilder()).append("Vast document parsed, ").append(vast).toString());
            startTranslateAd();
            return;
        }
        if (vast.errorCode != 2) goto _L2; else goto _L1
_L1:
        failWithError(constants.ERROR_NO_AD_AVAILABLE(), vast.errorMessage);
_L4:
        vast = null;
        return;
_L2:
        if (vast.errorCode == 0)
        {
            failWithError(constants.ERROR_PARSE(), vast.errorMessage);
        } else
        if (vast.errorCode == 1)
        {
            failWithError(constants.ERROR_UNSUPPORTED_3P_FEATURE(), vast.errorMessage);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void printMultilineLog(String s, String s1)
    {
        s1 = s1.trim();
        if (s1.length() != 0)
        {
            int j = 1;
            s1 = s1.split("\n");
            int k = s1.length;
            int i = 0;
            while (i < k) 
            {
                String s2 = s1[i];
                logger.debug((new StringBuilder()).append(s).append(j).append(":").append(s2).toString());
                j++;
                i++;
            }
        }
    }

    private void sendRequest(String s)
    {
        logger.debug((new StringBuilder()).append("Loading VAST document from: ").append(s).toString());
        s = new URLRequest(s, System.getProperty("http.agent"));
        s.method = 1;
        s.contentType = "text/plain";
        httpLoader.load(s);
    }

    private void startTranslateAd()
    {
        logger.debug("startTranslateAd()");
        if (vast != null)
        {
            ArrayList arraylist1 = vast.getRenditionsInDrivingSlot();
            HashMap hashmap = new HashMap();
            Object obj = new ArrayList();
            if (vast.wrapper != null || vast.inLine != null && !arraylist1.isEmpty())
            {
                ((ArrayList) (obj)).add(context.getAdInstance().getSlot());
            }
            ArrayList arraylist = context.getCompanionSlots();
            ArrayList arraylist2 = new ArrayList();
            double d = context.getActivity().getResources().getDisplayMetrics().density;
            int i = 0;
            while (i < arraylist.size()) 
            {
                ISlot islot = (ISlot)arraylist.get(i);
                ((ArrayList) (obj)).add(islot);
                Object obj1 = vast.getCompanionRenditions(islot);
                ((ArrayList) (obj1)).removeAll(arraylist2);
                if (((ArrayList) (obj1)).size() > 0)
                {
                    obj1 = Vast.match(((ArrayList) (obj1)), islot, d);
                    if (obj1 != null)
                    {
                        hashmap.put(islot, obj1);
                        arraylist2.add(obj1);
                    } else
                    {
                        logger.debug((new StringBuilder()).append("No matching rendition for companion slot:").append(islot).toString());
                    }
                }
                i++;
            }
            obj = context.scheduleAdInstances(((ArrayList) (obj)));
            arraylist2 = new ArrayList(((ArrayList) (obj)).size());
            arraylist2.addAll(((java.util.Collection) (obj)));
            arraylist = null;
            Iterator iterator = arraylist2.iterator();
            do
            {
                obj = arraylist;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (IAdInstance)iterator.next();
                if (obj == null || ((IAdInstance) (obj)).getSlot() != context.getAdInstance().getSlot())
                {
                    continue;
                }
                configureDrivingAdInstance(((IAdInstance) (obj)), arraylist1);
                break;
            } while (true);
            if (obj != null)
            {
                arraylist2.remove(obj);
            }
            obj = arraylist2.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                IAdInstance iadinstance = (IAdInstance)((Iterator) (obj)).next();
                if (iadinstance != null)
                {
                    Companion companion = (Companion)hashmap.get(iadinstance.getSlot());
                    if (companion != null)
                    {
                        ICreativeRendition icreativerendition = iadinstance.createCreativeRenditionForTranslation();
                        configureTracking(iadinstance, companion.getTrackingEvents());
                        companion.translateToFWCreativeRendition(icreativerendition, iadinstance, context.getAdInstance(), constants);
                        icreativerendition.setWidth((int)((double)icreativerendition.getWidth() / d));
                        icreativerendition.setHeight((int)((double)icreativerendition.getHeight() / d));
                        logger.debug(String.format("Translated companion:slot(customId=%s:width=%d,height=%d) Ad(Id=%d) companion (ID=%s:width=%d,height=%d)", new Object[] {
                            iadinstance.getSlot().getCustomId(), Integer.valueOf(iadinstance.getSlot().getWidth()), Integer.valueOf(iadinstance.getSlot().getHeight()), Integer.valueOf(iadinstance.getAdId()), companion.id, companion.width, companion.height
                        }));
                    }
                }
            } while (true);
        }
        context.dispatchEvent(constants.EVENT_AD_LOADED());
    }

    public void dispose()
    {
        logger.debug("dispose()");
        _stop();
    }

    public double getDuration()
    {
        return -1D;
    }

    public void load(IRendererContext irenderercontext)
    {
        logger.debug("load()");
        context = irenderercontext;
        constants = irenderercontext.getConstants();
        paramParser = new ParamParser(context, "translator.vast");
        if (!checkCompatibilityWithSDK())
        {
            return;
        }
        if (context.getAdInstance().getSlot().getType() != constants.SLOT_TYPE_TEMPORAL())
        {
            failWithError(constants.ERROR_INVALID_SLOT(), "Vast Translator only supports temporal slots.");
            return;
        }
        originalActiveRendition = context.getAdInstance().getActiveCreativeRendition();
        vastURL = context.getAdInstance().getActiveCreativeRendition().getWrapperURL();
        if (StringUtils.isBlank(vastURL.trim()) || !URLUtil.isValidUrl(vastURL))
        {
            failWithError(constants.ERROR_INVALID_VALUE(), (new StringBuilder()).append("Not a valid URL to load VAST document from: ").append(vastURL).toString());
            return;
        }
        try
        {
            new URL(vastURL);
        }
        // Misplaced declaration of an exception variable
        catch (IRendererContext irenderercontext)
        {
            irenderercontext.printStackTrace();
            failWithError(constants.ERROR_INVALID_VALUE(), (new StringBuilder()).append("Not a valid URL to load VAST document from: ").append(vastURL).toString());
        }
        sendRequest(vastURL);
    }

    public void start()
    {
        logger.debug("start()");
        context.dispatchEvent(constants.EVENT_AD_STARTED());
        context.dispatchEvent(constants.EVENT_AD_STOPPED());
    }

    public void stop()
    {
        logger.debug("stop()");
        _stop();
    }






}

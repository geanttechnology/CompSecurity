// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.freewheel.hybrid.ad.AdManager;
import tv.freewheel.hybrid.ad.interfaces.IAdContext;
import tv.freewheel.hybrid.ad.interfaces.IAdInstance;
import tv.freewheel.hybrid.ad.interfaces.IAdManager;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.IEvent;
import tv.freewheel.hybrid.ad.interfaces.IEventListener;
import tv.freewheel.hybrid.ad.interfaces.ISlot;
import tv.freewheel.hybrid.utils.Logger;
import tv.freewheel.hybrid.utils.events.Event;

// Referenced classes of package tv.freewheel.hybrid:
//            CuePointManager

public class StreamStitcherHelper
{

    public static String FW_CREATIVE_PARAMETER_EMBEDDED_METADATA = "embedded_metadata";
    public static double Timeout = 5D;
    public static boolean isHybridSDK = false;
    private static int logLevel = 6;
    private final Activity activity;
    private final IEventListener adStartedListener;
    private final IEventListener adStoppedListener;
    private final IAdManager adm;
    private IConstants constants;
    private IAdContext ctx;
    private IAdInstance currentAd;
    private boolean exitPlayerFlag;
    private Boolean inAdRequesting;
    private final Logger logger;
    private HashMap nonTemporalSlotBases;
    private final IEventListener onCuePoint;
    private Pair pendingEmbeddedMetadata;
    private final HashSet playedAd;
    private final IEventListener requestCompleteListener;
    private final ArrayList retiredCtxList;
    private CuePointManager timeline;
    private URL url;
    private FrameLayout videoDisplayBase;

    public StreamStitcherHelper(Activity activity1, Context context, Location location, URL url1)
        throws MalformedURLException
    {
        exitPlayerFlag = false;
        retiredCtxList = new ArrayList();
        playedAd = new HashSet();
        inAdRequesting = Boolean.valueOf(false);
        requestCompleteListener = new IEventListener() {

            final StreamStitcherHelper this$0;

            public void run(IEvent ievent)
            {
                logger.debug("EVENT_REQUEST_COMPLETE");
                inAdRequesting = Boolean.valueOf(false);
                if ("false".equalsIgnoreCase((String)ievent.getData().get(constants.INFO_KEY_SUCCESS())))
                {
                    logger.warn("Ad request failed.");
                } else
                if (pendingEmbeddedMetadata != null)
                {
                    handleMetadata("TIT2", (String)pendingEmbeddedMetadata.first, ((Long)pendingEmbeddedMetadata.second).longValue());
                    return;
                }
            }

            
            {
                this$0 = StreamStitcherHelper.this;
                super();
            }
        };
        adStartedListener = new IEventListener() {

            final StreamStitcherHelper this$0;

            public void run(IEvent ievent)
            {
                Object obj;
                int i;
                int j;
                logger.debug("EVENT_AD_STARTED");
                obj = (String)ievent.getData().get(constants.INFO_KEY_CUSTOM_ID());
                i = ((Integer)ievent.getData().get(constants.INFO_KEY_AD_ID())).intValue();
                j = ((Integer)ievent.getData().get(constants.INFO_KEY_REPLICA_ID())).intValue();
                ievent = ctx.getSlotByCustomId(((String) (obj)));
                if (ievent != null) goto _L2; else goto _L1
_L1:
                logger.debug((new StringBuilder()).append("Slot not found in current ad context. slot id: ").append(((String) (obj))).toString());
_L4:
                return;
_L2:
                int k = ievent.getTimePositionClass();
                if (k != constants.TIME_POSITION_CLASS_PREROLL() && k != constants.TIME_POSITION_CLASS_MIDROLL() && k != constants.TIME_POSITION_CLASS_POSTROLL())
                {
                    logger.debug((new StringBuilder()).append("Ignore slots other than PRE/MID/POST. slot id: ").append(((String) (obj))).toString());
                    return;
                }
                obj = ievent.getAdInstances().iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    ievent = (IAdInstance)((Iterator) (obj)).next();
                } while (ievent.getAdId() != i || ievent.getReplicaId() != j);
                currentAd = ievent;
                obj = Pair.create(Integer.valueOf(i), Integer.valueOf(j));
                if (!playedAd.contains(obj))
                {
                    playedAd.add(obj);
                    playCompanion(ievent);
                    return;
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = StreamStitcherHelper.this;
                super();
            }
        };
        adStoppedListener = new IEventListener() {

            final StreamStitcherHelper this$0;

            public void run(IEvent ievent)
            {
                Object obj;
                int i;
                int j;
                logger.debug("EVENT_AD_STOPPED");
                obj = (String)ievent.getData().get(constants.INFO_KEY_CUSTOM_ID());
                i = ((Integer)ievent.getData().get(constants.INFO_KEY_AD_ID())).intValue();
                j = ((Integer)ievent.getData().get(constants.INFO_KEY_REPLICA_ID())).intValue();
                ievent = ctx.getSlotByCustomId(((String) (obj)));
                if (ievent != null) goto _L2; else goto _L1
_L1:
                logger.debug((new StringBuilder()).append("Slot not found in current ad context. slot id: ").append(((String) (obj))).toString());
_L4:
                return;
_L2:
                int k = ievent.getTimePositionClass();
                if (k != constants.TIME_POSITION_CLASS_PREROLL() && k != constants.TIME_POSITION_CLASS_MIDROLL() && k != constants.TIME_POSITION_CLASS_POSTROLL())
                {
                    logger.debug((new StringBuilder()).append("Ignore slots other than PRE/MID/POST. slot id: ").append(((String) (obj))).toString());
                    return;
                }
                obj = ievent.getAdInstances();
                Iterator iterator = ((ArrayList) (obj)).iterator();
                IAdInstance iadinstance;
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    iadinstance = (IAdInstance)iterator.next();
                } while (iadinstance.getAdId() != i || iadinstance.getReplicaId() != j || currentAd != iadinstance);
                logger.debug((new StringBuilder()).append(iadinstance.getAdId()).append(" ended").toString());
                currentAd = null;
                if (((ArrayList) (obj)).indexOf(iadinstance) == ((ArrayList) (obj)).size() - 1)
                {
                    resetCuePointSlotsInTimeline(ievent);
                    ievent.processSlotEvent(constants.EVENT_SLOT_ENDED());
                    return;
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = StreamStitcherHelper.this;
                super();
            }
        };
        onCuePoint = new IEventListener() {

            final StreamStitcherHelper this$0;

            public void run(IEvent ievent)
            {
                ievent = (String)ievent.getData().get(constants.INFO_KEY_MESSAGE());
                logger.debug((new StringBuilder()).append("onCuePoint ").append(ievent).toString());
                ievent = ctx.getSlotByCustomId(ievent);
                if (ievent != null)
                {
                    ievent.play();
                }
            }

            
            {
                this$0 = StreamStitcherHelper.this;
                super();
            }
        };
        logger = Logger.getLogger(this);
        nonTemporalSlotBases = new HashMap();
        timeline = new CuePointManager();
        timeline.addEventListener(CuePointManager.EVENT_CUE_POINT_REACHED, onCuePoint);
        adm = AdManager.getInstance(context);
        Logger.setLogLevel(logLevel);
        if (location != null)
        {
            adm.setLocation(location);
        }
        activity = activity1;
        processStreamStitcherURL(url1);
    }

    public StreamStitcherHelper(Activity activity1, Context context, URL url1)
        throws MalformedURLException
    {
        this(activity1, context, null, url1);
    }

    private IAdInstance findAdWithMetadataValue(String s)
    {
        logger.debug((new StringBuilder()).append("findAdWithMetadataValue: ").append(s).toString());
        if (ctx != null) goto _L2; else goto _L1
_L1:
        IAdInstance iadinstance = null;
_L4:
        return iadinstance;
_L2:
        IAdInstance iadinstance1;
        Iterator iterator;
        iadinstance1 = null;
        iterator = ctx.getTemporalSlots().iterator();
_L6:
        iadinstance = iadinstance1;
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        ISlot islot;
        Iterator iterator1;
        islot = (ISlot)iterator.next();
        iterator1 = islot.getAdInstances().iterator();
        iadinstance = iadinstance1;
_L7:
        iadinstance1 = iadinstance;
        if (!iterator1.hasNext()) goto _L6; else goto _L5
_L5:
        IAdInstance iadinstance2 = (IAdInstance)iterator1.next();
        if (!playedAd.contains(Pair.create(Integer.valueOf(iadinstance2.getAdId()), Integer.valueOf(iadinstance2.getReplicaId()))))
        {
            Object obj = iadinstance2.getParameter(FW_CREATIVE_PARAMETER_EMBEDDED_METADATA);
            if (obj != null && s.equalsIgnoreCase((String)obj))
            {
                if (iadinstance == null)
                {
                    iadinstance = iadinstance2;
                } else
                if (iadinstance.getSlot().getTimePosition() > islot.getTimePosition())
                {
                    iadinstance = iadinstance2;
                }
            }
        }
          goto _L7
    }

    private void playCompanion(IAdInstance iadinstance)
    {
        logger.debug("playCompanion");
        iadinstance = iadinstance.getCompanionAdInstances().iterator();
        do
        {
            if (!iadinstance.hasNext())
            {
                break;
            }
            ISlot islot = ((IAdInstance)iadinstance.next()).getSlot();
            ViewGroup viewgroup = (ViewGroup)nonTemporalSlotBases.get(islot.getCustomId());
            if (viewgroup != null)
            {
                viewgroup.removeAllViews();
                viewgroup.addView(islot.getBase());
            }
        } while (true);
    }

    private void processStreamStitcherURL(URL url1)
        throws MalformedURLException
    {
        url1 = url1.toString();
        url = new URL(url1.replaceAll("resp=m3u8", "resp=smrx"));
        adm.setServer(url.toString());
        try
        {
            Matcher matcher = Pattern.compile("[\\?&]nw=([\\d]+)").matcher(url1);
            if (matcher.find())
            {
                adm.setNetwork(Integer.parseInt(matcher.group(1)));
            }
            return;
        }
        catch (NumberFormatException numberformatexception)
        {
            logger.error((new StringBuilder()).append("Failed to parse network id from URL ").append(url1).toString());
        }
    }

    private void resetCuePointSlotsInTimeline(ISlot islot)
    {
        logger.debug("resetCuePointSlotsInTimeline");
        timeline.reset();
        Object obj = ctx.getTemporalSlots();
        Collections.sort(((java.util.List) (obj)), new Comparator() {

            final StreamStitcherHelper this$0;

            public volatile int compare(Object obj1, Object obj2)
            {
                return compare((ISlot)obj1, (ISlot)obj2);
            }

            public int compare(ISlot islot2, ISlot islot3)
            {
                return Double.valueOf(islot2.getTimePosition()).compareTo(Double.valueOf(islot3.getTimePosition()));
            }

            
            {
                this$0 = StreamStitcherHelper.this;
                super();
            }
        });
        obj = ((ArrayList) (obj)).iterator();
        do
        {
            ISlot islot1;
label0:
            {
                if (((Iterator) (obj)).hasNext())
                {
                    islot1 = (ISlot)((Iterator) (obj)).next();
                    if (islot1.getTimePosition() < islot.getTimePosition() || islot1.getTimePositionClass() == constants.TIME_POSITION_CLASS_PAUSE_MIDROLL())
                    {
                        continue;
                    }
                    if (islot1.getTimePositionClass() == constants.TIME_POSITION_CLASS_OVERLAY())
                    {
                        break label0;
                    }
                    if (islot1.getCustomId().equals(islot.getCustomId()))
                    {
                        continue;
                    }
                }
                timeline.start();
                return;
            }
            double d = islot1.getTimePosition() - islot.getTimePosition();
            if (d == 0.0D)
            {
                islot1.play();
            } else
            {
                logger.debug((new StringBuilder()).append("schedule an overlay slot ").append(islot1.getCustomId()).append(" after ").append(d).append(" seconds").toString());
                timeline.addCuePointForName(islot1.getCustomId(), d);
            }
        } while (true);
    }

    private void startNewContext()
    {
        inAdRequesting = Boolean.valueOf(true);
        if (ctx != null)
        {
            ctx.removeEventListener(constants.EVENT_REQUEST_COMPLETE(), requestCompleteListener);
            ctx.removeEventListener(constants.EVENT_AD_STARTED(), adStartedListener);
            ctx.removeEventListener(constants.EVENT_AD_STOPPED(), adStoppedListener);
            retiredCtxList.add(ctx);
            ctx = adm.newContextWithContext(ctx);
        } else
        {
            ctx = adm.newContext();
            ctx.setActivity(activity);
        }
        constants = ctx.getConstants();
        ctx.addEventListener(constants.EVENT_REQUEST_COMPLETE(), requestCompleteListener);
        ctx.addEventListener(constants.EVENT_AD_STARTED(), adStartedListener);
        ctx.addEventListener(constants.EVENT_AD_STOPPED(), adStoppedListener);
        ctx.setParameter(constants.PARAMETER_REQUEST_ALTERNATIVE_URL(), url, constants.PARAMETER_LEVEL_GLOBAL());
        if (videoDisplayBase != null)
        {
            ctx.registerVideoDisplayBase(videoDisplayBase);
        }
        ctx.submitRequest(Timeout);
    }

    public void handleMetadata(String s, String s1, long l)
    {
        logger.debug(String.format("handleMetadata (%s, %s, %d)", new Object[] {
            s, s1, Long.valueOf(l)
        }));
        boolean flag1 = false;
        boolean flag = flag1;
        if (pendingEmbeddedMetadata != null)
        {
            flag = flag1;
            if (pendingEmbeddedMetadata.equals(Pair.create(s1, Long.valueOf(l))))
            {
                flag = true;
            }
        }
        pendingEmbeddedMetadata = null;
        s = findAdWithMetadataValue(s1);
        if (s != null)
        {
            if (s == s.getSlot().getAdInstances().get(0))
            {
                s.getSlot().processSlotEvent(constants.EVENT_SLOT_STARTED());
            }
            s.play2();
        } else
        if (!flag && !exitPlayerFlag)
        {
            pendingEmbeddedMetadata = Pair.create(s1, Long.valueOf(l));
            playedAd.clear();
            startNewContext();
            return;
        }
    }

    public void handleProgressUpdate(long l)
    {
        if (ctx == null)
        {
            return;
        } else
        {
            HashMap hashmap = new HashMap();
            hashmap.put(constants.TIME_POSITION_STRING(), Long.valueOf(l));
            ctx.dispatchEvent(new Event(constants.EVENT_PROGRESS_UPDATE(), hashmap));
            return;
        }
    }

    public void start()
    {
        retiredCtxList.clear();
        playedAd.clear();
        exitPlayerFlag = false;
        isHybridSDK = true;
    }

    public void stop()
    {
        if (ctx != null)
        {
            ctx.dispose();
        }
        timeline.stop();
        retiredCtxList.clear();
        playedAd.clear();
        isHybridSDK = false;
        exitPlayerFlag = true;
    }




/*
    static Boolean access$102(StreamStitcherHelper streamstitcherhelper, Boolean boolean1)
    {
        streamstitcherhelper.inAdRequesting = boolean1;
        return boolean1;
    }

*/






/*
    static IAdInstance access$502(StreamStitcherHelper streamstitcherhelper, IAdInstance iadinstance)
    {
        streamstitcherhelper.currentAd = iadinstance;
        return iadinstance;
    }

*/



}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.FrameLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IAdManager;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.ad.slot.NonTemporalSlot;
import tv.freewheel.ad.slot.Slot;
import tv.freewheel.ad.slot.TemporalSlot;
import tv.freewheel.ad.state.VideoPausedState;
import tv.freewheel.ad.state.VideoPendingState;
import tv.freewheel.ad.state.VideoPlayingState;
import tv.freewheel.extension.ExtensionManager;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.utils.CommonUtil;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.URLLoader;
import tv.freewheel.utils.URLRequest;
import tv.freewheel.utils.events.Event;
import tv.freewheel.utils.events.EventDispatcher;

// Referenced classes of package tv.freewheel.ad:
//            Visitor, Capabilities, AdRequest, AdResponse, 
//            VideoAsset, AdManager, AdRenderer, Constants, 
//            AdInstance

public class AdContext extends EventDispatcher
    implements IAdContext
{

    private static Constants constants;
    private IEventListener adLoadCompleteListener = new IEventListener() {

        final AdContext this$0;

        public void run(IEvent ievent)
        {
            String s2 = (String)ievent.getData().get("message");
            logResponse(s2);
            ievent = new HashMap();
            try
            {
                adResponse.parse(s2);
            }
            catch (AdResponse.IllegalAdResponseException illegaladresponseexception)
            {
                illegaladresponseexception.printStackTrace();
                ievent.put("message", (new StringBuilder()).append("request failed: ").append(illegaladresponseexception.toString()).toString());
                ievent.put("success", "false");
                dispatchEvent(new Event("requestComplete", ievent));
                return;
            }
            catch (Throwable throwable)
            {
                throwable.printStackTrace();
                ievent.put("message", (new StringBuilder()).append("request failed: ").append(throwable.toString()).toString());
                ievent.put("success", "false");
                dispatchEvent(new Event("requestComplete", ievent));
                return;
            }
            autoloadExtensions = getNeedLoadedExtensions();
            if (autoloadExtensions.size() == 0)
            {
                notifyRequestComplete();
                return;
            }
            String s3;
            for (ievent = autoloadExtensions.keySet().iterator(); ievent.hasNext(); loadExtension(s3))
            {
                s3 = (String)ievent.next();
            }

            notifyRequestComplete();
        }

            
            {
                this$0 = AdContext.this;
                super();
            }
    };
    private IEventListener adLoadFailedListener = new IEventListener() {

        final AdContext this$0;

        public void run(IEvent ievent)
        {
            ievent = (String)ievent.getData().get("message");
            logger.debug((new StringBuilder()).append("request failed: ").append(ievent).toString());
            HashMap hashmap = new HashMap();
            hashmap.put("message", (new StringBuilder()).append("request failed: ").append(ievent).toString());
            hashmap.put("success", "false");
            dispatchEvent(new Event("requestComplete", hashmap));
        }

            
            {
                this$0 = AdContext.this;
                super();
            }
    };
    public final AdManager adManager;
    public final String adManagerVersion;
    public ArrayList adRenderers;
    public AdRequest adRequest;
    public AdResponse adResponse;
    private Map autoloadExtensions;
    public Capabilities capabilities;
    public String defaultSiteSectionSlotProfile;
    public String defaultTemporalSlotProfile;
    public String defaultVideoPlayerSlotProfile;
    private boolean deviceIdAdded;
    protected Location geoLocation;
    private Activity hostActivity;
    public HashMap loadedExtensions;
    private Logger logger;
    public ArrayList mOnActivityCallbackListeners;
    public final int networkId;
    public String playerProfile;
    private URLLoader requestLoader;
    private boolean requestSubmitted;
    protected String screenDimensionStr;
    public final String serverUrl;
    private FrameLayout temporalSlotBase;
    private String userAgent;
    public final int version;
    public Visitor visitor;

    public AdContext(int i, String s, String s1, int j)
    {
        requestSubmitted = false;
        deviceIdAdded = false;
        playerProfile = null;
        defaultTemporalSlotProfile = null;
        defaultVideoPlayerSlotProfile = null;
        defaultSiteSectionSlotProfile = null;
        requestLoader = null;
        networkId = i;
        serverUrl = s;
        adManagerVersion = s1;
        version = j;
        adManager = null;
        if (logger == null)
        {
            logger = Logger.getLogger(this);
        }
        visitor = new Visitor(getVersion());
        capabilities = new Capabilities();
        adRequest = new AdRequest(this);
        adResponse = new AdResponse(this);
        adRenderers = new ArrayList();
        userAgent = (new StringBuilder()).append("Mozilla/5.0 (").append(getCurrentUserAgent()).append(") FreeWheelAdManager/").append(adManagerVersion).toString();
        mOnActivityCallbackListeners = new ArrayList();
    }

    public AdContext(AdContext adcontext)
    {
        this(adcontext.adManager);
        adRequest.setAdRequest(adcontext.adRequest);
        visitor.customId = adcontext.visitor.customId;
        visitor.ipV4Address = adcontext.visitor.ipV4Address;
        visitor.bandwidth = adcontext.visitor.bandwidth;
        visitor.bandwidthSource = adcontext.visitor.bandwidthSource;
        String s;
        String s1;
        for (Iterator iterator = adcontext.visitor.httpHeaders.keySet().iterator(); iterator.hasNext(); visitor.setVisitorHttpHeader(s, s1))
        {
            s = (String)iterator.next();
            s1 = (String)adcontext.visitor.httpHeaders.get(s);
        }

        capabilities.setCapabilities(adcontext.capabilities);
        setCapability("resetExclusivity", 2);
        playerProfile = adcontext.playerProfile;
        defaultTemporalSlotProfile = adcontext.defaultTemporalSlotProfile;
        defaultVideoPlayerSlotProfile = adcontext.defaultVideoPlayerSlotProfile;
        defaultSiteSectionSlotProfile = adcontext.defaultSiteSectionSlotProfile;
        screenDimensionStr = adcontext.screenDimensionStr;
        temporalSlotBase = adcontext.temporalSlotBase;
        hostActivity = adcontext.hostActivity;
        adResponse.videoAsset.state = adcontext.adResponse.videoAsset.state;
        adResponse.videoAsset.timer = adcontext.adResponse.videoAsset.timer;
        adResponse.videoAsset.callbackHandler = adcontext.adResponse.videoAsset.callbackHandler;
    }

    public AdContext(AdManager admanager)
    {
        requestSubmitted = false;
        deviceIdAdded = false;
        playerProfile = null;
        defaultTemporalSlotProfile = null;
        defaultVideoPlayerSlotProfile = null;
        defaultSiteSectionSlotProfile = null;
        requestLoader = null;
        logger = Logger.getLogger(this, true);
        logger.debug((new StringBuilder()).append("new ").append(getClass().getName()).toString());
        adManager = admanager;
        serverUrl = admanager.serverUrl;
        networkId = admanager.networkId;
        adManagerVersion = admanager.getStringVersion();
        version = admanager.getVersion();
        visitor = new Visitor(getVersion());
        capabilities = new Capabilities();
        adRequest = new AdRequest(this);
        adResponse = new AdResponse(this);
        adRenderers = new ArrayList();
        userAgent = (new StringBuilder()).append("Mozilla/5.0 (").append(getCurrentUserAgent()).append(") FreeWheelAdManager/").append(adManagerVersion).toString();
        mOnActivityCallbackListeners = new ArrayList();
        if (adManager.geoLocation != null)
        {
            geoLocation = new Location(adManager.geoLocation);
        } else
        {
            geoLocation = null;
        }
        loadedExtensions = new HashMap();
    }

    private int checkIdType(int i)
    {
        int j = i;
        if (i != 0)
        {
            j = i;
            if (i != 1)
            {
                j = i;
                if (i != 2)
                {
                    j = 0;
                }
            }
        }
        return j;
    }

    private HashMap getAutoLoadExtensions(String s)
    {
        HashMap hashmap = new HashMap();
        s = ((String) (getParameter(s)));
        if (s != null)
        {
            String as[] = s.toString().split(",");
            int i = 0;
            while (i < as.length) 
            {
                String s1 = as[i].trim();
                if (!s1.equals(""))
                {
                    s = null;
                    if (s1.lastIndexOf(".") > -1)
                    {
                        s = s1.substring(s1.lastIndexOf("/") + 1, s1.lastIndexOf("."));
                    }
                    if (s != null)
                    {
                        logger.debug((new StringBuilder()).append("getAutoLoadExtensions() add extension, name:").append(s).append(" url:").append(s1).toString());
                        hashmap.put(s, s1);
                    }
                }
                i++;
            }
        }
        return hashmap;
    }

    private String getCurrentUserAgent()
    {
        Object obj = Locale.getDefault();
        StringBuffer stringbuffer = new StringBuffer();
        String s = android.os.Build.VERSION.RELEASE;
        if (s.length() > 0)
        {
            stringbuffer.append(s);
        } else
        {
            stringbuffer.append("1.0");
        }
        stringbuffer.append("; ");
        s = ((Locale) (obj)).getLanguage();
        if (s != null)
        {
            stringbuffer.append(s.toLowerCase());
            obj = ((Locale) (obj)).getCountry();
            if (obj != null)
            {
                stringbuffer.append("-");
                stringbuffer.append(((String) (obj)).toLowerCase());
            }
        } else
        {
            stringbuffer.append("en");
        }
        if ("REL".equals(android.os.Build.VERSION.CODENAME))
        {
            obj = Build.MODEL;
            if (((String) (obj)).length() > 0)
            {
                stringbuffer.append("; ");
                stringbuffer.append(((String) (obj)));
            }
        }
        obj = Build.ID;
        if (((String) (obj)).length() > 0)
        {
            stringbuffer.append(" Build/");
            stringbuffer.append(((String) (obj)));
        }
        return String.format("Android %s", new Object[] {
            stringbuffer
        });
    }

    private Map getNeedLoadedExtensions()
    {
        ConcurrentHashMap concurrenthashmap = new ConcurrentHashMap();
        concurrenthashmap.putAll(getAutoLoadExtensions("autoloadExtensions"));
        concurrenthashmap.putAll(getAutoLoadExtensions("autoloadExtensionsInternal"));
        for (Iterator iterator = ExtensionManager.internalExtensions.iterator(); iterator.hasNext(); concurrenthashmap.put((String)iterator.next(), "")) { }
        Iterator iterator1 = (new HashSet(concurrenthashmap.keySet())).iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            String s = (String)iterator1.next();
            if (loadedExtensions.containsKey(s))
            {
                logger.debug((new StringBuilder()).append("remove extension(").append(s).append(") since it has been loaded").toString());
                concurrenthashmap.remove(s);
            }
        } while (true);
        return concurrenthashmap;
    }

    private void logResponse(String s)
    {
        Object obj = new ArrayList();
        splitStringIntoArray(s, ((ArrayList) (obj)));
        logger.debug("got response: ");
        for (s = ((ArrayList) (obj)).iterator(); s.hasNext(); logger.debug(((String) (obj))))
        {
            obj = (String)s.next();
        }

    }

    private void notifyActivityCallback(int i)
    {
        Iterator iterator = mOnActivityCallbackListeners.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            IActivityCallbackListener iactivitycallbacklistener = (IActivityCallbackListener)((WeakReference)iterator.next()).get();
            if (iactivitycallbacklistener != null)
            {
                iactivitycallbacklistener.onActivityCallback(i);
            }
        } while (true);
    }

    private void notifyRequestComplete()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("message", "request succeeded");
        hashmap.put("success", "true");
        dispatchEvent(new Event("requestComplete", hashmap));
    }

    private void setDeviceIdentifier()
    {
        if (!deviceIdAdded)
        {
            deviceIdAdded = true;
            if (CommonUtil.parseBoolean((String)getParameter("_fw_did_android_id"), Boolean.valueOf(false)).booleanValue())
            {
                String s = android.provider.Settings.Secure.getString(hostActivity.getContentResolver(), "android_id");
                if (s != null && !s.isEmpty())
                {
                    addKeyValue("_fw_did_android_id", CommonUtil.md5(s));
                    return;
                }
            }
        }
    }

    private void splitStringIntoArray(String s, ArrayList arraylist)
    {
        if (s.length() > 4000)
        {
            arraylist.add(s.substring(0, 4000));
            splitStringIntoArray(s.substring(4000), arraylist);
            return;
        } else
        {
            arraylist.add(s);
            return;
        }
    }

    public void addKeyValue(String s, String s1)
    {
        logger.debug((new StringBuilder()).append("addKeyValue ").append(s).append(" ").append(s1).toString());
        adRequest.addKeyValue(s, s1);
    }

    void addOnActivityCallbackListener(IActivityCallbackListener iactivitycallbacklistener)
    {
        mOnActivityCallbackListeners.add(new WeakReference(iactivitycallbacklistener));
    }

    public void addRenderer(String s, String s1, String s2, String s3, String s4, String s5, HashMap hashmap)
    {
        logger.debug((new StringBuilder()).append("addRenderer ").append(s).toString());
        s = new AdRenderer(this, s, s1, s2, s3, s4, s5, null, hashmap);
        adRenderers.add(0, s);
    }

    public void addRenderer(String s, String s1, String s2, String s3, String s4, HashMap hashmap)
    {
        addRenderer(s, s1, s2, s3, s4, null, hashmap);
    }

    public void addSiteSectionNonTemporalSlot(String s, String s1, int i, int j, String s2, boolean flag, String s3, 
            String s4)
    {
        addSiteSectionNonTemporalSlot(s, s1, i, j, s2, flag, s3, s4, 0, null);
    }

    public void addSiteSectionNonTemporalSlot(String s, String s1, int i, int j, String s2, boolean flag, String s3, 
            String s4, int k, String s5)
    {
        adRequest.addSiteSectionNonTemporalSlot(s, s1, i, j, s2, flag, s3, s4, k, s5);
    }

    public void addTemporalSlot(String s, String s1, double d, String s2, int i, double d1, String s3, String s4, double d2)
    {
        adRequest.addTemporalSlot(s, s1, d, s2, i, d1, s3, s4, d2);
    }

    public void addVideoPlayerNonTemporalSlot(String s, String s1, int i, int j, String s2, boolean flag, String s3, 
            String s4)
    {
        addVideoPlayerNonTemporalSlot(s, s1, i, j, s2, flag, s3, s4, 0, null);
    }

    public void addVideoPlayerNonTemporalSlot(String s, String s1, int i, int j, String s2, boolean flag, String s3, 
            String s4, int k, String s5)
    {
        adRequest.addVideoPlayerNonTemporalSlot(s, s1, i, j, s2, flag, s3, s4, k, s5);
    }

    public URLRequest buildRequest()
    {
        if (networkId != -1 && serverUrl != null)
        {
            float f = getActivity().getApplicationContext().getResources().getDisplayMetrics().density;
            Object obj = new DecimalFormat("0.##");
            adRequest.addKeyValue("_fw_dpr", ((DecimalFormat) (obj)).format(f));
            setDeviceIdentifier();
            URLRequest urlrequest;
            try
            {
                obj = adRequest.toXML();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                dispatchEvent(new Event("requestComplete", exception.toString()));
                return null;
            }
            logger.debug((new StringBuilder()).append("request is: ").append(((String) (obj))).toString());
            logger.debug((new StringBuilder()).append("submitRequest: ").append(serverUrl).toString());
            urlrequest = new URLRequest(serverUrl, userAgent);
            urlrequest.method = 0;
            urlrequest.contentType = "text/xml";
            urlrequest.data = ((String) (obj));
            return urlrequest;
        } else
        {
            logger.error("invalid networkId or serverUrl");
            return null;
        }
    }

    public void dispatchEvent(final IEvent event)
    {
        if (hostActivity == null)
        {
            logger.warn("The activity is not registered yet. The dispatchEvent will be done on current thread.");
            super.dispatchEvent(event);
            return;
        }
        if (Looper.myLooper() != hostActivity.getMainLooper())
        {
            logger.warn((new StringBuilder()).append("Need re-dispatchEvent ").append(event.getType()).append(" on main UI thread.").toString());
            (new Handler(hostActivity.getMainLooper())).post(new Runnable() {

                final AdContext this$0;
                final IEvent val$event;

                public void run()
                {
                    dispatchEvent(event);
                }

            
            {
                this$0 = AdContext.this;
                event = ievent;
                super();
            }
            });
            return;
        } else
        {
            super.dispatchEvent(event);
            return;
        }
    }

    public void dispose()
    {
        logger.debug("dispose");
        removeAllListeners();
        if (requestLoader != null)
        {
            requestLoader.removeAllListeners();
        }
        mOnActivityCallbackListeners.clear();
        for (Iterator iterator = adResponse.nonTemporalSlots.iterator(); iterator.hasNext(); ((NonTemporalSlot)iterator.next()).stop()) { }
        Iterator iterator1 = adResponse.temporalSlots.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            TemporalSlot temporalslot = (TemporalSlot)iterator1.next();
            if (temporalslot.isPlaying())
            {
                temporalslot.stop();
            }
        } while (true);
        hostActivity = null;
        ExtensionManager.unregisterAdContext(this);
    }

    public Activity getActivity()
    {
        return hostActivity;
    }

    public IAdManager getAdManager()
    {
        return adManager;
    }

    public IConstants getConstants()
    {
        if (constants == null)
        {
            constants = new Constants();
        }
        return constants;
    }

    public int getNetworkId()
    {
        return networkId;
    }

    public Object getParameter(String s)
    {
        Object obj = null;
        ArrayList arraylist = new ArrayList();
        arraylist.add(adRequest.overrideLevelParameters);
        arraylist.add(adResponse.profileParameters);
        arraylist.add(adRequest.globalLevelParameters);
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
        return obj;
    }

    public int getRequestMode()
    {
        return !adRequest.getRequestMode().equals("LIVE") ? 1 : 2;
    }

    protected String getScreenDimensionStr()
    {
        if (screenDimensionStr == null)
        {
            Display display = ((WindowManager)hostActivity.getSystemService("window")).getDefaultDisplay();
            screenDimensionStr = String.format("%d,%d", new Object[] {
                Integer.valueOf(display.getWidth()), Integer.valueOf(display.getHeight())
            });
        }
        return screenDimensionStr;
    }

    public String getServerUrl()
    {
        return serverUrl;
    }

    public ArrayList getSiteSectionNonTemporalSlots()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = adResponse.nonTemporalSlots.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ISlot islot = (ISlot)iterator.next();
            if (islot.getType() == 2)
            {
                arraylist.add(islot);
            }
        } while (true);
        return arraylist;
    }

    public ISlot getSlotByCustomId(String s)
    {
        for (Iterator iterator = adResponse.temporalSlots.iterator(); iterator.hasNext();)
        {
            Slot slot = (Slot)iterator.next();
            if (s.equals(slot.customId))
            {
                return slot;
            }
        }

        for (Iterator iterator1 = adResponse.nonTemporalSlots.iterator(); iterator1.hasNext();)
        {
            Slot slot1 = (Slot)iterator1.next();
            if (s.equals(slot1.customId))
            {
                return slot1;
            }
        }

        return null;
    }

    public ArrayList getSlotsByTimePositionClass(int i)
    {
        ArrayList arraylist = new ArrayList();
        if (i == 5)
        {
            for (Iterator iterator = adResponse.nonTemporalSlots.iterator(); iterator.hasNext(); arraylist.add((ISlot)iterator.next())) { }
        } else
        {
            Iterator iterator1 = adResponse.temporalSlots.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                ISlot islot = (ISlot)iterator1.next();
                if (i == islot.getTimePositionClass())
                {
                    arraylist.add(islot);
                }
            } while (true);
        }
        return arraylist;
    }

    public FrameLayout getTemporalSlotBase()
    {
        return temporalSlotBase;
    }

    public ArrayList getTemporalSlots()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = adResponse.temporalSlots.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ISlot islot = (ISlot)iterator.next();
            if (islot.getTimePositionClass() != 6)
            {
                arraylist.add(islot);
            }
        } while (true);
        return arraylist;
    }

    public String getUserAgent()
    {
        return userAgent;
    }

    public String getVersion()
    {
        return adManagerVersion;
    }

    public String getVideoLocation()
    {
        return adRequest.vaMediaLocation;
    }

    public ArrayList getVideoPlayerNonTemporalSlots()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = adResponse.nonTemporalSlots.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ISlot islot = (ISlot)iterator.next();
            if (islot.getType() == 1)
            {
                arraylist.add(islot);
            }
        } while (true);
        return arraylist;
    }

    public void loadExtension(String s)
    {
        Object obj;
        boolean flag;
        logger.debug((new StringBuilder()).append("loadExtension: ").append(s).toString());
        if (loadedExtensions.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_105;
        }
        flag = true;
        obj = "load successful";
        if (ExtensionManager.loadExtension(s, this) == null)
        {
            flag = false;
            try
            {
                obj = (new StringBuilder()).append("can not get a instance for ").append(s).toString();
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                flag = false;
                illegalaccessexception = illegalaccessexception.getMessage();
            }
            catch (InstantiationException instantiationexception)
            {
                flag = false;
                instantiationexception = instantiationexception.getMessage();
            }
        }
        onExtensionLoaded(flag, ((String) (obj)), s);
        return;
        logger.info((new StringBuilder()).append("already have extension ").append(s).append(" loaded before, ignore the action").toString());
        return;
    }

    public void notifyUserAction(int i)
    {
        logger.debug((new StringBuilder()).append("notifyUserAction(userAction=").append(i).append(")").toString());
        HashMap hashmap = new HashMap();
        hashmap.put("userAction", Integer.valueOf(i));
        dispatchEvent(new Event("userActionNotified", hashmap));
    }

    public void onExtensionLoaded(boolean flag, String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("moduleName", s1);
        if (flag)
        {
            hashmap.put("message", "extension loaded");
            hashmap.put("success", "true");
        } else
        {
            hashmap.put("message", s);
            hashmap.put("success", "false");
        }
        dispatchEvent(new Event("extensionLoaded", hashmap));
    }

    public void registerVideoDisplay(SurfaceView surfaceview)
    {
        if (surfaceview.getParent() instanceof FrameLayout)
        {
            registerVideoDisplayBase((FrameLayout)surfaceview.getParent());
            return;
        } else
        {
            throw new RuntimeException("Please put your content video in a FrameLayout");
        }
    }

    public void registerVideoDisplayBase(FrameLayout framelayout)
    {
        temporalSlotBase = framelayout;
        (new Handler(hostActivity.getMainLooper())).post(new Runnable() {

            final AdContext this$0;

            public void run()
            {
                Iterator iterator = adResponse.temporalSlots.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    TemporalSlot temporalslot = (TemporalSlot)iterator.next();
                    if (!temporalslot.isPlaying() || temporalslot.currentPlayingAdInstance == null)
                    {
                        continue;
                    }
                    temporalslot.currentPlayingAdInstance.renderer.resize();
                    break;
                } while (true);
                logger.info((new StringBuilder()).append("registerVideoDisplay(").append(temporalSlotBase).append("), width: ").append(temporalSlotBase.getWidth()).append(", height: ").append(temporalSlotBase.getHeight()).toString());
            }

            
            {
                this$0 = AdContext.this;
                super();
            }
        });
    }

    public void requestContentPause(Slot slot)
    {
        logger.debug((new StringBuilder()).append("requestContentPause(slot=").append(slot).append(")").toString());
        if (adResponse.videoAsset.state == VideoPlayingState.Instance() || adResponse.videoAsset.state == VideoPendingState.Instance())
        {
            dispatchEvent(new Event("requestContentVideoPause", slot.customId));
            return;
        } else
        {
            logger.info("ignore since main video is not in playing state");
            return;
        }
    }

    public void requestContentResume(Slot slot)
    {
        logger.debug((new StringBuilder()).append("requestContentResume(slot=").append(slot).append(")").toString());
        Object obj = new ArrayList();
        for (Iterator iterator = getTemporalSlots().iterator(); iterator.hasNext(); ((ArrayList) (obj)).add((Slot)(ISlot)iterator.next())) { }
        for (Iterator iterator1 = getVideoPlayerNonTemporalSlots().iterator(); iterator1.hasNext(); ((ArrayList) (obj)).add((Slot)(ISlot)iterator1.next())) { }
        for (Iterator iterator2 = getSiteSectionNonTemporalSlots().iterator(); iterator2.hasNext(); ((ArrayList) (obj)).add((Slot)(ISlot)iterator2.next())) { }
        boolean flag1 = false;
        obj = ((ArrayList) (obj)).iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            if (!((Slot)((Iterator) (obj)).next()).requestContentPause)
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        if (!flag)
        {
            if (adResponse.videoAsset.state == VideoPausedState.Instance())
            {
                dispatchEvent(new Event("requestContentVideoResume", slot.customId));
                return;
            } else
            {
                logger.info("ignore since main video is in playing state");
                return;
            }
        } else
        {
            logger.info("ignore since other slot need content video pause");
            return;
        }
    }

    public void resetExclusivity()
    {
        setCapability("resetExclusivity", 0);
    }

    public void setActivity(Activity activity)
    {
        if (activity == null) goto _L2; else goto _L1
_L1:
        Logger.overrideLogLevel(activity);
        hostActivity = activity;
        int i = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode;
        String s = String.valueOf(i);
_L4:
        userAgent = (new StringBuilder()).append(userAgent).append(";").append(activity.getPackageName()).append("/").append(s).toString();
        logger.debug((new StringBuilder()).append("UserAgent:").append(userAgent).toString());
_L2:
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception = "unknown";
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setActivityState(int i)
    {
        if (hostActivity == null)
        {
            return;
        }
        logger.debug((new StringBuilder()).append("setActivityState ").append(i).toString());
        if (i == 4 || i == 5)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("activityState", Integer.valueOf(i));
            dispatchEvent(new Event("activityStateChanged", hashmap));
        }
        i;
        JVM INSTR tableswitch 4 5: default 104
    //                   4 105
    //                   5 137;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        CookieSyncManager.getInstance().stopSync();
        if (!hostActivity.isFinishing()) goto _L5; else goto _L4
_L4:
        logger.debug("The activity will be destroyed.");
_L7:
        notifyActivityCallback(i);
        return;
_L3:
        CookieSyncManager.getInstance().startSync();
        Iterator iterator = adResponse.temporalSlots.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            TemporalSlot temporalslot = (TemporalSlot)iterator.next();
            if (!temporalslot.isPlaying() || temporalslot.currentPlayingAdInstance == null)
            {
                continue;
            }
            temporalslot.currentPlayingAdInstance.resume();
            break;
        } while (true);
        notifyActivityCallback(i);
        return;
_L5:
        logger.debug("It is going to pause active ad.");
        Iterator iterator1 = adResponse.temporalSlots.iterator();
        TemporalSlot temporalslot1;
        do
        {
            if (!iterator1.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            temporalslot1 = (TemporalSlot)iterator1.next();
        } while (!temporalslot1.isPlaying() || temporalslot1.currentPlayingAdInstance == null);
        temporalslot1.currentPlayingAdInstance.pause();
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void setCapability(String s, int i)
    {
        logger.debug((new StringBuilder()).append("setCapability ").append(s).append(" ").append(i).toString());
        capabilities.setCapability(s, i);
    }

    public void setParameter(String s, Object obj, int i)
    {
        adRequest.setParameter(s, obj, i);
    }

    public void setProfile(String s, String s1, String s2, String s3)
    {
        logger.debug((new StringBuilder()).append("setProfile ").append(s).append(" ").append(s1).append(" ").append(s2).append(" ").append(s3).toString());
        playerProfile = s;
        if (s1 == null || s1.length() <= 0)
        {
            s1 = s;
        }
        defaultTemporalSlotProfile = s1;
        defaultVideoPlayerSlotProfile = s2;
        defaultSiteSectionSlotProfile = s3;
    }

    public void setRequestDuration(double d)
    {
        adRequest.setRequestDuration(d);
    }

    public void setRequestMode(int i)
    {
        adRequest.setRequestMode(i);
    }

    public void setSiteSection(String s, int i, int j, int k, int l)
    {
        logger.debug((new StringBuilder()).append("setSiteSection ").append(s).append(" ").append(i).append(" ").append(j).append(" ").append(k).append(" ").append(l).toString());
        k = checkIdType(k);
        adRequest.setSiteSection(s, i, j, k, l);
    }

    public void setVideoAsset(String s, double d, String s1, int i, int j, int k, 
            int l, int i1, int j1)
    {
        logger.debug((new StringBuilder()).append("setVideoAsset ").append(s).append(" ").append(d).append(" ").append(s1).append(" ").append(i).append(" ").append(j).append(" ").append(k).append(" ").append(l).append(" ").append(i1).append(" ").append(j1).toString());
        l = checkIdType(l);
        AdRequest adrequest = adRequest;
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        adrequest.setVideoAsset(s, d, s1, flag, j, k, l, i1, j1, i);
    }

    public void setVideoAsset(String s, double d, String s1, boolean flag, int i, int j, 
            int k, int l)
    {
        int i1;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        setVideoAsset(s, d, s1, i1, i, j, k, l, 0);
    }

    public void setVideoAssetCurrentTimePosition(double d)
    {
        adRequest.setVideoAssetCurrentTimePosition(d);
    }

    public void setVideoPlayer(int i)
    {
        logger.debug((new StringBuilder()).append("setVideoPlayer ").append(i).toString());
        adRequest.setVideoPlayer(i);
    }

    public void setVideoState(int i)
    {
        logger.info((new StringBuilder()).append("setVideoState ").append(i).toString());
        if (i == 1)
        {
            adResponse.videoAsset.play();
        } else
        {
            if (i == 2 || i == 3)
            {
                adResponse.videoAsset.pause();
                return;
            }
            if (i == 4)
            {
                adResponse.videoAsset.complete();
                adRequest.videoViewCallbackRequested = false;
                adResponse.videoAsset = new VideoAsset(this);
                return;
            }
        }
    }

    public void setVisitor(String s, String s1, int i, String s2)
    {
        logger.debug((new StringBuilder()).append("setVisitor ").append(s).append(" ").append(s1).append(" ").append(i).append("").append(s2).toString());
        visitor.customId = s;
        visitor.ipV4Address = s1;
        visitor.bandwidth = i;
        visitor.bandwidthSource = s2;
    }

    public void setVisitorHttpHeader(String s, String s1)
    {
        logger.debug((new StringBuilder()).append("setVisitorHttpHeader ").append(s).append(" ").append(s1).toString());
        visitor.setVisitorHttpHeader(s, s1);
    }

    public void startSubsession(int i)
    {
        adRequest.startSubsession(i);
    }

    public void submitRequest(double d)
    {
        submitRequest(d, 0.0D);
    }

    public void submitRequest(double d, double d1)
    {
        final long delayMs = (long)(1000D * d1);
        if (requestSubmitted)
        {
            logger.warn("Each AdContext instance can only submit ad request once.");
        } else
        {
            requestSubmitted = true;
            if (!serverUrl.matches("^\\w+:.*"))
            {
                logger.debug((new StringBuilder()).append("submitRequest to local file: ").append(serverUrl).toString());
                (new Thread() {

                    final AdContext this$0;
                    final long val$delayMs;

                    public void run()
                    {
                        Object obj;
                        if (delayMs > 0L)
                        {
                            Thread.sleep(delayMs);
                        }
                        obj = new HashMap();
                        FileInputStream fileinputstream = new FileInputStream(new File(serverUrl));
                        adResponse.parse(fileinputstream);
                        ((HashMap) (obj)).put("message", "request succeeded");
                        ((HashMap) (obj)).put("success", "true");
                        dispatchEvent(new Event("requestComplete", ((HashMap) (obj))));
                        return;
                        Object obj1;
                        obj1;
                        try
                        {
                            ((HashMap) (obj)).put("message", (new StringBuilder()).append("request failed: ").append(((FileNotFoundException) (obj1)).getMessage()).toString());
                            ((HashMap) (obj)).put("success", "false");
                            dispatchEvent(new Event("requestComplete", ((HashMap) (obj))));
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            ((Throwable) (obj)).printStackTrace();
                        }
                        return;
                        obj1;
                        ((HashMap) (obj)).put("message", (new StringBuilder()).append("request failed: ").append(((AdResponse.IllegalAdResponseException) (obj1)).getMessage()).toString());
                        ((HashMap) (obj)).put("success", "false");
                        dispatchEvent(new Event("requestComplete", ((HashMap) (obj))));
                        return;
                    }

            
            {
                this$0 = AdContext.this;
                delayMs = l;
                super();
            }
                }).start();
                return;
            }
            setCapability("skipsAdSelection", 1);
            URLRequest urlrequest;
            if (adRequest.hasVideoAsset())
            {
                if (adRequest.videoViewCallbackRequested)
                {
                    setCapability("requiresVideoCallbackUrl", 1);
                } else
                {
                    adRequest.videoViewCallbackRequested = true;
                    setCapability("requiresVideoCallbackUrl", 0);
                }
            } else
            {
                setCapability("requiresVideoCallbackUrl", 1);
            }
            if (geoLocation != null)
            {
                addKeyValue("ltlg", String.format("%.4f,%.4f", new Object[] {
                    Double.valueOf(geoLocation.getLatitude()), Double.valueOf(geoLocation.getLongitude())
                }));
            }
            urlrequest = buildRequest();
            if (urlrequest != null)
            {
                urlrequest.delayMs = delayMs;
                requestLoader = new URLLoader();
                requestLoader.addEventListener("URLLoader.Load.Complete", adLoadCompleteListener);
                requestLoader.addEventListener("URLLoader.Load.Error", adLoadFailedListener);
                if (d <= 0.0D)
                {
                    requestLoader.load(urlrequest);
                    return;
                } else
                {
                    requestLoader.load(urlrequest, d);
                    return;
                }
            }
        }
    }




/*
    static Map access$102(AdContext adcontext, Map map)
    {
        adcontext.autoloadExtensions = map;
        return map;
    }

*/





}

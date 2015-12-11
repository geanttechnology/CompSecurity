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
import android.view.WindowManager;
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
import java.util.concurrent.ConcurrentHashMap;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.ad.slot.Slot;
import tv.freewheel.ad.state.VideoPausedState;
import tv.freewheel.ad.state.VideoPendingState;
import tv.freewheel.ad.state.VideoPlayingState;
import tv.freewheel.extension.ExtensionManager;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.utils.CommonUtil;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.URLLoader;
import tv.freewheel.utils.URLRequest;
import tv.freewheel.utils.events.Event;
import tv.freewheel.utils.events.EventDispatcher;

// Referenced classes of package tv.freewheel.ad:
//            AdManager, Visitor, Capabilities, AdRequest, 
//            AdResponse, Constants, VideoAsset

public class AdContext extends EventDispatcher
    implements IAdContext
{

    private static Constants constants;
    private IEventListener adLoadCompleteListener;
    private IEventListener adLoadFailedListener;
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

    public AdContext(AdManager admanager)
    {
        requestSubmitted = false;
        deviceIdAdded = false;
        playerProfile = null;
        defaultTemporalSlotProfile = null;
        defaultVideoPlayerSlotProfile = null;
        defaultSiteSectionSlotProfile = null;
        requestLoader = null;
        adLoadCompleteListener = new IEventListener() {

            final AdContext this$0;

            public void run(IEvent ievent)
            {
                String s = (String)ievent.getData().get("message");
                logResponse(s);
                ievent = new HashMap();
                try
                {
                    adResponse.parse(s);
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
                String s1;
                for (ievent = autoloadExtensions.keySet().iterator(); ievent.hasNext(); loadExtension(s1))
                {
                    s1 = (String)ievent.next();
                }

                notifyRequestComplete();
            }

            
            {
                this$0 = AdContext.this;
                super();
            }
        };
        adLoadFailedListener = new IEventListener() {

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

    public Activity getActivity()
    {
        return hostActivity;
    }

    public IConstants getConstants()
    {
        if (constants == null)
        {
            constants = new Constants();
        }
        return constants;
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

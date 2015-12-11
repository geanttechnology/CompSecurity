// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.liverail.library.AdView;
import com.liverail.library.events.VPAIDEvent;
import com.liverail.library.events.VPAIDEventListener;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.renderers.interfaces.IRendererContext;

public class LiveRailFWRenderer
    implements IRenderer
{

    private static final String EXTRA_PARAMS_KEY = "parameters";
    private static final String LR_ADMAP = "LR_ADMAP";
    private static final String LR_PUBLISHER_ID = "LR_PUBLISHER_ID";
    private static final String LR_VIDEO_POSITION = "LR_VIDEO_POSITION";
    private static final String TAG = "LiveRailRenderer";
    private AdView adView;
    private IRendererContext context;
    private IConstants fwconst;
    private boolean isAdImpression;
    private boolean isInitComplete;
    private final VPAIDEventListener onAdClickThrough = new VPAIDEventListener() {

        final LiveRailFWRenderer this$0;

        public void onEvent(VPAIDEvent vpaidevent)
        {
            boolean flag = ((Boolean)vpaidevent.getParameter("playerHandles")).booleanValue();
            Object obj = (String)vpaidevent.getParameter("url");
            Object obj1 = (new StringBuilder("VPAID Event ")).append(vpaidevent.getType()).append(" playerHandles=").append(flag).append(" url=");
            if (obj != null)
            {
                vpaidevent = ((VPAIDEvent) (obj));
            } else
            {
                vpaidevent = "null";
            }
            Log.v("LiveRailRenderer", ((StringBuilder) (obj1)).append(vpaidevent).toString());
            if (flag && obj != null && !((String) (obj)).isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            vpaidevent = new Bundle();
            vpaidevent.putBoolean(fwconst.INFO_KEY_SHOW_BROWSER(), flag);
            obj1 = fwconst.INFO_KEY_URL();
            if (!flag)
            {
                obj = "";
            }
            vpaidevent.putString(((String) (obj1)), ((String) (obj)));
            obj = new HashMap();
            ((HashMap) (obj)).put(fwconst.INFO_KEY_EXTRA_INFO(), vpaidevent);
            Log.d("LiveRailRenderer", "dispatch EVENT_AD_CLICK ");
            context.dispatchEvent(fwconst.EVENT_AD_CLICK(), ((HashMap) (obj)));
        }

            
            {
                this$0 = LiveRailFWRenderer.this;
                super();
            }
    };
    private final VPAIDEventListener onAdError = new VPAIDEventListener() {

        final LiveRailFWRenderer this$0;

        public void onEvent(VPAIDEvent vpaidevent)
        {
            Log.v("LiveRailRenderer", (new StringBuilder("VPAID Event ")).append(vpaidevent.getType()).append(" at least one impression=").append(isAdImpression).toString());
            adExperienceCompleted();
        }

            
            {
                this$0 = LiveRailFWRenderer.this;
                super();
            }
    };
    private final VPAIDEventListener onAdImpression = new VPAIDEventListener() {

        final LiveRailFWRenderer this$0;

        public void onEvent(VPAIDEvent vpaidevent)
        {
            Log.v("LiveRailRenderer", (new StringBuilder("VPAID Event ")).append(vpaidevent.getType()).toString());
            isAdImpression = true;
            Log.v("LiveRailRenderer", "Dispatching EVENT_AD_STARTED");
            context.dispatchEvent(context.getConstants().EVENT_AD_STARTED());
        }

            
            {
                this$0 = LiveRailFWRenderer.this;
                super();
            }
    };
    private final VPAIDEventListener onAdLoaded = new VPAIDEventListener() {

        final LiveRailFWRenderer this$0;

        public void onEvent(VPAIDEvent vpaidevent)
        {
            Log.v("LiveRailRenderer", (new StringBuilder("VPAID Event ")).append(vpaidevent.getType()).toString());
            isInitComplete = true;
            Log.v("LiveRailRenderer", "Dispatching EVENT_AD_LOADED");
            context.dispatchEvent(context.getConstants().EVENT_AD_LOADED());
        }

            
            {
                this$0 = LiveRailFWRenderer.this;
                super();
            }
    };
    private final VPAIDEventListener onAdProgressListener = new VPAIDEventListener() {

        final LiveRailFWRenderer this$0;

        public void onEvent(VPAIDEvent vpaidevent)
        {
            Log.v("LiveRailRenderer", (new StringBuilder("VPAID Event ")).append(vpaidevent.getType()).toString());
            if (vpaidevent.getType().equals("AdVideoFirstQuartile"))
            {
                Log.v("LiveRailRenderer", "Dispatching EVENT_AD_FIRST_QUARTILE");
                context.dispatchEvent(context.getConstants().EVENT_AD_FIRST_QUARTILE());
            } else
            {
                if (vpaidevent.getType().equals("AdVideoMidpoint"))
                {
                    Log.v("LiveRailRenderer", "Dispatching EVENT_AD_MIDPOINT");
                    context.dispatchEvent(context.getConstants().EVENT_AD_MIDPOINT());
                    return;
                }
                if (vpaidevent.getType().equals("AdVideoThirdQuartile"))
                {
                    Log.v("LiveRailRenderer", "Dispatching EVENT_AD_THIRD_QUARTILE");
                    context.dispatchEvent(context.getConstants().EVENT_AD_THIRD_QUARTILE());
                    return;
                }
                if (vpaidevent.getType().equals("AdVideoComplete"))
                {
                    Log.v("LiveRailRenderer", "Dispatching EVENT_AD_COMPLETE");
                    context.dispatchEvent(context.getConstants().EVENT_AD_COMPLETE());
                    return;
                }
            }
        }

            
            {
                this$0 = LiveRailFWRenderer.this;
                super();
            }
    };
    private final VPAIDEventListener onAdStopped = new VPAIDEventListener() {

        final LiveRailFWRenderer this$0;

        public void onEvent(VPAIDEvent vpaidevent)
        {
            Log.v("LiveRailRenderer", (new StringBuilder("VPAID Event ")).append(vpaidevent.getType()).toString());
            adExperienceCompleted();
        }

            
            {
                this$0 = LiveRailFWRenderer.this;
                super();
            }
    };
    private ViewGroup parentView;
    private ISlot slot;
    private final String supportedLRParams[] = {
        "LR_PUBLISHER_ID", "LR_TITLE", "LR_VIDEO_ID", "LR_VIDEO_URL", "LR_TAGS", "LR_ADMAP", "LR_VIDEO_POSITION", "LR_VIDEO_DURATION", "LR_VERTICALS", "LR_CONTENT", 
        "LR_PARTNERS", "LR_LAYOUT_SKIN_MESSAGE", "LR_TIMEOUT_DELIVERY", "LR_TIMEOUT_ADSOURCE", "LR_TIMEOUT_STREAM", "LR_WRAPPER_LIMIT"
    };

    public LiveRailFWRenderer()
    {
        Log.i("LiveRailRenderer", "LiveRailRenderer for FW SDK version=5.5.1-r9816-1304230605");
    }

    private void adExperienceCompleted()
    {
        if (!isAdImpression)
        {
            Log.i("LiveRailRenderer", "Dispatching ERROR_NO_AD_AVAILABLE");
            dispatchErrorEvent(fwconst.ERROR_NO_AD_AVAILABLE(), "No ad available.");
            return;
        } else
        {
            Log.i("LiveRailRenderer", "Dispatching EVENT_AD_STOPPED");
            context.dispatchEvent(context.getConstants().EVENT_AD_STOPPED());
            return;
        }
    }

    private void dispatchErrorEvent(final String map, String s)
    {
        Log.w("LiveRailRenderer", (new StringBuilder("Dispatching EVENT_ERROR code=")).append(map).append(" info=").append(s).toString());
        Bundle bundle = new Bundle();
        bundle.putString(fwconst.INFO_KEY_ERROR_CODE(), map);
        bundle.putString(fwconst.INFO_KEY_ERROR_INFO(), s);
        map = new HashMap();
        map.put(fwconst.INFO_KEY_EXTRA_INFO(), bundle);
        (new Handler(context.getActivity().getMainLooper())).post(new Runnable() {

            final LiveRailFWRenderer this$0;
            private final HashMap val$map;

            public void run()
            {
                context.dispatchEvent(fwconst.EVENT_ERROR(), map);
            }

            
            {
                this$0 = LiveRailFWRenderer.this;
                map = hashmap;
                super();
            }
        });
    }

    public void dispose()
    {
        Log.i("LiveRailRenderer", "FW >> dispose()");
        isInitComplete = false;
        isAdImpression = false;
        if (parentView != null && adView != null)
        {
            Log.v("LiveRailRenderer", "Removing LiveRail from view container");
            adView.stopAd();
            parentView.removeView(adView);
        }
        parentView = null;
        adView = null;
        Log.v("LiveRailRenderer", "Dispatching EVENT_AD_STOPPED");
        context.dispatchEvent(context.getConstants().EVENT_AD_STOPPED());
    }

    public double getDuration()
    {
        double d = -1D;
        if (adView != null)
        {
            d = adView.getAdDuration();
        }
        Log.v("LiveRailRenderer", (new StringBuilder("FW >> getDuration() return ")).append(d).toString());
        if (d > 0.0D)
        {
            return d;
        } else
        {
            return -1D;
        }
    }

    public HashMap getModuleInfo()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("moduleType", "renderer");
        hashmap.put("requiredAPIVersion", "5.5.1-r9816-1304230605");
        return hashmap;
    }

    public double getPlayheadTime()
    {
        double d = -1D;
        if (adView != null)
        {
            d = adView.getAdDuration() - adView.getAdRemainingTime();
        }
        Log.v("LiveRailRenderer", (new StringBuilder("FW >> getPlayheadTime() return ")).append(d).toString());
        if (d >= 0.0D)
        {
            return d;
        } else
        {
            return -1D;
        }
    }

    public void load(IRendererContext irenderercontext)
    {
        HashMap hashmap;
        String as[];
        int i;
        Log.i("LiveRailRenderer", "FW >> load()");
        context = irenderercontext;
        fwconst = context.getConstants();
        slot = context.getAdInstance().getSlot();
        context.setRendererCapability(fwconst.EVENT_AD_PAUSE(), fwconst.CAPABILITY_STATUS_ON());
        context.setRendererCapability(fwconst.EVENT_AD_RESUME(), fwconst.CAPABILITY_STATUS_ON());
        context.setRendererCapability(fwconst.EVENT_AD_FIRST_QUARTILE(), fwconst.CAPABILITY_STATUS_ON());
        context.setRendererCapability(fwconst.EVENT_AD_MIDPOINT(), fwconst.CAPABILITY_STATUS_ON());
        context.setRendererCapability(fwconst.EVENT_AD_THIRD_QUARTILE(), fwconst.CAPABILITY_STATUS_ON());
        context.setRendererCapability(fwconst.EVENT_AD_COMPLETE(), fwconst.CAPABILITY_STATUS_ON());
        isInitComplete = false;
        try
        {
            parentView = slot.getBase();
        }
        // Misplaced declaration of an exception variable
        catch (IRendererContext irenderercontext)
        {
            irenderercontext.printStackTrace();
        }
        if (parentView == null)
        {
            Log.w("LiveRailRenderer", "Failed to get slot.getBase()");
            try
            {
                parentView = (ViewGroup)context.getVideoDisplay().getParent();
            }
            // Misplaced declaration of an exception variable
            catch (IRendererContext irenderercontext)
            {
                irenderercontext.printStackTrace();
            }
        }
        if (parentView == null)
        {
            Log.w("LiveRailRenderer", "Failed to retrieve the parent view.");
            try
            {
                parentView = (ViewGroup)context.getActivity().getWindow().getDecorView().getRootView();
            }
            // Misplaced declaration of an exception variable
            catch (IRendererContext irenderercontext)
            {
                irenderercontext.printStackTrace();
            }
        }
        if (parentView == null)
        {
            dispatchErrorEvent(fwconst.ERROR_INVALID_VALUE(), "Failed to retrieve ViewGroup container for the ad.");
            return;
        }
        if (slot.getType() != fwconst.SLOT_TYPE_TEMPORAL())
        {
            dispatchErrorEvent(fwconst.ERROR_INVALID_SLOT(), "LiveRail only supports temporal slots.");
            return;
        }
        hashmap = new HashMap();
        hashmap.put("LR_PLAYER_HANDLES_CLICK", "1");
        hashmap.put("LR_INTEGRATION", "fw");
        int j;
        if (slot.getTimePositionClass() == fwconst.TIME_POSITION_CLASS_PREROLL())
        {
            hashmap.put("LR_ADMAP", "in::0");
            hashmap.put("LR_VIDEO_POSITION", "0");
        } else
        if (slot.getTimePositionClass() == fwconst.TIME_POSITION_CLASS_POSTROLL())
        {
            hashmap.put("LR_ADMAP", "in::0");
            hashmap.put("LR_VIDEO_POSITION", "100%");
        } else
        if (slot.getTimePositionClass() == fwconst.TIME_POSITION_CLASS_OVERLAY())
        {
            hashmap.put("LR_ADMAP", "ov::0");
            hashmap.put("LR_VIDEO_POSITION", String.valueOf(slot.getTimePosition()));
        } else
        {
            hashmap.put("LR_ADMAP", "in::0");
            hashmap.put("LR_VIDEO_POSITION", String.valueOf(slot.getTimePosition()));
        }
        irenderercontext = supportedLRParams;
        j = irenderercontext.length;
        i = 0;
_L5:
        if (i < j) goto _L2; else goto _L1
_L1:
        irenderercontext = (String)context.getParameter("parameters");
        if (irenderercontext == null || irenderercontext.isEmpty())
        {
            break MISSING_BLOCK_LABEL_927;
        }
        Log.d("LiveRailRenderer", (new StringBuilder("Found extra parameters ")).append(irenderercontext).toString());
        as = TextUtils.split(irenderercontext, "&");
        j = as.length;
        i = 0;
_L8:
        if (i < j) goto _L4; else goto _L3
_L3:
        String s;
        Object obj;
        String s1;
        if (hashmap.get("LR_PUBLISHER_ID") == null || ((String)hashmap.get("LR_PUBLISHER_ID")).isEmpty())
        {
            dispatchErrorEvent(fwconst.ERROR_MISSING_PARAMETER(), "Missing LR_PUBLISHER_ID parameter.");
            return;
        } else
        {
            adView = new AdView(context.getActivity());
            Log.v("LiveRailRenderer", "Adding LiveRail to container view.");
            irenderercontext = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            parentView.addView(adView, irenderercontext);
            adView.addEventListener("AdLoaded", onAdLoaded);
            adView.addEventListener("AdImpression", onAdImpression);
            adView.addEventListener("AdStopped", onAdStopped);
            adView.addEventListener("AdError", onAdError);
            adView.addEventListener("AdVideoFirstQuartile", onAdProgressListener);
            adView.addEventListener("AdVideoMidpoint", onAdProgressListener);
            adView.addEventListener("AdVideoThirdQuartile", onAdProgressListener);
            adView.addEventListener("AdVideoComplete", onAdProgressListener);
            adView.addEventListener("AdClickThru", onAdClickThrough);
            Log.d("LiveRailRenderer", "adView.initAd()");
            adView.initAd(hashmap);
            return;
        }
_L2:
        s = irenderercontext[i];
        obj = context.getParameter(s);
        if (obj != null)
        {
            hashmap.put(s, obj.toString());
        }
        i++;
          goto _L5
_L4:
        s = as[i];
        irenderercontext = TextUtils.split(s, "=");
        if (irenderercontext.length < 2)
        {
            break MISSING_BLOCK_LABEL_901;
        }
        s1 = irenderercontext[0];
        s = irenderercontext[1];
        if (s1.isEmpty() || !s1.substring(0, 3).equalsIgnoreCase("LR_")) goto _L7; else goto _L6
_L6:
        irenderercontext = null;
        obj = URLDecoder.decode(s, "UTF-8");
        irenderercontext = ((IRendererContext) (obj));
_L9:
        Exception exception;
        if (irenderercontext == null)
        {
            irenderercontext = s;
        }
        hashmap.put(s1, irenderercontext);
_L7:
        i++;
          goto _L8
        exception;
        exception.printStackTrace();
          goto _L9
        Log.w("LiveRailRenderer", (new StringBuilder("Invalid key/value pair: ")).append(s).toString());
          goto _L7
        Log.v("LiveRailRenderer", "No extra parameters defined.");
          goto _L3
    }

    public void pause()
    {
        Log.i("LiveRailRenderer", "FW >> pause()");
        if (adView != null && isInitComplete)
        {
            adView.pauseAd();
            Log.v("LiveRailRenderer", "Dispatching EVENT_AD_PAUSE");
            context.dispatchEvent(context.getConstants().EVENT_AD_PAUSE());
        }
    }

    public void resize()
    {
        if (slot != null)
        {
            Log.i("LiveRailRenderer", (new StringBuilder("FW >> resize() ")).append(slot.getWidth()).append("x").append(slot.getHeight()).toString());
        }
    }

    public void resume()
    {
        Log.i("LiveRailRenderer", "FW >> resume()");
        if (adView != null && isInitComplete)
        {
            adView.bringToFront();
            adView.resumeAd();
            Log.v("LiveRailRenderer", "Dispatching EVENT_AD_RESUME");
            context.dispatchEvent(context.getConstants().EVENT_AD_RESUME());
        }
    }

    public void start()
    {
        Log.i("LiveRailRenderer", "FW >> start()");
        isAdImpression = false;
        adView.bringToFront();
        adView.requestFocus();
        Log.d("LiveRailRenderer", "adView.startAd()");
        adView.startAd();
    }

    public void stop()
    {
        Log.i("LiveRailRenderer", "FW >> stop()");
        if (adView != null)
        {
            adView.stopAd();
        }
        Log.v("LiveRailRenderer", "Dispatching EVENT_AD_STOPPED");
        context.dispatchEvent(context.getConstants().EVENT_AD_STOPPED());
    }






}

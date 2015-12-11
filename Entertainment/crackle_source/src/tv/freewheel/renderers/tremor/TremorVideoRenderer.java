// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.tremor;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import com.tremorvideo.sdk.android.FWAdapter.FWAdapterCallbackListener;
import com.tremorvideo.sdk.android.FWAdapter.FWAdapterCalls;
import com.tremorvideo.sdk.android.videoad.Settings;
import com.tremorvideo.sdk.android.videoad.TremorVideo;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.renderers.interfaces.IRendererContext;

public class TremorVideoRenderer
    implements FWAdapterCallbackListener, IRenderer
{
    class checkAdIsReady extends TimerTask
    {

        final TremorVideoRenderer this$0;

        public void run()
        {
            if (TremorVideo.isAdReady())
            {
                _isReadyCheckTimer.purge();
                _isReadyCheckTimer.cancel();
                _isReadyCheckTimer = null;
                rendererContext.dispatchEvent(rendererContext.getConstants().EVENT_AD_LOADED());
            } else
            if (!TremorVideo.isDownloadStarted())
            {
                failWithError(rendererContext.getConstants().ERROR_NO_AD_AVAILABLE(), "Unable to load Ad");
                return;
            }
        }

        checkAdIsReady()
        {
            this$0 = TremorVideoRenderer.this;
            super();
        }
    }


    private static final String CLASSTAG = "TremorVideoRenderer";
    static final int TREMORVIDEO_REQUEST_CODE = 48879;
    private Activity _activity;
    private Timer _isReadyCheckTimer;
    private boolean _registeredImpression;
    private IActivityCallbackListener activityCallbackListener;
    private IRendererContext rendererContext;

    public TremorVideoRenderer()
    {
        Log.i("TremorVideoRenderer", "trunk-r5014-1202080537");
    }

    private void failWithError(String s, String s1)
    {
        Log.e("TremorVideoRenderer", (new StringBuilder()).append("errorMessage: ").append(s1).toString());
        if (_isReadyCheckTimer != null)
        {
            _isReadyCheckTimer.purge();
            _isReadyCheckTimer.cancel();
            _isReadyCheckTimer = null;
        }
        activityCallbackListener = null;
        FWAdapterCalls.clearListener();
        Bundle bundle = new Bundle();
        IConstants iconstants = rendererContext.getConstants();
        bundle.putString(iconstants.INFO_KEY_ERROR_CODE(), s);
        bundle.putString(iconstants.INFO_KEY_ERROR_INFO(), s1);
        s = new HashMap();
        s.put(iconstants.INFO_KEY_EXTRA_INFO(), bundle);
        rendererContext.dispatchEvent(iconstants.EVENT_ERROR(), s);
    }

    public void dispose()
    {
        if (!_registeredImpression)
        {
            TremorVideo.registerAvailableImpression(_activity);
        }
        if (_isReadyCheckTimer != null)
        {
            _isReadyCheckTimer.purge();
            _isReadyCheckTimer.cancel();
            _isReadyCheckTimer = null;
        }
        FWAdapterCalls.clearListener();
        activityCallbackListener = null;
        _activity = null;
    }

    public double getDuration()
    {
        double d = TremorVideo.getAdDuration();
        if (d == -1D)
        {
            return -1D;
        } else
        {
            return d / 1000D;
        }
    }

    public HashMap getModuleInfo()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("moduleType", "renderer");
        hashmap.put("requiredAPIVersion", "5.5.0-r9798-1304150654");
        return hashmap;
    }

    public String getParamAsString(String s)
    {
        s = ((String) (rendererContext.getParameter(s)));
        if (s == null)
        {
            return "";
        } else
        {
            return s.toString();
        }
    }

    public double getPlayheadTime()
    {
        double d = TremorVideo.getPlayheadTime();
        if (d == -1D)
        {
            return -1D;
        } else
        {
            return d / 1000D;
        }
    }

    public void load(IRendererContext irenderercontext)
    {
        rendererContext = irenderercontext;
        _activity = irenderercontext.getActivity();
        _registeredImpression = false;
        Object obj = irenderercontext.getConstants();
        irenderercontext.setRendererCapability(((IConstants) (obj)).EVENT_AD_CLICK(), ((IConstants) (obj)).CAPABILITY_STATUS_OFF());
        FWAdapterCalls.setFWCallBackListener(this);
        obj = irenderercontext.getParameter("tremorSiteId");
        if (obj == null || obj.toString().length() == 0)
        {
            failWithError(irenderercontext.getConstants().ERROR_MISSING_PARAMETER(), "Unable to find tremorSiteId");
            return;
        }
        obj = obj.toString();
        TremorVideo.initialize(_activity, ((String) (obj)));
        obj = new Settings();
        String s = getParamAsString("userAge");
        if (s.length() > 0)
        {
            obj.userAge = Integer.parseInt(s);
        }
        s = getParamAsString("userGender");
        if (s.startsWith("m"))
        {
            obj.userGender = com.tremorvideo.sdk.android.videoad.Settings.Gender.Male;
        } else
        if (s.startsWith("f"))
        {
            obj.userGender = com.tremorvideo.sdk.android.videoad.Settings.Gender.Felmale;
        } else
        {
            obj.userGender = com.tremorvideo.sdk.android.videoad.Settings.Gender.Unknown;
        }
        s = getParamAsString("userLanguage");
        if (s.length() > 0)
        {
            obj.userLanguage = s;
        }
        s = getParamAsString("userCountry");
        if (s.length() > 0)
        {
            obj.userCountry = s;
        }
        s = getParamAsString("userZip");
        if (s.length() > 0)
        {
            obj.userZip = s;
        }
        s = getParamAsString("contentTitle");
        if (s.length() > 0)
        {
            obj.contentTitle = s;
        }
        s = getParamAsString("contentID");
        if (s.length() > 0)
        {
            obj.contentID = s;
        }
        s = getParamAsString("contentDescription");
        if (s.length() > 0)
        {
            obj.contentDescription = s;
        }
        if (irenderercontext.getLocation() != null)
        {
            obj.userLongitude = irenderercontext.getLocation().getLongitude();
            obj.userLatitude = irenderercontext.getLocation().getLatitude();
        }
        TremorVideo.updateSettings(((Settings) (obj)));
        TremorVideo.start();
        _isReadyCheckTimer = new Timer();
        _isReadyCheckTimer.schedule(new checkAdIsReady(), 0L, 1000L);
    }

    public void onAdFailed()
    {
        failWithError(rendererContext.getConstants().ERROR_NO_AD_AVAILABLE(), "No Ad Avail");
    }

    public void onAdFinished()
    {
    }

    public void onAdReady()
    {
    }

    public void onLeaveAd()
    {
    }

    public void pause()
    {
    }

    public void resize()
    {
    }

    public void resume()
    {
    }

    public void start()
    {
        _registeredImpression = true;
        if (!TremorVideo.isAdReady())
        {
            break MISSING_BLOCK_LABEL_191;
        }
        if (!TremorVideo.showAd(rendererContext.getActivity(), 48879))
        {
            failWithError(rendererContext.getConstants().ERROR_NO_AD_AVAILABLE(), "Failed to show ad");
            return;
        }
        try
        {
            rendererContext.dispatchEvent(rendererContext.getConstants().EVENT_AD_STARTED());
            if (_isReadyCheckTimer != null)
            {
                _isReadyCheckTimer.purge();
                _isReadyCheckTimer.cancel();
                _isReadyCheckTimer = null;
            }
            activityCallbackListener = new IActivityCallbackListener() {

                final TremorVideoRenderer this$0;
                final IConstants val$constants;

                public void onActivityCallback(int i)
                {
                    if (i == constants.ACTIVITY_CALLBACK_RESUME())
                    {
                        rendererContext.dispatchEvent(constants.EVENT_AD_STOPPED());
                    }
                }

            
            {
                this$0 = TremorVideoRenderer.this;
                constants = iconstants;
                super();
            }
            };
            rendererContext.addOnActivityCallbackListener(activityCallbackListener);
            return;
        }
        catch (Exception exception)
        {
            failWithError(rendererContext.getConstants().ERROR_NO_AD_AVAILABLE(), (new StringBuilder()).append("Error Starting Ad: ").append(exception.getCause()).append("\n").append(exception.getMessage()).toString());
        }
        return;
        TremorVideo.registerAvailableImpression(_activity);
        return;
    }

    public void stop()
    {
        if (_isReadyCheckTimer != null)
        {
            _isReadyCheckTimer.purge();
            _isReadyCheckTimer.cancel();
            _isReadyCheckTimer = null;
        }
        FWAdapterCalls.clearListener();
        rendererContext.dispatchEvent(rendererContext.getConstants().EVENT_AD_STOPPED());
    }




/*
    static Timer access$102(TremorVideoRenderer tremorvideorenderer, Timer timer)
    {
        tremorvideorenderer._isReadyCheckTimer = timer;
        return timer;
    }

*/

}

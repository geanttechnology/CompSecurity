// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.RelativeLayout;

// Referenced classes of package com.millennialmedia.android:
//            MMBaseActivity, AdViewOverlayView, MMActivity, OverlaySettings, 
//            MMAdImpl, MMAdImplController, MMWebView

class AdViewOverlayActivity extends MMBaseActivity
{

    private SensorEventListener accelerometerEventListener;
    private AdViewOverlayView adViewOverlayView;
    boolean hasFocus;
    private final int interval = 1000;
    boolean isPaused;
    private SensorManager sensorManager;
    private OverlaySettings settings;
    private final float threshold = 0.2F;

    AdViewOverlayActivity()
    {
        accelerometerEventListener = new SensorEventListener() {

            private long currentTime;
            private float force;
            private float lastX;
            private float lastY;
            private float lastZ;
            private long prevShakeTime;
            private long prevTime;
            final AdViewOverlayActivity this$0;
            private long timeDifference;
            private float x;
            private float y;
            private float z;

            public void onAccuracyChanged(Sensor sensor, int i)
            {
            }

            public void onSensorChanged(SensorEvent sensorevent)
            {
                currentTime = sensorevent.timestamp;
                x = sensorevent.values[0];
                y = sensorevent.values[1];
                z = sensorevent.values[2];
                timeDifference = currentTime - prevTime;
                if (timeDifference > 500L)
                {
                    didAccelerate(x, y, z);
                    force = Math.abs((x + y + z) - lastX - lastY - lastZ) / (float)timeDifference;
                    didAccelerate(x, y, z);
                    if (force > 0.2F)
                    {
                        if (currentTime - prevShakeTime >= 1000L)
                        {
                            didShake(force);
                        }
                        prevShakeTime = currentTime;
                    }
                    lastX = x;
                    lastY = y;
                    lastZ = z;
                    prevTime = currentTime;
                }
            }

            
            {
                this$0 = AdViewOverlayActivity.this;
                super();
                x = 0.0F;
                y = 0.0F;
                z = 0.0F;
                lastX = 0.0F;
                lastY = 0.0F;
                lastZ = 0.0F;
                force = 0.0F;
                currentTime = 0L;
                prevTime = 0L;
                timeDifference = 0L;
                prevShakeTime = 0L;
            }
        };
    }

    private void didAccelerate(float f, float f1, float f2)
    {
        MMSDK.Log.v("Accelerometer x:%fy:%fz:%f", new Object[] {
            Float.valueOf(f), Float.valueOf(f1), Float.valueOf(f2)
        });
        adViewOverlayView.injectJS((new StringBuilder()).append("javascript:didAccelerate(").append(f).append(",").append(f1).append(",").append(f2).append(")").toString());
    }

    private void didShake(float f)
    {
        MMSDK.Log.v("Phone shaken: %f", new Object[] {
            Float.valueOf(f)
        });
        adViewOverlayView.injectJS((new StringBuilder()).append("javascript:didShake(").append(f).append(")").toString());
    }

    private void lockOrientation()
    {
        if (activity.getRequestedOrientation() == 0)
        {
            setRequestedOrientation(0);
            return;
        }
        if (activity.getRequestedOrientation() == 8)
        {
            setRequestedOrientation(8);
            return;
        }
        if (activity.getRequestedOrientation() == 9)
        {
            setRequestedOrientation(9);
            return;
        } else
        {
            setRequestedOrientation(1);
            return;
        }
    }

    private void setRequestedOrientation(String s)
    {
        if ("landscape".equalsIgnoreCase(s))
        {
            setRequestedOrientation(0);
        } else
        if ("portrait".equalsIgnoreCase(s))
        {
            setRequestedOrientation(1);
            return;
        }
    }

    private void startAccelerating()
    {
        sensorManager = (SensorManager)getSystemService("sensor");
        if (!Boolean.valueOf(sensorManager.registerListener(accelerometerEventListener, sensorManager.getDefaultSensor(1), 1)).booleanValue())
        {
            MMSDK.Log.w("Accelerometer not supported by this device. Unregistering listener.");
            sensorManager.unregisterListener(accelerometerEventListener, sensorManager.getDefaultSensor(1));
            accelerometerEventListener = null;
            sensorManager = null;
        }
    }

    private void stopAccelerating()
    {
        try
        {
            if (sensorManager != null && accelerometerEventListener != null)
            {
                sensorManager.unregisterListener(accelerometerEventListener, sensorManager.getDefaultSensor(1));
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void finish()
    {
        if (adViewOverlayView != null)
        {
            adViewOverlayView.attachWebViewToLink();
        }
        super.finish();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (adViewOverlayView != null)
        {
            adViewOverlayView.inlineConfigChange();
        }
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        setTheme(0x1030010);
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().clearFlags(1024);
        getWindow().addFlags(2048);
        getWindow().addFlags(0x1000000);
        bundle = getIntent();
        settings = (OverlaySettings)bundle.getParcelableExtra("settings");
        if (settings == null)
        {
            settings = new OverlaySettings();
        }
        settings.log();
        if (settings.orientation != null)
        {
            setRequestedOrientation(settings.orientation);
        }
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if (settings.allowOrientationChange)
        {
            unlockScreenOrientation();
        } else
        {
            lockOrientation();
        }
        if (bundle != null)
        {
            bundle = bundle.getData();
            if (bundle != null)
            {
                MMSDK.Log.v("Path: %s", new Object[] {
                    bundle.getLastPathSegment()
                });
            }
        }
        bundle = new RelativeLayout(activity);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        bundle.setId(0x34c60db9);
        bundle.setLayoutParams(layoutparams);
        adViewOverlayView = new AdViewOverlayView(this, settings);
        bundle.addView(adViewOverlayView);
        setContentView(bundle);
        if (getLastNonConfigurationInstance() != null) goto _L2; else goto _L1
_L1:
        if (!settings.isExpanded()) goto _L4; else goto _L3
_L3:
        adViewOverlayView.adImpl.controller.webView.setMraidExpanded();
        if (settings.hasExpandUrl())
        {
            adViewOverlayView.getWebContent(settings.urlToLoad);
        }
_L2:
        settings.orientation = null;
        return;
_L4:
        if (!settings.isExpanded())
        {
            adViewOverlayView.loadWebContent(settings.content, settings.adUrl);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void onDestroy()
    {
        super.onDestroy();
        MMSDK.Log.d("Overlay onDestroy");
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0)
        {
            adViewOverlayView.finishOverlayWithAnimation();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onPause()
    {
        isPaused = true;
        MMSDK.Log.d("Overlay onPause");
        if (settings.canAccelerate)
        {
            stopAccelerating();
        }
        BridgeMMMedia.Audio.sharedAudio(activity).stop();
        adViewOverlayView.pauseVideo();
        setResult(0);
        adViewOverlayView.adImpl.controller.pauseWebViewVideo();
        super.onPause();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        isPaused = false;
        MMSDK.Log.d("Overlay onResume");
        if (settings.canAccelerate)
        {
            startAccelerating();
        }
        if (hasFocus)
        {
            adViewOverlayView.resumeVideo();
        }
        adViewOverlayView.addBlackView();
        adViewOverlayView.adImpl.controller.resumeWebViewVideo();
        super.onResume();
    }

    public Object onRetainNonConfigurationInstance()
    {
        return adViewOverlayView.getNonConfigurationInstance();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("adViewId", adViewOverlayView.getId());
        super.onSaveInstanceState(bundle);
    }

    protected void onStop()
    {
        super.onStop();
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        hasFocus = flag;
        if (!isPaused && flag)
        {
            adViewOverlayView.resumeVideo();
        }
    }

    void setAllowOrientationChange(boolean flag)
    {
        settings.allowOrientationChange = flag;
        if (flag)
        {
            unlockScreenOrientation();
            return;
        } else
        {
            lockOrientation();
            return;
        }
    }

    void setRequestedOrientationLandscape()
    {
        settings.orientation = "landscape";
        settings.allowOrientationChange = false;
        setRequestedOrientation(0);
    }

    void setRequestedOrientationPortrait()
    {
        settings.orientation = "portrait";
        settings.allowOrientationChange = false;
        setRequestedOrientation(1);
    }

    void unlockScreenOrientation()
    {
        setRequestedOrientation(-1);
    }


}

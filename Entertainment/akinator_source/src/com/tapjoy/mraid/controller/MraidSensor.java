// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.controller;

import android.content.Context;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.listener.Accel;
import com.tapjoy.mraid.view.MraidView;

// Referenced classes of package com.tapjoy.mraid.controller:
//            Abstract

public class MraidSensor extends Abstract
{

    final int c = 1000;
    private Accel d;
    private float e;
    private float f;
    private float g;

    public MraidSensor(MraidView mraidview, Context context)
    {
        super(mraidview, context);
        e = 0.0F;
        f = 0.0F;
        g = 0.0F;
        d = new Accel(context, this);
    }

    public float getHeading()
    {
        TapjoyLog.d("MRAID Sensor", (new StringBuilder("getHeading: ")).append(d.getHeading()).toString());
        return d.getHeading();
    }

    public String getTilt()
    {
        String s = (new StringBuilder("{ x : \"")).append(e).append("\", y : \"").append(f).append("\", z : \"").append(g).append("\"}").toString();
        TapjoyLog.d("MRAID Sensor", (new StringBuilder("getTilt: ")).append(s).toString());
        return s;
    }

    public void onHeadingChange(float f1)
    {
        String s = (new StringBuilder("window.mraidview.fireChangeEvent({ heading: ")).append((int)((double)f1 * 57.295779513082323D)).append("});").toString();
        TapjoyLog.d("MRAID Sensor", s);
        a.injectMraidJavaScript(s);
    }

    public void onShake()
    {
        a.injectMraidJavaScript("mraid.gotShake()");
    }

    public void onTilt(float f1, float f2, float f3)
    {
        e = f1;
        f = f2;
        g = f3;
        String s = (new StringBuilder("window.mraidview.fireChangeEvent({ tilt: ")).append(getTilt()).append("})").toString();
        TapjoyLog.d("MRAID Sensor", s);
        a.injectMraidJavaScript(s);
    }

    public void startHeadingListener()
    {
        d.startTrackingHeading();
    }

    public void startShakeListener()
    {
        d.startTrackingShake();
    }

    public void startTiltListener()
    {
        d.startTrackingTilt();
    }

    public void stopAllListeners()
    {
        d.stopAllListeners();
    }

    public void stopHeadingListener()
    {
        d.stopTrackingHeading();
    }

    public void stopShakeListener()
    {
        d.stopTrackingShake();
    }

    public void stopTiltListener()
    {
        d.stopTrackingTilt();
    }
}

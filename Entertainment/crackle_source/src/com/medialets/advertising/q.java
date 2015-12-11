// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

// Referenced classes of package com.medialets.advertising:
//            JSBridge, a, AdView, AdWebView

final class q
    implements SensorEventListener
{

    private JSBridge a;

    q(JSBridge jsbridge)
    {
        a = jsbridge;
        super();
    }

    public final void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public final void onSensorChanged(SensorEvent sensorevent)
    {
        sensorevent = sensorevent.values;
        Class class1 = JSBridge.a();
        class1;
        JVM INSTR monitorenter ;
        float f;
        float f1;
        float f2;
        f = sensorevent[0] / 9.81F;
        f1 = sensorevent[1] / 9.81F;
        f2 = sensorevent[2] / 9.81F;
        if (f >= 0.0F) goto _L2; else goto _L1
_L1:
        f = Math.abs(f);
_L5:
        if (f1 >= 0.0F) goto _L4; else goto _L3
_L3:
        f1 = Math.abs(f1);
_L6:
        if (f2 >= 0.0F)
        {
            break MISSING_BLOCK_LABEL_475;
        }
        f2 = Math.abs(f2);
_L7:
        float f3;
        JSBridge.a(a, JSBridge.e(a) * f + JSBridge.f(a) * (1.0F - JSBridge.e(a)));
        JSBridge.b(a, JSBridge.e(a) * f1 + JSBridge.g(a) * (1.0F - JSBridge.e(a)));
        JSBridge.c(a, JSBridge.e(a) * f2 + JSBridge.h(a) * (1.0F - JSBridge.e(a)));
        f3 = f - JSBridge.f(a);
        float f4 = f1 - JSBridge.g(a);
        float f5 = f2 - JSBridge.h(a);
        f3 = (float)Math.sqrt(f3 * f3 + f4 * f4 + f5 * f5);
        sensorevent = "";
        if (f3 <= JSBridge.i(a))
        {
            break MISSING_BLOCK_LABEL_259;
        }
        com.medialets.advertising.a.a("Shake event has been detected...");
        sensorevent = "if (Device.Acceleration.shakeCallback) Device.Acceleration.shakeCallback();";
        String s = String.format("javascript:if (Device.Acceleration._callback) Device.Acceleration._callback('%f', '%f', '%f', '%f','%f', '%f'); %s", new Object[] {
            Float.valueOf(f), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(JSBridge.f(a)), Float.valueOf(JSBridge.g(a)), Float.valueOf(JSBridge.h(a)), sensorevent
        });
        sensorevent = String.format("javascript:if (Device.Acceleration._callback) Device.Acceleration._callback('%f', '%f', '%f', '%f','%f', '%f'); %s", new Object[] {
            Float.valueOf(f), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(JSBridge.f(a)), Float.valueOf(JSBridge.g(a)), Float.valueOf(JSBridge.h(a)), sensorevent
        });
        if (JSBridge.c(a) != null)
        {
            JSBridge.c(a).getAdWebView().loadUrl(s);
            JSBridge.c(a).getAdWebView().loadUrl(sensorevent);
        }
        class1;
        JVM INSTR monitorexit ;
        return;
        sensorevent;
        class1;
        JVM INSTR monitorexit ;
        throw sensorevent;
_L2:
        f = -f;
          goto _L5
_L4:
        f1 = -f1;
          goto _L6
        f2 = -f2;
          goto _L7
    }
}

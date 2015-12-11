// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.tracking;

import android.app.Application;
import com.adobe.mobile.Analytics;
import com.adobe.mobile.Config;
import com.comcast.cim.android.PropertyService;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import java.util.HashMap;

public abstract class CimAppMeasurement
{

    private HashMap cdata;

    public CimAppMeasurement(Application application, String s, AndroidDevice androiddevice, PropertyService propertyservice)
    {
        cdata = new HashMap();
        Config.setContext(application);
        Config.setDebugLogging(Boolean.valueOf(propertyservice.getOmnitureDebug()));
        setAppVersion(s);
        setAndroidOsVersionField(androiddevice);
        configureAppSpecificFields();
    }

    private void setAndroidOsVersionField(AndroidDevice androiddevice)
    {
        putCdata("OSVersion", androiddevice.getAndroidPrefixedBuildVersionRelease());
    }

    private void setAppVersion(String s)
    {
        putCdata("appVersion", s);
    }

    protected abstract void configureAppSpecificFields();

    public void putCdata(String s, Object obj)
    {
        cdata.put(s, obj);
    }

    public void setEvents(String s)
    {
        cdata.put("&&events", s);
    }

    public void setProducts(String s)
    {
        cdata.put("&&products", s);
    }

    public void trackAction(String s)
    {
        Analytics.trackAction(s, cdata);
    }

    public void trackState(String s)
    {
        Analytics.trackState(s, cdata);
    }
}

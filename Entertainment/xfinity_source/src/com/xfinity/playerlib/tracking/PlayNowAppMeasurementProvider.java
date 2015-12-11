// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.tracking;

import com.comcast.cim.android.PropertyService;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.xfinity.playerlib.PlayerApplication;

// Referenced classes of package com.xfinity.playerlib.tracking:
//            PlayNowAppMeasurement

public class PlayNowAppMeasurementProvider
    implements Provider
{

    private AndroidDevice androidDevice;
    private PlayerApplication application;
    private String applicationName;
    private PropertyService propertyService;

    public PlayNowAppMeasurementProvider(PlayerApplication playerapplication, AndroidDevice androiddevice, PropertyService propertyservice, String s)
    {
        application = playerapplication;
        androidDevice = androiddevice;
        propertyService = propertyservice;
        applicationName = s;
    }

    public PlayNowAppMeasurement get()
    {
        return new PlayNowAppMeasurement(application, androidDevice, propertyService, applicationName);
    }

    public volatile Object get()
    {
        return get();
    }
}

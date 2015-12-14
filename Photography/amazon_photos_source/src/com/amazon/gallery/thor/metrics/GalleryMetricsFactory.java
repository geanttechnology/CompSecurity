// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.metrics;

import android.content.Context;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.client.metrics.transport.OAuthHelper;
import com.amazon.device.crashmanager.CrashDetectionHelper;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.gallery.thor.app.ThorGalleryApplication;

// Referenced classes of package com.amazon.gallery.thor.metrics:
//            MAPOAuthHelper

public class GalleryMetricsFactory
{

    private static final String TAG = com/amazon/gallery/thor/metrics/GalleryMetricsFactory.getName();

    public GalleryMetricsFactory()
    {
    }

    private static MetricsFactory buildMetricsFactory(Context context, OAuthHelper oauthhelper, DeviceAttributeStore deviceattributestore)
    {
        GLogger.i(TAG, "creating 3p metrics factory.", new Object[0]);
        AndroidMetricsFactoryImpl.setOAuthHelper(context, oauthhelper);
        AndroidMetricsFactoryImpl.setDeviceType(context, deviceattributestore.getDeviceTypeId());
        AndroidMetricsFactoryImpl.setDeviceId(context, deviceattributestore.getUniqueDeviceId());
        return AndroidMetricsFactoryImpl.getInstance(context);
    }

    public static MetricsFactory getMetricsFactory(Context context)
    {
        DeviceAttributeStore deviceattributestore = (DeviceAttributeStore)ThorGalleryApplication.getBean(Keys.DEVICE_ATTRIBUTE_STORE);
        MAPOAuthHelper mapoauthhelper = new MAPOAuthHelper(context);
        MetricsFactory metricsfactory = buildMetricsFactory(context, mapoauthhelper, deviceattributestore);
        String s = deviceattributestore.getUniqueDeviceId();
        s = s.substring(0, Math.min(31, s.length()));
        CrashDetectionHelper.setUpCrashDetection(deviceattributestore.getDeviceTypeId(), s, mapoauthhelper, metricsfactory, context);
        return metricsfactory;
    }

}

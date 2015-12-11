// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.network.request;

import android.os.Build;
import android.util.DisplayMetrics;
import com.google.android.speech.SpeechSettings;
import com.google.android.speech.helper.SpeechLocationHelper;
import com.google.android.speech.params.DeviceParams;
import com.google.android.speech.params.RegionExperiment;
import egf;
import exa;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.speech.network.request:
//            BaseRequestBuilderTask

public class S3ClientInfoBuilderTask extends BaseRequestBuilderTask
{

    private static final String ANDROID_PLATFORM = "Android";
    private static final boolean DBG = false;
    private static final String TAG = "VS.S3ClientInfoBuilderTask";
    private final String mAppId;
    private final DeviceParams mDeviceParams;
    private final SpeechLocationHelper mLocationHelper;
    private final egf mRegionExperiments;
    private final SpeechSettings mSpeechSettings;
    private final String mTriggerApplicationId;

    public S3ClientInfoBuilderTask(SpeechLocationHelper speechlocationhelper, egf egf1, SpeechSettings speechsettings, String s, DeviceParams deviceparams, String s1)
    {
        super("S3ClientInfoBuilderTask");
        mLocationHelper = speechlocationhelper;
        mRegionExperiments = egf1;
        mSpeechSettings = speechsettings;
        mAppId = s;
        mDeviceParams = deviceparams;
        mTriggerApplicationId = s1;
    }

    protected exa build()
    {
        exa exa1 = (new exa()).a("").d("Android").e(Build.DISPLAY).f(mAppId).g(mDeviceParams.getApplicationVersion()).b(mDeviceParams.getUserAgent()).h(Build.MODEL);
        for (Iterator iterator = mSpeechSettings.getExperimentIds().iterator(); iterator.hasNext(); exa1.c((String)iterator.next())) { }
        Object obj = mLocationHelper.getAndroidLocation();
        if (obj != null)
        {
            Iterator iterator1 = ((List)mRegionExperiments.get()).iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                RegionExperiment regionexperiment = (RegionExperiment)iterator1.next();
                if (regionexperiment.isLocationInsideRegion(((android.location.Location) (obj))))
                {
                    exa1.c(regionexperiment.getExperimentId());
                }
            } while (true);
        }
        obj = mDeviceParams.getDisplayMetrics();
        if (obj != null)
        {
            exa1.a(((DisplayMetrics) (obj)).widthPixels).b(((DisplayMetrics) (obj)).heightPixels).c(((DisplayMetrics) (obj)).densityDpi);
        }
        if (mTriggerApplicationId != null)
        {
            exa1.i(mTriggerApplicationId);
        }
        return exa1;
    }

    protected volatile Object build()
    {
        return build();
    }
}

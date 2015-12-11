// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.params;

import com.google.android.speech.SpeechSettings;
import com.google.android.speech.helper.AuthTokenHelper;
import com.google.android.speech.helper.SpeechLocationHelper;
import com.google.android.speech.utils.NetworkInformation;
import dbi;
import egf;

// Referenced classes of package com.google.android.speech.params:
//            DeviceParams

public class NetworkRequestProducerParams
{

    private final AuthTokenHelper mAuthTokenHelper;
    private final DeviceParams mDeviceParams;
    private final SpeechLocationHelper mLocationHelper;
    private final NetworkInformation mNetworkInformation;
    private final dbi mPinholeParamsBuilder;
    private final egf mRegionExperimentsSupplier;
    private final SpeechSettings mSpeechSettings;
    private final egf mTopContactNamesSupplier;

    public NetworkRequestProducerParams(AuthTokenHelper authtokenhelper, NetworkInformation networkinformation, dbi dbi, SpeechLocationHelper speechlocationhelper, SpeechSettings speechsettings, DeviceParams deviceparams, egf egf, 
            egf egf1)
    {
        mAuthTokenHelper = authtokenhelper;
        mNetworkInformation = networkinformation;
        mPinholeParamsBuilder = dbi;
        mLocationHelper = speechlocationhelper;
        mSpeechSettings = speechsettings;
        mDeviceParams = deviceparams;
        mTopContactNamesSupplier = egf;
        mRegionExperimentsSupplier = egf1;
    }

    public AuthTokenHelper getAuthTokenHelper()
    {
        return mAuthTokenHelper;
    }

    public DeviceParams getDeviceParams()
    {
        return mDeviceParams;
    }

    public SpeechLocationHelper getLocationHelper()
    {
        return mLocationHelper;
    }

    public NetworkInformation getNetworkInformation()
    {
        return mNetworkInformation;
    }

    public dbi getPinholeParamsBuilder()
    {
        return mPinholeParamsBuilder;
    }

    public egf getRegionExperimentsSupplier()
    {
        return mRegionExperimentsSupplier;
    }

    public SpeechSettings getSpeechSettings()
    {
        return mSpeechSettings;
    }

    public egf getTopContactNamesSupplier()
    {
        return mTopContactNamesSupplier;
    }
}

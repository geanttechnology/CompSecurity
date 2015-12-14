// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk;

import android.util.Log;

// Referenced classes of package com.targetspot.android.sdk:
//            TSContentSize, TSAdType, TSGender, TSLocationType, 
//            TSAudioFormat, TSAudioBitrate

public class AdSettings
{

    private TSAdType adType;
    private double alphaForBackground;
    private TSAudioFormat audioFormat;
    private boolean backToBackMode;
    private TSAudioBitrate bitrate;
    private TSContentSize contentSize;
    private TSLocationType locationType;
    private boolean managedMode;
    private int maxNumAds;
    private int playbackLengths[] = {
        15
    };
    private double playbackVolume;
    private String postalCode;
    private boolean productionMode;
    private String targetSpotStation;
    private String testAccessor;
    private boolean testMode;
    private int userAge;
    private TSGender userGender;

    public AdSettings()
    {
        targetSpotStation = "";
        productionMode = true;
        managedMode = true;
        backToBackMode = false;
        testMode = false;
        alphaForBackground = 0.80000000000000004D;
        playbackVolume = 1.0D;
        contentSize = TSContentSize.TSContentSizeDefault;
        adType = TSAdType.TSAdTypeAudio;
        userGender = TSGender.TSGenderUnknown;
        userAge = 0;
        maxNumAds = -1;
        locationType = TSLocationType.TSLocationBestAvailable;
        postalCode = "";
        audioFormat = TSAudioFormat.TSAudioDefault;
        bitrate = TSAudioBitrate.TSAudioBitrateDefault;
        testAccessor = "hatersgonnahate";
    }

    public AdSettings(String s)
    {
        targetSpotStation = "";
        productionMode = true;
        managedMode = true;
        backToBackMode = false;
        testMode = false;
        alphaForBackground = 0.80000000000000004D;
        playbackVolume = 1.0D;
        contentSize = TSContentSize.TSContentSizeDefault;
        adType = TSAdType.TSAdTypeAudio;
        userGender = TSGender.TSGenderUnknown;
        userAge = 0;
        maxNumAds = -1;
        locationType = TSLocationType.TSLocationBestAvailable;
        postalCode = "";
        audioFormat = TSAudioFormat.TSAudioDefault;
        bitrate = TSAudioBitrate.TSAudioBitrateDefault;
        testAccessor = "hatersgonnahate";
        targetSpotStation = s;
    }

    public TSAdType getAdType()
    {
        return adType;
    }

    public double getAlphaForBackground()
    {
        return alphaForBackground;
    }

    public TSAudioBitrate getAudioBitrate()
    {
        return bitrate;
    }

    public TSAudioFormat getAudioFormat()
    {
        return audioFormat;
    }

    public TSContentSize getContentSize()
    {
        return contentSize;
    }

    public TSLocationType getLocationType()
    {
        return locationType;
    }

    public int getMaxNumAds()
    {
        return maxNumAds;
    }

    public int[] getPlaybackLengths()
    {
        return playbackLengths;
    }

    public double getPlaybackVolume()
    {
        return playbackVolume;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String getTargetSpotStation()
    {
        return targetSpotStation;
    }

    public boolean getTestMode()
    {
        return testMode;
    }

    public int getUserAge()
    {
        return userAge;
    }

    public TSGender getUserGender()
    {
        return userGender;
    }

    public boolean isBackToBackMode()
    {
        return backToBackMode;
    }

    public boolean isManagedMode()
    {
        return managedMode;
    }

    public boolean isProductionMode()
    {
        return productionMode;
    }

    public void setAdType(TSAdType tsadtype)
    {
        adType = tsadtype;
    }

    public void setAlphaForBackground(double d)
    {
        alphaForBackground = d;
    }

    public void setAudioBitrate(TSAudioBitrate tsaudiobitrate)
    {
        if (managedMode)
        {
            Log.e("AdSettings", "Cannot change audio bitrate when in managed mode");
            return;
        } else
        {
            bitrate = tsaudiobitrate;
            return;
        }
    }

    public void setAudioFormat(TSAudioFormat tsaudioformat)
    {
        if (managedMode)
        {
            Log.e("AdSettings", "Cannot change audio format when in managed mode");
            return;
        } else
        {
            audioFormat = tsaudioformat;
            return;
        }
    }

    public void setBackToBackMode(boolean flag)
    {
        if (isManagedMode())
        {
            backToBackMode = false;
            return;
        } else
        {
            backToBackMode = flag;
            return;
        }
    }

    public void setContentSize(TSContentSize tscontentsize)
    {
        contentSize = tscontentsize;
    }

    public void setLocationType(TSLocationType tslocationtype)
    {
        locationType = tslocationtype;
    }

    public void setManagedMode(boolean flag)
    {
        managedMode = flag;
    }

    public void setMaxNumAds(int i)
    {
        maxNumAds = i;
    }

    public void setPlaybackLengths(int ai[])
    {
        playbackLengths = ai;
    }

    public void setPlaybackVolume(double d)
    {
        playbackVolume = d;
    }

    public void setPostalCode(String s)
    {
        postalCode = s;
    }

    public void setProductionMode(boolean flag)
    {
        productionMode = flag;
    }

    public void setTargetSpotStation(String s)
    {
        targetSpotStation = s;
    }

    public void setTestMode(String s)
    {
        if (s.equals(testAccessor))
        {
            testMode = true;
            return;
        } else
        {
            testMode = false;
            return;
        }
    }

    public void setUserAge(int i)
    {
        userAge = i;
    }

    public void setUserGender(TSGender tsgender)
    {
        userGender = tsgender;
    }
}

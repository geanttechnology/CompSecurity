// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import com.amazon.android.webkit.AmazonWebKitCapabilities;

public class AndroidWebKitCapabilities extends AmazonWebKitCapabilities
{

    public AndroidWebKitCapabilities()
    {
    }

    public boolean isMediaDeviceSettingsSupported()
    {
        return false;
    }

    public boolean isOnCloudSupported()
    {
        return false;
    }

    public boolean isPluginManagerSupported()
    {
        return true;
    }

    public boolean isPreconnectSupported()
    {
        return false;
    }

    public boolean isPrerenderSupported()
    {
        return false;
    }

    public boolean isSendOutOfBandRequestSupported()
    {
        return false;
    }

    public boolean isWebViewGetCertificateSupported()
    {
        return true;
    }
}

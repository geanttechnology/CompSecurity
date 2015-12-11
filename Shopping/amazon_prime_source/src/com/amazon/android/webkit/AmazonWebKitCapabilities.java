// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


public abstract class AmazonWebKitCapabilities
{

    public AmazonWebKitCapabilities()
    {
    }

    public boolean canSetExtraLibraryPath()
    {
        return false;
    }

    public boolean isContentScrollBySupported()
    {
        return false;
    }

    public boolean isDeveloperToolsSupported()
    {
        return false;
    }

    public boolean isGetContentGeometrySupported()
    {
        return false;
    }

    public abstract boolean isMediaDeviceSettingsSupported();

    public abstract boolean isOnCloudSupported();

    public abstract boolean isPluginManagerSupported();

    public abstract boolean isPreconnectSupported();

    public abstract boolean isPrerenderSupported();

    public boolean isPrintingSupported()
    {
        return false;
    }

    public abstract boolean isSendOutOfBandRequestSupported();

    public boolean isSetEmbeddedVideoSupported()
    {
        return false;
    }

    public abstract boolean isWebViewGetCertificateSupported();
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.cordova.plugin;

import android.os.Bundle;
import org.apache.cordova.CordovaActivity;

public class AmazonMobileMASHCordovaPluginsAndroidLib extends CordovaActivity
{

    public AmazonMobileMASHCordovaPluginsAndroidLib()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        loadUrl(launchUrl);
    }
}

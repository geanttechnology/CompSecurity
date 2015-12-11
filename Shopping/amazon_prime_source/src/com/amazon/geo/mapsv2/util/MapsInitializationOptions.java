// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.os.Bundle;

public class MapsInitializationOptions
{

    public Boolean appProvidesAccount;
    public String engineAssetName;
    public Boolean forceNoAccount;

    public MapsInitializationOptions()
    {
        forceNoAccount = null;
        engineAssetName = null;
        appProvidesAccount = null;
    }

    public Bundle toBundle()
    {
        Bundle bundle = new Bundle();
        if (forceNoAccount != null)
        {
            bundle.putString("com.amazon.geo.mapsv2.forceNoAccount", Boolean.toString(forceNoAccount.booleanValue()));
            bundle.putString("com.amazon.geo.mapsv2.forceLocalKeyManagement", Boolean.toString(forceNoAccount.booleanValue()));
        }
        if (engineAssetName != null)
        {
            bundle.putString("com.amazon.geo.mapsv2.engineAssetName", engineAssetName);
        }
        if (appProvidesAccount != null)
        {
            bundle.putBoolean("com.amazon.geo.mapsv2.appProvidesAccountInfo", appProvidesAccount.booleanValue());
        }
        return bundle;
    }
}

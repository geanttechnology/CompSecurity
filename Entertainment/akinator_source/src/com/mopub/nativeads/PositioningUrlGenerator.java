// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;

class PositioningUrlGenerator extends BaseUrlGenerator
{

    private static final String POSITIONING_API_VERSION = "1";
    private String mAdUnitId;
    private final Context mContext;

    public PositioningUrlGenerator(Context context)
    {
        mContext = context;
    }

    private void setAdUnitId(String s)
    {
        addParam("id", s);
    }

    private void setSdkVersion(String s)
    {
        addParam("nsv", s);
    }

    public String generateUrlString(String s)
    {
        initUrlString(s, "/m/pos");
        setAdUnitId(mAdUnitId);
        setApiVersion("1");
        s = ClientMetadata.getInstance(mContext);
        setSdkVersion(s.getSdkVersion());
        setDeviceInfo(new String[] {
            s.getDeviceManufacturer(), s.getDeviceModel(), s.getDeviceProduct()
        });
        setAppVersion(s.getAppVersion());
        appendAdvertisingInfoTemplates();
        return getFinalUrlString();
    }

    public PositioningUrlGenerator withAdUnitId(String s)
    {
        mAdUnitId = s;
        return this;
    }
}

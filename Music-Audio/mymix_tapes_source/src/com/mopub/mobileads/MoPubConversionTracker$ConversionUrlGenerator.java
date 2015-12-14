// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;

// Referenced classes of package com.mopub.mobileads:
//            MoPubConversionTracker

private class <init> extends BaseUrlGenerator
{

    final MoPubConversionTracker this$0;

    private void setPackageId(String s)
    {
        addParam("id", s);
    }

    public String generateUrlString(String s)
    {
        initUrlString(s, "/m/open");
        setApiVersion("6");
        setPackageId(MoPubConversionTracker.access$300(MoPubConversionTracker.this));
        setAppVersion(ClientMetadata.getInstance(MoPubConversionTracker.access$400(MoPubConversionTracker.this)).getAppVersion());
        appendAdvertisingInfoTemplates();
        return getFinalUrlString();
    }

    private ()
    {
        this$0 = MoPubConversionTracker.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

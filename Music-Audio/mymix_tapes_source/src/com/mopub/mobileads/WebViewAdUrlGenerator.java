// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;

public class WebViewAdUrlGenerator extends AdUrlGenerator
{

    private final boolean mIsStorePictureSupported;

    public WebViewAdUrlGenerator(Context context, boolean flag)
    {
        super(context);
        mIsStorePictureSupported = flag;
    }

    public String generateUrlString(String s)
    {
        initUrlString(s, "/m/ad");
        setApiVersion("6");
        addBaseParams(ClientMetadata.getInstance(mContext));
        setMraidFlag(true);
        setExternalStoragePermission(mIsStorePictureSupported);
        return getFinalUrlString();
    }
}

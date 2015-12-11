// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;

// Referenced classes of package com.mopub.nativeads:
//            RequestParameters

class NativeUrlGenerator extends AdUrlGenerator
{

    private String mDesiredAssets;
    private String mSequenceNumber;

    NativeUrlGenerator(Context context)
    {
        super(context);
    }

    private void setDesiredAssets()
    {
        if (!TextUtils.isEmpty(mDesiredAssets))
        {
            addParam("assets", mDesiredAssets);
        }
    }

    private void setSequenceNumber()
    {
        if (!TextUtils.isEmpty(mSequenceNumber))
        {
            addParam("MAGIC_NO", mSequenceNumber);
        }
    }

    public String generateUrlString(String s)
    {
        initUrlString(s, "/m/ad");
        addBaseParams(ClientMetadata.getInstance(mContext));
        setDesiredAssets();
        setSequenceNumber();
        return getFinalUrlString();
    }

    protected void setSdkVersion(String s)
    {
        addParam("nsv", s);
    }

    public volatile AdUrlGenerator withAdUnitId(String s)
    {
        return withAdUnitId(s);
    }

    public NativeUrlGenerator withAdUnitId(String s)
    {
        mAdUnitId = s;
        return this;
    }

    NativeUrlGenerator withRequest(RequestParameters requestparameters)
    {
        if (requestparameters != null)
        {
            mKeywords = requestparameters.getKeywords();
            mLocation = requestparameters.getLocation();
            mDesiredAssets = requestparameters.getDesiredAssets();
        }
        return this;
    }

    NativeUrlGenerator withSequenceNumber(int i)
    {
        mSequenceNumber = String.valueOf(i);
        return this;
    }
}

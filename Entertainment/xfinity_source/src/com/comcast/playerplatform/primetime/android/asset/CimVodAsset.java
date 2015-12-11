// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.asset;

import com.comcast.playerplatform.primetime.android.enums.DrmWorkflow;
import com.comcast.playerplatform.primetime.android.enums.StreamType;

// Referenced classes of package com.comcast.playerplatform.primetime.android.asset:
//            Asset

public class CimVodAsset extends Asset
{
    public static class Builder extends Asset.Builder
    {

        public Builder(String s, String s1, boolean flag, DrmWorkflow drmworkflow, String s2, String s3)
        {
            withManifest(s);
            withDrmWorkflow(drmworkflow);
            withAssetInfo((new AssetInfo.Builder()).withMediaId(s3).withTid(s2).build());
            asStreamType(StreamType.VOD);
            withCustomDRMKey(s1);
        }
    }


    public CimVodAsset(String s, String s1, boolean flag, DrmWorkflow drmworkflow, String s2, String s3)
    {
        super(new Builder(s, s1, flag, drmworkflow, s2, s3));
    }
}

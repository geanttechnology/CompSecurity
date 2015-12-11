// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.asset;

import com.comcast.playerplatform.primetime.android.enums.DrmWorkflow;
import com.comcast.playerplatform.primetime.android.enums.StreamType;

// Referenced classes of package com.comcast.playerplatform.primetime.android.asset:
//            Asset

public class CimLinearAsset extends Asset
{
    public static class Builder extends Asset.Builder
    {

        public Builder(String s, String s1, boolean flag, DrmWorkflow drmworkflow, String s2)
        {
            withManifest(s);
            withDrmWorkflow(drmworkflow);
            withAssetInfo((new AssetInfo.Builder()).withStreamId(s2).build());
            asStreamType(StreamType.LINEAR);
            if (flag)
            {
                withCustomDRMKey(s1);
            }
        }
    }


    public CimLinearAsset(String s, String s1, boolean flag, DrmWorkflow drmworkflow, String s2)
    {
        super(new Builder(s, s1, flag, drmworkflow, s2));
    }
}

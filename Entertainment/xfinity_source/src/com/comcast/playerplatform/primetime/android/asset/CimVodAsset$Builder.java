// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.asset;

import com.comcast.playerplatform.primetime.android.enums.DrmWorkflow;
import com.comcast.playerplatform.primetime.android.enums.StreamType;

// Referenced classes of package com.comcast.playerplatform.primetime.android.asset:
//            CimVodAsset

public static class withCustomDRMKey extends withCustomDRMKey
{

    public (String s, String s1, boolean flag, DrmWorkflow drmworkflow, String s2, String s3)
    {
        withManifest(s);
        withDrmWorkflow(drmworkflow);
        withAssetInfo((new nit>()).thMediaId(s3).thTid(s2).ild());
        asStreamType(StreamType.VOD);
        withCustomDRMKey(s1);
    }
}

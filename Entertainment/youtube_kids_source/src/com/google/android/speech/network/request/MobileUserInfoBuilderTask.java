// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.network.request;

import com.google.android.speech.utils.NetworkInformation;
import ews;

// Referenced classes of package com.google.android.speech.network.request:
//            BaseRequestBuilderTask

public class MobileUserInfoBuilderTask extends BaseRequestBuilderTask
{

    private final NetworkInformation mNetworkInfo;

    public MobileUserInfoBuilderTask(NetworkInformation networkinformation)
    {
        super("MobileUserInfoBuilderTask");
        mNetworkInfo = networkinformation;
    }

    protected ews build()
    {
        ews ews1 = new ews();
        int ai[] = mNetworkInfo.getNetworkMccMnc();
        if (ai != NetworkInformation.MISSING_TELEPHONY_RESULT)
        {
            ews1.a(ai[0]);
            ews1.b(ai[1]);
        }
        ai = mNetworkInfo.getSimMccMnc();
        if (ai != NetworkInformation.MISSING_TELEPHONY_RESULT)
        {
            ews1.c(ai[0]);
            ews1.d(ai[1]);
        }
        int i = mNetworkInfo.getConnectionId();
        if (i != -1)
        {
            ews1.e(i);
        }
        return ews1;
    }

    protected volatile Object build()
    {
        return build();
    }
}

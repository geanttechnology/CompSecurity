// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.apls;

import android.content.Context;
import com.ebay.nautilus.domain.net.api.apls.AplsClientInfo;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.util.DelayedAsyncTask;

// Referenced classes of package com.ebay.mobile.apls:
//            AplsLogTrackSweeper

private abstract class sessionGuid extends DelayedAsyncTask
{

    protected AplsClientInfo clientInfo;
    protected final String sessionGuid;
    final AplsLogTrackSweeper this$0;

    protected void backgroundPrepare()
    {
        clientInfo.setDeviceGuid(EbayIdentity.getDeviceIdString((Context)AplsLogTrackSweeper.access$600(AplsLogTrackSweeper.this).getExtension(android/content/Context)));
    }

    protected void onPreExecute()
    {
        clientInfo = buildClientInfo(sessionGuid);
    }

    protected nfo(String s)
    {
        this$0 = AplsLogTrackSweeper.this;
        super();
        sessionGuid = s;
    }
}

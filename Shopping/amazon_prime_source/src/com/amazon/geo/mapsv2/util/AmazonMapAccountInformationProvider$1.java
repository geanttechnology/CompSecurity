// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import com.amazon.identity.auth.device.api.Callback;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            AmazonMapAccountInformationProvider

class this._cls0
    implements Runnable
{

    final AmazonMapAccountInformationProvider this$0;

    public void run()
    {
        AmazonMapAccountInformationProvider.access$000(AmazonMapAccountInformationProvider.this).onSuccess(null);
    }

    ()
    {
        this$0 = AmazonMapAccountInformationProvider.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.os.Bundle;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            AmazonMapAccountInformationProvider

class val.succeeded
    implements Runnable
{

    final val.succeeded this$0;
    final Bundle val$bundle;
    final boolean val$succeeded;

    public void run()
    {
        FinishedMainThread(val$bundle, val$succeeded);
    }

    ()
    {
        this$0 = final_;
        val$bundle = bundle1;
        val$succeeded = Z.this;
        super();
    }
}

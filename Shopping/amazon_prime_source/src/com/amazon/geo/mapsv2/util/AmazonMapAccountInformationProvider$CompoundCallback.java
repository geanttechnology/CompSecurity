// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            AmazonMapAccountInformationProvider

public abstract class succeeded extends succeeded
{
    public class CallbackItem extends AmazonMapAccountInformationProvider.SimpleCallback
    {

        final AmazonMapAccountInformationProvider.CompoundCallback this$1;

        protected void onFinished(Bundle bundle, boolean flag)
        {
            removeCallback(bundle, flag);
        }

        CallbackItem()
        {
            this$1 = AmazonMapAccountInformationProvider.CompoundCallback.this;
            super();
            addCallback();
        }
    }


    private final AtomicInteger numCallbacks = new AtomicInteger(0);
    private boolean succeeded;
    final AmazonMapAccountInformationProvider this$0;

    void addCallback()
    {
        numCallbacks.addAndGet(1);
    }

    void removeCallback(Bundle bundle, boolean flag)
    {
        boolean flag1;
        if (flag && succeeded)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        succeeded = flag1;
        if (numCallbacks.decrementAndGet() == 0)
        {
            onFinished(bundle, flag);
        }
    }

    public addCallback()
    {
        this$0 = AmazonMapAccountInformationProvider.this;
        super();
        succeeded = true;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.device.ads:
//            AdLayout

static final class val.loadListener
    implements android.view.erUtil._cls1
{

    final AdLayout val$adLayout;
    final val.adLayout val$loadListener;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        if (AdLayout.access$200(val$adLayout).getAndSet(false))
        {
            val$adLayout.setFloatingWindowDimensions();
            val$adLayout.loadAdFromAdController(val$loadListener);
            AdLayout.access$300(val$adLayout).removeOnLayoutChangeListener(this);
        }
    }

    A(AdLayout adlayout, A a)
    {
        val$adLayout = adlayout;
        val$loadListener = a;
        super();
    }
}

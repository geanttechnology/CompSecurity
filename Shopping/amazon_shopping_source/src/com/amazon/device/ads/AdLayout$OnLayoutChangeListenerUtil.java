// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.device.ads:
//            AdLayout

private static class _cls1.val.loadListener
{

    protected static void setOnLayoutChangeListenerForRoot(AdLayout adlayout, _cls1.val.loadListener loadlistener)
    {
        loadlistener = new android.view.View.OnLayoutChangeListener(adlayout, loadlistener) {

            final AdLayout val$adLayout;
            final AdLoader.AdReadyToLoadListener val$loadListener;

            public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
                    int k1, int l1)
            {
                if (AdLayout.access$200(adLayout).getAndSet(false))
                {
                    adLayout.setFloatingWindowDimensions();
                    adLayout.loadAdFromAdController(loadListener);
                    AdLayout.access$300(adLayout).removeOnLayoutChangeListener(this);
                }
            }

            
            {
                adLayout = adlayout;
                loadListener = adreadytoloadlistener;
                super();
            }
        };
        AdLayout.access$300(adlayout).addOnLayoutChangeListener(loadlistener);
    }

    private _cls1.val.loadListener()
    {
    }
}

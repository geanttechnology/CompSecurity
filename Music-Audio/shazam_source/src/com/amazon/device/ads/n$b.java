// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.view.View;

// Referenced classes of package com.amazon.device.ads:
//            n

private static final class _cls1.a
{

    // Unreferenced inner class com/amazon/device/ads/n$b$1

/* anonymous class */
    static final class _cls1
        implements android.view.View.OnLayoutChangeListener
    {

        final n a;

        public final void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
                int k1, int l1)
        {
            if (a.getAndSetNeedsToLoadAdOnLayout$138603())
            {
                a.c();
                n.c(a);
                n.d(a).removeOnLayoutChangeListener(this);
            }
        }

            
            {
                a = n1;
                super();
            }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.view.View;

// Referenced classes of package com.amazon.device.ads:
//            n

static final class a
    implements android.view.nLayoutChangeListener
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

    angeListener(n n1)
    {
        a = n1;
        super();
    }
}

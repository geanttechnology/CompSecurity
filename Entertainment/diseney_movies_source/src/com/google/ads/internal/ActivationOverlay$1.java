// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import com.google.ads.AdView;
import com.google.ads.n;

// Referenced classes of package com.google.ads.internal:
//            ActivationOverlay

class a
    implements Runnable
{

    final ActivationOverlay a;
    final ActivationOverlay b;

    public void run()
    {
        ((AdView)b.a.j.a()).removeView(a);
    }

    (ActivationOverlay activationoverlay, ActivationOverlay activationoverlay1)
    {
        b = activationoverlay;
        a = activationoverlay1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;

// Referenced classes of package com.google.ads.mediation.millennial:
//            MillennialAdapter

class a
    implements Runnable
{

    final MillennialAdapter a;

    public void run()
    {
        MillennialAdapter.b(a).onAdLeftApplication(a);
    }

    lListener(MillennialAdapter millennialadapter)
    {
        a = millennialadapter;
        super();
    }
}

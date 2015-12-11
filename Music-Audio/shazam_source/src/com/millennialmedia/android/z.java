// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            ap, ao

final class z extends ap
{

    z(ap.a a1, x.a a2)
    {
        super(a1, a2);
    }

    final void a(ao ao1)
    {
        ao1.loadUrl("javascript:MMJS.sdk.setPlacementType('interstitial');");
        ao1.k();
        ao1.loadUrl("javascript:MMJS.sdk.ready();");
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import java.util.Collections;

// Referenced classes of package com.flurry.android:
//            em, cy

final class w
    implements AdListener
{

    private em al;

    w(em em1)
    {
        this(em1, (byte)0);
    }

    private w(em em1, byte byte0)
    {
        al = em1;
        super();
    }

    public final void onDismissScreen(Ad ad)
    {
        al.onAdClosed(Collections.emptyMap());
        cy.e(em.ap(), "Admob AdView dismissed from screen.");
    }

    public final void onFailedToReceiveAd(Ad ad, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        al.onRenderFailed(Collections.emptyMap());
        cy.g(em.ap(), "Admob AdView failed to receive ad.");
    }

    public final void onLeaveApplication(Ad ad)
    {
        al.onAdClicked(Collections.emptyMap());
        cy.e(em.ap(), "Admob AdView leave application.");
    }

    public final void onPresentScreen(Ad ad)
    {
        cy.e(em.ap(), "Admob AdView present on screen.");
    }

    public final void onReceiveAd(Ad ad)
    {
        al.onAdShown(Collections.emptyMap());
        cy.e(em.ap(), "Admob AdView received ad.");
    }
}

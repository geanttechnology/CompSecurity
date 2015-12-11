// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.display;

import com.rhythmnewmedia.sdk.NoAdReason;

// Referenced classes of package com.rhythmnewmedia.sdk.display:
//            AdEventListener, AdView

public abstract class AdEventAdapter
    implements AdEventListener
{

    public AdEventAdapter()
    {
    }

    public void onAdReady(AdView adview)
    {
    }

    public void onAdReceived(AdView adview)
    {
    }

    public void onNoAdReceived(AdView adview, NoAdReason noadreason)
    {
    }

    public void onWillRequestAd(AdView adview)
    {
    }
}

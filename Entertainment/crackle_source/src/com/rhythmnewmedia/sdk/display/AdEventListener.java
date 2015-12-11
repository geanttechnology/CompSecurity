// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.display;

import com.rhythmnewmedia.sdk.NoAdReason;

// Referenced classes of package com.rhythmnewmedia.sdk.display:
//            AdView

public interface AdEventListener
{

    public abstract void onAdReady(AdView adview);

    public abstract void onAdReceived(AdView adview);

    public abstract void onNoAdReceived(AdView adview, NoAdReason noadreason);

    public abstract void onWillRequestAd(AdView adview);
}

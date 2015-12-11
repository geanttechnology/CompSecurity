// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.display;


// Referenced classes of package com.rhythmnewmedia.sdk.display:
//            AdView

public interface AdControlListener
{

    public abstract void onAdDidRequestDismissal(AdView adview);

    public abstract void onAdPinned(AdView adview);

    public abstract void onAdUnpinned(AdView adview);
}

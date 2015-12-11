// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;


// Referenced classes of package com.tapjoy:
//            TJPlacement, TJActionRequest, TJError

public interface TJPlacementListener
{

    public abstract void onContentDismiss(TJPlacement tjplacement);

    public abstract void onContentReady(TJPlacement tjplacement);

    public abstract void onContentShow(TJPlacement tjplacement);

    public abstract void onPurchaseRequest(TJPlacement tjplacement, TJActionRequest tjactionrequest, String s);

    public abstract void onRequestFailure(TJPlacement tjplacement, TJError tjerror);

    public abstract void onRequestSuccess(TJPlacement tjplacement);

    public abstract void onRewardRequest(TJPlacement tjplacement, TJActionRequest tjactionrequest, String s, int i);
}

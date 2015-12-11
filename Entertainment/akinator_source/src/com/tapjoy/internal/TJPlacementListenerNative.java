// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;

public class TJPlacementListenerNative
    implements TJPlacementListener
{

    private final long a;

    private TJPlacementListenerNative(long l)
    {
        if (l == 0L)
        {
            throw new IllegalArgumentException();
        } else
        {
            a = l;
            return;
        }
    }

    static Object create(long l)
    {
        return new TJPlacementListenerNative(l);
    }

    private static native void onContentDismissNative(long l, TJPlacement tjplacement, String s);

    private static native void onContentReadyNative(long l, TJPlacement tjplacement, String s);

    private static native void onContentShowNative(long l, TJPlacement tjplacement, String s);

    private static native void onPurchaseRequestNative(long l, TJPlacement tjplacement, String s, TJActionRequest tjactionrequest, String s1, String s2, String s3);

    private static native void onRequestFailureNative(long l, TJPlacement tjplacement, String s, int i, String s1);

    private static native void onRequestSuccessNative(long l, TJPlacement tjplacement, String s);

    private static native void onRewardRequestNative(long l, TJPlacement tjplacement, String s, TJActionRequest tjactionrequest, String s1, String s2, String s3, 
            int i);

    public void onContentDismiss(TJPlacement tjplacement)
    {
        onContentDismissNative(a, tjplacement, tjplacement.getName());
    }

    public void onContentReady(TJPlacement tjplacement)
    {
        onContentReadyNative(a, tjplacement, tjplacement.getName());
    }

    public void onContentShow(TJPlacement tjplacement)
    {
        onContentShowNative(a, tjplacement, tjplacement.getName());
    }

    public void onPurchaseRequest(TJPlacement tjplacement, TJActionRequest tjactionrequest, String s)
    {
        onPurchaseRequestNative(a, tjplacement, tjplacement.getName(), tjactionrequest, tjactionrequest.getRequestId(), tjactionrequest.getToken(), s);
    }

    public void onRequestFailure(TJPlacement tjplacement, TJError tjerror)
    {
        onRequestFailureNative(a, tjplacement, tjplacement.getName(), tjerror.code, tjerror.message);
    }

    public void onRequestSuccess(TJPlacement tjplacement)
    {
        onRequestSuccessNative(a, tjplacement, tjplacement.getName());
    }

    public void onRewardRequest(TJPlacement tjplacement, TJActionRequest tjactionrequest, String s, int i)
    {
        onRewardRequestNative(a, tjplacement, tjplacement.getName(), tjactionrequest, tjactionrequest.getRequestId(), tjactionrequest.getToken(), s, i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            NativeAd

public static interface us
{

    public abstract void onAdLeftApplication(NativeAd nativead);

    public abstract void onClicked(NativeAd nativead, us us, int i);

    public abstract void onExpired(NativeAd nativead);

    public abstract void onLoadFailed(NativeAd nativead, us us);

    public abstract void onLoaded(NativeAd nativead);
}

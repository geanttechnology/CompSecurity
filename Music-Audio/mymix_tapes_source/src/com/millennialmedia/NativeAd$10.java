// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            NativeAd

class iveListener
    implements Runnable
{

    final NativeAd this$0;
    final iveListener val$localNativeListener;

    public void run()
    {
        val$localNativeListener.onExpired(NativeAd.this);
    }

    iveListener()
    {
        this$0 = final_nativead;
        val$localNativeListener = iveListener.this;
        super();
    }
}

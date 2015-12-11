// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.environment;

import jumiomobile.hy;

// Referenced classes of package com.jumio.netverify.sdk.environment:
//            RecognizerCallback

public class RecognizerWrapper
{

    public RecognizerWrapper()
    {
    }

    private native void terminate();

    public void a()
    {
        terminate();
        RecognizerCallback.releaseListeners();
    }

    public void a(hy hy)
    {
        RecognizerCallback.addListener(hy);
    }

    public native String init(String s, int i);

    public native String recognize(byte abyte0[], int i, int j, int k);
}

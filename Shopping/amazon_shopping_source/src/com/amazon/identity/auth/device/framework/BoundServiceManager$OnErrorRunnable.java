// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;


// Referenced classes of package com.amazon.identity.auth.device.framework:
//            BoundServiceManager

private static class mCallback
    implements Runnable
{

    private final back mCallback;

    public void run()
    {
        mCallback.onError();
    }

    back(back back)
    {
        mCallback = back;
    }
}

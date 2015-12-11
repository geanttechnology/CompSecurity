// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonValueCallback

public abstract class AmazonGeolocationPermissions
{
    public static interface Callback
    {

        public abstract void invoke(String s, boolean flag, boolean flag1);
    }


    public AmazonGeolocationPermissions()
    {
    }

    public abstract void allow(String s);

    public abstract void clear(String s);

    public abstract void clearAll();

    public abstract void getAllowed(String s, AmazonValueCallback amazonvaluecallback);

    public abstract void getOrigins(AmazonValueCallback amazonvaluecallback);
}

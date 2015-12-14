// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;


// Referenced classes of package com.brightroll.androidsdk:
//            AsyncHttpRequest

public interface AsyncHttpRequestDelegate
{

    public abstract void asyncHttpRequestCompleted(AsyncHttpRequest asynchttprequest);

    public abstract void asyncHttpRequestFailed(AsyncHttpRequest asynchttprequest);
}

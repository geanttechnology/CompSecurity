// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import java.util.HashMap;

// Referenced classes of package co.vine.android.util:
//            UrlResourceCache

private class mResult
    implements Runnable
{

    private final HashMap mResult;
    final UrlResourceCache this$0;

    public void run()
    {
        urlResourceLoaded(mResult);
    }

    public (HashMap hashmap)
    {
        this$0 = UrlResourceCache.this;
        super();
        mResult = hashmap;
    }
}

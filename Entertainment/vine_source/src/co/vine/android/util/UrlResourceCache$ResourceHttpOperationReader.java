// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import co.vine.android.network.HttpOperationReader;
import co.vine.android.network.HttpResult;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package co.vine.android.util:
//            UrlResourceCache, UrlResource

private class mPersist
    implements HttpOperationReader
{

    private final Object mKey;
    private final long mOwnerId;
    private final boolean mPersist;
    private UrlResource mResource;
    private final String mUrl;
    final UrlResourceCache this$0;

    public final UrlResource getResultResource()
    {
        return mResource;
    }

    public void onHandleError(HttpResult httpresult)
    {
        onResourceError(mKey, httpresult);
    }

    public final void readInput(int i, int j, InputStream inputstream)
        throws IOException
    {
        if (mPersist)
        {
            mResource = saveResource(mOwnerId, mKey, mUrl, inputstream, true);
            return;
        } else
        {
            mResource = obtainResource(mKey, mUrl, inputstream);
            return;
        }
    }

    public (long l, Object obj, String s, boolean flag)
    {
        this$0 = UrlResourceCache.this;
        super();
        mResource = null;
        mOwnerId = l;
        mKey = obj;
        mUrl = s;
        mPersist = flag;
    }
}

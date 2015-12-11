// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.os.AsyncTask;

// Referenced classes of package com.mopub.common:
//            CacheService

private static class mKey extends AsyncTask
{

    private final ner mDiskLruCacheGetListener;
    private final String mKey;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient byte[] doInBackground(Void avoid[])
    {
        return CacheService.getFromDiskCache(mKey);
    }

    protected void onCancelled()
    {
        if (mDiskLruCacheGetListener != null)
        {
            mDiskLruCacheGetListener.onComplete(mKey, null);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((byte[])obj);
    }

    protected void onPostExecute(byte abyte0[])
    {
        if (isCancelled())
        {
            onCancelled();
        } else
        if (mDiskLruCacheGetListener != null)
        {
            mDiskLruCacheGetListener.onComplete(mKey, abyte0);
            return;
        }
    }

    ner(String s, ner ner)
    {
        mDiskLruCacheGetListener = ner;
        mKey = s;
    }
}

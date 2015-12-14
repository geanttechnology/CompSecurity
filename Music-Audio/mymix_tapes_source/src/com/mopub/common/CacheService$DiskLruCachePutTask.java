// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.os.AsyncTask;

// Referenced classes of package com.mopub.common:
//            CacheService

private static class mContent extends AsyncTask
{

    private final byte mContent[];
    private final String mKey;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        CacheService.putToDiskCache(mKey, mContent);
        return null;
    }

    (String s, byte abyte0[])
    {
        mKey = s;
        mContent = abyte0;
    }
}

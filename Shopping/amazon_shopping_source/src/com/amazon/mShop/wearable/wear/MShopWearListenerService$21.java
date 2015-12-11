// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;

import android.os.AsyncTask;

// Referenced classes of package com.amazon.mShop.wearable.wear:
//            MShopWearListenerService

static final class val.responseJson extends AsyncTask
{

    final byte val$responseJson[];

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        MShopWearListenerService.access$1100(MShopWearListenerService.access$1000(), null, "/query/mobileState", val$responseJson);
        return null;
    }

    (byte abyte0[])
    {
        val$responseJson = abyte0;
        super();
    }
}

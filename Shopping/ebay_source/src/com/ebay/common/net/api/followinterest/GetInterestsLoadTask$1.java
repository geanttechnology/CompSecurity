// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.os.AsyncTask;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            GetInterestsLoadTask

static final class  extends AsyncTask
{

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        GetInterestsLoadTask.invalidateCache();
        return null;
    }

    ()
    {
    }
}

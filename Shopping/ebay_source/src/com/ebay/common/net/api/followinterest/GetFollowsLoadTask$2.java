// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.content.Context;
import android.os.AsyncTask;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            GetFollowsLoadTask

static final class val.context extends AsyncTask
{

    final Context val$context;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        GetFollowsLoadTask.invalidateCache(val$context);
        return null;
    }

    A(Context context1)
    {
        val$context = context1;
        super();
    }
}

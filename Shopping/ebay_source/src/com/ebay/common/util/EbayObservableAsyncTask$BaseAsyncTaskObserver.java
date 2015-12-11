// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;


// Referenced classes of package com.ebay.common.util:
//            EbayObservableAsyncTask

public static abstract class asyncTask
    implements asyncTask
{

    private EbayObservableAsyncTask asyncTask;

    public final void clear()
    {
        if (asyncTask != null)
        {
            asyncTask.removeObserver(this);
            asyncTask = null;
        }
    }

    public final EbayObservableAsyncTask getTask()
    {
        return asyncTask;
    }

    public final void setTask(EbayObservableAsyncTask ebayobservableasynctask)
    {
        asyncTask = ebayobservableasynctask;
        ebayobservableasynctask.addObserver(this);
    }

    public ()
    {
        asyncTask = null;
    }
}

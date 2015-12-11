// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.os.AsyncTask;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            AsyncResultBase, AsyncLoadTask

final class task extends AsyncTask
{

    private Object result;
    private final AsyncLoadTask task;
    final task this$1;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Object doInBackground(Void avoid[])
    {
        result = task.loadInBackground();
        return result;
    }

    protected void onCancelled()
    {
        result.this.result(this);
        dispatchOnCanceled(this._cls1.this, task, result);
    }

    protected void onPostExecute(Object obj)
    {
        result.this.result(this);
        dispatchOnLoadComplete(this._cls1.this, task, obj);
    }

    public (AsyncLoadTask asyncloadtask)
    {
        this$1 = this._cls1.this;
        super();
        task = asyncloadtask;
        task.this.task(this);
    }
}

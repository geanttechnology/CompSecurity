// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.dialog;

import android.app.Activity;
import android.os.AsyncTask;

public abstract class ShowDialogAsyncTask extends DialogManager.ShowDialogTask
{

    private AsyncTask asyncTask;

    protected ShowDialogAsyncTask(Activity activity)
    {
        super(activity);
        asyncTask = new AsyncTask() {

            final ShowDialogAsyncTask this$0;

            protected transient Boolean doInBackground(Void avoid[])
            {
                return Boolean.valueOf(shouldShowDialog());
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(Boolean boolean1)
            {
                if (boolean1.booleanValue())
                {
                    showDialog();
                    return;
                } else
                {
                    completeWithoutShowingDialog();
                    return;
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Boolean)obj);
            }

            
            {
                this$0 = ShowDialogAsyncTask.this;
                super();
            }
        };
    }

    protected void cancel()
    {
        asyncTask.cancel(true);
    }

    protected void execute()
    {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    protected abstract boolean shouldShowDialog();
}

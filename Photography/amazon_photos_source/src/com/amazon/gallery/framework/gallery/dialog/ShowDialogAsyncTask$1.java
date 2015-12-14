// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.dialog;

import android.os.AsyncTask;

// Referenced classes of package com.amazon.gallery.framework.gallery.dialog:
//            ShowDialogAsyncTask

class this._cls0 extends AsyncTask
{

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

    ()
    {
        this$0 = ShowDialogAsyncTask.this;
        super();
    }
}

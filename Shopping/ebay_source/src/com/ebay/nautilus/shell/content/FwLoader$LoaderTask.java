// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.content;


// Referenced classes of package com.ebay.nautilus.shell.content:
//            FwAsyncTask, FwLoader

private static final class cb extends FwAsyncTask
{

    private final loader cb;
    public final FwLoader loader;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        loader.doInBackground();
        return null;
    }

    protected void onCancelled()
    {
        loader.canceled = true;
        loader.task = null;
        loader.onCanceled();
        cb.Canceled(loader);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        loader.task = null;
        cb.TaskComplete(loader);
        loader.status = android.os.ISHED;
    }

    public _cls9(FwLoader fwloader, _cls9 _pcls9, int i)
    {
        super(i);
        loader = fwloader;
        cb = _pcls9;
    }
}

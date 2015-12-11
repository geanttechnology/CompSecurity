// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayWatchingDataManager

private final class observer extends AsyncTask
{

    public final onPostExecute observer;
    final MyEbayWatchingDataManager this$0;

    protected transient ResultStatus doInBackground(Void avoid[])
    {
        try
        {
            avoid = removeAllItems();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return null;
        }
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleRemoveAllResult(this, null);
    }

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.onPostExecute(resultstatus);
        handleRemoveAllResult(this, resultstatus);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    public Q(Q q)
    {
        this$0 = MyEbayWatchingDataManager.this;
        super();
        observer = q;
    }
}

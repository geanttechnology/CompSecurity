// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.ListContent;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            PagedListManager

private final class <init> extends AsyncTask
{

    final PagedListManager this$0;

    protected transient ListContent doInBackground(Integer ainteger[])
    {
        try
        {
            ainteger = loadData(ainteger[0].intValue());
        }
        // Misplaced declaration of an exception variable
        catch (Integer ainteger[])
        {
            return null;
        }
        return ainteger;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Integer[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleLoadDataResult(this, null);
    }

    protected void onPostExecute(ListContent listcontent)
    {
        super.onPostExecute(listcontent);
        handleLoadDataResult(this, listcontent);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ListContent)obj);
    }

    private ()
    {
        this$0 = PagedListManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

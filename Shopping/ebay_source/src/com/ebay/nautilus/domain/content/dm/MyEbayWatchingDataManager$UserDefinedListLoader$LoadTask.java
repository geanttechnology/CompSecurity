// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.DatedContent;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayWatchingDataManager

private final class <init> extends AsyncTask
{

    final onPostExecute this$1;

    protected transient DatedContent doInBackground(Void avoid[])
    {
        try
        {
            avoid = <init>.this.<init>();
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
        dListResult(this, null);
    }

    protected void onPostExecute(DatedContent datedcontent)
    {
        super.onPostExecute(datedcontent);
        dListResult(this, datedcontent);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((DatedContent)obj);
    }

    private ()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}

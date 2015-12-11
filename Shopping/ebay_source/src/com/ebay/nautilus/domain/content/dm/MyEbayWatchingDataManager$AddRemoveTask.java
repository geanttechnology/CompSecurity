// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.EbayItemIdAndVariationSpecifics;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayWatchingDataManager

private final class observer extends AsyncTask
{

    public final boolean add;
    public final onPostExecute observer;
    final MyEbayWatchingDataManager this$0;

    protected transient Content doInBackground(EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
    {
        try
        {
            aebayitemidandvariationspecifics = addRemoveItems(add, aebayitemidandvariationspecifics);
        }
        // Misplaced declaration of an exception variable
        catch (EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
        {
            return null;
        }
        return aebayitemidandvariationspecifics;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((EbayItemIdAndVariationSpecifics[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleAddRemoveResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleAddRemoveResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public Q(boolean flag, Q q)
    {
        this$0 = MyEbayWatchingDataManager.this;
        super();
        add = flag;
        observer = q;
    }
}

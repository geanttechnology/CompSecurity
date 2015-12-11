// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssDealsHistogramDataManager

private final class <init> extends AsyncTask
{

    final UssDealsHistogramDataManager this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        UssDealsHistogramDataManager.access$300().clear();
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        UssDealsHistogramDataManager.access$502(UssDealsHistogramDataManager.this, null);
    }

    private ()
    {
        this$0 = UssDealsHistogramDataManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

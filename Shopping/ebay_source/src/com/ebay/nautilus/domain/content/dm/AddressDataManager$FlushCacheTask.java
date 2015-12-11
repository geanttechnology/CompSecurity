// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            AddressDataManager

public class this._cls0 extends AsyncTask
{

    final AddressDataManager this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        AddressDataManager.access$500().clear();
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        AddressDataManager.access$1602(AddressDataManager.this, null);
    }

    public ()
    {
        this$0 = AddressDataManager.this;
        super();
    }
}

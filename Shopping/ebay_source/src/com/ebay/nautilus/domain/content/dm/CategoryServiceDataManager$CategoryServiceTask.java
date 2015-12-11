// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.util.LongSparseArray;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            CategoryServiceDataManager

protected abstract class ebaySite extends AsyncTask
{

    protected final long categoryId;
    protected final EbaySite ebaySite;
    final CategoryServiceDataManager this$0;

    protected void onCancelled(Content content)
    {
        super.onCancelled();
        if (this == tasksInFlight.get(categoryId))
        {
            tasksInFlight.remove(categoryId);
        }
    }

    protected volatile void onCancelled(Object obj)
    {
        onCancelled((Content)obj);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        tasksInFlight.remove(categoryId);
        if (content == null)
        {
            return;
        } else
        {
            ((categoryId)CategoryServiceDataManager.access$400(CategoryServiceDataManager.this)).sChanged(CategoryServiceDataManager.this, categoryId, content);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        ((onPostExecute)CategoryServiceDataManager.access$300(CategoryServiceDataManager.this)).sLoading(CategoryServiceDataManager.this, categoryId);
    }

    protected (long l, EbaySite ebaysite)
    {
        this$0 = CategoryServiceDataManager.this;
        super();
        categoryId = l;
        ebaySite = ebaysite;
    }
}

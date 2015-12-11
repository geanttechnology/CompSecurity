// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.Content;

// Referenced classes of package com.ebay.common.net.api.local:
//            BaseEbayNowDataManager

private final class <init> extends AsyncTask
{

    final BaseEbayNowDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        try
        {
            avoid = BaseEbayNowDataManager.access$100(BaseEbayNowDataManager.this);
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

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        BaseEbayNowDataManager.access$200(BaseEbayNowDataManager.this, this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    private ()
    {
        this$0 = BaseEbayNowDataManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

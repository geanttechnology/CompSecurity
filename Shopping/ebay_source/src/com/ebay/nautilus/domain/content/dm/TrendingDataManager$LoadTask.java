// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.trend.TrendContentRequest;
import com.ebay.nautilus.domain.net.api.trend.TrendContentResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Arrays;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            TrendingDataManager

private final class <init> extends AsyncTask
{

    final TrendingDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        if (TrendingDataManager.log.)
        {
            TrendingDataManager.log.((new StringBuilder()).append("Starting background task: ").append(this).toString());
        }
        try
        {
            avoid = (TrendContentResponse)TrendingDataManager.access$100(TrendingDataManager.this, new TrendContentRequest());
            ResultStatus resultstatus = avoid.getResultStatus();
            if (resultstatus.hasError())
            {
                return new Content(resultstatus);
            }
            avoid = new Content(Arrays.asList(((TrendContentResponse) (avoid)).trends), resultstatus);
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
        handleLoadDataResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleLoadDataResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    private ()
    {
        this$0 = TrendingDataManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

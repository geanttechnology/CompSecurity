// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.currency;

import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.util.DelayedAsyncTask;
import com.ebay.nautilus.kernel.util.TimedCacheWallClock;

// Referenced classes of package com.ebay.common.net.api.currency:
//            CurrencyConversionDataManager, CurrencyConversionRequest, CurrencyConversionResponse

private final class conversionParams extends DelayedAsyncTask
{

    public final nCacheKey cacheKey;
    public final acheLock cacheLock;
    public final uestParams conversionParams;
    public final uestParams observer;
    final CurrencyConversionDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        ResultStatus resultstatus;
        if (CurrencyConversionDataManager.logger.)
        {
            CurrencyConversionDataManager.logger.((new StringBuilder()).append("Calling currency conversion API for: ").append(conversionParams).toString());
        }
        ResultStatusOwner resultstatusowner = new ResultStatusOwner();
        avoid = (CurrencyConversionResponse)CurrencyConversionDataManager.access$100(CurrencyConversionDataManager.this, new CurrencyConversionRequest(conversionParams), resultstatusowner);
        resultstatus = resultstatusowner.getResultStatus();
        if (!CurrencyConversionDataManager.treatableAsError(resultstatus)) goto _L2; else goto _L1
_L1:
        if (CurrencyConversionDataManager.logger.)
        {
            CurrencyConversionDataManager.logger.((new StringBuilder()).append("Error from API, not caching result: ").append(resultstatus).toString());
        }
        avoid = new Content(null, resultstatus);
_L8:
        Object obj = cacheLock;
        obj;
        JVM INSTR monitorenter ;
        if (resultstatus != ResultStatus.CANCELED || cacheKey.bypassCache) goto _L4; else goto _L3
_L3:
        CurrencyConversionDataManager.access$300(CurrencyConversionDataManager.this).remove(cacheKey);
_L6:
        return avoid;
_L2:
        CurrencyConversionRate currencyconversionrate = ((CurrencyConversionResponse) (avoid)).currencyConversionRate;
        if (CurrencyConversionDataManager.logger.)
        {
            CurrencyConversionDataManager.logger.((new StringBuilder()).append("Successful rate conversion: ").append(currencyconversionrate).toString());
        }
        obj = new Content(currencyconversionrate, resultstatus);
        long l = CurrencyConversionDataManager.access$200(CurrencyConversionDataManager.this, cacheKey, currencyconversionrate);
        cacheLock.setData(obj);
        avoid = ((Void []) (obj));
        if (!cacheKey.bypassCache)
        {
            currencyconversionrate = currencyconversionrate.createReciprocalRate();
            avoid = ((Void []) (obj));
            if (currencyconversionrate != null)
            {
                if (CurrencyConversionDataManager.logger.)
                {
                    CurrencyConversionDataManager.logger.((new StringBuilder()).append("Reciprocal rate created: ").append(currencyconversionrate).toString());
                }
                avoid = new nCacheKey(cacheKey.toCurr, cacheKey.fromCurr, false);
                acheLock achelock = new acheLock();
                achelock.loadState = acheLock.LoadState.DONE;
                achelock.setData(new Content(currencyconversionrate, resultstatus));
                CurrencyConversionDataManager.access$300(CurrencyConversionDataManager.this).put(avoid, achelock, l);
                avoid = ((Void []) (obj));
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        cacheLock.loadState = acheLock.LoadState.DONE;
        cacheLock.loadTask = null;
        cacheLock.setLoadTime();
        if (true) goto _L6; else goto _L5
_L5:
        avoid;
        obj;
        JVM INSTR monitorexit ;
        throw avoid;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        CurrencyConversionDataManager.access$500(CurrencyConversionDataManager.this, observer, CurrencyConversionDataManager.access$400(), conversionParams);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        CurrencyConversionDataManager.access$500(CurrencyConversionDataManager.this, observer, content, conversionParams);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public uestParams(uestParams uestparams, nCacheKey ncachekey, acheLock achelock, uestParams uestparams1)
    {
        this$0 = CurrencyConversionDataManager.this;
        super();
        observer = uestparams;
        cacheKey = ncachekey;
        cacheLock = achelock;
        conversionParams = uestparams1;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.merch;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.content.EbayCguidGetter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.Merchandise;
import com.ebay.nautilus.domain.net.api.recommendation.GetPlacementRequest;
import com.ebay.nautilus.domain.net.api.recommendation.GetPlacementResponse;
import com.ebay.nautilus.domain.net.api.recommendation.Placements;
import com.ebay.nautilus.domain.net.api.recommendation.RecommendationApiContext;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.List;

// Referenced classes of package com.ebay.mobile.merch:
//            MerchandiseDataManager

private final class site extends AsyncTask
{

    private final RecommendationApiContext apiContext;
    private final Authentication auth;
    private final piContext caller;
    private final boolean isTransacted;
    private final List itemIds;
    private final List placementIds;
    private final EbaySite site;
    final MerchandiseDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        avoid = MerchandiseDataManager.access$300(apiContext, placementIds, itemIds, isTransacted);
        Merchandise merchandise;
        synchronized (MerchandiseDataManager.access$400())
        {
            merchandise = (Merchandise)MerchandiseDataManager.access$500().get(avoid);
        }
        if (merchandise != null)
        {
            return new Content(merchandise);
        }
        break MISSING_BLOCK_LABEL_57;
        avoid;
        obj;
        JVM INSTR monitorexit ;
        throw avoid;
        Object obj1 = new StringBuilder();
        ((StringBuilder) (obj1)).append("guid=").append(EbayIdentity.getDeviceIdString(getContext()));
        if (auth != null)
        {
            String s = EbayCguidGetter.get(getEbayContext(), MyApp.getPrefs(), site, auth.iafToken);
            if (!TextUtils.isEmpty(s))
            {
                ((StringBuilder) (obj1)).append(",cguid=").append(s);
            }
        }
        ((StringBuilder) (obj1)).append(",pageid=2047935");
        Object obj2 = new ResultStatusOwner();
        obj1 = new GetPlacementRequest(apiContext, placementIds, itemIds, isTransacted, ((StringBuilder) (obj1)).toString());
        obj1 = (GetPlacementResponse)MerchandiseDataManager.access$600(MerchandiseDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj1)), ((ResultStatusOwner) (obj2)));
        if (obj1 != null && !((GetPlacementResponse) (obj1)).getResultStatus().hasError() && ((GetPlacementResponse) (obj1)).getResultStatus() != ResultStatus.CANCELED)
        {
            obj2 = new Merchandise(((GetPlacementResponse) (obj1)).placementToListingMap);
            synchronized (MerchandiseDataManager.access$400())
            {
                MerchandiseDataManager.access$500().put(avoid, obj2);
            }
            if (((GetPlacementResponse) (obj1)).placements != null)
            {
                avoid = new TrackingData("MerchFeed", TrackingType.EVENT);
                avoid.addKeyValuePair("svcdata", ((GetPlacementResponse) (obj1)).placements.impression);
                avoid.send(getEbayContext());
            }
            return new Content(obj2, ((GetPlacementResponse) (obj1)).getResultStatus());
        } else
        {
            return new Content(((ResultStatusOwner) (obj2)).getResultStatus());
        }
        avoid;
        obj3;
        JVM INSTR monitorexit ;
        throw avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onCancelled()
    {
        if (caller != null)
        {
            caller.diseLoaded(MerchandiseDataManager.this, new Content(ResultStatus.CANCELED));
            return;
        } else
        {
            ((this._cls0)MerchandiseDataManager.access$700(MerchandiseDataManager.this)).diseLoaded(MerchandiseDataManager.this, new Content(ResultStatus.CANCELED));
            return;
        }
    }

    protected void onPostExecute(Content content)
    {
        if (caller != null)
        {
            caller.diseLoaded(MerchandiseDataManager.this, content);
            return;
        } else
        {
            ((this._cls0)MerchandiseDataManager.access$800(MerchandiseDataManager.this)).diseLoaded(MerchandiseDataManager.this, content);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    protected void onPreExecute()
    {
        if (caller != null)
        {
            caller.diseLoading(MerchandiseDataManager.this);
            return;
        } else
        {
            ((this._cls0)MerchandiseDataManager.access$200(MerchandiseDataManager.this)).diseLoading(MerchandiseDataManager.this);
            return;
        }
    }

    public piContext(RecommendationApiContext recommendationapicontext, List list, List list1, boolean flag, piContext picontext)
    {
        this$0 = MerchandiseDataManager.this;
        super();
        apiContext = recommendationapicontext;
        placementIds = list;
        itemIds = list1;
        isTransacted = flag;
        caller = picontext;
        auth = MerchandiseDataManager.access$000(MerchandiseDataManager.this);
        site = MerchandiseDataManager.access$100(MerchandiseDataManager.this).site;
    }
}

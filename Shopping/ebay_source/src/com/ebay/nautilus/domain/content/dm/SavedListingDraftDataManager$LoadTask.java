// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.listingdraft.ListingDraftOperation;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.net.api.lds.GetSavedListingDraftsRequest;
import com.ebay.nautilus.domain.net.api.lds.LdsRequestParams;
import com.ebay.nautilus.domain.net.api.lds.LdsResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SavedListingDraftDataManager

private final class iafToken extends AsyncTask
{

    private final EbayCountry country;
    private final String iafToken;
    LdsResponse response;
    final SavedListingDraftDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        if (country == null || iafToken == null)
        {
            return null;
        }
        Object obj = getDraftFilterConfig();
        LdsRequestParams ldsrequestparams;
        com.ebay.nautilus.kernel.content.FilterConfig filterconfig;
        try
        {
            ldsrequestparams = new LdsRequestParams(ListingDraftOperation.GET_SAVED_DRAFTS);
            ldsrequestparams.iafToken = iafToken;
            ldsrequestparams.site = country.site;
            response = (LdsResponse)SavedListingDraftDataManager.access$100(SavedListingDraftDataManager.this, new GetSavedListingDraftsRequest(ldsrequestparams, ((com.ebay.nautilus.domain.net.api.lds.erConfig) (obj))));
            avoid = response.getResultStatus();
            filterconfig = avoid.getFirstError();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return null;
        }
        if (filterconfig == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        if ("network".equals(filterconfig.response()))
        {
            avoid.setCanRetry(true);
        }
        return new Content(null, avoid);
        if (EbaySite.US.equals(country.site))
        {
            SavedListingDraftDataManager.access$200(response.drafts);
            ldsrequestparams.site = EbaySite.MOTOR;
            obj = (LdsResponse)SavedListingDraftDataManager.access$300(SavedListingDraftDataManager.this, new GetSavedListingDraftsRequest(ldsrequestparams, ((com.ebay.nautilus.domain.net.api.lds.erConfig) (obj))));
            if (!((LdsResponse) (obj)).getResultStatus().hasError())
            {
                response.drafts.addAll(((LdsResponse) (obj)).drafts);
            }
            Collections.sort(response.drafts, new Comparator() {

                final SavedListingDraftDataManager.LoadTask this$1;

                public int compare(ListingDraft listingdraft, ListingDraft listingdraft1)
                {
                    return listingdraft1.lastModified.getDateValue().compareTo(listingdraft.lastModified.getDateValue());
                }

                public volatile int compare(Object obj1, Object obj2)
                {
                    return compare((ListingDraft)obj1, (ListingDraft)obj2);
                }

            
            {
                this$1 = SavedListingDraftDataManager.LoadTask.this;
                super();
            }
            });
        }
        avoid = new Content(response.drafts, avoid);
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        if (SavedListingDraftDataManager.access$400(SavedListingDraftDataManager.this) == this)
        {
            SavedListingDraftDataManager.access$402(SavedListingDraftDataManager.this, null);
        }
        if (content == null)
        {
            return;
        }
        if (!content.getStatus().hasError())
        {
            SavedListingDraftDataManager.access$502(SavedListingDraftDataManager.this, content);
        }
        ((this._cls0)SavedListingDraftDataManager.access$600(SavedListingDraftDataManager.this)).onContentChanged(content, ype.LOAD);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public _cls1.this._cls1(EbayCountry ebaycountry, Authentication authentication)
    {
        this$0 = SavedListingDraftDataManager.this;
        super();
        country = ebaycountry;
        if (authentication != null)
        {
            savedlistingdraftdatamanager = authentication.iafToken;
        } else
        {
            savedlistingdraftdatamanager = null;
        }
        iafToken = SavedListingDraftDataManager.this;
    }
}

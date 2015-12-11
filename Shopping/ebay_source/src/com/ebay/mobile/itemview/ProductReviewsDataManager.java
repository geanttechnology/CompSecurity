// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.itemview;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager;
import com.ebay.nautilus.domain.net.api.guidesandreviews.GetReviewsRequest;
import com.ebay.nautilus.domain.net.api.guidesandreviews.GetReviewsResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;

public final class ProductReviewsDataManager extends UserContextObservingDataManager
{
    public static final class KeyParams extends com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams((EbaySite)EbaySite.CREATOR.createFromParcel(parcel));
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final EbaySite site;

        public ProductReviewsDataManager create(EbayContext ebaycontext)
        {
            return new ProductReviewsDataManager(ebaycontext, this);
        }

        public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj instanceof KeyParams)
            {
                return ((KeyParams)obj).site.equals(site);
            } else
            {
                return false;
            }
        }

        public int hashCode()
        {
            return super.hashCode() * 31 + site.idInt;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Site:").append(site.id).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            site.writeToParcel(parcel, i);
        }


        public KeyParams(EbaySite ebaysite)
        {
            site = ebaysite;
        }
    }

    final class LoadTask extends AsyncTask
    {

        final ProductReviewsDataManager this$0;

        protected transient Content doInBackground(RequestParams arequestparams[])
        {
            Object obj = new GetReviewsRequest(arequestparams[0].ebayCountry, arequestparams[0].user, arequestparams[0].subjectReferenceId, arequestparams[0].pageNumber, 10);
            arequestparams = new ResultStatusOwner();
            obj = (GetReviewsResponse)safeSendRequest(((Request) (obj)), arequestparams);
            arequestparams = arequestparams.getResultStatus();
            if (arequestparams == ResultStatus.CANCELED)
            {
                return null;
            }
            if (arequestparams.hasError())
            {
                return new Content(arequestparams);
            } else
            {
                return new Content(((GetReviewsResponse) (obj)).reviews, arequestparams);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((RequestParams[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected void onPostExecute(Content content)
        {
            onPostExecute(content);
            ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        LoadTask()
        {
            this$0 = ProductReviewsDataManager.this;
            super();
        }
    }

    public static interface Observer
    {

        public abstract void onGetReviewDetails(Content content);
    }

    public static final class RequestParams
    {

        public final EbayCountry ebayCountry;
        public final int maxResultsPerPage;
        public final int pageNumber;
        public final String subjectReferenceId;
        public final Authentication user;

        public String toString()
        {
            return (new StringBuilder()).append("maxResultsPerPage: ").append(maxResultsPerPage).append(", ").append("pageNumber: ").append(pageNumber).append(", ").append("subjectReferenceId: ").append(subjectReferenceId).toString();
        }

        public RequestParams(String s, int i, int j, Authentication authentication, EbayCountry ebaycountry)
        {
            if (ebaycountry == null || TextUtils.isEmpty(s) || i <= 0)
            {
                throw new IllegalArgumentException("invalid argument");
            } else
            {
                maxResultsPerPage = j;
                pageNumber = i;
                subjectReferenceId = s;
                user = authentication;
                ebayCountry = ebaycountry;
                return;
            }
        }
    }


    public static final int DEFAULT_PAGE_SIZE = 10;
    private final KeyParams params;

    ProductReviewsDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        UserContextObservingDataManager(ebaycontext, com/ebay/mobile/itemview/ProductReviewsDataManager$Observer, keyparams);
        if (keyparams == null)
        {
            throw new IllegalArgumentException("invalid argument");
        } else
        {
            params = keyparams;
            return;
        }
    }

    public void getReviews(String s, int i)
    {
        NautilusKernel.verifyMain();
        Authentication authentication = getCurrentUser();
        executeOnThreadPool(new LoadTask(), new RequestParams[] {
            new RequestParams(s, i, 10, authentication, MyApp.getPrefs().getCurrentCountry())
        });
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }



}

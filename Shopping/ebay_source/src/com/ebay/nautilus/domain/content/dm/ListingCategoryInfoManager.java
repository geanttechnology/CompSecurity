// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.net.api.ums.GetMetadataRequest;
import com.ebay.nautilus.domain.net.api.ums.GetMetadataResponse;
import com.ebay.nautilus.domain.net.api.ums.Metadata;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;

public final class ListingCategoryInfoManager extends DataManager
{
    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams((EbaySite)EbaySite.CREATOR.createFromParcel(parcel), parcel.readString());
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
        public final String categoryId;
        public final EbaySite site;

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public ListingCategoryInfoManager createManager(EbayContext ebaycontext)
        {
            return new ListingCategoryInfoManager(ebaycontext, this);
        }

        public boolean equals(Object obj)
        {
            if (this != obj) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (KeyParams)obj;
            if (categoryId == null)
            {
                if (((KeyParams) (obj)).categoryId != null)
                {
                    return false;
                }
            } else
            if (!categoryId.equals(((KeyParams) (obj)).categoryId))
            {
                return false;
            }
            if (site != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((KeyParams) (obj)).site == null) goto _L1; else goto _L3
_L3:
            return false;
            if (site.equals(((KeyParams) (obj)).site)) goto _L1; else goto _L4
_L4:
            return false;
        }

        public int hashCode()
        {
            int j = 0;
            int k = super.hashCode();
            int i;
            if (categoryId == null)
            {
                i = 0;
            } else
            {
                i = categoryId.hashCode();
            }
            if (site != null)
            {
                j = site.hashCode();
            }
            return (k * 31 + i) * 31 + j;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            site.writeToParcel(parcel, i);
            parcel.writeString(categoryId);
        }


        public KeyParams(EbaySite ebaysite, String s)
        {
            site = ebaysite;
            categoryId = s;
        }
    }

    public static class ListingCategoryInfo
    {

        public Content content;

        public ListingCategoryInfo()
        {
            content = null;
        }
    }

    private final class LoadTask extends AsyncTask
    {

        private final String categoryId;
        private final EbaySite site;
        final ListingCategoryInfoManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            try
            {
                avoid = (GetMetadataResponse)sendRequest(new GetMetadataRequest(site, categoryId));
                ResultStatus resultstatus = avoid.getResultStatus();
                if (resultstatus.hasError())
                {
                    return new Content(resultstatus);
                }
                avoid = new Content(Metadata.convertMetadataToSpecifics(((GetMetadataResponse) (avoid)).metadata), resultstatus);
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
            ListingCategoryInfo listingcategoryinfo = categoryInfo;
            listingcategoryinfo;
            JVM INSTR monitorenter ;
            if (loadTask == this)
            {
                loadTask = null;
            }
            if (content != null)
            {
                break MISSING_BLOCK_LABEL_42;
            }
            listingcategoryinfo;
            JVM INSTR monitorexit ;
            return;
            if (!content.getStatus().hasError())
            {
                categoryInfo.content = content;
            }
            ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public LoadTask(EbaySite ebaysite, String s)
        {
            this$0 = ListingCategoryInfoManager.this;
            super();
            site = ebaysite;
            categoryId = s;
        }
    }

    public static interface Observer
    {

        public abstract void onItemSpecificsChanged(Content content);
    }


    private final ListingCategoryInfo categoryInfo = new ListingCategoryInfo();
    private LoadTask loadTask;
    private final KeyParams params;

    ListingCategoryInfoManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        DataManager(ebaycontext, com/ebay/nautilus/domain/content/dm/ListingCategoryInfoManager$Observer);
        params = keyparams;
    }

    public KeyParams getParams()
    {
        return params;
    }

    public volatile Object getParams()
    {
        return getParams();
    }

    public void loadData(Observer observer)
    {
label0:
        {
            NautilusKernel.verifyMain();
            synchronized (categoryInfo)
            {
                if (loadTask == null)
                {
                    break label0;
                }
            }
            return;
        }
        Content content = categoryInfo.content;
        if (content != null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        loadTask = new LoadTask(params.site, params.categoryId);
        executeOnThreadPool(loadTask, new Void[0]);
        listingcategoryinfo;
        JVM INSTR monitorexit ;
        if (observer != null && content != null)
        {
            ((Observer)dispatcher).onItemSpecificsChanged(content);
            return;
        } else
        {
            return;
        }
        observer;
        listingcategoryinfo;
        JVM INSTR monitorexit ;
        throw observer;
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }





/*
    static LoadTask access$202(ListingCategoryInfoManager listingcategoryinfomanager, LoadTask loadtask)
    {
        listingcategoryinfomanager.loadTask = loadtask;
        return loadtask;
    }

*/

}

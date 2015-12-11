// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.ShippingLabelContact;
import com.ebay.nautilus.domain.net.api.shippinglabel.DraftShippingLabelResponse;
import com.ebay.nautilus.domain.net.api.shippinglabel.GetDraftShippingLabelRequest;
import com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelAddressRequest;
import com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.net.URL;

public class ShippingLabelDraftDataManager extends DataManager
{
    private final class CreateDraftLabelTask extends AsyncTask
    {

        private final String iafToken;
        private final String itemId;
        final ShippingLabelDraftDataManager this$0;
        private final String transactionId;
        private final String url;

        protected transient Content doInBackground(Address aaddress[])
        {
            Object obj = new GetDraftShippingLabelRequest(itemId, transactionId, iafToken, url);
            aaddress = new ResultStatusOwner();
            obj = (DraftShippingLabelResponse)safeSendRequest(((Request) (obj)), aaddress);
            aaddress = aaddress.getResultStatus();
            if (aaddress == ResultStatus.CANCELED)
            {
                return null;
            } else
            {
                return new Content(((DraftShippingLabelResponse) (obj)).shippingLabel, aaddress);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Address[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            createDraftLabelTask = null;
            handleUpdateDraftResult(null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            createDraftLabelTask = null;
            handleUpdateDraftResult(content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public CreateDraftLabelTask(KeyParams keyparams)
        {
            this$0 = ShippingLabelDraftDataManager.this;
            super();
            url = keyparams.url;
            itemId = keyparams.itemId;
            transactionId = keyparams.transactionId;
            iafToken = keyparams.iafToken;
        }
    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
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
        public final String iafToken;
        public final String itemId;
        public final String transactionId;
        public final String url;

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public ShippingLabelDraftDataManager createManager(EbayContext ebaycontext)
        {
            return new ShippingLabelDraftDataManager(ebaycontext, this);
        }

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (obj == null)
                {
                    return false;
                }
                if (getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (KeyParams)obj;
                if (!TextUtils.equals(itemId, ((KeyParams) (obj)).itemId) || !TextUtils.equals(transactionId, ((KeyParams) (obj)).transactionId) || !TextUtils.equals(url, ((KeyParams) (obj)).url) || !TextUtils.equals(iafToken, ((KeyParams) (obj)).iafToken))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            int l = 0;
            int i1 = super.hashCode();
            int i;
            int j;
            int k;
            if (itemId == null)
            {
                i = 0;
            } else
            {
                i = itemId.hashCode();
            }
            if (transactionId == null)
            {
                j = 0;
            } else
            {
                j = transactionId.hashCode();
            }
            if (url == null)
            {
                k = 0;
            } else
            {
                k = url.hashCode();
            }
            if (iafToken != null)
            {
                l = iafToken.hashCode();
            }
            return (((i1 * 31 + i) * 31 + j) * 31 + k) * 31 + l;
        }

        public String toString()
        {
            return (new StringBuilder()).append("ShippingLabelDraftParams [itemId=").append(itemId).append(", transactionId=").append(transactionId).append(", url=").append(url).append("]").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(itemId);
            parcel.writeString(transactionId);
            parcel.writeString(url);
            parcel.writeString(iafToken);
        }


        public KeyParams(String s, String s1, String s2, String s3)
        {
            url = s2;
            itemId = s;
            transactionId = s1;
            iafToken = s3;
        }
    }

    public static interface Observer
    {

        public abstract void onDraftChanged(ShippingLabelDraftDataManager shippinglabeldraftdatamanager, Content content, boolean flag);
    }

    private final class UpdateDraftAddressTask extends AsyncTask
    {

        private final ShippingLabelContact address;
        private final com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingAddressType addressType;
        private final String labelId;
        final ShippingLabelDraftDataManager this$0;
        private final URL url;

        protected transient Content doInBackground(String as[])
        {
            Object obj = new UpdateDraftShippingLabelAddressRequest(address, addressType, labelId, params.iafToken, url);
            as = new ResultStatusOwner();
            obj = (DraftShippingLabelResponse)safeSendRequest(((Request) (obj)), as);
            as = as.getResultStatus();
            if (as == ResultStatus.CANCELED)
            {
                return null;
            } else
            {
                return new Content(((DraftShippingLabelResponse) (obj)).shippingLabel, as);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            updateDraftAddressTask = null;
            handleUpdateDraftResult(null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            updateDraftAddressTask = null;
            handleUpdateDraftResult(content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public UpdateDraftAddressTask(ShippingLabelContact shippinglabelcontact, com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingAddressType shippingaddresstype, String s, URL url1)
        {
            this$0 = ShippingLabelDraftDataManager.this;
            super();
            url = url1;
            labelId = s;
            address = shippinglabelcontact;
            addressType = shippingaddresstype;
        }
    }

    private final class UpdateDraftPackageTask extends AsyncTask
    {

        private final String labelId;
        private final com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams requestParams;
        final ShippingLabelDraftDataManager this$0;
        private final URL url;

        protected transient Content doInBackground(String as[])
        {
            Object obj = new UpdateDraftShippingLabelPackageRequest(labelId, params.iafToken, requestParams, url);
            as = new ResultStatusOwner();
            obj = (DraftShippingLabelResponse)safeSendRequest(((Request) (obj)), as);
            as = as.getResultStatus();
            if (as == ResultStatus.CANCELED)
            {
                return null;
            } else
            {
                return new Content(((DraftShippingLabelResponse) (obj)).shippingLabel, as);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            updateDraftPackageTask = null;
            handleUpdateDraftResult(null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            updateDraftPackageTask = null;
            handleUpdateDraftResult(content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public UpdateDraftPackageTask(com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams labelrequestparams, String s, URL url1)
        {
            this$0 = ShippingLabelDraftDataManager.this;
            super();
            requestParams = labelrequestparams;
            url = url1;
            labelId = s;
        }
    }


    protected CreateDraftLabelTask createDraftLabelTask;
    private Content draftContent;
    private final KeyParams params;
    protected UpdateDraftAddressTask updateDraftAddressTask;
    protected UpdateDraftPackageTask updateDraftPackageTask;

    ShippingLabelDraftDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/ShippingLabelDraftDataManager$Observer);
        updateDraftAddressTask = null;
        updateDraftPackageTask = null;
        createDraftLabelTask = null;
        params = keyparams;
    }

    private void cancelTasks()
    {
        if (createDraftLabelTask != null)
        {
            createDraftLabelTask.cancel(true);
            createDraftLabelTask = null;
        }
        if (updateDraftAddressTask != null)
        {
            updateDraftAddressTask.cancel(true);
            updateDraftAddressTask = null;
        }
        if (updateDraftPackageTask != null)
        {
            updateDraftPackageTask.cancel(true);
            updateDraftPackageTask = null;
        }
    }

    public void clearCache()
    {
        draftContent = null;
    }

    public void createShippingLabel()
    {
        if (createDraftLabelTask != null)
        {
            return;
        }
        if (draftContent != null)
        {
            ((Observer)dispatcher).onDraftChanged(this, draftContent, true);
            return;
        } else
        {
            CreateDraftLabelTask createdraftlabeltask = new CreateDraftLabelTask(params);
            createDraftLabelTask = createdraftlabeltask;
            executeOnThreadPool(createdraftlabeltask, new Address[0]);
            return;
        }
    }

    public KeyParams getParams()
    {
        return params;
    }

    public volatile Object getParams()
    {
        return getParams();
    }

    protected void handleUpdateDraftResult(Content content)
    {
        if (content == null)
        {
            return;
        }
        if (!content.getStatus().hasError())
        {
            draftContent = content;
        }
        ((Observer)dispatcher).onDraftChanged(this, content, false);
    }

    public boolean isLoading()
    {
        return updateDraftAddressTask != null || updateDraftPackageTask != null || createDraftLabelTask != null;
    }

    public void loadData(Observer observer)
    {
        NautilusKernel.verifyMain();
        if (createDraftLabelTask != null)
        {
            return;
        }
        if (draftContent != null)
        {
            ((Observer)dispatcher).onDraftChanged(this, draftContent, true);
            return;
        } else
        {
            observer = new CreateDraftLabelTask(params);
            createDraftLabelTask = observer;
            executeOnThreadPool(observer, new Address[0]);
            return;
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    protected void onLastObserverUnregistered()
    {
        cancelTasks();
    }

    public void updateDraftAddress(ShippingLabelContact shippinglabelcontact, com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingAddressType shippingaddresstype, String s, URL url)
    {
        updateDraftAddressTask = new UpdateDraftAddressTask(shippinglabelcontact, shippingaddresstype, s, url);
        executeOnThreadPool(updateDraftAddressTask, new String[0]);
    }

    public void updateDraftPackage(com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams labelrequestparams, String s, URL url)
    {
        updateDraftPackageTask = new UpdateDraftPackageTask(labelrequestparams, s, url);
        executeOnThreadPool(updateDraftPackageTask, new String[0]);
    }




}

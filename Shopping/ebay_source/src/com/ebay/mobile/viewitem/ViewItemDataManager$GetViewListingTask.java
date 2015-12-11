// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbayCguidGetter;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.ErrorMessageDetails;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.viewlisting.GetViewListingRequest;
import com.ebay.nautilus.domain.net.api.viewlisting.GetViewListingResponse;
import com.ebay.nautilus.domain.net.api.viewlisting.Listing;
import com.ebay.nautilus.domain.net.api.viewlisting.ListingDetails;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager, ViewItemViewData, ItemMapper

private final class taskId extends AsyncTask
{

    Content content;
    final Integer quantity;
    final EbaySite site;
    final onPostExecute taskId;
    final ViewItemDataManager this$0;
    final ItemCurrency unitPrice;
    final ViewItemViewData viewData;

    protected transient Content doInBackground(taskId ataskid[])
    {
        Object obj;
        Object obj2 = null;
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        Object obj1;
        String s;
        StringBuilder stringbuilder;
        boolean flag;
        boolean flag1;
        if (deviceconfiguration.get(DcsNautilusBoolean.PROX) && deviceconfiguration.get(DcsBoolean.payments_payUponInvoiceEnabled))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = deviceconfiguration.get(DcsBoolean.VI_feature_EEK);
        obj = ViewItemDataManager.access$3500();
        if (TextUtils.isEmpty(viewData.searchRefinedPostalCode)) goto _L2; else goto _L1
_L1:
        obj = new Address();
        ((Address) (obj)).addressFields.ata = site.localeCountry;
        ((Address) (obj)).addressFields.ata = viewData.searchRefinedPostalCode;
_L4:
        obj1 = null;
        s = EbayIdentity.getDeviceIdString(getContext());
        if (ViewItemDataManager.access$1000(ViewItemDataManager.this) != null)
        {
            obj1 = EbayCguidGetter.get(getEbayContext(), MyApp.getPrefs(), site, ViewItemDataManager.access$1000(ViewItemDataManager.this).iafToken);
        }
        stringbuilder = new StringBuilder();
        stringbuilder.append("guid=").append(s);
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            stringbuilder.append(",cguid=").append(((String) (obj1)));
        }
        stringbuilder.append(",pageid=2047935");
        ataskid = new GetViewListingRequest(MyApp.getPrefs().getCurrentCountry(), ViewItemDataManager.access$1000(ViewItemDataManager.this), ataskid[0]._fld0, ViewItemDataManager.access$3600(ViewItemDataManager.this), ((Address) (obj)), s, stringbuilder.toString(), viewData.trackingCorrelationId, unitPrice, quantity, flag1, flag, deviceconfiguration.get(com.ebay.mobile.dcs.Task.quantity));
        obj = new ResultStatusOwner();
        obj1 = (GetViewListingResponse)ViewItemDataManager.access$3700(ViewItemDataManager.this, ataskid, ((ResultStatusOwner) (obj)));
        ataskid = obj2;
        if (((ResultStatusOwner) (obj)).getResultStatus() != ResultStatus.CANCELED)
        {
            ataskid = new Content(((GetViewListingResponse) (obj1)).details, ((ResultStatusOwner) (obj)).getResultStatus());
        }
        return ataskid;
_L2:
        if (viewData.primaryAddress != null)
        {
            obj = viewData.primaryAddress;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((doInBackground[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        switch (ay.mobile.viewitem.ViewItemDataManager.TaskId[taskId.taskId()])
        {
        default:
            handleLoadDataResult(taskId, viewData, null);
            return;

        case 1: // '\001'
            ViewItemDataManager.access$3800(ViewItemDataManager.this, taskId, null);
            return;

        case 2: // '\002'
            ViewItemDataManager.access$3900(ViewItemDataManager.this, taskId, null);
            break;
        }
    }

    protected void onPostExecute(Content content1)
    {
        super.onPostExecute(content1);
        if (content1.getStatus().hasError())
        {
            break MISSING_BLOCK_LABEL_497;
        }
        ay.mobile.viewitem.ViewItemDataManager.TaskId[taskId.taskId()];
        JVM INSTR tableswitch 1 3: default 52
    //                   1 430
    //                   2 329
    //                   3 104;
           goto _L1 _L2 _L3 _L4
_L1:
        Object obj;
        Item item;
        boolean flag;
        boolean flag1;
        switch (ay.mobile.viewitem.ViewItemDataManager.TaskId[taskId.taskId()])
        {
        default:
            handleLoadDataResult(taskId, viewData, content);
            return;

        case 1: // '\001'
            ViewItemDataManager.access$3800(ViewItemDataManager.this, taskId, content);
            return;

        case 2: // '\002'
            ViewItemDataManager.access$3900(ViewItemDataManager.this, taskId, content);
            break;
        }
        break MISSING_BLOCK_LABEL_547;
_L4:
        obj = (ListingDetails)content1.getData();
        if (obj == null || ((ListingDetails) (obj)).listing == null || ((ListingDetails) (obj)).listing.itemVariations == null || ((ListingDetails) (obj)).listing.itemVariations.isEmpty())
        {
            content1 = new ResultStatusOwner();
            content1.addResultMessage(new com.ebay.nautilus.kernel.content.[] {
                new ErrorMessageDetails()
            });
            content = new Content(null, content1.getResultStatus());
        } else
        {
            ItemMapper.mapGetViewListingToItem(getContext(), (ListingDetails)content1.getData(), (Item)content.getData(), viewData);
            content1 = (Item)content.getData();
            if (ViewItemDataManager.access$4000(ViewItemDataManager.this).onId != null)
            {
                content1.transactionId = ViewItemDataManager.access$4000(ViewItemDataManager.this).onId;
            }
            if (ViewItemDataManager.access$1000(ViewItemDataManager.this) != null)
            {
                content1.user = getUserName();
            }
            ViewItemDataManager.access$4100(ViewItemDataManager.this, viewData, content1);
            ViewItemDataManager.access$4200(ViewItemDataManager.this, content, viewData);
            ViewItemDataManager.access$4300(ViewItemDataManager.this, content, viewData);
        }
          goto _L1
_L3:
        flag1 = false;
        item = (Item)content.getData();
        flag = flag1;
        obj = item;
        if (quantity != null)
        {
            flag = flag1;
            obj = item;
            if (quantity.intValue() > 1)
            {
                obj = new Item();
                flag = true;
            }
        }
        ItemMapper.mapShipping(getContext(), ((ListingDetails)content1.getData()).listing, ((Item) (obj)));
        if (flag)
        {
            ((Item)content.getData()).shippingInfoUpdated = ((Item) (obj)).shippingInfo;
        }
          goto _L1
_L2:
        obj = new Item();
        ItemMapper.mapGetViewListingToItem(getContext(), (ListingDetails)content1.getData(), ((Item) (obj)), viewData);
        ((Item)content.getData()).isReserveMet = ((Item) (obj)).isReserveMet;
        ((Item)content.getData()).buyItNowAvailable = ((Item) (obj)).buyItNowAvailable;
          goto _L1
        content = new Content(null, content1.getStatus());
          goto _L1
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    protected nse(ViewItemViewData viewitemviewdata, EbaySite ebaysite, Content content1, nse nse)
    {
        this(viewitemviewdata, ebaysite, content1, nse, null, null);
    }

    protected <init>(ViewItemViewData viewitemviewdata, EbaySite ebaysite, Content content1, <init> <init>1, ItemCurrency itemcurrency, Integer integer)
    {
        this$0 = ViewItemDataManager.this;
        super();
        viewData = viewitemviewdata;
        site = ebaysite;
        content = content1;
        unitPrice = itemcurrency;
        quantity = integer;
        taskId = <init>1;
        ViewItemDataManager.access$000(ViewItemDataManager.this, <init>1);
    }
}

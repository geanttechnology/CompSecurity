// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.local.EbayNowDeliveryTimeSlot;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.net.api.local:
//            BaseEbayNowDataManager, EbayNowTimeSlotRequest, EbayNowTimeSlotResponse, BaseEbayNowRequest, 
//            BaseEbayNowResponse

public final class EbayNowTimeSlotDataManager extends BaseEbayNowDataManager
{
    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return (KeyParams)DataMapperFactory.readParcelJson(parcel, com/ebay/common/net/api/local/EbayNowTimeSlotDataManager$KeyParams);
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
        public final Cart cart;
        public final String iafToken;
        public final ArrayList lineItems;
        public final String sellerId;
        public final ArrayList serviceIds;
        public final String storeId;
        public final String zoneId;

        private static ArrayList createSingleItemList(com.ebay.common.model.cart.Cart.LineItem lineitem)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(lineitem);
            return arraylist;
        }

        public EbayNowTimeSlotDataManager createManager(EbayContext ebaycontext)
        {
            return new EbayNowTimeSlotDataManager(ebaycontext, this);
        }

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof KeyParams))
                {
                    return false;
                }
                obj = (KeyParams)obj;
                if (!TextUtils.equals(iafToken, ((KeyParams) (obj)).iafToken) || cart != ((KeyParams) (obj)).cart && (cart == null || !cart.equals(((KeyParams) (obj)).cart)) || lineItems != ((KeyParams) (obj)).lineItems && (lineItems == null || !lineItems.equals(((KeyParams) (obj)).lineItems)) || !TextUtils.equals(zoneId, ((KeyParams) (obj)).zoneId) || !TextUtils.equals(sellerId, ((KeyParams) (obj)).sellerId) || !TextUtils.equals(storeId, ((KeyParams) (obj)).storeId) || serviceIds != ((KeyParams) (obj)).serviceIds && (serviceIds == null || !serviceIds.equals(((KeyParams) (obj)).serviceIds)))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            int k1 = 0;
            int l1 = super.hashCode();
            int i;
            int j;
            int k;
            int l;
            int i1;
            int j1;
            if (iafToken == null)
            {
                i = 0;
            } else
            {
                i = iafToken.hashCode();
            }
            if (cart == null)
            {
                j = 0;
            } else
            {
                j = cart.hashCode();
            }
            if (lineItems == null)
            {
                k = 0;
            } else
            {
                k = lineItems.hashCode();
            }
            if (zoneId == null)
            {
                l = 0;
            } else
            {
                l = zoneId.hashCode();
            }
            if (sellerId == null)
            {
                i1 = 0;
            } else
            {
                i1 = sellerId.hashCode();
            }
            if (storeId == null)
            {
                j1 = 0;
            } else
            {
                j1 = storeId.hashCode();
            }
            if (serviceIds != null)
            {
                k1 = serviceIds.hashCode();
            }
            return ((((((l1 * 31 + i) * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            DataMapperFactory.writeParcelJson(parcel, this);
        }


        public KeyParams(String s, Cart cart1, com.ebay.common.model.cart.Cart.LineItem lineitem, String s1, String s2, String s3, ArrayList arraylist)
        {
            this(s, cart1, createSingleItemList(lineitem), s1, s2, s3, arraylist);
        }

        public KeyParams(String s, Cart cart1, ArrayList arraylist, String s1, String s2, String s3, ArrayList arraylist1)
        {
            iafToken = s;
            cart = cart1;
            lineItems = arraylist;
            zoneId = s1;
            sellerId = s2;
            storeId = s3;
            serviceIds = arraylist1;
        }
    }

    public static interface Observer
    {

        public abstract void onTimeSlotsChanged(EbayNowTimeSlotDataManager ebaynowtimeslotdatamanager, Content content);
    }


    private final KeyParams params;

    EbayNowTimeSlotDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/common/net/api/local/EbayNowTimeSlotDataManager$Observer);
        params = keyparams;
    }

    protected volatile BaseEbayNowRequest createRequest()
    {
        return createRequest();
    }

    protected EbayNowTimeSlotRequest createRequest()
    {
        return new EbayNowTimeSlotRequest(params.iafToken, params.cart, params.lineItems, params.zoneId, params.sellerId, params.storeId, params.serviceIds);
    }

    public KeyParams getParams()
    {
        return params;
    }

    public volatile Object getParams()
    {
        return getParams();
    }

    protected volatile Object getResponseResult(BaseEbayNowResponse baseebaynowresponse)
    {
        return getResponseResult((EbayNowTimeSlotResponse)baseebaynowresponse);
    }

    protected EbayNowDeliveryTimeSlot[] getResponseResult(EbayNowTimeSlotResponse ebaynowtimeslotresponse)
    {
        return (EbayNowDeliveryTimeSlot[])ebaynowtimeslotresponse.getResult();
    }

    protected void observerCallback(Observer observer, Content content)
    {
        observer.onTimeSlotsChanged(this, content);
    }

    protected volatile void observerCallback(Object obj, Content content)
    {
        observerCallback((Observer)obj, content);
    }
}

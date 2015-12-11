// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.common.model.local.EbayNowValidateTimeSlotResult;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.local:
//            BaseEbayNowDataManager, EbayNowValidateTimeSlotRequest, BaseEbayNowRequest, BaseEbayNowResponse

public final class EbayNowValidateTimeSlotDataManager extends BaseEbayNowDataManager
{
    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return (KeyParams)DataMapperFactory.readParcelJson(parcel, com/ebay/common/net/api/local/EbayNowValidateTimeSlotDataManager$KeyParams);
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
        public final String deliveryNotes;
        public final String iafToken;
        public final String phone;
        public final String reservationToken;

        public EbayNowValidateTimeSlotDataManager createManager(EbayContext ebaycontext)
        {
            return new EbayNowValidateTimeSlotDataManager(ebaycontext, this);
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
                if (!TextUtils.equals(iafToken, ((KeyParams) (obj)).iafToken) || !TextUtils.equals(reservationToken, ((KeyParams) (obj)).reservationToken) || !TextUtils.equals(phone, ((KeyParams) (obj)).phone) || !TextUtils.equals(deliveryNotes, ((KeyParams) (obj)).deliveryNotes))
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
            if (iafToken == null)
            {
                i = 0;
            } else
            {
                i = iafToken.hashCode();
            }
            if (reservationToken == null)
            {
                j = 0;
            } else
            {
                j = reservationToken.hashCode();
            }
            if (phone == null)
            {
                k = 0;
            } else
            {
                k = phone.hashCode();
            }
            if (deliveryNotes != null)
            {
                l = deliveryNotes.hashCode();
            }
            return (((i1 * 31 + i) * 31 + j) * 31 + k) * 31 + l;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            DataMapperFactory.writeParcelJson(parcel, this);
        }


        public KeyParams(String s, String s1, String s2, String s3)
        {
            iafToken = s;
            reservationToken = s1;
            phone = s2;
            deliveryNotes = s3;
        }
    }

    public static interface Observer
    {

        public abstract void onValidateTimeSlotComplete(EbayNowValidateTimeSlotDataManager ebaynowvalidatetimeslotdatamanager, Content content);
    }


    private final KeyParams params;

    EbayNowValidateTimeSlotDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/common/net/api/local/EbayNowValidateTimeSlotDataManager$Observer);
        params = keyparams;
    }

    protected volatile BaseEbayNowRequest createRequest()
    {
        return createRequest();
    }

    protected EbayNowValidateTimeSlotRequest createRequest()
    {
        return new EbayNowValidateTimeSlotRequest(params.iafToken, params.reservationToken, null, null, params.phone, params.deliveryNotes);
    }

    public KeyParams getParams()
    {
        return params;
    }

    public volatile Object getParams()
    {
        return getParams();
    }

    protected EbayNowValidateTimeSlotResult getResponseResult(BaseEbayNowResponse baseebaynowresponse)
    {
        return null;
    }

    protected volatile Object getResponseResult(BaseEbayNowResponse baseebaynowresponse)
    {
        return getResponseResult(baseebaynowresponse);
    }

    protected void observerCallback(Observer observer, Content content)
    {
        observer.onValidateTimeSlotComplete(this, content);
    }

    protected volatile void observerCallback(Object obj, Content content)
    {
        observerCallback((Observer)obj, content);
    }
}

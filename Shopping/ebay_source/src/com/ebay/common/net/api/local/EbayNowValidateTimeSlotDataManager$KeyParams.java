// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.local:
//            EbayNowValidateTimeSlotDataManager

public static final class deliveryNotes extends com.ebay.nautilus.domain.content.iveryNotes
    implements Parcelable
{

    public static final android.os.riteParcelJson CREATOR = new android.os.Parcelable.Creator() {

        public EbayNowValidateTimeSlotDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return (EbayNowValidateTimeSlotDataManager.KeyParams)DataMapperFactory.readParcelJson(parcel, com/ebay/common/net/api/local/EbayNowValidateTimeSlotDataManager$KeyParams);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayNowValidateTimeSlotDataManager.KeyParams[] newArray(int i)
        {
            return new EbayNowValidateTimeSlotDataManager.KeyParams[i];
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
            if (!(obj instanceof createManager))
            {
                return false;
            }
            obj = (createManager)obj;
            if (!TextUtils.equals(iafToken, ((iafToken) (obj)).iafToken) || !TextUtils.equals(reservationToken, ((reservationToken) (obj)).reservationToken) || !TextUtils.equals(phone, ((phone) (obj)).phone) || !TextUtils.equals(deliveryNotes, ((deliveryNotes) (obj)).deliveryNotes))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int l = 0;
        int i1 = super.iveryNotes();
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


    public _cls1(String s, String s1, String s2, String s3)
    {
        iafToken = s;
        reservationToken = s1;
        phone = s2;
        deliveryNotes = s3;
    }
}

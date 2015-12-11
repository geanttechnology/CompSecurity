// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

public static final class countryCode extends com.ebay.nautilus.domain.content.ms
    implements Parcelable
{

    public static final android.os.ger.KeyParams.countryCode CREATOR = new android.os.Parcelable.Creator() {

        public ViewItemDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return new ViewItemDataManager.KeyParams(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ViewItemDataManager.KeyParams[] newArray(int i)
        {
            return new ViewItemDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final String countryCode;
    public final long itemId;
    public final Locale locale;
    public final Long transactionId;

    public ViewItemDataManager createManager(EbayContext ebaycontext)
    {
        ebaycontext = new ViewItemDataManager(ebaycontext, this);
        ebaycontext.create();
        return ebaycontext;
    }

    public volatile DataManager createManager(EbayContext ebaycontext)
    {
        return createManager(ebaycontext);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (createManager)obj;
            if (itemId != ((itemId) (obj)).itemId || (transactionId != null ? !transactionId.equals(((transactionId) (obj)).transactionId) : ((transactionId) (obj)).transactionId != null) || (!locale.equals(((locale) (obj)).locale) || !countryCode.equals(((countryCode) (obj)).countryCode)))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = super.hashCode();
        int k = Long.valueOf(itemId).hashCode();
        int i;
        if (transactionId == null)
        {
            i = -1;
        } else
        {
            i = transactionId.hashCode();
        }
        return (((j * 31 + k) * 31 + i) * 31 + countryCode.hashCode()) * 31 + locale.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("ItemKey [id=").append(itemId).append(";transactionId=").append(transactionId).append(";locale=").append(locale).append(";country=").append(countryCode).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(itemId);
        if (transactionId != null)
        {
            parcel.writeInt(1);
            parcel.writeLong(transactionId.longValue());
        } else
        {
            parcel.writeInt(0);
        }
        parcel.writeSerializable(locale);
        parcel.writeString(countryCode);
    }


    public _cls1(long l, Long long1)
    {
        if (ViewItemDataManager.logTag.arams)
        {
            ViewItemDataManager.logTag.arams((new StringBuilder()).append("KeyParams: itemId=").append(l).append(";transactionId=").append(long1).toString());
        }
        itemId = l;
        countryCode = MyApp.getPrefs().getCurrentCountry().getCountryCode();
        locale = Locale.getDefault();
        transactionId = long1;
    }

    transactionId(Parcel parcel)
    {
        itemId = parcel.readLong();
        Long long1;
        if (parcel.readInt() != 0)
        {
            long1 = Long.valueOf(parcel.readLong());
        } else
        {
            long1 = null;
        }
        transactionId = long1;
        locale = (Locale)parcel.readSerializable();
        countryCode = parcel.readString();
    }
}

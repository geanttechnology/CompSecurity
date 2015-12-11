// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.net.URL;

// Referenced classes of package com.ebay.mobile.viewitem:
//            BiddingDataManager

public static final class imageUrl extends com.ebay.nautilus.domain.content.dm.er.KeyBase
    implements Parcelable
{

    public static final android.os.ger.KeyParams.imageUrl CREATOR = new android.os.Parcelable.Creator() {

        public BiddingDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            long l = parcel.readLong();
            return new BiddingDataManager.KeyParams(parcel.readString(), l);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public BiddingDataManager.KeyParams[] newArray(int i)
        {
            return new BiddingDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final String imageUrl;
    public final long itemId;

    protected BiddingDataManager create(EbayContext ebaycontext)
    {
        return new BiddingDataManager(ebaycontext, this, null);
    }

    protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof create)
            {
                if (itemId != ((itemId) (obj = (itemId)obj)).itemId || !TextUtils.equals(imageUrl, ((imageUrl) (obj)).imageUrl))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = super.hashCode();
        int k = (int)(itemId ^ itemId >>> 32);
        int i;
        if (imageUrl == null)
        {
            i = 33;
        } else
        {
            i = imageUrl.hashCode();
        }
        return (j * 31 + k) * 31 + i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ItemId: ").append(itemId).append(", imageUrl: ").append(imageUrl).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(itemId);
        parcel.writeString(imageUrl);
    }


    public _cls1(long l, URL url)
    {
        itemId = l;
        imageUrl = BiddingDataManager.access$200(url);
    }

    protected (String s, long l)
    {
        itemId = l;
        imageUrl = s;
    }
}

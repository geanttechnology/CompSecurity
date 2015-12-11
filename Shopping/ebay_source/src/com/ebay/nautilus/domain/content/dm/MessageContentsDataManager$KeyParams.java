// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessageContentsDataManager, UserContextObservingDataManager

public static final class message extends se
    implements Parcelable
{

    public static final android.os.oParcel CREATOR = new android.os.Parcelable.Creator() {

        public MessageContentsDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return new MessageContentsDataManager.KeyParams((EbayMessage)EbayMessage.CREATOR.createFromParcel(parcel));
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public MessageContentsDataManager.KeyParams[] newArray(int i)
        {
            return new MessageContentsDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final EbayMessage message;

    public MessageContentsDataManager create(EbayContext ebaycontext)
    {
        return new MessageContentsDataManager(ebaycontext, this);
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
        if (obj != null && obj.getClass().equals(getClass()))
        {
            return ((create)obj).message.equals(message);
        } else
        {
            return false;
        }
    }

    public final EbayMessage getMessage()
    {
        return message;
    }

    public int hashCode()
    {
        return super.hashCode() * 31 + message.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("message:").append(message).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        message.writeToParcel(parcel, i);
    }


    public _cls1(EbayMessage ebaymessage)
    {
        message = ebaymessage.clone();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Date;

public class EbayMessage extends BaseDataMapped
    implements Parcelable, Cloneable
{
    public static class Builder
    {

        private String externalMessageId;
        private boolean flagged;
        private long folderId;
        private boolean highPriority;
        private Date itemEndDate;
        private long itemId;
        private String itemTitle;
        private String messageId;
        private boolean read;
        private Date receiveDate;
        private boolean replied;
        private boolean responseEnabled;
        private String sendToName;
        private String sender;
        private String subject;
        private String text;

        public EbayMessage build()
        {
            return new EbayMessage(messageId, externalMessageId, flagged, folderId, highPriority, itemEndDate, itemId, itemTitle, read, receiveDate, replied, sender, sendToName, subject, text, responseEnabled);
        }

        public Builder externalMessageId(String s)
        {
            externalMessageId = s;
            return this;
        }

        public Builder flagged(boolean flag)
        {
            flagged = flag;
            return this;
        }

        public Builder folderId(long l)
        {
            folderId = l;
            return this;
        }

        public Builder highPriority(boolean flag)
        {
            highPriority = flag;
            return this;
        }

        public Builder itemEndDate(Date date)
        {
            itemEndDate = date;
            return this;
        }

        public Builder itemId(long l)
        {
            itemId = l;
            return this;
        }

        public Builder itemTitle(String s)
        {
            itemTitle = s;
            return this;
        }

        public Builder messageId(String s)
        {
            messageId = s;
            return this;
        }

        public Builder read(boolean flag)
        {
            read = flag;
            return this;
        }

        public Builder receiveDate(Date date)
        {
            receiveDate = date;
            return this;
        }

        public Builder replied(boolean flag)
        {
            replied = flag;
            return this;
        }

        public Builder responseEnabled(boolean flag)
        {
            responseEnabled = flag;
            return this;
        }

        public Builder sendToName(String s)
        {
            sendToName = s;
            return this;
        }

        public Builder sender(String s)
        {
            sender = s;
            return this;
        }

        public Builder subject(String s)
        {
            subject = s;
            return this;
        }

        public Builder text(String s)
        {
            text = s;
            return this;
        }

        public Builder()
        {
            folderId = -1L;
            itemId = -1L;
        }

        public Builder(String s)
        {
            messageId = s;
            folderId = -1L;
            itemId = -1L;
        }

        public Builder(String s, String s1, boolean flag, long l, boolean flag1, Date date, 
                long l1, String s2, boolean flag2, Date date1, boolean flag3, String s3, 
                String s4, String s5, String s6, boolean flag4)
        {
            messageId = s;
            externalMessageId = s1;
            flagged = flag;
            folderId = l;
            highPriority = flag1;
            itemEndDate = date;
            itemId = l1;
            itemTitle = s2;
            read = flag2;
            receiveDate = date1;
            replied = flag3;
            sender = s3;
            sendToName = s4;
            subject = s5;
            text = s6;
            responseEnabled = flag4;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbayMessage createFromParcel(Parcel parcel)
        {
            return (EbayMessage)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/EbayMessage);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayMessage[] newArray(int i)
        {
            return new EbayMessage[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final long NO_ID = -1L;
    public final String externalMessageId;
    public final boolean flagged;
    public final long folderId;
    public final boolean highPriority;
    public final Date itemEndDate;
    public final long itemId;
    public final String itemTitle;
    public final String messageId;
    public final boolean read;
    public final Date receiveDate;
    public final boolean replied;
    public final boolean responseEnabled;
    public final String sendToName;
    public final String sender;
    public final String subject;
    public final String text;

    private EbayMessage()
    {
        messageId = null;
        externalMessageId = null;
        flagged = false;
        folderId = 0L;
        highPriority = false;
        itemEndDate = null;
        itemId = 0L;
        itemTitle = null;
        read = false;
        receiveDate = null;
        replied = false;
        sender = null;
        sendToName = null;
        subject = null;
        text = null;
        responseEnabled = false;
    }

    public EbayMessage(String s, String s1, boolean flag, long l, boolean flag1, Date date, 
            long l1, String s2, boolean flag2, Date date1, boolean flag3, String s3, 
            String s4, String s5, String s6, boolean flag4)
    {
        messageId = s;
        externalMessageId = s1;
        flagged = flag;
        folderId = l;
        highPriority = flag1;
        itemEndDate = date;
        itemId = l1;
        itemTitle = s2;
        read = flag2;
        receiveDate = date1;
        replied = flag3;
        sender = s3;
        sendToName = s4;
        subject = s5;
        text = s6;
        responseEnabled = flag4;
    }

    public Builder buildUpon()
    {
        return new Builder(messageId, externalMessageId, flagged, folderId, highPriority, itemEndDate, itemId, itemTitle, read, receiveDate, replied, sender, sendToName, subject, text, responseEnabled);
    }

    public EbayMessage clone()
    {
        EbayMessage ebaymessage;
        try
        {
            ebaymessage = (EbayMessage)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            clonenotsupportedexception.printStackTrace();
            return null;
        }
        return ebaymessage;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof EbayMessage)
        {
            obj = (EbayMessage)obj;
            return messageId.equals(((EbayMessage) (obj)).messageId);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return messageId.hashCode();
    }

    public boolean isEbayMessage()
    {
        return TextUtils.equals(sender, "eBay") || TextUtils.equals(sender, "eBay Research");
    }

    public boolean isFlagged()
    {
        return flagged;
    }

    public boolean isHighPriority()
    {
        return highPriority;
    }

    public boolean isInSameFolder(EbayMessage ebaymessage)
    {
        return ebaymessage != null && folderId == ebaymessage.folderId;
    }

    public boolean isMemberMessage()
    {
        return !isEbayMessage();
    }

    public boolean isUnread()
    {
        return !read;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(").append(messageId).append(",").append(folderId).append(",").append(read).append(",").append(flagged).append(")").toString();
    }

}

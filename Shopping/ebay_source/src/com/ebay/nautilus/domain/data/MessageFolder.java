// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            EbayMessage

public class MessageFolder extends BaseDataMapped
    implements Parcelable, Cloneable
{
    public static class Builder
    {

        private long folderId;
        private String folderName;
        private int newMessageCount;
        private int totalMessageCount;

        public MessageFolder build()
        {
            return new MessageFolder(folderId, folderName, newMessageCount, totalMessageCount);
        }

        public Builder folderId(long l)
        {
            folderId = l;
            return this;
        }

        public Builder folderName(String s)
        {
            folderName = s;
            return this;
        }

        public Builder newMessageCount(int i)
        {
            newMessageCount = i;
            return this;
        }

        public Builder totalMessageCount(int i)
        {
            totalMessageCount = i;
            return this;
        }

        public Builder()
        {
            folderId = -1L;
        }

        public Builder(long l)
        {
            folderId = l;
        }

        public Builder(long l, String s, int i, int j)
        {
            folderId = l;
            folderName = s;
            newMessageCount = i;
            totalMessageCount = j;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public MessageFolder createFromParcel(Parcel parcel)
        {
            return (MessageFolder)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/MessageFolder);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public MessageFolder[] newArray(int i)
        {
            return new MessageFolder[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final long FOLDER_ID_ARCHIVE = 6L;
    public static final long FOLDER_ID_INBOX = 0L;
    public static final long FOLDER_ID_SENT = 1L;
    public static final long NO_ID = -1L;
    public final long folderId;
    public final String folderName;
    public final int newMessageCount;
    public final int totalMessageCount;

    private MessageFolder()
    {
        folderId = -1L;
        folderName = null;
        newMessageCount = 0;
        totalMessageCount = 0;
    }

    public MessageFolder(long l, String s, int i, int j)
    {
        folderId = l;
        folderName = s;
        newMessageCount = i;
        totalMessageCount = j;
    }

    public static boolean isArchiveFolder(long l)
    {
        return l == 6L;
    }

    public static boolean isInbox(long l)
    {
        return l == 0L;
    }

    public static boolean isSentFolder(long l)
    {
        return l == 1L;
    }

    public Builder buildUpon()
    {
        return new Builder(folderId, folderName, newMessageCount, totalMessageCount);
    }

    public MessageFolder clone()
    {
        MessageFolder messagefolder;
        try
        {
            messagefolder = (MessageFolder)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            clonenotsupportedexception.printStackTrace();
            return null;
        }
        return messagefolder;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof MessageFolder)
            {
                if (folderId != ((MessageFolder) (obj = (MessageFolder)obj)).folderId)
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
        return Long.valueOf(folderId).hashCode();
    }

    public boolean isArchiveFolder()
    {
        return isArchiveFolder(folderId);
    }

    public boolean isFolderOf(EbayMessage ebaymessage)
    {
        return ebaymessage != null && folderId == ebaymessage.folderId;
    }

    public boolean isInbox()
    {
        return isInbox(folderId);
    }

    public boolean isSentFolder()
    {
        return isSentFolder(folderId);
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(").append(folderId).append(",").append(folderName).append(",").append(newMessageCount).append(",").append(totalMessageCount).append(")").toString();
    }

}

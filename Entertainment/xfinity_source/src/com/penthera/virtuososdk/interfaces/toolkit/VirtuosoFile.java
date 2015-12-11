// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces.toolkit;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import com.penthera.virtuososdk.download.MD5State;
import com.penthera.virtuososdk.internal.interfaces.IEngVFile;
import com.penthera.virtuososdk.utility.Serialization;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.penthera.virtuososdk.interfaces.toolkit:
//            VirtuosoIdentifier, VirtuosoContentBox

class VirtuosoFile extends VirtuosoIdentifier
    implements IEngVFile
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VirtuosoFile createFromParcel(Parcel parcel)
        {
            return new VirtuosoFile(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VirtuosoFile[] newArray(int i)
        {
            return new VirtuosoFile[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    String iAssetId;
    String iAssetURL;
    double iCurrentSize;
    String iDescription;
    long iErrorCount;
    double iExpectedSize;
    String iFileHash;
    String iFilePath;
    boolean iIsPending;
    long iLastUpdateTime;
    MD5State iMD5State;
    String iMimeType;
    String iName;

    VirtuosoFile()
    {
        super(1, 1);
        iExpectedSize = -1D;
        iCurrentSize = 0.0D;
        iIsPending = true;
        iLastUpdateTime = -1L;
    }

    VirtuosoFile(Cursor cursor)
    {
        this();
        refresh(cursor);
    }

    public VirtuosoFile(Parcel parcel)
    {
        iExpectedSize = -1D;
        iCurrentSize = 0.0D;
        iIsPending = true;
        iLastUpdateTime = -1L;
        readFromParcel(parcel);
    }

    public String assetId()
    {
        return iAssetId;
    }

    public String assetURL()
    {
        return iAssetURL;
    }

    public double currentSize()
    {
        return iCurrentSize;
    }

    public long errorCount()
    {
        return iErrorCount;
    }

    public double expectedSize()
    {
        return iExpectedSize;
    }

    public String fileMD5()
    {
        return iFileHash;
    }

    public String filePath()
    {
        return iFilePath;
    }

    public double fractionComplete()
    {
        if (iExpectedSize <= 0.0D)
        {
            return 0.0D;
        } else
        {
            return iCurrentSize / iExpectedSize;
        }
    }

    public boolean isPending()
    {
        return iIsPending;
    }

    public MD5State md5State()
    {
        return iMD5State;
    }

    public byte[] md5StateAsByteArray()
    {
        return Serialization.serializeObject(iMD5State);
    }

    public String metadata()
    {
        return iDescription;
    }

    public String mimeType()
    {
        return iMimeType;
    }

    protected void readFromParcel(Parcel parcel)
    {
        boolean flag = true;
        super.readFromParcel(parcel);
        iAssetURL = readStringProperty(parcel);
        iAssetId = readStringProperty(parcel);
        iDescription = readStringProperty(parcel);
        iExpectedSize = parcel.readDouble();
        iCurrentSize = parcel.readDouble();
        iFilePath = readStringProperty(parcel);
        iFileHash = readStringProperty(parcel);
        iMimeType = readStringProperty(parcel);
        setMd5State(parcel.createByteArray());
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        iIsPending = flag;
        iName = readStringProperty(parcel);
    }

    void refresh(Cursor cursor)
    {
        setAssetUrl(cursor.getString(cursor.getColumnIndex("assetUrl")));
        setAssetId(cursor.getString(cursor.getColumnIndex("assetId")));
        setMetadata(cursor.getString(cursor.getColumnIndex("description")));
        setFileMD5(cursor.getString(cursor.getColumnIndex("fileHash")));
        setMimeType(cursor.getString(cursor.getColumnIndex("mimeType")));
        setCurrentSize(cursor.getLong(cursor.getColumnIndex("currentSize")));
        setExpectedSize(cursor.getLong(cursor.getColumnIndex("expectedSize")));
        setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.values()[(int)cursor.getLong(cursor.getColumnIndex("errorType"))]);
        setFilePath(cursor.getString(cursor.getColumnIndex("filePath")));
        setUuid(cursor.getString(cursor.getColumnIndex("uuid")));
        setErrorCount(cursor.getLong(cursor.getColumnIndex("errorCount")));
        setMd5State(cursor.getBlob(cursor.getColumnIndex("hashState")));
        boolean flag;
        if (cursor.getShort(cursor.getColumnIndex("pending")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setPending(flag);
        setParentUuid(cursor.getString(cursor.getColumnIndex("parentUuid")));
        setType(1);
        setId(cursor.getInt(cursor.getColumnIndex("_id")));
        setCompletionTime(cursor.getLong(cursor.getColumnIndex("completeTime")));
        setClientProviderAuth(cursor.getString(cursor.getColumnIndex("clientAuthority")));
        setContentState(cursor.getInt(cursor.getColumnIndex("contentState")));
    }

    public void regenerateFilePath(ContentResolver contentresolver, String s, Context context)
    {
        setFilePath(VirtuosoContentBox.generateFilePath(this, contentresolver, s, context));
    }

    public void setAssetId(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("aAssetId must be provided");
        } else
        {
            iAssetId = s;
            return;
        }
    }

    public void setAssetUrl(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("aAssetUrl must be provided");
        }
        try
        {
            new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException("aAssetUrl must be a valid URL");
        }
        iAssetURL = s;
    }

    public void setCurrentSize(double d)
    {
        iCurrentSize = d;
    }

    public void setErrorCount(long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException("aErrorCount must be greater than or equal 0");
        } else
        {
            iErrorCount = l;
            return;
        }
    }

    public void setExpectedSize(double d)
    {
        double d1 = d;
        if (d < 0.0D)
        {
            d1 = -1D;
        }
        iExpectedSize = d1;
    }

    public void setFileMD5(String s)
    {
        iFileHash = s;
    }

    public void setFilePath(String s)
    {
        iFilePath = s;
    }

    public void setMd5State(MD5State md5state)
    {
        iMD5State.copy(md5state);
    }

    public void setMd5State(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return;
        } else
        {
            iMD5State = (MD5State)Serialization.deserializeObject(abyte0);
            return;
        }
    }

    public void setMetadata(String s)
    {
        iDescription = s;
    }

    public void setMimeType(String s)
    {
        iMimeType = s;
    }

    public void setPending(boolean flag)
    {
        iIsPending = flag;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        writeStringProperty(parcel, iAssetURL);
        writeStringProperty(parcel, iAssetId);
        writeStringProperty(parcel, iDescription);
        parcel.writeDouble(iExpectedSize);
        parcel.writeDouble(iCurrentSize);
        writeStringProperty(parcel, iFilePath);
        writeStringProperty(parcel, iFileHash);
        writeStringProperty(parcel, iMimeType);
        parcel.writeByteArray(md5StateAsByteArray());
        if (iIsPending)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        writeStringProperty(parcel, iName);
    }

}

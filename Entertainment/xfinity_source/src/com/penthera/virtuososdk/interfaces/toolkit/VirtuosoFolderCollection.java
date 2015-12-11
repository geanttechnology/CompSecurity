// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces.toolkit;

import android.database.Cursor;
import android.os.Parcel;
import com.penthera.virtuososdk.internal.interfaces.IEngVCollection;

// Referenced classes of package com.penthera.virtuososdk.interfaces.toolkit:
//            VirtuosoIdentifier

class VirtuosoFolderCollection extends VirtuosoIdentifier
    implements IEngVCollection
{

    private static final String LOG_TAG = com/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection.getName();
    String iAssetId;
    String iAssetURL;
    int iCompleted;
    double iCurrentSize;
    double iExpectedSize;
    String iMetaData;
    int iSize;
    boolean isAdded;

    VirtuosoFolderCollection()
    {
        super(2, 2);
        iCompleted = 0;
        iSize = 0;
        isAdded = false;
        iCurrentSize = 0.0D;
        iExpectedSize = 0.0D;
    }

    VirtuosoFolderCollection(int i)
    {
        super(i, i);
        iCompleted = 0;
        iSize = 0;
        isAdded = false;
        iCurrentSize = 0.0D;
        iExpectedSize = 0.0D;
    }

    VirtuosoFolderCollection(Cursor cursor)
    {
        this();
        refresh(cursor);
    }

    public VirtuosoFolderCollection(Parcel parcel)
    {
        iCompleted = 0;
        iSize = 0;
        isAdded = false;
        iCurrentSize = 0.0D;
        iExpectedSize = 0.0D;
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

    public double expectedSize()
    {
        return iExpectedSize;
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

    public boolean isAdded()
    {
        return isAdded;
    }

    public String metadata()
    {
        return iMetaData;
    }

    protected void readFromParcel(Parcel parcel)
    {
        boolean flag = true;
        super.readFromParcel(parcel);
        iAssetURL = readStringProperty(parcel);
        iAssetId = readStringProperty(parcel);
        iMetaData = readStringProperty(parcel);
        iCompleted = parcel.readInt();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        isAdded = flag;
        iSize = parcel.readInt();
        iCurrentSize = parcel.readDouble();
        iExpectedSize = parcel.readDouble();
    }

    void refresh(Cursor cursor)
    {
        boolean flag = true;
        setAssetUrl(cursor.getString(cursor.getColumnIndex("assetUrl")));
        setAssetId(cursor.getString(cursor.getColumnIndex("assetId")));
        setMetadata(cursor.getString(cursor.getColumnIndex("description")));
        setUuid(cursor.getString(cursor.getColumnIndex("uuid")));
        setParentUuid(cursor.getString(cursor.getColumnIndex("parentUuid")));
        setType(cursor.getInt(cursor.getColumnIndex("contentType")));
        if (cursor.getInt(cursor.getColumnIndex("addedToQueue")) != 1)
        {
            flag = false;
        }
        setAdded(flag);
        setId(cursor.getInt(cursor.getColumnIndex("_id")));
        setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.values()[(int)cursor.getLong(cursor.getColumnIndex("errorType"))]);
        setCurrentSize(cursor.getLong(cursor.getColumnIndex("currentSize")));
        setExpectedSize(cursor.getLong(cursor.getColumnIndex("expectedSize")));
        setClientProviderAuth(cursor.getString(cursor.getColumnIndex("clientAuthority")));
    }

    public void setAdded(boolean flag)
    {
        isAdded = flag;
    }

    public void setAssetId(String s)
    {
        iAssetId = s;
    }

    public void setAssetUrl(String s)
    {
        iAssetURL = s;
    }

    public void setCurrentSize(double d)
    {
        iCurrentSize = d;
    }

    public void setExpectedSize(double d)
    {
        iExpectedSize = d;
    }

    public void setMetadata(String s)
    {
        iMetaData = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        writeStringProperty(parcel, iAssetURL);
        writeStringProperty(parcel, iAssetId);
        writeStringProperty(parcel, iMetaData);
        parcel.writeInt(iCompleted);
        if (isAdded)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(iSize);
        parcel.writeDouble(iCurrentSize);
        parcel.writeDouble(iExpectedSize);
    }

}

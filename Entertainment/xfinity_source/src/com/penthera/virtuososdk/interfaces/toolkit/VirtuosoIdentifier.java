// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces.toolkit;

import android.os.Parcel;
import com.penthera.virtuososdk.internal.interfaces.IEngVIdentifier;
import java.util.UUID;

class VirtuosoIdentifier
    implements IEngVIdentifier
{

    String iClientProvider;
    long iCompletionTime;
    int iContentState;
    int iContentType;
    com.penthera.virtuososdk.Common.EFileDownloadStatus iDownloadErrorType;
    int iId;
    String iParentUuid;
    int iType;
    String iUuid;

    VirtuosoIdentifier()
    {
        this(0, 0);
    }

    VirtuosoIdentifier(int i, int j)
    {
        iId = -1;
        iDownloadErrorType = com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Not_Pending;
        iContentState = 0;
        iUuid = UUID.randomUUID().toString();
        iParentUuid = null;
        iType = i;
        iContentType = j;
    }

    public VirtuosoIdentifier(Parcel parcel)
    {
        iId = -1;
        iDownloadErrorType = com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_Not_Pending;
        iContentState = 0;
        readFromParcel(parcel);
    }

    public String clientProviderAuth()
    {
        return iClientProvider;
    }

    public long completionTime()
    {
        return iCompletionTime;
    }

    public int describeContents()
    {
        return 0;
    }

    public com.penthera.virtuososdk.Common.EFileDownloadStatus downloadStatus()
    {
        return iDownloadErrorType;
    }

    public int getContentState()
    {
        return iContentState;
    }

    public int id()
    {
        return iId;
    }

    public String parentUuid()
    {
        return iParentUuid;
    }

    protected void readFromParcel(Parcel parcel)
    {
        iType = parcel.readInt();
        iContentType = parcel.readInt();
        iUuid = readStringProperty(parcel);
        iParentUuid = readStringProperty(parcel);
        iId = parcel.readInt();
        iDownloadErrorType = com.penthera.virtuososdk.Common.EFileDownloadStatus.values()[parcel.readInt()];
        iCompletionTime = parcel.readLong();
        iClientProvider = readStringProperty(parcel);
        iContentState = parcel.readInt();
    }

    public String readStringProperty(Parcel parcel)
    {
        String s = parcel.readString();
        parcel = s;
        if (s.equalsIgnoreCase("null"))
        {
            parcel = null;
        }
        return parcel;
    }

    public void setClientProviderAuth(String s)
    {
        iClientProvider = s;
    }

    public void setCompletionTime(long l)
    {
        iCompletionTime = l;
    }

    public void setContentState(int i)
    {
        iContentState = i;
    }

    public void setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus efiledownloadstatus)
    {
        iDownloadErrorType = efiledownloadstatus;
    }

    public void setId(int i)
    {
        iId = i;
    }

    public void setParentUuid(String s)
    {
        iParentUuid = s;
    }

    public void setType(int i)
    {
        iType = i;
    }

    public void setUuid(String s)
    {
        iUuid = s;
    }

    public int type()
    {
        return iType;
    }

    public String uuid()
    {
        return iUuid;
    }

    public void writeStringProperty(Parcel parcel, String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "null";
        }
        parcel.writeString(s1);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(iType);
        parcel.writeInt(iContentType);
        writeStringProperty(parcel, iUuid);
        writeStringProperty(parcel, iParentUuid);
        parcel.writeInt(iId);
        parcel.writeInt(iDownloadErrorType.ordinal());
        parcel.writeLong(iCompletionTime);
        writeStringProperty(parcel, iClientProvider);
        parcel.writeInt(iContentState);
    }
}

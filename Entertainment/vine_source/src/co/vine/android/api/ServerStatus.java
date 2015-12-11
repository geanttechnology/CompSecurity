// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;

public class ServerStatus
    implements Parcelable
{

    public static final String MEDIA_UPLOAD = "media";
    public static final String S3_UPLOAD = "s3";
    public String message;
    public String staticTimelineUrl;
    public String status;
    public String title;
    public String uploadType;

    public ServerStatus(Parcel parcel)
    {
        uploadType = parcel.readString();
        status = parcel.readString();
        title = parcel.readString();
        staticTimelineUrl = parcel.readString();
        message = parcel.readString();
    }

    public ServerStatus(String s, String s1, String s2, String s3, String s4)
    {
        uploadType = s;
        status = s1;
        title = s2;
        staticTimelineUrl = s3;
        message = s4;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (ServerStatus)obj;
            if (message == null ? ((ServerStatus) (obj)).message != null : !message.equals(((ServerStatus) (obj)).message))
            {
                return false;
            }
            if (staticTimelineUrl == null ? ((ServerStatus) (obj)).staticTimelineUrl != null : !staticTimelineUrl.equals(((ServerStatus) (obj)).staticTimelineUrl))
            {
                return false;
            }
            if (status == null ? ((ServerStatus) (obj)).status != null : !status.equals(((ServerStatus) (obj)).status))
            {
                return false;
            }
            if (title == null ? ((ServerStatus) (obj)).title != null : !title.equals(((ServerStatus) (obj)).title))
            {
                return false;
            }
            if (uploadType == null ? ((ServerStatus) (obj)).uploadType != null : !uploadType.equals(((ServerStatus) (obj)).uploadType))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int i1 = 0;
        int i;
        int j;
        int k;
        int l;
        if (uploadType != null)
        {
            i = uploadType.hashCode();
        } else
        {
            i = 0;
        }
        if (status != null)
        {
            j = status.hashCode();
        } else
        {
            j = 0;
        }
        if (title != null)
        {
            k = title.hashCode();
        } else
        {
            k = 0;
        }
        if (staticTimelineUrl != null)
        {
            l = staticTimelineUrl.hashCode();
        } else
        {
            l = 0;
        }
        if (message != null)
        {
            i1 = message.hashCode();
        }
        return (((i * 31 + j) * 31 + k) * 31 + l) * 31 + i1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(uploadType);
        parcel.writeString(status);
        parcel.writeString(title);
        parcel.writeString(staticTimelineUrl);
        parcel.writeString(message);
    }
}

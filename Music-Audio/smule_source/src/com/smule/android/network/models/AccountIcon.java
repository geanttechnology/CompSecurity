// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class AccountIcon
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AccountIcon a(Parcel parcel)
        {
            return new AccountIcon(parcel);
        }

        public AccountIcon[] a(int i)
        {
            return new AccountIcon[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private String a;
    public long accountId;
    public HashSet appsUsed;
    public HashSet appsWithSubscription;
    public String handle;
    public float latitude;
    public float longitude;
    public String picUrl;
    public HashSet platformsWithSmulePass;
    public List verifiedUrls;

    public AccountIcon()
    {
        latitude = 0.0F;
        longitude = 0.0F;
        appsWithSubscription = new HashSet();
        platformsWithSmulePass = new HashSet();
        verifiedUrls = new ArrayList();
        appsUsed = new HashSet();
        a = null;
    }

    public AccountIcon(Parcel parcel)
    {
        latitude = 0.0F;
        longitude = 0.0F;
        appsWithSubscription = new HashSet();
        platformsWithSmulePass = new HashSet();
        verifiedUrls = new ArrayList();
        appsUsed = new HashSet();
        a = null;
        accountId = parcel.readLong();
        picUrl = parcel.readString();
        handle = parcel.readString();
        latitude = parcel.readFloat();
        longitude = parcel.readFloat();
        Object obj = new ArrayList();
        parcel.readStringList(((List) (obj)));
        String s;
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); appsWithSubscription.add(s))
        {
            s = (String)((Iterator) (obj)).next();
        }

        obj = new ArrayList();
        parcel.readStringList(((List) (obj)));
        for (parcel = ((ArrayList) (obj)).iterator(); parcel.hasNext(); platformsWithSmulePass.add(obj))
        {
            obj = (String)parcel.next();
        }

    }

    public void a(String s)
    {
        a = s;
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
            obj = (AccountIcon)obj;
            if (accountId != ((AccountIcon) (obj)).accountId)
            {
                return false;
            }
            if (Float.compare(((AccountIcon) (obj)).latitude, latitude) != 0)
            {
                return false;
            }
            if (Float.compare(((AccountIcon) (obj)).longitude, longitude) != 0)
            {
                return false;
            }
            if (appsUsed == null ? ((AccountIcon) (obj)).appsUsed != null : !appsUsed.equals(((AccountIcon) (obj)).appsUsed))
            {
                return false;
            }
            if (appsWithSubscription == null ? ((AccountIcon) (obj)).appsWithSubscription != null : !appsWithSubscription.equals(((AccountIcon) (obj)).appsWithSubscription))
            {
                return false;
            }
            if (handle == null ? ((AccountIcon) (obj)).handle != null : !handle.equals(((AccountIcon) (obj)).handle))
            {
                return false;
            }
            if (picUrl == null ? ((AccountIcon) (obj)).picUrl != null : !picUrl.equals(((AccountIcon) (obj)).picUrl))
            {
                return false;
            }
            if (platformsWithSmulePass == null ? ((AccountIcon) (obj)).platformsWithSmulePass != null : !platformsWithSmulePass.equals(((AccountIcon) (obj)).platformsWithSmulePass))
            {
                return false;
            }
            if (verifiedUrls == null ? ((AccountIcon) (obj)).verifiedUrls != null : !verifiedUrls.equals(((AccountIcon) (obj)).verifiedUrls))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int l1 = 0;
        int i2 = (int)(accountId ^ accountId >>> 32);
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if (picUrl != null)
        {
            i = picUrl.hashCode();
        } else
        {
            i = 0;
        }
        if (handle != null)
        {
            j = handle.hashCode();
        } else
        {
            j = 0;
        }
        if (latitude != 0.0F)
        {
            k = Float.floatToIntBits(latitude);
        } else
        {
            k = 0;
        }
        if (longitude != 0.0F)
        {
            l = Float.floatToIntBits(longitude);
        } else
        {
            l = 0;
        }
        if (appsWithSubscription != null)
        {
            i1 = appsWithSubscription.hashCode();
        } else
        {
            i1 = 0;
        }
        if (platformsWithSmulePass != null)
        {
            j1 = platformsWithSmulePass.hashCode();
        } else
        {
            j1 = 0;
        }
        if (verifiedUrls != null)
        {
            k1 = verifiedUrls.hashCode();
        } else
        {
            k1 = 0;
        }
        if (appsUsed != null)
        {
            l1 = appsUsed.hashCode();
        }
        return (k1 + (j1 + (i1 + (l + (k + (j + (i + i2 * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("AccountIcon [accountId=").append(accountId).append(", picUrl=").append(picUrl).append(", latitude=").append(latitude).append(", longitude=").append(longitude).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(accountId);
        parcel.writeString(picUrl);
        parcel.writeString(handle);
        parcel.writeFloat(latitude);
        parcel.writeFloat(longitude);
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(appsWithSubscription);
        parcel.writeStringList(arraylist);
        arraylist = new ArrayList();
        arraylist.addAll(platformsWithSmulePass);
        parcel.writeStringList(arraylist);
    }

}

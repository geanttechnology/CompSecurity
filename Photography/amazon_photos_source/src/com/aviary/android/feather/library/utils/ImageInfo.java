// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.utils;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.Locale;

public class ImageInfo
    implements Parcelable
{

    static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ImageInfo createFromParcel(Parcel parcel)
        {
            return new ImageInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ImageInfo[] newArray(int i)
        {
            return new ImageInfo[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    final int decodedSize[] = {
        -1, -1
    };
    List exifTagList;
    int orientation;
    final int originalSize[] = {
        -1, -1
    };
    Uri uri;

    public ImageInfo()
    {
    }

    public ImageInfo(Parcel parcel)
    {
        uri = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        parcel.readIntArray(originalSize);
        parcel.readIntArray(decodedSize);
        orientation = parcel.readInt();
    }

    public int describeContents()
    {
        return 0;
    }

    public int[] getDecodedSize()
    {
        return decodedSize;
    }

    public List getExifTagList()
    {
        return exifTagList;
    }

    public int getOrientation()
    {
        return orientation;
    }

    public int[] getOriginalSize()
    {
        return originalSize;
    }

    public Uri getUri()
    {
        return uri;
    }

    public void setDecodedSize(int i, int j)
    {
        decodedSize[0] = i;
        decodedSize[1] = j;
    }

    public void setExifTagList(List list)
    {
        exifTagList = list;
    }

    public void setOrientation(int i)
    {
        orientation = i;
    }

    public void setOriginalSize(int i, int j)
    {
        originalSize[0] = i;
        originalSize[1] = j;
    }

    public void setUri(Uri uri1)
    {
        uri = uri1;
    }

    public String toString()
    {
        int i = 0;
        Locale locale = Locale.US;
        Uri uri1 = uri;
        int j = orientation;
        int k = originalSize[0];
        int l = originalSize[1];
        int i1 = decodedSize[0];
        int j1 = decodedSize[1];
        if (exifTagList != null)
        {
            i = exifTagList.size();
        }
        return String.format(locale, "ImageInfo{uri:%s, orientation:%d, originalSize:%dx%d, decodedSize:%dx%d, tags:%d}", new Object[] {
            uri1, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(i)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(uri, i);
        parcel.writeIntArray(originalSize);
        parcel.writeIntArray(decodedSize);
        parcel.writeInt(orientation);
    }

}

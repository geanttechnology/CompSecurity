// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.product;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.abtnprojects.ambatana.models.product:
//            AbstractImage

public class LocalImage extends AbstractImage
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LocalImage createFromParcel(Parcel parcel)
        {
            return new LocalImage(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public LocalImage[] newArray(int i)
        {
            return new LocalImage[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private String path;
    private Uri thumbUri;
    private Uri uri;

    public LocalImage(Parcel parcel)
    {
        path = parcel.readString();
        uri = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        thumbUri = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
    }

    public LocalImage(String s, Uri uri1, Uri uri2)
    {
        path = s;
        uri = uri1;
        thumbUri = uri2;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getDisplayUrl()
    {
        Uri uri1 = getThumbUri();
        if (uri1 == null)
        {
            return null;
        } else
        {
            return uri1.toString();
        }
    }

    public String getPath()
    {
        return path;
    }

    public Uri getThumbUri()
    {
        return thumbUri;
    }

    public Uri getUri()
    {
        return uri;
    }

    public void setPath(String s)
    {
        path = s;
    }

    public void setThumbUri(Uri uri1)
    {
        thumbUri = uri1;
    }

    public void setUri(Uri uri1)
    {
        uri = uri1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("LocalImage{path='").append(path).append('\'').append(", uri=").append(uri).append(", thumbUri=").append(thumbUri).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(path);
        parcel.writeParcelable(uri, i);
        parcel.writeParcelable(thumbUri, i);
    }

}

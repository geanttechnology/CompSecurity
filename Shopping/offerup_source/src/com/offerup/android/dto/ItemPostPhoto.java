// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.offerup.android.dto:
//            Photo

public class ItemPostPhoto
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private final Uri imageUri;
    private final String uuid;

    public ItemPostPhoto()
    {
        uuid = null;
        imageUri = null;
    }

    public ItemPostPhoto(Uri uri)
    {
        imageUri = uri;
        uuid = null;
    }

    public ItemPostPhoto(Photo photo)
    {
        if (photo != null)
        {
            uuid = photo.getUuid();
            imageUri = photo.getListUrl();
            return;
        } else
        {
            uuid = null;
            imageUri = null;
            return;
        }
    }

    public ItemPostPhoto(String s, Uri uri)
    {
        uuid = s;
        imageUri = uri;
    }

    public int describeContents()
    {
        return 0;
    }

    public Uri getImageUri()
    {
        return imageUri;
    }

    public String getUuid()
    {
        return uuid;
    }

    public boolean requiresUpload()
    {
        return uuid == null;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeValue(uuid);
        parcel.writeValue(imageUri);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final ItemPostPhoto createFromParcel(Parcel parcel)
        {
            return new ItemPostPhoto((String)parcel.readValue(java/lang/String.getClassLoader()), (Uri)parcel.readValue(android/net/Uri.getClassLoader()));
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final ItemPostPhoto[] newArray(int i)
        {
            return new ItemPostPhoto[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}

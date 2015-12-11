// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            ShareContent, ShareModel, SharePhoto, ShareVideo

public final class ShareVideoContent extends ShareContent
    implements ShareModel
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShareVideoContent createFromParcel(Parcel parcel)
        {
            return new ShareVideoContent(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShareVideoContent[] newArray(int i)
        {
            return new ShareVideoContent[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final String contentDescription;
    private final String contentTitle;
    private final SharePhoto previewPhoto;
    private final ShareVideo video;

    ShareVideoContent(Parcel parcel)
    {
        super(parcel);
        contentDescription = parcel.readString();
        contentTitle = parcel.readString();
        SharePhoto.Builder builder = (new SharePhoto.Builder()).readFrom(parcel);
        if (builder.getImageUrl() != null || builder.getBitmap() != null)
        {
            previewPhoto = builder.build();
        } else
        {
            previewPhoto = null;
        }
        video = (new ShareVideo.Builder()).readFrom(parcel).build();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeString(contentDescription);
        parcel.writeString(contentTitle);
        parcel.writeParcelable(previewPhoto, 0);
        parcel.writeParcelable(video, 0);
    }

}

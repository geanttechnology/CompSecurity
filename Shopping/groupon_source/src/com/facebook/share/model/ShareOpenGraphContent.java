// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            ShareContent, ShareOpenGraphAction

public final class ShareOpenGraphContent extends ShareContent
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShareOpenGraphContent createFromParcel(Parcel parcel)
        {
            return new ShareOpenGraphContent(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShareOpenGraphContent[] newArray(int i)
        {
            return new ShareOpenGraphContent[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final ShareOpenGraphAction action;
    private final String previewPropertyName;

    ShareOpenGraphContent(Parcel parcel)
    {
        super(parcel);
        action = (new ShareOpenGraphAction.Builder()).readFrom(parcel).build();
        previewPropertyName = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(action, 0);
        parcel.writeString(previewPropertyName);
    }

}

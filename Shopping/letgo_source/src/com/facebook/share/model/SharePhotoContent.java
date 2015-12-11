// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Parcel;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.facebook.share.model:
//            ShareContent

public final class SharePhotoContent extends ShareContent
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SharePhotoContent a(Parcel parcel)
        {
            return new SharePhotoContent(parcel);
        }

        public SharePhotoContent[] a(int i)
        {
            return new SharePhotoContent[i];
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
    private final List a;

    SharePhotoContent(Parcel parcel)
    {
        super(parcel);
        a = Collections.unmodifiableList(SharePhoto.a.b(parcel));
    }

    public List a()
    {
        return a;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        SharePhoto.a.a(parcel, a);
    }

}

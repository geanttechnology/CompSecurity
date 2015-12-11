// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcel;
import com.target.mothership.common.page_item.c;
import com.target.mothership.util.p;

// Referenced classes of package com.target.mothership.model.common:
//            OrderProductImage

public class TGTOrderProductImage
    implements OrderProductImage
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderProductImage a(Parcel parcel)
        {
            return new TGTOrderProductImage(parcel);
        }

        public TGTOrderProductImage[] a(int i)
        {
            return new TGTOrderProductImage[i];
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
    private String mImagePath;
    private String mImageResolution;

    public TGTOrderProductImage()
    {
    }

    private TGTOrderProductImage(Parcel parcel)
    {
        mImagePath = parcel.readString();
        mImageResolution = parcel.readString();
    }


    public String a()
    {
        return mImagePath;
    }

    public String a(int i)
    {
        return p.a(mImagePath, i, c.SCENE_7);
    }

    public void a(String s)
    {
        mImagePath = s;
    }

    public void b(String s)
    {
        mImageResolution = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mImagePath);
        parcel.writeString(mImageResolution);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.contextualmenu.api;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;

public class ContextualMenuImage
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ContextualMenuImage createFromParcel(Parcel parcel)
        {
            return new ContextualMenuImage(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ContextualMenuImage[] newArray(int i)
        {
            return new ContextualMenuImage[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final float DEFAULT_SCALE = 1F;
    private static final int PARCEL_CURRENT_VERSION = 1;
    private static final int PARCEL_VERSION_1 = 1;
    private final int mRotateTimerInMS;
    private final float mScale;
    private final String mUrls[];

    public ContextualMenuImage(Parcel parcel)
    {
        if (parcel.readInt() == 1)
        {
            int j = parcel.readInt();
            mUrls = new String[j];
            for (int i = 0; i < j; i++)
            {
                mUrls[i] = parcel.readString();
            }

            mRotateTimerInMS = parcel.readInt();
            mScale = parcel.readFloat();
            return;
        } else
        {
            throw new ParcelFormatException();
        }
    }

    public ContextualMenuImage(String s)
    {
        this(new String[] {
            s
        }, -1);
    }

    public ContextualMenuImage(String s, float f)
    {
        this(new String[] {
            s
        }, -1, f);
    }

    public ContextualMenuImage(String as[], int i)
    {
        this(as, i, 1.0F);
    }

    public ContextualMenuImage(String as[], int i, float f)
    {
        mUrls = as;
        mRotateTimerInMS = i;
        mScale = f;
    }

    public int count()
    {
        return mUrls.length;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getRotateTimerInMs()
    {
        return mRotateTimerInMS;
    }

    public float getScale()
    {
        return mScale;
    }

    public String getUrl(int i)
    {
        if (i < 0 || i >= mUrls.length)
        {
            return null;
        } else
        {
            return mUrls[i];
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(1);
        parcel.writeInt(mUrls.length);
        for (i = 0; i < mUrls.length; i++)
        {
            parcel.writeString(mUrls[i]);
        }

        parcel.writeInt(mRotateTimerInMS);
        parcel.writeFloat(mScale);
    }

}

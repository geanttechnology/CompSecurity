// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.contextualmenu.api;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;

// Referenced classes of package com.fanhattan.services.contextualmenu.api:
//            IContextualMenuElement, ContextualMenuImage

public class ContextualMenuItem
    implements IContextualMenuElement, Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ContextualMenuItem createFromParcel(Parcel parcel)
        {
            return new ContextualMenuItem(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ContextualMenuItem[] newArray(int i)
        {
            return new ContextualMenuItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final int PARCEL_CURRENT_VERSION = 1;
    private static final int PARCEL_VERSION_1 = 1;
    private final String mId;
    private boolean mIsEnabled;
    private ContextualMenuImage mLeftImage;
    private ContextualMenuImage mLeftImageBackground;
    private int mOdrder;
    private ContextualMenuImage mRightImage;
    private ContextualMenuImage mRightImageBackground;
    private String mText;

    public ContextualMenuItem(Parcel parcel)
    {
        if (parcel.readInt() == 1)
        {
            mId = parcel.readString();
            mText = parcel.readString();
            mLeftImage = (ContextualMenuImage)parcel.readParcelable(com/fanhattan/services/contextualmenu/api/ContextualMenuImage.getClassLoader());
            mLeftImageBackground = (ContextualMenuImage)parcel.readParcelable(com/fanhattan/services/contextualmenu/api/ContextualMenuItem.getClassLoader());
            mRightImage = (ContextualMenuImage)parcel.readParcelable(com/fanhattan/services/contextualmenu/api/ContextualMenuImage.getClassLoader());
            mRightImageBackground = (ContextualMenuImage)parcel.readParcelable(com/fanhattan/services/contextualmenu/api/ContextualMenuItem.getClassLoader());
            boolean flag;
            if (parcel.readByte() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mIsEnabled = flag;
            mOdrder = parcel.readInt();
            return;
        } else
        {
            throw new ParcelFormatException();
        }
    }

    public ContextualMenuItem(String s, String s1)
    {
        this(s, s1, null, null, true);
    }

    public ContextualMenuItem(String s, String s1, int i)
    {
        this(s, s1, null, null, i, true);
    }

    public ContextualMenuItem(String s, String s1, ContextualMenuImage contextualmenuimage, ContextualMenuImage contextualmenuimage1, int i, boolean flag)
    {
        mId = s;
        mText = s1;
        mLeftImage = contextualmenuimage;
        mRightImage = contextualmenuimage1;
        mIsEnabled = flag;
        mOdrder = i;
    }

    public ContextualMenuItem(String s, String s1, ContextualMenuImage contextualmenuimage, ContextualMenuImage contextualmenuimage1, boolean flag)
    {
        this(s, s1, contextualmenuimage, contextualmenuimage1, -1, flag);
    }

    public int describeContents()
    {
        return 0;
    }

    public String getId()
    {
        return mId;
    }

    public ContextualMenuImage getLeftImage()
    {
        return mLeftImage;
    }

    public ContextualMenuImage getLeftImageBackground()
    {
        return mLeftImageBackground;
    }

    public int getOrder()
    {
        return mOdrder;
    }

    public ContextualMenuImage getRightImage()
    {
        return mRightImage;
    }

    public ContextualMenuImage getRightImageBackground()
    {
        return mRightImageBackground;
    }

    public String getText()
    {
        return mText;
    }

    public boolean isEnabled()
    {
        return mIsEnabled;
    }

    public void setEnabled(boolean flag)
    {
        mIsEnabled = flag;
    }

    public void setLeftImage(ContextualMenuImage contextualmenuimage)
    {
        mLeftImage = contextualmenuimage;
    }

    public void setLeftImageBackground(ContextualMenuImage contextualmenuimage)
    {
        mLeftImageBackground = contextualmenuimage;
    }

    public void setOrder(int i)
    {
        mOdrder = i;
    }

    public void setRightImage(ContextualMenuImage contextualmenuimage)
    {
        mRightImage = contextualmenuimage;
    }

    public void setRightImageBackground(ContextualMenuImage contextualmenuimage)
    {
        mRightImageBackground = contextualmenuimage;
    }

    public void setText(String s)
    {
        mText = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeInt(1);
        parcel.writeString(mId);
        parcel.writeString(mText);
        parcel.writeParcelable(mLeftImage, i);
        parcel.writeParcelable(mLeftImageBackground, i);
        parcel.writeParcelable(mRightImage, i);
        parcel.writeParcelable(mRightImageBackground, i);
        if (mIsEnabled)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeInt(mOdrder);
    }

}

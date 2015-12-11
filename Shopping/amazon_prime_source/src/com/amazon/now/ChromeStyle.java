// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;

public class ChromeStyle
    implements Parcelable
{
    public static final class ChromeLayout extends Enum
    {

        private static final ChromeLayout $VALUES[];
        public static final ChromeLayout HEADER;
        public static final ChromeLayout LOGO_ONLY;
        public static final ChromeLayout NONE;
        public static final ChromeLayout NORMAL;

        public static ChromeLayout valueOf(String s)
        {
            return (ChromeLayout)Enum.valueOf(com/amazon/now/ChromeStyle$ChromeLayout, s);
        }

        public static ChromeLayout[] values()
        {
            return (ChromeLayout[])$VALUES.clone();
        }

        static 
        {
            NONE = new ChromeLayout("NONE", 0);
            NORMAL = new ChromeLayout("NORMAL", 1);
            LOGO_ONLY = new ChromeLayout("LOGO_ONLY", 2);
            HEADER = new ChromeLayout("HEADER", 3);
            $VALUES = (new ChromeLayout[] {
                NONE, NORMAL, LOGO_ONLY, HEADER
            });
        }

        private ChromeLayout(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ChromeStyle createFromParcel(Parcel parcel)
        {
            return new ChromeStyle(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ChromeStyle[] newArray(int i)
        {
            return new ChromeStyle[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final int PRIME_NOW_ORANGE = Color.parseColor("#FF7817");
    private static final String TAG = com/amazon/now/ChromeStyle.getSimpleName();
    private int mColor;
    private String mHeader;
    private ChromeLayout mLayout;
    private boolean mSetBackground;

    public ChromeStyle(Parcel parcel)
    {
        mSetBackground = false;
        mLayout = (ChromeLayout)parcel.readSerializable();
        mColor = parcel.readInt();
        mHeader = parcel.readString();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mSetBackground = flag;
    }

    public ChromeStyle(ChromeLayout chromelayout)
    {
        mSetBackground = false;
        mLayout = chromelayout;
        mColor = PRIME_NOW_ORANGE;
    }

    public ChromeStyle(ChromeLayout chromelayout, int i, boolean flag)
    {
        mSetBackground = false;
        mLayout = chromelayout;
        mColor = i;
        mSetBackground = flag;
    }

    public ChromeStyle(ChromeLayout chromelayout, String s)
    {
        mSetBackground = false;
        mLayout = chromelayout;
        if (TextUtils.isEmpty(s))
        {
            mColor = PRIME_NOW_ORANGE;
            return;
        }
        try
        {
            mColor = Color.parseColor(validatePrefix(s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ChromeLayout chromelayout)
        {
            Log.e(TAG, "Wrong color code passed, fall back to orange", chromelayout);
        }
        mColor = PRIME_NOW_ORANGE;
    }

    public ChromeStyle(ChromeLayout chromelayout, String s, boolean flag)
    {
        this(chromelayout, s);
        mSetBackground = flag;
    }

    private String validatePrefix(String s)
    {
        String s1 = s;
        if (!s.startsWith("#"))
        {
            s1 = (new StringBuilder()).append("#").append(s).toString();
        }
        return s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getColor()
    {
        return mColor;
    }

    public String getHeader()
    {
        return mHeader;
    }

    public ChromeLayout getLayout()
    {
        return mLayout;
    }

    public void setHeader(String s)
    {
        mHeader = s;
    }

    public boolean shouldSetBackground()
    {
        return mSetBackground;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mLayout);
        parcel.writeInt(mColor);
        parcel.writeString(mHeader);
        if (mSetBackground)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

}

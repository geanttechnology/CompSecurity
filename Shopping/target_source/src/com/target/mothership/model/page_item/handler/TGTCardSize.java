// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;
import com.target.mothership.common.page_item.a;
import com.target.mothership.model.page_item.interfaces.CardSize;

class TGTCardSize
    implements CardSize
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCardSize a(Parcel parcel)
        {
            return new TGTCardSize(parcel);
        }

        public TGTCardSize[] a(int i)
        {
            return new TGTCardSize[i];
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
    private a mCardSizeType;
    private int mHeight;
    private int mWidth;

    public TGTCardSize()
    {
    }

    private TGTCardSize(Parcel parcel)
    {
        int i = parcel.readInt();
        if (i == -1)
        {
            parcel = null;
        } else
        {
            parcel = com.target.mothership.common.page_item.a.values()[i];
        }
        mCardSizeType = parcel;
        b(mCardSizeType);
    }


    private void b(a a1)
    {
        if (a1 == null)
        {
            mWidth = 1;
            mHeight = 1;
            return;
        }
        static class _cls2
        {

            static final int $SwitchMap$com$target$mothership$common$page_item$CardSizeType[];

            static 
            {
                $SwitchMap$com$target$mothership$common$page_item$CardSizeType = new int[com.target.mothership.common.page_item.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$page_item$CardSizeType[a.ONE_X_ONE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$page_item$CardSizeType[a.ONE_X_TWO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$page_item$CardSizeType[a.TWO_X_ONE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$page_item$CardSizeType[a.TWO_X_TWO.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$page_item$CardSizeType[a.THREE_X_ONE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$page_item$CardSizeType[a.THREE_X_TWO.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$page_item$CardSizeType[a.UNKNOWN.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.target.mothership.common.page_item.CardSizeType[a1.ordinal()])
        {
        default:
            mWidth = 1;
            mHeight = 1;
            return;

        case 1: // '\001'
            mWidth = 1;
            mHeight = 1;
            return;

        case 2: // '\002'
            mWidth = 1;
            mHeight = 2;
            return;

        case 3: // '\003'
            mWidth = 2;
            mHeight = 1;
            return;

        case 4: // '\004'
            mWidth = 2;
            mHeight = 2;
            return;

        case 5: // '\005'
            mWidth = 3;
            mHeight = 1;
            return;

        case 6: // '\006'
            mWidth = 3;
            break;
        }
        mHeight = 2;
    }

    public int a()
    {
        return mHeight;
    }

    public void a(a a1)
    {
        mCardSizeType = a1;
        b(a1);
    }

    public int b()
    {
        return mWidth;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mCardSizeType == null)
        {
            i = -1;
        } else
        {
            i = mCardSizeType.ordinal();
        }
        parcel.writeInt(i);
    }

}

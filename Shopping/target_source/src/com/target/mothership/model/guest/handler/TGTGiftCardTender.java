// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.model.common.GiftCardTender;
import com.target.mothership.util.c;
import java.math.BigDecimal;

public class TGTGiftCardTender
    implements GiftCardTender
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTGiftCardTender a(Parcel parcel)
        {
            return new TGTGiftCardTender(parcel);
        }

        public TGTGiftCardTender[] a(int i)
        {
            return new TGTGiftCardTender[i];
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
    private String mAccessCode;
    private BigDecimal mBalance;
    private String mBarCodeImageUrl;
    private String mCardInfoId;
    private String mCardNumber;
    private String mNickName;

    TGTGiftCardTender()
    {
    }

    private TGTGiftCardTender(Parcel parcel)
    {
        mCardInfoId = parcel.readString();
        mCardNumber = parcel.readString();
        mAccessCode = parcel.readString();
        mBalance = (BigDecimal)parcel.readSerializable();
        mNickName = parcel.readString();
        mBarCodeImageUrl = parcel.readString();
    }


    public String a()
    {
        return mCardInfoId;
    }

    public void a(String s)
    {
        mCardInfoId = s;
    }

    public String b()
    {
        return mCardNumber;
    }

    public void b(String s)
    {
        mCardNumber = s;
    }

    public String c()
    {
        return mAccessCode;
    }

    public void c(String s)
    {
        mAccessCode = s;
    }

    public BigDecimal d()
    {
        return mBalance;
    }

    public void d(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mBalance = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return mBarCodeImageUrl;
    }

    public void e(String s)
    {
        mNickName = s;
    }

    public boolean equals(Object obj)
    {
        boolean flag1;
        boolean flag2;
        flag1 = true;
        flag2 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag2;
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag = flag2;
        if (getClass() != obj.getClass()) goto _L4; else goto _L5
_L5:
        obj = (TGTGiftCardTender)obj;
        if (mCardNumber == null) goto _L7; else goto _L6
_L6:
        flag = flag2;
        if (!mCardNumber.equals(((TGTGiftCardTender) (obj)).mCardNumber)) goto _L4; else goto _L8
_L8:
        if (mAccessCode == null) goto _L10; else goto _L9
_L9:
        flag = flag2;
        if (!mAccessCode.equals(((TGTGiftCardTender) (obj)).mAccessCode)) goto _L4; else goto _L11
_L11:
        if (mBalance == null) goto _L13; else goto _L12
_L12:
        flag = flag2;
        if (!mBalance.equals(((TGTGiftCardTender) (obj)).mBalance)) goto _L4; else goto _L14
_L14:
        if (mNickName == null) goto _L16; else goto _L15
_L15:
        flag = flag2;
        if (!mNickName.equals(((TGTGiftCardTender) (obj)).mNickName)) goto _L4; else goto _L17
_L17:
        if (mBarCodeImageUrl == null) goto _L19; else goto _L18
_L18:
        flag = flag1;
        if (mBarCodeImageUrl.equals(((TGTGiftCardTender) (obj)).mBarCodeImageUrl)) goto _L21; else goto _L20
_L20:
        flag = false;
_L21:
        return flag;
_L7:
        if (((TGTGiftCardTender) (obj)).mCardNumber == null) goto _L8; else goto _L22
_L22:
        return false;
_L10:
        if (((TGTGiftCardTender) (obj)).mAccessCode == null) goto _L11; else goto _L23
_L23:
        return false;
_L13:
        if (((TGTGiftCardTender) (obj)).mBalance == null) goto _L14; else goto _L24
_L24:
        return false;
_L16:
        if (((TGTGiftCardTender) (obj)).mNickName == null) goto _L17; else goto _L25
_L25:
        return false;
_L19:
        if (((TGTGiftCardTender) (obj)).mBarCodeImageUrl != null) goto _L20; else goto _L26
_L26:
        flag = flag1;
          goto _L21
    }

    public void f(String s)
    {
        mBarCodeImageUrl = s;
    }

    public int hashCode()
    {
        int i1 = 0;
        int i;
        int j;
        int k;
        int l;
        if (mCardNumber != null)
        {
            i = mCardNumber.hashCode();
        } else
        {
            i = 0;
        }
        if (mAccessCode != null)
        {
            j = mAccessCode.hashCode();
        } else
        {
            j = 0;
        }
        if (mBalance != null)
        {
            k = mBalance.hashCode();
        } else
        {
            k = 0;
        }
        if (mNickName != null)
        {
            l = mNickName.hashCode();
        } else
        {
            l = 0;
        }
        if (mBarCodeImageUrl != null)
        {
            i1 = mBarCodeImageUrl.hashCode();
        }
        return (l + (k + (j + i * 31) * 31) * 31) * 31 + i1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mCardInfoId);
        parcel.writeString(mCardNumber);
        parcel.writeString(mAccessCode);
        parcel.writeSerializable(mBalance);
        parcel.writeString(mNickName);
        parcel.writeString(mBarCodeImageUrl);
    }

}

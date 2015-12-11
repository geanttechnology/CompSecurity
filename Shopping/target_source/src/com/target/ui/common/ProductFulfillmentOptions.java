// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.product.d;

public class ProductFulfillmentOptions
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProductFulfillmentOptions a(Parcel parcel)
        {
            return new ProductFulfillmentOptions(parcel);
        }

        public ProductFulfillmentOptions[] a(int i1)
        {
            return new ProductFulfillmentOptions[i1];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i1)
        {
            return a(i1);
        }

    };
    private boolean mAddToListEnabled;
    private int mAddToListText;
    private String mAisleText;
    private d mDepartment;
    private boolean mEmailEnabled;
    private int mEmailText;
    private boolean mFindInStoreEnabled;
    private int mFindInStoreText;
    private boolean mMailEnabled;
    private int mMailText;
    private boolean mPickUpEnabled;
    private int mPickUpText;
    private boolean mShipItEnabled;
    private int mShipItText;
    private boolean mShowAddToList;
    private boolean mShowAisle;
    private boolean mShowEmail;
    private boolean mShowFindInStore;
    private boolean mShowMail;
    private boolean mShowPickup;
    private boolean mShowShipIt;
    private boolean mShowSms;
    private boolean mSmsEnabled;
    private int mSmsText;

    public ProductFulfillmentOptions()
    {
        mShowFindInStore = false;
        mShowPickup = false;
        mShowShipIt = false;
        mShowMail = false;
        mShowAisle = false;
        mPickUpEnabled = true;
        mShipItEnabled = true;
        mShowAddToList = true;
        mAddToListEnabled = true;
    }

    protected ProductFulfillmentOptions(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        int i1;
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShowEmail = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShowSms = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShowFindInStore = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShowPickup = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShowShipIt = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShowMail = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShowAisle = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShowAddToList = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mEmailEnabled = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mSmsEnabled = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mPickUpEnabled = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShipItEnabled = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mMailEnabled = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mFindInStoreEnabled = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mAddToListEnabled = flag;
        mEmailText = parcel.readInt();
        mSmsText = parcel.readInt();
        mShipItText = parcel.readInt();
        mMailText = parcel.readInt();
        mPickUpText = parcel.readInt();
        mFindInStoreText = parcel.readInt();
        mAddToListText = parcel.readInt();
        mAisleText = parcel.readString();
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            parcel = null;
        } else
        {
            parcel = com.target.mothership.common.product.d.values()[i1];
        }
        mDepartment = parcel;
    }

    public void a(int i1)
    {
        mShipItText = i1;
    }

    public void a(d d1)
    {
        mDepartment = d1;
    }

    public void a(String s1)
    {
        mAisleText = s1;
    }

    public void a(boolean flag)
    {
        mShowEmail = flag;
    }

    public boolean a()
    {
        return mShowEmail;
    }

    public void b(int i1)
    {
        mMailText = i1;
    }

    public void b(boolean flag)
    {
        mShowSms = flag;
    }

    public boolean b()
    {
        return mShowSms;
    }

    public void c(int i1)
    {
        mPickUpText = i1;
    }

    public void c(boolean flag)
    {
        mShowFindInStore = flag;
    }

    public boolean c()
    {
        return mShowFindInStore;
    }

    public void d(int i1)
    {
        mFindInStoreText = i1;
    }

    public void d(boolean flag)
    {
        mShowPickup = flag;
    }

    public boolean d()
    {
        return mShowPickup;
    }

    public int describeContents()
    {
        return 0;
    }

    public void e(int i1)
    {
        mAddToListText = i1;
    }

    public void e(boolean flag)
    {
        mShowShipIt = flag;
    }

    public boolean e()
    {
        return mShowShipIt;
    }

    public void f(int i1)
    {
        mEmailText = i1;
    }

    public void f(boolean flag)
    {
        mShowMail = flag;
    }

    public boolean f()
    {
        return mShowMail;
    }

    public void g(int i1)
    {
        mSmsText = i1;
    }

    public void g(boolean flag)
    {
        mShowAisle = flag;
    }

    public boolean g()
    {
        return mShowAisle;
    }

    public void h(boolean flag)
    {
        mShowAddToList = flag;
    }

    public boolean h()
    {
        return mShowAddToList;
    }

    public void i(boolean flag)
    {
        mEmailEnabled = flag;
    }

    public boolean i()
    {
        return mEmailEnabled;
    }

    public void j(boolean flag)
    {
        mSmsEnabled = flag;
    }

    public boolean j()
    {
        return mSmsEnabled;
    }

    public void k(boolean flag)
    {
        mPickUpEnabled = flag;
    }

    public boolean k()
    {
        return mPickUpEnabled;
    }

    public void l(boolean flag)
    {
        mShipItEnabled = flag;
    }

    public boolean l()
    {
        return mShipItEnabled;
    }

    public void m(boolean flag)
    {
        mMailEnabled = flag;
    }

    public boolean m()
    {
        return mMailEnabled;
    }

    public void n(boolean flag)
    {
        mFindInStoreEnabled = flag;
    }

    public boolean n()
    {
        return mFindInStoreEnabled;
    }

    public void o(boolean flag)
    {
        mAddToListEnabled = flag;
    }

    public boolean o()
    {
        return mAddToListEnabled;
    }

    public int p()
    {
        return mShipItText;
    }

    public int q()
    {
        return mMailText;
    }

    public int r()
    {
        return mPickUpText;
    }

    public int s()
    {
        return mFindInStoreText;
    }

    public String t()
    {
        return mAisleText;
    }

    public int u()
    {
        return mEmailText;
    }

    public int v()
    {
        return mSmsText;
    }

    public int w()
    {
        return mAddToListText;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        boolean flag = true;
        byte byte0;
        if (mShowEmail)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mShowSms)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mShowFindInStore)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mShowPickup)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mShowShipIt)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mShowMail)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mShowAisle)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mShowAddToList)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mEmailEnabled)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mSmsEnabled)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mPickUpEnabled)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mShipItEnabled)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mMailEnabled)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mFindInStoreEnabled)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mAddToListEnabled)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeInt(mEmailText);
        parcel.writeInt(mSmsText);
        parcel.writeInt(mShipItText);
        parcel.writeInt(mMailText);
        parcel.writeInt(mPickUpText);
        parcel.writeInt(mFindInStoreText);
        parcel.writeInt(mAddToListText);
        parcel.writeString(mAisleText);
        if (mDepartment == null)
        {
            i1 = -1;
        } else
        {
            i1 = mDepartment.ordinal();
        }
        parcel.writeInt(i1);
    }

    public d x()
    {
        if (mDepartment == null)
        {
            return d.UNKNOWN;
        } else
        {
            return mDepartment;
        }
    }

}

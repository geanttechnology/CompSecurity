// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.params.b;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.c;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.h;
import java.util.HashSet;

abstract class GuestDataSource extends c
{
    private static class GuestLocal
        implements Parcelable, GuestBase
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public GuestLocal a(Parcel parcel)
            {
                return new GuestLocal(parcel);
            }

            public GuestLocal[] a(int i)
            {
                return new GuestLocal[i];
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
        private String mGuestId;
        private boolean mIsAnonymous;

        public int describeContents()
        {
            return 0;
        }

        public String getGuestId()
        {
            return mGuestId;
        }

        public boolean isAnonymous()
        {
            return mIsAnonymous;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            byte byte0;
            if (mIsAnonymous)
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            parcel.writeByte(byte0);
            parcel.writeString(mGuestId);
        }


        public GuestLocal()
        {
            mIsAnonymous = true;
            mGuestId = "none";
        }

        private GuestLocal(Parcel parcel)
        {
            boolean flag;
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mIsAnonymous = flag;
            mGuestId = parcel.readString();
        }

    }


    protected static HashSet sGuestChangeListeners = new HashSet();

    GuestDataSource()
    {
    }

    public static void a(b.a a1)
    {
        if (a1 == null)
        {
            throw new IllegalStateException("GuestChangeListener can't be null");
        } else
        {
            sGuestChangeListeners.add(a1);
            return;
        }
    }

    public static GuestBase c()
    {
        return new GuestLocal();
    }

    public abstract void a(Guest guest, int i, d d);

    public abstract void a(Guest guest, AddressParams addressparams, boolean flag, d d);

    public abstract void a(Guest guest, b b1, d d);

    public abstract void a(Guest guest, PaymentTender paymenttender, d d);

    public abstract void a(Guest guest, PaymentTender paymenttender, boolean flag, AddressParams addressparams, d d);

    public abstract void a(Guest guest, GuestAddress guestaddress, AddressParams addressparams, boolean flag, d d);

    public abstract void a(Guest guest, GuestAddress guestaddress, d d);

    public abstract void a(Guest guest, d d);

    public abstract void a(Guest guest, h h);

    public abstract void a(Guest guest, String s, d d);

    public abstract void a(Guest guest, String s, String s1, d d);

    public abstract void a(h h);

    public abstract void a(String s, h h);

    public abstract void a(String s, String s1, d d);

    public abstract void a(String s, String s1, String s2, String s3, String s4, String s5, boolean flag, 
            d d);

    public abstract void b(Guest guest, d d);

    public abstract void b(Guest guest, h h);

    public abstract void b(h h);

    public abstract void c(Guest guest, d d);

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.store.interfaces.StoreOperatingHours;
import com.target.mothership.util.TimeOfDay;

public class DisplayStoreOperatingHours
    implements StoreOperatingHours
{

    private final TimeOfDay mBeginTime;
    private final TimeOfDay mEndTime;
    private final boolean mIsClosed;
    private final boolean mIsOpen24Hours;
    private final String mName;
    private final String mShortName;

    public DisplayStoreOperatingHours(StoreOperatingHours storeoperatinghours)
    {
        this(storeoperatinghours, storeoperatinghours.a().replace(".", ""), storeoperatinghours.b().replace(".", ""));
    }

    public DisplayStoreOperatingHours(StoreOperatingHours storeoperatinghours, String s, String s1)
    {
        Object obj = null;
        super();
        mName = s;
        mShortName = s1;
        mIsOpen24Hours = storeoperatinghours.c();
        mIsClosed = storeoperatinghours.d();
        if (storeoperatinghours.e().b())
        {
            s = new TimeOfDay((TimeOfDay)storeoperatinghours.e().c());
        } else
        {
            s = null;
        }
        mBeginTime = s;
        s = obj;
        if (storeoperatinghours.f().b())
        {
            s = new TimeOfDay((TimeOfDay)storeoperatinghours.f().c());
        }
        mEndTime = s;
    }

    public String a()
    {
        return mName;
    }

    public String b()
    {
        return mShortName;
    }

    public boolean c()
    {
        return mIsOpen24Hours;
    }

    public boolean d()
    {
        return mIsClosed;
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return com.google.a.a.e.c(mBeginTime);
    }

    public e f()
    {
        return com.google.a.a.e.c(mEndTime);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }
}

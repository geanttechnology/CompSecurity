// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.h.b;

import java.util.ArrayList;

// Referenced classes of package com.target.mothership.services.e.h.b:
//            a

public class h
{

    private a mAddress;
    private ArrayList mAlternateHours;
    private ArrayList mCapabilities;
    private ArrayList mHours;
    private String mName;
    private ArrayList mPhoneNumbers;
    private String mStoreId;
    private String mSubTypeDescription;

    public h()
    {
        mPhoneNumbers = new ArrayList();
        mHours = new ArrayList();
        mAlternateHours = new ArrayList();
        mCapabilities = new ArrayList();
    }

    public String a()
    {
        return mStoreId;
    }

    public String b()
    {
        return mName;
    }

    public a c()
    {
        return mAddress;
    }

    public ArrayList d()
    {
        return mPhoneNumbers;
    }

    public ArrayList e()
    {
        return mHours;
    }

    public ArrayList f()
    {
        return mAlternateHours;
    }

    public ArrayList g()
    {
        return mCapabilities;
    }

    public String h()
    {
        return mSubTypeDescription;
    }
}

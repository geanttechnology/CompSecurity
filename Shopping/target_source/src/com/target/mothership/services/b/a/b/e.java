// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.b.a.b;

import com.target.mothership.services.ab;
import com.target.mothership.services.d;
import java.util.List;

public class e
    implements d
{

    private List mAssignedOffers;
    private boolean mIsValid;
    private String mStatusCode;
    private ab mXmlFailure;

    public e()
    {
    }

    public void a(ab ab)
    {
        mXmlFailure = ab;
    }

    public void a(String s)
    {
        mStatusCode = s;
    }

    public void a(List list)
    {
        mAssignedOffers = list;
    }

    public void a(boolean flag)
    {
        mIsValid = flag;
    }

    public boolean a()
    {
        return mIsValid;
    }

    public String b()
    {
        return mStatusCode;
    }

    public List c()
    {
        return mAssignedOffers;
    }
}

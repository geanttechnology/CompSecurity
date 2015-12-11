// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.b.a.b;

import com.target.mothership.services.ab;
import com.target.mothership.services.d;
import java.util.ArrayList;
import java.util.List;

public class f
    implements d
{

    private List mAvailableOffers;
    private boolean mIsValid;
    private String mStatusCode;
    private ab mXmlFailure;

    public f()
    {
        mAvailableOffers = new ArrayList();
    }

    public List a()
    {
        return mAvailableOffers;
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
        mAvailableOffers = list;
    }

    public void a(boolean flag)
    {
        mIsValid = flag;
    }
}

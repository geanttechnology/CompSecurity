// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.ir;


// Referenced classes of package com.amazon.communication.ir:
//            IrMaster

public class IrMasterImpl
    implements IrMaster
{

    private final String mDomain;
    private final String mRealm;

    public IrMasterImpl(String s, String s1)
    {
        if (s == null || s.trim().length() == 0)
        {
            throw new IllegalArgumentException("domain is NULL or empty");
        }
        if (s1 == null || s1.trim().length() == 0)
        {
            throw new IllegalArgumentException("realm is NULL or empty");
        } else
        {
            mDomain = s;
            mRealm = s1;
            return;
        }
    }

    public String getDomain()
    {
        return mDomain;
    }

    public String getRealm()
    {
        return mRealm;
    }
}

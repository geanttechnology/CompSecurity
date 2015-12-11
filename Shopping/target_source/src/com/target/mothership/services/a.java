// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;


// Referenced classes of package com.target.mothership.services:
//            q, w, aa

public abstract class a
    implements q
{

    private final w mTGTListener;
    private final aa mTransformer;

    public a(w w1, aa aa)
    {
        if (w1 == null)
        {
            throw new IllegalArgumentException("TGTResponseListener may not be null");
        } else
        {
            mTransformer = aa;
            mTGTListener = w1;
            return;
        }
    }

    public w a()
    {
        return mTGTListener;
    }

    public aa b()
    {
        return mTransformer;
    }

    public String c()
    {
        return mTGTListener.getTag();
    }
}

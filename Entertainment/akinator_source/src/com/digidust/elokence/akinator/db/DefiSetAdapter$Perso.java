// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.db;


// Referenced classes of package com.digidust.elokence.akinator.db:
//            DefiSetAdapter

public static class misFound
{

    protected int mBaseId;
    protected String mDescription;
    protected String mName;
    protected String mPhotoBase64;
    protected float mPourcentage;
    protected boolean misFound;

    public int getBaseId()
    {
        return mBaseId;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public String getName()
    {
        return mName;
    }

    public String getPhotoBase64()
    {
        return mPhotoBase64;
    }

    public float getPourcentage()
    {
        return mPourcentage;
    }

    public boolean isFound()
    {
        return misFound;
    }

    public (int i, String s, String s1, String s2, float f, boolean flag)
    {
        mBaseId = i;
        mName = s;
        mDescription = s1;
        mPhotoBase64 = s2;
        mPourcentage = f;
        misFound = flag;
    }
}

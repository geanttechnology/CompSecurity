// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import java.io.Serializable;

// Referenced classes of package com.elokence.limuleapi:
//            Session

public static class mDescription
    implements Serializable
{

    private String mDescription;
    private int mId_base;
    private String mName;

    public String getDescription()
    {
        return mDescription;
    }

    public int getIdBase()
    {
        return mId_base;
    }

    public String getName()
    {
        return mName;
    }

    public void setDescription(String s)
    {
        mDescription = s;
    }

    public void setIdBase(int i)
    {
        mId_base = i;
    }

    public void setName(String s)
    {
        mName = s;
    }

    public ()
    {
    }

    public (int i, String s, String s1)
    {
        mId_base = i;
        mName = s;
        mDescription = s1;
    }
}

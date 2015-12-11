// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import java.io.Serializable;

// Referenced classes of package com.elokence.limuleapi:
//            Session

public static class mValue
    implements Serializable
{

    private int mIndex;
    private String mValue;

    public int getIndex()
    {
        return mIndex;
    }

    public String getValue()
    {
        return mValue;
    }

    public ()
    {
    }

    public (int i, String s)
    {
        mIndex = i;
        mValue = s;
    }
}

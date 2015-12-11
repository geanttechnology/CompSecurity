// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Callable;

public abstract class dau
    implements Callable
{

    private String mName;
    private final String mParentName;
    private final int mPermissions;
    private final String mTaskName;

    public transient dau(String s, String s1, int ai[])
    {
        mParentName = s;
        mTaskName = s1;
        mPermissions = dbf.a(ai);
    }

    public transient dau(String s, int ai[])
    {
        this(null, s, ai);
    }

    public transient dau(int ai[])
    {
        this(null, null, ai);
    }

    public int getPermissions()
    {
        return mPermissions;
    }

    public String toString()
    {
        if (mName == null)
        {
            mName = dbf.a(this, mParentName, mTaskName);
        }
        return mName;
    }
}

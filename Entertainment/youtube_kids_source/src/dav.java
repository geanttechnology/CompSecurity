// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class dav
    implements Runnable
{

    private String mName;
    private final String mParentName;
    private final int mPermissions;
    private final String mTaskName;

    public transient dav(String s, String s1, int ai[])
    {
        mParentName = s;
        mTaskName = s1;
        mPermissions = dbf.a(ai);
    }

    public transient dav(String s, int ai[])
    {
        this(null, s, ai);
    }

    public transient dav(int ai[])
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

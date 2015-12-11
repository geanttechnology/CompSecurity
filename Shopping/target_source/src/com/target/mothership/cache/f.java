// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import android.database.sqlite.SQLiteDatabase;

public abstract class f
{

    private int mVersion;

    public f(int i)
    {
        mVersion = i;
    }

    public abstract void apply(SQLiteDatabase sqlitedatabase);

    public int getVersion()
    {
        return mVersion;
    }

    public abstract void revert(SQLiteDatabase sqlitedatabase);
}

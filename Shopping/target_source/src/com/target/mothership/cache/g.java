// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

// Referenced classes of package com.target.mothership.cache:
//            f

public class g
{

    private SparseArray mMigrations;

    public g()
    {
        mMigrations = new SparseArray();
    }

    public void add(f f1)
    {
        mMigrations.put(f1.getVersion(), f1);
    }

    public void apply(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (i > j)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Database migration: can't upgrade from version ").append(i).append(" to version ").append(j).toString());
        }
        for (i++; i <= j; i++)
        {
            f f1 = (f)mMigrations.get(i);
            if (f1 != null)
            {
                f1.apply(sqlitedatabase);
            }
        }

    }

    public void revert(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        int k = i;
        if (j > i)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Database migration: can't downgrade from version ").append(i).append(" to version ").append(j).toString());
        }
        for (; k > j; k--)
        {
            f f1 = (f)mMigrations.get(k);
            if (f1 != null)
            {
                f1.revert(sqlitedatabase);
            }
        }

    }
}

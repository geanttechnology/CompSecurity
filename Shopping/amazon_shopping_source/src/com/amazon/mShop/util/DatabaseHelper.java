// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.amazon.mShop.net.ErrorExceptionMetricsObserver;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.mShop.util:
//            DBException

public abstract class DatabaseHelper extends SQLiteOpenHelper
{

    protected final Context mContext;
    protected Executor mExecutor;

    protected DatabaseHelper(Context context, String s, int i)
    {
        super(context, s, null, i);
        mExecutor = Executors.newSingleThreadExecutor();
        mContext = context;
    }

    public SQLiteDatabase getWritableDatabase()
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = super.getWritableDatabase();
        this;
        JVM INSTR monitorexit ;
        return sqlitedatabase;
        Object obj;
        obj;
        ErrorExceptionMetricsObserver.logMetric(((Exception) (obj)));
        throw new DBException("Cannot open database");
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }
}

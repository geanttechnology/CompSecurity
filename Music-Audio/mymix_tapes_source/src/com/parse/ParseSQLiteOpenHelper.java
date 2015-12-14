// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase

abstract class ParseSQLiteOpenHelper
{

    private final SQLiteOpenHelper helper;

    public ParseSQLiteOpenHelper(Context context, String s, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, int i)
    {
        this(context, s, cursorfactory, i, null);
    }

    public ParseSQLiteOpenHelper(Context context, String s, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, int i, DatabaseErrorHandler databaseerrorhandler)
    {
        helper = new SQLiteOpenHelper(context, s, cursorfactory, i) {

            final ParseSQLiteOpenHelper this$0;

            public void onConfigure(SQLiteDatabase sqlitedatabase)
            {
                super.onConfigure(sqlitedatabase);
                ParseSQLiteOpenHelper.this.onConfigure(sqlitedatabase);
            }

            public void onCreate(SQLiteDatabase sqlitedatabase)
            {
                ParseSQLiteOpenHelper.this.onCreate(sqlitedatabase);
            }

            public void onDowngrade(SQLiteDatabase sqlitedatabase, int j, int k)
            {
                super.onDowngrade(sqlitedatabase, j, k);
                ParseSQLiteOpenHelper.this.onDowngrade(sqlitedatabase);
            }

            public void onOpen(SQLiteDatabase sqlitedatabase)
            {
                super.onOpen(sqlitedatabase);
                ParseSQLiteOpenHelper.this.onOpen(sqlitedatabase);
            }

            public void onUpgrade(SQLiteDatabase sqlitedatabase, int j, int k)
            {
                ParseSQLiteOpenHelper.this.onUpgrade(sqlitedatabase, j, k);
            }

            
            {
                this$0 = ParseSQLiteOpenHelper.this;
                super(context, s, cursorfactory, i);
            }
        };
    }

    private Task getDatabaseAsync(boolean flag)
    {
        final ParseSQLiteDatabase db = new ParseSQLiteDatabase(flag);
        return Task.forResult(null).continueWithTask(new Continuation() {

            final ParseSQLiteOpenHelper this$0;
            final ParseSQLiteDatabase val$db;

            public Task then(Task task)
                throws Exception
            {
                return db.open(helper);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseSQLiteOpenHelper.this;
                db = parsesqlitedatabase;
                super();
            }
        }).continueWithTask(new Continuation() {

            final ParseSQLiteOpenHelper this$0;
            final ParseSQLiteDatabase val$db;

            public Task then(Task task)
                throws Exception
            {
                return Task.forResult(db);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseSQLiteOpenHelper.this;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    public String getDatabaseName()
    {
        return helper.getDatabaseName();
    }

    public Task getReadableDatabaseAsync()
    {
        return getDatabaseAsync(false);
    }

    public Task getWritableDatabaseAsync()
    {
        return getDatabaseAsync(true);
    }

    public void onConfigure(SQLiteDatabase sqlitedatabase)
    {
    }

    public abstract void onCreate(SQLiteDatabase sqlitedatabase);

    public void onDowngrade(SQLiteDatabase sqlitedatabase)
    {
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
    }

    public abstract void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j);

}

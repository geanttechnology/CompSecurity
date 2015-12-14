// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.ULogUtility;

public class b extends SQLiteOpenHelper
{

    public b(Context context, DatabaseErrorHandler databaseerrorhandler)
    {
        super(context, "u.sqlite", null, 1, databaseerrorhandler);
    }

    private void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE CLGroup (_id INTEGER,GroupId INTEGER PRIMARY KEY,GroupType TEXT,DisplayName TEXT,Jid TEXT,Avatar TEXT,LastModified INTEGER,NumberOfMember INTEGER,LastRead INTEGER,isDisabled INTEGER,isNotificationDisabled INTEGER,LastDeleteChatTime INTEGER,DraftText TEXT,LastMsg TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE Event (_id INTEGER PRIMARY KEY,EventId TEXT,EventFrom TEXT,EventTo TEXT,EventType TEXT,EventContent TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE User (_id INTEGER,UserId INTEGER PRIMARY KEY,Jid TEXT,DisplayName TEXT,Avatar TEXT,IsBlocked INTEGER);");
        sqlitedatabase.execSQL("CREATE TABLE SendReceipt (_id INTEGER PRIMARY KEY,MessageId TEXT,ReceiptId TEXT,Status TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE RecvReceipt (MessageId TEXT,UserId TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE Message (_id INTEGER,MessageId TEXT PRIMARY KEY,GroupId TEXT,SendTime INTEGER,MessageType TEXT,MessageContent TEXT,ReadCount INTEGER,UserId TEXT,Status TEXT,MemberStatus TEXT,IsNewVersion INTEGER,SrcXml TEXT,UploadStatus TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE GroupMember (_id INTEGER PRIMARY KEY,GroupId INTEGER,UserId INTEGER);");
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.beginTransaction();
        ULogUtility.e("Create", sqlitedatabase.getPath());
        Log.i("DatabaseOpenHelper", "creating schema");
        a(sqlitedatabase);
        sqlitedatabase.setTransactionSuccessful();
        ULogUtility.e("Create", (new StringBuilder()).append("Success ").append(sqlitedatabase.getPath()).toString());
        Log.i("DatabaseOpenHelper", "end transaction");
        sqlitedatabase.endTransaction();
        return;
        Object obj;
        obj;
        ULogUtility.a("DatabaseOpenHelper", "onCreate ", ((Exception) (obj)));
        Log.i("DatabaseOpenHelper", "end transaction");
        sqlitedatabase.endTransaction();
        return;
        obj;
        Log.i("DatabaseOpenHelper", "end transaction");
        sqlitedatabase.endTransaction();
        throw obj;
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        long l = System.currentTimeMillis();
        for (int k = i - 1; k >= j; k--)
        {
            Log.w("DatabaseOpenHelper", (new StringBuilder()).append("Downgrading database from version ").append(i).append(" to ").append(k).toString());
            ULogUtility.e("Downgrade", (new StringBuilder()).append(i).append(" to ").append(k).toString());
        }

        long l1 = System.currentTimeMillis();
        Log.e("DatabaseOpenHelper", (new StringBuilder()).append("Downgrading done ").append(String.valueOf(l1 - l)).append(" ms").toString());
        ULogUtility.e("Downgrade", (new StringBuilder()).append("done ").append(String.valueOf(l1 - l)).append(" ms").toString());
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        Log.i("DatabaseOpenHelper", "Open database");
        super.onOpen(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        long l = System.currentTimeMillis();
        for (int k = i + 1; k <= j; k++)
        {
            Log.w("DatabaseOpenHelper", (new StringBuilder()).append("Upgrading database from version ").append(i).append(" to ").append(k).toString());
            sqlitedatabase = (new StringBuilder()).append(i).append("(").append(g.a().H()).append(")").append(" to ").append(k).append("(");
            g.a();
            ULogUtility.e("Upgrade", sqlitedatabase.append(g.p()).append(")").toString());
        }

        long l1 = System.currentTimeMillis();
        Log.e("DatabaseOpenHelper", (new StringBuilder()).append("Upgrading done ").append(String.valueOf(l1 - l)).append(" ms").toString());
        ULogUtility.e("Upgrade", (new StringBuilder()).append("done ").append(String.valueOf(l1 - l)).append(" ms").toString());
    }
}

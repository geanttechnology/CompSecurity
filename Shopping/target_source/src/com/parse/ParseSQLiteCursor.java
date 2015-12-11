// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

class ParseSQLiteCursor
    implements Cursor
{

    private Cursor cursor;
    private Executor executor;

    private ParseSQLiteCursor(Cursor cursor1, Executor executor1)
    {
        cursor = cursor1;
        executor = executor1;
    }

    public static Cursor create(Cursor cursor1, Executor executor1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return cursor1;
        } else
        {
            return new ParseSQLiteCursor(cursor1, executor1);
        }
    }

    public void close()
    {
        j.a(new Callable() {

            final ParseSQLiteCursor this$0;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                cursor.close();
                return null;
            }

            
            {
                this$0 = ParseSQLiteCursor.this;
                super();
            }
        }, executor);
    }

    public void copyStringToBuffer(int i, CharArrayBuffer chararraybuffer)
    {
        cursor.copyStringToBuffer(i, chararraybuffer);
    }

    public void deactivate()
    {
        cursor.deactivate();
    }

    public byte[] getBlob(int i)
    {
        return cursor.getBlob(i);
    }

    public int getColumnCount()
    {
        return cursor.getColumnCount();
    }

    public int getColumnIndex(String s)
    {
        return cursor.getColumnIndex(s);
    }

    public int getColumnIndexOrThrow(String s)
        throws IllegalArgumentException
    {
        return cursor.getColumnIndexOrThrow(s);
    }

    public String getColumnName(int i)
    {
        return cursor.getColumnName(i);
    }

    public String[] getColumnNames()
    {
        return cursor.getColumnNames();
    }

    public int getCount()
    {
        return cursor.getCount();
    }

    public double getDouble(int i)
    {
        return cursor.getDouble(i);
    }

    public Bundle getExtras()
    {
        return cursor.getExtras();
    }

    public float getFloat(int i)
    {
        return cursor.getFloat(i);
    }

    public int getInt(int i)
    {
        return cursor.getInt(i);
    }

    public long getLong(int i)
    {
        return cursor.getLong(i);
    }

    public Uri getNotificationUri()
    {
        return cursor.getNotificationUri();
    }

    public int getPosition()
    {
        return cursor.getPosition();
    }

    public short getShort(int i)
    {
        return cursor.getShort(i);
    }

    public String getString(int i)
    {
        return cursor.getString(i);
    }

    public int getType(int i)
    {
        return cursor.getType(i);
    }

    public boolean getWantsAllOnMoveCalls()
    {
        return cursor.getWantsAllOnMoveCalls();
    }

    public boolean isAfterLast()
    {
        return cursor.isAfterLast();
    }

    public boolean isBeforeFirst()
    {
        return cursor.isBeforeFirst();
    }

    public boolean isClosed()
    {
        return cursor.isClosed();
    }

    public boolean isFirst()
    {
        return cursor.isFirst();
    }

    public boolean isLast()
    {
        return cursor.isLast();
    }

    public boolean isNull(int i)
    {
        return cursor.isNull(i);
    }

    public boolean move(int i)
    {
        return cursor.move(i);
    }

    public boolean moveToFirst()
    {
        return cursor.moveToFirst();
    }

    public boolean moveToLast()
    {
        return cursor.moveToLast();
    }

    public boolean moveToNext()
    {
        return cursor.moveToNext();
    }

    public boolean moveToPosition(int i)
    {
        return cursor.moveToPosition(i);
    }

    public boolean moveToPrevious()
    {
        return cursor.moveToPrevious();
    }

    public void registerContentObserver(ContentObserver contentobserver)
    {
        cursor.registerContentObserver(contentobserver);
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        cursor.registerDataSetObserver(datasetobserver);
    }

    public boolean requery()
    {
        return cursor.requery();
    }

    public Bundle respond(Bundle bundle)
    {
        return cursor.respond(bundle);
    }

    public void setNotificationUri(ContentResolver contentresolver, Uri uri)
    {
        cursor.setNotificationUri(contentresolver, uri);
    }

    public void unregisterContentObserver(ContentObserver contentobserver)
    {
        cursor.unregisterContentObserver(contentobserver);
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        cursor.unregisterDataSetObserver(datasetobserver);
    }

}

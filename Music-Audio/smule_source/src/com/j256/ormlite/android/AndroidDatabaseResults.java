// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.android;

import android.database.Cursor;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.support.DatabaseResults;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AndroidDatabaseResults
    implements DatabaseResults
{

    private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
    private final Cursor cursor;
    private boolean firstCall;
    private final ObjectCache objectCache;

    public AndroidDatabaseResults(Cursor cursor1, ObjectCache objectcache)
    {
        cursor = cursor1;
        firstCall = true;
        objectCache = objectcache;
    }

    public int findColumn(String s)
    {
        int j = cursor.getColumnIndex(s);
        int i = j;
        if (j < 0)
        {
            StringBuilder stringbuilder = new StringBuilder(s.length() + 4);
            databaseType.appendEscapedEntityName(stringbuilder, s);
            int k = cursor.getColumnIndex(stringbuilder.toString());
            i = k;
            if (k < 0)
            {
                throw new SQLException((new StringBuilder()).append("Unknown field '").append(s).append("' from the Android sqlite cursor").toString());
            }
        }
        return i;
    }

    public InputStream getBlobStream(int i)
    {
        return new ByteArrayInputStream(cursor.getBlob(i));
    }

    public boolean getBoolean(int i)
    {
        return !cursor.isNull(i) && cursor.getShort(i) != 0;
    }

    public byte getByte(int i)
    {
        return (byte)getShort(i);
    }

    public byte[] getBytes(int i)
    {
        return cursor.getBlob(i);
    }

    public char getChar(int i)
    {
        String s = cursor.getString(i);
        if (s == null || s.length() == 0)
        {
            return '\0';
        }
        if (s.length() == 1)
        {
            return s.charAt(0);
        } else
        {
            throw new SQLException((new StringBuilder()).append("More than 1 character stored in database column: ").append(i).toString());
        }
    }

    public int getColumnCount()
    {
        return cursor.getColumnCount();
    }

    public double getDouble(int i)
    {
        return cursor.getDouble(i);
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

    public ObjectCache getObjectCache()
    {
        return objectCache;
    }

    public Cursor getRawCursor()
    {
        return cursor;
    }

    public short getShort(int i)
    {
        return cursor.getShort(i);
    }

    public String getString(int i)
    {
        return cursor.getString(i);
    }

    public Timestamp getTimestamp(int i)
    {
        throw new SQLException("Android does not support timestamp.  Use JAVA_DATE_LONG or JAVA_DATE_STRING types");
    }

    public boolean next()
    {
        if (firstCall)
        {
            boolean flag = cursor.moveToFirst();
            firstCall = false;
            return flag;
        } else
        {
            return cursor.moveToNext();
        }
    }

    public boolean wasNull(int i)
    {
        return cursor.isNull(i);
    }

}

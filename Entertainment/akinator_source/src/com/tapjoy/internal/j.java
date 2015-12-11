// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

// Referenced classes of package com.tapjoy.internal:
//            az, bd, bk, de, 
//            cv

public final class j extends az
    implements bd, Closeable
{

    private SQLiteDatabase a;
    private final bk b;
    private int c;

    public j(File file, bk bk1)
    {
        a = SQLiteDatabase.openOrCreateDatabase(file, null);
        b = bk1;
        if (a.getVersion() == 1)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        a.beginTransaction();
        a.execSQL("CREATE TABLE IF NOT EXISTS List(value BLOB)");
        a.setVersion(1);
        a.setTransactionSuccessful();
        a.endTransaction();
        c = a();
        return;
        file;
        a.endTransaction();
        throw file;
    }

    private int a()
    {
        Cursor cursor = null;
        Cursor cursor1 = a.rawQuery("SELECT COUNT(1) FROM List", null);
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break MISSING_BLOCK_LABEL_41;
        }
        cursor = cursor1;
        int i = cursor1.getInt(0);
        a(cursor1);
        return i;
        a(cursor1);
        return 0;
        Exception exception;
        exception;
        a(cursor);
        throw exception;
    }

    private static Cursor a(Cursor cursor)
    {
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
    }

    public final Object a(int i)
    {
        Object obj;
        obj = null;
        if (i < 0 || i >= c)
        {
            throw new IndexOutOfBoundsException();
        }
        Object obj1 = a.rawQuery((new StringBuilder("SELECT value FROM List ORDER BY rowid LIMIT ")).append(i).append(",1").toString(), null);
        obj = obj1;
        if (!((Cursor) (obj1)).moveToNext())
        {
            break MISSING_BLOCK_LABEL_141;
        }
        obj = obj1;
        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(((Cursor) (obj1)).getBlob(0));
        Object obj2 = b.b(bytearrayinputstream);
        obj = obj1;
        de.a(bytearrayinputstream);
        a(((Cursor) (obj1)));
        return obj2;
        obj;
        throw new IllegalStateException(((Throwable) (obj)));
        Exception exception;
        exception;
        obj = obj1;
        de.a(bytearrayinputstream);
        obj = obj1;
        throw exception;
        obj1;
        a(((Cursor) (obj)));
        throw obj1;
        obj = obj1;
        throw new NoSuchElementException();
    }

    public final void b(int i)
    {
        Object obj1;
        obj1 = null;
        if (i <= 0 || i > c)
        {
            throw new IndexOutOfBoundsException();
        }
        if (i == c)
        {
            clear();
            return;
        }
        Object obj = a.rawQuery((new StringBuilder("SELECT rowid FROM List ORDER BY rowid LIMIT ")).append(i - 1).append(",1").toString(), null);
        if (!((Cursor) (obj)).moveToNext()) goto _L2; else goto _L1
_L1:
        long l;
        l = ((Cursor) (obj)).getLong(0);
        ((Cursor) (obj)).close();
        int k;
        k = a.delete("List", (new StringBuilder("rowid <= ")).append(l).toString(), null);
        c = c - k;
        if (k == i) goto _L4; else goto _L3
_L3:
        throw new IllegalStateException((new StringBuilder("Try to delete ")).append(i).append(", but deleted ").append(k).toString());
        obj;
_L5:
        a(((Cursor) (obj1)));
        throw obj;
_L2:
        throw new IllegalStateException();
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
        if (true) goto _L5; else goto _L4
_L4:
        a(((Cursor) (null)));
        return;
    }

    public final void clear()
    {
        a.delete("List", "1", null);
        c = 0;
    }

    public final void close()
    {
        if (a != null)
        {
            a.close();
            a = null;
        }
    }

    protected final void finalize()
    {
        close();
        super.finalize();
    }

    public final boolean offer(Object obj)
    {
        Object obj1;
        cv.a(obj);
        obj1 = new ByteArrayOutputStream();
        b.a(((java.io.OutputStream) (obj1)), obj);
        obj = ((ByteArrayOutputStream) (obj1)).toByteArray();
        de.a(((Closeable) (obj1)));
        obj1 = new ContentValues();
        ((ContentValues) (obj1)).put("value", ((byte []) (obj)));
        if (a.insert("List", null, ((ContentValues) (obj1))) == -1L)
        {
            return false;
        } else
        {
            c = c + 1;
            return true;
        }
        obj;
        throw new IllegalArgumentException(((Throwable) (obj)));
        obj;
        de.a(((Closeable) (obj1)));
        throw obj;
    }

    public final Object peek()
    {
        if (c > 0)
        {
            return a(0);
        } else
        {
            return null;
        }
    }

    public final Object poll()
    {
        if (c > 0)
        {
            Object obj = peek();
            b(1);
            return obj;
        } else
        {
            return null;
        }
    }

    public final int size()
    {
        return c;
    }
}

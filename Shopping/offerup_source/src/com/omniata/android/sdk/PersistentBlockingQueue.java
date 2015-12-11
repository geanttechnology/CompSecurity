// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.omniata.android.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.lang.reflect.Constructor;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.omniata.android.sdk:
//            OmniataDBHelper, OmniataLog

class PersistentBlockingQueue extends AbstractQueue
    implements BlockingQueue
{

    private static final String TAG = "PersistentBlockingQueue";
    private Context context;
    private SQLiteOpenHelper helper;
    private String name;
    private int size;
    private Class type;

    public PersistentBlockingQueue(Context context1, String s, Class class1)
    {
        name = s;
        type = class1;
        context = context1;
        size = -1;
        helper = new OmniataDBHelper(context, s);
        size = OmniataDBHelper.size(getDB(), s);
    }

    private Object instantiateE(Cursor cursor)
    {
        return instantiateE(cursor.getString(1));
    }

    private Object instantiateE(String s)
    {
        try
        {
            s = ((String) (type.getConstructor(new Class[] {
                java/lang/String
            }).newInstance(new Object[] {
                s
            })));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public Object blockingPeek()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = peek();
_L1:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        OmniataLog.d("PersistentBlockingQueue", "Queue Empty");
        wait();
        obj = peek();
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clear()
    {
        this;
        JVM INSTR monitorenter ;
        OmniataDBHelper.deleteAll(getDB(), name);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int drainTo(Collection collection)
    {
        this;
        JVM INSTR monitorenter ;
        Cursor cursor;
        cursor = OmniataDBHelper.all(getDB(), name);
        cursor.moveToFirst();
        int i = 0;
_L1:
        if (i >= cursor.getCount())
        {
            break MISSING_BLOCK_LABEL_64;
        }
        collection.add(instantiateE(cursor));
        i++;
        cursor.moveToNext();
          goto _L1
        collection;
        this;
        JVM INSTR monitorexit ;
        throw collection;
        cursor.close();
        this;
        JVM INSTR monitorexit ;
        return 0;
    }

    public int drainTo(Collection collection, int i)
    {
        return 0;
    }

    protected SQLiteDatabase getDB()
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = helper.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            return null;
        }
        return sqlitedatabase;
    }

    public Iterator iterator()
    {
        return null;
    }

    public boolean offer(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        obj = obj.toString();
        l = OmniataDBHelper.insert(getDB(), name, ((String) (obj)));
        if (l == -1L)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        size = size + 1;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return l != -1L;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public boolean offer(Object obj, long l, TimeUnit timeunit)
    {
        return offer(obj);
    }

    public Object peek()
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        Cursor cursor = OmniataDBHelper.first(getDB(), name);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_61;
        }
        obj = instantiateE(cursor);
_L3:
        cursor.close();
_L2:
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        cursor.close();
        this;
        JVM INSTR monitorexit ;
        return null;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj = null;
          goto _L3
    }

    public Object poll()
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        Cursor cursor = OmniataDBHelper.first(getDB(), name);
        Object obj = obj1;
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
        int i;
        i = cursor.getInt(0);
        obj = cursor.getString(1);
        cursor.close();
        OmniataDBHelper.delete(getDB(), name, i);
        i = size - 1;
        size = i;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        OmniataDBHelper.resetAutoIncrement(getDB(), name);
        obj = instantiateE(((String) (obj)));
_L2:
        this;
        JVM INSTR monitorexit ;
        return obj;
_L4:
        cursor.close();
        obj = obj1;
          goto _L2
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object poll(long l, TimeUnit timeunit)
    {
        return poll();
    }

    public void put(Object obj)
    {
        offer(obj);
    }

    public int remainingCapacity()
    {
        return 0x7fffffff;
    }

    public int size()
    {
        this;
        JVM INSTR monitorenter ;
        int i = size;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object take()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = poll();
_L1:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        OmniataLog.d("PersistentBlockingQueue", "Queue Empty");
        wait();
        obj = poll();
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

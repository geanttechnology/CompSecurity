// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.util.Locale;

public abstract class bjb
{

    final biz a;
    final String b;

    public bjb(biz biz1, String s)
    {
        a = (biz)b.a(biz1);
        b = (String)b.a(s);
    }

    public int a(String s)
    {
        b.b();
        return a.getWritableDatabase().delete(b, "key = ?", new String[] {
            s
        });
    }

    public abstract Object a(byte abyte0[]);

    public void a()
    {
        b.b();
        a.getWritableDatabase().beginTransaction();
    }

    public void a(String s, Object obj)
    {
        ContentValues contentvalues;
        b.b();
        a();
        contentvalues = new ContentValues();
        contentvalues.put("key", s);
        contentvalues.put("value", a(obj));
        contentvalues.put("sortingValue", Long.valueOf(b(obj)));
        if (b(s) != null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        a.getWritableDatabase().insert(b, null, contentvalues);
_L1:
        c();
        b();
        return;
        a.getWritableDatabase().update(b, contentvalues, "key = ?", new String[] {
            s
        });
          goto _L1
        s;
        b();
        throw s;
    }

    public abstract byte[] a(Object obj);

    public abstract long b(Object obj);

    public Object b(String s)
    {
        Object obj = null;
        b.b();
        Cursor cursor = a.getReadableDatabase().query(b, new String[] {
            "value"
        }, "key=?", new String[] {
            s
        }, null, null, null, null);
        s = obj;
        if (cursor.moveToNext())
        {
            s = ((String) (a(cursor.getBlob(0))));
            cursor.close();
        }
        return s;
    }

    public void b()
    {
        b.b();
        a.getWritableDatabase().endTransaction();
    }

    public void c()
    {
        b.b();
        a.getWritableDatabase().setTransactionSuccessful();
    }

    public bjc d()
    {
        b.b();
        Cursor cursor = a.getReadableDatabase().query(b, new String[] {
            "value"
        }, null, null, null, null, "sortingValue ASC, insertionOrder ASC");
        try
        {
            cursor.getCount();
        }
        catch (SQLException sqlexception)
        {
            String s = "";
            Object obj = "";
            if (a instanceof biv)
            {
                obj = (biv)a;
                s = ((biv) (obj)).getDatabaseName();
                obj = ((biv) (obj)).a.getDatabasePath(((biv) (obj)).getDatabaseName());
                if (obj == null)
                {
                    obj = " is null";
                } else
                if (!((File) (obj)).exists())
                {
                    obj = String.format("%s doesn't exist", new Object[] {
                        ((File) (obj)).getAbsolutePath()
                    });
                } else
                if (!((File) (obj)).canRead())
                {
                    obj = String.format("%s is not readable", new Object[] {
                        ((File) (obj)).getAbsolutePath()
                    });
                } else
                {
                    obj = String.format("%s is readable", new Object[] {
                        ((File) (obj)).getAbsolutePath()
                    });
                }
            }
            throw new l(String.format(Locale.US, "%s trying to access db %s: %s", new Object[] {
                sqlexception.toString(), s, obj
            }));
        }
        return new biw(this, cursor);
    }
}

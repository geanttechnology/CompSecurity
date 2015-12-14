// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.database.more.f;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.a:
//            b

public class c
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public c()
    {
    }

    public b a(long l, long l1)
    {
        Object obj1;
        String as[] = f.a();
        obj1 = com.cyberlink.youcammakeup.c.c;
        obj1 = a.query("FilmMetadataCache", as, "Findex=? and Cid=?", new String[] {
            String.valueOf(l), String.valueOf(l1)
        }, null, null, null, ((String) (obj1)));
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        Object obj = obj1;
        m.e("BeautyFilmMetadataDAO", "Failed to query: cursor is null");
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        obj = null;
_L4:
        return ((b) (obj));
_L2:
        obj = obj1;
        if (((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_123;
        }
        obj = obj1;
        m.b("BeautyFilmMetadataDAO", "Failure of cursor.moveToFirst().");
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        obj = obj1;
        int i = ((Cursor) (obj1)).getColumnIndex("JsonString");
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        obj = obj1;
        m.e("BeautyFilmMetadataDAO", "cursor.getColumnIndex() returned negative number");
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        obj = obj1;
        b b1 = new b(new JSONObject(((Cursor) (obj1)).getString(i)));
        obj = b1;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj1)).close();
        return b1;
        Exception exception1;
        exception1;
        obj1 = null;
_L8:
        obj = obj1;
        m.e("BeautyFilmMetadataDAO", (new StringBuilder()).append("Exception: ").append(exception1.getMessage()).toString());
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        return null;
        Exception exception;
        exception;
        obj = null;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
        exception1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public b a(long l, long l1, b b1)
    {
        b b2 = a(l, l1);
        if (b2 != null)
        {
            b1 = b2;
        } else
        {
            android.content.ContentValues contentvalues = b1.a(l, l1);
            try
            {
                l = b.insert("FilmMetadataCache", null, contentvalues);
            }
            // Misplaced declaration of an exception variable
            catch (b b1)
            {
                return null;
            }
            finally
            {
                throw b1;
            }
            if (l < 0L)
            {
                return null;
            }
        }
        return b1;
    }

    public Collection a(long l)
    {
        Cursor cursor;
        String as[] = f.a();
        cursor = a.query("FilmMetadataCache", as, "Cid=?", new String[] {
            String.valueOf(l)
        }, null, null, null, null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        Object obj = cursor;
        m.e("BeautyFilmMetadataDAO", "Failed to query: cursor is null");
        if (cursor != null)
        {
            cursor.close();
        }
        obj = null;
_L6:
        return ((Collection) (obj));
_L2:
        obj = cursor;
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        obj = cursor;
        m.b("BeautyFilmMetadataDAO", "Failure of cursor.moveToFirst().");
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        obj = cursor;
        ArrayList arraylist = new ArrayList();
        obj = cursor;
        int j = cursor.getCount();
        obj = cursor;
        cursor.moveToFirst();
        int i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = cursor;
        int k = cursor.getColumnIndex("JsonString");
        if (k >= 0)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        obj = cursor;
        m.e("BeautyFilmMetadataDAO", "cursor.getColumnIndex() returned negative number");
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        obj = cursor;
        arraylist.add(new b(new JSONObject(cursor.getString(k))));
        obj = cursor;
        cursor.moveToNext();
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        obj = arraylist;
        if (cursor == null) goto _L6; else goto _L5
_L5:
        cursor.close();
        return arraylist;
        Exception exception1;
        exception1;
        cursor = null;
_L10:
        obj = cursor;
        m.e("BeautyFilmMetadataDAO", (new StringBuilder()).append("Exception: ").append(exception1.getMessage()).toString());
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        Exception exception;
        exception;
        obj = null;
_L8:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L8; else goto _L7
_L7:
        exception1;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public boolean b(long l)
    {
        b.delete("FilmMetadataCache", "Cid=?", new String[] {
            String.valueOf(l)
        });
        return true;
    }
}

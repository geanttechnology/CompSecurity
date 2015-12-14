// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.c;

// Referenced classes of package com.cyberlink.youcammakeup.database:
//            o

public class n
{

    private static final String c[] = {
        "bucket_id"
    };
    private static final String d[] = {
        "_id"
    };
    private static final String e[] = {
        "_data", "date_modified"
    };
    private static final String f[] = {
        "_id", "_data", "date_modified"
    };
    private static final String g[] = {
        "_data"
    };
    private String a;
    private ContentResolver b;

    public n()
    {
        a = "database.FileDao";
        b = Globals.d().getContentResolver();
    }

    private Cursor a(String as[], String s)
    {
        Uri uri = android.provider.MediaStore.Files.getContentUri("external");
        return b.query(uri, e, "_id=?", as, s);
    }

    private Long a(String s, Cursor cursor)
    {
        if (cursor != null && cursor.moveToFirst())
        {
            int i = cursor.getColumnIndex("_id");
            if (i >= 0)
            {
                if (cursor.getCount() <= 1);
                return Long.valueOf(cursor.getLong(i));
            }
        }
        return null;
    }

    public Long a(long l)
    {
        Object obj;
        long l1;
        l1 = System.currentTimeMillis();
        obj = c.a;
        obj = b.query(((Uri) (obj)), c, "_id=?", new String[] {
            String.valueOf(l)
        }, null);
        l = System.currentTimeMillis();
        double d1 = (double)(l - l1) / 1000D;
        if (obj != null) goto _L2; else goto _L1
_L1:
        Long long1;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        long1 = null;
_L4:
        return long1;
_L2:
        boolean flag = ((Cursor) (obj)).moveToFirst();
        if (!flag)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return null;
        }
        int i = ((Cursor) (obj)).getColumnIndex("bucket_id");
        if (i < 0)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return null;
        }
        l = System.currentTimeMillis();
        if (((Cursor) (obj)).getCount() <= 1);
        l1 = ((Cursor) (obj)).getLong(i);
        double d2 = (double)(System.currentTimeMillis() - l) / 1000D;
        Long long2;
        long2 = Long.valueOf(l1);
        long1 = long2;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return long2;
        obj;
        obj = null;
_L8:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        Object obj1;
        obj1;
        obj = null;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw obj1;
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public Long a(Uri uri)
    {
        long l;
        l = System.currentTimeMillis();
        uri = b.query(uri, d, null, null, null);
        long l1;
        l1 = a("[getId(Uri)] ", ((Cursor) (uri))).longValue();
        double d1 = (double)(System.currentTimeMillis() - l) / 1000D;
        if (uri != null)
        {
            uri.close();
        }
        return Long.valueOf(l1);
        uri;
        uri = null;
_L4:
        if (uri != null)
        {
            uri.close();
        }
        return null;
        Object obj;
        obj;
        uri = null;
_L2:
        if (uri != null)
        {
            uri.close();
        }
        throw obj;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Long a(String s)
    {
        String s1 = null;
        long l;
        l = System.currentTimeMillis();
        Uri uri = c.a;
        s = b.query(uri, d, "_data=?", new String[] {
            s
        }, null);
        long l1;
        l1 = a("[getId(String)] ", ((Cursor) (s))).longValue();
        double d1 = (double)(System.currentTimeMillis() - l) / 1000D;
        if (s != null)
        {
            s.close();
        }
        return Long.valueOf(l1);
        s;
        s = null;
_L4:
        if (s != null)
        {
            s.close();
        }
        return null;
        s;
_L2:
        if (s1 != null)
        {
            s1.close();
        }
        throw s;
        Exception exception1;
        exception1;
        s1 = s;
        s = exception1;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public o b(long l)
    {
        Object obj;
        String as[];
        long l1;
        l1 = System.currentTimeMillis();
        obj = c.a;
        as = new String[1];
        as[0] = String.valueOf(l);
        obj = b.query(((Uri) (obj)), e, "_id=?", as, null);
        double d1;
        Object obj1;
        Exception exception;
        o o1;
        int i;
        int j;
        boolean flag;
        try
        {
            d1 = (double)(System.currentTimeMillis() - l1) / 1000D;
        }
        catch (Exception exception1)
        {
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_95;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        ((Cursor) (obj)).close();
        obj1 = a(as, ((String) (null)));
        obj = obj1;
        if (obj != null) goto _L2; else goto _L1
_L1:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        obj1 = null;
_L4:
        return ((o) (obj1));
_L2:
        flag = ((Cursor) (obj)).moveToFirst();
        if (!flag)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return null;
        }
        i = ((Cursor) (obj)).getColumnIndex("_data");
        j = ((Cursor) (obj)).getColumnIndex("date_modified");
        if (i < 0 || j < 0)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return null;
        }
        l1 = System.currentTimeMillis();
        if (((Cursor) (obj)).getCount() <= 1);
        o1 = new o(l, ((Cursor) (obj)).getString(i), ((Cursor) (obj)).getInt(j));
        l = System.currentTimeMillis();
        d1 = (double)(l - l1) / 1000D;
        obj1 = o1;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return o1;
        obj;
        obj = null;
_L8:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
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
        Exception exception2;
        exception2;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void b(String s)
    {
        Object obj = new StringBuilder();
        ((StringBuilder) (obj)).append("LOWER(");
        ((StringBuilder) (obj)).append("_data");
        ((StringBuilder) (obj)).append(") =?");
        obj = ((StringBuilder) (obj)).toString();
        b.delete(c.a, ((String) (obj)), new String[] {
            s
        });
    }

}

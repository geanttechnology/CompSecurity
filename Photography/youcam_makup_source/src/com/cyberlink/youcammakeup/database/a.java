// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import android.content.ContentResolver;
import android.database.Cursor;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.database:
//            b, p

public class a
{

    private static final String c[] = {
        "bucket_id", "bucket_display_name", "COUNT(bucket_id)", "_id", "_data", "MAX(datetaken)"
    };
    private static final String d[] = {
        "_id"
    };
    private static String e;
    private static String f;
    private String a;
    private ContentResolver b;

    public a()
    {
        a = "database.AlbumDao";
        b = Globals.d().getContentResolver();
    }

    private static String a()
    {
        boolean flag = false;
        com/cyberlink/youcammakeup/database/a;
        JVM INSTR monitorenter ;
        if (e != null) goto _L2; else goto _L1
_L1:
        Object obj;
        int j;
        int k;
        obj = new StringBuilder();
        k = c.d.length;
        j = c.e.length;
        if (k != 0 && j != 0) goto _L4; else goto _L3
_L3:
        ((StringBuilder) (obj)).append("1");
_L8:
        ((StringBuilder) (obj)).append(") GROUP BY (");
        ((StringBuilder) (obj)).append("bucket_id");
        e = ((StringBuilder) (obj)).toString();
_L2:
        obj = e;
        com/cyberlink/youcammakeup/database/a;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L4:
        Exception exception;
        for (int i = 0; i >= k; i++)
        {
            break MISSING_BLOCK_LABEL_130;
        }

        ((StringBuilder) (obj)).append("LOWER(SUBSTR(_data, ");
        ((StringBuilder) (obj)).append(-c.d[i].length());
        ((StringBuilder) (obj)).append("))=?");
        if (i >= k - 1)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        ((StringBuilder) (obj)).append(" OR ");
        break MISSING_BLOCK_LABEL_197;
        ((StringBuilder) (obj)).insert(0, "(").append(")");
        i = ((flag) ? 1 : 0);
_L6:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((StringBuilder) (obj)).append(" AND ");
        ((StringBuilder) (obj)).append("LOWER(SUBSTR(_data, 1, ");
        ((StringBuilder) (obj)).append(c.e[i].length());
        ((StringBuilder) (obj)).append("))!=?");
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L8; else goto _L7
_L7:
        exception;
        throw exception;
    }

    private static String b()
    {
        com/cyberlink/youcammakeup/database/a;
        JVM INSTR monitorenter ;
        if (f != null) goto _L2; else goto _L1
_L1:
        Object obj;
        int j;
        j = c.d.length;
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append("bucket_id=?");
        if (j <= 0) goto _L4; else goto _L3
_L3:
        ((StringBuilder) (obj)).append(" AND (");
        int i = 0;
_L10:
        if (i >= j) goto _L6; else goto _L5
_L5:
        ((StringBuilder) (obj)).append("LOWER(SUBSTR(_data, ");
        ((StringBuilder) (obj)).append(-c.d[i].length());
        ((StringBuilder) (obj)).append("))=?");
        if (i >= j - 1) goto _L8; else goto _L7
_L7:
        ((StringBuilder) (obj)).append(" OR ");
          goto _L8
_L6:
        ((StringBuilder) (obj)).append(")");
_L4:
        f = ((StringBuilder) (obj)).toString();
_L2:
        obj = f;
        com/cyberlink/youcammakeup/database/a;
        JVM INSTR monitorexit ;
        return ((String) (obj));
        Exception exception;
        exception;
        throw exception;
_L8:
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private static String[] d(long l)
    {
        int i = 0;
        String as[] = new String[c.d.length + 1];
        as[0] = String.valueOf(l);
        for (; i < c.d.length; i++)
        {
            as[i + 1] = c.d[i];
        }

        return as;
    }

    public com.cyberlink.youcammakeup.database.b a(long l)
    {
        Object obj = null;
        Object obj1;
        long l1;
        l1 = System.currentTimeMillis();
        obj1 = c.a;
        obj1 = b.query(((android.net.Uri) (obj1)), c, "bucket_id=?) GROUP BY (1", new String[] {
            String.valueOf(l)
        }, "MAX(datetaken) DESC");
        obj = obj1;
        l = System.currentTimeMillis();
        double d1 = (double)(l - l1) / 1000D;
        if (obj != null) goto _L2; else goto _L1
_L1:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        obj1 = null;
_L4:
        return ((com.cyberlink.youcammakeup.database.b) (obj1));
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
        int i;
        int j;
        int k;
        int i1;
        int j1;
        int k1;
        i = ((Cursor) (obj)).getColumnIndex("bucket_id");
        j = ((Cursor) (obj)).getColumnIndex("bucket_display_name");
        k = ((Cursor) (obj)).getColumnIndex("COUNT(bucket_id)");
        i1 = ((Cursor) (obj)).getColumnIndex("_id");
        j1 = ((Cursor) (obj)).getColumnIndex("_data");
        k1 = ((Cursor) (obj)).getColumnIndex("MAX(datetaken)");
        if (i < 0 || j < 0 || k < 0 || i1 < 0 || j1 < 0 || k1 < 0)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return null;
        }
        com.cyberlink.youcammakeup.database.b b1;
        l = System.currentTimeMillis();
        ((Cursor) (obj)).getCount();
        b1 = new com.cyberlink.youcammakeup.database.b(((Cursor) (obj)).getLong(i), ((Cursor) (obj)).getString(j), ((Cursor) (obj)).getInt(k), ((Cursor) (obj)).getLong(i1), -1L, ((Cursor) (obj)).getString(j1), ((Cursor) (obj)).getLong(k1));
        l1 = System.currentTimeMillis();
        double d2 = (double)(l1 - l) / 1000D;
        obj1 = b1;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return b1;
        obj;
        obj = null;
_L8:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        Object obj2;
        obj2;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw obj2;
        obj2;
        if (true) goto _L6; else goto _L5
_L5:
        obj2;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public List a(boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        Object obj;
        long l1;
        l1 = System.currentTimeMillis();
        obj = c.a;
        String s = a();
        String as[] = (String[])com.cyberlink.youcammakeup.utility.b.a(c.d, c.e);
        obj = b.query(((android.net.Uri) (obj)), c, s, as, "MAX(datetaken) DESC");
        long l3 = System.currentTimeMillis();
        double d1 = (double)(l3 - l1) / 1000D;
        if (obj == null)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return arraylist;
        }
        boolean flag1 = ((Cursor) (obj)).moveToFirst();
        if (!flag1)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return arraylist;
        }
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        i = ((Cursor) (obj)).getColumnIndex("bucket_id");
        j = ((Cursor) (obj)).getColumnIndex("bucket_display_name");
        k = ((Cursor) (obj)).getColumnIndex("COUNT(bucket_id)");
        l = ((Cursor) (obj)).getColumnIndex("_id");
        i1 = ((Cursor) (obj)).getColumnIndex("_data");
        j1 = ((Cursor) (obj)).getColumnIndex("MAX(datetaken)");
        if (i < 0 || j < 0 || k < 0 || l < 0 || i1 < 0 || j1 < 0)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return arraylist;
        }
        ArrayList arraylist1;
        long l2 = System.currentTimeMillis();
        arraylist1 = new ArrayList(((Cursor) (obj)).getCount());
        do
        {
            arraylist1.add(new com.cyberlink.youcammakeup.database.b(((Cursor) (obj)).getLong(i), ((Cursor) (obj)).getString(j), ((Cursor) (obj)).getInt(k), ((Cursor) (obj)).getLong(l), -1L, ((Cursor) (obj)).getString(i1), ((Cursor) (obj)).getLong(j1)));
        } while (((Cursor) (obj)).moveToNext());
        double d2 = (double)(System.currentTimeMillis() - l2) / 1000D;
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj1 = new HashMap();
        i = 0;
_L11:
        if (i >= arraylist1.size()) goto _L4; else goto _L3
_L3:
        if (!((com.cyberlink.youcammakeup.database.b)arraylist1.get(i)).b().equalsIgnoreCase("YouCam Makeup")) goto _L6; else goto _L5
_L5:
        ((Map) (obj1)).put("1", arraylist1.get(i));
_L10:
        if (((Map) (obj1)).size() != 2) goto _L7; else goto _L4
_L4:
        com.cyberlink.youcammakeup.database.b b1 = (com.cyberlink.youcammakeup.database.b)((Map) (obj1)).get("2");
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_457;
        }
        arraylist1.remove(b1);
        arraylist1.add(0, b1);
        obj1 = (com.cyberlink.youcammakeup.database.b)((Map) (obj1)).get("1");
        if (obj1 == null) goto _L2; else goto _L8
_L8:
        arraylist1.remove(obj1);
        arraylist1.add(0, obj1);
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return arraylist1;
_L6:
        if (!((com.cyberlink.youcammakeup.database.b)arraylist1.get(i)).b().equalsIgnoreCase("YouCam Makeup Sample")) goto _L10; else goto _L9
_L9:
        ((Map) (obj1)).put("2", arraylist1.get(i));
          goto _L10
        Exception exception2;
        exception2;
_L14:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return arraylist;
_L7:
        i++;
          goto _L11
        Exception exception1;
        exception1;
        obj = null;
_L13:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception1;
        exception1;
        if (true) goto _L13; else goto _L12
_L12:
        Exception exception;
        exception;
        exception = null;
          goto _L14
    }

    public long[] b(long l)
    {
        long al[] = new long[0];
        Object obj;
        long l1;
        l1 = System.currentTimeMillis();
        obj = c.a;
        String s = b();
        String as[] = d(l);
        obj = b.query(((android.net.Uri) (obj)), d, s, as, "datetaken DESC");
        l = System.currentTimeMillis();
        double d1 = (double)(l - l1) / 1000D;
        if (obj != null) goto _L2; else goto _L1
_L1:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
_L6:
        return al;
_L2:
        boolean flag = ((Cursor) (obj)).moveToFirst();
        if (!flag)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return al;
        }
        int k = ((Cursor) (obj)).getColumnIndex("_id");
        if (k < 0)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return al;
        }
        long al1[];
        int i1;
        l = System.currentTimeMillis();
        i1 = ((Cursor) (obj)).getCount();
        al1 = new long[i1];
        int i = 0;
_L4:
        al1[i] = ((Cursor) (obj)).getLong(k);
        int j;
        j = i + 1;
        if (j > i1)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return al;
        }
        flag = ((Cursor) (obj)).moveToNext();
        i = j;
        if (flag) goto _L4; else goto _L3
_L3:
        if (j != i1)
        {
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return al;
        }
        l1 = System.currentTimeMillis();
        double d2 = (double)(l1 - l) / 1000D;
        al = al1;
        if (obj == null) goto _L6; else goto _L5
_L5:
        ((Cursor) (obj)).close();
        return al1;
        obj;
        obj = null;
_L10:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return al;
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
        Exception exception1;
        exception1;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public long[] c(long l)
    {
        return com.cyberlink.youcammakeup.c.f().a(b(l));
    }

}

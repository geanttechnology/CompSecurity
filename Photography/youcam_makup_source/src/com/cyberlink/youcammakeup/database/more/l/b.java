// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.l;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.more.j;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.types.a;
import com.cyberlink.youcammakeup.database.more.unzipped.UnzippedCollageClassicMetadata;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.l:
//            a

public class b
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public b()
    {
    }

    private com.cyberlink.youcammakeup.database.more.unzipped.c a(Cursor cursor, String s, CategoryType categorytype)
    {
        if (categorytype.equals(CategoryType.h))
        {
            return new UnzippedCollageClassicMetadata(s, 0, 2);
        } else
        {
            return new com.cyberlink.youcammakeup.database.more.unzipped.b(s, 0);
        }
    }

    public int a(a a1)
    {
        Cursor cursor;
        a1 = a1.b().toString();
        cursor = a.query("MakeupTemplateFileInfo", new String[] {
            "COUNT(_id)"
        }, "TemplateType=?", new String[] {
            a1
        }, null, null, null, null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        a1 = cursor;
        m.e("TemplateFileInfoDao", "Failed to query: cursor is null");
        int i;
        if (cursor != null)
        {
            cursor.close();
        }
        i = 0;
_L4:
        return i;
_L2:
        a1 = cursor;
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_104;
        }
        a1 = cursor;
        m.b("TemplateFileInfoDao", "Failure of cursor.moveToFirst().");
        if (cursor != null)
        {
            cursor.close();
        }
        return 0;
        a1 = cursor;
        i = cursor.getColumnIndex("COUNT(_id)");
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        a1 = cursor;
        m.e("TemplateFileInfoDao", "cursor.getColumnIndex() returned negative number");
        if (cursor != null)
        {
            cursor.close();
        }
        return 0;
        a1 = cursor;
        int k = cursor.getInt(i);
        i = k;
        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
        return k;
        Exception exception1;
        exception1;
        cursor = null;
_L8:
        a1 = cursor;
        m.e("TemplateFileInfoDao", (new StringBuilder()).append("Exception: ").append(exception1.getMessage()).toString());
        if (cursor != null)
        {
            cursor.close();
        }
        return 0;
        Exception exception;
        exception;
        a1 = null;
_L6:
        if (a1 != null)
        {
            a1.close();
        }
        throw exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
        exception1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public com.cyberlink.youcammakeup.database.more.l.a a(com.cyberlink.youcammakeup.database.more.l.a a1)
    {
        com.cyberlink.youcammakeup.database.more.l.a a2 = b(a1.a());
        if (a2 != null)
        {
            a1 = a2;
        } else
        {
            android.content.ContentValues contentvalues = a1.h();
            long l;
            try
            {
                l = b.insert("MakeupTemplateFileInfo", null, contentvalues);
            }
            // Misplaced declaration of an exception variable
            catch (com.cyberlink.youcammakeup.database.more.l.a a1)
            {
                return null;
            }
            finally
            {
                throw a1;
            }
            if (l < 0L)
            {
                return null;
            }
        }
        return a1;
    }

    public com.cyberlink.youcammakeup.database.more.l.a a(a a1, int i)
    {
        String as[] = j.b();
        a1 = a1.b().toString();
        a1 = a.query("MakeupTemplateFileInfo", as, "TemplateType=?", new String[] {
            a1
        }, null, null, null, null);
        if (a1 != null) goto _L2; else goto _L1
_L1:
        m.e("TemplateFileInfoDao", "Failed to query: cursor is null");
        Object obj;
        if (a1 != null)
        {
            a1.close();
        }
        obj = null;
_L4:
        return ((com.cyberlink.youcammakeup.database.more.l.a) (obj));
_L2:
        if (a1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_92;
        }
        m.e("TemplateFileInfoDao", "Failure of cursor.moveToFirst().");
        if (a1 != null)
        {
            a1.close();
        }
        return null;
        boolean flag = a1.move(i);
        if (!flag)
        {
            if (a1 != null)
            {
                a1.close();
            }
            return null;
        }
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        i = a1.getColumnIndex("GUID");
        k = a1.getColumnIndex("Tid");
        l = a1.getColumnIndex("Stamp");
        i1 = a1.getColumnIndex("FolderPath");
        j1 = a1.getColumnIndex("TemplateType");
        k1 = a1.getColumnIndex("PublishDate");
        l1 = a1.getColumnIndex("ExpiredDate");
        i2 = a1.getColumnIndex("IsNew");
        if (i >= 0 && k >= 0 && l >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        m.e("TemplateFileInfoDao", "cursor.getColumnIndex() returned negative number");
        if (a1 != null)
        {
            a1.close();
        }
        return null;
        Object obj2;
        CategoryType categorytype;
        long l2;
        long l3;
        obj2 = a1.getString(i);
        l2 = a1.getLong(k);
        l3 = a1.getLong(l);
        obj = a1.getString(i1);
        categorytype = CategoryType.valueOf(a1.getString(j1));
        com.cyberlink.youcammakeup.database.more.unzipped.c c1;
        if (a1.getInt(i2) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c1 = a(((Cursor) (a1)), ((String) (obj)), categorytype);
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_357;
        }
        m.e("TemplateFileInfoDao", "getUnzippedMetadata() failed");
        if (a1 != null)
        {
            a1.close();
        }
        return null;
        Calendar calendar;
        long l4;
        l4 = a1.getLong(k1);
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l4);
        l4 = a1.getLong(l1);
        obj = null;
        if (l4 <= 0L)
        {
            break MISSING_BLOCK_LABEL_408;
        }
        obj = Calendar.getInstance();
        ((Calendar) (obj)).setTimeInMillis(l4);
        obj2 = new com.cyberlink.youcammakeup.database.more.l.a(l2, ((String) (obj2)), l3, c1, categorytype, calendar, ((Calendar) (obj)), flag);
        obj = obj2;
        if (a1 == null) goto _L4; else goto _L3
_L3:
        a1.close();
        return ((com.cyberlink.youcammakeup.database.more.l.a) (obj2));
        Object obj1;
        obj1;
        a1 = null;
_L8:
        m.e("TemplateFileInfoDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj1)).getMessage()).toString());
        if (a1 != null)
        {
            a1.close();
        }
        return null;
        obj1;
        a1 = null;
_L6:
        if (a1 != null)
        {
            a1.close();
        }
        throw obj1;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public com.cyberlink.youcammakeup.database.more.l.a a(String s)
    {
        Object obj;
        String as[] = j.b();
        String s1 = String.valueOf(s);
        String s2 = c.c;
        obj = a.query("MakeupTemplateFileInfo", as, "GUID=?", new String[] {
            s1
        }, null, null, null, s2);
        if (obj != null) goto _L2; else goto _L1
_L1:
        m.e("TemplateFileInfoDao", "Failed to query: cursor is null");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        s = null;
_L4:
        return s;
_L2:
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_95;
        }
        m.b("TemplateFileInfoDao", "Failure of cursor.moveToFirst().");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        int i;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        i = ((Cursor) (obj)).getColumnIndex("Tid");
        k = ((Cursor) (obj)).getColumnIndex("Stamp");
        l = ((Cursor) (obj)).getColumnIndex("FolderPath");
        i1 = ((Cursor) (obj)).getColumnIndex("TemplateType");
        j1 = ((Cursor) (obj)).getColumnIndex("PublishDate");
        k1 = ((Cursor) (obj)).getColumnIndex("ExpiredDate");
        l1 = ((Cursor) (obj)).getColumnIndex("IsNew");
        if (i >= 0 && k >= 0 && l >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        m.e("TemplateFileInfoDao", "cursor.getColumnIndex() returned negative number");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        Object obj1;
        CategoryType categorytype;
        long l2;
        long l3;
        l2 = ((Cursor) (obj)).getLong(i);
        l3 = ((Cursor) (obj)).getLong(k);
        obj1 = ((Cursor) (obj)).getString(l);
        categorytype = CategoryType.valueOf(((Cursor) (obj)).getString(i1));
        com.cyberlink.youcammakeup.database.more.unzipped.c c1;
        boolean flag;
        if (((Cursor) (obj)).getInt(l1) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c1 = a(((Cursor) (obj)), ((String) (obj1)), categorytype);
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        m.e("TemplateFileInfoDao", "getUnzippedMetadata() failed");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        Calendar calendar;
        long l4;
        l4 = ((Cursor) (obj)).getLong(j1);
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l4);
        l4 = ((Cursor) (obj)).getLong(k1);
        obj1 = null;
        if (l4 <= 0L)
        {
            break MISSING_BLOCK_LABEL_363;
        }
        obj1 = Calendar.getInstance();
        ((Calendar) (obj1)).setTimeInMillis(l4);
        obj1 = new com.cyberlink.youcammakeup.database.more.l.a(l2, s, l3, c1, categorytype, calendar, ((Calendar) (obj1)), flag);
        s = ((String) (obj1));
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return ((com.cyberlink.youcammakeup.database.more.l.a) (obj1));
        obj;
        s = null;
_L8:
        m.e("TemplateFileInfoDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
        if (s != null)
        {
            s.close();
        }
        return null;
        s;
        obj = null;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        Object obj2;
        obj2;
        obj = s;
        s = ((String) (obj2));
        if (true) goto _L6; else goto _L5
_L5:
        obj2;
        s = ((String) (obj));
        obj = obj2;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public Collection a()
    {
        ArrayList arraylist = new ArrayList();
        String as[] = j.b();
        Cursor cursor = a.query("MakeupTemplateFileInfo", as, null, null, null, null, "Tid ASC", null);
        if (cursor == null)
        {
            m.e("TemplateFileInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!cursor.moveToFirst())
        {
            m.e("TemplateFileInfoDao", "Failure of cursor.moveToFirst().");
            cursor.close();
            return arraylist;
        }
        do
        {
            arraylist.add(Long.valueOf(cursor.getLong(cursor.getColumnIndex("Tid"))));
        } while (cursor.moveToNext());
        cursor.close();
        return arraylist;
    }

    public boolean a(long l)
    {
        Cursor cursor1;
        String s = c.c;
        cursor1 = a.query("MakeupTemplateFileInfo", new String[0], "Tid=?", new String[] {
            String.valueOf(l)
        }, null, null, null, s);
        Cursor cursor;
        if (cursor1 != null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        cursor = cursor1;
        m.e("TemplateFileInfoDao", "Failed to query: cursor is null");
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return false;
        cursor = cursor1;
        if (cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_104;
        }
        cursor = cursor1;
        m.b("TemplateFileInfoDao", "Failure of cursor.moveToFirst().");
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return false;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return true;
        Exception exception1;
        exception1;
        cursor1 = null;
_L4:
        cursor = cursor1;
        m.e("TemplateFileInfoDao", (new StringBuilder()).append("Exception: ").append(exception1.getMessage()).toString());
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return false;
        Exception exception;
        exception;
        cursor = null;
_L2:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
        exception1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public com.cyberlink.youcammakeup.database.more.l.a b(long l)
    {
        Cursor cursor;
        String as[] = j.b();
        String s = c.c;
        cursor = a.query("MakeupTemplateFileInfo", as, "Tid=?", new String[] {
            String.valueOf(l)
        }, null, null, null, s);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        m.e("TemplateFileInfoDao", "Failed to query: cursor is null");
        Object obj;
        if (cursor != null)
        {
            cursor.close();
        }
        obj = null;
_L4:
        return ((com.cyberlink.youcammakeup.database.more.l.a) (obj));
_L2:
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_95;
        }
        m.b("TemplateFileInfoDao", "Failure of cursor.moveToFirst().");
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        int i;
        int k;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        i = cursor.getColumnIndex("GUID");
        k = cursor.getColumnIndex("Stamp");
        i1 = cursor.getColumnIndex("FolderPath");
        j1 = cursor.getColumnIndex("TemplateType");
        k1 = cursor.getColumnIndex("PublishDate");
        l1 = cursor.getColumnIndex("ExpiredDate");
        i2 = cursor.getColumnIndex("IsNew");
        if (i >= 0 && k >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        m.e("TemplateFileInfoDao", "cursor.getColumnIndex() returned negative number");
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        Object obj2;
        CategoryType categorytype;
        long l2;
        obj2 = cursor.getString(i);
        l2 = cursor.getLong(k);
        obj = cursor.getString(i1);
        categorytype = CategoryType.valueOf(cursor.getString(j1));
        com.cyberlink.youcammakeup.database.more.unzipped.c c1;
        boolean flag;
        if (cursor.getInt(i2) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c1 = a(cursor, ((String) (obj)), categorytype);
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_314;
        }
        m.e("TemplateFileInfoDao", "getUnzippedMetadata() failed");
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        Calendar calendar;
        long l3;
        l3 = cursor.getLong(k1);
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l3);
        l3 = cursor.getLong(l1);
        obj = null;
        if (l3 <= 0L)
        {
            break MISSING_BLOCK_LABEL_368;
        }
        obj = Calendar.getInstance();
        ((Calendar) (obj)).setTimeInMillis(l3);
        obj2 = new com.cyberlink.youcammakeup.database.more.l.a(l, ((String) (obj2)), l2, c1, categorytype, calendar, ((Calendar) (obj)), flag);
        obj = obj2;
        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
        return ((com.cyberlink.youcammakeup.database.more.l.a) (obj2));
        Object obj1;
        obj1;
        cursor = null;
_L8:
        m.e("TemplateFileInfoDao", (new StringBuilder()).append("Exception: ").append(((Exception) (obj1)).getMessage()).toString());
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        obj1;
        cursor = null;
_L6:
        if (cursor != null)
        {
            cursor.close();
        }
        throw obj1;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean b(String s)
    {
        c(s);
        b.delete("MakeupTemplateFileInfo", "GUID=?", new String[] {
            s
        });
        return true;
        s;
        m.e("TemplateFileInfoDao", (new StringBuilder()).append("db.delete exception: ").append(s.getMessage()).toString());
        return false;
        s;
        throw s;
    }

    public boolean c(long l)
    {
        b.delete("MakeupTemplateFileInfo", "Tid=?", new String[] {
            String.valueOf(l)
        });
        return true;
        Object obj;
        obj;
        m.e("TemplateFileInfoDao", (new StringBuilder()).append("db.delete exception: ").append(((Exception) (obj)).getMessage()).toString());
        return false;
        obj;
        throw obj;
    }

    public boolean c(String s)
    {
        s = a(s);
        boolean flag = false;
        if (s != null)
        {
            flag = false | (new File((new StringBuilder()).append(s.c().b()).append(File.separator).append("makeup_metadata.json").toString())).delete() | (new File((new StringBuilder()).append(s.c().b()).append(File.separator).append("makeup_category_id").toString())).delete();
        }
        m.b("TemplateFileInfoDao", (new StringBuilder()).append("Delete metadata: ").append(flag).toString());
        return flag;
    }
}

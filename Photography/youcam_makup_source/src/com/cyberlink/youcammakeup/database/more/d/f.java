// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.database.more.g;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.d:
//            e, b

public class f
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public f()
    {
    }

    public e a(e e1)
    {
        e e2 = a(e1.a());
        if (e2 == null) goto _L2; else goto _L1
_L1:
        e1 = e2;
_L4:
        return e1;
_L2:
        ContentValues contentvalues = e1.k();
        long l;
        try
        {
            m.a("LookInfoDao", (new StringBuilder()).append("db.insert to LookInfo: ").append(contentvalues.toString()).toString());
            l = b.insert("LookInfo", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            m.e("LookInfoDao", (new StringBuilder()).append("db.insert exception: ").append(e1.getMessage()).toString());
            return null;
        }
        if (l >= 0L) goto _L4; else goto _L3
_L3:
        m.e("LookInfoDao", (new StringBuilder()).append("db.insert failed. id: ").append(l).toString());
        return null;
    }

    public e a(String s)
    {
        Cursor cursor;
        String as[] = g.a();
        cursor = a.query("LookInfo", as, "GUID=?", new String[] {
            s
        }, null, null, null, null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        m.e("LookInfoDao", "Failed to query: cursor is null");
        Object obj = null;
        s = obj;
        if (cursor != null)
        {
            cursor.close();
            s = obj;
        }
_L4:
        return s;
_L2:
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_93;
        }
        m.b("LookInfoDao", "Failure of cursor.moveToFirst().");
        s = null;
        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
        return null;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        k = cursor.getColumnIndex("GUID");
        l = cursor.getColumnIndex("Version");
        i1 = cursor.getColumnIndex("Name");
        j1 = cursor.getColumnIndex("Description");
        k1 = cursor.getColumnIndex("ThumbImage");
        l1 = cursor.getColumnIndex("PreviewImage");
        i2 = cursor.getColumnIndex("Source");
        j2 = cursor.getColumnIndex("SupportMode");
        k2 = cursor.getColumnIndex("IsNew");
        l2 = cursor.getColumnIndex("ExtraData");
        i3 = cursor.getColumnIndex("ExtStr1");
        j3 = cursor.getColumnIndex("ExtStr2");
        k3 = cursor.getColumnIndex("ExtStr3");
        l3 = cursor.getColumnIndex("ExtInt1");
        j = cursor.getColumnIndex("ExtInt2");
        i = cursor.getColumnIndex("ExtInt3");
        if (k >= 0 && l >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0 && i2 >= 0 && j2 >= 0 && k2 >= 0 && l2 >= 0 && i3 >= 0 && j3 >= 0 && k3 >= 0 && l3 >= 0 && j >= 0 && i >= 0)
        {
            break MISSING_BLOCK_LABEL_355;
        }
        m.e("LookInfoDao", "cursor.getColumnIndex() returned negative number");
        s = null;
        if (cursor == null) goto _L4; else goto _L5
_L5:
        cursor.close();
        return null;
        float f1;
        Object obj1;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        s = cursor.getString(k);
        f1 = cursor.getFloat(l);
        obj1 = cursor.getString(i1);
        s1 = cursor.getString(j1);
        s2 = cursor.getString(k1);
        s3 = cursor.getString(l1);
        s4 = cursor.getString(i2);
        s5 = cursor.getString(j2);
        String s6;
        String s7;
        String s8;
        String s9;
        boolean flag;
        if (cursor.getInt(k2) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s6 = cursor.getString(l2);
        s7 = cursor.getString(i3);
        s8 = cursor.getString(j3);
        s9 = cursor.getString(k3);
        k = cursor.getInt(l3);
        j = cursor.getInt(j);
        i = cursor.getInt(i);
        obj1 = new e(s, Float.valueOf(f1).floatValue(), ((String) (obj1)), s1, s2, s3, s4, s5, Boolean.valueOf(flag).booleanValue(), s6, s7, s8, s9, Integer.valueOf(k).intValue(), Integer.valueOf(j).intValue(), Integer.valueOf(i).intValue());
        s = ((String) (obj1));
        if (cursor == null) goto _L4; else goto _L6
_L6:
        cursor.close();
        return ((e) (obj1));
        s;
        cursor = null;
_L10:
        m.e("LookInfoDao", (new StringBuilder()).append("Exception: ").append(s.getMessage()).toString());
        s = null;
        if (cursor == null) goto _L4; else goto _L7
_L7:
        cursor.close();
        return null;
        s;
        cursor = null;
_L9:
        if (cursor != null)
        {
            cursor.close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L9; else goto _L8
_L8:
        s;
          goto _L10
    }

    public transient Collection a(String s, String as[])
    {
        ArrayList arraylist = new ArrayList();
        Object obj;
        String as1[];
        int i;
        if (s != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (s != null && as.length > 0)
        {
            String s1;
            int j;
            if (s != null)
            {
                obj = new String[as.length + i];
            } else
            {
                obj = null;
            }
            obj[0] = s;
            s1 = "Source=?";
            as1 = ((String []) (obj));
            obj = s1;
        } else
        if (as.length > 0)
        {
            as1 = new String[as.length];
            obj = null;
        } else
        if (s != null)
        {
            if (s != null)
            {
                obj = new String[1];
                obj[0] = s;
            } else
            {
                obj = null;
            }
            as1 = ((String []) (obj));
            obj = "Source=?";
        } else
        {
            as1 = null;
            obj = null;
        }
        s1 = ((String) (obj));
        if (s != null)
        {
            s1 = ((String) (obj));
            if (as.length > 0)
            {
                s1 = (new StringBuilder()).append(((String) (obj))).append(" AND ( ").toString();
            }
        }
        obj = s1;
        for (j = 0; j < as.length; j++)
        {
            s1 = ((String) (obj));
            if (j > 0)
            {
                s1 = (new StringBuilder()).append(((String) (obj))).append(" OR ").toString();
            }
            obj = (new StringBuilder()).append(s1).append("SupportMode=?").toString();
            as1[j + i] = as[j];
        }

        if (s != null && as.length > 0)
        {
            s = (new StringBuilder()).append(((String) (obj))).append(" ) ").toString();
        } else
        {
            s = ((String) (obj));
        }
        s = a.query("LookInfo", new String[] {
            "GUID"
        }, s, as1, null, null, "_id ASC", null);
        if (s == null)
        {
            m.e("LookInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("LookInfoDao", "Failure of cursor.moveToFirst().");
            s.close();
            return arraylist;
        }
        do
        {
            arraylist.add(s.getString(s.getColumnIndex("GUID")));
        } while (s.moveToNext());
        s.close();
        return arraylist;
    }

    public transient Collection a(String as[])
    {
        ArrayList arraylist = new ArrayList();
        String s;
        String as1[];
        int i;
        if (as.length > 0)
        {
            s = "";
        } else
        {
            s = null;
        }
        if (as.length > 0)
        {
            as1 = new String[as.length];
        } else
        {
            as1 = null;
        }
        for (i = 0; i < as.length; i++)
        {
            String s1 = s;
            if (i > 0)
            {
                s1 = (new StringBuilder()).append(s).append(" OR ").toString();
            }
            s = (new StringBuilder()).append(s1).append("Source=?").toString();
            as1[i] = as[i];
        }

        as = a.query("LookInfo", new String[] {
            "GUID"
        }, s, as1, null, null, "_id ASC", null);
        if (as == null)
        {
            m.e("LookInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!as.moveToFirst())
        {
            m.e("LookInfoDao", "Failure of cursor.moveToFirst().");
            as.close();
            return arraylist;
        }
        do
        {
            arraylist.add(as.getString(as.getColumnIndex("GUID")));
        } while (as.moveToNext());
        as.close();
        return arraylist;
    }

    public boolean a(String s, e e1)
    {
        e1 = e1.k();
        int i = b.update("LookInfo", e1, "GUID = ?", new String[] {
            s
        });
        if (i != 1)
        {
            m.e("LookInfoDao", (new StringBuilder()).append("[update]  update id: ").append(s).append(", rowsAffected != 1, rowsAffected: ").append(i).toString());
            return false;
        } else
        {
            return true;
        }
    }

    public boolean a(String s, String s1)
    {
        int i;
        try
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("IsNew", s1);
            i = b.update("LookInfo", contentvalues, "GUID = ?", new String[] {
                s
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        finally
        {
            throw s;
        }
        return i == 1;
    }

    public Collection b(String s)
    {
        ArrayList arraylist = new ArrayList();
        String s1;
        if (s != null)
        {
            s1 = "Source=?";
        } else
        {
            s1 = null;
        }
        if (s != null)
        {
            String as[] = new String[1];
            as[0] = s;
            s = as;
        } else
        {
            s = null;
        }
        s = a.query("LookInfo", new String[] {
            "Name"
        }, s1, s, null, null, null, null);
        if (s == null)
        {
            m.e("LookInfoDao", "Failed to query: cursor is null");
            return arraylist;
        }
        if (!s.moveToFirst())
        {
            m.e("LookInfoDao", "Failure of cursor.moveToFirst().");
            s.close();
            return arraylist;
        }
        do
        {
            arraylist.add(s.getString(s.getColumnIndex("Name")));
        } while (s.moveToNext());
        s.close();
        return arraylist;
    }

    public boolean c(String s)
    {
        int i = b.delete("LookInfo", "GUID = ?", new String[] {
            s
        });
        if (i != 1)
        {
            m.e("LookInfoDao", (new StringBuilder()).append("[delete]  delete id: ").append(s).append(", rowsAffected != 1, rowsAffected: ").append(i).toString());
            return false;
        }
        String s1;
        for (s = ((List)h.m().b(s)).iterator(); s.hasNext(); h.m().g(s1))
        {
            s1 = (String)s.next();
        }

        return true;
    }
}

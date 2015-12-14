// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.util.Pair;
import com.cyberlink.you.i;
import com.cyberlink.you.utility.ULogUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class e
{

    private static final String a[] = {
        "_id", "GroupId", "UserId"
    };
    private final SQLiteDatabase b = com.cyberlink.you.e.a();
    private final SQLiteDatabase c = com.cyberlink.you.e.b();

    public e()
    {
    }

    private Pair a(Cursor cursor)
    {
        long l1 = System.currentTimeMillis();
        int j = cursor.getColumnIndex("_id");
        int k = cursor.getColumnIndex("GroupId");
        int l = cursor.getColumnIndex("UserId");
        if (j < 0 || k < 0 || l < 0)
        {
            i.c("database.GroupMember", new Object[] {
                "[_get(Cursor)] ", "cursor.getColumnIndex() returned negative number"
            });
            return null;
        }
        Long long1 = Long.valueOf(cursor.getLong(k));
        cursor = Long.valueOf(cursor.getLong(l));
        if (i.a() <= 2)
        {
            i.a("database.GroupMember", new Object[] {
                "[_get(Cursor)] ", "    groupId: ", long1, "    userId: ", cursor
            });
            i.a("database.GroupMember", new Object[] {
                "[_get(Cursor)] ", "Iterating takes ", Double.valueOf((double)(System.currentTimeMillis() - l1) / 1000D), " seconds."
            });
        }
        return Pair.create(long1, cursor);
    }

    private Pair a(String s, String as[], String s1)
    {
        long l;
        l = System.currentTimeMillis();
        as = b.query("GroupMember", a, s, as, null, null, s1, com.cyberlink.you.e.c);
        if (as != null) goto _L2; else goto _L1
_L1:
        s = as;
        i.c("database.GroupMember", new Object[] {
            "[get(String, String[])] ", "Failed to query: cursor is null"
        });
        s1 = null;
        s = s1;
        if (as != null)
        {
            as.close();
            s = s1;
        }
_L4:
        return s;
_L2:
        s = as;
        if (i.a() > 2)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        s = as;
        i.a("database.GroupMember", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        s = as;
        if (as.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        s = as;
        i.a("database.GroupMember", new Object[] {
            "[get(String, String[])] ", "Database has no records."
        });
        s = null;
        if (as != null)
        {
            as.close();
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
        s = as;
        s1 = a(((Cursor) (as)));
        s = s1;
        if (as == null) goto _L4; else goto _L5
_L5:
        as.close();
        return s1;
        s1;
        as = null;
_L9:
        s = as;
        ULogUtility.a("database.GroupMember", "[get(String, String[])] ", s1);
        s = null;
        if (as == null) goto _L4; else goto _L6
_L6:
        as.close();
        return null;
        as;
        s = null;
_L8:
        if (s != null)
        {
            s.close();
        }
        throw as;
        as;
        if (true) goto _L8; else goto _L7
_L7:
        s1;
          goto _L9
    }

    private List a(String s, String as[])
    {
        long l;
        l = System.currentTimeMillis();
        as = b.query("GroupMember", a, s, as, null, null, null);
        if (as != null) goto _L2; else goto _L1
_L1:
        s = as;
        i.c("database.GroupMember", new Object[] {
            "[get(String, String[])] ", "Failed to query: cursor is null"
        });
        s = as;
        Object obj = Collections.EMPTY_LIST;
        s = ((String) (obj));
        if (as != null)
        {
            as.close();
            s = ((String) (obj));
        }
_L4:
        return s;
_L2:
        s = as;
        if (i.a() > 2)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        s = as;
        i.a("database.GroupMember", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        s = as;
        if (as.getCount() > 0)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        s = as;
        i.a("database.GroupMember", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        s = as;
        if (as.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        s = as;
        i.a("database.GroupMember", new Object[] {
            "[get(String, String[])] ", "Database has no records."
        });
        s = as;
        obj = Collections.EMPTY_LIST;
        s = ((String) (obj));
        if (as != null)
        {
            as.close();
            return ((List) (obj));
        }
        if (true) goto _L4; else goto _L3
_L3:
        s = as;
        obj = new ArrayList();
_L6:
        s = as;
        ((List) (obj)).add(a(((Cursor) (as))).second);
        s = as;
        boolean flag = as.moveToNext();
        if (flag) goto _L6; else goto _L5
_L5:
        s = ((String) (obj));
        if (as == null) goto _L4; else goto _L7
_L7:
        as.close();
        return ((List) (obj));
        Exception exception;
        exception;
        as = null;
_L11:
        s = as;
        ULogUtility.a("database.GroupMember", "[get(String, String[])] ", exception);
        s = as;
        exception = Collections.EMPTY_LIST;
        s = exception;
        if (as == null) goto _L4; else goto _L8
_L8:
        as.close();
        return exception;
        as;
        s = null;
_L10:
        if (s != null)
        {
            s.close();
        }
        throw as;
        as;
        if (true) goto _L10; else goto _L9
_L9:
        exception;
          goto _L11
    }

    private void a(Pair pair)
    {
        if (pair != null && pair.first != null && pair.second != null)
        {
            d((Long)pair.first, (Long)pair.second);
        }
    }

    private boolean a(String s)
    {
        int j = c.delete("GroupMember", "GroupId=?", new String[] {
            s
        });
        if (j != 1)
        {
            i.c("database.GroupMember", new Object[] {
                "[_delete] ", "delete groupId: ", s, ", rowsAffected != 1, rowsAffected: ", Integer.valueOf(j)
            });
            return false;
        } else
        {
            return true;
        }
    }

    private boolean a(String s, String s1)
    {
        int j = c.delete("GroupMember", "GroupId=? AND UserId=?", new String[] {
            s, s1
        });
        if (j != 1)
        {
            i.c("database.GroupMember", new Object[] {
                "[_delete] ", "delete groupId: ", s, " userId: ", s1, ", rowsAffected != 1, rowsAffected: ", Integer.valueOf(j)
            });
            return false;
        } else
        {
            return true;
        }
    }

    private void d(Long long1, Long long2)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("GroupId", long1);
        contentvalues.put("UserId", long2);
        long l;
        try
        {
            if (i.a() <= 2)
            {
                i.a("database.GroupMember", new Object[] {
                    "[insert] ", "db.insert to ", "GroupMember", ": ", contentvalues.toString()
                });
            }
            l = c.insert("GroupMember", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (Long long1)
        {
            ULogUtility.a("database.GroupMember", "[insert] ", long1);
            return;
        }
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        i.c("database.GroupMember", new Object[] {
            "[insert] ", "db.insert id: ", Long.valueOf(l)
        });
    }

    public Pair a(Long long1, Long long2)
    {
        return a("GroupId=? AND UserId=?", new String[] {
            String.valueOf(long1), String.valueOf(long2)
        }, null);
    }

    public List a()
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        Cursor cursor = b.rawQuery("Select UserId from GroupMember group by UserId", null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        obj = cursor;
        obj1 = cursor;
        Object obj2 = Collections.EMPTY_LIST;
        obj = obj2;
        if (cursor != null)
        {
            cursor.close();
            obj = obj2;
        }
_L4:
        return ((List) (obj));
_L2:
        obj = cursor;
        obj1 = cursor;
        if (cursor.getCount() > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        obj = cursor;
        obj1 = cursor;
        cursor.close();
        obj = cursor;
        obj1 = cursor;
        obj2 = Collections.EMPTY_LIST;
        obj = obj2;
        if (cursor != null)
        {
            cursor.close();
            return ((List) (obj2));
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj = cursor;
        obj1 = cursor;
        cursor.moveToFirst();
        obj = cursor;
        obj1 = cursor;
        int j = cursor.getColumnIndex("UserId");
        if (j >= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = cursor;
        obj1 = cursor;
        Log.e("database.GroupMember", "getAllGroupEx cursor.getColumnIndex() returned negative number");
        obj = cursor;
        obj1 = cursor;
        obj2 = Collections.EMPTY_LIST;
        obj = obj2;
        if (cursor != null)
        {
            cursor.close();
            return ((List) (obj2));
        }
        if (true) goto _L4; else goto _L5
_L5:
        obj = cursor;
        obj1 = cursor;
        if (cursor.getCount() > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = cursor;
        obj1 = cursor;
        obj2 = Collections.EMPTY_LIST;
        obj = obj2;
        if (cursor != null)
        {
            cursor.close();
            return ((List) (obj2));
        }
        if (true) goto _L4; else goto _L6
_L6:
        obj = cursor;
        obj1 = cursor;
        obj2 = new ArrayList();
_L8:
        obj = cursor;
        obj1 = cursor;
        ((List) (obj2)).add(Long.valueOf(cursor.getLong(j)));
        obj = cursor;
        obj1 = cursor;
        boolean flag = cursor.moveToNext();
        if (flag) goto _L8; else goto _L7
_L7:
        obj = obj2;
        if (cursor != null)
        {
            cursor.close();
            return ((List) (obj2));
        }
        if (true) goto _L4; else goto _L9
_L9:
        Exception exception1;
        exception1;
        obj1 = obj;
        ULogUtility.a("database.GroupMember", "[getExistedGroupMemberIdList] ", exception1);
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return Collections.EMPTY_LIST;
        Exception exception;
        exception;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw exception;
    }

    public List a(Long long1)
    {
        return a("GroupId=?", new String[] {
            String.valueOf(long1)
        });
    }

    public boolean b(Long long1)
    {
        return a(String.valueOf(long1));
    }

    public boolean b(Long long1, Long long2)
    {
        return a(String.valueOf(long1), String.valueOf(long2));
    }

    public void c(Long long1, Long long2)
    {
        if (a(long1, long2) == null)
        {
            a(Pair.create(long1, long2));
        }
    }

}

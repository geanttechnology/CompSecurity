// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.i;
import com.cyberlink.you.utility.ULogUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class o
{

    private static final String a[] = {
        "_id", "UserId", "Jid", "DisplayName", "Avatar", "IsBlocked"
    };
    private final SQLiteDatabase b = e.a();
    private final SQLiteDatabase c = e.b();

    public o()
    {
    }

    private Friend a(Cursor cursor)
    {
        long l1 = System.currentTimeMillis();
        int j = cursor.getColumnIndex("_id");
        int k = cursor.getColumnIndex("UserId");
        int l = cursor.getColumnIndex("Jid");
        int i1 = cursor.getColumnIndex("DisplayName");
        int j1 = cursor.getColumnIndex("Avatar");
        int k1 = cursor.getColumnIndex("IsBlocked");
        if (j < 0 || k < 0 || l < 0 || i1 < 0 || j1 < 0 || k1 < 0)
        {
            i.c("database.FriendDao", new Object[] {
                "[_get(Cursor)] ", "cursor.getColumnIndex() returned negative number"
            });
            cursor = null;
        } else
        {
            long l2 = cursor.getLong(j);
            long l3 = cursor.getLong(k);
            Object obj = cursor.getString(l);
            String s = cursor.getString(i1);
            String s1 = cursor.getString(j1);
            boolean flag;
            if (cursor.getInt(k1) == 0)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            obj = new Friend(l2, l3, ((String) (obj)), s, s1, flag);
            cursor = ((Cursor) (obj));
            if (i.a() <= 2)
            {
                i.a("database.FriendDao", new Object[] {
                    "[_get(Cursor)] ", "    friend: ", obj.toString()
                });
                i.a("database.FriendDao", new Object[] {
                    "[_get(Cursor)] ", "Iterating takes ", Double.valueOf((double)(System.currentTimeMillis() - l1) / 1000D), " seconds."
                });
                return ((Friend) (obj));
            }
        }
        return cursor;
    }

    private Friend a(String s, String as[])
    {
        long l;
        l = System.currentTimeMillis();
        s = b.query("User", a, s, as, null, null, null, e.c);
        if (s != null) goto _L2; else goto _L1
_L1:
        as = s;
        i.c("database.FriendDao", new Object[] {
            "[get(String, String[])] ", "Failed to query: cursor is null"
        });
        if (s != null)
        {
            s.close();
        }
        as = null;
_L4:
        return as;
_L2:
        as = s;
        if (i.a() > 2)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        as = s;
        i.a("database.FriendDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        as = s;
        if (s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_164;
        }
        as = s;
        i.b("database.FriendDao", new Object[] {
            "[get(String, String[])] ", "Database has no records."
        });
        if (s != null)
        {
            s.close();
        }
        return null;
        as = s;
        Friend friend = a(((Cursor) (s)));
        as = friend;
        if (s == null) goto _L4; else goto _L3
_L3:
        s.close();
        return friend;
        Exception exception;
        exception;
        s = null;
_L8:
        as = s;
        ULogUtility.a("database.FriendDao", "[get(String, String[])] ", exception);
        if (s != null)
        {
            s.close();
        }
        return null;
        s;
        as = null;
_L6:
        if (as != null)
        {
            as.close();
        }
        throw s;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        exception;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void a(String s, ContentValues contentvalues)
    {
        int j;
        try
        {
            if (i.a() <= 2)
            {
                i.a("database.FriendDao", new Object[] {
                    "[update] ", "db.update to ", "User", ", id: ", s, ", values: ", contentvalues.toString()
                });
            }
            j = c.update("User", contentvalues, "UserId=?", new String[] {
                s
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ULogUtility.a("database.FriendDao", "[update] ", s);
            return;
        }
        if (j == 1)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        i.c("database.FriendDao", new Object[] {
            "[update] ", "update id: ", s, ", rowsAffected != 1, rowsAffected: ", Integer.valueOf(j)
        });
    }

    private List b(String s)
    {
        String s1;
        String s2;
        Object obj;
        Object obj1;
        ArrayList arraylist;
        arraylist = new ArrayList();
        obj1 = null;
        obj = null;
        s2 = obj;
        s1 = obj1;
        long l = System.currentTimeMillis();
        s2 = obj;
        s1 = obj1;
        s = b.rawQuery(s, null);
        if (s != null) goto _L2; else goto _L1
_L1:
        s2 = s;
        s1 = s;
        i.c("database.FriendDao", new Object[] {
            "[_getUser(String)] ", "Failed to query: cursor is null"
        });
        if (s != null)
        {
            s.close();
        }
_L6:
        return arraylist;
_L2:
        s2 = s;
        s1 = s;
        if (i.a() > 2)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        s2 = s;
        s1 = s;
        i.a("database.FriendDao", new Object[] {
            "[_getUser(String)] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        s2 = s;
        s1 = s;
        if (s.getCount() > 0)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        s2 = s;
        s1 = s;
        i.a("database.FriendDao", new Object[] {
            "[_getUser(String)] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        s2 = s;
        s1 = s;
        if (s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_249;
        }
        s2 = s;
        s1 = s;
        i.b("database.FriendDao", new Object[] {
            "[_getUser(String)] ", "Database has no records."
        });
        if (s != null)
        {
            s.close();
            return arraylist;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        s2 = s;
        s1 = s;
        arraylist.add(a(s));
        s2 = s;
        s1 = s;
        boolean flag = s.moveToNext();
        if (flag) goto _L4; else goto _L3
_L3:
        if (s != null)
        {
            s.close();
            return arraylist;
        }
        if (true) goto _L6; else goto _L5
_L5:
        s;
        s1 = s2;
        ULogUtility.a("database.FriendDao", "[_getUser(String)] ", s);
        if (s2 == null) goto _L6; else goto _L7
_L7:
        s2.close();
        return arraylist;
        s;
        if (s1 != null)
        {
            s1.close();
        }
        throw s;
    }

    private void b(Friend friend)
    {
        friend = friend.c();
        friend.remove("_id");
        long l;
        try
        {
            if (i.a() <= 2)
            {
                i.a("database.FriendDao", new Object[] {
                    "[insert] ", "db.insert to ", "User", ": ", friend.toString()
                });
            }
            l = c.insert("User", null, friend);
        }
        // Misplaced declaration of an exception variable
        catch (Friend friend)
        {
            ULogUtility.a("database.FriendDao", "[insert] ", friend);
            return;
        }
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        i.c("database.FriendDao", new Object[] {
            "[insert] ", "db.insert id: ", Long.valueOf(l)
        });
    }

    public Friend a(String s)
    {
        return a("UserId=?", new String[] {
            s
        });
    }

    public List a(long l)
    {
        return b((new StringBuilder()).append("select B.* from (select UserId from GroupMember where GroupId=").append(l).append(") A left join (select * from User ) B on A.UserId=B.UserId").toString());
    }

    public List a(List list)
    {
        if (list == null || list.isEmpty())
        {
            return Collections.EMPTY_LIST;
        }
        StringBuilder stringbuilder = new StringBuilder("Select * from User where ");
        stringbuilder.append("UserId=");
        stringbuilder.append(list.get(0));
        long l;
        for (list = list.iterator(); list.hasNext(); stringbuilder.append(l))
        {
            l = ((Long)list.next()).longValue();
            stringbuilder.append(" OR UserId=");
        }

        stringbuilder.append(" order by UserId ASC");
        return b(stringbuilder.toString());
    }

    public Map a()
    {
        HashMap hashmap = new HashMap();
        Cursor cursor1;
        long l;
        l = System.currentTimeMillis();
        cursor1 = b.query("User", a, null, null, null, null, null);
        Cursor cursor;
        if (cursor1 != null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        cursor = cursor1;
        i.c("database.FriendDao", new Object[] {
            "[get(String, String[])] ", "Failed to query: cursor is null"
        });
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return hashmap;
        cursor = cursor1;
        if (i.a() > 2)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        cursor = cursor1;
        i.a("database.FriendDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        cursor = cursor1;
        if (cursor1.getCount() > 0)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        cursor = cursor1;
        i.a("database.FriendDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        cursor = cursor1;
        if (cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_225;
        }
        cursor = cursor1;
        i.b("database.FriendDao", new Object[] {
            "[get(String, String[])] ", "Database has no records."
        });
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return hashmap;
_L2:
        cursor = cursor1;
        Friend friend = a(cursor1);
        cursor = cursor1;
        hashmap.put(String.valueOf(friend.a), friend);
        cursor = cursor1;
        boolean flag = cursor1.moveToNext();
        if (flag) goto _L2; else goto _L1
_L1:
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return hashmap;
        Exception exception1;
        exception1;
        cursor1 = null;
_L6:
        cursor = cursor1;
        ULogUtility.a("database.FriendDao", "[get(String, String[])] ", exception1);
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return hashmap;
        Exception exception;
        exception;
        cursor = null;
_L4:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
        exception1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a(Friend friend)
    {
        a(friend, Friend.e);
    }

    public void a(Friend friend, List list)
    {
label0:
        {
            if (friend != null)
            {
                if (a(String.valueOf(friend.a)) != null)
                {
                    break label0;
                }
                b(friend);
            }
            return;
        }
        a(String.valueOf(friend.a), friend, list);
    }

    public void a(String s, Friend friend, String s1)
    {
        a(s, friend.b(s1));
    }

    public void a(String s, Friend friend, List list)
    {
        a(s, friend.a(list));
    }

    public void b(List list)
    {
        for (list = list.iterator(); list.hasNext(); a((Friend)list.next())) { }
    }

}

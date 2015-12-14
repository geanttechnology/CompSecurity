// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.cyberlink.you.e;
import com.cyberlink.you.g;
import com.cyberlink.you.i;
import com.cyberlink.you.utility.ULogUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.database:
//            Group

public class d
{

    private static final String a[] = {
        "_id", "GroupId", "GroupType", "DisplayName", "LastModified", "Jid", "Avatar", "NumberOfMember", "LastRead", "isDisabled", 
        "isNotificationDisabled", "LastDeleteChatTime", "DraftText", "LastMsg"
    };
    private final SQLiteDatabase b = com.cyberlink.you.e.a();
    private final SQLiteDatabase c = com.cyberlink.you.e.b();
    private List d;

    public d()
    {
    }

    private Group a(Cursor cursor)
    {
        long l3 = System.currentTimeMillis();
        int l1 = cursor.getColumnIndex("_id");
        int i2 = cursor.getColumnIndex("GroupId");
        int j2 = cursor.getColumnIndex("GroupType");
        int k2 = cursor.getColumnIndex("DisplayName");
        int l2 = cursor.getColumnIndex("Jid");
        int i3 = cursor.getColumnIndex("Avatar");
        int j3 = cursor.getColumnIndex("LastModified");
        int k3 = cursor.getColumnIndex("NumberOfMember");
        int j = cursor.getColumnIndex("LastRead");
        int k = cursor.getColumnIndex("isDisabled");
        int l = cursor.getColumnIndex("isNotificationDisabled");
        int i1 = cursor.getColumnIndex("LastDeleteChatTime");
        int j1 = cursor.getColumnIndex("DraftText");
        int k1 = cursor.getColumnIndex("LastMsg");
        if (l1 < 0 || i2 < 0 || j2 < 0 || k2 < 0 || l2 < 0 || i3 < 0 || j3 < 0 || k3 < 0 || j < 0 || k < 0 || l < 0 || i1 < 0 || j1 < 0 || k1 < 0)
        {
            i.c("database.GroupDao", new Object[] {
                "[_get(Cursor)] ", "cursor.getColumnIndex() returned negative number"
            });
            cursor = null;
        } else
        {
            long l4 = cursor.getLong(l1);
            long l5 = cursor.getLong(i2);
            Object obj = cursor.getString(j2);
            String s = cursor.getString(k2);
            String s1 = cursor.getString(l2);
            String s2 = cursor.getString(i3);
            long l6 = cursor.getLong(j3);
            l1 = cursor.getInt(k3);
            long l7 = cursor.getLong(j);
            boolean flag;
            boolean flag1;
            if (cursor.getInt(k) == 0)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            if (cursor.getInt(l) == 0)
            {
                flag1 = false;
            } else
            {
                flag1 = true;
            }
            obj = new Group(l4, l5, ((String) (obj)), s, s1, s2, l6, l1, l7, flag, flag1, 0, cursor.getLong(i1), cursor.getString(j1), cursor.getString(k1));
            cursor = ((Cursor) (obj));
            if (i.a() <= 2)
            {
                i.a("database.GroupDao", new Object[] {
                    "[_get(Cursor)] ", "    group: ", ((Group) (obj)).toString()
                });
                i.a("database.GroupDao", new Object[] {
                    "[_get(Cursor)] ", "Iterating takes ", Double.valueOf((double)(System.currentTimeMillis() - l3) / 1000D), " seconds."
                });
                return ((Group) (obj));
            }
        }
        return cursor;
    }

    private Group a(String s, String as[])
    {
        long l;
        l = System.currentTimeMillis();
        s = b.query("CLGroup", a, s, as, null, null, null, e.c);
        if (s != null) goto _L2; else goto _L1
_L1:
        as = s;
        i.c("database.GroupDao", new Object[] {
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
        i.a("database.GroupDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        as = s;
        if (s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_164;
        }
        as = s;
        i.a("database.GroupDao", new Object[] {
            "[get(String, String[])] ", "Database has no records."
        });
        if (s != null)
        {
            s.close();
        }
        return null;
        as = s;
        Group group = a(((Cursor) (s)));
        as = group;
        if (s == null) goto _L4; else goto _L3
_L3:
        s.close();
        return group;
        Exception exception;
        exception;
        s = null;
_L8:
        as = s;
        ULogUtility.a("database.GroupDao", "[get(String, String[])] ", exception);
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
        if (i.a() <= 2)
        {
            i.a("database.GroupDao", new Object[] {
                "[update] ", "db.update to ", "CLGroup", ", id: ", s, ", values: ", contentvalues.toString()
            });
        }
        j = c.update("CLGroup", contentvalues, "GroupId=?", new String[] {
            s
        });
        if (j != 1)
        {
            try
            {
                i.c("database.GroupDao", new Object[] {
                    "[update] ", "update id: ", s, ", rowsAffected != 1, rowsAffected: ", Integer.valueOf(j)
                });
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                ULogUtility.a("database.GroupDao", "[update] ", s);
            }
        }
        d();
        return;
    }

    private void c(Group group)
    {
        group = group.a();
        group.remove("_id");
        long l;
        if (i.a() <= 2)
        {
            i.a("database.GroupDao", new Object[] {
                "[insert] ", "db.insert to ", "CLGroup", ": ", group.toString()
            });
        }
        l = c.insert("CLGroup", null, group);
        if (l < 0L)
        {
            try
            {
                i.c("database.GroupDao", new Object[] {
                    "[insert] ", "db.insert id: ", Long.valueOf(l)
                });
            }
            // Misplaced declaration of an exception variable
            catch (Group group)
            {
                ULogUtility.a("database.GroupDao", "[insert] ", group);
            }
        }
        d();
        return;
    }

    private void d()
    {
        d = null;
    }

    private List g(String s)
    {
        String s1;
        ArrayList arraylist;
        s1 = null;
        arraylist = new ArrayList();
        s = b.rawQuery(s, null);
        s1 = s;
        if (s1 != null) goto _L2; else goto _L1
_L1:
        Object obj = Collections.EMPTY_LIST;
        s = ((String) (obj));
        if (s1 != null)
        {
            s1.close();
            s = ((String) (obj));
        }
_L4:
        return s;
_L2:
        if (s1.getCount() > 0)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        s1.close();
        obj = Collections.EMPTY_LIST;
        s = ((String) (obj));
        if (s1 == null) goto _L4; else goto _L3
_L3:
        s1.close();
        return ((List) (obj));
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
        int i4;
        s1.moveToFirst();
        j = s1.getColumnIndex("_id");
        k = s1.getColumnIndex("GroupId");
        l = s1.getColumnIndex("GroupType");
        i1 = s1.getColumnIndex("DisplayName");
        j1 = s1.getColumnIndex("Jid");
        k1 = s1.getColumnIndex("Avatar");
        l1 = s1.getColumnIndex("LastModified");
        i2 = s1.getColumnIndex("NumberOfMember");
        j2 = s1.getColumnIndex("LastRead");
        k2 = s1.getColumnIndex("isDisabled");
        l2 = s1.getColumnIndex("isNotificationDisabled");
        i3 = s1.getColumnIndex("LastDeleteChatTime");
        j3 = s1.getColumnIndex("SendTime");
        k3 = s1.getColumnIndex("Cnt");
        l3 = s1.getColumnIndex("DraftText");
        i4 = s1.getColumnIndex("LastMsg");
        if (j >= 0 && k >= 0 && l >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0 && i2 >= 0 && j2 >= 0 && k2 >= 0 && l2 >= 0 && i3 >= 0 && j3 >= 0 && k3 >= 0 && l3 >= 0 && i4 >= 0)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        Log.e("database.GroupDao", "getAllGroupEx cursor.getColumnIndex() returned negative number");
        obj = Collections.EMPTY_LIST;
        s = ((String) (obj));
        if (s1 == null) goto _L4; else goto _L5
_L5:
        s1.close();
        return ((List) (obj));
        if (s1.getCount() > 0)
        {
            break MISSING_BLOCK_LABEL_395;
        }
        obj = Collections.EMPTY_LIST;
        s = ((String) (obj));
        if (s1 == null) goto _L4; else goto _L6
_L6:
        s1.close();
        return ((List) (obj));
_L8:
        String s2;
        String s3;
        int j4;
        long l4;
        long l5;
        long l6;
        long l7;
        l4 = s1.getLong(j);
        l5 = s1.getLong(k);
        s = s1.getString(l);
        obj = s1.getString(i1);
        s2 = s1.getString(j1);
        s3 = s1.getString(k1);
        l6 = s1.getLong(l1);
        j4 = s1.getInt(i2);
        l7 = s1.getLong(j2);
        long l8;
        long l9;
        boolean flag;
        boolean flag1;
        if (s1.getInt(k2) == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (s1.getInt(l2) == 0)
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        l8 = s1.getLong(i3);
        l9 = s1.getLong(j3);
        arraylist.add(new Group(l4, l5, s, ((String) (obj)), s2, s3, l6, j4, l7, flag, flag1, s1.getInt(k3), l8, l9, s1.getString(l3), s1.getString(i4)));
        flag = s1.moveToNext();
        if (flag) goto _L8; else goto _L7
_L7:
        s = arraylist;
        if (s1 == null) goto _L4; else goto _L9
_L9:
        s1.close();
        return arraylist;
        s;
_L13:
        ULogUtility.a("database.GroupDao", "[getAllGroupEx] ", s);
        s = arraylist;
        if (s1 == null) goto _L4; else goto _L10
_L10:
        s1.close();
        return arraylist;
        s;
        s1 = null;
_L12:
        if (s1 != null)
        {
            s1.close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L12; else goto _L11
_L11:
        s;
          goto _L13
    }

    private boolean h(String s)
    {
        int j = c.delete("CLGroup", "GroupId=?", new String[] {
            s
        });
        d();
        if (j != 1)
        {
            i.c("database.GroupDao", new Object[] {
                "[_delete] ", "delete groupId: ", s, ", rowsAffected != 1, rowsAffected: ", Integer.valueOf(j)
            });
            return false;
        } else
        {
            return true;
        }
    }

    public int a()
    {
        Object obj;
        Object obj1;
        int j;
        int k;
        boolean flag;
        int l;
        obj = null;
        obj1 = null;
        flag = false;
        l = 0;
        j = 0;
        k = l;
        Cursor cursor = b.rawQuery("Select COUNT(*) as cnt from CLGroup", null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        k = j;
        if (cursor != null)
        {
            cursor.close();
            k = j;
        }
_L4:
        return k;
_L2:
        k = l;
        obj1 = cursor;
        obj = cursor;
        if (cursor.getCount() > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        k = l;
        obj1 = cursor;
        obj = cursor;
        cursor.close();
        k = j;
        if (cursor != null)
        {
            cursor.close();
            return 0;
        }
        if (true) goto _L4; else goto _L3
_L3:
        k = l;
        obj1 = cursor;
        obj = cursor;
        cursor.moveToFirst();
        k = l;
        obj1 = cursor;
        obj = cursor;
        int i1 = cursor.getColumnIndex("cnt");
        if (i1 >= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = l;
        obj1 = cursor;
        obj = cursor;
        Log.e("database.GroupDao", "getAllGroupEx cursor.getColumnIndex() returned negative number");
        k = j;
        if (cursor != null)
        {
            cursor.close();
            return 0;
        }
        if (true) goto _L4; else goto _L5
_L5:
        k = l;
        obj1 = cursor;
        obj = cursor;
        l = cursor.getCount();
        k = ((flag) ? 1 : 0);
        if (l <= 0)
        {
            k = j;
            if (cursor != null)
            {
                cursor.close();
                return 0;
            }
            continue; /* Loop/switch isn't completed */
        }
_L7:
        obj = cursor;
        j = cursor.getInt(i1);
        k = j;
        obj1 = cursor;
        obj = cursor;
        boolean flag1 = cursor.moveToNext();
        k = j;
        if (flag1) goto _L7; else goto _L6
_L6:
        k = j;
        if (cursor != null)
        {
            cursor.close();
            return j;
        }
        if (true) goto _L4; else goto _L8
_L8:
        obj;
        cursor = ((Cursor) (obj1));
        obj1 = obj;
        j = k;
_L10:
        obj = cursor;
        ULogUtility.a("database.GroupDao", "[getAllGroupEx] ", ((Exception) (obj1)));
        k = j;
        if (cursor == null) goto _L4; else goto _L9
_L9:
        cursor.close();
        return j;
        Exception exception;
        exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        obj1;
        j = k;
          goto _L10
    }

    public Group a(String s)
    {
        return a("GroupId=?", new String[] {
            s
        });
    }

    public Group a(List list)
    {
        if (list == null || list.size() != 0) goto _L2; else goto _L1
_L1:
        list = null;
_L4:
        return list;
_L2:
        Object obj;
        Object obj1;
        obj = (new StringBuilder()).append("UserId=").append(String.valueOf(com.cyberlink.you.g.a().g())).toString();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Long long1 = (Long)iterator.next();
            obj = (new StringBuilder()).append(((String) (obj))).append(" or UserId=").append(long1).toString();
        }

        obj = (new StringBuilder()).append("Select cntA, cntB, D.* from ((Select GroupId, count(UserId) as cntA from GroupMember where ").append(((String) (obj))).append(" group by GroupId) A").append(" left join (Select GroupId, count(UserId) as cntB from GroupMember group by GroupId) B on A.GroupId=B.GroupId) C left join (Select * from CLGroup) D on C.GroupId=D.GroupId").toString();
        obj1 = null;
        obj = b.rawQuery(((String) (obj)), null);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        list = null;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return null;
        if (((Cursor) (obj)).getCount() > 0)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        ((Cursor) (obj)).close();
        list = null;
        if (obj == null) goto _L4; else goto _L5
_L5:
        ((Cursor) (obj)).close();
        return null;
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
        int i4;
        ((Cursor) (obj)).moveToFirst();
        j = ((Cursor) (obj)).getColumnIndex("cntA");
        k = ((Cursor) (obj)).getColumnIndex("cntB");
        l = ((Cursor) (obj)).getColumnIndex("_id");
        i1 = ((Cursor) (obj)).getColumnIndex("GroupId");
        j1 = ((Cursor) (obj)).getColumnIndex("GroupType");
        k1 = ((Cursor) (obj)).getColumnIndex("DisplayName");
        l1 = ((Cursor) (obj)).getColumnIndex("Jid");
        i2 = ((Cursor) (obj)).getColumnIndex("Avatar");
        j2 = ((Cursor) (obj)).getColumnIndex("LastModified");
        k2 = ((Cursor) (obj)).getColumnIndex("NumberOfMember");
        l2 = ((Cursor) (obj)).getColumnIndex("LastRead");
        i3 = ((Cursor) (obj)).getColumnIndex("isDisabled");
        j3 = ((Cursor) (obj)).getColumnIndex("isNotificationDisabled");
        k3 = ((Cursor) (obj)).getColumnIndex("LastDeleteChatTime");
        l3 = ((Cursor) (obj)).getColumnIndex("DraftText");
        i4 = ((Cursor) (obj)).getColumnIndex("LastMsg");
        if (l >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0 && i2 >= 0 && j2 >= 0 && k2 >= 0 && l2 >= 0 && i3 >= 0 && j3 >= 0 && k3 >= 0 && k >= 0 && j >= 0 && l3 >= 0 && i4 >= 0)
        {
            break MISSING_BLOCK_LABEL_469;
        }
        Log.e("database.GroupDao", "getAllGroupEx cursor.getColumnIndex() returned negative number");
        list = null;
        if (obj == null) goto _L4; else goto _L6
_L6:
        ((Cursor) (obj)).close();
        return null;
        int j4 = ((Cursor) (obj)).getCount();
        if (j4 > 0)
        {
            break MISSING_BLOCK_LABEL_851;
        }
        list = null;
        if (obj == null) goto _L4; else goto _L7
_L7:
        ((Cursor) (obj)).close();
        return null;
_L9:
        Object obj2;
        String s;
        String s1;
        String s2;
        int k4;
        int l4;
        long l5;
        long l6;
        long l7;
        long l8;
        j4 = ((Cursor) (obj)).getInt(j);
        k4 = ((Cursor) (obj)).getInt(k);
        l5 = ((Cursor) (obj)).getLong(l);
        l6 = ((Cursor) (obj)).getLong(i1);
        obj2 = ((Cursor) (obj)).getString(j1);
        s = ((Cursor) (obj)).getString(k1);
        s1 = ((Cursor) (obj)).getString(l1);
        s2 = ((Cursor) (obj)).getString(i2);
        l7 = ((Cursor) (obj)).getLong(j2);
        l4 = ((Cursor) (obj)).getInt(k2);
        l8 = ((Cursor) (obj)).getLong(l2);
        String s3;
        String s4;
        long l9;
        boolean flag;
        boolean flag1;
        if (((Cursor) (obj)).getInt(i3) == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (((Cursor) (obj)).getInt(j3) == 0)
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        l9 = ((Cursor) (obj)).getLong(k3);
        s3 = ((Cursor) (obj)).getString(l3);
        s4 = ((Cursor) (obj)).getString(i4);
        if (k4 != j4)
        {
            break MISSING_BLOCK_LABEL_726;
        }
        if (k4 != list.size() + 1)
        {
            break MISSING_BLOCK_LABEL_726;
        }
        obj2 = new Group(l5, l6, ((String) (obj2)), s, s1, s2, l7, l4, l8, flag, flag1, 0, l9, 0L, s3, s4);
        obj1 = obj2;
        flag = ((Cursor) (obj)).moveToNext();
        if (flag) goto _L9; else goto _L8
_L8:
        list = ((List) (obj1));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            return ((Group) (obj1));
        }
          goto _L4
        list;
        obj = null;
_L13:
        ULogUtility.a("database.GroupDao", "[getGroup] ", list);
        list = ((List) (obj));
        if (obj1 == null) goto _L4; else goto _L10
_L10:
        ((Cursor) (obj1)).close();
        return ((Group) (obj));
        list;
        obj = null;
_L12:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw list;
        list;
        continue; /* Loop/switch isn't completed */
        list;
        obj = obj1;
        if (true) goto _L12; else goto _L11
_L11:
        list;
        obj1 = obj;
        obj = null;
          goto _L13
        list;
        Object obj3 = obj;
        obj = obj1;
        obj1 = obj3;
          goto _L13
        list;
        Cursor cursor = ((Cursor) (obj));
        obj = obj1;
        obj1 = cursor;
          goto _L13
        obj1 = null;
          goto _L9
    }

    public List a(int j, int k)
    {
        return g((new StringBuilder()).append("Select G.*, SendTime, Cnt from (select * from CLGroup) G left join (select GroupId, Max(SendTime) as SendTime from Message where MessageType != 'Event' group by GroupId order by SendTime desc) N on G.GroupId = N.GroupId left join(Select U.*, U.GroupId as GroupId, Count(Mid) as Cnt from (Select H.GroupId, M.STime, M.MessageContent, MessageId as Mid from CLGroup H join (select GroupId, SendTime as STime, MessageId, MessageType, MessageContent from Message where MessageType != 'Event' and UserId != ").append(com.cyberlink.you.g.a().g()).append(" ) M ").append("on H.GroupId = M.GroupId and M.STime > H.LastRead) U group by GroupId) K on G.GroupId = K.GroupId order by SendTime desc").append(" limit ").append(String.valueOf(k)).append(" offset ").append(String.valueOf(j)).toString());
    }

    public void a(Group group)
    {
        if (group != null)
        {
            a(String.valueOf(group.b), group, Group.a);
        }
    }

    public void a(String s, Group group)
    {
        group = group.a();
        group.remove("_id");
        int j;
        if (i.a() <= 2)
        {
            i.a("database.GroupDao", new Object[] {
                "[update] ", "db.update to ", "CLGroup", ", id: ", s, ", values: ", group.toString()
            });
        }
        j = c.update("CLGroup", group, "GroupId=?", new String[] {
            s
        });
        if (j != 1)
        {
            try
            {
                i.c("database.GroupDao", new Object[] {
                    "[update] ", "update id: ", s, ", rowsAffected != 1, rowsAffected: ", Integer.valueOf(j)
                });
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                ULogUtility.a("database.GroupDao", "[update] ", s);
            }
        }
        d();
        return;
    }

    public void a(String s, Group group, String s1)
    {
        a(s, group.b(s1));
    }

    public void a(String s, Group group, List list)
    {
        a(s, group.a(list));
    }

    public boolean a(Group group, boolean flag)
    {
        Group group1 = a(String.valueOf(group.b));
        if (group1 == null)
        {
            c(group);
            return true;
        }
        group.k = group1.k;
        group.p = group1.p;
        if (flag || !group.h.equals(group1.h))
        {
            a(String.valueOf(group.b), group);
            return true;
        } else
        {
            return false;
        }
    }

    public Group b(String s)
    {
        return a("Jid=?", new String[] {
            s
        });
    }

    public List b()
    {
        return g((new StringBuilder()).append("Select G.*, SendTime, Cnt from (select * from CLGroup) G left join (select GroupId, Max(SendTime) as SendTime from Message where MessageType != 'Event' group by GroupId order by SendTime desc) N on G.GroupId = N.GroupId left join(Select U.*, U.GroupId as GroupId, Count(Mid) as Cnt from (Select H.GroupId, M.STime, M.MessageContent, MessageId as Mid from CLGroup H join (select GroupId, SendTime as STime, MessageId, MessageType, MessageContent from Message where MessageType != 'Event' and UserId != ").append(com.cyberlink.you.g.a().g()).append(" ) M ").append("on H.GroupId = M.GroupId and M.STime > H.LastRead) U group by GroupId) K on G.GroupId = K.GroupId order by SendTime desc").toString());
    }

    public boolean b(Group group)
    {
        return a(group, false);
    }

    public boolean b(List list)
    {
        list = list.iterator();
        boolean flag = false;
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Group group = (Group)list.next();
            if (group != null)
            {
                flag = b(group) | flag;
            }
        } while (true);
        return flag;
    }

    public Group c(String s)
    {
        return e((new StringBuilder()).append("Select Y.*, K.cnt as unread from CLGroup Y left join (Select U.*, U.GroupId as GroupId, Count(Mid) as Cnt from (Select G.GroupId, M.SendTime, M.MessageContent, MessageId as Mid from CLGroup G join (select GroupId, SendTime, MessageId, MessageType, MessageContent from Message where MessageType != 'Event' and UserId != ").append(com.cyberlink.you.g.a().g()).append(" ) M on G.GroupId = M.GroupId and M.SendTime > G.LastRead) U group by GroupId) K on Y.GroupId = K.GroupId ").append("where Y.Jid = '").append(s).append("'").toString());
    }

    public List c()
    {
        Object obj;
        Object obj3;
        obj = (new StringBuilder()).append("Select Y.*, K.cnt as unread from (select * from CLGroup) Y left join (Select U.*, U.GroupId as GroupId, Count(Mid) as Cnt from (Select G.GroupId, M.SendTime, M.MessageContent, MessageId as Mid from CLGroup G join (select GroupId, SendTime, MessageId, MessageType, MessageContent from Message where MessageType != 'Event' and UserId != ").append(com.cyberlink.you.g.a().g()).append(" ) M on G.GroupId = M.GroupId and M.SendTime > G.LastRead) U group by GroupId) K on Y.GroupId = K.GroupId").toString();
        obj3 = null;
        Object obj2 = b.rawQuery(((String) (obj)), null);
        if (obj2 != null) goto _L2; else goto _L1
_L1:
        obj3 = null;
        obj = obj3;
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
            obj = obj3;
        }
_L4:
        return ((List) (obj));
_L2:
        if (((Cursor) (obj2)).getCount() > 0)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        ((Cursor) (obj2)).close();
        obj = null;
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj2)).close();
        return null;
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
        ((Cursor) (obj2)).moveToFirst();
        j = ((Cursor) (obj2)).getColumnIndex("_id");
        k = ((Cursor) (obj2)).getColumnIndex("GroupId");
        l = ((Cursor) (obj2)).getColumnIndex("GroupType");
        i1 = ((Cursor) (obj2)).getColumnIndex("DisplayName");
        j1 = ((Cursor) (obj2)).getColumnIndex("Jid");
        k1 = ((Cursor) (obj2)).getColumnIndex("Avatar");
        l1 = ((Cursor) (obj2)).getColumnIndex("LastModified");
        i2 = ((Cursor) (obj2)).getColumnIndex("NumberOfMember");
        j2 = ((Cursor) (obj2)).getColumnIndex("LastRead");
        k2 = ((Cursor) (obj2)).getColumnIndex("isDisabled");
        l2 = ((Cursor) (obj2)).getColumnIndex("isNotificationDisabled");
        i3 = ((Cursor) (obj2)).getColumnIndex("unread");
        j3 = ((Cursor) (obj2)).getColumnIndex("LastDeleteChatTime");
        k3 = ((Cursor) (obj2)).getColumnIndex("DraftText");
        l3 = ((Cursor) (obj2)).getColumnIndex("LastMsg");
        if (j >= 0 && k >= 0 && l >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0 && i2 >= 0 && j2 >= 0 && k2 >= 0 && l2 >= 0 && i3 >= 0 && j3 >= 0 && k3 >= 0 && l3 >= 0)
        {
            break MISSING_BLOCK_LABEL_354;
        }
        Log.e("database.GroupDao", "getAllGroupEx cursor.getColumnIndex() returned negative number");
        obj = null;
        if (obj2 == null) goto _L4; else goto _L5
_L5:
        ((Cursor) (obj2)).close();
        return null;
        obj3 = new ArrayList();
_L7:
        String s;
        String s1;
        String s2;
        int i4;
        long l4;
        long l5;
        long l6;
        long l7;
        l4 = ((Cursor) (obj2)).getLong(j);
        l5 = ((Cursor) (obj2)).getLong(k);
        obj = ((Cursor) (obj2)).getString(l);
        s = ((Cursor) (obj2)).getString(i1);
        s1 = ((Cursor) (obj2)).getString(j1);
        s2 = ((Cursor) (obj2)).getString(k1);
        l6 = ((Cursor) (obj2)).getLong(l1);
        i4 = ((Cursor) (obj2)).getInt(i2);
        l7 = ((Cursor) (obj2)).getLong(j2);
        boolean flag;
        boolean flag1;
        if (((Cursor) (obj2)).getInt(k2) == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (((Cursor) (obj2)).getInt(l2) == 0)
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        ((List) (obj3)).add(new Group(l4, l5, ((String) (obj)), s, s1, s2, l6, i4, l7, flag, flag1, ((Cursor) (obj2)).getInt(i3), ((Cursor) (obj2)).getLong(j3), ((Cursor) (obj2)).getString(k3), ((Cursor) (obj2)).getString(l3)));
        flag = ((Cursor) (obj2)).moveToNext();
        if (flag) goto _L7; else goto _L6
_L6:
        obj = obj3;
        if (obj2 == null) goto _L4; else goto _L8
_L8:
        ((Cursor) (obj2)).close();
        return ((List) (obj3));
        Object obj1;
        obj1;
        obj2 = null;
_L12:
        ((Exception) (obj1)).printStackTrace();
        ULogUtility.a("database.GroupDao", "[getAllGroupBadge] ", ((Exception) (obj1)));
        obj1 = obj2;
        if (obj3 == null) goto _L4; else goto _L9
_L9:
        ((Cursor) (obj3)).close();
        return ((List) (obj2));
        obj1;
        obj2 = null;
_L11:
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        throw obj1;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj2 = obj3;
        if (true) goto _L11; else goto _L10
_L10:
        obj1;
        obj3 = obj2;
        obj2 = null;
          goto _L12
        obj1;
        Cursor cursor = ((Cursor) (obj2));
        obj2 = obj3;
        obj3 = cursor;
          goto _L12
    }

    public Group d(String s)
    {
        return e((new StringBuilder()).append("Select Y.*, K.cnt as unread from (select * from CLGroup) Y left join (Select U.*, U.GroupId as GroupId, Count(Mid) as Cnt from (Select G.GroupId, M.SendTime, M.MessageContent, MessageId as Mid from CLGroup G join (select GroupId, SendTime, MessageId, MessageType, MessageContent from Message where MessageType != 'Event' and UserId != ").append(com.cyberlink.you.g.a().g()).append(" ) M on G.GroupId = M.GroupId and M.SendTime > G.LastRead) U group by GroupId) K on Y.GroupId = K.GroupId ").append("where Y.GroupId = ").append(s).toString());
    }

    public Group e(String s)
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj1 = null;
        obj2 = null;
        obj = null;
        s = b.rawQuery(s, null);
        obj = s;
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj1 = null;
        s = ((String) (obj1));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            s = ((String) (obj1));
        }
_L4:
        return s;
_L2:
        obj1 = obj2;
        if (((Cursor) (obj)).getCount() > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        obj1 = obj2;
        ((Cursor) (obj)).close();
        s = null;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj1 = obj2;
        ((Cursor) (obj)).moveToFirst();
        obj1 = obj2;
        int j = ((Cursor) (obj)).getColumnIndex("_id");
        obj1 = obj2;
        int k = ((Cursor) (obj)).getColumnIndex("GroupId");
        obj1 = obj2;
        int l = ((Cursor) (obj)).getColumnIndex("GroupType");
        obj1 = obj2;
        int i1 = ((Cursor) (obj)).getColumnIndex("DisplayName");
        obj1 = obj2;
        int j1 = ((Cursor) (obj)).getColumnIndex("Jid");
        obj1 = obj2;
        int k1 = ((Cursor) (obj)).getColumnIndex("Avatar");
        obj1 = obj2;
        int l1 = ((Cursor) (obj)).getColumnIndex("LastModified");
        obj1 = obj2;
        int i2 = ((Cursor) (obj)).getColumnIndex("NumberOfMember");
        obj1 = obj2;
        int j2 = ((Cursor) (obj)).getColumnIndex("LastRead");
        obj1 = obj2;
        int k2 = ((Cursor) (obj)).getColumnIndex("isDisabled");
        obj1 = obj2;
        int l2 = ((Cursor) (obj)).getColumnIndex("isNotificationDisabled");
        obj1 = obj2;
        int i3 = ((Cursor) (obj)).getColumnIndex("unread");
        obj1 = obj2;
        int j3 = ((Cursor) (obj)).getColumnIndex("LastDeleteChatTime");
        obj1 = obj2;
        int k3 = ((Cursor) (obj)).getColumnIndex("DraftText");
        obj1 = obj2;
        int l3 = ((Cursor) (obj)).getColumnIndex("LastMsg");
        if (j >= 0 && k >= 0 && l >= 0 && i1 >= 0 && j1 >= 0 && k1 >= 0 && l1 >= 0 && i2 >= 0 && j2 >= 0 && k2 >= 0 && l2 >= 0 && i3 >= 0 && j3 >= 0 && k3 >= 0 && l3 >= 0)
        {
            break MISSING_BLOCK_LABEL_686;
        }
        obj1 = obj2;
        Log.e("database.GroupDao", "getAllGroupEx cursor.getColumnIndex() returned negative number");
        s = null;
        if (obj == null) goto _L4; else goto _L5
_L5:
        ((Cursor) (obj)).close();
        return null;
_L7:
        s = ((String) (obj2));
_L13:
        String s1;
        String s2;
        int i4;
        long l4;
        long l5;
        long l6;
        long l7;
        l4 = ((Cursor) (obj)).getLong(j);
        l5 = ((Cursor) (obj)).getLong(k);
        obj1 = ((Cursor) (obj)).getString(l);
        obj2 = ((Cursor) (obj)).getString(i1);
        s1 = ((Cursor) (obj)).getString(j1);
        s2 = ((Cursor) (obj)).getString(k1);
        l6 = ((Cursor) (obj)).getLong(l1);
        i4 = ((Cursor) (obj)).getInt(i2);
        l7 = ((Cursor) (obj)).getLong(j2);
        boolean flag;
        boolean flag1;
        if (((Cursor) (obj)).getInt(k2) == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (((Cursor) (obj)).getInt(l2) == 0)
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        obj2 = new Group(l4, l5, ((String) (obj1)), ((String) (obj2)), s1, s2, l6, i4, l7, flag, flag1, ((Cursor) (obj)).getInt(i3), ((Cursor) (obj)).getLong(j3), ((Cursor) (obj)).getString(k3), ((Cursor) (obj)).getString(l3));
        obj1 = obj2;
        flag = ((Cursor) (obj)).moveToNext();
        if (flag) goto _L7; else goto _L6
_L6:
        s = ((String) (obj2));
        if (obj == null) goto _L4; else goto _L8
_L8:
        ((Cursor) (obj)).close();
        return ((Group) (obj2));
        s;
_L12:
        s.printStackTrace();
        s = ((String) (obj));
        if (obj1 == null) goto _L4; else goto _L9
_L9:
        ((Cursor) (obj1)).close();
        return ((Group) (obj));
        s;
        obj = null;
_L11:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        obj = obj1;
        if (true) goto _L11; else goto _L10
_L10:
        s;
        Object obj3 = obj;
        obj = obj1;
        obj1 = obj3;
          goto _L12
        Exception exception;
        exception;
        obj1 = s;
        Object obj4 = obj;
        s = exception;
        obj = obj1;
        obj1 = obj4;
          goto _L12
        s = null;
          goto _L13
    }

    public boolean f(String s)
    {
        return h(s);
    }

}

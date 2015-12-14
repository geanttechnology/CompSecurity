// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.you.e;
import com.cyberlink.you.g;
import com.cyberlink.you.i;
import com.cyberlink.you.utility.ULogUtility;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.you.database:
//            MessageObj

public class f
{

    private static final String a[] = {
        "_id", "MessageId", "GroupId", "SendTime", "MessageType", "MessageContent", "ReadCount", "UserId", "Status", "MemberStatus", 
        "IsNewVersion", "SrcXml", "UploadStatus"
    };
    private static final String b;
    private static final String c = (new StringBuilder()).append("Status='").append("6".toString()).append("'").toString();
    private static final String d;
    private static final String e;
    private static final String f = (new StringBuilder()).append("GroupId=? AND UserId!=? AND (").append(c).append(" OR ").append("Status").append("='").append("0".toString()).append("')").toString();
    private static final String g;
    private final SQLiteDatabase h = com.cyberlink.you.e.a();
    private final SQLiteDatabase i = com.cyberlink.you.e.b();

    public f()
    {
    }

    private MessageObj a(Cursor cursor)
    {
        long l3 = System.currentTimeMillis();
        int l1 = cursor.getColumnIndex("_id");
        int i2 = cursor.getColumnIndex("MessageId");
        int j2 = cursor.getColumnIndex("GroupId");
        int k2 = cursor.getColumnIndex("SendTime");
        int l2 = cursor.getColumnIndex("MessageType");
        int i3 = cursor.getColumnIndex("MessageContent");
        int j3 = cursor.getColumnIndex("ReadCount");
        int j = cursor.getColumnIndex("UserId");
        int k = cursor.getColumnIndex("Status");
        int l = cursor.getColumnIndex("MemberStatus");
        int i1 = cursor.getColumnIndex("IsNewVersion");
        int j1 = cursor.getColumnIndex("SrcXml");
        int k1 = cursor.getColumnIndex("UploadStatus");
        Object obj;
        if (l1 < 0 || i2 < 0 || j2 < 0 || k2 < 0 || l2 < 0 || i3 < 0 || j3 < 0 || j < 0 || k < 0 || l < 0 || i1 < 0 || j1 < 0 || k1 < 0)
        {
            com.cyberlink.you.i.c("database.MessageDao", new Object[] {
                "[_get(Cursor)] ", "cursor.getColumnIndex() returned negative number"
            });
            obj = null;
        } else
        {
            long l4 = cursor.getLong(l1);
            obj = cursor.getString(i2);
            String s = cursor.getString(j2);
            long l5 = cursor.getLong(k2);
            String s6 = cursor.getString(l2);
            String s1 = cursor.getString(i3);
            l1 = cursor.getInt(j3);
            String s2 = cursor.getString(j);
            String s3 = cursor.getString(k);
            String s7 = cursor.getString(l);
            String s4;
            String s5;
            boolean flag;
            if (cursor.getInt(i1) == 0)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            s4 = cursor.getString(j1);
            s5 = cursor.getString(k1);
            try
            {
                cursor = new MessageObj(l4, ((String) (obj)), s, l5, MessageObj.MessageType.valueOf(s6), s1, l1, s2, s3, MessageObj.MemberStatus.valueOf(s7), flag, s4, s5);
            }
            // Misplaced declaration of an exception variable
            catch (Cursor cursor)
            {
                cursor = new MessageObj(l4, ((String) (obj)), s, l5, MessageObj.MessageType.j, s1, l1, s2, s3, MessageObj.MemberStatus.a, true, s4, s5);
            }
            obj = cursor;
            if (com.cyberlink.you.i.a() <= 2)
            {
                com.cyberlink.you.i.a("database.MessageDao", new Object[] {
                    "[_get(Cursor)] ", "    messageObj: ", cursor.toString()
                });
                com.cyberlink.you.i.a("database.MessageDao", new Object[] {
                    "[_get(Cursor)] ", "Iterating takes ", Double.valueOf((double)(System.currentTimeMillis() - l3) / 1000D), " seconds."
                });
                return cursor;
            }
        }
        return ((MessageObj) (obj));
    }

    private MessageObj a(String s, String as[], String s1)
    {
        long l;
        l = System.currentTimeMillis();
        as = h.query("Message", a, s, as, null, null, s1, e.c);
        if (as != null) goto _L2; else goto _L1
_L1:
        s = as;
        com.cyberlink.you.i.c("database.MessageDao", new Object[] {
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
        if (com.cyberlink.you.i.a() > 2)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        s = as;
        com.cyberlink.you.i.a("database.MessageDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        s = as;
        if (as.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        s = as;
        com.cyberlink.you.i.a("database.MessageDao", new Object[] {
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
        ULogUtility.a("database.MessageDao", "[get(String, String[])] ", s1);
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

    private List a(String s, String as[], int j)
    {
        long l = System.currentTimeMillis();
        if (j != 0) goto _L2; else goto _L1
_L1:
        s = h.query("Message", a, s, as, null, null, "SendTime ASC");
_L5:
        if (s != null) goto _L4; else goto _L3
_L3:
        as = s;
        com.cyberlink.you.i.c("database.MessageDao", new Object[] {
            "[get(String, String[])] ", "Failed to query: cursor is null"
        });
        Object obj = null;
        as = obj;
        if (s != null)
        {
            s.close();
            as = obj;
        }
_L6:
        return as;
_L2:
        s = h.query("Message", a, s, as, null, null, "SendTime DESC", String.valueOf(j));
          goto _L5
_L4:
        as = s;
        if (com.cyberlink.you.i.a() > 2)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        as = s;
        com.cyberlink.you.i.a("database.MessageDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        as = s;
        if (s.getCount() > 0)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        as = s;
        com.cyberlink.you.i.a("database.MessageDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        as = s;
        if (s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_256;
        }
        as = s;
        com.cyberlink.you.i.a("database.MessageDao", new Object[] {
            "[get(String, String[])] ", "Database has no records."
        });
        as = null;
        if (s != null)
        {
            s.close();
            return null;
        }
          goto _L6
        as = s;
        ArrayList arraylist = new ArrayList();
_L8:
        as = s;
        arraylist.add(a(((Cursor) (s))));
        as = s;
        boolean flag = s.moveToNext();
        if (flag) goto _L8; else goto _L7
_L7:
        as = arraylist;
        if (s != null)
        {
            s.close();
            return arraylist;
        }
          goto _L6
        Exception exception;
        exception;
        s = null;
_L12:
        as = s;
        ULogUtility.a("database.MessageDao", "[get(String, String[])] ", exception);
        as = null;
        if (s == null) goto _L6; else goto _L9
_L9:
        s.close();
        return null;
        s;
        as = null;
_L11:
        if (as != null)
        {
            as.close();
        }
        throw s;
        s;
        if (true) goto _L11; else goto _L10
_L10:
        exception;
          goto _L12
    }

    private void a(String s, ContentValues contentvalues)
    {
        int j;
        try
        {
            if (com.cyberlink.you.i.a() <= 2)
            {
                com.cyberlink.you.i.a("database.MessageDao", new Object[] {
                    "[update] ", "db.update to ", "Message", ", id: ", s, ", values: ", contentvalues.toString()
                });
            }
            j = i.update("Message", contentvalues, "MessageId=?", new String[] {
                s
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ULogUtility.a("database.MessageDao", "[update] ", s);
            return;
        }
        if (j == 1)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        com.cyberlink.you.i.c("database.MessageDao", new Object[] {
            "[update] ", "update id: ", s, ", rowsAffected != 1, rowsAffected: ", Integer.valueOf(j)
        });
    }

    private boolean g(String s)
    {
        int j = i.delete("Message", "MessageId=?", new String[] {
            s
        });
        if (j != 1)
        {
            com.cyberlink.you.i.c("database.MessageDao", new Object[] {
                "[_delete] ", "delete messageId: ", s, ", rowsAffected != 1, rowsAffected: ", Integer.valueOf(j)
            });
            return false;
        } else
        {
            return true;
        }
    }

    private boolean h(String s)
    {
        int j = i.delete("Message", "GroupId=?", new String[] {
            s
        });
        if (j != 1)
        {
            com.cyberlink.you.i.c("database.MessageDao", new Object[] {
                "[_delete] ", "delete messageId: ", s, ", rowsAffected != 1, rowsAffected: ", Integer.valueOf(j)
            });
            return false;
        } else
        {
            return true;
        }
    }

    public MessageObj a()
    {
        return a(b, ((String []) (null)), "SendTime DESC");
    }

    public MessageObj a(String s)
    {
        return a("MessageId=?", new String[] {
            s
        }, ((String) (null)));
    }

    public List a(String s, String s1)
    {
        String s2 = (new StringBuilder()).append("GroupId=? AND MessageType != '").append(MessageObj.MessageType.h.toString()).append("' AND (").append("Status").append("='").append("0".toString()).append("' OR ").append("Status").append("='").append("10".toString()).append("' OR ").append("Status").append("='").append("6".toString()).append("' OR ").append("Status").append("='").append("5".toString()).append("')").toString();
        if (s1 != null)
        {
            return a((new StringBuilder()).append(s2).append(" AND SendTime <?").toString(), new String[] {
                s, s1
            }, 100);
        } else
        {
            return a(s2, new String[] {
                s
            }, 100);
        }
    }

    public void a(MessageObj messageobj)
    {
        messageobj = messageobj.o();
        messageobj.remove("_id");
        long l;
        try
        {
            if (com.cyberlink.you.i.a() <= 2)
            {
                com.cyberlink.you.i.a("database.MessageDao", new Object[] {
                    "[insert] ", "db.insert to ", "Message", ": ", messageobj.toString()
                });
            }
            l = i.insert("Message", null, messageobj);
        }
        // Misplaced declaration of an exception variable
        catch (MessageObj messageobj)
        {
            ULogUtility.a("database.MessageDao", "[insert] ", messageobj);
            return;
        }
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        com.cyberlink.you.i.c("database.MessageDao", new Object[] {
            "[insert] ", "db.insert id: ", Long.valueOf(l)
        });
    }

    public void a(String s, MessageObj messageobj, String s1)
    {
        a(s, messageobj.d(s1));
    }

    public void a(String s, MessageObj messageobj, List list)
    {
        a(s, messageobj.a(list));
    }

    public MessageObj b(String s)
    {
        return a(e, new String[] {
            s
        }, "SendTime DESC");
    }

    public List b()
    {
        return a((new StringBuilder()).append("UserId=? AND ((Status='").append("2".toString()).append("' AND ").append("UploadStatus").append("<>'").append("1".toString()).append("' AND ").append("UploadStatus").append("<>'").append("4".toString()).append("') OR ").append("Status").append("='").append("3".toString()).append("')").toString(), new String[] {
            String.valueOf(com.cyberlink.you.g.a().g())
        }, 0);
    }

    public List b(String s, String s1)
    {
        return a((new StringBuilder()).append(d).append(" AND ").append("UserId").append(" != ").append(com.cyberlink.you.g.a().g()).toString(), new String[] {
            s, s1
        }, 0);
    }

    public List c(String s)
    {
        return a(f, new String[] {
            s, String.valueOf(com.cyberlink.you.g.a().g())
        }, 0);
    }

    public List d(String s)
    {
        return a((new StringBuilder()).append("UserId=? AND GroupId=? AND (Status='").append("2".toString()).append("' OR ").append("Status").append("='").append("3".toString()).append("')").toString(), new String[] {
            String.valueOf(com.cyberlink.you.g.a().g()), s
        }, 0);
    }

    public boolean e(String s)
    {
        return g(s);
    }

    public boolean f(String s)
    {
        return h(s);
    }

    static 
    {
        b = (new StringBuilder()).append("NOT MessageType='").append(MessageObj.MessageType.h.toString()).append("'").toString();
        d = (new StringBuilder()).append("GroupId=? AND SendTime>? AND ").append(b).toString();
        e = (new StringBuilder()).append("GroupId=? AND ").append(b).toString();
        g = (new StringBuilder()).append("select max(SendTime) as SendTime, _id, MessageId, GroupId, MessageType, MessageContent, ReadCount, UserId, Status, MemberStatus, IsNewVersion, SrcXml, UploadStatus from Message where MessageType <> '").append(MessageObj.MessageType.h.toString()).append("'").append(" group by ").append("GroupId").toString();
    }
}

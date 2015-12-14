// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.you.e;
import com.cyberlink.you.i;
import com.cyberlink.you.utility.ULogUtility;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.you.database:
//            i

public class h
{

    private static final String a[] = {
        "MessageId", "UserId"
    };
    private final SQLiteDatabase b = e.a();
    private final SQLiteDatabase c = e.b();

    public h()
    {
    }

    private com.cyberlink.you.database.i a(Cursor cursor)
    {
        long l1 = System.currentTimeMillis();
        int k = cursor.getColumnIndex("MessageId");
        int l = cursor.getColumnIndex("UserId");
        if (k < 0 || l < 0)
        {
            i.c("database.RecvReceiptDao", new Object[] {
                "[_get(Cursor)] ", "cursor.getColumnIndex() returned negative number"
            });
            cursor = null;
        } else
        {
            com.cyberlink.you.database.i j = new com.cyberlink.you.database.i(cursor.getString(k), cursor.getString(l));
            cursor = j;
            if (i.a() <= 2)
            {
                i.a("database.RecvReceiptDao", new Object[] {
                    "[_get(Cursor)] ", "    recvReceiptObj: ", j.toString()
                });
                i.a("database.RecvReceiptDao", new Object[] {
                    "[_get(Cursor)] ", "Iterating takes ", Double.valueOf((double)(System.currentTimeMillis() - l1) / 1000D), " seconds."
                });
                return j;
            }
        }
        return cursor;
    }

    private com.cyberlink.you.database.i a(String s, String as[], String s1)
    {
        long l;
        l = System.currentTimeMillis();
        as = b.query("RecvReceipt", a, s, as, null, null, s1, e.c);
        if (as != null) goto _L2; else goto _L1
_L1:
        s = as;
        i.c("database.RecvReceiptDao", new Object[] {
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
        i.a("database.RecvReceiptDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        s = as;
        if (as.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        s = as;
        i.a("database.RecvReceiptDao", new Object[] {
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
        ULogUtility.a("database.RecvReceiptDao", "[get(String, String[])] ", s1);
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

    private List b(String s, String as[], String s1)
    {
        long l;
        l = System.currentTimeMillis();
        as = b.query("RecvReceipt", a, s, as, null, null, s1);
        if (as != null) goto _L2; else goto _L1
_L1:
        s = as;
        i.c("database.RecvReceiptDao", new Object[] {
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
            break MISSING_BLOCK_LABEL_120;
        }
        s = as;
        i.a("database.RecvReceiptDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        s = as;
        if (as.getCount() > 0)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        s = as;
        i.a("database.RecvReceiptDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        s = as;
        if (as.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        s = as;
        i.a("database.RecvReceiptDao", new Object[] {
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
        s1 = new ArrayList();
_L6:
        s = as;
        s1.add(a(as));
        s = as;
        boolean flag = as.moveToNext();
        if (flag) goto _L6; else goto _L5
_L5:
        s = s1;
        if (as == null) goto _L4; else goto _L7
_L7:
        as.close();
        return s1;
        s1;
        as = null;
_L11:
        s = as;
        ULogUtility.a("database.RecvReceiptDao", "[get(String, String[])] ", s1);
        s = null;
        if (as == null) goto _L4; else goto _L8
_L8:
        as.close();
        return null;
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
        s1;
          goto _L11
    }

    public com.cyberlink.you.database.i a(String s, String s1)
    {
        return a("MessageId=? AND UserId=?", new String[] {
            s, s1
        }, null);
    }

    public List a(String s)
    {
        return b("MessageId=?", new String[] {
            s
        }, null);
    }

    public void a(com.cyberlink.you.database.i j)
    {
        j = j.c();
        j.remove("_id");
        long l;
        try
        {
            if (i.a() <= 2)
            {
                i.a("database.RecvReceiptDao", new Object[] {
                    "[insert] ", "db.insert to ", "RecvReceipt", ": ", j.toString()
                });
            }
            l = c.insert("RecvReceipt", null, j);
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.you.database.i j)
        {
            ULogUtility.a("database.RecvReceiptDao", "[insert] ", j);
            return;
        }
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        i.c("database.RecvReceiptDao", new Object[] {
            "[insert] ", "db.insert id: ", Long.valueOf(l)
        });
    }

    public int b(String s)
    {
        s = a(s);
        if (s != null)
        {
            return s.size();
        } else
        {
            return 0;
        }
    }

}

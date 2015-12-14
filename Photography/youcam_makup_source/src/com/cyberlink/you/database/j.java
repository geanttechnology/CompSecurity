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
//            k

public class j
{

    private static final String a[] = {
        "_id", "MessageId", "ReceiptId", "Status"
    };
    private final SQLiteDatabase b = e.a();
    private final SQLiteDatabase c = e.b();

    public j()
    {
    }

    private k a(Cursor cursor)
    {
        long l2 = System.currentTimeMillis();
        int l = cursor.getColumnIndex("_id");
        int i1 = cursor.getColumnIndex("MessageId");
        int j1 = cursor.getColumnIndex("ReceiptId");
        int l1 = cursor.getColumnIndex("Status");
        if (l < 0 || i1 < 0 || j1 < 0 || l1 < 0)
        {
            i.c("database.SendReceiptDao", new Object[] {
                "[_get(Cursor)] ", "cursor.getColumnIndex() returned negative number"
            });
            cursor = null;
        } else
        {
            k k1 = new k(cursor.getString(i1), cursor.getString(j1), cursor.getString(l1));
            cursor = k1;
            if (i.a() <= 2)
            {
                i.a("database.SendReceiptDao", new Object[] {
                    "[_get(Cursor)] ", "    sendReceiptObj: ", k1.toString()
                });
                i.a("database.SendReceiptDao", new Object[] {
                    "[_get(Cursor)] ", "Iterating takes ", Double.valueOf((double)(System.currentTimeMillis() - l2) / 1000D), " seconds."
                });
                return k1;
            }
        }
        return cursor;
    }

    private k a(String s, String as[], String s1)
    {
        long l;
        l = System.currentTimeMillis();
        as = b.query("SendReceipt", a, s, as, null, null, s1, e.c);
        if (as != null) goto _L2; else goto _L1
_L1:
        s = as;
        i.c("database.SendReceiptDao", new Object[] {
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
        i.a("database.SendReceiptDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l) / 1000D), " seconds."
        });
        s = as;
        if (as.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        s = as;
        i.a("database.SendReceiptDao", new Object[] {
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
        ULogUtility.a("database.SendReceiptDao", "[get(String, String[])] ", s1);
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

    private List a(String s, String as[], int l)
    {
        Object obj1;
        String as1[];
        long l1;
        l1 = System.currentTimeMillis();
        obj1 = b;
        as1 = a;
        Object obj;
        if (l == 0)
        {
            obj = null;
        } else
        {
            obj = String.valueOf(l);
        }
        as = ((SQLiteDatabase) (obj1)).query("SendReceipt", as1, s, as, null, null, null, ((String) (obj)));
        if (as != null) goto _L2; else goto _L1
_L1:
        s = as;
        i.c("database.SendReceiptDao", new Object[] {
            "[get(String, String[])] ", "Failed to query: cursor is null"
        });
        obj = null;
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
            break MISSING_BLOCK_LABEL_149;
        }
        s = as;
        i.a("database.SendReceiptDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l1) / 1000D), " seconds."
        });
        s = as;
        if (as.getCount() > 0)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        s = as;
        i.a("database.SendReceiptDao", new Object[] {
            "[get(String, String[])] ", "Querying takes ", Double.valueOf((double)(System.currentTimeMillis() - l1) / 1000D), " seconds."
        });
        s = as;
        if (as.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        s = as;
        i.a("database.SendReceiptDao", new Object[] {
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
        obj = new ArrayList();
_L6:
        s = as;
        obj1 = a(((Cursor) (as)));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_288;
        }
        s = as;
        ((List) (obj)).add(obj1);
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
        ULogUtility.a("database.SendReceiptDao", "[get(String, String[])] ", exception);
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
        exception;
          goto _L11
    }

    private boolean a(String s, boolean flag)
    {
        int l = c.delete("SendReceipt", "MessageId=?", new String[] {
            s
        });
        if (!flag && l != 1)
        {
            i.c("database.SendReceiptDao", new Object[] {
                "[_delete] ", "delete messageId: ", s, ", rowsAffected != 1, rowsAffected: ", Integer.valueOf(l)
            });
            return false;
        } else
        {
            return true;
        }
    }

    public k a(String s)
    {
        return a("ReceiptId=?", new String[] {
            s
        }, ((String) (null)));
    }

    public List a()
    {
        return a(null, null, 0);
    }

    public void a(k k1)
    {
        k1 = k1.d();
        k1.remove("_id");
        long l;
        try
        {
            if (i.a() <= 2)
            {
                i.a("database.SendReceiptDao", new Object[] {
                    "[insert] ", "db.insert to ", "SendReceipt", ": ", k1.toString()
                });
            }
            l = c.insert("SendReceipt", null, k1);
        }
        // Misplaced declaration of an exception variable
        catch (k k1)
        {
            ULogUtility.a("database.SendReceiptDao", "[insert] ", k1);
            return;
        }
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        i.c("database.SendReceiptDao", new Object[] {
            "[insert] ", "db.insert id: ", Long.valueOf(l)
        });
    }

    public boolean b(String s)
    {
        return a(s, false);
    }

    public boolean c(String s)
    {
        return a(s, true);
    }

}

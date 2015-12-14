// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

// Referenced classes of package com.tencent.mm.sdk.storage:
//            MStorage, ISQLiteDatabase, MAutoDBItem

public abstract class MAutoStorage extends MStorage
{

    private ISQLiteDatabase P;
    private final String bL;
    private final String columns[] = getColumns();

    public MAutoStorage(ISQLiteDatabase isqlitedatabase)
    {
        P = isqlitedatabase;
        if (Util.isNullOrNil(getPrimaryKey()))
        {
            isqlitedatabase = "rowid";
        } else
        {
            isqlitedatabase = getPrimaryKey();
        }
        bL = isqlitedatabase;
    }

    private static transient StringBuilder a(ContentValues contentvalues, String as[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            stringbuilder.append((new StringBuilder()).append(s).append(" = ? AND ").toString());
            if (contentvalues.get(s) == null)
            {
                return null;
            }
        }

        stringbuilder.append(" 1=1");
        return stringbuilder;
    }

    private boolean a(ContentValues contentvalues)
    {
        Cursor cursor = P.query(getTableName(), columns, (new StringBuilder()).append(bL).append(" = ?").toString(), new String[] {
            Util.nullAsNil(contentvalues.getAsString(bL))
        }, null, null, null);
        boolean flag = MAutoDBItem.checkIOEqual(contentvalues, cursor);
        cursor.close();
        return flag;
    }

    private static String[] a(String as[], ContentValues contentvalues)
    {
        String as1[] = new String[as.length];
        for (int i = 0; i < as1.length; i++)
        {
            as1[i] = Util.nullAsNil(contentvalues.getAsString(as[i]));
        }

        return as1;
    }

    private void d(String s)
    {
        Log.d("MicroMsg.SDK.MAutoStorage", (new StringBuilder()).append(getTableName()).append(":").append(s).toString());
    }

    private void e(String s)
    {
        Log.e("MicroMsg.SDK.MAutoStorage", (new StringBuilder()).append(getTableName()).append(":").append(s).toString());
    }

    public static transient List getCreateSQLs(Field afield[], String s, String s1, String as[])
    {
        LinkedList linkedlist = new LinkedList();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder("CREATE TABLE IF NOT EXISTS ")).append(s).append(" ( ").toString());
        afield = MAutoDBItem.identify(afield, stringbuilder, s1);
        stringbuilder.append(");");
        linkedlist.addFirst(stringbuilder.toString());
        if (as != null && as.length > 0)
        {
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                s1 = as[i];
                if (s1 == null || s1.length() <= 0)
                {
                    continue;
                }
                if (afield.get(s1) == null)
                {
                    Log.e("MicroMsg.SDK.MAutoStorage", (new StringBuilder("skipped invalid index: ")).append(s1).append(", not found in fields").toString());
                }
                linkedlist.add((new StringBuilder("CREATE INDEX IF NOT EXISTS _mindex_")).append(s).append("_").append(s1).append("_ ON ").append(s).append("(").append(s1).append(");").toString());
            }

        }
        return linkedlist;
    }

    public static List getUpdateSQLs(Field afield[], String s, ISQLiteDatabase isqlitedatabase)
    {
        LinkedList linkedlist = new LinkedList();
        HashMap hashmap = new HashMap();
        for (isqlitedatabase = isqlitedatabase.rawQuery((new StringBuilder("PRAGMA table_info( ")).append(s).append(" )").toString(), null); isqlitedatabase.moveToNext(); hashmap.put(isqlitedatabase.getString(isqlitedatabase.getColumnIndex("name")), isqlitedatabase.getString(isqlitedatabase.getColumnIndex("type")))) { }
        isqlitedatabase.close();
        afield = MAutoDBItem.identify(afield, null, null).entrySet().iterator();
        do
        {
            if (!afield.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)afield.next();
            isqlitedatabase = (String)((java.util.Map.Entry) (obj)).getValue();
            obj = (String)((java.util.Map.Entry) (obj)).getKey();
            boolean flag;
            boolean flag1;
            if (isqlitedatabase == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (isqlitedatabase.length() <= 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!(flag | flag1))
            {
                String s1 = (String)hashmap.get(obj);
                if (s1 == null)
                {
                    linkedlist.add((new StringBuilder("ALTER TABLE ")).append(s).append(" ADD COLUMN ").append(((String) (obj))).append(" ").append(isqlitedatabase).append(";").toString());
                    hashmap.remove(obj);
                } else
                if (!s1.equalsIgnoreCase(isqlitedatabase))
                {
                    Log.e("MicroMsg.SDK.MAutoStorage", (new StringBuilder("conflicting alter table on column: ")).append(((String) (obj))).append(", ").append(s1).append("<o-n>").append(isqlitedatabase).toString());
                    hashmap.remove(obj);
                }
            }
        } while (true);
        return linkedlist;
    }

    public boolean delete(long l)
    {
        boolean flag = true;
        if (P.delete(getTableName(), "rowid = ?", new String[] {
    String.valueOf(l)
}) <= 0)
        {
            flag = false;
        }
        if (flag)
        {
            notify();
        }
        return flag;
    }

    public transient boolean delete(MAutoDBItem mautodbitem, String as[])
    {
        boolean flag = false;
        boolean flag1 = false;
        mautodbitem = mautodbitem.convertTo();
        if (mautodbitem == null || mautodbitem.size() <= 0)
        {
            e("delete failed, value.size <= 0");
        } else
        if (as == null || as.length <= 0)
        {
            d("delete with primary key");
            if (P.delete(getTableName(), (new StringBuilder()).append(bL).append(" = ?").toString(), new String[] {
    Util.nullAsNil(mautodbitem.getAsString(bL))
}) > 0)
            {
                flag = true;
            }
            flag1 = flag;
            if (flag)
            {
                doNotify();
                return flag;
            }
        } else
        {
            StringBuilder stringbuilder = a(mautodbitem, as);
            if (stringbuilder == null)
            {
                e("delete failed, check keys failed");
                return false;
            }
            if (P.delete(getTableName(), stringbuilder.toString(), a(as, mautodbitem)) > 0)
            {
                doNotify(bL);
                return true;
            } else
            {
                e("delete failed");
                return false;
            }
        }
        return flag1;
    }

    public boolean get(long l, MAutoDBItem mautodbitem)
    {
        Cursor cursor = P.query(getTableName(), columns, "rowid = ?", new String[] {
            String.valueOf(l)
        }, null, null, null);
        if (cursor.moveToFirst())
        {
            mautodbitem.convertFrom(cursor);
            cursor.close();
            return true;
        } else
        {
            cursor.close();
            return false;
        }
    }

    public transient boolean get(MAutoDBItem mautodbitem, String as[])
    {
        ContentValues contentvalues = mautodbitem.convertTo();
        if (contentvalues == null || contentvalues.size() <= 0)
        {
            e("get failed, value.size <= 0");
            return false;
        }
        if (as == null || as.length <= 0)
        {
            d("get with primary key");
            as = P.query(getTableName(), columns, (new StringBuilder()).append(bL).append(" = ?").toString(), new String[] {
                Util.nullAsNil(contentvalues.getAsString(bL))
            }, null, null, null);
            if (as.moveToFirst())
            {
                mautodbitem.convertFrom(as);
                as.close();
                return true;
            } else
            {
                as.close();
                return false;
            }
        }
        StringBuilder stringbuilder = a(contentvalues, as);
        if (stringbuilder == null)
        {
            e("get failed, check keys failed");
            return false;
        }
        as = P.query(getTableName(), columns, stringbuilder.toString(), a(as, contentvalues), null, null, null);
        if (as.moveToFirst())
        {
            mautodbitem.convertFrom(as);
            as.close();
            return true;
        } else
        {
            as.close();
            d("get failed, not found");
            return false;
        }
    }

    public Cursor getAll()
    {
        return P.query(getTableName(), columns, null, null, null, null, null);
    }

    public abstract String[] getColumns();

    public int getCount()
    {
        int i = 0;
        Cursor cursor = rawQuery((new StringBuilder("select count(*) from ")).append(getTableName()).toString(), new String[0]);
        if (cursor != null)
        {
            cursor.moveToFirst();
            i = cursor.getInt(0);
            cursor.close();
        }
        return i;
    }

    public abstract String getPrimaryKey();

    public abstract String getTableName();

    public boolean insert(MAutoDBItem mautodbitem)
    {
        ContentValues contentvalues = mautodbitem.convertTo();
        if (contentvalues == null || contentvalues.size() <= 0)
        {
            e("insert failed, value.size <= 0");
            return false;
        }
        mautodbitem.systemRowid = P.insert(getTableName(), bL, mautodbitem.convertTo());
        if (mautodbitem.systemRowid <= 0L)
        {
            e("insert failed");
            return false;
        } else
        {
            doNotify(bL);
            return true;
        }
    }

    public transient Cursor rawQuery(String s, String as[])
    {
        return P.rawQuery(s, as);
    }

    public boolean replace(MAutoDBItem mautodbitem)
    {
        ContentValues contentvalues;
label0:
        {
            boolean flag;
            if (!Util.isNullOrNil(bL))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assert.assertTrue("replace primaryKey == null", flag);
            contentvalues = mautodbitem.convertTo();
            if (contentvalues != null)
            {
                int j = contentvalues.size();
                int k = mautodbitem.fields().length;
                int i;
                if (contentvalues.containsKey("rowid"))
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (j == i + k)
                {
                    break label0;
                }
            }
            e("replace failed, cv.size() != item.fields().length");
            return false;
        }
        if (a(contentvalues))
        {
            d("no need replace , fields no change");
            return true;
        }
        if (P.replace(getTableName(), bL, contentvalues) > 0L)
        {
            doNotify(bL);
            return true;
        } else
        {
            e("replace failed");
            return false;
        }
    }

    public boolean update(long l, MAutoDBItem mautodbitem)
    {
        mautodbitem = mautodbitem.convertTo();
        boolean flag1;
        if (mautodbitem == null || mautodbitem.size() <= 0)
        {
            e("update failed, value.size <= 0");
            flag1 = false;
        } else
        {
            Cursor cursor = P.query(getTableName(), columns, "rowid = ?", new String[] {
                String.valueOf(l)
            }, null, null, null);
            if (MAutoDBItem.checkIOEqual(mautodbitem, cursor))
            {
                cursor.close();
                d("no need replace , fields no change");
                return true;
            }
            cursor.close();
            boolean flag;
            if (P.update(getTableName(), mautodbitem, "rowid = ?", new String[] {
    String.valueOf(l)
}) > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (flag)
            {
                doNotify();
                return flag;
            }
        }
        return flag1;
    }

    public transient boolean update(MAutoDBItem mautodbitem, String as[])
    {
        boolean flag = false;
        boolean flag1 = false;
        mautodbitem = mautodbitem.convertTo();
        if (mautodbitem == null || mautodbitem.size() <= 0)
        {
            e("update failed, value.size <= 0");
        } else
        if (as == null || as.length <= 0)
        {
            d("update with primary key");
            if (a(mautodbitem))
            {
                d("no need replace , fields no change");
                return true;
            }
            if (P.update(getTableName(), mautodbitem, (new StringBuilder()).append(bL).append(" = ?").toString(), new String[] {
    Util.nullAsNil(mautodbitem.getAsString(bL))
}) > 0)
            {
                flag = true;
            }
            flag1 = flag;
            if (flag)
            {
                doNotify();
                return flag;
            }
        } else
        {
            StringBuilder stringbuilder = a(mautodbitem, as);
            if (stringbuilder == null)
            {
                e("update failed, check keys failed");
                return false;
            }
            if (P.update(getTableName(), mautodbitem, stringbuilder.toString(), a(as, mautodbitem)) > 0)
            {
                doNotify(bL);
                return true;
            } else
            {
                e("update failed");
                return false;
            }
        }
        return flag1;
    }
}

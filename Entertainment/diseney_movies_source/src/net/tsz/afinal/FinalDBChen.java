// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.tsz.afinal.db.sqlite.MySqliteOpenHelper;

// Referenced classes of package net.tsz.afinal:
//            UtilChen

public class FinalDBChen
{

    private SQLiteDatabase database;
    private String sel;
    public MySqliteOpenHelper sqlOpenHelper;
    private String tabName;
    private String where;

    public FinalDBChen(Context context, String s)
    {
        sel = "SELECT * FROM ";
        where = " WHERE ";
        database = MySqliteOpenHelper.create(context, s, null, null, null).getWritableDatabase();
    }

    public FinalDBChen(Context context, String s, Object obj, String s1, String s2)
    {
        sel = "SELECT * FROM ";
        where = " WHERE ";
        tabName = s1;
        s2 = s1;
        if (TextUtils.isEmpty(s1))
        {
            s2 = context.getPackageName();
        }
        sqlOpenHelper = MySqliteOpenHelper.create(context, s, obj, s2, "");
        database = sqlOpenHelper.getDb();
    }

    public FinalDBChen(SQLiteDatabase sqlitedatabase)
    {
        sel = "SELECT * FROM ";
        where = " WHERE ";
        database = sqlitedatabase;
    }

    public void addTable(String s, Object obj)
    {
        if (database != null)
        {
            UtilChen.addTab(s, database, obj);
        }
    }

    public void closeDb()
    {
    }

    public void deleteItem(String s, String s1, String as[])
    {
        database.delete(s, s1, as);
    }

    public List findItemsByWhereAndWhereValue(String s, String s1, Class class1, String s2, String s3)
    {
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        ArrayList arraylist;
        arraylist = new ArrayList();
        obj1 = null;
        obj2 = null;
        obj3 = null;
        obj = null;
        s8 = s2;
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        if (!TextUtils.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_71;
        }
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        s8 = tabName;
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        Field afield[] = class1.getDeclaredFields();
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        String as[] = new String[afield.length];
        int i = 0;
_L6:
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        if (i < afield.length) goto _L2; else goto _L1
_L1:
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        s2 = (new StringBuilder(String.valueOf(s))).append("=?").toString();
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        if (!TextUtils.isEmpty(s)) goto _L4; else goto _L3
_L3:
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        if (!TextUtils.isEmpty(s1)) goto _L4; else goto _L5
_L5:
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        s1 = database.query(s8, as, null, null, null, null, s3);
_L7:
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        boolean flag;
        flag = s1.moveToNext();
        break MISSING_BLOCK_LABEL_281;
_L2:
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        afield[i].setAccessible(true);
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        as[i] = afield[i].getName();
        i++;
          goto _L6
_L4:
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_550;
        }
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        if (!TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_550;
        }
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        s1 = (new StringBuilder(String.valueOf(sel))).append(s8).append(where).append(s).toString();
        s = s1;
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        if (TextUtils.isEmpty(s3))
        {
            break MISSING_BLOCK_LABEL_521;
        }
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        s = (new StringBuilder(String.valueOf(s1))).append(" ").append(s3).toString();
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        s1 = database.rawQuery(s, null);
          goto _L7
        s5 = obj;
        s6 = obj1;
        s7 = obj2;
        s4 = obj3;
        s1 = database.query(s8, as, s2, new String[] {
            s1
        }, null, null, s3);
          goto _L7
        if (!flag)
        {
            s1.close();
            return arraylist;
        }
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        s3 = ((String) (class1.newInstance()));
        i = 0;
_L8:
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (i < as.length)
        {
            break MISSING_BLOCK_LABEL_680;
        }
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        arraylist.add(s3);
          goto _L7
        s;
        s4 = s5;
        s.printStackTrace();
        s5.close();
        return arraylist;
        int j;
        s8 = as[i];
        j = 0;
        s = null;
_L14:
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (j < afield.length)
        {
            break MISSING_BLOCK_LABEL_721;
        }
        i++;
          goto _L8
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        afield[j].setAccessible(true);
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        s2 = s;
        if (!afield[j].getName().equals(s8))
        {
            break MISSING_BLOCK_LABEL_1371;
        }
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        s2 = afield[j].getType().getSimpleName();
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (!s2.equals("String")) goto _L10; else goto _L9
_L9:
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        s = s1.getString(s1.getColumnIndex(s8));
_L11:
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        afield[j].set(s3, s);
        s2 = s;
        break MISSING_BLOCK_LABEL_1371;
_L10:
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (s2.equals("Long"))
        {
            break MISSING_BLOCK_LABEL_920;
        }
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (!s2.equals("long"))
        {
            break MISSING_BLOCK_LABEL_953;
        }
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        s = Long.valueOf(s1.getLong(s1.getColumnIndex(s8)));
          goto _L11
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (s2.equals("Integer"))
        {
            break MISSING_BLOCK_LABEL_997;
        }
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (!s2.equals("int"))
        {
            break MISSING_BLOCK_LABEL_1030;
        }
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        s = Integer.valueOf(s1.getInt(s1.getColumnIndex(s8)));
          goto _L11
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (!s2.equals("boolean"))
        {
            break MISSING_BLOCK_LABEL_1088;
        }
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        s = Boolean.valueOf(Boolean.parseBoolean(s1.getString(s1.getColumnIndex(s8))));
          goto _L11
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (s2.equals("Float"))
        {
            break MISSING_BLOCK_LABEL_1132;
        }
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (!s2.equals("float"))
        {
            break MISSING_BLOCK_LABEL_1165;
        }
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        s = Float.valueOf(s1.getFloat(s1.getColumnIndex(s8)));
          goto _L11
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (s2.equals("Double"))
        {
            break MISSING_BLOCK_LABEL_1209;
        }
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (!s2.equals("double"))
        {
            break MISSING_BLOCK_LABEL_1242;
        }
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        s = Double.valueOf(s1.getDouble(s1.getColumnIndex(s8)));
          goto _L11
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (s2.equals("Short")) goto _L13; else goto _L12
_L12:
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        if (!s2.equals("short")) goto _L11; else goto _L13
_L13:
        s5 = s1;
        s6 = s1;
        s7 = s1;
        s4 = s1;
        short word0 = s1.getShort(s1.getColumnIndex(s8));
        s = Short.valueOf(word0);
          goto _L11
        s;
        s4 = s6;
        s.printStackTrace();
        s6.close();
        return arraylist;
        s;
        s4 = s7;
        s.printStackTrace();
        s7.close();
        return arraylist;
        s;
        s4.close();
        throw s;
        j++;
        s = s2;
          goto _L14
    }

    public SQLiteDatabase getDatabase()
    {
        return database;
    }

    public long insertBeanList(List list, String s)
    {
        long l;
        long l1;
        long l2;
        long l3;
        long l4;
        l = -1L;
        l4 = l;
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        l1 = l;
        l2 = l;
        l3 = l;
        l4 = l;
        if (list.size() == 0)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        int i;
        int k;
        l1 = l;
        l2 = l;
        l3 = l;
        Field afield[];
        ContentValues contentvalues;
        Field field;
        int j;
        try
        {
            k = list.size();
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list.printStackTrace();
            return l1;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list.printStackTrace();
            return l2;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list.printStackTrace();
            return l3;
        }
        i = 0;
          goto _L1
_L5:
        l1 = l;
        l2 = l;
        l3 = l;
        afield = list.get(i).getClass().getDeclaredFields();
        l1 = l;
        l2 = l;
        l3 = l;
        contentvalues = new ContentValues();
        j = 0;
_L3:
        l1 = l;
        l2 = l;
        l3 = l;
        if (j < afield.length)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        l1 = l;
        l2 = l;
        l3 = l;
        l = database.insert(s, null, contentvalues);
        i++;
        continue; /* Loop/switch isn't completed */
        field = afield[j];
        l1 = l;
        l2 = l;
        l3 = l;
        field.setAccessible(true);
        l1 = l;
        l2 = l;
        l3 = l;
        contentvalues.put(field.getName(), (new StringBuilder()).append(field.get(list.get(i))).toString());
        j++;
        if (true) goto _L3; else goto _L2
_L2:
_L1:
        if (i < k) goto _L5; else goto _L4
_L4:
        l4 = l;
        return l4;
    }

    public long insertMap(Map map, String s)
    {
        long l;
        long l1;
        l1 = -1L;
        l = l1;
        if (map == null) goto _L2; else goto _L1
_L1:
        l = l1;
        if (map.size() == 0) goto _L2; else goto _L3
_L3:
        ContentValues contentvalues;
        Iterator iterator;
        contentvalues = new ContentValues();
        iterator = map.keySet().iterator();
_L7:
        if (iterator.hasNext()) goto _L5; else goto _L4
_L4:
        l = database.insert(s, null, contentvalues);
_L2:
        return l;
_L5:
        String s1 = (String)iterator.next();
        contentvalues.put(s1, (String)map.get(s1));
        if (true) goto _L7; else goto _L6
_L6:
    }

    public long insertObject(Object obj, String s)
    {
        String s1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        s1 = s;
        Field afield[];
        if (TextUtils.isEmpty(s))
        {
            s1 = tabName;
        }
        s = new ContentValues();
        afield = obj.getClass().getDeclaredFields();
        int i = 0;
_L1:
        if (i >= afield.length)
        {
            return database.insert(s1, null, s);
        }
        Field field = afield[i];
        field.setAccessible(true);
        s.put(field.getName(), (new StringBuilder()).append(field.get(obj)).toString());
        i++;
          goto _L1
        obj;
        ((SecurityException) (obj)).printStackTrace();
        return -1L;
        obj;
        ((IllegalArgumentException) (obj)).printStackTrace();
        return -1L;
        obj;
        ((IllegalAccessException) (obj)).printStackTrace();
        return -1L;
    }

    public String quer(String s, String s1)
    {
        database.query(s, null, (new StringBuilder("file_id='")).append(s1).append("'").toString(), null, null, null, null);
        return s1;
    }

    public void setDatabase(SQLiteDatabase sqlitedatabase)
    {
        database = sqlitedatabase;
    }

    public void updateValue(String s, String s1, String as[], ContentValues contentvalues)
    {
        database.update(s, contentvalues, s1, as);
    }

    public void updateValuesByJavaBean(String s, String s1, String as[], Object obj)
    {
        ContentValues contentvalues;
        Field afield[];
        int j;
        contentvalues = new ContentValues();
        afield = obj.getClass().getDeclaredFields();
        j = afield.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            Field field;
            try
            {
                updateValue(s, s1, as, contentvalues);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_113;
        }
        field = afield[i];
        field.setAccessible(true);
        contentvalues.put(field.getName(), (new StringBuilder()).append(field.get(obj)).toString());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }
}

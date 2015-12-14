// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.perfectcorp.model.Model;
import com.perfectcorp.model.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model.database:
//            a

public abstract class a extends a
{

    public String CREATE_TABLE_COMMAND;
    public String INSERT_COMMAND;
    public String TABLE_NAME;
    protected ArrayList a;

    public void a(SQLiteDatabase sqlitedatabase, Object aobj[])
    {
        SQLiteStatement sqlitestatement;
        int j;
        int k;
        sqlitestatement = sqlitedatabase.compileStatement(INSERT_COMMAND);
        sqlitedatabase.beginTransaction();
        k = aobj.length;
        j = 0;
_L2:
        Object obj;
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_437;
        }
        obj = aobj[j];
        Iterator iterator;
        sqlitestatement.clearBindings();
        iterator = a.iterator();
        int i = 0;
_L1:
        Object obj1;
        Object obj2;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_430;
        }
        obj1 = (com.cyberlink.beautycircle.model.database.a)iterator.next();
        obj2 = obj.getClass().getField(((com.cyberlink.beautycircle.model.database.a) (obj1)).b);
        obj1 = ((Field) (obj2)).getType();
        if (!obj1.equals(Long.TYPE) && !obj1.equals(java/lang/Long))
        {
            break MISSING_BLOCK_LABEL_142;
        }
        i++;
        sqlitestatement.bindLong(i, ((Long)((Field) (obj2)).get(obj)).longValue());
          goto _L1
        if (!obj1.equals(Boolean.TYPE) && !obj1.equals(java/lang/Boolean))
        {
            break MISSING_BLOCK_LABEL_199;
        }
        i++;
        long l;
        if (((Boolean)((Field) (obj2)).get(obj)).booleanValue())
        {
            l = 1L;
        } else
        {
            l = 0L;
        }
        sqlitestatement.bindLong(i, l);
          goto _L1
        if (!obj1.equals(java/util/Date))
        {
            break MISSING_BLOCK_LABEL_237;
        }
        i++;
        sqlitestatement.bindLong(i, ((Date)((Field) (obj2)).get(obj)).getTime());
          goto _L1
        if (!obj1.equals(java/lang/String))
        {
            break MISSING_BLOCK_LABEL_312;
        }
        obj1 = (String)((Field) (obj2)).get(obj);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        i++;
        sqlitestatement.bindString(i, ((String) (obj1)));
          goto _L1
        i++;
        sqlitestatement.bindNull(i);
          goto _L1
        try
        {
            sqlitestatement.execute();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        j++;
          goto _L2
        if (!com/perfectcorp/model/Model.isAssignableFrom(((Class) (obj1))))
        {
            break MISSING_BLOCK_LABEL_376;
        }
        obj2 = ((Field) (obj2)).get(obj);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_361;
        }
        i++;
        sqlitestatement.bindString(i, ((Class) (obj1)).cast(obj2).toString());
          goto _L1
        i++;
        sqlitestatement.bindNull(i);
          goto _L1
        obj2 = ((Field) (obj2)).get(obj);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_415;
        }
        i++;
        sqlitestatement.bindString(i, ((Class) (obj1)).cast(obj2).toString());
          goto _L1
        i++;
        sqlitestatement.bindNull(i);
          goto _L1
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
          goto _L1
    }

    protected void a(Object obj, String s)
    {
        TABLE_NAME = s;
        s = obj.getClass().getFields();
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            Field field = s[i];
            int k = field.getModifiers();
            if (Modifier.isPublic(k) && Modifier.isFinal(k) && com/cyberlink/beautycircle/model/database/a.isAssignableFrom(field.getType()))
            {
                com.cyberlink.beautycircle.model.database.a a1 = (com.cyberlink.beautycircle.model.database.a)field.get(obj);
                a1.b = field.getName();
                a.add(a1);
            }
        }

        obj = (new StringBuilder("CREATE TABLE ")).append(TABLE_NAME).append('(');
        s = (new StringBuilder("INSERT OR REPLACE INTO ")).append(TABLE_NAME).append('(');
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = a.iterator(); iterator.hasNext(); stringbuilder.append('?'))
        {
            com.cyberlink.beautycircle.model.database.a a2 = (com.cyberlink.beautycircle.model.database.a)iterator.next();
            if (stringbuilder.length() != 0)
            {
                ((StringBuilder) (obj)).append(',');
                s.append(',');
                stringbuilder.append(',');
            }
            ((StringBuilder) (obj)).append(a2.b());
            s.append(a2.b);
        }

        ((StringBuilder) (obj)).append(");");
        CREATE_TABLE_COMMAND = ((StringBuilder) (obj)).toString();
        s.append(") VALUES (").append(stringbuilder).append(");");
        INSERT_COMMAND = s.toString();
    }

    public String[] a()
    {
        String as[] = new String[a.size()];
        for (int i = 0; i < a.size(); i++)
        {
            as[i] = ((com.cyberlink.beautycircle.model.database.a)a.get(i)).b;
        }

        return as;
    }

    public ()
    {
        TABLE_NAME = null;
        CREATE_TABLE_COMMAND = null;
        INSERT_COMMAND = null;
        a = new ArrayList();
    }
}

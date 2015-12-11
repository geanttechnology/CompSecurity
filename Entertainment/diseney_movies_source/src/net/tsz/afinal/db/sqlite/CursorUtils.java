// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.db.sqlite;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import net.tsz.afinal.db.table.Id;
import net.tsz.afinal.db.table.Property;
import net.tsz.afinal.db.table.TableInfo;

// Referenced classes of package net.tsz.afinal.db.sqlite:
//            DbModel

public class CursorUtils
{

    public CursorUtils()
    {
    }

    public static Object dbModel2Entity(DbModel dbmodel, Class class1)
    {
        if (dbmodel == null) goto _L2; else goto _L1
_L1:
        dbmodel = dbmodel.getDataMap();
        Object obj;
        Iterator iterator;
        obj = class1.newInstance();
        iterator = dbmodel.entrySet().iterator();
_L7:
        if (!iterator.hasNext())
        {
            return obj;
        }
        Object obj1;
        String s;
        TableInfo tableinfo;
        dbmodel = (java.util.Map.Entry)iterator.next();
        s = (String)dbmodel.getKey();
        tableinfo = TableInfo.get(class1);
        obj1 = (Property)tableinfo.propertyMap.get(s);
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        if (dbmodel.getValue() != null) goto _L6; else goto _L5
_L5:
        dbmodel = null;
_L8:
        ((Property) (obj1)).setValue(obj, dbmodel);
          goto _L7
        dbmodel;
        dbmodel.printStackTrace();
_L2:
        return null;
_L6:
        dbmodel = dbmodel.getValue().toString();
          goto _L8
_L4:
        if (!tableinfo.getId().getColumn().equals(s)) goto _L7; else goto _L9
_L9:
        obj1 = tableinfo.getId();
        if (dbmodel.getValue() != null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        dbmodel = null;
_L10:
        ((Id) (obj1)).setValue(obj, dbmodel);
          goto _L7
        dbmodel = dbmodel.getValue().toString();
          goto _L10
    }

    public static DbModel getDbModel(Cursor cursor)
    {
        if (cursor != null && cursor.getColumnCount() > 0)
        {
            DbModel dbmodel = new DbModel();
            int j = cursor.getColumnCount();
            int i = 0;
            do
            {
                if (i >= j)
                {
                    return dbmodel;
                }
                dbmodel.set(cursor.getColumnName(i), cursor.getString(i));
                i++;
            } while (true);
        } else
        {
            return null;
        }
    }

    public static Object getEntity(Cursor cursor, Class class1)
    {
        if (cursor == null) goto _L2; else goto _L1
_L1:
        TableInfo tableinfo;
        int j;
        tableinfo = TableInfo.get(class1);
        j = cursor.getColumnCount();
        if (j <= 0) goto _L2; else goto _L3
_L3:
        class1 = ((Class) (class1.newInstance()));
        int i = 0;
          goto _L4
_L8:
        String s;
        Property property;
        s = cursor.getColumnName(i);
        property = (Property)tableinfo.propertyMap.get(s);
        if (property == null) goto _L6; else goto _L5
_L5:
        try
        {
            property.setValue(class1, cursor.getString(i));
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            cursor.printStackTrace();
        }
          goto _L2
_L6:
        if (tableinfo.getId().getColumn().equals(s))
        {
            tableinfo.getId().setValue(class1, cursor.getString(i));
        }
        break; /* Loop/switch isn't completed */
_L2:
        return null;
_L4:
        if (i >= j)
        {
            return class1;
        }
        if (true) goto _L8; else goto _L7
_L7:
        i++;
          goto _L4
        if (true) goto _L8; else goto _L9
_L9:
    }
}

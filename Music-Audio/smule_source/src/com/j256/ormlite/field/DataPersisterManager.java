// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;

import com.j256.ormlite.field.types.EnumStringType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.j256.ormlite.field:
//            DataPersister, DataType

public class DataPersisterManager
{

    private static final DataPersister DEFAULT_ENUM_PERSISTER = EnumStringType.getSingleton();
    private static Map builtInMap = null;
    private static List registeredPersisters = null;

    public DataPersisterManager()
    {
    }

    public static void clear()
    {
        registeredPersisters = null;
    }

    public static DataPersister lookupForField(Field field)
    {
        if (registeredPersisters == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = registeredPersisters.iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        Object obj = (DataPersister)iterator.next();
        if (!((DataPersister) (obj)).isValidForField(field)) goto _L5; else goto _L4
_L4:
        return ((DataPersister) (obj));
_L2:
        if (builtInMap == null)
        {
            obj = new HashMap();
            DataType adatatype[] = DataType.values();
            int k = adatatype.length;
            for (int i = 0; i < k; i++)
            {
                DataPersister datapersister1 = adatatype[i].getDataPersister();
                if (datapersister1 == null)
                {
                    continue;
                }
                Class aclass[] = datapersister1.getAssociatedClasses();
                int l = aclass.length;
                for (int j = 0; j < l; j++)
                {
                    ((HashMap) (obj)).put(aclass[j], datapersister1);
                }

            }

            builtInMap = ((Map) (obj));
        }
        DataPersister datapersister = (DataPersister)builtInMap.get(field.getType());
        obj = datapersister;
        if (datapersister == null)
        {
            if (field.getType().isEnum())
            {
                return DEFAULT_ENUM_PERSISTER;
            } else
            {
                return null;
            }
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public static transient void registerDataPersisters(DataPersister adatapersister[])
    {
        ArrayList arraylist = new ArrayList();
        if (registeredPersisters != null)
        {
            arraylist.addAll(registeredPersisters);
        }
        int j = adatapersister.length;
        for (int i = 0; i < j; i++)
        {
            arraylist.add(adatapersister[i]);
        }

        registeredPersisters = arraylist;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;

import com.j256.ormlite.field.types.EnumStringType;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.j256.ormlite.field:
//            DataType, DataPersister

public class DataPersisterManager
{

    private static final DataPersister DEFAULT_ENUM_PERSISTER = EnumStringType.getSingleton();
    private static final Map builtInMap;
    private static List registeredPersisters = null;

    public static DataPersister lookupForField(Field field)
    {
        Iterator iterator;
        if (registeredPersisters == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        iterator = registeredPersisters.iterator();
_L4:
        DataPersister datapersister1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        datapersister1 = (DataPersister)iterator.next();
        if (!datapersister1.isValidForField(field)) goto _L2; else goto _L1
_L1:
        return datapersister1;
_L2:
        Class aclass[];
        int i;
        int j;
        aclass = datapersister1.getAssociatedClasses();
        j = aclass.length;
        i = 0;
_L6:
        if (i >= j) goto _L4; else goto _L3
_L3:
        Class class1 = aclass[i];
        if (field.getType() == class1) goto _L1; else goto _L5
_L5:
        i++;
          goto _L6
        DataPersister datapersister = (DataPersister)builtInMap.get(field.getType().getName());
        if (datapersister != null)
        {
            return datapersister;
        }
        if (field.getType().isEnum())
        {
            return DEFAULT_ENUM_PERSISTER;
        } else
        {
            return null;
        }
    }

    static 
    {
        builtInMap = new HashMap();
        DataType adatatype[] = DataType.values();
        int l = adatatype.length;
        for (int i = 0; i < l; i++)
        {
            DataPersister datapersister = adatatype[i].getDataPersister();
            if (datapersister == null)
            {
                continue;
            }
            Object aobj[] = datapersister.getAssociatedClasses();
            int i1 = aobj.length;
            for (int j = 0; j < i1; j++)
            {
                Class class1 = aobj[j];
                builtInMap.put(class1.getName(), datapersister);
            }

            if (datapersister.getAssociatedClassNames() == null)
            {
                continue;
            }
            aobj = datapersister.getAssociatedClassNames();
            i1 = aobj.length;
            for (int k = 0; k < i1; k++)
            {
                String s = aobj[k];
                builtInMap.put(s, datapersister);
            }

        }

    }
}

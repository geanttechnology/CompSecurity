// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.util.List;

// Referenced classes of package com.j256.ormlite.stmt.query:
//            Clause

public class Raw
    implements Clause
{

    private final ArgumentHolder args[];
    private final String statement;

    public Raw(String s, ArgumentHolder aargumentholder[])
    {
        statement = s;
        args = aargumentholder;
    }

    public void appendSql(DatabaseType databasetype, String s, StringBuilder stringbuilder, List list)
    {
        stringbuilder.append(statement);
        stringbuilder.append(' ');
        databasetype = args;
        int j = databasetype.length;
        for (int i = 0; i < j; i++)
        {
            list.add(databasetype[i]);
        }

    }
}

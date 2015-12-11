// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.utils.StringHelpers;
import java.util.ArrayList;
import java.util.List;

public class SQLTable
{

    private List mColumnNames;
    private String mName;
    private List mTableDefinition;

    public SQLTable(SQLTable sqltable)
    {
        mColumnNames = new ArrayList();
        mTableDefinition = new ArrayList();
        mName = sqltable.mName;
        mColumnNames = new ArrayList(sqltable.mColumnNames);
        mTableDefinition = new ArrayList(sqltable.mTableDefinition);
    }

    public SQLTable(String s)
    {
        mColumnNames = new ArrayList();
        mTableDefinition = new ArrayList();
        mName = s;
    }

    public SQLTable addColumn(String s, String s1)
    {
        mColumnNames.add(s);
        mTableDefinition.add((new StringBuilder()).append(s).append(" ").append(s1).toString());
        return this;
    }

    public SQLTable addConstraint(String s)
    {
        mTableDefinition.add(s);
        return this;
    }

    public List getColumnNames()
    {
        return mColumnNames;
    }

    public String getName()
    {
        return mName;
    }

    public void setName(String s)
    {
        mName = s;
    }

    public String toString()
    {
        return String.format("CREATE TABLE %s (%s);", new Object[] {
            mName, StringHelpers.join(", ", mTableDefinition)
        });
    }
}

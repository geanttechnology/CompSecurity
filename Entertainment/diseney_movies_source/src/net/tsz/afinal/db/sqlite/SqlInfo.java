// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.db.sqlite;

import java.util.LinkedList;

public class SqlInfo
{

    private LinkedList bindArgs;
    private String sql;

    public SqlInfo()
    {
    }

    public void addValue(Object obj)
    {
        if (bindArgs == null)
        {
            bindArgs = new LinkedList();
        }
        bindArgs.add(obj);
    }

    public LinkedList getBindArgs()
    {
        return bindArgs;
    }

    public Object[] getBindArgsAsArray()
    {
        if (bindArgs != null)
        {
            return bindArgs.toArray();
        } else
        {
            return null;
        }
    }

    public String[] getBindArgsAsStringArray()
    {
        if (bindArgs != null)
        {
            String as[] = new String[bindArgs.size()];
            int i = 0;
            do
            {
                if (i >= bindArgs.size())
                {
                    return as;
                }
                as[i] = bindArgs.get(i).toString();
                i++;
            } while (true);
        } else
        {
            return null;
        }
    }

    public String getSql()
    {
        return sql;
    }

    public void setBindArgs(LinkedList linkedlist)
    {
        bindArgs = linkedlist;
    }

    public void setSql(String s)
    {
        sql = s;
    }
}

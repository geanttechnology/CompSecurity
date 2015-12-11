// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import android.content.Context;

// Referenced classes of package net.tsz.afinal:
//            FinalDb

public static class debug
{

    private Context context;
    private String dbName;
    private stener dbUpdateListener;
    private int dbVersion;
    private boolean debug;

    public Context getContext()
    {
        return context;
    }

    public String getDbName()
    {
        return dbName;
    }

    public stener getDbUpdateListener()
    {
        return dbUpdateListener;
    }

    public int getDbVersion()
    {
        return dbVersion;
    }

    public boolean isDebug()
    {
        return debug;
    }

    public void setContext(Context context1)
    {
        context = context1;
    }

    public void setDbName(String s)
    {
        dbName = s;
    }

    public void setDbUpdateListener(stener stener)
    {
        dbUpdateListener = stener;
    }

    public void setDbVersion(int i)
    {
        dbVersion = i;
    }

    public void setDebug(boolean flag)
    {
        debug = flag;
    }

    public stener()
    {
        context = null;
        dbName = "afinal.db";
        dbVersion = 1;
        debug = true;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.support;


// Referenced classes of package com.j256.ormlite.support:
//            BaseConnectionSource, DatabaseConnection

private static class nestedC
{

    public final DatabaseConnection connection;
    private int nestedC;

    public int decrementAndGet()
    {
        nestedC = nestedC - 1;
        return nestedC;
    }

    public void increment()
    {
        nestedC = nestedC + 1;
    }

    public (DatabaseConnection databaseconnection)
    {
        connection = databaseconnection;
        nestedC = 1;
    }
}

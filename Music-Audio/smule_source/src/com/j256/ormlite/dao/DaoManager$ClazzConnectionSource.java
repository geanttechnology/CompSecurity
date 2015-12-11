// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.support.ConnectionSource;

class clazz
{

    Class clazz;
    ConnectionSource connectionSource;

    public boolean equals(Object obj)
    {
        if (obj != null && getClass() == obj.getClass())
        {
            if (clazz.equals(((clazz) (obj = (clazz)obj)).clazz) && connectionSource.equals(((connectionSource) (obj)).connectionSource))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return (clazz.hashCode() + 31) * 31 + connectionSource.hashCode();
    }

    public (ConnectionSource connectionsource, Class class1)
    {
        connectionSource = connectionsource;
        clazz = class1;
    }
}

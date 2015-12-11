// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


public class BadgeCount
{

    public static int count = 0;

    public BadgeCount()
    {
    }

    public static void incrementCount()
    {
        com/poshmark/data_model/models/BadgeCount;
        JVM INSTR monitorenter ;
        count++;
        com/poshmark/data_model/models/BadgeCount;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void resetCount()
    {
        com/poshmark/data_model/models/BadgeCount;
        JVM INSTR monitorenter ;
        count = 0;
        com/poshmark/data_model/models/BadgeCount;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void setCountValue(int i)
    {
        com/poshmark/data_model/models/BadgeCount;
        JVM INSTR monitorenter ;
        count = i;
        com/poshmark/data_model/models/BadgeCount;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}

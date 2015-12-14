// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


public final class Suppress extends Enum
{

    private static final Suppress $VALUES[];
    public static final Suppress Deduplication;
    public static final Suppress Process;
    public final String parameter;

    private Suppress(String s, int i, String s1)
    {
        super(s, i);
        parameter = s1;
    }

    public static Suppress valueOf(String s)
    {
        return (Suppress)Enum.valueOf(com/amazon/clouddrive/model/Suppress, s);
    }

    public static Suppress[] values()
    {
        return (Suppress[])$VALUES.clone();
    }

    static 
    {
        Deduplication = new Suppress("Deduplication", 0, "deduplication");
        Process = new Suppress("Process", 1, "process");
        $VALUES = (new Suppress[] {
            Deduplication, Process
        });
    }
}

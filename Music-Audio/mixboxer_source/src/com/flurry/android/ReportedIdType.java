// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


public final class ReportedIdType extends Enum
{

    public static final ReportedIdType PhoneId;
    public static final ReportedIdType Sha1Imei;
    private static final ReportedIdType eU[];
    final int eS;
    final boolean eT;

    private ReportedIdType(String s, int i, int j, boolean flag)
    {
        super(s, i);
        eS = j;
        eT = flag;
    }

    public static ReportedIdType valueOf(String s)
    {
        return (ReportedIdType)Enum.valueOf(com/flurry/android/ReportedIdType, s);
    }

    public static ReportedIdType[] values()
    {
        return (ReportedIdType[])eU.clone();
    }

    static 
    {
        PhoneId = new ReportedIdType("PhoneId", 0, 1, true);
        Sha1Imei = new ReportedIdType("Sha1Imei", 1, 5, false);
        eU = (new ReportedIdType[] {
            PhoneId, Sha1Imei
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.tools;


public final class CpuInfo
{

    private static final String TAG = "CpuInfo";

    private CpuInfo()
    {
    }

    public static native int cpuArch();

    public static native int cpuImplementer();

    public static native int cpuPart();

    public static native int cpuRevision();

    public static native int cpuVariant();

    public static native String hardwareName();

    public static native String hardwareRevision();

    public static native boolean hasFeature(String s);

    public static native int numCPUs();
}

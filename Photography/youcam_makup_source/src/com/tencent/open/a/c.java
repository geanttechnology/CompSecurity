// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import java.io.File;

public class c
{

    public static int a = 60;
    public static int b = 32;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;
    public static String f = "OpenSDK.File.Tracer";
    public static String g = "OpenSDK.Client.File.Tracer";
    public static String h;
    public static String i = ".OpenSDK.log";
    public static String j = ".app.log";
    public static long k = 0x800000L;
    public static int l = 0x40000;
    public static int m = 8192;
    public static int n = 10000;
    public static String o = "debug.file.blockcount";
    public static String p = "debug.file.keepperiod";
    public static String q = "debug.file.tracelevel";
    public static int r = 24;
    public static long s = 0x240c8400L;

    static 
    {
        h = (new StringBuilder()).append("Tencent").append(File.separator).append("OpenSDK").append(File.separator).append("Logs").toString();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Trace;
import java.lang.reflect.Method;

final class bnd
{

    public static Method a;
    public static Method b;

    static 
    {
        if (bnc.a() < 18)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        a = android/os/Trace.getMethod("asyncTraceBegin", new Class[] {
            Long.TYPE, java/lang/String, Integer.TYPE
        });
        b = android/os/Trace.getMethod("asyncTraceEnd", new Class[] {
            Long.TYPE, java/lang/String, Integer.TYPE
        });
        android/os/Trace.getMethod("traceCounter", new Class[] {
            Long.TYPE, java/lang/String, Integer.TYPE
        });
        return;
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
    }
}

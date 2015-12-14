// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.util.Log;

public class i
{

    public static final StringBuilder a = new StringBuilder();

    public static int a()
    {
        return 3;
    }

    public static transient int a(String s, Object aobj[])
    {
        return -1;
    }

    private static transient String a(Object aobj[])
    {
        int j = 0;
        StringBuilder stringbuilder = a;
        stringbuilder;
        JVM INSTR monitorenter ;
        int k;
        a.setLength(0);
        k = aobj.length;
_L2:
        Object obj;
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        obj = aobj[j];
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        a.append(obj.toString());
        break MISSING_BLOCK_LABEL_82;
        a.append("null");
        break MISSING_BLOCK_LABEL_82;
        aobj;
        stringbuilder;
        JVM INSTR monitorexit ;
        throw aobj;
        aobj = a.toString();
        a.setLength(0);
        stringbuilder;
        JVM INSTR monitorexit ;
        return ((String) (aobj));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static transient int b(String s, Object aobj[])
    {
        return Log.w(s, a(aobj));
    }

    public static transient int c(String s, Object aobj[])
    {
        return Log.e(s, a(aobj));
    }

}

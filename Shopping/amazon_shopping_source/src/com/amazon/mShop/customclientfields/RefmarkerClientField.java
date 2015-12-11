// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.customclientfields;

import com.amazon.mShop.util.Util;
import java.util.HashMap;
import java.util.Map;

public class RefmarkerClientField
{

    private static final Map SERVICECALL_TO_REFMARKER = new HashMap();

    public RefmarkerClientField()
    {
    }

    public static final String getHttpHeaderForRefmarker(String s)
    {
        com/amazon/mShop/customclientfields/RefmarkerClientField;
        JVM INSTR monitorenter ;
        String s1;
        boolean flag;
        s1 = (String)SERVICECALL_TO_REFMARKER.get(s);
        flag = Util.isEmpty(s1);
        if (!flag) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        com/amazon/mShop/customclientfields/RefmarkerClientField;
        JVM INSTR monitorexit ;
        return s;
_L2:
        SERVICECALL_TO_REFMARKER.remove(s);
        s = s1;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public static boolean logServiceMethodNameAndRefmarker(String s, String s1)
    {
        com/amazon/mShop/customclientfields/RefmarkerClientField;
        JVM INSTR monitorenter ;
        if (Util.isEmpty(s) || Util.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        SERVICECALL_TO_REFMARKER.put(s, s1);
        boolean flag = true;
_L4:
        com/amazon/mShop/customclientfields/RefmarkerClientField;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

}

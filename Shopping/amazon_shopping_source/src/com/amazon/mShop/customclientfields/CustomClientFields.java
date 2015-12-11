// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.customclientfields;

import com.amazon.mShop.util.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CustomClientFields
{

    private static Map sCustomHeaderFieldsMapping = new HashMap();

    public CustomClientFields()
    {
    }

    private static Map generateCustomHeaderFields(boolean flag, String s)
    {
        if (Util.isEmpty(s))
        {
            return null;
        }
        HashMap hashmap = new HashMap();
        if (flag)
        {
            hashmap.put("x-amz-msh-rel-rid", s);
            hashmap.put("x-amz-msh-page-asm-type", "pageComponent");
            return hashmap;
        } else
        {
            hashmap.put("x-amz-msh-rid", s);
            return hashmap;
        }
    }

    public static String getAmazonRequestId()
    {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 20);
    }

    public static Map getCustomHeaderFields(String s)
    {
        com/amazon/mShop/customclientfields/CustomClientFields;
        JVM INSTR monitorenter ;
        s = (Map)sCustomHeaderFieldsMapping.get(s);
        com/amazon/mShop/customclientfields/CustomClientFields;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public static void setCustomHeaderFields(String s, String s1, String s2)
    {
        com/amazon/mShop/customclientfields/CustomClientFields;
        JVM INSTR monitorenter ;
        if (Util.isEmpty(s1) || Util.isEmpty(s2)) goto _L2; else goto _L1
_L1:
        boolean flag = Util.isEmpty(s);
        if (!flag) goto _L3; else goto _L2
_L2:
        com/amazon/mShop/customclientfields/CustomClientFields;
        JVM INSTR monitorexit ;
        return;
_L3:
        HashMap hashmap = new HashMap();
        hashmap.put("x-amz-msh-rel-rid", s1);
        hashmap.put("x-amz-msh-page-asm-type", s2);
        sCustomHeaderFieldsMapping.put(s, hashmap);
        if (true) goto _L2; else goto _L4
_L4:
        s;
        throw s;
    }

    public static void setCustomHeaderFields(String s, boolean flag, String s1)
    {
        com/amazon/mShop/customclientfields/CustomClientFields;
        JVM INSTR monitorenter ;
        sCustomHeaderFieldsMapping.put(s, generateCustomHeaderFields(flag, s1));
        com/amazon/mShop/customclientfields/CustomClientFields;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

}

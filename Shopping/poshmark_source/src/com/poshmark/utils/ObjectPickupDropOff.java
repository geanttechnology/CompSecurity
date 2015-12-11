// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ObjectPickupDropOff
{

    private static Map dataBin = new HashMap();

    public ObjectPickupDropOff()
    {
    }

    public static void dropOffDataObject(UUID uuid, Object obj)
    {
        com/poshmark/utils/ObjectPickupDropOff;
        JVM INSTR monitorenter ;
        dataBin.put(uuid, obj);
        com/poshmark/utils/ObjectPickupDropOff;
        JVM INSTR monitorexit ;
        return;
        uuid;
        throw uuid;
    }

    public static UUID getUniqueKey()
    {
        com/poshmark/utils/ObjectPickupDropOff;
        JVM INSTR monitorenter ;
        UUID uuid = UUID.randomUUID();
        com/poshmark/utils/ObjectPickupDropOff;
        JVM INSTR monitorexit ;
        return uuid;
        Exception exception;
        exception;
        throw exception;
    }

    public static Object pickupDataObject(UUID uuid)
    {
        com/poshmark/utils/ObjectPickupDropOff;
        JVM INSTR monitorenter ;
        if (!dataBin.containsKey(uuid)) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = dataBin.get(uuid);
        dataBin.remove(uuid);
        if (obj == null) goto _L2; else goto _L3
_L3:
        uuid = ((UUID) (obj));
_L5:
        com/poshmark/utils/ObjectPickupDropOff;
        JVM INSTR monitorexit ;
        return uuid;
_L2:
        uuid = null;
        if (true) goto _L5; else goto _L4
_L4:
        uuid;
        throw uuid;
    }

}

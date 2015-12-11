// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package com.google.android.gms.internal:
//            cq, cr, co

public final class cp
{

    private static final Object op;
    public static final String pu;
    private static cq pv;
    private static BigInteger pw;
    private static HashSet px;
    private static HashMap py;

    public static Bundle a(v.a a1, String s, Context context)
    {
        Object obj = op;
        obj;
        JVM INSTR monitorenter ;
        Bundle bundle;
        bundle = new Bundle();
        bundle.putBundle("app", pv.b(s, context));
        s = new Bundle();
        String s1;
        for (context = py.keySet().iterator(); context.hasNext(); s.putBundle(s1, ((cr)py.get(s1)).toBundle()))
        {
            s1 = (String)context.next();
        }

        break MISSING_BLOCK_LABEL_98;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
        bundle.putBundle("slots", s);
        s = new ArrayList();
        for (context = px.iterator(); context.hasNext(); s.add(((co)context.next()).toBundle())) { }
        bundle.putParcelableArrayList("ads", s);
        a1.a(px);
        px = new HashSet();
        obj;
        JVM INSTR monitorexit ;
        return bundle;
    }

    public static void a(co co1)
    {
        synchronized (op)
        {
            px.add(co1);
        }
        return;
        co1;
        obj;
        JVM INSTR monitorexit ;
        throw co1;
    }

    public static void a(v.a a1)
    {
        synchronized (op)
        {
            px.addAll(a1.ah());
        }
        return;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public static void a(String s, cr cr1)
    {
        synchronized (op)
        {
            py.put(s, cr1);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static String aP()
    {
        String s;
        synchronized (op)
        {
            s = pw.toString();
            pw = pw.add(BigInteger.ONE);
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static cq aQ()
    {
        cq cq1;
        synchronized (op)
        {
            cq1 = pv;
        }
        return cq1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        Object obj;
        byte abyte0[];
        byte abyte1[];
        int i;
        obj = UUID.randomUUID();
        abyte0 = BigInteger.valueOf(((UUID) (obj)).getLeastSignificantBits()).toByteArray();
        abyte1 = BigInteger.valueOf(((UUID) (obj)).getMostSignificantBits()).toByteArray();
        obj = (new BigInteger(1, abyte0)).toString();
        i = 0;
_L2:
        if (i >= 2)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1;
        obj1 = MessageDigest.getInstance("MD5");
        ((MessageDigest) (obj1)).update(abyte0);
        ((MessageDigest) (obj1)).update(abyte1);
        byte abyte2[] = new byte[8];
        System.arraycopy(((MessageDigest) (obj1)).digest(), 0, abyte2, 0, 8);
        obj1 = (new BigInteger(1, abyte2)).toString();
        obj = obj1;
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        pu = ((String) (obj));
        op = new Object();
        pv = new cq(pu);
        pw = BigInteger.ONE;
        px = new HashSet();
        py = new HashMap();
        return;
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
          goto _L3
    }
}

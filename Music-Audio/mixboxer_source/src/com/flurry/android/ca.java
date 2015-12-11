// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            bl

final class ca
{

    private static ca dX;
    private HashMap dY;

    ca()
    {
        dY = new HashMap();
    }

    static ca aq()
    {
        if (dX == null)
        {
            dX = new ca();
        }
        return dX;
    }

    static boolean c(long l1)
    {
        return l1 <= System.currentTimeMillis();
    }

    final void a(bl bl1)
    {
        if (bl1.ab().length() == 0)
        {
            return;
        }
        this;
        JVM INSTR monitorenter ;
        if (!dY.containsKey(bl1.ab()))
        {
            break MISSING_BLOCK_LABEL_74;
        }
        dY.remove(bl1.ab());
        if (bl1.ae() != -1)
        {
            dY.put(bl1.ab(), bl1);
        }
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        bl1;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw bl1;
        }
        // Misplaced declaration of an exception variable
        catch (bl bl1)
        {
            bl1.printStackTrace();
        }
        return;
        dY.put(bl1.ab(), bl1);
          goto _L1
    }

    final List ar()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new ArrayList();
        for (Iterator iterator = dY.values().iterator(); iterator.hasNext(); ((List) (obj)).add(((bl)iterator.next()).aa())) { }
        break MISSING_BLOCK_LABEL_66;
        obj;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        return null;
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
    }

    final void as()
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = ar().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            bl bl1 = (bl)iterator.next();
            if (c(bl1.ah()))
            {
                (new StringBuilder()).append("expiring adunit freq cap for idHash: ").append(bl1.ab()).append(" adunit exp: ").append(bl1.ah()).append(" device epoch").append(System.currentTimeMillis()).toString();
                m(bl1.ab());
            }
        } while (true);
        break MISSING_BLOCK_LABEL_109;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
        }
        return;
        this;
        JVM INSTR monitorexit ;
    }

    final bl l(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (!dY.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_29;
        }
        s = (bl)dY.get(s);
        return s;
        this;
        JVM INSTR monitorexit ;
        return null;
        s;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return null;
    }

    final void m(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (dY.containsKey(s))
        {
            dY.remove(s);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

// Referenced classes of package com.tapjoy.internal:
//            bn, ar

public final class gh
{

    private final File a;

    public gh(File file)
    {
        a = file;
    }

    public final boolean a()
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        String s = b();
        if (s == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        bn.a(a, UUID.randomUUID().toString());
        s = b();
        if (s != null)
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        try
        {
            a.delete();
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            this;
        }
        if (true) goto _L1; else goto _L3
_L3:
        JVM INSTR monitorexit ;
        throw obj;
    }

    final String b()
    {
        if (!a.exists())
        {
            break MISSING_BLOCK_LABEL_33;
        }
        String s;
        int i;
        s = bn.a(a, ar.c);
        i = s.length();
        if (i > 0)
        {
            return s;
        }
        break MISSING_BLOCK_LABEL_33;
        IOException ioexception;
        ioexception;
        return null;
    }
}

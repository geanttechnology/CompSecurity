// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.ConditionVariable;
import java.io.File;

final class atb extends Thread
{

    private ConditionVariable a;
    private ata b;

    atb(ata ata1, ConditionVariable conditionvariable)
    {
        b = ata1;
        a = conditionvariable;
        super();
    }

    public final void run()
    {
        ata ata1 = b;
        ata1;
        JVM INSTR monitorenter ;
        Object obj;
        File afile[];
        a.open();
        obj = b;
        if (!((ata) (obj)).a.exists())
        {
            ((ata) (obj)).a.mkdirs();
        }
        afile = ((ata) (obj)).a.listFiles();
        if (afile == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L10:
        if (i >= afile.length) goto _L2; else goto _L3
_L3:
        File file = afile[i];
        if (file.length() != 0L) goto _L5; else goto _L4
_L4:
        file.delete();
          goto _L6
_L5:
        asy asy1 = asy.a(file);
        if (asy1 != null) goto _L8; else goto _L7
_L7:
        file.delete();
          goto _L6
        obj;
        ata1;
        JVM INSTR monitorexit ;
        throw obj;
_L8:
        ((ata) (obj)).c(asy1);
          goto _L6
_L2:
        ata1;
        JVM INSTR monitorexit ;
        return;
_L6:
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }
}

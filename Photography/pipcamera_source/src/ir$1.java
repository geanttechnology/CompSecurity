// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;

class lang.Object
    implements in
{

    final ir a;

    public void a(int i)
    {
        Object obj;
        File file;
        obj = (new StringBuilder()).append(ir.a()).append("/fonts/").append(ir.a(a).f).append(".zip").toString();
        file = new File(((String) (obj)));
        i;
        JVM INSTR tableswitch -1 1: default 76
    //                   -1 163
    //                   0 77
    //                   1 90;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L3:
        if (file.exists())
        {
            file.delete();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (file.exists())
        {
            obj = new it(((String) (obj)), (new StringBuilder()).append(ir.a()).append("/fonts/").toString(), ir.b(a), true, ir.c(a));
            ((it) (obj)).a(ir.d(a));
            ((it) (obj)).execute(new Void[0]);
            return;
        }
        if (true) goto _L1; else goto _L2
_L2:
        if (file.exists())
        {
            file.delete();
        }
        if (ir.e(a) != null)
        {
            ir.e(a).a();
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    >(ir ir1)
    {
        a = ir1;
        super();
    }
}

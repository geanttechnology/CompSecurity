// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;

class alt
    implements alo
{

    final ama a;
    final als b;

    alt(als als1, ama ama1)
    {
        b = als1;
        a = ama1;
        super();
    }

    public void a(int i)
    {
        Object obj;
        File file;
        als.a(b, a);
        obj = (new StringBuilder()).append(als.a()).append("/fonts/").append(a.f).append(".zip").toString();
        file = new File(((String) (obj)));
        i;
        JVM INSTR tableswitch -1 1: default 84
    //                   -1 172
    //                   0 85
    //                   1 98;
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
            obj = new alw(((String) (obj)), (new StringBuilder()).append(als.a()).append("/fonts/").toString(), als.a(b), true, als.b(b));
            ((alw) (obj)).a(new alu(this));
            ((alw) (obj)).execute(new Void[0]);
            return;
        }
        if (true) goto _L1; else goto _L2
_L2:
        if (file.exists())
        {
            file.delete();
        }
        if (als.c(b) != null)
        {
            als.c(b).a();
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }
}

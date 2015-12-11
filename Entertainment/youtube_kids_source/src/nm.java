// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

final class nm extends bmr
{

    private nd a;

    nm(nd nd1)
    {
        a = nd1;
        super();
    }

    public final Object a()
    {
        boolean flag;
        flag = true;
        bkn bkn = a.c.h();
        boolean flag2 = a.a(a.a, a.s());
        Context context;
        boolean flag1;
        if (a.a(a.a.getContentResolver()) == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        context = a.a;
        a.a(context.getContentResolver());
        JVM INSTR tableswitch 0 1: default 88
    //                   0 114
    //                   1 93;
           goto _L1 _L2 _L3
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        flag = bnh.a(context);
_L5:
        return new ckt(bkn, flag2, flag1, flag, false);
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.ScheduledExecutorService;

final class lang.Object
    implements ac
{

    private ah a;

    public final void a(Object obj)
    {
        obj = (ad)obj;
        switch (a[((ad) (obj)).ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            ah.b(a).execute(ah.a(a));
            break;
        }
    }

    >(ah ah1)
    {
        a = ah1;
        super();
    }
}

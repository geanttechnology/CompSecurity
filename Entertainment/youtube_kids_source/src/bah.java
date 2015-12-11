// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.LinkedBlockingQueue;

final class bah
    implements avt
{

    private LinkedBlockingQueue a;

    bah(baf baf, LinkedBlockingQueue linkedblockingqueue)
    {
        a = linkedblockingqueue;
        super();
    }

    public final void a(avq avq)
    {
        try
        {
            a.put(new bai((new StringBuilder("Connection failed: ")).append(avq).toString()));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (avq avq)
        {
            return;
        }
    }
}

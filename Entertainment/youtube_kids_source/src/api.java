// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

final class api
    implements Runnable
{

    private IOException a;
    private apd b;

    api(apd apd1, IOException ioexception)
    {
        b = apd1;
        a = ioexception;
        super();
    }

    public final void run()
    {
        Object obj = b.b;
        int i = b.a;
        obj = a;
    }
}

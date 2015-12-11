// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

public final class daf
    implements dah
{

    private final dah a;
    private final dah b;
    private dah c;

    public daf(dah dah1, dah dah2)
    {
        a = dah1;
        b = dah2;
        c = a;
    }

    public final void close()
    {
        emp.a(a);
        emp.a(b);
    }

    public final exe next()
    {
        exe exe;
        exe exe1;
        try
        {
            exe1 = c.next();
        }
        catch (IOException ioexception)
        {
            close();
            throw ioexception;
        }
        exe = exe1;
        if (exe1 != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (c != a)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        c = b;
        exe = c.next();
        return exe;
        return null;
    }
}

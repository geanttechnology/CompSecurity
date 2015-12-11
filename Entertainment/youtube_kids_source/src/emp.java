// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class emp
{

    static final Logger a = Logger.getLogger(emp.getName());

    private emp()
    {
    }

    public static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
        try
        {
            a.log(Level.WARNING, "IOException thrown while closing Closeable.", closeable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            a.log(Level.SEVERE, "IOException should not have been thrown.", closeable);
        }
        return;
    }

}

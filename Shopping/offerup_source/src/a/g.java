// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;

import java.util.Locale;

public final class g
{

    private final Object a;

    public final boolean a()
    {
        synchronized (a) { }
        return false;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final String toString()
    {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] {
            getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(false)
        });
    }
}

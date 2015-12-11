// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import java.util.Locale;
import java.util.concurrent.CancellationException;

// Referenced classes of package bolts:
//            CancellationTokenSource, CancellationTokenRegistration

public class CancellationToken
{

    private final CancellationTokenSource tokenSource;

    CancellationToken(CancellationTokenSource cancellationtokensource)
    {
        tokenSource = cancellationtokensource;
    }

    public boolean isCancellationRequested()
    {
        return tokenSource.isCancellationRequested();
    }

    public CancellationTokenRegistration register(Runnable runnable)
    {
        return tokenSource.register(runnable);
    }

    public void throwIfCancellationRequested()
        throws CancellationException
    {
        tokenSource.throwIfCancellationRequested();
    }

    public String toString()
    {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] {
            getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(tokenSource.isCancellationRequested())
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.speech.engine.RetryPolicy;

final class ahm
    implements RetryPolicy
{

    ahm(ahf ahf)
    {
    }

    public final boolean canRetry(dap dap)
    {
        return false;
    }

    public final dap equivalentToError(exf exf)
    {
        return null;
    }

    public final boolean isAuthException(dap dap)
    {
        return false;
    }

    public final void reset()
    {
    }
}

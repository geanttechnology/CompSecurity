// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.engine;

import dap;
import exf;

public interface RetryPolicy
{

    public abstract boolean canRetry(dap dap);

    public abstract dap equivalentToError(exf exf);

    public abstract boolean isAuthException(dap dap);

    public abstract void reset();
}

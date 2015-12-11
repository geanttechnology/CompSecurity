// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.concurrent.Cancellable;

public interface HttpExecutionAware
{

    public abstract boolean isAborted();

    public abstract void setCancellable(Cancellable cancellable);
}

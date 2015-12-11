// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.pool;

import cz.msebera.android.httpclient.concurrent.FutureCallback;
import java.util.concurrent.Future;

public interface ConnPool
{

    public abstract Future lease(Object obj, Object obj1, FutureCallback futurecallback);

    public abstract void release(Object obj, boolean flag);
}

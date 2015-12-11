// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.util.concurrent;


// Referenced classes of package org.roboguice.shaded.goole.common.util.concurrent:
//            ListenableFuture

public interface AsyncFunction
{

    public abstract ListenableFuture apply(Object obj)
        throws Exception;
}

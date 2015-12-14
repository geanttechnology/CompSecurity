// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network;


// Referenced classes of package com.amazon.gallery.framework.network:
//            NetworkExecutor

public static interface tion
    extends Runnable
{

    public abstract boolean cancel(boolean flag);

    public abstract tion getOperation();
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.concurrent;


// Referenced classes of package com.amazon.mixtape.concurrent:
//            KeyedThreads

public static interface 
    extends Runnable
{

    public abstract Object getKey();
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            Dispatcher

interface HitStore
{

    public abstract void close();

    public abstract void dispatch();

    public abstract Dispatcher getDispatcher();

    public abstract void putHit(long l, String s);
}

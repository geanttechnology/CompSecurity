// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;


// Referenced classes of package com.google.common.util.concurrent:
//            AbstractFuture

private static abstract class <init>
{

    abstract boolean casListeners(AbstractFuture abstractfuture, <init> <init>1, <init> <init>2);

    abstract boolean casValue(AbstractFuture abstractfuture, Object obj, Object obj1);

    abstract boolean casWaiters(AbstractFuture abstractfuture, <init> <init>1, <init> <init>2);

    abstract void putNext(<init> <init>1, <init> <init>2);

    abstract void putThread(<init> <init>1, Thread thread);

    private ()
    {
    }

    ( )
    {
        this();
    }
}

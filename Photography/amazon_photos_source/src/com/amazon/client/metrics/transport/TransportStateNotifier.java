// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.transport;


public interface TransportStateNotifier
{
    public static interface TransportWarmedListener
    {
    }


    public abstract void listenForTransportWarmed(TransportWarmedListener transportwarmedlistener);
}

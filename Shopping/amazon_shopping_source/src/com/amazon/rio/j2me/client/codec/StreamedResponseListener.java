// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;


public interface StreamedResponseListener
{

    public abstract void aboutToReceiveArrayOfSize(int i, int ai[]);

    public abstract void receivedObject(Object obj, int ai[]);
}

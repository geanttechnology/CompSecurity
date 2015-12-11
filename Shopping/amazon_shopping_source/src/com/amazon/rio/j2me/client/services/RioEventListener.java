// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services;


// Referenced classes of package com.amazon.rio.j2me.client.services:
//            ServiceCall

public interface RioEventListener
{

    public abstract void connectionFailed(ServiceCall servicecall);

    public abstract void connectionSucceeded(ServiceCall servicecall);
}

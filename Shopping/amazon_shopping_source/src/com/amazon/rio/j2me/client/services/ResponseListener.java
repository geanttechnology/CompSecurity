// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services;


// Referenced classes of package com.amazon.rio.j2me.client.services:
//            ServiceCall

public interface ResponseListener
{

    public abstract void cancelled(ServiceCall servicecall);

    public abstract void error(Exception exception, ServiceCall servicecall);
}

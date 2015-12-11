// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.rsc;


// Referenced classes of package com.amazon.rio.j2me.client.rsc:
//            ClientRequestReply, ServiceCallInvoker, ServiceCallState

public interface ServiceCall
{

    public abstract boolean allowCookies();

    public abstract void cancel();

    public abstract String getApplicationID();

    public abstract ClientRequestReply getClientRequestReply();

    public abstract String getMethod();

    public abstract ServiceCallInvoker getServiceCallInvoker();

    public abstract String getServiceName();

    public abstract ServiceCallState getState();

    public abstract boolean isSecure();
}

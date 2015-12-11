// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.rsc;


// Referenced classes of package com.amazon.rio.j2me.client.rsc:
//            ClientRequestReply, ServiceCall

public interface ServiceCallInvoker
{

    public abstract ServiceCall invoke(String s, String s1, String s2, boolean flag, boolean flag1, ClientRequestReply clientrequestreply);
}

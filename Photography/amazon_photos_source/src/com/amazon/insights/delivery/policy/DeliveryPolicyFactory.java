// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.delivery.policy;


// Referenced classes of package com.amazon.insights.delivery.policy:
//            DeliveryPolicy

public interface DeliveryPolicyFactory
{

    public abstract DeliveryPolicy newConnectivityPolicy();

    public abstract DeliveryPolicy newForceSubmissionTimePolicy();
}

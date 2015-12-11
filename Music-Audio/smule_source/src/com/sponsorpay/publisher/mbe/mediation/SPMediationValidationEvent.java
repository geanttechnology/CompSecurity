// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe.mediation;

import java.util.Map;

// Referenced classes of package com.sponsorpay.publisher.mbe.mediation:
//            SPTPNVideoValidationResult

public interface SPMediationValidationEvent
{

    public abstract void validationEventResult(String s, SPTPNVideoValidationResult sptpnvideovalidationresult, Map map);
}

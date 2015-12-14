// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;


// Referenced classes of package com.inmobi.ads:
//            InMobiNative, InMobiAdRequestStatus

public static interface 
{

    public abstract void onAdDismissed(InMobiNative inmobinative);

    public abstract void onAdDisplayed(InMobiNative inmobinative);

    public abstract void onAdLoadFailed(InMobiNative inmobinative, InMobiAdRequestStatus inmobiadrequeststatus);

    public abstract void onAdLoadSucceeded(InMobiNative inmobinative);

    public abstract void onUserLeftApplication(InMobiNative inmobinative);
}

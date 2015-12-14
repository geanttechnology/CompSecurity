// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;

import android.app.Activity;

// Referenced classes of package com.brightroll.androidsdk:
//            Ad

public interface AdDelegate
{

    public abstract void adDidClick();

    public abstract void adDidCompletion();

    public abstract void adDidFirstQuartile();

    public abstract void adDidImpression();

    public abstract void adDidMidpoint();

    public abstract void adDidThirdQuartile();

    public abstract void adDismissed(Ad ad);

    public abstract void adFetchFailed(Ad ad);

    public abstract void adFetched(Ad ad);

    public abstract Activity getAdActivity();
}

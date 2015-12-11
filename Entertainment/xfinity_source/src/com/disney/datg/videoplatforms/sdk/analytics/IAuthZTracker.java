// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics:
//            ITrackable

public interface IAuthZTracker
{

    public abstract void trackAuthZFailure(ITrackable itrackable);

    public abstract void trackAuthZStarted(ITrackable itrackable);

    public abstract void trackAuthZSuccess(ITrackable itrackable);
}

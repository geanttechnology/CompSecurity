// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics:
//            ITracker, ITrackable

public interface IMediaTracker
    extends ITracker
{

    public abstract void trackMediaComplete(ITrackable itrackable);

    public abstract void trackMediaError(ITrackable itrackable);

    public abstract void trackMediaFirstQuarter(ITrackable itrackable);

    public abstract void trackMediaForward(ITrackable itrackable);

    public abstract void trackMediaMidpoint(ITrackable itrackable);

    public abstract void trackMediaPaused(ITrackable itrackable);

    public abstract void trackMediaResumed(ITrackable itrackable);

    public abstract void trackMediaRewind(ITrackable itrackable);

    public abstract void trackMediaStarted(ITrackable itrackable);

    public abstract void trackMediaStateUpdated(ITrackable itrackable);

    public abstract void trackMediaStopped(ITrackable itrackable);

    public abstract void trackMediaThirdQuarter(ITrackable itrackable);

    public abstract void trackPing(ITrackable itrackable);
}

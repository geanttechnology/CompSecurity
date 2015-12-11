// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics:
//            ITracker, ITrackable

public interface IAdTracker
    extends ITracker
{

    public abstract void trackAdBreakEnd(ITrackable itrackable);

    public abstract void trackAdBreakStart(ITrackable itrackable);

    public abstract void trackAdEnd(ITrackable itrackable);

    public abstract void trackAdError(ITrackable itrackable);

    public abstract void trackAdFirstQuartile(ITrackable itrackable);

    public abstract void trackAdMidpoint(ITrackable itrackable);

    public abstract void trackAdStart(ITrackable itrackable);

    public abstract void trackAdThirdQuartile(ITrackable itrackable);
}

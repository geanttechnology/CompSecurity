// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.VideoView;

final class aeg
{

    private static final long INTERVAL_MILLIS = 250L;
    final aec this$0;
    private final Runnable updateTimebarCallback;

    private aeg(aec aec1)
    {
        this$0 = aec1;
        super();
        updateTimebarCallback = new aeh(this);
    }

    aeg(aec aec1, aed aed)
    {
        this(aec1);
    }

    private void updateTimeBar()
    {
        if (aec.access$100(aec.this).isCurrentOrPast(aef.PLAYING))
        {
            aec.access$600(aec.this).setTimes(aec.access$500(aec.this).getCurrentPosition(), aec.access$500(aec.this).getDuration());
            aec.access$500(aec.this).postDelayed(updateTimebarCallback, 250L);
        }
    }

    public final void onVideoEnded()
    {
        stopRequesting();
        int i = aec.access$500(aec.this).getDuration();
        aec.access$600(aec.this).setTimes(i, i);
    }

    public final void startRequesting()
    {
        stopRequesting();
        aec.access$500(aec.this).post(updateTimebarCallback);
    }

    public final void stopRequesting()
    {
        aec.access$500(aec.this).removeCallbacks(updateTimebarCallback);
    }

}

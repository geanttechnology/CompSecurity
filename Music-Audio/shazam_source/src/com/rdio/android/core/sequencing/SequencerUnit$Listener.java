// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;


// Referenced classes of package com.rdio.android.core.sequencing:
//            SequencerUnit

public static interface 
{

    public abstract void onError( );

    public abstract void onInitialTrackKeyReady(String s, SequencerUnit sequencerunit);

    public abstract void onJumpComplete(String s, SequencerUnit sequencerunit);

    public abstract void onMoveToNextComplete(String s, SequencerUnit sequencerunit);

    public abstract void onMoveToPreviousComplete(String s, SequencerUnit sequencerunit);

    public abstract void onNextTrackKeyReady(String s, SequencerUnit sequencerunit);

    public abstract void onPreviousTrackKeyReady(String s, SequencerUnit sequencerunit);

    public abstract void onSequenceChanged(int ai[], SequencerUnit sequencerunit);

    public abstract void onSequenceReachedEnd(SequencerUnit sequencerunit);

    public abstract void onSourceConversion(String s, String s1);
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.audio;

import android.media.AudioRecord;

// Referenced classes of package com.amazon.blueshift.bluefront.android.audio:
//            AudioRecorder, AudioSourceListener

private class <init>
    implements android.media.r.RecordPositionChangeListener
{

    private static final double DEFAULT_WEIGHT = -3.1000000000000001D;
    private double max;
    private double min;
    final AudioRecorder this$0;

    public void onMarkerReached(AudioRecord audiorecord)
    {
    }

    public void onPeriodicNotification(AudioRecord audiorecord)
    {
        if (AudioRecorder.access$100(AudioRecorder.this) <= 0)
        {
            return;
        }
        double d = Math.log10(Math.sqrt(AudioRecorder.access$200(AudioRecorder.this) / (double)AudioRecorder.access$100(AudioRecorder.this)) / 32767D);
        AudioRecorder.access$202(AudioRecorder.this, 0.0D);
        AudioRecorder.access$102(AudioRecorder.this, 0);
        if (d < min && d > -200000D)
        {
            min = d;
        }
        if (d > max)
        {
            max = d;
        }
        d = (d + 3.2000000000000002D) / 2D;
        getAudioSourceListener().onRmsChanged((float)d);
    }

    private ()
    {
        this$0 = AudioRecorder.this;
        super();
        min = -3.1000000000000001D;
        max = -3.1000000000000001D;
    }

    max(max max1)
    {
        this();
    }
}

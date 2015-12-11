// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package shared_presage.com.google.android.exoplayer.audio:
//            AudioCapabilitiesReceiver, AudioCapabilities

private final class <init> extends BroadcastReceiver
{

    final AudioCapabilitiesReceiver a;

    public final void onReceive(Context context, Intent intent)
    {
        while (isInitialStickyBroadcast() || !intent.getAction().equals("android.media.action.HDMI_AUDIO_PLUG")) 
        {
            return;
        }
        AudioCapabilitiesReceiver.access$100(a).onAudioCapabilitiesChanged(new AudioCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0)));
    }

    private stener(AudioCapabilitiesReceiver audiocapabilitiesreceiver)
    {
        a = audiocapabilitiesreceiver;
        super();
    }

    a(AudioCapabilitiesReceiver audiocapabilitiesreceiver, byte byte0)
    {
        this(audiocapabilitiesreceiver);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.audio:
//            AudioCapabilities

public final class AudioCapabilitiesReceiver
{
    public static interface Listener
    {

        public abstract void onAudioCapabilitiesChanged(AudioCapabilities audiocapabilities);
    }

    private final class a extends BroadcastReceiver
    {

        final AudioCapabilitiesReceiver a;

        public final void onReceive(Context context1, Intent intent)
        {
            while (isInitialStickyBroadcast() || !intent.getAction().equals("android.media.action.HDMI_AUDIO_PLUG")) 
            {
                return;
            }
            a.listener.onAudioCapabilitiesChanged(new AudioCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0)));
        }

        private a()
        {
            a = AudioCapabilitiesReceiver.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    private static final AudioCapabilities DEFAULT_AUDIO_CAPABILITIES = new AudioCapabilities(new int[] {
        2
    }, 2);
    private final Context context;
    private final Listener listener;
    private final BroadcastReceiver receiver;

    public AudioCapabilitiesReceiver(Context context1, Listener listener1)
    {
        context = (Context)Assertions.checkNotNull(context1);
        listener = (Listener)Assertions.checkNotNull(listener1);
        if (Util.SDK_INT >= 21)
        {
            context1 = new a((byte)0);
        } else
        {
            context1 = null;
        }
        receiver = context1;
    }

    public final void register()
    {
        if (receiver != null)
        {
            Intent intent = context.registerReceiver(receiver, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
            if (intent != null)
            {
                receiver.onReceive(context, intent);
                return;
            }
        }
        listener.onAudioCapabilitiesChanged(DEFAULT_AUDIO_CAPABILITIES);
    }

    public final void unregister()
    {
        if (receiver != null)
        {
            context.unregisterReceiver(receiver);
        }
    }


}

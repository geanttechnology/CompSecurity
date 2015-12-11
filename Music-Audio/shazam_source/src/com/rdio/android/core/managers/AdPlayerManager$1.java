// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.managers;

import com.google.a.d.e;
import com.rdio.android.core.events.ads.AdPlayerPositionUpdateEvent;
import com.rdio.android.core.events.ads.AdPlayerStateChanged;
import com.rdio.android.core.media.SimpleUriAudioPlayer;

// Referenced classes of package com.rdio.android.core.managers:
//            AdPlayerManager

class this._cls0
    implements com.rdio.android.core.media.er.Listener
{

    final AdPlayerManager this$0;

    public void onError()
    {
        AdPlayerManager.access$000(AdPlayerManager.this, true);
    }

    public void onPlaybackComplete()
    {
        AdPlayerManager.access$000(AdPlayerManager.this, false);
    }

    public void onPlayingChanged(boolean flag)
    {
        AdPlayerManager.access$200(AdPlayerManager.this).post(new AdPlayerStateChanged(flag));
    }

    public void onPositionChanged()
    {
        AdPlayerManager.access$200(AdPlayerManager.this).post(new AdPlayerPositionUpdateEvent(AdPlayerManager.access$100(AdPlayerManager.this).getPosition(), AdPlayerManager.access$100(AdPlayerManager.this).getDuration()));
    }

    UpdateEvent()
    {
        this$0 = AdPlayerManager.this;
        super();
    }
}

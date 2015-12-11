// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.disney;

import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.player.DisneyEspnTokenDelegate;
import com.disney.datg.videoplatforms.sdk.common.VPAuthToken;
import com.disney.datg.videoplatforms.sdk.media.VPMedia;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.playerplatform.primetime.android.disney:
//            DisneyPlayer

class setTokenParameters extends VPAuthToken
{

    final setTokenParameters this$1;

    l.mediaToAuthorize()
    {
        this$1 = this._cls1.this;
        super();
        mediatoauthorize = DisneyPlayer.access$100(_fld0).getDrmKey();
        HashMap hashmap = new HashMap();
        hashmap.put("token_type", "offsite.comcast");
        hashmap.put("token", is._cls0.this);
        setTokenParameters(hashmap);
    }

    // Unreferenced inner class com/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4

/* anonymous class */
    class DisneyPlayer._cls4
        implements Runnable
    {

        final DisneyPlayer this$0;
        final VPMedia val$mediaToAuthorize;

        public void run()
        {
            DisneyPlayer.access$700().debug("TeaTime-Disney Player Auth Token request received");
            DisneyEspnTokenDelegate disneyespntokendelegate = DisneyPlayer.access$100(DisneyPlayer.this).getDisneyEspnTokenDelegate();
            if (DisneyPlayer.access$100(DisneyPlayer.this).getDrmKey() == null || disneyespntokendelegate != null && (isDrmComplete || DisneyPlayer.access$1100(DisneyPlayer.this)))
            {
                DisneyPlayer.access$100(DisneyPlayer.this).setDrmKey(disneyespntokendelegate.onTokenExpired(DisneyPlayer.access$100(DisneyPlayer.this).getChannelName(), DisneyPlayer.access$100(DisneyPlayer.this).getDrmKey()));
            }
            mediaToAuthorize.authorizeMediaWithAuthToken(new DisneyPlayer._cls4._cls1());
        }

            
            {
                this$0 = final_disneyplayer;
                mediaToAuthorize = VPMedia.this;
                super();
            }
    }

}

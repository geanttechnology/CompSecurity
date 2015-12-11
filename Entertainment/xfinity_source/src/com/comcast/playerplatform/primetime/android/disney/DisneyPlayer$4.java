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

class val.mediaToAuthorize
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
        val$mediaToAuthorize.authorizeMediaWithAuthToken(new VPAuthToken() {

            final DisneyPlayer._cls4 this$1;

            
            {
                this$1 = DisneyPlayer._cls4.this;
                super();
                _pcls4 = DisneyPlayer.access$100(this$0).getDrmKey();
                HashMap hashmap = new HashMap();
                hashmap.put("token_type", "offsite.comcast");
                hashmap.put("token", DisneyPlayer._cls4.this);
                setTokenParameters(hashmap);
            }
        });
    }

    _cls1.setTokenParameters()
    {
        this$0 = final_disneyplayer;
        val$mediaToAuthorize = VPMedia.this;
        super();
    }
}

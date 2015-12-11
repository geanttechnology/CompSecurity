// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.player;

import android.media.MediaPlayer;
import android.net.Uri;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.comcast.playerplatform.primetime.android.player:
//            AndroidPlayer

class val.asset
    implements Runnable
{

    final AndroidPlayer this$0;
    final Asset val$asset;

    public void run()
    {
        try
        {
            AndroidPlayer.access$002(AndroidPlayer.this, PlayerStatus.INITIALIZING);
            AndroidPlayer.access$100(AndroidPlayer.this);
            HashMap hashmap = new HashMap();
            hashmap.put("Cookie", (new StringBuilder()).append(val$asset.authCookieName).append(" = ").append(val$asset.authCookieValue).toString());
            AndroidPlayer.access$300(AndroidPlayer.this).setDataSource(AndroidPlayer.access$200(AndroidPlayer.this), Uri.parse(val$asset.getManifestUri()), hashmap);
            AndroidPlayer.access$002(AndroidPlayer.this, PlayerStatus.INITIALIZED);
            AndroidPlayer.access$100(AndroidPlayer.this);
            AndroidPlayer.access$300(AndroidPlayer.this).prepareAsync();
            AndroidPlayer.access$002(AndroidPlayer.this, PlayerStatus.PREPARING);
            AndroidPlayer.access$100(AndroidPlayer.this);
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    I()
    {
        this$0 = final_androidplayer;
        val$asset = Asset.this;
        super();
    }
}

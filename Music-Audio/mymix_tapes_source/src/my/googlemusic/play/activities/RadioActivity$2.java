// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import java.util.Collections;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.services.player.PlayerService;

// Referenced classes of package my.googlemusic.play.activities:
//            RadioActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final RadioActivity this$0;

    public void onFailure(Response response)
    {
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        if (RadioActivity.access$800(RadioActivity.this) == 0L)
        {
            RadioActivity.access$902(RadioActivity.this, RadioActivity.access$600(RadioActivity.this).getRadio());
        } else
        {
            RadioActivity.access$902(RadioActivity.this, RadioActivity.access$600(RadioActivity.this).getArtistSongs(RadioActivity.access$800(RadioActivity.this)));
            Collections.shuffle(RadioActivity.access$900(RadioActivity.this));
        }
        bindService(new Intent(RadioActivity.this, my/googlemusic/play/services/player/PlayerService), RadioActivity.access$1000(RadioActivity.this), 1);
    }

    ce()
    {
        this$0 = RadioActivity.this;
        super();
    }
}

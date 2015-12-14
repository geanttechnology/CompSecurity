// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.List;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;

// Referenced classes of package my.googlemusic.play.services.player:
//            PlayerService, PlayerManager

class this._cls0 extends BroadcastReceiver
{

    final PlayerService this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getStringExtra("EXTRAS");
        if (context != null && context.equals("MUSIC PREPARED") && PlayerService.access$000(PlayerService.this).isRadio())
        {
            int i = 0;
            while (i < PlayerService.access$000(PlayerService.this).getPlaylist().size()) 
            {
                if (((Song)PlayerService.access$000(PlayerService.this).getPlaylist().get(i)).getId() != PlayerService.access$000(PlayerService.this).getCurrentSong().getId() || i != PlayerService.access$100(PlayerService.this))
                {
                    continue;
                }
                if (PlayerService.access$200(PlayerService.this))
                {
                    PlayerService.access$202(PlayerService.this, false);
                    PlayerService.access$112(PlayerService.this, 6);
                } else
                {
                    PlayerService.access$202(PlayerService.this, true);
                    PlayerService.access$112(PlayerService.this, 3);
                }
                if (!PlayerService.access$300(PlayerService.this).getUser().isPremium())
                {
                    PlayerService.access$400(PlayerService.this);
                }
                i++;
            }
        }
    }

    _cls9()
    {
        this$0 = PlayerService.this;
        super();
    }
}

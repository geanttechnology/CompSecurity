// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.player;

import android.os.Binder;
import my.googlemusic.play.interfaces.Player;

// Referenced classes of package my.googlemusic.play.services.player:
//            PlayerService

public class this._cls0 extends Binder
{

    final PlayerService this$0;

    public Player getDownloader()
    {
        return PlayerService.access$000(PlayerService.this);
    }

    public Player getPlayer()
    {
        return PlayerService.access$000(PlayerService.this);
    }

    public ()
    {
        this$0 = PlayerService.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.widget.ImageButton;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.utils.animations.AnimationRipple;
import my.googlemusic.play.utils.appbar.AppBar;

// Referenced classes of package my.googlemusic.play.activities:
//            PlayerActivity

class this._cls0
    implements ServiceConnection
{

    final PlayerActivity this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        componentname = (my.googlemusic.play.services.player.alBinder)ibinder;
        PlayerActivity.access$002(PlayerActivity.this, componentname.getPlayer());
        PlayerActivity.access$1102(PlayerActivity.this, true);
        if (!PlayerActivity.access$000(PlayerActivity.this).isActive())
        {
            finish();
            return;
        }
        componentname = PlayerActivity.access$000(PlayerActivity.this).getCurrentSong();
        PlayerActivity.access$1000(PlayerActivity.this).song.setText(componentname.getName());
        PlayerActivity.access$1000(PlayerActivity.this).album.setText(componentname.getAlbum().getName());
        PlayerActivity.access$1000(PlayerActivity.this).appBar.title(componentname.getAlbum().getArtist().getName());
        PlayerActivity.access$1000(PlayerActivity.this).infoPlays.setText((new StringBuilder()).append(componentname.getAlbum().getHits()).append(" plays").toString());
        PlayerActivity.access$1000(PlayerActivity.this).infoLikes.setText((new StringBuilder()).append(componentname.getAlbum().getLikes()).append(" likes").toString());
        PlayerActivity.access$1000(PlayerActivity.this).infoComments.setText((new StringBuilder()).append(componentname.getAlbum().getCommentsCount()).append(" comments").toString());
        ibinder = PlayerActivity.access$1000(PlayerActivity.this).favorite;
        int i;
        if (PlayerActivity.access$1200(PlayerActivity.this).isFavorited(componentname))
        {
            i = 0x7f020078;
        } else
        {
            i = 0x7f020077;
        }
        ibinder.setImageResource(i);
        Picasso.with(PlayerActivity.this).load(componentname.getAlbum().getImage()).placeholder(0x7f0201dc).into(PlayerActivity.access$1000(PlayerActivity.this).cover);
        AnimationRipple.initFadeState(PlayerActivity.access$1000(PlayerActivity.this).song, PlayerActivity.access$1000(PlayerActivity.this).favoriteEffectBack, PlayerActivity.access$1200(PlayerActivity.this).isFavorited(componentname), PlayerActivity.this);
        if (!PlayerActivity.access$000(PlayerActivity.this).isPlaying()) goto _L2; else goto _L1
_L1:
        PlayerActivity.access$100(PlayerActivity.this);
        PlayerActivity.access$400(PlayerActivity.this);
_L4:
        PlayerActivity.access$000(PlayerActivity.this).setNotificationVisible(false);
        PlayerActivity.access$1300(PlayerActivity.this);
        PlayerActivity.access$1400(PlayerActivity.this);
        return;
_L2:
        if (PlayerActivity.access$000(PlayerActivity.this).isPaused())
        {
            PlayerActivity.access$100(PlayerActivity.this);
            PlayerActivity.access$500(PlayerActivity.this);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        PlayerActivity.access$1102(PlayerActivity.this, false);
    }

    pple()
    {
        this$0 = PlayerActivity.this;
        super();
    }
}

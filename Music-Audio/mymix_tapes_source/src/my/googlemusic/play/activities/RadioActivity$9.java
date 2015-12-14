// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.utils.animations.AnimationRipple;
import my.googlemusic.play.utils.appbar.AppBar;

// Referenced classes of package my.googlemusic.play.activities:
//            RadioActivity

class this._cls0
    implements ServiceConnection
{

    final RadioActivity this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        componentname = (my.googlemusic.play.services.player.calBinder)ibinder;
        RadioActivity.access$502(RadioActivity.this, componentname.getPlayer());
        RadioActivity.access$1302(RadioActivity.this, true);
        int i;
        if (!RadioActivity.access$500(RadioActivity.this).isRadio() || RadioActivity.access$1400(RadioActivity.this) || RadioActivity.access$800(RadioActivity.this) != RadioActivity.access$500(RadioActivity.this).getIdArtistRadio())
        {
            componentname = RadioActivity.access$500(RadioActivity.this);
            ibinder = RadioActivity.access$900(RadioActivity.this);
            Object obj;
            boolean flag;
            if (RadioActivity.access$800(RadioActivity.this) != 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            componentname.setPlayList(ibinder, true, flag, RadioActivity.access$800(RadioActivity.this));
            RadioActivity.access$500(RadioActivity.this).play(0);
            componentname = (Song)RadioActivity.access$900(RadioActivity.this).get(0);
        } else
        {
            ibinder = RadioActivity.access$500(RadioActivity.this).getCurrentSong();
            componentname = ibinder;
            if (RadioActivity.access$800(RadioActivity.this) == ibinder.getAlbum().getArtist().getId())
            {
                componentname = ibinder;
            }
        }
        RadioActivity.access$500(RadioActivity.this).setNotificationVisible(false);
        RadioActivity.access$700(RadioActivity.this).album.setText(componentname.getAlbum().getName());
        obj = RadioActivity.access$700(RadioActivity.this).song;
        if (componentname.getId() == 0L)
        {
            ibinder = "";
        } else
        {
            ibinder = componentname.getName();
        }
        ((TextView) (obj)).setText(ibinder);
        obj = RadioActivity.access$700(RadioActivity.this).appBar;
        if (componentname.getId() == 0L)
        {
            ibinder = "";
        } else
        {
            ibinder = componentname.getAlbum().getArtist().getName();
        }
        ((AppBar) (obj)).title(ibinder);
        RadioActivity.access$700(RadioActivity.this).infoPlays.setText((new StringBuilder()).append(RadioActivity.access$500(RadioActivity.this).getCurrentSong().getAlbum().getHits()).append(" plays").toString());
        RadioActivity.access$700(RadioActivity.this).infoLikes.setText((new StringBuilder()).append(((Song)RadioActivity.access$500(RadioActivity.this).getPlaylist().get(RadioActivity.access$500(RadioActivity.this).getCurrentTrack())).getAlbum().getLikes()).append(" likes").toString());
        RadioActivity.access$700(RadioActivity.this).infoComments.setText((new StringBuilder()).append(((Song)RadioActivity.access$500(RadioActivity.this).getPlaylist().get(RadioActivity.access$500(RadioActivity.this).getCurrentTrack())).getAlbum().getCommentsCount()).append(" comments").toString());
        ibinder = RadioActivity.access$700(RadioActivity.this).favorite;
        if (RadioActivity.access$600(RadioActivity.this).isFavorited(componentname))
        {
            i = 0x7f020078;
        } else
        {
            i = 0x7f020077;
        }
        ibinder.setImageResource(i);
        AnimationRipple.initFadeState(RadioActivity.access$700(RadioActivity.this).song, RadioActivity.access$700(RadioActivity.this).favoriteEffectBack, RadioActivity.access$600(RadioActivity.this).isFavorited(componentname), RadioActivity.this);
        if (RadioActivity.access$500(RadioActivity.this).isPlaying())
        {
            RadioActivity.access$000(RadioActivity.this);
            RadioActivity.access$300(RadioActivity.this);
        } else
        if (RadioActivity.access$500(RadioActivity.this).isPaused())
        {
            RadioActivity.access$000(RadioActivity.this);
            RadioActivity.access$400(RadioActivity.this);
        }
        RadioActivity.access$700(RadioActivity.this).download.setImageResource(0x7f02013d);
        if (RadioActivity.access$600(RadioActivity.this).isDownloaded(componentname))
        {
            ibinder = RadioActivity.access$700(RadioActivity.this).download;
            if (RadioActivity.access$600(RadioActivity.this).isDownloadFinished(componentname))
            {
                i = 0x7f02008e;
            } else
            {
                i = 0x7f02008f;
            }
            ibinder.setImageResource(i);
        }
        RadioActivity.access$1500(RadioActivity.this);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        RadioActivity.access$1302(RadioActivity.this, false);
    }

    ipple()
    {
        this$0 = RadioActivity.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package my.googlemusic.play.activities:
//            AlbumActivity

class this._cls0
    implements ServiceConnection
{

    final AlbumActivity this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        componentname = (my.googlemusic.play.services.player.alBinder)ibinder;
        AlbumActivity.access$402(AlbumActivity.this, componentname.getPlayer());
        AlbumActivity.access$902(AlbumActivity.this, true);
        if (AlbumActivity.access$1000(AlbumActivity.this) != null)
        {
            onSongPlay(AlbumActivity.access$1000(AlbumActivity.this));
        }
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        AlbumActivity.access$902(AlbumActivity.this, false);
    }

    e.LocalBinder()
    {
        this$0 = AlbumActivity.this;
        super();
    }
}

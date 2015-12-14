// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package my.googlemusic.play.activities:
//            FavoriteActivity

class this._cls0
    implements ServiceConnection
{

    final FavoriteActivity this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        componentname = (my.googlemusic.play.services.player.Binder)ibinder;
        FavoriteActivity.access$1202(FavoriteActivity.this, componentname.getPlayer());
        FavoriteActivity.access$1302(FavoriteActivity.this, true);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        FavoriteActivity.access$1302(FavoriteActivity.this, false);
    }

    LocalBinder()
    {
        this$0 = FavoriteActivity.this;
        super();
    }
}

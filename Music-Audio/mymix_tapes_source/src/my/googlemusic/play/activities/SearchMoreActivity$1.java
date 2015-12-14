// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package my.googlemusic.play.activities:
//            SearchMoreActivity

class this._cls0
    implements ServiceConnection
{

    final SearchMoreActivity this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        componentname = (my.googlemusic.play.services.player.nder)ibinder;
        SearchMoreActivity.access$102(SearchMoreActivity.this, componentname.getPlayer());
        mBound = true;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        mBound = false;
    }

    calBinder()
    {
        this$0 = SearchMoreActivity.this;
        super();
    }
}

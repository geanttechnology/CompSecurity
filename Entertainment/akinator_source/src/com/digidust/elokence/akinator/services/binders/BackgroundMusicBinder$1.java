// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.services.binders;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.services.BackgroundMusicService;

// Referenced classes of package com.digidust.elokence.akinator.services.binders:
//            BackgroundMusicBinder

class this._cls0
    implements ServiceConnection
{

    final BackgroundMusicBinder this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        BackgroundMusicBinder.access$002(BackgroundMusicBinder.this, ((com.digidust.elokence.akinator.services.erviceBinder)ibinder).getService());
        BackgroundMusicBinder.access$000(BackgroundMusicBinder.this).setBMB(BackgroundMusicBinder.this);
        BackgroundMusicBinder.access$000(BackgroundMusicBinder.this).startMusic(BackgroundMusicBinder.access$100(BackgroundMusicBinder.this));
        AkLog.v("BackgroundMusicBinder", (new StringBuilder()).append("BackgroundMusicBinder Service Connected with Music Type : ").append(BackgroundMusicBinder.access$100(BackgroundMusicBinder.this)).toString());
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        AkLog.v("BackgroundMusicBinder", "BackgroundMusicBinder Service Disconnected");
        BackgroundMusicBinder.access$002(BackgroundMusicBinder.this, null);
    }

    nder()
    {
        this$0 = BackgroundMusicBinder.this;
        super();
    }
}

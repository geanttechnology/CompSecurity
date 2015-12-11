// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.services.binders;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.services.BackgroundSoundsService;

// Referenced classes of package com.digidust.elokence.akinator.services.binders:
//            BackgroundSoundsBinder

class this._cls0
    implements ServiceConnection
{

    final BackgroundSoundsBinder this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        BackgroundSoundsBinder.access$002(BackgroundSoundsBinder.this, ((com.digidust.elokence.akinator.services.erviceBinder)ibinder).getService());
        BackgroundSoundsBinder.access$000(BackgroundSoundsBinder.this).setBSB(BackgroundSoundsBinder.this);
        AkLog.v("Akinator", "Service Connected");
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        BackgroundSoundsBinder.access$002(BackgroundSoundsBinder.this, null);
    }

    nder()
    {
        this$0 = BackgroundSoundsBinder.this;
        super();
    }
}

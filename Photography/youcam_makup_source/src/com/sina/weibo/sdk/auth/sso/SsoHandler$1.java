// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.sina.sso.RemoteSSO;

// Referenced classes of package com.sina.weibo.sdk.auth.sso:
//            SsoHandler, WebAuthHandler

class this._cls0
    implements ServiceConnection
{

    final SsoHandler this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        ibinder = com.sina.sso.b.asInterface(ibinder);
        try
        {
            componentname = ibinder.getPackageName();
            ibinder = ibinder.getActivityName();
            SsoHandler.access$2(SsoHandler.this).getApplicationContext().unbindService(SsoHandler.access$3(SsoHandler.this));
            if (!SsoHandler.access$4(SsoHandler.this, componentname, ibinder))
            {
                SsoHandler.access$0(SsoHandler.this).anthorize(SsoHandler.access$1(SsoHandler.this));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname)
        {
            componentname.printStackTrace();
        }
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        SsoHandler.access$0(SsoHandler.this).anthorize(SsoHandler.access$1(SsoHandler.this));
    }

    r()
    {
        this$0 = SsoHandler.this;
        super();
    }
}

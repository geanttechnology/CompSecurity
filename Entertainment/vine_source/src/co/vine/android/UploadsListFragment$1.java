// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android:
//            UploadsListFragment

class this._cls0
    implements ServiceConnection
{

    final UploadsListFragment this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        SLog.dWithTag("UploadsListFragment", "Bind VineUploadService successful!");
        UploadsListFragment.access$102(UploadsListFragment.this, new Messenger(ibinder));
        UploadsListFragment.access$202(UploadsListFragment.this, true);
        componentname = Message.obtain(null, 1);
        componentname.replyTo = UploadsListFragment.access$300(UploadsListFragment.this);
        UploadsListFragment.access$400(UploadsListFragment.this, componentname);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        SLog.dWithTag("UploadsListFragment", "Connection to VineUploadService lost unexpectedly!");
        UploadsListFragment.access$102(UploadsListFragment.this, null);
        UploadsListFragment.access$202(UploadsListFragment.this, false);
    }

    ()
    {
        this$0 = UploadsListFragment.this;
        super();
    }
}

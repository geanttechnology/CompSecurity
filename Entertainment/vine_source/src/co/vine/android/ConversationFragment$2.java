// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android:
//            ConversationFragment

class this._cls0
    implements ServiceConnection
{

    final ConversationFragment this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        SLog.dWithTag("ConversationFrag", "Bound to VineUploadService");
        ConversationFragment.access$102(ConversationFragment.this, new Messenger(ibinder));
        ConversationFragment.access$202(ConversationFragment.this, true);
        ConversationFragment.access$400(ConversationFragment.this, ConversationFragment.access$300(ConversationFragment.this));
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        SLog.dWithTag("ConversationFrag", "Connection to VineUploadService lost unexpectedly!");
        ConversationFragment.access$102(ConversationFragment.this, null);
        ConversationFragment.access$202(ConversationFragment.this, false);
    }

    ()
    {
        this$0 = ConversationFragment.this;
        super();
    }
}

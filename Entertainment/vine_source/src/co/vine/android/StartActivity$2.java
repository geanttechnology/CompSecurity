// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.player.VideoViewInterface;
import co.vine.android.util.SystemUtil;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android:
//            StartActivity

class this._cls0
    implements co.vine.android.player.ce.OnPreparedListener
{

    final StartActivity this$0;

    public void onPrepared(VideoViewInterface videoviewinterface)
    {
        SystemUtil.setNormalVideoPlayable(getApplicationContext(), true);
        StartActivity.access$200(StartActivity.this).start();
        SLog.d("Video test completed, assuming success, may change later.");
    }

    Interface()
    {
        this$0 = StartActivity.this;
        super();
    }
}

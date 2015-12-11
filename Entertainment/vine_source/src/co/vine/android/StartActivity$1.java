// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Handler;
import co.vine.android.player.VideoViewInterface;
import co.vine.android.util.SystemUtil;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android:
//            StartActivity

class this._cls0
    implements co.vine.android.player.ce.OnErrorListener
{

    final StartActivity this$0;

    public boolean onError(VideoViewInterface videoviewinterface, int i, int j)
    {
        SLog.d("Video test failed.");
        SystemUtil.setNormalVideoPlayable(getApplicationContext(), false);
        StartActivity.access$100(StartActivity.this).postDelayed(new Runnable() {

            final StartActivity._cls1 this$1;

            public void run()
            {
                StartActivity.access$000(this$0);
            }

            
            {
                this$1 = StartActivity._cls1.this;
                super();
            }
        }, 50L);
        return true;
    }

    _cls1.this._cls1()
    {
        this$0 = StartActivity.this;
        super();
    }
}

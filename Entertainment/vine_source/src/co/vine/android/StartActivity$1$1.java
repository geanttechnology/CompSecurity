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

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        StartActivity.access$000(_fld0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class co/vine/android/StartActivity$1

/* anonymous class */
    class StartActivity._cls1
        implements co.vine.android.player.VideoViewInterface.OnErrorListener
    {

        final StartActivity this$0;

        public boolean onError(VideoViewInterface videoviewinterface, int i, int j)
        {
            SLog.d("Video test failed.");
            SystemUtil.setNormalVideoPlayable(getApplicationContext(), false);
            StartActivity.access$100(StartActivity.this).postDelayed(new StartActivity._cls1._cls1(), 50L);
            return true;
        }

            
            {
                this$0 = StartActivity.this;
                super();
            }
    }

}

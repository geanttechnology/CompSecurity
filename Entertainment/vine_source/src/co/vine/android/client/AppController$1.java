// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import co.vine.android.util.image.PhotoImagesCache;
import co.vine.android.util.video.VideoCache;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.client:
//            AppController

class > extends BroadcastReceiver
{

    final AppController this$0;

    public void onReceive(Context context, Intent intent)
    {
        SLog.d("Received invalidate cache broadcast");
        VideoCache.invalidateCache();
        PhotoImagesCache.invalidateCache();
    }

    ache()
    {
        this$0 = AppController.this;
        super();
    }
}

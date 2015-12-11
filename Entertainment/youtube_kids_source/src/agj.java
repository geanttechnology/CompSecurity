// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import com.google.android.apps.youtube.kids.voice.BitmapSoundLevelsView;

public final class agj extends Handler
{

    public volatile boolean a;
    private BitmapSoundLevelsView b;

    public agj(BitmapSoundLevelsView bitmapsoundlevelsview)
    {
        b = bitmapsoundlevelsview;
        super();
    }

    public final void handleMessage(Message message)
    {
        if (a)
        {
            b.invalidate();
            sendMessageDelayed(obtainMessage(0), 10L);
        }
    }
}

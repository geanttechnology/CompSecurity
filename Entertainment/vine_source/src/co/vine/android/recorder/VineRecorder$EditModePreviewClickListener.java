// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;
import co.vine.android.player.SdkVideoView;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

private class <init>
    implements android.view.ickListener
{

    final VineRecorder this$0;

    public void onClick(View view)
    {
        if (VineRecorder.access$1900(VineRecorder.this).isPlaying())
        {
            VineRecorder.access$2900(VineRecorder.this).lay = VineRecorder.access$1100(VineRecorder.this);
            VineRecorder.access$2900(VineRecorder.this).ceRefresh = false;
            pausePreview(true);
        }
    }

    private ()
    {
        this$0 = VineRecorder.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

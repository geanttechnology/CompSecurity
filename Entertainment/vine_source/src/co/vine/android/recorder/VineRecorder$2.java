// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.widget.SeekBar;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder, CameraManager

class this._cls0
    implements android.widget.arChangeListener
{

    final VineRecorder this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        CameraManager.getInstance().modifyZoom(seekbar.getProgress() + 1);
    }

    stener()
    {
        this$0 = VineRecorder.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.widget.ImageView;
import com.sonymobile.camera.addon.capturingmode.CapturingModeSelector;

// Referenced classes of package co.vine.android:
//            SonyRecordingActivity

class this._cls0
    implements com.sonymobile.camera.addon.capturingmode.ModeFinishListener
{

    final SonyRecordingActivity this$0;

    public void onModeFinish()
    {
        if (SonyRecordingActivity.access$000(SonyRecordingActivity.this) != null)
        {
            SonyRecordingActivity.access$000(SonyRecordingActivity.this).close();
            SonyRecordingActivity.access$200(SonyRecordingActivity.this).setVisibility(0);
        }
    }

    e.CapturingModeSelector()
    {
        this$0 = SonyRecordingActivity.this;
        super();
    }
}

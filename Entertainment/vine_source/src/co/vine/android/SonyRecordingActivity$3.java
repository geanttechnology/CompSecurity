// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import com.sonymobile.camera.addon.capturingmode.CapturingModeSelector;

// Referenced classes of package co.vine.android:
//            SonyRecordingActivity

class this._cls0
    implements com.sonymobile.camera.addon.capturingmode.ModeSelectListener
{

    final SonyRecordingActivity this$0;

    public void onModeSelect(String s)
    {
        if (SonyRecordingActivity.access$000(SonyRecordingActivity.this) != null)
        {
            SonyRecordingActivity.access$000(SonyRecordingActivity.this).close();
        }
        finish();
    }

    e.CapturingModeSelector()
    {
        this$0 = SonyRecordingActivity.this;
        super();
    }
}

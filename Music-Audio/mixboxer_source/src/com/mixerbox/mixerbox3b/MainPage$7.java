// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.Context;
import android.view.OrientationEventListener;
import android.widget.RelativeLayout;
import com.mixerbox.mixerbox3b.classes.DrawView;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class er extends OrientationEventListener
{

    final MainPage this$0;

    public void onOrientationChanged(int i)
    {
        if (i != -1 && isForeground)
        {
            if (i >= 0 && i <= 45 || i >= 315 || i >= 135 && i <= 225)
            {
                curOri = 1;
            } else
            {
                curOri = 0;
            }
            if (!MainPage.defaultPortrait)
            {
                if (curOri == 1)
                {
                    curOri = 0;
                } else
                {
                    curOri = 1;
                }
            }
            if (preOri == -1)
            {
                preOri = curOri;
                return;
            }
            if (preOri == -1 || preOri != curOri)
            {
                preOri = curOri;
                if (guideView != null && guideView.isShown() && android.provider.stem.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1)
                {
                    guideView.performClick();
                }
                if (curOri == 1 && SCREEN_STATE == 2)
                {
                    setUnFullScreen(true);
                    return;
                }
                if (curOri == 1)
                {
                    setRequestedOrientation(7);
                    return;
                }
                if (curOri == 0 && android.provider.stem.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1 && rlVideoPlayer.getVisibility() == 0)
                {
                    setFullScreen();
                    return;
                }
                if (curOri == 0 && android.provider.stem.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1)
                {
                    setRequestedOrientation(6);
                    return;
                }
            }
        }
    }

    wView(Context context, int i)
    {
        this$0 = MainPage.this;
        super(context, i);
    }
}

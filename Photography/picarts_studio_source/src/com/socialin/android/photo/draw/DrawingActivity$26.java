// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.widget.SeekBar;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.widget.angeListener
{

    private DrawingActivity a;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (flag)
        {
            DrawingActivity.b(a).setSelectedLayerOpacity(seekbar.getProgress());
        }
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        DrawingActivity.b(a).c.c();
    }

    (DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}

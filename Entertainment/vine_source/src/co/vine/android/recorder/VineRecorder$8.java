// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class val.ghostBitmap
    implements Runnable
{

    final VineRecorder this$0;
    final Bitmap val$ghostBitmap;

    public void run()
    {
        if (val$ghostBitmap == null)
        {
            if (VineRecorder.access$1400(VineRecorder.this) != null)
            {
                VineRecorder.access$1400(VineRecorder.this).setVisibility(8);
            }
        } else
        if (VineRecorder.access$300(VineRecorder.this) != null && VineRecorder.access$1400(VineRecorder.this) != null)
        {
            if (mEditedSegments.size() == 0)
            {
                VineRecorder.access$1400(VineRecorder.this).setVisibility(8);
                return;
            }
            if (VineRecorder.access$1400(VineRecorder.this).getVisibility() != 0)
            {
                VineRecorder.access$1400(VineRecorder.this).setVisibility(0);
            }
            VineRecorder.access$1400(VineRecorder.this).setImageDrawable(new BitmapDrawable(VineRecorder.access$300(VineRecorder.this), val$ghostBitmap));
            return;
        }
    }

    ()
    {
        this$0 = final_vinerecorder;
        val$ghostBitmap = Bitmap.this;
        super();
    }
}

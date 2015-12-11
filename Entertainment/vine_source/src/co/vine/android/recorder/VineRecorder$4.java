// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;
import co.vine.android.util.ViewUtil;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder, RecordController

class this._cls0
    implements Runnable
{

    final VineRecorder this$0;

    public void run()
    {
        if (VineRecorder.access$100(VineRecorder.this) != null)
        {
            Drawable drawable;
            if (mVideoController.canChangeFocus())
            {
                drawable = VineRecorder.access$300(VineRecorder.this).getDrawable(VineRecorder.access$200(VineRecorder.this));
            } else
            {
                drawable = VineRecorder.access$300(VineRecorder.this).getDrawable(VineRecorder.access$400(VineRecorder.this));
            }
            if (VineRecorder.access$500(VineRecorder.this))
            {
                drawable.setColorFilter(VineRecorder.access$600(VineRecorder.this), android.graphics..SRC_ATOP);
            }
            if (mVideoController.canChangeFocus())
            {
                VineRecorder.access$100(VineRecorder.this).setAlpha(0.35F);
            } else
            {
                VineRecorder.access$100(VineRecorder.this).setAlpha(1.0F);
            }
            ViewUtil.setBackground(VineRecorder.access$100(VineRecorder.this), drawable);
        }
        setAutoFocusing(true);
        if (VineRecorder.access$700(VineRecorder.this) != null)
        {
            if (mFrontFacing)
            {
                VineRecorder.access$700(VineRecorder.this).getChildAt(0).setAlpha(1.0F);
            } else
            {
                VineRecorder.access$700(VineRecorder.this).getChildAt(0).setAlpha(0.35F);
            }
        }
        if (VineRecorder.access$800(VineRecorder.this) != null)
        {
            VineRecorder.access$800(VineRecorder.this).setChecked(VineRecorder.access$900(VineRecorder.this));
        }
    }

    r()
    {
        this$0 = VineRecorder.this;
        super();
    }
}

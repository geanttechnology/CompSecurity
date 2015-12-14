// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.SeekBar;
import android.widget.TextView;
import com.cyberlink.youcammakeup.utility.bk;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            ak

public class SliderValueText extends TextView
{

    private GestureDetector a;
    private SeekBar b;
    private int c;
    private Boolean d;
    private android.animation.Animator.AnimatorListener e;

    public SliderValueText(Context context)
    {
        super(context);
        c = 0;
        d = Boolean.valueOf(true);
        e = null;
    }

    public SliderValueText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = 0;
        d = Boolean.valueOf(true);
        e = null;
        a = new GestureDetector(context, new ak(this));
    }

    public SliderValueText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c = 0;
        d = Boolean.valueOf(true);
        e = null;
    }

    static Boolean a(SliderValueText slidervaluetext)
    {
        return slidervaluetext.d;
    }

    public void a()
    {
        if (b != null)
        {
            bk.a(b, c, null, e);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (a != null)
        {
            a.onTouchEvent(motionevent);
        }
        return true;
    }

    public void setDefaultValue(int i)
    {
        c = i;
    }

    public void setDoubleTapAble(Boolean boolean1)
    {
        d = boolean1;
    }

    public void setDoubleTapCallback(android.animation.Animator.AnimatorListener animatorlistener)
    {
        e = animatorlistener;
    }

    public void setSlider(SeekBar seekbar)
    {
        b = seekbar;
    }
}

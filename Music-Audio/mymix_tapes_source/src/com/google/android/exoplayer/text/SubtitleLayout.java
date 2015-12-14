// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.text:
//            CaptionStyleCompat, CuePainter, Cue

public final class SubtitleLayout extends View
{

    private List cues;
    private float fontScale;
    private final List painters;
    private CaptionStyleCompat style;

    public SubtitleLayout(Context context)
    {
        this(context, null);
    }

    public SubtitleLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        painters = new ArrayList();
        fontScale = 1.0F;
        style = CaptionStyleCompat.DEFAULT;
    }

    public void dispatchDraw(Canvas canvas)
    {
        int i;
        int j;
        if (cues == null)
        {
            i = 0;
        } else
        {
            i = cues.size();
        }
        for (j = 0; j < i; j++)
        {
            ((CuePainter)painters.get(j)).draw((Cue)cues.get(j), style, fontScale, canvas, getLeft(), getTop(), getRight(), getBottom());
        }

    }

    public void setCues(List list)
    {
        if (cues == list)
        {
            return;
        }
        cues = list;
        int i;
        if (list == null)
        {
            i = 0;
        } else
        {
            i = list.size();
        }
        for (; painters.size() < i; painters.add(new CuePainter(getContext()))) { }
        invalidate();
    }

    public void setFontScale(float f)
    {
        if (fontScale == f)
        {
            return;
        } else
        {
            fontScale = f;
            invalidate();
            return;
        }
    }

    public void setStyle(CaptionStyleCompat captionstylecompat)
    {
        if (style == captionstylecompat)
        {
            return;
        } else
        {
            style = captionstylecompat;
            invalidate();
            return;
        }
    }
}

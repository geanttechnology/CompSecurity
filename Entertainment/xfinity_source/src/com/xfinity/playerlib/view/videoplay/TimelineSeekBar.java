// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import com.comcast.playerplatform.primetime.android.primetime.TimelineMarker;
import java.util.Iterator;

public class TimelineSeekBar extends SeekBar
{

    private long duration;
    private Bitmap highlightMarker;
    private Bitmap marker;
    private PlayerTimeline playerTimeline;

    public TimelineSeekBar(Context context)
    {
        super(context);
        marker = BitmapFactory.decodeResource(getResources(), com.xfinity.playerlib.R.drawable.ad_break);
        highlightMarker = BitmapFactory.decodeResource(getResources(), com.xfinity.playerlib.R.drawable.ad_break_light);
    }

    public TimelineSeekBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        marker = BitmapFactory.decodeResource(getResources(), com.xfinity.playerlib.R.drawable.ad_break);
        highlightMarker = BitmapFactory.decodeResource(getResources(), com.xfinity.playerlib.R.drawable.ad_break_light);
    }

    protected void onDraw(Canvas canvas)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator;
        super.onDraw(canvas);
        if (playerTimeline == null)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        iterator = playerTimeline.timelineMarkers();
_L2:
        int i;
        do
        {
            long l1;
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_214;
                }
                l1 = ((TimelineMarker)iterator.next()).getTime();
            } while (l1 > duration || getWidth() <= 0);
            i = (int)((double)(getWidth() - getThumbOffset() * 2) * ((double)l1 / (double)duration) + (double)getThumbOffset());
            if ((int)((double)(getWidth() - getThumbOffset() * 2) * ((double)getProgress() / (double)getMax()) + (double)getThumbOffset()) <= i)
            {
                break MISSING_BLOCK_LABEL_173;
            }
            int j = getHeight() / 2;
            int l = highlightMarker.getHeight() / 2;
            canvas.drawBitmap(highlightMarker, i, j - l - 1, null);
        } while (true);
        canvas;
        throw canvas;
        int k = getHeight() / 2;
        int i1 = marker.getHeight() / 2;
        canvas.drawBitmap(marker, i, k - i1 - 1, null);
        if (true) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
    }

    public void setMarkersAndDuration(PlayerTimeline playertimeline, long l)
    {
        playerTimeline = playertimeline;
        duration = l;
    }
}

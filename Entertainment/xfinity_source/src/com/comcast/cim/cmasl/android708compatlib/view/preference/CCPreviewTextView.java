// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android708compatlib.view.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class CCPreviewTextView extends TextView
{

    private int edgeColor;
    private com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge edgeType;
    private final Paint outlinePaint;

    public CCPreviewTextView(Context context)
    {
        super(context);
        outlinePaint = new Paint();
    }

    public CCPreviewTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        outlinePaint = new Paint();
    }

    protected void onDraw(Canvas canvas)
    {
        if (edgeType != com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.UNIFORM && edgeType != com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.RAISED && edgeType != com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.DEPRESSED) goto _L2; else goto _L1
_L1:
        outlinePaint.setAntiAlias(true);
        outlinePaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        outlinePaint.setStrokeWidth(getResources().getDimensionPixelSize(com.comcast.cim.cmasl.android708compatlib.R.dimen.cc_preview_outline_stroke_width));
        outlinePaint.setColor(edgeColor);
        outlinePaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        outlinePaint.setTextSize(getTextSize());
        outlinePaint.setTypeface(getTypeface());
        static class _cls1
        {

            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge[];

            static 
            {
                $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge = new int[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.DROP_SHADOW_RIGHT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.DROP_SHADOW_LEFT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.UNIFORM.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.RAISED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge[com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge.DEPRESSED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge[edgeType.ordinal()];
        JVM INSTR tableswitch 3 5: default 148
    //                   3 154
    //                   4 178
    //                   5 205;
           goto _L2 _L3 _L4 _L5
_L2:
        super.onDraw(canvas);
        return;
_L3:
        canvas.drawText((String)getText(), 0.0F, getBaseline(), outlinePaint);
        continue; /* Loop/switch isn't completed */
_L4:
        canvas.drawText((String)getText(), -2F, getBaseline() - 2, outlinePaint);
        continue; /* Loop/switch isn't completed */
_L5:
        canvas.drawText((String)getText(), 2.0F, getBaseline(), outlinePaint);
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void setEdge(com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge fontedge, int i)
    {
        edgeType = fontedge;
        edgeColor = i;
        switch (_cls1..SwitchMap.com.comcast.playerplatform.primetime.android.util.ClosedCaptionsFormat.FontEdge[fontedge.ordinal()])
        {
        default:
            setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            return;

        case 1: // '\001'
            setShadowLayer(10F, 2.0F, 2.0F, i);
            return;

        case 2: // '\002'
            setShadowLayer(10F, -2F, 2.0F, i);
            break;
        }
    }
}

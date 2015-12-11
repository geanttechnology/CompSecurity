// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.TextPaint;
import android.view.Gravity;
import android.widget.Button;

// Referenced classes of package com.inc247:
//            ChatSDK, ChatSDKResources

public class ChatSDKMaximizeButton extends Button
{

    final boolean topDown;

    public ChatSDKMaximizeButton(Context context)
    {
        super(context);
        int i = getGravity();
        if (Gravity.isVertical(i) && (i & 0x70) == 80)
        {
            setGravity(i & 7 | 0x30);
            topDown = true;
            return;
        } else
        {
            topDown = false;
            return;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        TextPaint textpaint = getPaint();
        textpaint.setColor(getCurrentTextColor());
        textpaint.drawableState = getDrawableState();
        canvas.save();
        if (shouldRotate())
        {
            if (topDown)
            {
                canvas.translate(getWidth(), 0.0F);
                canvas.rotate(90F);
            } else
            {
                canvas.translate(0.0F, getHeight());
                canvas.rotate(-90F);
            }
        }
        canvas.translate(getCompoundPaddingLeft(), getExtendedPaddingTop());
        getLayout().draw(canvas);
        canvas.restore();
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(j, i);
        if (shouldRotate())
        {
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public boolean shouldRotate()
    {
        return ChatSDK.getSDKInstance().activity.getResources().getConfiguration().orientation != 1 ? !ChatSDKResources.MAXIMIZE_BUTTON_POSITION_LANDSCAPE.equalsIgnoreCase("top-center") && !ChatSDKResources.MAXIMIZE_BUTTON_POSITION_LANDSCAPE.equalsIgnoreCase("bottom-center") : !ChatSDKResources.MAXIMIZE_BUTTON_POSITION_PORTRAIT.equalsIgnoreCase("top-center") && !ChatSDKResources.MAXIMIZE_BUTTON_POSITION_PORTRAIT.equalsIgnoreCase("bottom-center");
    }
}

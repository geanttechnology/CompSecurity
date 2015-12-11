// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ClearView extends View
{
    public static interface OnAngelChangeListener
    {

        public abstract void OnAngelChanged(int i);
    }


    private OnAngelChangeListener angelListener;
    private int color;
    private int heigth;
    private boolean isRun;
    private Paint paint;
    private RectF rectf;
    boolean state;
    private int sweepAngle;
    private int width;

    public ClearView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        isRun = false;
        state = true;
        paint = new Paint();
        paint.setAntiAlias(true);
        color = 0xff75a7f9;
        sweepAngle = 230;
    }

    public void SetonAngelchanged(OnAngelChangeListener onangelchangelistener)
    {
        angelListener = onangelchangelistener;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        paint.setColor(color);
        canvas.drawArc(rectf, -90F, sweepAngle, true, paint);
        if (angelListener != null)
        {
            angelListener.OnAngelChanged(sweepAngle);
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        width = android.view.View.MeasureSpec.getSize(i);
        heigth = android.view.View.MeasureSpec.getSize(j);
        rectf = new RectF(0.0F, 0.0F, width, heigth);
        setMeasuredDimension(width, heigth);
    }

    public void setAngle(final int angle)
    {
        if (isRun)
        {
            return;
        } else
        {
            state = true;
            isRun = true;
            (new Thread() {

                final ClearView this$0;
                private final int val$angle;

                public void run()
                {
_L3:
                    if (!isRun)
                    {
                        return;
                    }
                    ClearView clearview;
                    try
                    {
                        Thread.sleep(8L);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                    if (!state) goto _L2; else goto _L1
_L1:
                    clearview = ClearView.this;
                    clearview.sweepAngle = clearview.sweepAngle - 2;
                    if (sweepAngle <= 0)
                    {
                        sweepAngle = 0;
                        state = false;
                    }
_L4:
                    ClearView clearview1;
                    if (sweepAngle < 100)
                    {
                        color = 0xff75a7f9;
                    } else
                    if (sweepAngle < 250)
                    {
                        color = 0xff75a7f9;
                    } else
                    {
                        color = 0xff75a7f9;
                    }
                    postInvalidate();
                    if (true) goto _L3; else goto _L2
_L2:
                    clearview1 = ClearView.this;
                    clearview1.sweepAngle = clearview1.sweepAngle + 2;
                    if (sweepAngle >= angle)
                    {
                        sweepAngle = angle;
                        isRun = false;
                    }
                      goto _L4
                }

            
            {
                this$0 = ClearView.this;
                angle = i;
                super();
            }
            }).start();
            return;
        }
    }





}

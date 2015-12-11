// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class eBayRating extends View
    implements android.view.View.OnTouchListener
{

    private static final int DEFAULT_THRESHOLD = 2;
    private Context context;
    private boolean defaultFiveStarRating;
    private boolean displayedFiveStarRatingImmutable;
    private int filledStarGreenDrawableId;
    private int filledStarRedDrawableId;
    private boolean fiveStartRatingImmutable;
    private int halfStarDrawableId;
    private Bitmap m_filled_star_green;
    private Bitmap m_filled_star_red;
    private Bitmap m_half_star;
    private float m_last_star_touched;
    private final int m_num_stars;
    private int m_threshold;
    private Bitmap m_unfilled_star;
    private Paint paint;
    private Rect rect;
    private int unfilledStarDrawableId;

    public eBayRating(Context context1)
    {
        super(context1);
        defaultFiveStarRating = false;
        fiveStartRatingImmutable = false;
        displayedFiveStarRatingImmutable = false;
        m_filled_star_green = null;
        filledStarGreenDrawableId = -1;
        m_filled_star_red = null;
        filledStarRedDrawableId = -1;
        m_unfilled_star = null;
        unfilledStarDrawableId = -1;
        m_half_star = null;
        halfStarDrawableId = -1;
        m_threshold = 2;
        m_last_star_touched = -1F;
        m_num_stars = 5;
        init();
        m_threshold = 2;
    }

    public eBayRating(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        defaultFiveStarRating = false;
        fiveStartRatingImmutable = false;
        displayedFiveStarRatingImmutable = false;
        m_filled_star_green = null;
        filledStarGreenDrawableId = -1;
        m_filled_star_red = null;
        filledStarRedDrawableId = -1;
        m_unfilled_star = null;
        unfilledStarDrawableId = -1;
        m_half_star = null;
        halfStarDrawableId = -1;
        m_threshold = 2;
        m_last_star_touched = -1F;
        m_num_stars = 5;
        context = context1;
        init(attributeset);
    }

    public eBayRating(Context context1, AttributeSet attributeset, int i)
    {
        super(context1, attributeset, i);
        defaultFiveStarRating = false;
        fiveStartRatingImmutable = false;
        displayedFiveStarRatingImmutable = false;
        m_filled_star_green = null;
        filledStarGreenDrawableId = -1;
        m_filled_star_red = null;
        filledStarRedDrawableId = -1;
        m_unfilled_star = null;
        unfilledStarDrawableId = -1;
        m_half_star = null;
        halfStarDrawableId = -1;
        m_threshold = 2;
        m_last_star_touched = -1F;
        m_num_stars = 5;
        context = context1;
        init(attributeset);
    }

    private void init()
    {
        if (m_filled_star_green == null)
        {
            filledStarGreenDrawableId = 0x7f020199;
            m_filled_star_green = BitmapFactory.decodeResource(getResources(), filledStarGreenDrawableId);
        }
        if (m_filled_star_red == null)
        {
            filledStarRedDrawableId = 0x7f02019c;
            m_filled_star_red = BitmapFactory.decodeResource(getResources(), filledStarRedDrawableId);
        }
        if (m_unfilled_star == null)
        {
            unfilledStarDrawableId = 0x7f02019a;
            m_unfilled_star = BitmapFactory.decodeResource(getResources(), unfilledStarDrawableId);
        }
        paint = new Paint();
        paint.setColor(0xffff0000);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        rect = new Rect();
        setOnTouchListener(this);
    }

    private void init(AttributeSet attributeset)
    {
        init();
        attributeset = getContext().obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.eBayRating);
        m_threshold = attributeset.getInt(0, 2);
        attributeset.recycle();
    }

    private void showShippingCostRatingExplanationDialog()
    {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        builder.setTitle(0x7f070130);
        if (fiveStartRatingImmutable)
        {
            builder.setMessage(context.getString(0x7f070139));
        } else
        {
            builder.setMessage(context.getString(0x7f07013a));
        }
        builder.setPositiveButton(0x7f070738, new android.content.DialogInterface.OnClickListener() {

            final eBayRating this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = eBayRating.this;
                super();
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public float getEbayRoundedValueForStarRating(float f)
    {
        float f1 = (int)f;
        f -= f1;
        if (f < 0.25F)
        {
            return f1;
        }
        if (f >= 0.25F && f <= 0.75F)
        {
            return f1 + 0.5F;
        } else
        {
            return f1 + 1.0F;
        }
    }

    public Bitmap getStarForIndex(int i, float f)
    {
        Bitmap bitmap = null;
        i = getStarIdForIndex(i, f);
        if (i == filledStarRedDrawableId)
        {
            bitmap = m_filled_star_red;
        } else
        {
            if (i == filledStarGreenDrawableId)
            {
                return m_filled_star_green;
            }
            if (i == halfStarDrawableId)
            {
                return m_half_star;
            }
            if (i == unfilledStarDrawableId)
            {
                return m_unfilled_star;
            }
        }
        return bitmap;
    }

    public int getStarIdForIndex(int i, float f)
    {
        if (f >= (float)i)
        {
            if (m_last_star_touched <= (float)m_threshold)
            {
                return filledStarRedDrawableId;
            } else
            {
                return filledStarGreenDrawableId;
            }
        }
        if ((float)((double)i - 0.5D) == f)
        {
            return halfStarDrawableId;
        } else
        {
            return unfilledStarDrawableId;
        }
    }

    public float getValue()
    {
        return m_last_star_touched;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int j = getWidth() / 5;
        int k = (int)((double)j * 0.90000000000000002D);
        float f = getEbayRoundedValueForStarRating(m_last_star_touched);
        int i = 1;
        while (i <= 5) 
        {
            int l = (i - 1) * j;
            Bitmap bitmap = getStarForIndex(i, f);
            if (bitmap != null)
            {
                canvas.drawBitmap(bitmap, l, 0.0F, paint);
            } else
            {
                rect.set(l, 0, l + k, 20);
                canvas.drawRect(rect, paint);
            }
            i++;
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (defaultFiveStarRating && !displayedFiveStarRatingImmutable)
        {
            if (motionevent.getAction() == 0)
            {
                showShippingCostRatingExplanationDialog();
            }
            if (!fiveStartRatingImmutable)
            {
                displayedFiveStarRatingImmutable = true;
            }
            return true;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 1 2: default 64
    //                   1 157
    //                   2 115;
           goto _L1 _L2 _L3
_L1:
        int i = getWidth() / 5;
        int l = (int)motionevent.getX() / i + 1;
        i = l;
        if (l >= 5)
        {
            i = 5;
        }
        if ((float)i != m_last_star_touched)
        {
            m_last_star_touched = i;
            invalidate();
        }
        return false;
_L3:
        if ((motionevent.getEdgeFlags() & 4) != 0)
        {
            m_last_star_touched = -1F;
            invalidate();
        }
        if ((motionevent.getEdgeFlags() & 8) != 0)
        {
            m_last_star_touched = 5F;
            invalidate();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        int j = getWidth() / 5;
        int i1 = (int)motionevent.getX() / j + 1;
        if ((float)i1 != m_last_star_touched)
        {
            int k = i1;
            if (i1 >= 5)
            {
                k = 5;
            }
            m_last_star_touched = k;
            invalidate();
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setDefaultFiveStarRating(boolean flag, boolean flag1)
    {
        defaultFiveStarRating = flag;
        fiveStartRatingImmutable = flag1;
        if (defaultFiveStarRating)
        {
            m_last_star_touched = 5F;
        }
    }

    public void setFeedbackStarResources(int i, int j, int k, int l)
    {
        if (i > 0)
        {
            filledStarGreenDrawableId = i;
            m_filled_star_green = BitmapFactory.decodeResource(getResources(), i);
        }
        if (j > 0)
        {
            unfilledStarDrawableId = j;
            m_unfilled_star = BitmapFactory.decodeResource(getResources(), j);
        }
        if (k > 0)
        {
            filledStarRedDrawableId = k;
            m_filled_star_red = BitmapFactory.decodeResource(getResources(), k);
        }
        if (l > 0)
        {
            halfStarDrawableId = l;
            m_half_star = BitmapFactory.decodeResource(getResources(), l);
        }
        init();
    }

    public void setFeedbackThreshold(int i)
    {
        m_threshold = i;
    }

    public void setValue(float f)
    {
        m_last_star_touched = f;
    }

    public void setValue(int i)
    {
        m_last_star_touched = i;
    }
}

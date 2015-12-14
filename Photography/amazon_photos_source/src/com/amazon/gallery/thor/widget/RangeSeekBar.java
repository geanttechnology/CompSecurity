// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            VideoFramesParams

public class RangeSeekBar extends RelativeLayout
{
    public static interface OnRangeSeekBarChangeListener
    {

        public abstract void onRangeSeekBarFramesLoaded(RangeSeekBar rangeseekbar);

        public abstract void onRangeSeekBarValuesChanged(RangeSeekBar rangeseekbar, int i, int j, int k, Thumb thumb);
    }

    public static final class Thumb extends Enum
    {

        private static final Thumb $VALUES[];
        public static final Thumb MAX;
        public static final Thumb MIDDLE;
        public static final Thumb MIN;

        public static Thumb valueOf(String s)
        {
            return (Thumb)Enum.valueOf(com/amazon/gallery/thor/widget/RangeSeekBar$Thumb, s);
        }

        public static Thumb[] values()
        {
            return (Thumb[])$VALUES.clone();
        }

        static 
        {
            MIN = new Thumb("MIN", 0);
            MAX = new Thumb("MAX", 1);
            MIDDLE = new Thumb("MIDDLE", 2);
            $VALUES = (new Thumb[] {
                MIN, MAX, MIDDLE
            });
        }

        private Thumb(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int CONTAINER_COLOR = Color.argb(230, 29, 29, 29);
    private static int thumbPaddingBottom;
    private static int thumbPaddingTop;
    private int activePointerId;
    private final Bitmap bottomActiveBorder;
    private final Bitmap bottomInactiveBorder;
    private Context context;
    private float downMotionX;
    private final List frames;
    private boolean isDragging;
    private Set listeners;
    private final Bitmap maxActiveThumb;
    private final Bitmap maxInactiveThumb;
    private final Bitmap maxThumbShadow;
    private final Bitmap minActiveThumb;
    private final Bitmap minInactiveThumb;
    private final Bitmap minThumbShadow;
    private boolean notifyWhileDragging;
    private int numFramesLoaded;
    private final Paint opaque;
    private final Paint paint;
    private VideoFramesParams params;
    private final Bitmap placeHolderFrame;
    private Thumb pressedThumb;
    private final Bitmap progressMarker;
    private boolean progressMarkerVisible;
    private final RectF rect;
    private int scaledTouchSlop;
    private int selectedMax;
    private int selectedMin;
    private int selectedProgress;
    private final Bitmap topActiveBorder;
    private final Bitmap topInactiveBorder;
    private final Paint translucent;

    public RangeSeekBar(Context context1)
    {
        super(context1);
        paint = new Paint(1);
        opaque = new Paint() {

            final RangeSeekBar this$0;

            
            {
                this$0 = RangeSeekBar.this;
                super();
                setAlpha(255);
            }
        };
        translucent = new Paint() {

            final RangeSeekBar this$0;

            
            {
                this$0 = RangeSeekBar.this;
                super();
                setColor(RangeSeekBar.CONTAINER_COLOR);
                setAlpha(150);
            }
        };
        rect = new RectF();
        minInactiveThumb = BitmapFactory.decodeResource(getResources(), 0x7f0201fd);
        minActiveThumb = BitmapFactory.decodeResource(getResources(), 0x7f0201fe);
        minThumbShadow = BitmapFactory.decodeResource(getResources(), 0x7f020202);
        maxInactiveThumb = BitmapFactory.decodeResource(getResources(), 0x7f020200);
        maxActiveThumb = BitmapFactory.decodeResource(getResources(), 0x7f020201);
        maxThumbShadow = BitmapFactory.decodeResource(getResources(), 0x7f020203);
        topInactiveBorder = BitmapFactory.decodeResource(getResources(), 0x7f020204);
        topActiveBorder = BitmapFactory.decodeResource(getResources(), 0x7f020205);
        bottomInactiveBorder = BitmapFactory.decodeResource(getResources(), 0x7f0201fb);
        bottomActiveBorder = BitmapFactory.decodeResource(getResources(), 0x7f0201fc);
        placeHolderFrame = BitmapFactory.decodeResource(getResources(), 0x7f0201f5);
        progressMarker = BitmapFactory.decodeResource(getResources(), 0x7f0201ff);
        frames = Collections.synchronizedList(new ArrayList(10));
        pressedThumb = null;
        selectedMin = 0;
        selectedMax = 0;
        selectedProgress = 0;
        numFramesLoaded = 0;
        notifyWhileDragging = false;
        listeners = Collections.synchronizedSet(new HashSet());
        activePointerId = 255;
        progressMarkerVisible = false;
        init(context1);
    }

    public RangeSeekBar(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        paint = new Paint(1);
        opaque = new _cls1();
        translucent = new _cls2();
        rect = new RectF();
        minInactiveThumb = BitmapFactory.decodeResource(getResources(), 0x7f0201fd);
        minActiveThumb = BitmapFactory.decodeResource(getResources(), 0x7f0201fe);
        minThumbShadow = BitmapFactory.decodeResource(getResources(), 0x7f020202);
        maxInactiveThumb = BitmapFactory.decodeResource(getResources(), 0x7f020200);
        maxActiveThumb = BitmapFactory.decodeResource(getResources(), 0x7f020201);
        maxThumbShadow = BitmapFactory.decodeResource(getResources(), 0x7f020203);
        topInactiveBorder = BitmapFactory.decodeResource(getResources(), 0x7f020204);
        topActiveBorder = BitmapFactory.decodeResource(getResources(), 0x7f020205);
        bottomInactiveBorder = BitmapFactory.decodeResource(getResources(), 0x7f0201fb);
        bottomActiveBorder = BitmapFactory.decodeResource(getResources(), 0x7f0201fc);
        placeHolderFrame = BitmapFactory.decodeResource(getResources(), 0x7f0201f5);
        progressMarker = BitmapFactory.decodeResource(getResources(), 0x7f0201ff);
        frames = Collections.synchronizedList(new ArrayList(10));
        pressedThumb = null;
        selectedMin = 0;
        selectedMax = 0;
        selectedProgress = 0;
        numFramesLoaded = 0;
        notifyWhileDragging = false;
        listeners = Collections.synchronizedSet(new HashSet());
        activePointerId = 255;
        progressMarkerVisible = false;
        init(context1);
    }

    private void attemptClaimDrag()
    {
        if (getParent() != null)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private float boundValue(float f, float f1, float f2)
    {
        return Math.min(f1, Math.max(f, f2));
    }

    private int boundValue(int i, int j, int k)
    {
        return Math.min(j, Math.max(i, k));
    }

    private float computeDrift(float f, boolean flag)
    {
        float f1 = downMotionX;
        if (flag)
        {
            downMotionX = f;
        }
        return f1 - f;
    }

    private void dragMax(float f)
    {
        if (f == 0.0F) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        int i = screenCoordToValue(valueToScreenCoord(getSelectedMax()) - f);
        l = boundValue(params.min + params.minVideoDuration, params.max, i);
        k = getSelectedMin();
        if (k >= l - params.maxVideoDuration) goto _L4; else goto _L3
_L3:
        int j = screenCoordToValue(valueToScreenCoord(getSelectedMin()) - f);
_L6:
        j = boundValue(params.min, params.max - params.minVideoDuration, j);
        setSelectedMax(l);
        setSelectedMin(j);
_L2:
        return;
_L4:
        j = k;
        if (k > l - params.minVideoDuration)
        {
            j = l - params.minVideoDuration;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void dragMin(float f)
    {
        if (f == 0.0F) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        int i = screenCoordToValue(valueToScreenCoord(getSelectedMin()) - f);
        l = boundValue(params.min, params.max - params.minVideoDuration, i);
        k = getSelectedMax();
        if (k <= params.maxVideoDuration + l) goto _L4; else goto _L3
_L3:
        int j = screenCoordToValue(valueToScreenCoord(getSelectedMax()) - f);
_L6:
        j = boundValue(params.min + params.minVideoDuration, params.max, j);
        setSelectedMin(l);
        setSelectedMax(j);
_L2:
        return;
_L4:
        j = k;
        if (k < params.minVideoDuration + l)
        {
            j = l + params.minVideoDuration;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void dragMinMax(float f)
    {
        int k;
        int l;
        k = screenCoordToValue(valueToScreenCoord(getSelectedMin()) - f);
        l = screenCoordToValue(valueToScreenCoord(getSelectedMax()) - f);
        if (f <= 0.0F || k > params.min) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = params.min;
        i = getSelectedMax() - (getSelectedMin() - j);
_L4:
        setSelectedMin(j);
        setSelectedMax(i);
        return;
_L2:
        i = l;
        j = k;
        if (f < 0.0F)
        {
            i = l;
            j = k;
            if (l >= params.max)
            {
                i = params.max;
                j = getSelectedMin() - (getSelectedMax() - i);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void drawBorder(boolean flag, Canvas canvas)
    {
        float f = valueToScreenCoord(selectedMin);
        float f1 = valueToScreenCoord(selectedMax);
        Bitmap bitmap;
        Bitmap bitmap1;
        if (flag)
        {
            bitmap = topActiveBorder;
        } else
        {
            bitmap = topInactiveBorder;
        }
        if (flag)
        {
            bitmap1 = bottomActiveBorder;
        } else
        {
            bitmap1 = bottomInactiveBorder;
        }
        for (; f <= f1; f++)
        {
            canvas.drawBitmap(bitmap, f, thumbPaddingTop, paint);
            canvas.drawBitmap(bitmap1, f, getHeight() - thumbPaddingBottom - bottomActiveBorder.getHeight(), paint);
        }

    }

    private void drawFrames(Canvas canvas)
    {
        float f = valueToScreenCoord(params.min);
        for (Iterator iterator = frames.iterator(); iterator.hasNext();)
        {
            Bitmap bitmap = (Bitmap)iterator.next();
            canvas.drawBitmap(bitmap, f, getPaddingTop(), opaque);
            f += bitmap.getWidth();
        }

    }

    private void drawProgressMarker(Canvas canvas)
    {
        if (!progressMarkerVisible)
        {
            return;
        } else
        {
            float f = valueToScreenCoord(selectedProgress);
            float f1 = progressMarker.getWidth() / 2;
            float f2 = (minActiveThumb.getHeight() - progressMarker.getHeight()) / 2;
            float f3 = thumbPaddingTop;
            canvas.drawBitmap(progressMarker, f - f1, f3 + f2, paint);
            return;
        }
    }

    private void drawThumb(boolean flag, Canvas canvas)
    {
        float f = valueToScreenCoord(selectedMin);
        float f1 = minActiveThumb.getWidth();
        Bitmap bitmap;
        if (flag)
        {
            bitmap = minActiveThumb;
        } else
        {
            bitmap = minInactiveThumb;
        }
        canvas.drawBitmap(bitmap, f - f1, thumbPaddingTop, paint);
        canvas.drawBitmap(minThumbShadow, f, getPaddingTop(), paint);
        f = valueToScreenCoord(selectedMax);
        if (flag)
        {
            bitmap = maxActiveThumb;
        } else
        {
            bitmap = maxInactiveThumb;
        }
        canvas.drawBitmap(bitmap, f, thumbPaddingTop, paint);
        canvas.drawBitmap(maxThumbShadow, f - (float)maxThumbShadow.getWidth(), getPaddingTop(), paint);
    }

    private void drawUnselected(Canvas canvas)
    {
        float f = valueToScreenCoord(selectedMin);
        float f1 = valueToScreenCoord(selectedMax);
        float f2 = getPaddingTop();
        float f3 = getHeight() - getPaddingBottom();
        float f4 = minActiveThumb.getWidth();
        rect.set((float)getPaddingLeft() + f4, f2, f, f3);
        canvas.drawRect(rect, translucent);
        rect.set(f1, f2, (float)(getWidth() - getPaddingRight()) - f4, f3);
        canvas.drawRect(rect, translucent);
    }

    private Thumb evalPressedThumb(float f)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag2 = true;
        Thumb thumb = null;
        float f1 = valueToScreenCoord(selectedMin);
        float f2 = valueToScreenCoord(selectedMax);
        if (f >= f1 - (float)minActiveThumb.getWidth() && f <= f1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (f >= f2 && f <= (float)maxActiveThumb.getWidth() + f2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (f <= f1 || f >= f2)
        {
            flag2 = false;
        }
        if (!flag || !flag1) goto _L2; else goto _L1
_L1:
        if (f / (float)getWidth() <= 0.5F) goto _L4; else goto _L3
_L3:
        thumb = Thumb.MIN;
_L6:
        return thumb;
_L4:
        return Thumb.MAX;
_L2:
        if (flag)
        {
            return Thumb.MIN;
        }
        if (flag1)
        {
            return Thumb.MAX;
        }
        if (flag2)
        {
            return Thumb.MIDDLE;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private float getLeftSpace()
    {
        return (float)(getPaddingLeft() + minActiveThumb.getWidth());
    }

    private float getRightSpace()
    {
        return (float)(getPaddingRight() + maxActiveThumb.getWidth());
    }

    private void init(Context context1)
    {
        context = context1;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setBackgroundColor(CONTAINER_COLOR);
        context1 = context1.getResources();
        thumbPaddingTop = context1.getDimensionPixelSize(0x7f0a004a);
        thumbPaddingBottom = context1.getDimensionPixelSize(0x7f0a0049);
        setPadding(context1.getDimensionPixelSize(0x7f0a0046), context1.getDimensionPixelSize(0x7f0a0048), context1.getDimensionPixelSize(0x7f0a0047), context1.getDimensionPixelSize(0x7f0a0045));
        scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private float normalize(float f, float f1, float f2)
    {
        return (f2 - f) / (f1 - f);
    }

    private void notifyFramesLoaded()
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((OnRangeSeekBarChangeListener)iterator.next()).onRangeSeekBarFramesLoaded(this)) { }
    }

    private void notifyValuesChanged()
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((OnRangeSeekBarChangeListener)iterator.next()).onRangeSeekBarValuesChanged(this, getSelectedMin(), getSelectedMax(), getSelectedProgress(), pressedThumb)) { }
    }

    private final void onSecondaryPointerUp(MotionEvent motionevent)
    {
        int i = (motionevent.getAction() & 0xff00) >> 8;
        if (motionevent.getPointerId(i) == activePointerId)
        {
            if (i == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            downMotionX = motionevent.getX(i);
            activePointerId = motionevent.getPointerId(i);
        }
    }

    private int screenCoordToValue(float f)
    {
        float f1 = getLeftSpace();
        float f2 = getRightSpace();
        f = boundValue(f1, f1 + ((float)getWidth() - f1 - f2), f);
        f = normalize(f1, (float)getWidth() - f2, f);
        return (int)((float)params.min + (float)(params.max - params.min) * f);
    }

    private final void trackTouchEvent(MotionEvent motionevent)
    {
        float f = motionevent.getX(motionevent.findPointerIndex(activePointerId));
        float f1 = computeDrift(f, true);
        screenCoordToValue(f);
        static class _cls3
        {

            static final int $SwitchMap$com$amazon$gallery$thor$widget$RangeSeekBar$Thumb[];

            static 
            {
                $SwitchMap$com$amazon$gallery$thor$widget$RangeSeekBar$Thumb = new int[Thumb.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$widget$RangeSeekBar$Thumb[Thumb.MIN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$widget$RangeSeekBar$Thumb[Thumb.MAX.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$widget$RangeSeekBar$Thumb[Thumb.MIDDLE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3..SwitchMap.com.amazon.gallery.thor.widget.RangeSeekBar.Thumb[pressedThumb.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            dragMin(f1);
            return;

        case 2: // '\002'
            dragMax(f1);
            return;

        case 3: // '\003'
            dragMinMax(f1);
            break;
        }
    }

    private float valueToScreenCoord(int i)
    {
        float f = normalize(params.min, params.max, i);
        float f1 = getLeftSpace();
        float f2 = getRightSpace();
        return ((float)getWidth() - f1 - f2) * f + f1;
    }

    public int getSelectedMax()
    {
        return selectedMax;
    }

    public int getSelectedMin()
    {
        return selectedMin;
    }

    public int getSelectedProgress()
    {
        return selectedProgress;
    }

    public void hideProgressMarker()
    {
        progressMarkerVisible = false;
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        this;
        JVM INSTR monitorenter ;
        VideoFramesParams videoframesparams;
        super.onDraw(canvas);
        videoframesparams = params;
        if (videoframesparams != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        boolean flag;
        if (pressedThumb != Thumb.MIN && pressedThumb != Thumb.MAX && pressedThumb != Thumb.MIDDLE)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        drawFrames(canvas);
        drawProgressMarker(canvas);
        drawUnselected(canvas);
        drawThumb(flag, canvas);
        drawBorder(flag, canvas);
        if (true) goto _L1; else goto _L3
_L3:
        canvas;
        throw canvas;
    }

    protected void onMeasure(int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        int k;
        int l;
        k = context.getResources().getDimensionPixelSize(0x7f0a004b);
        if (android.view.View.MeasureSpec.getMode(i) != 0)
        {
            k = android.view.View.MeasureSpec.getSize(i);
        }
        l = context.getResources().getDimensionPixelSize(0x7f0a0044);
        i = l;
        if (android.view.View.MeasureSpec.getMode(j) != 0)
        {
            i = Math.min(l, android.view.View.MeasureSpec.getSize(j));
        }
        setMeasuredDimension(k, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (Bundle)parcelable;
        super.onRestoreInstanceState(parcelable.getParcelable("SUPER"));
        selectedMin = parcelable.getInt("MIN");
        selectedMax = parcelable.getInt("MAX");
        selectedProgress = parcelable.getInt("PROGRESS");
        frames.clear();
        parcelable = parcelable.getParcelableArray("FRAMES");
        int j = parcelable.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = parcelable[i];
            frames.add((Bitmap)obj);
        }

    }

    protected Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER", super.onSaveInstanceState());
        bundle.putInt("MIN", selectedMin);
        bundle.putInt("MAX", selectedMax);
        bundle.putInt("PROGRESS", selectedProgress);
        bundle.putParcelableArray("FRAMES", (Parcelable[])frames.toArray(new Parcelable[frames.size()]));
        return bundle;
    }

    void onStartTrackingTouch()
    {
        isDragging = true;
    }

    void onStopTrackingTouch()
    {
        isDragging = false;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag1 = true;
        if (params != null && isEnabled()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        switch (motionevent.getAction() & 0xff)
        {
        case 4: // '\004'
        default:
            return true;

        case 0: // '\0'
            activePointerId = motionevent.getPointerId(motionevent.getPointerCount() - 1);
            downMotionX = motionevent.getX(motionevent.findPointerIndex(activePointerId));
            pressedThumb = evalPressedThumb(downMotionX);
            flag = flag1;
            if (pressedThumb != null)
            {
                setPressed(true);
                invalidate();
                onStartTrackingTouch();
                trackTouchEvent(motionevent);
                attemptClaimDrag();
                return true;
            }
            break;

        case 2: // '\002'
            flag = flag1;
            if (pressedThumb != null)
            {
                if (isDragging)
                {
                    trackTouchEvent(motionevent);
                } else
                if (Math.abs(motionevent.getX(motionevent.findPointerIndex(activePointerId)) - downMotionX) > (float)scaledTouchSlop)
                {
                    setPressed(true);
                    invalidate();
                    onStartTrackingTouch();
                    trackTouchEvent(motionevent);
                    attemptClaimDrag();
                }
                flag = flag1;
                if (notifyWhileDragging)
                {
                    notifyValuesChanged();
                    return true;
                }
            }
            break;

        case 1: // '\001'
            if (isDragging)
            {
                trackTouchEvent(motionevent);
                onStopTrackingTouch();
                setPressed(false);
            }
            pressedThumb = null;
            invalidate();
            notifyValuesChanged();
            return true;

        case 5: // '\005'
            int i = motionevent.getPointerCount() - 1;
            downMotionX = motionevent.getX(i);
            activePointerId = motionevent.getPointerId(i);
            invalidate();
            return true;

        case 6: // '\006'
            onSecondaryPointerUp(motionevent);
            invalidate();
            return true;

        case 3: // '\003'
            if (isDragging)
            {
                onStopTrackingTouch();
                setPressed(false);
            }
            invalidate();
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void refreshSelectedProgress()
    {
        setSelectedProgress(getSelectedProgress());
    }

    public void registerOnRangeSeekBarChangeListener(OnRangeSeekBarChangeListener onrangeseekbarchangelistener)
    {
        listeners.add(onrangeseekbarchangelistener);
    }

    public void setFrame(int i, Bitmap bitmap, boolean flag)
    {
        if (bitmap != null)
        {
            frames.set(i, bitmap);
            i = numFramesLoaded + 1;
            numFramesLoaded = i;
            if (i == frames.size())
            {
                notifyFramesLoaded();
            }
            if (flag)
            {
                postInvalidate();
            }
        }
    }

    public void setFrames(Bitmap abitmap[])
    {
        if (abitmap == null)
        {
            return;
        }
        for (int i = 0; i < abitmap.length; i++)
        {
            setFrame(i, abitmap[i], false);
        }

        postInvalidate();
    }

    public void setNotifyWhileDragging(boolean flag)
    {
        notifyWhileDragging = flag;
    }

    public void setSelectedMax(int i)
    {
        selectedMax = boundValue(params.min, params.max, i);
        refreshSelectedProgress();
        invalidate();
    }

    public void setSelectedMin(int i)
    {
        selectedMin = boundValue(params.min, params.max, i);
        refreshSelectedProgress();
        invalidate();
    }

    public void setSelectedProgress(int i)
    {
        selectedProgress = boundValue(selectedMin, selectedMax, i);
        invalidate();
    }

    public void setVideoFramesParams(VideoFramesParams videoframesparams)
        throws IllegalArgumentException
    {
        params = videoframesparams;
        selectedMin = boundValue(videoframesparams.min, videoframesparams.max, videoframesparams.min);
        selectedMax = boundValue(videoframesparams.min, videoframesparams.max, videoframesparams.min + videoframesparams.maxVideoDuration);
        selectedProgress = boundValue(videoframesparams.min, videoframesparams.max, videoframesparams.min);
        for (int i = 0; i < videoframesparams.framesCount; i++)
        {
            frames.add(placeHolderFrame);
        }

    }

    public void showProgressMarker()
    {
        progressMarkerVisible = true;
        invalidate();
    }

    public void unregisterOnRangeSeekBarChangeListener(OnRangeSeekBarChangeListener onrangeseekbarchangelistener)
    {
        listeners.remove(onrangeseekbarchangelistener);
    }


}

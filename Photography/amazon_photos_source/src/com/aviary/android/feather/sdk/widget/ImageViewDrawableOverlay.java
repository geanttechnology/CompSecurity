// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.aviary.android.feather.library.graphics.drawable.EditableDrawable;
import com.aviary.android.feather.library.graphics.drawable.FeatherDrawable;
import com.aviary.android.feather.library.services.drag.DragView;
import com.aviary.android.feather.library.services.drag.DropTarget;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            DrawableHighlightView

public class ImageViewDrawableOverlay extends ImageViewTouch
    implements DropTarget
{
    public static interface OnDrawableEventListener
    {

        public abstract void onClick(DrawableHighlightView drawablehighlightview);

        public abstract void onDown(DrawableHighlightView drawablehighlightview);

        public abstract void onFocusChange(DrawableHighlightView drawablehighlightview, DrawableHighlightView drawablehighlightview1);

        public abstract void onMove(DrawableHighlightView drawablehighlightview);
    }


    public static final float ANIMATION_INCREASE_RATIO = 1.5F;
    public static final float BLUR_MASK_RADIUS = 4F;
    public static final float MIN_SIZE_INCREASE_RATIO = 1.1F;
    private OnDrawableEventListener mDrawableListener;
    private Paint mDropPaint;
    private com.aviary.android.feather.library.services.drag.DropTarget.DropTargetListener mDropTargetListener;
    private boolean mForceSingleSelection;
    float mLastMotionScrollX;
    float mLastMotionScrollY;
    private int mOverlayStyleId;
    private DrawableHighlightView mOverlayView;
    private List mOverlayViews;
    private boolean mScaleWithContent;
    boolean mScrollStarted;
    private Rect mTempRect;

    public ImageViewDrawableOverlay(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mOverlayViews = new ArrayList();
        mForceSingleSelection = true;
        mTempRect = new Rect();
        mScaleWithContent = false;
    }

    public ImageViewDrawableOverlay(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mOverlayViews = new ArrayList();
        mForceSingleSelection = true;
        mTempRect = new Rect();
        mScaleWithContent = false;
    }

    private DrawableHighlightView checkSelection(MotionEvent motionevent)
    {
        Iterator iterator = mOverlayViews.iterator();
        DrawableHighlightView drawablehighlightview = null;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DrawableHighlightView drawablehighlightview1 = (DrawableHighlightView)iterator.next();
            if (drawablehighlightview1.getHit(motionevent.getX(), motionevent.getY()) != 1)
            {
                drawablehighlightview = drawablehighlightview1;
            }
        } while (true);
        return drawablehighlightview;
    }

    private void ensureVisible(DrawableHighlightView drawablehighlightview, float f, float f1)
    {
        drawablehighlightview = drawablehighlightview.getDrawRect();
        int i = 0;
        int k = 0;
        int j = 0;
        int l = 0;
        if (f > 0.0F)
        {
            i = (int)Math.max(0.0F, (float)getLeft() - ((RectF) (drawablehighlightview)).left);
        }
        if (f < 0.0F)
        {
            k = (int)Math.min(0.0F, (float)getRight() - ((RectF) (drawablehighlightview)).right);
        }
        if (f1 > 0.0F)
        {
            j = (int)Math.max(0.0F, (float)getTop() - ((RectF) (drawablehighlightview)).top);
        }
        if (f1 < 0.0F)
        {
            l = (int)Math.min(0.0F, (float)getBottom() - ((RectF) (drawablehighlightview)).bottom);
        }
        if (i == 0)
        {
            i = k;
        }
        if (j == 0)
        {
            j = l;
        }
        if (i != 0 || j != 0)
        {
            panBy(i, j);
        }
    }

    public boolean acceptDrop(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj)
    {
        if (mDropTargetListener != null)
        {
            return mDropTargetListener.acceptDrop(dragsource, i, j, k, l, dragview, obj);
        } else
        {
            return false;
        }
    }

    public boolean addHighlightView(DrawableHighlightView drawablehighlightview)
    {
        for (int i = 0; i < mOverlayViews.size(); i++)
        {
            if (((DrawableHighlightView)mOverlayViews.get(i)).equals(drawablehighlightview))
            {
                return false;
            }
        }

        mOverlayViews.add(drawablehighlightview);
        postInvalidate();
        if (mOverlayViews.size() == 1)
        {
            setSelectedHighlightView(drawablehighlightview);
        }
        return true;
    }

    public void clearOverlays()
    {
        Log.i("ImageViewTouchBase", "clearOverlays");
        setSelectedHighlightView(null);
        for (; mOverlayViews.size() > 0; ((DrawableHighlightView)mOverlayViews.remove(0)).dispose()) { }
        mOverlayView = null;
    }

    public void commit(Canvas canvas)
    {
        for (int i = 0; i < getHighlightCount(); i++)
        {
            Object obj = getHighlightViewAt(i);
            FeatherDrawable featherdrawable = ((DrawableHighlightView) (obj)).getContent();
            if (featherdrawable instanceof EditableDrawable)
            {
                ((EditableDrawable)featherdrawable).endEdit();
            }
            Matrix matrix = ((DrawableHighlightView) (obj)).getCropRotationMatrix();
            obj = ((DrawableHighlightView) (obj)).getCropRect();
            int j = canvas.save(1);
            canvas.concat(matrix);
            featherdrawable.setBounds(((Rect) (obj)));
            featherdrawable.draw(canvas);
            canvas.restoreToCount(j);
        }

    }

    public Rect estimateDropLocation(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj, 
            Rect rect)
    {
        return null;
    }

    public int getHighlightCount()
    {
        return mOverlayViews.size();
    }

    public DrawableHighlightView getHighlightViewAt(int i)
    {
        if (mOverlayViews.size() > 0)
        {
            return (DrawableHighlightView)mOverlayViews.get(i);
        } else
        {
            return null;
        }
    }

    public int getOverlayStyleId()
    {
        return mOverlayStyleId;
    }

    public boolean getScaleWithContent()
    {
        return mScaleWithContent;
    }

    public DrawableHighlightView getSelectedHighlightView()
    {
        return mOverlayView;
    }

    protected void init(Context context, AttributeSet attributeset, int i)
    {
        super.init(context, attributeset, i);
        mTouchSlop = ViewConfiguration.get(context).getScaledDoubleTapSlop();
        mGestureDetector.setIsLongpressEnabled(false);
        context = context.getTheme().obtainStyledAttributes(attributeset, com.aviary.android.feather.sdk.R.styleable.AviaryImageViewDrawableOverlay, i, 0);
        mOverlayStyleId = context.getResourceId(com.aviary.android.feather.sdk.R.styleable.AviaryImageViewDrawableOverlay_aviary_highlightStyle, -1);
        context.recycle();
    }

    public boolean onDown(MotionEvent motionevent)
    {
        Log.i("ImageViewTouchBase", "onDown");
        mScrollStarted = false;
        mLastMotionScrollX = motionevent.getX();
        mLastMotionScrollY = motionevent.getY();
        DrawableHighlightView drawablehighlightview2 = checkSelection(motionevent);
        DrawableHighlightView drawablehighlightview = drawablehighlightview2;
        if (drawablehighlightview2 == null)
        {
            drawablehighlightview = drawablehighlightview2;
            if (mOverlayViews.size() == 1)
            {
                drawablehighlightview = drawablehighlightview2;
                if (mForceSingleSelection)
                {
                    drawablehighlightview = (DrawableHighlightView)mOverlayViews.get(0);
                }
            }
        }
        setSelectedHighlightView(drawablehighlightview);
        if (drawablehighlightview2 != null && mScaleWithContent)
        {
            RectF rectf = drawablehighlightview2.getDisplayRect(drawablehighlightview2.getMatrix(), drawablehighlightview2.getCropRectF());
            boolean flag = drawablehighlightview2.getContent().validateSize(rectf);
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("invalidSize: ").append(flag).toString());
            if (!flag)
            {
                Log.w("ImageViewTouchBase", "drawable too small!!!");
                float f = drawablehighlightview2.getContent().getMinWidth();
                float f1 = drawablehighlightview2.getContent().getMinHeight();
                Log.d("ImageViewTouchBase", (new StringBuilder()).append("minW: ").append(f).toString());
                Log.d("ImageViewTouchBase", (new StringBuilder()).append("minH: ").append(f1).toString());
                float f2 = Math.min(f, f1) * 1.1F;
                Log.d("ImageViewTouchBase", (new StringBuilder()).append("minSize: ").append(f2).toString());
                float f3 = Math.min(rectf.width(), rectf.height());
                Log.d("ImageViewTouchBase", (new StringBuilder()).append("minRectSize: ").append(f3).toString());
                f2 /= f3;
                Log.d("ImageViewTouchBase", (new StringBuilder()).append("diff: ").append(f2).toString());
                Log.d("ImageViewTouchBase", (new StringBuilder()).append("min.size: ").append(f).append("x").append(f1).toString());
                Log.d("ImageViewTouchBase", (new StringBuilder()).append("cur.size: ").append(rectf.width()).append("x").append(rectf.height()).toString());
                Log.d("ImageViewTouchBase", (new StringBuilder()).append("zooming to: ").append(getScale() * f2).toString());
                zoomTo(getScale() * f2, rectf.centerX(), rectf.centerY(), 300L);
                return true;
            }
        }
        if (mOverlayView != null)
        {
            int i = mOverlayView.getHit(motionevent.getX(), motionevent.getY());
            if (i != 1)
            {
                if (i != 128)
                {
                    if (i == 256)
                    {
                        mOverlayView.setMode(256);
                    } else
                    {
                        DrawableHighlightView drawablehighlightview1 = mOverlayView;
                        if (i == 64)
                        {
                            i = 64;
                        } else
                        if (i == 32)
                        {
                            i = 32;
                        } else
                        {
                            i = 30;
                        }
                        drawablehighlightview1.setMode(i);
                    }
                } else
                {
                    mOverlayView.setMode(128);
                }
                postInvalidate();
                if (mDrawableListener != null)
                {
                    mDrawableListener.onDown(mOverlayView);
                }
            }
        }
        return super.onDown(motionevent);
    }

    public void onDragEnter(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj)
    {
        mDropPaint = new Paint();
        mDropPaint.setColor(0xff33b5e5);
        mDropPaint.setStrokeWidth(2.0F);
        mDropPaint.setMaskFilter(new BlurMaskFilter(4F, android.graphics.BlurMaskFilter.Blur.NORMAL));
        mDropPaint.setStyle(android.graphics.Paint.Style.STROKE);
        invalidate();
    }

    public void onDragExit(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj)
    {
        mDropPaint = null;
        invalidate();
    }

    public void onDragOver(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj)
    {
    }

    public void onDragViewDropAnimationFinished(Object obj, DragView dragview)
    {
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        boolean flag = false;
        for (int i = 0; i < mOverlayViews.size();)
        {
            canvas.save(1);
            Object obj = (DrawableHighlightView)mOverlayViews.get(i);
            ((DrawableHighlightView) (obj)).draw(canvas);
            boolean flag1 = flag;
            if (!flag)
            {
                obj = ((DrawableHighlightView) (obj)).getContent();
                flag1 = flag;
                if (obj instanceof EditableDrawable)
                {
                    flag1 = flag;
                    if (((EditableDrawable)obj).isEditing())
                    {
                        flag1 = true;
                    }
                }
            }
            canvas.restore();
            i++;
            flag = flag1;
        }

        if (mDropPaint != null)
        {
            getDrawingRect(mTempRect);
            canvas.drawRect(mTempRect, mDropPaint);
        }
        if (flag)
        {
            postInvalidateDelayed(400L);
        }
    }

    public void onDrop(com.aviary.android.feather.library.services.DragControllerService.DragSource dragsource, int i, int j, int k, int l, DragView dragview, Object obj)
    {
        if (mDropTargetListener != null)
        {
            mDropTargetListener.onDrop(dragsource, i, j, k, l, dragview, obj);
        }
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        Log.i("ImageViewTouchBase", "onFling");
        if (mOverlayView != null && mOverlayView.getMode() != 1)
        {
            return false;
        } else
        {
            return super.onFling(motionevent, motionevent1, f, f1);
        }
    }

    protected void onLayoutChanged(int i, int j, int k, int l)
    {
        super.onLayoutChanged(i, j, k, l);
        if (getDrawable() != null)
        {
            DrawableHighlightView drawablehighlightview;
            for (Iterator iterator = mOverlayViews.iterator(); iterator.hasNext(); drawablehighlightview.invalidate())
            {
                drawablehighlightview = (DrawableHighlightView)iterator.next();
                drawablehighlightview.getMatrix().set(getImageMatrix());
            }

        }
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        Log.i("ImageViewTouchBase", "onScroll");
        float f4 = motionevent1.getX();
        float f5 = motionevent1.getY();
        float f2;
        float f3;
        if (!mScrollStarted)
        {
            f2 = 0.0F;
            f3 = 0.0F;
            mScrollStarted = true;
        } else
        {
            f2 = mLastMotionScrollX - f4;
            f3 = mLastMotionScrollY - f5;
        }
        mLastMotionScrollX = f4;
        mLastMotionScrollY = f5;
        if (mOverlayView != null && mOverlayView.getMode() != 1 && mOverlayView.getMode() != 128)
        {
            mOverlayView.onMouseMove(mOverlayView.getMode(), motionevent1, -f2, -f3);
            postInvalidate();
            if (mDrawableListener != null)
            {
                mDrawableListener.onMove(mOverlayView);
            }
            if (mOverlayView.getMode() == 64 && !mScaleWithContent)
            {
                ensureVisible(mOverlayView, f, f1);
            }
            return true;
        } else
        {
            return super.onScroll(motionevent, motionevent1, f, f1);
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        Iterator iterator = mOverlayViews.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DrawableHighlightView drawablehighlightview = (DrawableHighlightView)iterator.next();
            if (drawablehighlightview.isSelected())
            {
                drawablehighlightview.onSingleTapConfirmed(motionevent.getX(), motionevent.getY());
                postInvalidate();
            }
        } while (true);
        return super.onSingleTapConfirmed(motionevent);
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        Log.i("ImageViewTouchBase", "onSingleTapUp");
        if (mOverlayView != null)
        {
            if ((mOverlayView.getHit(motionevent.getX(), motionevent.getY()) & 0x40) == 64)
            {
                if (mDrawableListener != null)
                {
                    mDrawableListener.onClick(mOverlayView);
                }
                return true;
            }
            mOverlayView.setMode(1);
            postInvalidate();
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("selected items: ").append(mOverlayViews.size()).toString());
            if (mOverlayViews.size() != 1)
            {
                setSelectedHighlightView(null);
            }
        }
        return super.onSingleTapUp(motionevent);
    }

    public boolean onUp(MotionEvent motionevent)
    {
        Log.i("ImageViewTouchBase", "onUp");
        if (mOverlayView != null)
        {
            mOverlayView.setMode(1);
            postInvalidate();
        }
        return super.onUp(motionevent);
    }

    protected void onZoomAnimationCompleted(float f)
    {
        Log.i("ImageViewTouchBase", (new StringBuilder()).append("onZoomAnimationCompleted: ").append(f).toString());
        super.onZoomAnimationCompleted(f);
        if (mOverlayView != null)
        {
            mOverlayView.setMode(64);
            postInvalidate();
        }
    }

    protected void postScale(float f, float f1, float f2)
    {
        if (mOverlayViews.size() > 0)
        {
            Iterator iterator = mOverlayViews.iterator();
            Matrix matrix = new Matrix(getImageViewMatrix());
            super.postScale(f, f1, f2);
            while (iterator.hasNext()) 
            {
                DrawableHighlightView drawablehighlightview = (DrawableHighlightView)iterator.next();
                if (!mScaleWithContent)
                {
                    RectF rectf = drawablehighlightview.getCropRectF();
                    RectF rectf1 = drawablehighlightview.getDisplayRect(matrix, drawablehighlightview.getCropRectF());
                    RectF rectf2 = drawablehighlightview.getDisplayRect(getImageViewMatrix(), drawablehighlightview.getCropRectF());
                    float af[] = new float[9];
                    getImageViewMatrix().getValues(af);
                    f = af[0];
                    rectf.offset((rectf1.left - rectf2.left) / f, (rectf1.top - rectf2.top) / f);
                    rectf.right = rectf.right + -(rectf2.width() - rectf1.width()) / f;
                    rectf.bottom = rectf.bottom + -(rectf2.height() - rectf1.height()) / f;
                    drawablehighlightview.getMatrix().set(getImageMatrix());
                    drawablehighlightview.getCropRectF().set(rectf);
                } else
                {
                    drawablehighlightview.getMatrix().set(getImageMatrix());
                }
                drawablehighlightview.invalidate();
            }
        } else
        {
            super.postScale(f, f1, f2);
        }
    }

    protected void postTranslate(float f, float f1)
    {
        super.postTranslate(f, f1);
        DrawableHighlightView drawablehighlightview;
        for (Iterator iterator = mOverlayViews.iterator(); iterator.hasNext(); drawablehighlightview.invalidate())
        {
            drawablehighlightview = (DrawableHighlightView)iterator.next();
            if (getScale() != 1.0F)
            {
                float af[] = new float[9];
                getImageMatrix().getValues(af);
                float f2 = af[0];
                if (!mScaleWithContent)
                {
                    drawablehighlightview.getCropRectF().offset(-f / f2, -f1 / f2);
                }
            }
            drawablehighlightview.getMatrix().set(getImageMatrix());
        }

    }

    public boolean removeHightlightView(DrawableHighlightView drawablehighlightview)
    {
        Log.i("ImageViewTouchBase", "removeHightlightView");
        for (int i = 0; i < mOverlayViews.size(); i++)
        {
            if (((DrawableHighlightView)mOverlayViews.get(i)).equals(drawablehighlightview))
            {
                drawablehighlightview = (DrawableHighlightView)mOverlayViews.remove(i);
                if (drawablehighlightview.equals(mOverlayView))
                {
                    setSelectedHighlightView(null);
                }
                drawablehighlightview.dispose();
                return true;
            }
        }

        return false;
    }

    public void setDropTargetListener(com.aviary.android.feather.library.services.drag.DropTarget.DropTargetListener droptargetlistener)
    {
        mDropTargetListener = droptargetlistener;
    }

    public void setForceSingleSelection(boolean flag)
    {
        mForceSingleSelection = flag;
    }

    public void setImageDrawable(Drawable drawable, Matrix matrix, float f, float f1)
    {
        super.setImageDrawable(drawable, matrix, f, f1);
    }

    public void setOnDrawableEventListener(OnDrawableEventListener ondrawableeventlistener)
    {
        mDrawableListener = ondrawableeventlistener;
    }

    public void setScaleWithContent(boolean flag)
    {
        mScaleWithContent = flag;
    }

    public void setSelectedHighlightView(DrawableHighlightView drawablehighlightview)
    {
        DrawableHighlightView drawablehighlightview1 = mOverlayView;
        if (mOverlayView != null && !mOverlayView.equals(drawablehighlightview))
        {
            mOverlayView.setSelected(false);
        }
        if (drawablehighlightview != null)
        {
            drawablehighlightview.setSelected(true);
        }
        postInvalidate();
        mOverlayView = drawablehighlightview;
        if (mDrawableListener != null)
        {
            mDrawableListener.onFocusChange(drawablehighlightview, drawablehighlightview1);
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MotionEventCompat;
import android.util.FloatMath;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import uk.co.senab.photoview.gestures.OnGestureListener;
import uk.co.senab.photoview.gestures.VersionedGestureDetector;
import uk.co.senab.photoview.log.LogManager;
import uk.co.senab.photoview.log.Logger;
import uk.co.senab.photoview.scrollerproxy.ScrollerProxy;

// Referenced classes of package uk.co.senab.photoview:
//            IPhotoView, DefaultOnDoubleTapListener, Compat

public class PhotoViewAttacher
    implements android.view.View.OnTouchListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, IPhotoView, OnGestureListener
{
    private class AnimatedZoomRunnable
        implements Runnable
    {

        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;
        final PhotoViewAttacher this$0;

        private float interpolate()
        {
            float f = Math.min(1.0F, ((float)(System.currentTimeMillis() - mStartTime) * 1.0F) / (float)ZOOM_DURATION);
            return PhotoViewAttacher.sInterpolator.getInterpolation(f);
        }

        public void run()
        {
            ImageView imageview = getImageView();
            if (imageview != null)
            {
                float f = interpolate();
                float f1 = (mZoomStart + (mZoomEnd - mZoomStart) * f) / getScale();
                mSuppMatrix.postScale(f1, f1, mFocalX, mFocalY);
                checkAndDisplayMatrix();
                if (f < 1.0F)
                {
                    Compat.postOnAnimation(imageview, this);
                    return;
                }
            }
        }

        public AnimatedZoomRunnable(float f, float f1, float f2, float f3)
        {
            this$0 = PhotoViewAttacher.this;
            super();
            mFocalX = f2;
            mFocalY = f3;
            mZoomStart = f;
            mZoomEnd = f1;
        }
    }

    private class FlingRunnable
        implements Runnable
    {

        private int mCurrentX;
        private int mCurrentY;
        private final ScrollerProxy mScroller;
        final PhotoViewAttacher this$0;

        public void cancelFling()
        {
            if (PhotoViewAttacher.DEBUG)
            {
                LogManager.getLogger().d("PhotoViewAttacher", "Cancel Fling");
            }
            mScroller.forceFinished(true);
        }

        public void fling(int i, int j, int k, int l)
        {
            RectF rectf = getDisplayRect();
            if (rectf != null)
            {
                int i1 = Math.round(-rectf.left);
                int j1;
                int k1;
                int l1;
                if ((float)i < rectf.width())
                {
                    i = (int)(-mTranslateBounds.left);
                    j1 = Math.round(rectf.width() - mTranslateBounds.right);
                } else
                {
                    j1 = i1;
                    i = i1;
                }
                k1 = Math.round(-rectf.top);
                if ((float)j < rectf.height())
                {
                    j = (int)(-mTranslateBounds.top);
                    l1 = Math.round(rectf.height() - mTranslateBounds.bottom);
                } else
                {
                    l1 = k1;
                    j = k1;
                }
                mCurrentX = i1;
                mCurrentY = k1;
                if (PhotoViewAttacher.DEBUG)
                {
                    LogManager.getLogger().d("PhotoViewAttacher", (new StringBuilder()).append("fling. StartX:").append(i1).append(" StartY:").append(k1).append(" MaxX:").append(j1).append(" MaxY:").append(l1).toString());
                }
                if (i1 != j1 || k1 != l1)
                {
                    mScroller.fling(i1, k1, k, l, i, j1, j, l1, 0, 0);
                    return;
                }
            }
        }

        public void run()
        {
            ImageView imageview;
            if (!mScroller.isFinished())
            {
                if ((imageview = getImageView()) != null && mScroller.computeScrollOffset())
                {
                    int i = mScroller.getCurrX();
                    int j = mScroller.getCurrY();
                    if (PhotoViewAttacher.DEBUG)
                    {
                        LogManager.getLogger().d("PhotoViewAttacher", (new StringBuilder()).append("fling run(). CurrentX:").append(mCurrentX).append(" CurrentY:").append(mCurrentY).append(" NewX:").append(i).append(" NewY:").append(j).toString());
                    }
                    mSuppMatrix.postTranslate(mCurrentX - i, mCurrentY - j);
                    setImageViewMatrix(getDrawMatrix());
                    mCurrentX = i;
                    mCurrentY = j;
                    Compat.postOnAnimation(imageview, this);
                    return;
                }
            }
        }

        public FlingRunnable(Context context)
        {
            this$0 = PhotoViewAttacher.this;
            super();
            mScroller = ScrollerProxy.getScroller(context);
        }
    }

    public static interface OnMatrixChangedListener
    {

        public abstract void onMatrixChanged(RectF rectf);
    }

    public static interface OnPhotoTapListener
    {

        public abstract void onPhotoTap(View view, float f, float f1);
    }

    public static interface OnScaleChangeListener
    {

        public abstract void onScaleChange(float f, float f1, float f2);
    }

    public static interface OnViewTapListener
    {

        public abstract void onViewTap(View view, float f, float f1);
    }


    private static final boolean DEBUG = Log.isLoggable("PhotoViewAttacher", 3);
    static final Interpolator sInterpolator = new AccelerateDecelerateInterpolator();
    int ZOOM_DURATION;
    private boolean mAllowParentInterceptOnEdge;
    private final Matrix mBaseMatrix;
    private boolean mBlockParentIntercept;
    private FlingRunnable mCurrentFlingRunnable;
    private boolean mCustomBounds;
    private final RectF mDisplayRect;
    private final Matrix mDrawMatrix;
    private GestureDetector mGestureDetector;
    private WeakReference mImageView;
    private int mIvBottom;
    private int mIvLeft;
    private int mIvRight;
    private int mIvTop;
    private android.view.View.OnLongClickListener mLongClickListener;
    private OnMatrixChangedListener mMatrixChangeListener;
    private final float mMatrixValues[];
    private float mMaxScale;
    private float mMidScale;
    private float mMinScale;
    private OnPhotoTapListener mPhotoTapListener;
    private OnScaleChangeListener mScaleChangeListener;
    private uk.co.senab.photoview.gestures.GestureDetector mScaleDragDetector;
    private android.widget.ImageView.ScaleType mScaleType;
    private int mScrollEdge;
    private final Matrix mSuppMatrix;
    private RectF mTranslateBounds;
    private OnViewTapListener mViewTapListener;
    private boolean mZoomEnabled;

    public PhotoViewAttacher(ImageView imageview)
    {
        this(imageview, true);
    }

    public PhotoViewAttacher(ImageView imageview, boolean flag)
    {
        ZOOM_DURATION = 200;
        mMinScale = 1.0F;
        mMidScale = 1.75F;
        mMaxScale = 3F;
        mAllowParentInterceptOnEdge = true;
        mBlockParentIntercept = false;
        mBaseMatrix = new Matrix();
        mDrawMatrix = new Matrix();
        mSuppMatrix = new Matrix();
        mDisplayRect = new RectF();
        mMatrixValues = new float[9];
        mScrollEdge = 2;
        mScaleType = android.widget.ImageView.ScaleType.FIT_CENTER;
        mImageView = new WeakReference(imageview);
        imageview.setDrawingCacheEnabled(true);
        imageview.setOnTouchListener(this);
        ViewTreeObserver viewtreeobserver = imageview.getViewTreeObserver();
        if (viewtreeobserver != null)
        {
            viewtreeobserver.addOnGlobalLayoutListener(this);
        }
        setImageViewScaleTypeMatrix(imageview);
        if (imageview.isInEditMode())
        {
            return;
        } else
        {
            mScaleDragDetector = VersionedGestureDetector.newInstance(imageview.getContext(), this);
            mGestureDetector = new GestureDetector(imageview.getContext(), new android.view.GestureDetector.SimpleOnGestureListener() {

                final PhotoViewAttacher this$0;

                public void onLongPress(MotionEvent motionevent)
                {
                    if (mLongClickListener != null)
                    {
                        mLongClickListener.onLongClick(getImageView());
                    }
                }

            
            {
                this$0 = PhotoViewAttacher.this;
                super();
            }
            });
            mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
            setZoomable(flag);
            return;
        }
    }

    private void cancelFling()
    {
        if (mCurrentFlingRunnable != null)
        {
            mCurrentFlingRunnable.cancelFling();
            mCurrentFlingRunnable = null;
        }
    }

    private void checkAndDisplayMatrix()
    {
        if (checkMatrixBounds())
        {
            setImageViewMatrix(getDrawMatrix());
        }
    }

    private void checkImageViewScaleType()
    {
        ImageView imageview = getImageView();
        if (imageview != null && !(imageview instanceof IPhotoView) && !android.widget.ImageView.ScaleType.MATRIX.equals(imageview.getScaleType()))
        {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        } else
        {
            return;
        }
    }

    private boolean checkMatrixBounds()
    {
        ImageView imageview = getImageView();
        if (imageview != null) goto _L2; else goto _L1
_L1:
        RectF rectf;
        return false;
_L2:
        if ((rectf = getDisplayRect(getDrawMatrix())) == null) goto _L1; else goto _L3
_L3:
        float f;
        float f1;
        float f2;
        float f3;
        int i;
        f3 = rectf.height();
        f2 = rectf.width();
        f1 = 0.0F;
        f = 0.0F;
        i = getImageViewHeight(imageview);
        if (f3 >= (float)i) goto _L5; else goto _L4
_L4:
        static class _cls2
        {

            static final int $SwitchMap$android$widget$ImageView$ScaleType[];

            static 
            {
                $SwitchMap$android$widget$ImageView$ScaleType = new int[android.widget.ImageView.ScaleType.values().length];
                try
                {
                    $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.MATRIX.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.android.widget.ImageView.ScaleType[mScaleType.ordinal()];
        JVM INSTR tableswitch 2 3: default 96
    //                   2 191
    //                   3 201;
           goto _L6 _L7 _L8
_L6:
        f = ((float)i - f3) / 2.0F - rectf.top;
_L12:
        i = getImageViewWidth(imageview);
        if (f2 >= (float)i)
        {
            break MISSING_BLOCK_LABEL_308;
        }
        _cls2..SwitchMap.android.widget.ImageView.ScaleType[mScaleType.ordinal()];
        JVM INSTR tableswitch 2 3: default 160
    //                   2 283
    //                   3 293;
           goto _L9 _L10 _L11
_L9:
        f1 = ((float)i - f2) / 2.0F - rectf.left;
_L13:
        mScrollEdge = 2;
_L14:
        mSuppMatrix.postTranslate(f1, f);
        return true;
_L7:
        f = -rectf.top;
          goto _L12
_L8:
        f = (float)i - f3 - rectf.top;
          goto _L12
_L5:
        if (rectf.top > mTranslateBounds.top)
        {
            f = mTranslateBounds.top - rectf.top;
        } else
        if (rectf.bottom < mTranslateBounds.bottom)
        {
            f = mTranslateBounds.bottom - rectf.bottom;
        }
          goto _L12
_L10:
        f1 = -rectf.left;
          goto _L13
_L11:
        f1 = (float)i - f2 - rectf.left;
          goto _L13
        if (rectf.left > mTranslateBounds.left)
        {
            mScrollEdge = 0;
            f1 = mTranslateBounds.left - rectf.left;
        } else
        if (rectf.right < mTranslateBounds.right)
        {
            f1 = mTranslateBounds.right - rectf.right;
            mScrollEdge = 1;
        } else
        {
            mScrollEdge = -1;
        }
          goto _L14
    }

    private static void checkZoomLevels(float f, float f1, float f2)
    {
        if (f >= f1)
        {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        }
        if (f1 >= f2)
        {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        } else
        {
            return;
        }
    }

    private RectF getDisplayRect(Matrix matrix)
    {
        Object obj = getImageView();
        if (obj != null)
        {
            obj = ((ImageView) (obj)).getDrawable();
            if (obj != null)
            {
                mDisplayRect.set(0.0F, 0.0F, ((Drawable) (obj)).getIntrinsicWidth(), ((Drawable) (obj)).getIntrinsicHeight());
                matrix.mapRect(mDisplayRect);
                return mDisplayRect;
            }
        }
        return null;
    }

    private int getImageViewHeight(ImageView imageview)
    {
        if (imageview == null)
        {
            return 0;
        } else
        {
            return imageview.getHeight() - imageview.getPaddingTop() - imageview.getPaddingBottom();
        }
    }

    private int getImageViewWidth(ImageView imageview)
    {
        if (imageview == null)
        {
            return 0;
        } else
        {
            return imageview.getWidth() - imageview.getPaddingLeft() - imageview.getPaddingRight();
        }
    }

    private float getValue(Matrix matrix, int i)
    {
        matrix.getValues(mMatrixValues);
        return mMatrixValues[i];
    }

    private static boolean hasDrawable(ImageView imageview)
    {
        return imageview != null && imageview.getDrawable() != null;
    }

    private static boolean isSupportedScaleType(android.widget.ImageView.ScaleType scaletype)
    {
        if (scaletype == null)
        {
            return false;
        }
        switch (_cls2..SwitchMap.android.widget.ImageView.ScaleType[scaletype.ordinal()])
        {
        default:
            return true;

        case 1: // '\001'
            throw new IllegalArgumentException((new StringBuilder()).append(scaletype.name()).append(" is not supported in PhotoView").toString());
        }
    }

    private void resetMatrix()
    {
        mSuppMatrix.reset();
        setImageViewMatrix(getDrawMatrix());
        checkMatrixBounds();
    }

    private void setImageViewMatrix(Matrix matrix)
    {
        ImageView imageview = getImageView();
        if (imageview != null)
        {
            checkImageViewScaleType();
            imageview.setImageMatrix(matrix);
            if (mMatrixChangeListener != null)
            {
                matrix = getDisplayRect(matrix);
                if (matrix != null)
                {
                    mMatrixChangeListener.onMatrixChanged(matrix);
                }
            }
        }
    }

    private static void setImageViewScaleTypeMatrix(ImageView imageview)
    {
        if (imageview != null && !(imageview instanceof IPhotoView) && !android.widget.ImageView.ScaleType.MATRIX.equals(imageview.getScaleType()))
        {
            imageview.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        }
    }

    private void updateBaseMatrix(Drawable drawable)
    {
        float f;
        float f1;
        float f2;
        float f3;
        int i;
        int j;
        ImageView imageview = getImageView();
        if (imageview == null || drawable == null)
        {
            return;
        }
        f = getImageViewWidth(imageview);
        f1 = getImageViewHeight(imageview);
        i = drawable.getIntrinsicWidth();
        j = drawable.getIntrinsicHeight();
        mBaseMatrix.reset();
        f2 = f / (float)i;
        f3 = f1 / (float)j;
        if (mScaleType != android.widget.ImageView.ScaleType.CENTER) goto _L2; else goto _L1
_L1:
        mBaseMatrix.postTranslate((f - (float)i) / 2.0F, (f1 - (float)j) / 2.0F);
_L4:
        if (!mCustomBounds)
        {
            mTranslateBounds = new RectF(0.0F, 0.0F, f, f1);
        }
        resetMatrix();
        return;
_L2:
        if (mScaleType == android.widget.ImageView.ScaleType.CENTER_CROP)
        {
            f2 = Math.max(f2, f3);
            mBaseMatrix.postScale(f2, f2);
            mBaseMatrix.postTranslate((f - (float)i * f2) / 2.0F, (f1 - (float)j * f2) / 2.0F);
            continue; /* Loop/switch isn't completed */
        }
        if (mScaleType != android.widget.ImageView.ScaleType.CENTER_INSIDE)
        {
            break; /* Loop/switch isn't completed */
        }
        f2 = Math.min(1.0F, Math.min(f2, f3));
        mBaseMatrix.postScale(f2, f2);
        mBaseMatrix.postTranslate((f - (float)i * f2) / 2.0F, (f1 - (float)j * f2) / 2.0F);
        if (true) goto _L4; else goto _L3
_L3:
        drawable = new RectF(0.0F, 0.0F, i, j);
        RectF rectf = new RectF(0.0F, 0.0F, f, f1);
        switch (_cls2..SwitchMap.android.widget.ImageView.ScaleType[mScaleType.ordinal()])
        {
        case 2: // '\002'
            mBaseMatrix.setRectToRect(drawable, rectf, android.graphics.Matrix.ScaleToFit.START);
            break;

        case 4: // '\004'
            mBaseMatrix.setRectToRect(drawable, rectf, android.graphics.Matrix.ScaleToFit.CENTER);
            break;

        case 3: // '\003'
            mBaseMatrix.setRectToRect(drawable, rectf, android.graphics.Matrix.ScaleToFit.END);
            break;

        case 5: // '\005'
            mBaseMatrix.setRectToRect(drawable, rectf, android.graphics.Matrix.ScaleToFit.FILL);
            break;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void cleanup()
    {
        if (mImageView == null)
        {
            return;
        }
        ImageView imageview = (ImageView)mImageView.get();
        if (imageview != null)
        {
            ViewTreeObserver viewtreeobserver = imageview.getViewTreeObserver();
            if (viewtreeobserver != null && viewtreeobserver.isAlive())
            {
                viewtreeobserver.removeGlobalOnLayoutListener(this);
            }
            imageview.setOnTouchListener(null);
            cancelFling();
        }
        if (mGestureDetector != null)
        {
            mGestureDetector.setOnDoubleTapListener(null);
        }
        mMatrixChangeListener = null;
        mPhotoTapListener = null;
        mViewTapListener = null;
        mImageView = null;
    }

    public Matrix getDisplayMatrix()
    {
        return new Matrix(getDrawMatrix());
    }

    public RectF getDisplayRect()
    {
        checkMatrixBounds();
        return getDisplayRect(getDrawMatrix());
    }

    public Matrix getDrawMatrix()
    {
        mDrawMatrix.set(mBaseMatrix);
        mDrawMatrix.postConcat(mSuppMatrix);
        return mDrawMatrix;
    }

    public ImageView getImageView()
    {
        ImageView imageview = null;
        if (mImageView != null)
        {
            imageview = (ImageView)mImageView.get();
        }
        if (imageview == null)
        {
            cleanup();
            Log.i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageview;
    }

    public float getMaximumScale()
    {
        return mMaxScale;
    }

    public float getMediumScale()
    {
        return mMidScale;
    }

    public float getMinimumScale()
    {
        return mMinScale;
    }

    public OnPhotoTapListener getOnPhotoTapListener()
    {
        return mPhotoTapListener;
    }

    public OnViewTapListener getOnViewTapListener()
    {
        return mViewTapListener;
    }

    public float getScale()
    {
        return FloatMath.sqrt((float)Math.pow(getValue(mSuppMatrix, 0), 2D) + (float)Math.pow(getValue(mSuppMatrix, 3), 2D));
    }

    public android.widget.ImageView.ScaleType getScaleType()
    {
        return mScaleType;
    }

    public Bitmap getVisibleRectangleBitmap()
    {
        ImageView imageview = getImageView();
        if (imageview == null)
        {
            return null;
        } else
        {
            return imageview.getDrawingCache();
        }
    }

    public void onDrag(float f, float f1)
    {
        if (!mScaleDragDetector.isScaling()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        if (DEBUG)
        {
            LogManager.getLogger().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[] {
                Float.valueOf(f), Float.valueOf(f1)
            }));
        }
        obj = getImageView();
        mSuppMatrix.postTranslate(f, f1);
        checkAndDisplayMatrix();
        obj = ((ImageView) (obj)).getParent();
        if (!mAllowParentInterceptOnEdge || mScaleDragDetector.isScaling() || mBlockParentIntercept)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mScrollEdge != 2 && (mScrollEdge != 0 || f < 1.0F) && (mScrollEdge != 1 || f > -1F) || obj == null) goto _L1; else goto _L3
_L3:
        ((ViewParent) (obj)).requestDisallowInterceptTouchEvent(false);
        return;
        if (obj == null) goto _L1; else goto _L4
_L4:
        ((ViewParent) (obj)).requestDisallowInterceptTouchEvent(true);
        return;
    }

    public void onFling(float f, float f1, float f2, float f3)
    {
        if (DEBUG)
        {
            LogManager.getLogger().d("PhotoViewAttacher", (new StringBuilder()).append("onFling. sX: ").append(f).append(" sY: ").append(f1).append(" Vx: ").append(f2).append(" Vy: ").append(f3).toString());
        }
        ImageView imageview = getImageView();
        mCurrentFlingRunnable = new FlingRunnable(imageview.getContext());
        mCurrentFlingRunnable.fling((int)mTranslateBounds.width(), (int)mTranslateBounds.height(), (int)f2, (int)f3);
        imageview.post(mCurrentFlingRunnable);
    }

    public void onGlobalLayout()
    {
        ImageView imageview;
label0:
        {
            imageview = getImageView();
            if (imageview != null)
            {
                if (!mZoomEnabled)
                {
                    break label0;
                }
                int i = imageview.getTop();
                int j = imageview.getRight();
                int k = imageview.getBottom();
                int l = imageview.getLeft();
                if (i != mIvTop || k != mIvBottom || l != mIvLeft || j != mIvRight)
                {
                    updateBaseMatrix(imageview.getDrawable());
                    mIvTop = i;
                    mIvRight = j;
                    mIvBottom = k;
                    mIvLeft = l;
                }
            }
            return;
        }
        updateBaseMatrix(imageview.getDrawable());
    }

    public void onScale(float f, float f1, float f2)
    {
        if (DEBUG)
        {
            LogManager.getLogger().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[] {
                Float.valueOf(f), Float.valueOf(f1), Float.valueOf(f2)
            }));
        }
        if (mScaleChangeListener != null)
        {
            mScaleChangeListener.onScaleChange(f, f1, f2);
        }
        if (getScale() < mMaxScale || f < 1.0F)
        {
            mSuppMatrix.postScale(f, f, f1, f2);
            checkAndDisplayMatrix();
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag4 = false;
        flag3 = false;
        flag2 = flag4;
        if (!mZoomEnabled) goto _L2; else goto _L1
_L1:
        flag2 = flag4;
        if (!hasDrawable((ImageView)view)) goto _L2; else goto _L3
_L3:
        Object obj;
        obj = view.getParent();
        flag2 = flag3;
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 76
    //                   0 216
    //                   1 280
    //                   2 80
    //                   3 280;
           goto _L4 _L5 _L6 _L7 _L6
_L6:
        break MISSING_BLOCK_LABEL_280;
_L4:
        flag2 = flag3;
_L7:
        flag3 = flag2;
        if (mScaleDragDetector != null)
        {
            flag2 = mScaleDragDetector.isScaling();
            boolean flag5 = mScaleDragDetector.isDragging();
            flag3 = mScaleDragDetector.onTouchEvent(motionevent);
            float f;
            boolean flag;
            boolean flag1;
            if (!flag2 && !mScaleDragDetector.isScaling())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag5 && !mScaleDragDetector.isDragging())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag && flag1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            mBlockParentIntercept = flag2;
        }
        flag2 = flag3;
        if (mGestureDetector != null)
        {
            flag2 = flag3;
            if (mGestureDetector.onTouchEvent(motionevent))
            {
                flag2 = true;
            }
        }
_L2:
        return flag2;
_L5:
        f = TypedValue.applyDimension(1, 50F, view.getContext().getResources().getDisplayMetrics());
        if (obj != null && MotionEventCompat.getX(motionevent, 0) > f)
        {
            ((ViewParent) (obj)).requestDisallowInterceptTouchEvent(true);
        } else
        {
            Log.i("PhotoViewAttacher", "onTouch getParent() returned null");
        }
        cancelFling();
        flag2 = flag3;
          goto _L7
        flag2 = flag3;
        if (getScale() < mMinScale)
        {
            obj = getDisplayRect();
            flag2 = flag3;
            if (obj != null)
            {
                view.post(new AnimatedZoomRunnable(getScale(), mMinScale, ((RectF) (obj)).centerX(), ((RectF) (obj)).centerY()));
                flag2 = true;
            }
        }
          goto _L7
    }

    public void setAllowParentInterceptOnEdge(boolean flag)
    {
        mAllowParentInterceptOnEdge = flag;
    }

    public void setCustomBounds(RectF rectf)
    {
        boolean flag;
        if (rectf != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mCustomBounds = flag;
        mTranslateBounds = rectf;
    }

    public void setMaximumScale(float f)
    {
        checkZoomLevels(mMinScale, mMidScale, f);
        mMaxScale = f;
    }

    public void setMediumScale(float f)
    {
        checkZoomLevels(mMinScale, f, mMaxScale);
        mMidScale = f;
    }

    public void setMinimumScale(float f)
    {
        checkZoomLevels(f, mMidScale, mMaxScale);
        mMinScale = f;
    }

    public void setOnDoubleTapListener(android.view.GestureDetector.OnDoubleTapListener ondoubletaplistener)
    {
        if (ondoubletaplistener != null)
        {
            mGestureDetector.setOnDoubleTapListener(ondoubletaplistener);
            return;
        } else
        {
            mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
            return;
        }
    }

    public void setOnLongClickListener(android.view.View.OnLongClickListener onlongclicklistener)
    {
        mLongClickListener = onlongclicklistener;
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onmatrixchangedlistener)
    {
        mMatrixChangeListener = onmatrixchangedlistener;
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onphototaplistener)
    {
        mPhotoTapListener = onphototaplistener;
    }

    public void setOnScaleChangeListener(OnScaleChangeListener onscalechangelistener)
    {
        mScaleChangeListener = onscalechangelistener;
    }

    public void setOnViewTapListener(OnViewTapListener onviewtaplistener)
    {
        mViewTapListener = onviewtaplistener;
    }

    public void setRotationBy(float f)
    {
        mSuppMatrix.postRotate(f % 360F);
        checkAndDisplayMatrix();
    }

    public void setRotationTo(float f)
    {
        mSuppMatrix.setRotate(f % 360F);
        checkAndDisplayMatrix();
    }

    public void setScale(float f)
    {
        setScale(f, false);
    }

    public void setScale(float f, float f1, float f2, boolean flag)
    {
        ImageView imageview;
label0:
        {
            imageview = getImageView();
            if (imageview != null)
            {
                if (f >= mMinScale && f <= mMaxScale)
                {
                    break label0;
                }
                LogManager.getLogger().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            }
            return;
        }
        if (flag)
        {
            imageview.post(new AnimatedZoomRunnable(getScale(), f, f1, f2));
            return;
        } else
        {
            mSuppMatrix.setScale(f, f, f1, f2);
            checkAndDisplayMatrix();
            return;
        }
    }

    public void setScale(float f, boolean flag)
    {
        ImageView imageview = getImageView();
        if (imageview != null)
        {
            setScale(f, imageview.getRight() / 2, imageview.getBottom() / 2, flag);
        }
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaletype)
    {
        if (isSupportedScaleType(scaletype) && scaletype != mScaleType)
        {
            mScaleType = scaletype;
            update();
        }
    }

    public void setZoomTransitionDuration(int i)
    {
        int j = i;
        if (i < 0)
        {
            j = 200;
        }
        ZOOM_DURATION = j;
    }

    public void setZoomable(boolean flag)
    {
        mZoomEnabled = flag;
        update();
    }

    public void update()
    {
label0:
        {
            ImageView imageview = getImageView();
            if (imageview != null)
            {
                if (!mZoomEnabled)
                {
                    break label0;
                }
                setImageViewScaleTypeMatrix(imageview);
                updateBaseMatrix(imageview.getDrawable());
            }
            return;
        }
        resetMatrix();
    }







}

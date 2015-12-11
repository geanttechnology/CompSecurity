// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.view.n;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import uk.co.senab.photoview.gestures.GestureDetector;
import uk.co.senab.photoview.gestures.OnGestureListener;
import uk.co.senab.photoview.gestures.VersionedGestureDetector;
import uk.co.senab.photoview.log.LogManager;
import uk.co.senab.photoview.log.Logger;

// Referenced classes of package uk.co.senab.photoview:
//            IPhotoView, PhotoView

public class PhotoViewAttacher
    implements android.view.GestureDetector.OnDoubleTapListener, android.view.View.OnTouchListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, IPhotoView, OnGestureListener
{

    private static final boolean DEBUG = Log.isLoggable("PhotoViewAttacher", 3);
    public static final float DEFAULT_MAX_SCALE = 3F;
    public static final float DEFAULT_MID_SCALE = 1.75F;
    public static final float DEFAULT_MIN_SCALE = 1F;
    static final int EDGE_BOTH = 2;
    static final int EDGE_LEFT = 0;
    static final int EDGE_NONE = -1;
    static final int EDGE_RIGHT = 1;
    private static final String LOG_TAG = "PhotoViewAttacher";
    static final int ZOOM_DURATION = 200;
    static final Interpolator sInterpolator = new AccelerateDecelerateInterpolator();
    private boolean mAllowParentInterceptOnEdge;
    private final Matrix mBaseMatrix = new Matrix();
    private FlingRunnable mCurrentFlingRunnable;
    private final RectF mDisplayRect = new RectF();
    private final Matrix mDrawMatrix = new Matrix();
    private OnFlingListener mFlingListener;
    private n mGestureDetector;
    private WeakReference mImageView;
    private int mIvBottom;
    private int mIvLeft;
    private int mIvRight;
    private int mIvTop;
    private float mLastRotation;
    private android.view.View.OnLongClickListener mLongClickListener;
    private OnMatrixChangedListener mMatrixChangeListener;
    private final float mMatrixValues[] = new float[9];
    private float mMaxScale;
    private float mMidScale;
    private float mMinScale;
    private OnPhotoTapListener mPhotoTapListener;
    private GestureDetector mScaleDragDetector;
    private android.widget.ImageView.ScaleType mScaleType;
    private int mScrollEdge;
    private final Matrix mSuppMatrix = new Matrix();
    private OnViewTapListener mViewTapListener;
    private boolean mZoomEnabled;

    public PhotoViewAttacher(ImageView imageview)
    {
        mMinScale = 1.0F;
        mMidScale = 1.75F;
        mMaxScale = 3F;
        mAllowParentInterceptOnEdge = true;
        mScrollEdge = 2;
        mScaleType = android.widget.ImageView.ScaleType.FIT_CENTER;
        mLastRotation = 0.0F;
        mImageView = new WeakReference(imageview);
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
            mGestureDetector = new n(imageview.getContext(), new _cls1());
            mGestureDetector.a(this);
            setZoomable(true);
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
        if (imageview != null && !(imageview instanceof PhotoView) && !android.widget.ImageView.ScaleType.MATRIX.equals(imageview.getScaleType()))
        {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        } else
        {
            return;
        }
    }

    private boolean checkMatrixBounds()
    {
        float f;
        float f1;
        float f2;
        ImageView imageview;
        RectF rectf;
        int i;
        f1 = 0.0F;
        imageview = getImageView();
        if (imageview == null)
        {
            return false;
        }
        rectf = getDisplayRect(getDrawMatrix());
        if (rectf == null)
        {
            return false;
        }
        f = rectf.height();
        f2 = rectf.width();
        i = getImageViewHeight(imageview);
        if (f > (float)i) goto _L2; else goto _L1
_L1:
        _cls2..SwitchMap.android.widget.ImageView.ScaleType[mScaleType.ordinal()];
        JVM INSTR tableswitch 2 3: default 92
    //                   2 187
    //                   3 197;
           goto _L3 _L4 _L5
_L3:
        f = ((float)i - f) / 2.0F - rectf.top;
_L9:
        i = getImageViewWidth(imageview);
        if (f2 > (float)i)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        _cls2..SwitchMap.android.widget.ImageView.ScaleType[mScaleType.ordinal()];
        JVM INSTR tableswitch 2 3: default 156
    //                   2 257
    //                   3 267;
           goto _L6 _L7 _L8
_L6:
        f1 = ((float)i - f2) / 2.0F - rectf.left;
_L10:
        mScrollEdge = 2;
_L11:
        mSuppMatrix.postTranslate(f1, f);
        return true;
_L4:
        f = -rectf.top;
          goto _L9
_L5:
        f = (float)i - f - rectf.top;
          goto _L9
_L2:
        if (rectf.top > 0.0F)
        {
            f = -rectf.top;
        } else
        if (rectf.bottom < (float)i)
        {
            f = (float)i - rectf.bottom;
        } else
        {
            f = 0.0F;
        }
          goto _L9
_L7:
        f1 = -rectf.left;
          goto _L10
_L8:
        f1 = (float)i - f2 - rectf.left;
          goto _L10
        if (rectf.left > 0.0F)
        {
            mScrollEdge = 0;
            f1 = -rectf.left;
        } else
        if (rectf.right < (float)i)
        {
            f1 = (float)i - rectf.right;
            mScrollEdge = 1;
        } else
        {
            mScrollEdge = -1;
        }
          goto _L11
    }

    private static void checkZoomLevels(float f, float f1, float f2)
    {
        if (f > f1)
        {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        }
        if (f1 > f2)
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
        if (imageview != null && !(imageview instanceof PhotoView) && !android.widget.ImageView.ScaleType.MATRIX.equals(imageview.getScaleType()))
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

    public final boolean canZoom()
    {
        return mZoomEnabled;
    }

    public final void cleanup()
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
            mGestureDetector.a(null);
        }
        mMatrixChangeListener = null;
        mPhotoTapListener = null;
        mViewTapListener = null;
        mFlingListener = null;
        mImageView = null;
    }

    public Matrix getDisplayMatrix()
    {
        return new Matrix(mSuppMatrix);
    }

    public final RectF getDisplayRect()
    {
        checkMatrixBounds();
        return getDisplayRect(getDrawMatrix());
    }

    protected Matrix getDrawMatrix()
    {
        mDrawMatrix.set(mBaseMatrix);
        mDrawMatrix.postConcat(mSuppMatrix);
        return mDrawMatrix;
    }

    public final ImageView getImageView()
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

    public float getMaxScale()
    {
        return getMaximumScale();
    }

    public float getMaximumScale()
    {
        return mMaxScale;
    }

    public float getMediumScale()
    {
        return mMidScale;
    }

    public float getMidScale()
    {
        return getMediumScale();
    }

    public float getMinScale()
    {
        return getMinimumScale();
    }

    public float getMinimumScale()
    {
        return mMinScale;
    }

    public final float getScale()
    {
        return (float)Math.sqrt(Math.pow(getValue(mSuppMatrix, 0), 2D) + Math.pow(getValue(mSuppMatrix, 3), 2D));
    }

    public final android.widget.ImageView.ScaleType getScaleType()
    {
        return mScaleType;
    }

    public final boolean onDoubleTap(MotionEvent motionevent)
    {
        float f;
        float f1;
        float f2;
        f = getScale();
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        if (f >= mMidScale)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        setScale(mMidScale, f1, f2, true);
        return true;
        if (f < mMidScale || f >= mMaxScale)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        setScale(mMaxScale, f1, f2, true);
        return true;
        try
        {
            setScale(mMinScale, f1, f2, true);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            return true;
        }
        return true;
    }

    public final boolean onDoubleTapEvent(MotionEvent motionevent)
    {
        return false;
    }

    public final void onDrag(float f, float f1)
    {
        if (DEBUG)
        {
            LogManager.getLogger().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[] {
                Float.valueOf(f), Float.valueOf(f1)
            }));
        }
        Object obj = getImageView();
        mSuppMatrix.postTranslate(f, f1);
        checkAndDisplayMatrix();
        if (mAllowParentInterceptOnEdge && !mScaleDragDetector.isScaling() && (mScrollEdge == 2 || mScrollEdge == 0 && f >= 1.0F || mScrollEdge == 1 && f <= -1F))
        {
            obj = ((ImageView) (obj)).getParent();
            if (obj != null)
            {
                ((ViewParent) (obj)).requestDisallowInterceptTouchEvent(false);
            }
        }
    }

    public final void onFling(float f, float f1, float f2, float f3)
    {
        if (DEBUG)
        {
            LogManager.getLogger().d("PhotoViewAttacher", (new StringBuilder("onFling. sX: ")).append(f).append(" sY: ").append(f1).append(" Vx: ").append(f2).append(" Vy: ").append(f3).toString());
        }
        ImageView imageview = getImageView();
        mCurrentFlingRunnable = new FlingRunnable(imageview.getContext());
        mCurrentFlingRunnable.fling(getImageViewWidth(imageview), getImageViewHeight(imageview), (int)f2, (int)f3);
        imageview.post(mCurrentFlingRunnable);
    }

    public final void onGlobalLayout()
    {
        ImageView imageview = getImageView();
        if (imageview != null && mZoomEnabled)
        {
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
    }

    public final void onScale(float f, float f1, float f2)
    {
        if (DEBUG)
        {
            LogManager.getLogger().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[] {
                Float.valueOf(f), Float.valueOf(f1), Float.valueOf(f2)
            }));
        }
        if (f > 1.0F && getScale() < mMaxScale || f < 1.0F && getScale() > 0.8F * mMinScale)
        {
            mSuppMatrix.postScale(f, f, f1, f2);
            checkAndDisplayMatrix();
        }
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        ImageView imageview = getImageView();
        if (mPhotoTapListener != null)
        {
            RectF rectf = getDisplayRect();
            if (rectf != null)
            {
                float f1 = motionevent.getX();
                float f = motionevent.getY();
                if (rectf.contains(f1, f))
                {
                    f1 = (f1 - rectf.left) / rectf.width();
                    f = (f - rectf.top) / rectf.height();
                    mPhotoTapListener.onPhotoTap(imageview, f1, f);
                    return true;
                }
            }
        }
        if (mViewTapListener != null)
        {
            mViewTapListener.onViewTap(imageview, motionevent.getX(), motionevent.getY());
        }
        return false;
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (!mZoomEnabled) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (!hasDrawable((ImageView)view)) goto _L2; else goto _L3
_L3:
        ViewParent viewparent = view.getParent();
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 68
    //                   0 142
    //                   1 175
    //                   2 68
    //                   3 175;
           goto _L4 _L5 _L6 _L4 _L6
_L4:
        flag = false;
_L9:
        flag1 = flag;
        if (mGestureDetector != null)
        {
            flag1 = flag;
            if (mGestureDetector.a(motionevent))
            {
                flag1 = true;
            }
        }
        if (!flag1 && viewparent != null)
        {
            viewparent.requestDisallowInterceptTouchEvent(false);
        }
        if (mScaleDragDetector == null || !mScaleDragDetector.onTouchEvent(motionevent)) goto _L8; else goto _L7
_L7:
        flag = true;
_L2:
        return flag;
_L5:
        if (viewparent != null)
        {
            viewparent.requestDisallowInterceptTouchEvent(true);
        } else
        {
            Log.i("PhotoViewAttacher", "onTouch getParent() returned null");
        }
        cancelFling();
        flag = false;
          goto _L9
_L6:
        if (getScale() >= mMinScale) goto _L4; else goto _L10
_L10:
        RectF rectf = getDisplayRect();
        if (rectf == null) goto _L4; else goto _L11
_L11:
        view.post(new AnimatedZoomRunnable(getScale(), mMinScale, rectf.centerX(), rectf.centerY()));
        flag = true;
          goto _L9
_L8:
        return flag1;
    }

    public void setAllowParentInterceptOnEdge(boolean flag)
    {
        mAllowParentInterceptOnEdge = flag;
    }

    public boolean setDisplayMatrix(Matrix matrix)
    {
        if (matrix == null)
        {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        for (ImageView imageview = getImageView(); imageview == null || imageview.getDrawable() == null;)
        {
            return false;
        }

        mSuppMatrix.set(matrix);
        setImageViewMatrix(getDrawMatrix());
        checkMatrixBounds();
        return true;
    }

    public void setMaxScale(float f)
    {
        setMaximumScale(f);
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

    public void setMidScale(float f)
    {
        setMediumScale(f);
    }

    public void setMinScale(float f)
    {
        setMinimumScale(f);
    }

    public void setMinimumScale(float f)
    {
        checkZoomLevels(f, mMidScale, mMaxScale);
        mMinScale = f;
    }

    public final void setOnFlingListener(OnFlingListener onflinglistener)
    {
        mFlingListener = onflinglistener;
    }

    public final void setOnLongClickListener(android.view.View.OnLongClickListener onlongclicklistener)
    {
        mLongClickListener = onlongclicklistener;
    }

    public final void setOnMatrixChangeListener(OnMatrixChangedListener onmatrixchangedlistener)
    {
        mMatrixChangeListener = onmatrixchangedlistener;
    }

    public final void setOnPhotoTapListener(OnPhotoTapListener onphototaplistener)
    {
        mPhotoTapListener = onphototaplistener;
    }

    public final void setOnViewTapListener(OnViewTapListener onviewtaplistener)
    {
        mViewTapListener = onviewtaplistener;
    }

    public void setPhotoViewRotation(float f)
    {
        f %= 360F;
        mSuppMatrix.postRotate(mLastRotation - f);
        mLastRotation = f;
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

    public final void setScaleType(android.widget.ImageView.ScaleType scaletype)
    {
        if (isSupportedScaleType(scaletype) && scaletype != mScaleType)
        {
            mScaleType = scaletype;
            update();
        }
    }

    public final void setZoomable(boolean flag)
    {
        mZoomEnabled = flag;
        update();
    }

    public final void update()
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








    private class _cls1 extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final PhotoViewAttacher this$0;

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            if (mFlingListener != null)
            {
                mFlingListener.onFling(f, f1);
            }
            return false;
        }

        public void onLongPress(MotionEvent motionevent)
        {
            if (mLongClickListener != null)
            {
                mLongClickListener.onLongClick(getImageView());
            }
        }

        _cls1()
        {
            this$0 = PhotoViewAttacher.this;
            super();
        }

        private class OnFlingListener
        {

            public abstract void onFling(float f, float f1);
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
                    j1 = Math.round(rectf.width() - (float)i);
                    i = 0;
                } else
                {
                    i = i1;
                    j1 = i1;
                }
                k1 = Math.round(-rectf.top);
                if ((float)j < rectf.height())
                {
                    l1 = Math.round(rectf.height() - (float)j);
                    j = 0;
                } else
                {
                    j = k1;
                    l1 = k1;
                }
                mCurrentX = i1;
                mCurrentY = k1;
                if (PhotoViewAttacher.DEBUG)
                {
                    LogManager.getLogger().d("PhotoViewAttacher", (new StringBuilder("fling. StartX:")).append(i1).append(" StartY:").append(k1).append(" MaxX:").append(j1).append(" MaxY:").append(l1).toString());
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
                        LogManager.getLogger().d("PhotoViewAttacher", (new StringBuilder("fling run(). CurrentX:")).append(mCurrentX).append(" CurrentY:").append(mCurrentY).append(" NewX:").append(i).append(" NewY:").append(j).toString());
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


    private class _cls2
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


    private class OnMatrixChangedListener
    {

        public abstract void onMatrixChanged(RectF rectf);
    }


    private class OnPhotoTapListener
    {

        public abstract void onPhotoTap(View view, float f, float f1);
    }


    private class OnViewTapListener
    {

        public abstract void onViewTap(View view, float f, float f1);
    }


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
            float f = Math.min(1.0F, ((float)(System.currentTimeMillis() - mStartTime) * 1.0F) / 200F);
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

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.aviary.android.feather.library.graphics.Point2D;
import com.aviary.android.feather.library.graphics.drawable.EditableDrawable;
import com.aviary.android.feather.library.graphics.drawable.FeatherDrawable;
import com.aviary.android.feather.sdk.FeatherActivity;
import com.aviary.android.feather.sdk.utils.Maturity;
import com.aviary.android.feather.sdk.utils.UIUtils;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import java.lang.ref.WeakReference;

public class DrawableHighlightView
    implements android.graphics.drawable.Drawable.Callback, com.aviary.android.feather.library.graphics.drawable.EditableDrawable.OnSizeChange
{
    public static final class AlignModeV extends Enum
    {

        private static final AlignModeV $VALUES[];
        public static final AlignModeV Bottom;
        public static final AlignModeV Center;
        public static final AlignModeV Top;

        public static AlignModeV valueOf(String s)
        {
            return (AlignModeV)Enum.valueOf(com/aviary/android/feather/sdk/widget/DrawableHighlightView$AlignModeV, s);
        }

        public static AlignModeV[] values()
        {
            return (AlignModeV[])$VALUES.clone();
        }

        static 
        {
            Top = new AlignModeV("Top", 0);
            Bottom = new AlignModeV("Bottom", 1);
            Center = new AlignModeV("Center", 2);
            $VALUES = (new AlignModeV[] {
                Top, Bottom, Center
            });
        }

        private AlignModeV(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface OnContentFlipListener
    {

        public abstract void onContentFlip(DrawableHighlightView drawablehighlightview);
    }

    public static interface OnDeleteClickListener
    {

        public abstract void onDeleteClick();
    }

    public static interface OnOpacityChangeListener
    {

        public abstract void onChangeOpacity();

        public abstract void onLockOpacity();
    }


    public static final float DEFAULT_MIN_SIZE = 20F;
    public static final int DELETE = 128;
    public static final int GROW = 30;
    public static final int GROW_BOTTOM_EDGE = 16;
    public static final int GROW_LEFT_EDGE = 2;
    public static final int GROW_RIGHT_EDGE = 4;
    public static final int GROW_TOP_EDGE = 8;
    private static final float HIT_TOLERANCE = 40F;
    static final String LOG_TAG = "drawable-view";
    public static final int MOVE = 64;
    public static final int NONE = 1;
    public static final int OPACITY = 256;
    public static final int ROTATE = 32;
    private static final int STATE_FOCUSED = 4;
    private static final int STATE_NONE = 1;
    private static final int STATE_SELECTED = 2;
    static final int STATE_SET_NONE[] = new int[0];
    static final int STATE_SET_SELECTED[] = {
        0x10100a1
    };
    static final int STATE_SET_SELECTED_FOCUSED[] = {
        0x101009c
    };
    static final int STATE_SET_SELECTED_PRESSED[] = {
        0x10100a1, 0x10100a7
    };
    private final float fpoints[] = {
        0.0F, 0.0F
    };
    private AlignModeV mAlignVerticalMode;
    private Drawable mAnchorDelete;
    private int mAnchorDeleteHeight;
    private int mAnchorDeleteWidth;
    private Drawable mAnchorOpacity;
    private int mAnchorOpacityHeight;
    private int mAnchorOpacityWidth;
    private Drawable mAnchorRotate;
    private int mAnchorRotateHeight;
    private int mAnchorRotateWidth;
    private Drawable mBackgroundDrawable;
    private int mConfirmedOpacity;
    private FeatherDrawable mContent;
    private WeakReference mContentFlipListener;
    private ImageViewTouch mContext;
    private RectF mCropRect;
    private OnDeleteClickListener mDeleteClickListener;
    private RectF mDrawRect;
    private EditableDrawable mEditableContent;
    private boolean mHidden;
    Rect mInvalidateRect;
    RectF mInvalidateRectF;
    private Matrix mMatrix;
    private int mMode;
    private boolean mMoveEnabled;
    private int mOpacity;
    private OnOpacityChangeListener mOpacityChangeListener;
    private int mPadding;
    private float mRatio;
    private int mResizeEdgeMode;
    private boolean mRotateEnabled;
    private Matrix mRotateMatrix;
    private float mRotation;
    private boolean mScaleEnabled;
    private boolean mShouldFlip;
    private boolean mShowAnchors;
    private int mState;
    private final RectF mTempRect = new RectF();

    public DrawableHighlightView(ImageViewTouch imageviewtouch, int i, FeatherDrawable featherdrawable)
    {
        mState = 1;
        mInvalidateRectF = new RectF();
        mInvalidateRect = new Rect();
        mRotation = 0.0F;
        mRatio = 1.0F;
        mRotateMatrix = new Matrix();
        mPadding = 0;
        mShowAnchors = true;
        mAlignVerticalMode = AlignModeV.Center;
        mShouldFlip = true;
        mOpacity = 255;
        mConfirmedOpacity = 255;
        mContent = featherdrawable;
        mContext = imageviewtouch;
        mContent.setCallback(this);
        float f;
        if (featherdrawable instanceof EditableDrawable)
        {
            mEditableContent = (EditableDrawable)featherdrawable;
            mEditableContent.setOnSizeChangeListener(this);
        } else
        {
            mEditableContent = null;
        }
        f = -1F;
        if (i > 0)
        {
            imageviewtouch = imageviewtouch.getContext().obtainStyledAttributes(i, com.aviary.android.feather.sdk.R.styleable.AviaryDrawableHighlightView);
            mAnchorRotate = imageviewtouch.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryDrawableHighlightView_aviary_rotateDrawable);
            mAnchorDelete = imageviewtouch.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryDrawableHighlightView_aviary_deleteDrawable);
            mAnchorOpacity = imageviewtouch.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryDrawableHighlightView_aviary_opacityDrawable);
            mBackgroundDrawable = imageviewtouch.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryDrawableHighlightView_android_background);
            mPadding = imageviewtouch.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryDrawableHighlightView_android_padding, 10);
            mResizeEdgeMode = imageviewtouch.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryDrawableHighlightView_aviary_resizeEdgeMode, 0);
            mMoveEnabled = imageviewtouch.getBoolean(com.aviary.android.feather.sdk.R.styleable.AviaryDrawableHighlightView_aviary_moveEnabled, true);
            mRotateEnabled = imageviewtouch.getBoolean(com.aviary.android.feather.sdk.R.styleable.AviaryDrawableHighlightView_aviary_rotateEnabled, true);
            mScaleEnabled = imageviewtouch.getBoolean(com.aviary.android.feather.sdk.R.styleable.AviaryDrawableHighlightView_aviary_resizeEnabled, true);
            f = imageviewtouch.getDimension(com.aviary.android.feather.sdk.R.styleable.AviaryDrawableHighlightView_aviary_minSize, 20F);
            imageviewtouch.recycle();
        }
        if (mAnchorRotate != null)
        {
            mAnchorRotateWidth = mAnchorRotate.getIntrinsicWidth() / 3;
            mAnchorRotateHeight = mAnchorRotate.getIntrinsicHeight() / 3;
        }
        if (mAnchorDelete != null)
        {
            mAnchorDeleteWidth = mAnchorDelete.getIntrinsicWidth() / 3;
            mAnchorDeleteHeight = mAnchorDelete.getIntrinsicHeight() / 3;
        }
        if (mAnchorOpacity != null)
        {
            mAnchorOpacityWidth = mAnchorOpacity.getIntrinsicWidth() / 3;
            mAnchorOpacityHeight = mAnchorOpacity.getIntrinsicHeight() / 3;
        }
        updateRatio();
        if (f > 0.0F)
        {
            setMinSize(f);
        }
    }

    private void updateRatio()
    {
        mRatio = mContent.getCurrentWidth() / mContent.getCurrentHeight();
    }

    protected RectF computeLayout()
    {
        return getDisplayRect(mMatrix, mCropRect);
    }

    public void copyBounds(RectF rectf)
    {
        rectf.set(mDrawRect);
        rectf.inset(-mPadding, -mPadding);
    }

    public void dispose()
    {
        mDeleteClickListener = null;
        mOpacityChangeListener = null;
        mContentFlipListener = null;
        mContext = null;
        mContent = null;
        mEditableContent = null;
    }

    public void draw(Canvas canvas)
    {
        if (mHidden)
        {
            return;
        }
        copyBounds(mTempRect);
        int i = canvas.save();
        canvas.concat(mRotateMatrix);
        if (mBackgroundDrawable != null)
        {
            mBackgroundDrawable.setBounds((int)mTempRect.left, (int)mTempRect.top, (int)mTempRect.right, (int)mTempRect.bottom);
            mBackgroundDrawable.draw(canvas);
        }
        boolean flag = isSelected();
        boolean flag1 = isFocused();
        if (mEditableContent != null)
        {
            mEditableContent.setBounds(mDrawRect.left, mDrawRect.top, mDrawRect.right, mDrawRect.bottom);
        } else
        {
            mContent.setBounds((int)mDrawRect.left, (int)mDrawRect.top, (int)mDrawRect.right, (int)mDrawRect.bottom);
        }
        mContent.draw(canvas);
        if ((flag || flag1) && mShowAnchors)
        {
            int j = (int)mTempRect.left;
            int k = (int)mTempRect.right;
            int l = (int)mTempRect.top;
            int i1 = (int)mTempRect.bottom;
            if (mAnchorRotate != null)
            {
                mAnchorRotate.setBounds(k - mAnchorRotateWidth, i1 - mAnchorRotateHeight, mAnchorRotateWidth + k, mAnchorRotateHeight + i1);
                mAnchorRotate.draw(canvas);
            }
            if (mAnchorDelete != null)
            {
                mAnchorDelete.setBounds(j - mAnchorDeleteWidth, l - mAnchorDeleteHeight, mAnchorDeleteWidth + j, mAnchorDeleteHeight + l);
                mAnchorDelete.draw(canvas);
            }
            if (mAnchorOpacity != null && !FeatherActivity.MATURITY.isKidsFriendly())
            {
                mAnchorOpacity.setBounds(k - mAnchorOpacityWidth, l - mAnchorOpacityHeight, mAnchorOpacityWidth + k, mAnchorOpacityHeight + l);
                mAnchorOpacity.draw(canvas);
            }
        }
        canvas.restoreToCount(i);
    }

    public void draw(Canvas canvas, Matrix matrix)
    {
        matrix = new Matrix(matrix);
        matrix.invert(matrix);
        int i = canvas.save();
        canvas.concat(matrix);
        canvas.concat(mRotateMatrix);
        mContent.setBounds((int)mDrawRect.left, (int)mDrawRect.top, (int)mDrawRect.right, (int)mDrawRect.bottom);
        mContent.draw(canvas);
        canvas.restoreToCount(i);
    }

    public void flipHorizontal()
    {
        float f1 = 1.0F;
        if (mContent != null && mContent.getHorizontalFlipEnabled())
        {
            final boolean flipped = mContent.getHorizontalFlip();
            Object obj = mContent;
            float f;
            if (flipped)
            {
                f = -1F;
            } else
            {
                f = 1.0F;
            }
            if (!flipped)
            {
                f1 = -1F;
            }
            obj = ObjectAnimator.ofFloat(obj, "scaleX", new float[] {
                f, f1
            });
            ((ObjectAnimator) (obj)).setDuration(150L);
            ((ObjectAnimator) (obj)).setInterpolator(new AccelerateDecelerateInterpolator());
            ((ObjectAnimator) (obj)).start();
            ((ObjectAnimator) (obj)).addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

                final DrawableHighlightView this$0;
                final boolean val$flipped;

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    if (mContent != null)
                    {
                        animator = mContent;
                        boolean flag;
                        if (!flipped)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        animator.setHorizontalFlip(flag);
                    }
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                this$0 = DrawableHighlightView.this;
                flipped = flag;
                super();
            }
            });
            if (mContentFlipListener != null)
            {
                OnContentFlipListener oncontentfliplistener = (OnContentFlipListener)mContentFlipListener.get();
                if (oncontentfliplistener != null)
                {
                    oncontentfliplistener.onContentFlip(this);
                }
            }
        }
    }

    public boolean forceUpdate()
    {
        RectF rectf = getCropRectF();
        RectF rectf1 = getDrawRect();
        if (mEditableContent != null)
        {
            float f = mContent.getCurrentWidth();
            float f1 = mContent.getCurrentHeight();
            updateRatio();
            RectF rectf2 = new RectF(rectf);
            getMatrix().mapRect(rectf2);
            float f2 = rectf2.width();
            float f3 = rectf2.height();
            float af[] = new float[2];
            af[0] = f - f2;
            af[1] = f1 - f3;
            (new Matrix()).postRotate(-mRotation);
            f1 = af[0];
            f = af[1];
            f1 *= rectf.width() / rectf1.width();
            f *= rectf.height() / rectf1.height();
            if (f1 != 0.0F || f != 0.0F)
            {
                growBy(f1 / 2.0F, f / 2.0F, false);
            }
            invalidate();
            return true;
        } else
        {
            return false;
        }
    }

    public int getConfirmedOpacity()
    {
        return mConfirmedOpacity;
    }

    public FeatherDrawable getContent()
    {
        return mContent;
    }

    public Rect getCropRect()
    {
        return new Rect((int)mCropRect.left, (int)mCropRect.top, (int)mCropRect.right, (int)mCropRect.bottom);
    }

    public RectF getCropRectF()
    {
        return mCropRect;
    }

    public Matrix getCropRotationMatrix()
    {
        Matrix matrix = new Matrix();
        matrix.postTranslate(-mCropRect.centerX(), -mCropRect.centerY());
        matrix.postRotate(mRotation);
        matrix.postTranslate(mCropRect.centerX(), mCropRect.centerY());
        return matrix;
    }

    public RectF getDisplayRect(Matrix matrix, RectF rectf)
    {
        rectf = new RectF(rectf);
        matrix.mapRect(rectf);
        return rectf;
    }

    public RectF getDisplayRectF()
    {
        RectF rectf = new RectF(mDrawRect);
        mRotateMatrix.mapRect(rectf);
        return rectf;
    }

    public RectF getDrawRect()
    {
        return mDrawRect;
    }

    public boolean getFlipHorizontal()
    {
        if (mContent != null)
        {
            return mContent.getHorizontalFlip();
        } else
        {
            return false;
        }
    }

    public int getHit(float f, float f1)
    {
label0:
        {
            RectF rectf = new RectF(mDrawRect);
            rectf.inset(-mPadding, -mPadding);
            float af[] = new float[2];
            af[0] = f;
            af[1] = f1;
            Matrix matrix = new Matrix();
            matrix.postTranslate(-rectf.centerX(), -rectf.centerY());
            matrix.postRotate(-mRotation);
            matrix.postTranslate(rectf.centerX(), rectf.centerY());
            matrix.mapPoints(af);
            f = af[0];
            f1 = af[1];
            int j = 1;
            int i;
            boolean flag;
            boolean flag1;
            if (f1 >= rectf.top - 40F && f1 < rectf.bottom + 40F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (f >= rectf.left - 40F && f < rectf.right + 40F)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            i = j;
            if (flag)
            {
                i = j;
                if (flag1)
                {
                    i = 64;
                }
            }
            j = i;
            if (mScaleEnabled)
            {
                j = i;
                if (Math.abs(rectf.left - f) < 40F)
                {
                    j = i;
                    if (flag)
                    {
                        j = i;
                        if (UIUtils.checkBits(mResizeEdgeMode, 2))
                        {
                            j = i | 2;
                        }
                    }
                }
                i = j;
                if (Math.abs(rectf.right - f) < 40F)
                {
                    i = j;
                    if (flag)
                    {
                        i = j;
                        if (UIUtils.checkBits(mResizeEdgeMode, 4))
                        {
                            i = j | 4;
                        }
                    }
                }
                int k = i;
                if (Math.abs(rectf.top - f1) < 40F)
                {
                    k = i;
                    if (flag1)
                    {
                        k = i;
                        if (UIUtils.checkBits(mResizeEdgeMode, 8))
                        {
                            k = i | 8;
                        }
                    }
                }
                j = k;
                if (Math.abs(rectf.bottom - f1) < 40F)
                {
                    j = k;
                    if (flag1)
                    {
                        j = k;
                        if (UIUtils.checkBits(mResizeEdgeMode, 16))
                        {
                            j = k | 0x10;
                        }
                    }
                }
            }
            if (!mRotateEnabled)
            {
                i = j;
                if (!mScaleEnabled)
                {
                    break label0;
                }
            }
            i = j;
            if (Math.abs(rectf.right - f) < 40F)
            {
                i = j;
                if (Math.abs(rectf.bottom - f1) < 40F)
                {
                    i = j;
                    if (flag)
                    {
                        i = j;
                        if (flag1)
                        {
                            i = 32;
                        }
                    }
                }
            }
        }
        j = i;
        if (mMoveEnabled)
        {
            j = i;
            if (i == 1)
            {
                j = i;
                if (rectf.contains((int)f, (int)f1))
                {
                    j = 64;
                }
            }
        }
        i = j;
        if (mAnchorDelete != null)
        {
            i = j;
            if (Math.abs(rectf.left - f) < 40F)
            {
                i = j;
                if (Math.abs(rectf.top - f1) < 40F)
                {
                    i = j;
                    if (flag)
                    {
                        i = j;
                        if (flag1)
                        {
                            i = 128;
                        }
                    }
                }
            }
        }
        j = i;
        if (mAnchorOpacity != null)
        {
            j = i;
            if (Math.abs(rectf.right - f) < 40F)
            {
                j = i;
                if (Math.abs(rectf.top - f1) < 40F)
                {
                    j = i;
                    if (flag)
                    {
                        j = i;
                        if (flag1)
                        {
                            j = 256;
                        }
                    }
                }
            }
        }
        return j;
    }

    public Rect getInvalidationRect()
    {
        mInvalidateRectF.set(mDrawRect);
        mInvalidateRectF.inset(-mPadding, -mPadding);
        mRotateMatrix.mapRect(mInvalidateRectF);
        mInvalidateRect.set((int)mInvalidateRectF.left, (int)mInvalidateRectF.top, (int)mInvalidateRectF.right, (int)mInvalidateRectF.bottom);
        int i = Math.max(mAnchorRotateWidth, mAnchorDeleteWidth);
        int j = Math.max(mAnchorRotateHeight, mAnchorDeleteHeight);
        mInvalidateRect.inset(-i * 2, -j * 2);
        return mInvalidateRect;
    }

    public Matrix getMatrix()
    {
        return mMatrix;
    }

    public int getMode()
    {
        return mMode;
    }

    public int getOpacity()
    {
        return mOpacity;
    }

    public float getRotation()
    {
        return mRotation;
    }

    public Matrix getRotationMatrix()
    {
        return mRotateMatrix;
    }

    protected void growBy(float f)
    {
        growBy(f, f / mRatio, true);
    }

    protected void growBy(float f, float f1, boolean flag)
    {
        if (mScaleEnabled)
        {
            RectF rectf = new RectF(mCropRect);
            RectF rectf1;
            if (mAlignVerticalMode == AlignModeV.Center)
            {
                rectf.inset(-f, -f1);
            } else
            if (mAlignVerticalMode == AlignModeV.Top)
            {
                rectf.inset(-f, 0.0F);
                rectf.bottom = rectf.bottom + f1 * 2.0F;
            } else
            {
                rectf.inset(-f, 0.0F);
                rectf.top = rectf.top - f1 * 2.0F;
            }
            rectf1 = getDisplayRect(mMatrix, rectf);
            if (mContent.validateSize(rectf1) || !flag)
            {
                mCropRect.set(rectf);
                invalidate();
                return;
            }
        }
    }

    public void invalidate()
    {
        mDrawRect = computeLayout();
        mRotateMatrix.reset();
        mRotateMatrix.postTranslate(-mDrawRect.centerX(), -mDrawRect.centerY());
        mRotateMatrix.postRotate(mRotation);
        mRotateMatrix.postTranslate(mDrawRect.centerX(), mDrawRect.centerY());
    }

    public void invalidateDrawable(Drawable drawable)
    {
        mContext.invalidate();
    }

    public boolean isFocused()
    {
        return (mState & 4) == 4;
    }

    public boolean isPressed()
    {
        return isSelected() && mMode != 1;
    }

    public boolean isSelected()
    {
        return (mState & 2) == 2;
    }

    void moveBy(float f, float f1)
    {
        if (mMoveEnabled)
        {
            mCropRect.offset(f, f1);
            invalidate();
        }
    }

    public void onMouseMove(int i, MotionEvent motionevent, float f, float f1)
    {
        boolean flag;
        boolean flag1;
        if (i == 1)
        {
            return;
        }
        fpoints[0] = f;
        fpoints[1] = f1;
        mShouldFlip = true;
        if (i == 64)
        {
            moveBy((mCropRect.width() / mDrawRect.width()) * f, (mCropRect.height() / mDrawRect.height()) * f1);
            return;
        }
        if (i == 32)
        {
            f = fpoints[0];
            f1 = fpoints[1];
            float f2 = mCropRect.width() / mDrawRect.width();
            f2 = mCropRect.height() / mDrawRect.height();
            rotateBy(motionevent.getX(), motionevent.getY(), f, f1);
            invalidate();
            return;
        }
        motionevent = new Matrix();
        motionevent.postRotate(-mRotation);
        motionevent.mapPoints(fpoints);
        f = fpoints[0];
        f1 = fpoints[1];
        if ((i & 6) == 0)
        {
            f = 0.0F;
        }
        if ((i & 0x18) == 0)
        {
            f1 = 0.0F;
        }
        f *= mCropRect.width() / mDrawRect.width();
        f1 *= mCropRect.height() / mDrawRect.height();
        flag = UIUtils.checkBits(i, 2);
        flag1 = UIUtils.checkBits(i, 8);
        if (Math.abs(f) < Math.abs(f1)) goto _L2; else goto _L1
_L1:
        f1 = f;
        f = f1;
        if (flag)
        {
            f = f1 * -1F;
        }
_L4:
        growBy(f);
        invalidate();
        return;
_L2:
        f = f1;
        if (flag1)
        {
            f = f1 * -1F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void onMove(float f, float f1)
    {
        moveBy((mCropRect.width() / mDrawRect.width()) * f, (mCropRect.height() / mDrawRect.height()) * f1);
    }

    void onRotateAndGrow(double d, float f)
    {
        if (!mRotateEnabled)
        {
            mRotation = mRotation - (float)d;
        }
        if (mRotateEnabled)
        {
            mRotation = mRotation - (float)d;
            growBy((mCropRect.width() / mDrawRect.width()) * f);
        }
        invalidate();
    }

    public void onSingleTapConfirmed(float f, float f1)
    {
        RectF rectf = new RectF(mDrawRect);
        rectf.inset(-mPadding, -mPadding);
        float af[] = new float[2];
        af[0] = f;
        af[1] = f1;
        Matrix matrix = new Matrix();
        matrix.postTranslate(-rectf.centerX(), -rectf.centerY());
        matrix.postRotate(-mRotation);
        matrix.postTranslate(rectf.centerX(), rectf.centerY());
        matrix.mapPoints(af);
        f = af[0];
        f1 = af[1];
        boolean flag;
        boolean flag1;
        if (f1 >= rectf.top - 40F && f1 < rectf.bottom + 40F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (f >= rectf.left - 40F && f < rectf.right + 40F)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (mAnchorDelete != null && Math.abs(rectf.left - f) < 40F && Math.abs(rectf.top - f1) < 40F && flag && flag1 && mDeleteClickListener != null)
        {
            mDeleteClickListener.onDeleteClick();
        } else
        if (mAnchorRotate == null || Math.abs(rectf.right - f) >= 40F || Math.abs(rectf.bottom - f1) >= 40F || !flag || !flag1)
        {
            if (mAnchorOpacity != null && Math.abs(rectf.right - f) < 40F && Math.abs(rectf.top - f1) < 40F && flag && flag1)
            {
                Log.i("drawable-view", "sticker opacity on singleTapConfirmed");
                if (mOpacityChangeListener != null)
                {
                    mOpacityChangeListener.onChangeOpacity();
                    return;
                }
            }
            if (mContent.getHorizontalFlipEnabled() && isSelected())
            {
                if (mShouldFlip)
                {
                    flipHorizontal();
                    return;
                } else
                {
                    mShouldFlip = true;
                    return;
                }
            }
        }
    }

    public void onSizeChanged(EditableDrawable editabledrawable, float f, float f1, float f2, float f3)
    {
label0:
        {
            if (editabledrawable.equals(mEditableContent) && mContext != null && (mDrawRect.left != f || mDrawRect.top != f1 || mDrawRect.right != f2 || mDrawRect.bottom != f3))
            {
                if (!forceUpdate())
                {
                    break label0;
                }
                mContext.invalidate(getInvalidationRect());
            }
            return;
        }
        mContext.postInvalidate();
    }

    public void playHorizontalFlipDemo()
    {
        float f2 = -1F;
        if (mContent != null && mContent.getHorizontalFlipEnabled())
        {
            boolean flag = mContent.getHorizontalFlip();
            AnimatorSet animatorset = new AnimatorSet();
            Object obj = mContent;
            float f;
            float f1;
            Object obj1;
            if (flag)
            {
                f = -1F;
            } else
            {
                f = 1.0F;
            }
            if (flag)
            {
                f1 = 1.0F;
            } else
            {
                f1 = -1F;
            }
            obj = ObjectAnimator.ofFloat(obj, "scaleX", new float[] {
                f, f1
            });
            ((ObjectAnimator) (obj)).setDuration(200L);
            ((ObjectAnimator) (obj)).setInterpolator(new AccelerateDecelerateInterpolator());
            obj1 = mContent;
            if (flag)
            {
                f = 1.0F;
            } else
            {
                f = -1F;
            }
            if (flag)
            {
                f1 = f2;
            } else
            {
                f1 = 1.0F;
            }
            obj1 = ObjectAnimator.ofFloat(obj1, "scaleX", new float[] {
                f, f1
            });
            ((ObjectAnimator) (obj1)).setDuration(200L);
            ((ObjectAnimator) (obj1)).setStartDelay(50L);
            ((ObjectAnimator) (obj1)).setInterpolator(new AccelerateDecelerateInterpolator());
            animatorset.playSequentially(new Animator[] {
                obj, obj1
            });
            animatorset.setStartDelay(150L);
            animatorset.start();
            animatorset.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

                final DrawableHighlightView this$0;

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    if (mContent != null)
                    {
                        mContent.setHorizontalFlip(false);
                    }
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                this$0 = DrawableHighlightView.this;
                super();
            }
            });
        }
    }

    void rotateBy(float f, float f1, float f2, float f3)
    {
        if (mRotateEnabled || mScaleEnabled)
        {
            float af[] = new float[2];
            af[0] = mDrawRect.centerX();
            af[1] = mDrawRect.centerY();
            float af1[] = new float[2];
            af1[0] = mDrawRect.right;
            af1[1] = mDrawRect.bottom;
            double d = Point2D.angleBetweenPoints(af1, af);
            double d2 = Point2D.angleBetweenPoints(new float[] {
                f, f1
            }, af);
            if (mRotateEnabled)
            {
                mRotation = -(float)(d2 - d);
            }
            if (mScaleEnabled)
            {
                Matrix matrix = new Matrix();
                matrix.postRotate(-mRotation);
                float af2[] = new float[2];
                af2[0] = f2;
                af2[1] = f3;
                matrix.mapPoints(af2);
                f = af2[0];
                f1 = af2[1];
                f2 = mCropRect.width() / mDrawRect.width();
                f3 = mCropRect.height() / mDrawRect.height();
                float f4 = mDrawRect.right;
                float f5 = mDrawRect.bottom;
                double d1 = Point2D.distance(af, af1);
                growBy((float)(Point2D.distance(af, new float[] {
                    f4 + f * f2, f5 + f1 * f3
                }) - d1));
                return;
            }
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l)
    {
    }

    public void setAlignModeV(AlignModeV alignmodev)
    {
        mAlignVerticalMode = alignmodev;
    }

    public void setConfirmedOpacity(int i)
    {
        mConfirmedOpacity = i;
    }

    public void setFocused(boolean flag)
    {
        if (isFocused() != flag)
        {
            mState = mState ^ 4;
            if (mEditableContent != null)
            {
                if (flag)
                {
                    mEditableContent.beginEdit();
                } else
                {
                    mEditableContent.endEdit();
                }
            }
            updateDrawableState();
        }
    }

    public void setHidden(boolean flag)
    {
        mHidden = flag;
    }

    public void setMinSize(float f)
    {
        if (mRatio >= 1.0F)
        {
            mContent.setMinSize(f, f / mRatio);
            return;
        } else
        {
            mContent.setMinSize(mRatio * f, f);
            return;
        }
    }

    public void setMode(int i)
    {
        if (i != mMode)
        {
            mMode = i;
            updateDrawableState();
        }
    }

    public void setOnChangeOpacityListener(OnOpacityChangeListener onopacitychangelistener)
    {
        mOpacityChangeListener = onopacitychangelistener;
    }

    public void setOnContentFlipListener(OnContentFlipListener oncontentfliplistener)
    {
        if (oncontentfliplistener != null)
        {
            mContentFlipListener = new WeakReference(oncontentfliplistener);
            return;
        } else
        {
            mContentFlipListener = null;
            return;
        }
    }

    public void setOnDeleteClickListener(OnDeleteClickListener ondeleteclicklistener)
    {
        mDeleteClickListener = ondeleteclicklistener;
    }

    public void setOpacity(int i)
    {
        getContent().setAlpha(i);
        mOpacity = i;
    }

    public void setPadding(int i)
    {
        mPadding = i;
    }

    public void setSelected(boolean flag)
    {
        if (!flag)
        {
            mShouldFlip = false;
            if (mOpacityChangeListener != null)
            {
                mOpacityChangeListener.onLockOpacity();
            }
        }
        if (isSelected() != flag)
        {
            mState = mState ^ 2;
            updateDrawableState();
        }
    }

    public void setup(Context context, Matrix matrix, Rect rect, RectF rectf, boolean flag)
    {
        mMatrix = new Matrix(matrix);
        mRotation = 0.0F;
        mRotateMatrix = new Matrix();
        mCropRect = rectf;
        setMode(1);
        invalidate();
    }

    public void showAnchors(boolean flag)
    {
        mShowAnchors = flag;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
    }

    public void update(Matrix matrix, Rect rect)
    {
        setMode(1);
        mMatrix = new Matrix(matrix);
        mRotation = 0.0F;
        mRotateMatrix = new Matrix();
        invalidate();
    }

    protected void updateDrawableState()
    {
        int ai1[];
        int ai2[];
        int ai5[];
        boolean flag;
        boolean flag1;
        flag = isSelected();
        flag1 = isFocused();
        ai2 = STATE_SET_NONE;
        ai1 = STATE_SET_NONE;
        ai5 = STATE_SET_NONE;
        if (!flag) goto _L2; else goto _L1
_L1:
        if (mMode != 1) goto _L4; else goto _L3
_L3:
        int ai[];
        int ai3[];
        int ai4[];
        if (flag1)
        {
            ai = STATE_SET_SELECTED_FOCUSED;
            ai4 = ai1;
            ai3 = ai2;
        } else
        {
            ai = STATE_SET_SELECTED;
            ai3 = ai2;
            ai4 = ai1;
        }
_L6:
        if (mBackgroundDrawable != null)
        {
            mBackgroundDrawable.setState(ai);
        }
        if (mAnchorRotate != null)
        {
            mAnchorRotate.setState(ai3);
        }
        if (mAnchorDelete != null)
        {
            mAnchorDelete.setState(ai4);
        }
        if (mAnchorOpacity != null)
        {
            mAnchorOpacity.setState(ai5);
        }
        return;
_L4:
        if ((mMode & 0x80) == 128)
        {
            ai1 = STATE_SET_SELECTED_PRESSED;
        }
        int ai6[] = STATE_SET_SELECTED_PRESSED;
        if ((mMode & 0x20) == 32)
        {
            ai2 = STATE_SET_SELECTED_PRESSED;
        }
        ai = ai6;
        ai3 = ai2;
        ai4 = ai1;
        if ((mMode & 0x100) == 256)
        {
            ai5 = STATE_SET_SELECTED_PRESSED;
            ai = ai6;
            ai3 = ai2;
            ai4 = ai1;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        ai = STATE_SET_NONE;
        ai3 = ai2;
        ai4 = ai1;
        if (true) goto _L6; else goto _L5
_L5:
    }


}

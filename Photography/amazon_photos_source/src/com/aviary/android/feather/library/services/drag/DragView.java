// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services.drag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import com.aviary.android.feather.library.graphics.animation.ExpoInterpolator;
import com.aviary.android.feather.library.graphics.animation.QuadInterpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.aviary.android.feather.library.services.drag:
//            DropTarget

public class DragView extends View
    implements com.nineoldandroids.animation.Animator.AnimatorListener, com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
{

    private static final String LOG_TAG = "DragView";
    protected float mAnimationScaleX;
    protected float mAnimationScaleY;
    protected Bitmap mBitmap;
    protected Paint mDefaultPaint;
    private Object mDragInfo;
    private DropTarget mDropTarget;
    protected ValueAnimator mFadeInAnimator;
    protected ValueAnimator mFadeOutAnimator;
    private boolean mIsDragging;
    private boolean mIsDropping;
    protected android.view.WindowManager.LayoutParams mLayoutParams;
    protected Paint mPaint;
    protected int mRegistrationX;
    protected int mRegistrationY;
    protected float mScaleX;
    protected float mScaleY;
    private int mTextureHeight;
    private int mTextureWidth;
    View mView;
    protected WindowManager mWindowManager;

    public DragView(Context context, Bitmap bitmap, int i, int j, int k, int l, int i1, 
            int j1)
    {
        super(context);
        mAnimationScaleX = 1.0F;
        mAnimationScaleY = 1.0F;
        mIsDragging = false;
        mIsDropping = false;
        init(context);
        mTextureWidth = i1;
        mTextureHeight = j1;
        mDefaultPaint = new Paint(1);
        mDefaultPaint.setColor(0xff000000);
        context = new Matrix();
        float f = i1;
        mScaleY = (0.0F + f) / f;
        mScaleX = mScaleY;
        f = mScaleY;
        context.setScale(f, f);
        mBitmap = Bitmap.createBitmap(bitmap, k, l, i1, j1, context, false);
        mRegistrationX = i + 0;
        mRegistrationY = j + 0;
    }

    public DragView(Context context, Bitmap bitmap, View view)
    {
        super(context);
        mAnimationScaleX = 1.0F;
        mAnimationScaleY = 1.0F;
        mIsDragging = false;
        mIsDropping = false;
        init(context);
        mBitmap = bitmap;
        mView = view;
        mTextureWidth = mBitmap.getWidth();
        mTextureHeight = mBitmap.getHeight();
        mScaleX = (float)mBitmap.getWidth() / (float)mView.getWidth();
        mScaleY = (float)mBitmap.getHeight() / (float)mView.getHeight();
        mAnimationScaleX = mScaleX;
        mAnimationScaleY = mScaleY;
        Log.v("DragView", (new StringBuilder()).append("mScale: ").append(mScaleX).append("x").append(mScaleY).toString());
    }

    private void init(Context context)
    {
        mWindowManager = (WindowManager)context.getSystemService("window");
        setPaint(new Paint());
        mFadeInAnimator = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        mFadeInAnimator.setDuration(200L);
        mFadeInAnimator.setInterpolator(new ExpoInterpolator(com.aviary.android.feather.library.graphics.animation.EasingType.Type.OUT));
        mFadeInAnimator.addUpdateListener(this);
        mFadeOutAnimator = ValueAnimator.ofFloat(new float[] {
            1.0F, 0.0F
        });
        mFadeOutAnimator.setDuration(200L);
        mFadeOutAnimator.setInterpolator(new ExpoInterpolator(com.aviary.android.feather.library.graphics.animation.EasingType.Type.OUT));
        mFadeOutAnimator.addUpdateListener(this);
        mFadeOutAnimator.addListener(this);
    }

    public float getScaleFactorX()
    {
        return mScaleX;
    }

    public float getScaleFactorY()
    {
        return mScaleY;
    }

    public void move(int i, int j)
    {
        android.view.WindowManager.LayoutParams layoutparams = mLayoutParams;
        if (!mIsDragging)
        {
            mRegistrationX = i - layoutparams.x;
            mRegistrationY = j - layoutparams.y;
            mIsDragging = true;
        }
        layoutparams.x = i - mRegistrationX;
        layoutparams.y = j - mRegistrationY;
        mWindowManager.updateViewLayout(this, layoutparams);
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (mWindowManager != null)
        {
            mWindowManager.removeView(this);
            return;
        } else
        {
            Log.w("DragView", "window manager is null");
            return;
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        onEasingValueChanged(((Float)valueanimator.getAnimatedValue()).floatValue());
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mBitmap != null && !mBitmap.isRecycled())
        {
            mBitmap.recycle();
            mBitmap = null;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        if (mAnimationScaleX < 0.999F || mAnimationScaleY < 0.999F)
        {
            canvas.translate(((float)mTextureWidth - (float)mTextureWidth * mAnimationScaleX) / 2.0F, ((float)mTextureHeight - (float)mTextureHeight * mAnimationScaleY) / 2.0F);
            canvas.scale(mAnimationScaleX, mAnimationScaleY);
        }
        if (mBitmap != null && !mBitmap.isRecycled())
        {
            canvas.drawBitmap(mBitmap, 0.0F, 0.0F, mPaint);
            return;
        } else
        {
            Log.e("DragView", "invalid bitmap or recycled bitmap");
            canvas.drawRect(0.0F, 0.0F, mTextureWidth, mTextureHeight, mDefaultPaint);
            return;
        }
    }

    public void onDrop(final int dropCenterX, final int dropCenterY, DropTarget droptarget, Object obj)
    {
        mDropTarget = droptarget;
        mDragInfo = obj;
        mIsDropping = true;
        droptarget = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        droptarget.setDuration(200L);
        droptarget.setInterpolator(new QuadInterpolator(com.aviary.android.feather.library.graphics.animation.EasingType.Type.OUT));
        droptarget.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {

            final DragView this$0;
            final int val$dropCenterX;
            final int val$dropCenterY;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
                valueanimator = mLayoutParams;
                int i = ((android.view.WindowManager.LayoutParams) (valueanimator)).x + mBitmap.getWidth() / 2;
                int j = ((android.view.WindowManager.LayoutParams) (valueanimator)).y + mBitmap.getHeight() / 2;
                int k = (int)((float)dropCenterX * f + (1.0F - f) * (float)i);
                int l = (int)((float)dropCenterY * f + (1.0F - f) * (float)j);
                valueanimator.x = ((android.view.WindowManager.LayoutParams) (valueanimator)).x + (k - i);
                valueanimator.y = ((android.view.WindowManager.LayoutParams) (valueanimator)).y + (l - j);
                if (mWindowManager != null)
                {
                    mWindowManager.updateViewLayout(DragView.this, valueanimator);
                }
                mAnimationScaleX = (1.0F - f) + f / mScaleX;
                mAnimationScaleY = (1.0F - f) + f / mScaleY;
                invalidate();
            }

            
            {
                this$0 = DragView.this;
                dropCenterX = i;
                dropCenterY = j;
                super();
            }
        });
        droptarget.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

            final DragView this$0;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                mIsDropping = false;
                if (mDropTarget != null)
                {
                    mDropTarget.onDragViewDropAnimationFinished(mDragInfo, DragView.this);
                }
                remove(false);
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                this$0 = DragView.this;
                super();
            }
        });
        droptarget.start();
    }

    public void onEasingValueChanged(float f)
    {
        mAnimationScaleX = ((mScaleX - 1.0F) * f + 1.0F) / mScaleX;
        mAnimationScaleY = ((mScaleY - 1.0F) * f + 1.0F) / mScaleY;
        mPaint.setAlpha((int)(255F * f));
        invalidate();
    }

    protected void onMeasure(int i, int j)
    {
        setMeasuredDimension(mBitmap.getWidth(), mBitmap.getHeight());
    }

    public void remove(boolean flag)
    {
label0:
        {
            if (!mIsDropping)
            {
                mFadeInAnimator.cancel();
                if (!flag)
                {
                    break label0;
                }
                mFadeOutAnimator.setFloatValues(new float[] {
                    1.0F, 0.0F
                });
                mFadeOutAnimator.start();
            }
            return;
        }
        if (getHandler() != null)
        {
            getHandler().post(new Runnable() {

                final DragView this$0;
                final View val$view;

                public void run()
                {
                    mWindowManager.removeView(view);
                }

            
            {
                this$0 = DragView.this;
                view = view1;
                super();
            }
            });
            return;
        } else
        {
            mWindowManager.removeView(this);
            return;
        }
    }

    public void setPaint(Paint paint)
    {
        mPaint = paint;
        invalidate();
    }

    public void show(IBinder ibinder, int i, int j, boolean flag)
    {
        android.view.WindowManager.LayoutParams layoutparams = new android.view.WindowManager.LayoutParams(-2, -2, i - mRegistrationX, j - mRegistrationY, 1002, 768, -3);
        layoutparams.gravity = 51;
        layoutparams.token = ibinder;
        layoutparams.setTitle("DragView");
        mLayoutParams = layoutparams;
        mWindowManager.addView(this, layoutparams);
        if (flag)
        {
            mAnimationScaleX = 1.0F / mScaleX;
            mAnimationScaleY = 1.0F / mScaleY;
            mFadeInAnimator.setFloatValues(new float[] {
                0.0F, 1.0F
            });
            mFadeInAnimator.start();
            return;
        } else
        {
            onEasingValueChanged(1.0F);
            return;
        }
    }


/*
    static boolean access$002(DragView dragview, boolean flag)
    {
        dragview.mIsDropping = flag;
        return flag;
    }

*/


}

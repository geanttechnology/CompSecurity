// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.pager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import java.util.HashMap;
import java.util.LinkedHashMap;

// Referenced classes of package com.aio.downloader.pager:
//            OutlineContainer

public class JazzyViewPager extends ViewPager
{
    private static final class State extends Enum
    {

        private static final State ENUM$VALUES[];
        public static final State GOING_LEFT;
        public static final State GOING_RIGHT;
        public static final State IDLE;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/aio/downloader/pager/JazzyViewPager$State, s);
        }

        public static State[] values()
        {
            State astate[] = ENUM$VALUES;
            int i = astate.length;
            State astate1[] = new State[i];
            System.arraycopy(astate, 0, astate1, 0, i);
            return astate1;
        }

        static 
        {
            IDLE = new State("IDLE", 0);
            GOING_LEFT = new State("GOING_LEFT", 1);
            GOING_RIGHT = new State("GOING_RIGHT", 2);
            ENUM$VALUES = (new State[] {
                IDLE, GOING_LEFT, GOING_RIGHT
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class TransitionEffect extends Enum
    {

        public static final TransitionEffect Accordion;
        public static final TransitionEffect CubeIn;
        public static final TransitionEffect CubeOut;
        private static final TransitionEffect ENUM$VALUES[];
        public static final TransitionEffect FlipHorizontal;
        public static final TransitionEffect FlipVertical;
        public static final TransitionEffect RotateDown;
        public static final TransitionEffect RotateUp;
        public static final TransitionEffect Stack;
        public static final TransitionEffect Standard;
        public static final TransitionEffect Tablet;
        public static final TransitionEffect ZoomIn;
        public static final TransitionEffect ZoomOut;

        public static TransitionEffect valueOf(String s)
        {
            return (TransitionEffect)Enum.valueOf(com/aio/downloader/pager/JazzyViewPager$TransitionEffect, s);
        }

        public static TransitionEffect[] values()
        {
            TransitionEffect atransitioneffect[] = ENUM$VALUES;
            int i = atransitioneffect.length;
            TransitionEffect atransitioneffect1[] = new TransitionEffect[i];
            System.arraycopy(atransitioneffect, 0, atransitioneffect1, 0, i);
            return atransitioneffect1;
        }

        static 
        {
            Standard = new TransitionEffect("Standard", 0);
            Tablet = new TransitionEffect("Tablet", 1);
            CubeIn = new TransitionEffect("CubeIn", 2);
            CubeOut = new TransitionEffect("CubeOut", 3);
            FlipVertical = new TransitionEffect("FlipVertical", 4);
            FlipHorizontal = new TransitionEffect("FlipHorizontal", 5);
            Stack = new TransitionEffect("Stack", 6);
            ZoomIn = new TransitionEffect("ZoomIn", 7);
            ZoomOut = new TransitionEffect("ZoomOut", 8);
            RotateUp = new TransitionEffect("RotateUp", 9);
            RotateDown = new TransitionEffect("RotateDown", 10);
            Accordion = new TransitionEffect("Accordion", 11);
            ENUM$VALUES = (new TransitionEffect[] {
                Standard, Tablet, CubeIn, CubeOut, FlipVertical, FlipHorizontal, Stack, ZoomIn, ZoomOut, RotateUp, 
                RotateDown, Accordion
            });
        }

        private TransitionEffect(String s, int i)
        {
            super(s, i);
        }
    }


    private static int $SWITCH_TABLE$com$aio$downloader$pager$JazzyViewPager$TransitionEffect[];
    private static final boolean API_11;
    private static final float ROT_MAX = 15F;
    private static final float SCALE_MAX = 0.5F;
    public static final String TAG = "JazzyViewPager";
    private static final float ZOOM_MAX = 0.5F;
    public static int sOutlineColor = -1;
    private Camera mCamera;
    private TransitionEffect mEffect;
    private boolean mEnabled;
    private boolean mFadeEnabled;
    private View mLeft;
    private Matrix mMatrix;
    private HashMap mObjs;
    private boolean mOutlineEnabled;
    private View mRight;
    private float mRot;
    private float mScale;
    private State mState;
    private float mTempFloat2[];
    private float mTrans;
    private int oldPage;

    static int[] $SWITCH_TABLE$com$aio$downloader$pager$JazzyViewPager$TransitionEffect()
    {
        int ai[] = $SWITCH_TABLE$com$aio$downloader$pager$JazzyViewPager$TransitionEffect;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[TransitionEffect.values().length];
        try
        {
            ai[TransitionEffect.Accordion.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            ai[TransitionEffect.CubeIn.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            ai[TransitionEffect.CubeOut.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            ai[TransitionEffect.FlipHorizontal.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            ai[TransitionEffect.FlipVertical.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            ai[TransitionEffect.RotateDown.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[TransitionEffect.RotateUp.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[TransitionEffect.Stack.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[TransitionEffect.Standard.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[TransitionEffect.Tablet.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[TransitionEffect.ZoomIn.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[TransitionEffect.ZoomOut.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$aio$downloader$pager$JazzyViewPager$TransitionEffect = ai;
        return ai;
    }

    public JazzyViewPager(Context context)
    {
        this(context, null);
    }

    public JazzyViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mEnabled = true;
        mFadeEnabled = false;
        mOutlineEnabled = false;
        mEffect = TransitionEffect.RotateUp;
        mObjs = new LinkedHashMap();
        mMatrix = new Matrix();
        mCamera = new Camera();
        mTempFloat2 = new float[2];
        setClipChildren(false);
        context = context.obtainStyledAttributes(attributeset, com.aio.downloader.R.styleable.JazzyViewPager);
        int i = context.getInt(0, 0);
        setTransitionEffect(TransitionEffect.valueOf(getResources().getStringArray(0x7f060001)[i]));
        setFadeEnabled(context.getBoolean(1, false));
        setOutlineEnabled(context.getBoolean(2, false));
        setOutlineColor(context.getColor(3, -1));
        $SWITCH_TABLE$com$aio$downloader$pager$JazzyViewPager$TransitionEffect()[mEffect.ordinal()];
        JVM INSTR tableswitch 10 12: default 176
    //                   10 181
    //                   11 176
    //                   12 181;
           goto _L1 _L2 _L1 _L2
_L1:
        context.recycle();
        return;
_L2:
        setFadeEnabled(true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void animateAccordion(View view, View view1, float f)
    {
        if (mState != State.IDLE)
        {
            if (view != null)
            {
                manageLayer(view, true);
                ViewHelper.setPivotX(view, view.getMeasuredWidth());
                ViewHelper.setPivotY(view, 0.0F);
                ViewHelper.setScaleX(view, 1.0F - f);
            }
            if (view1 != null)
            {
                manageLayer(view1, true);
                ViewHelper.setPivotX(view1, 0.0F);
                ViewHelper.setPivotY(view1, 0.0F);
                ViewHelper.setScaleX(view1, f);
            }
        }
    }

    private void animateCube(View view, View view1, float f, boolean flag)
    {
        float f2 = 90F;
        if (mState != State.IDLE)
        {
            float f1;
            if (view != null)
            {
                manageLayer(view, true);
                if (flag)
                {
                    f1 = 90F;
                } else
                {
                    f1 = -90F;
                }
                mRot = f1 * f;
                ViewHelper.setPivotX(view, view.getMeasuredWidth());
                ViewHelper.setPivotY(view, (float)view.getMeasuredHeight() * 0.5F);
                ViewHelper.setRotationY(view, mRot);
            }
            if (view1 != null)
            {
                manageLayer(view1, true);
                if (flag)
                {
                    f1 = f2;
                } else
                {
                    f1 = -90F;
                }
                mRot = -f1 * (1.0F - f);
                ViewHelper.setPivotX(view1, 0.0F);
                ViewHelper.setPivotY(view1, (float)view1.getMeasuredHeight() * 0.5F);
                ViewHelper.setRotationY(view1, mRot);
            }
        }
    }

    private void animateFlipHorizontal(View view, View view1, float f, int i)
    {
label0:
        {
            if (mState != State.IDLE)
            {
                if (view != null)
                {
                    manageLayer(view, true);
                    mRot = 180F * f;
                    if (mRot > 90F)
                    {
                        view.setVisibility(4);
                    } else
                    {
                        if (view.getVisibility() == 4)
                        {
                            view.setVisibility(0);
                        }
                        mTrans = i;
                        ViewHelper.setPivotX(view, (float)view.getMeasuredWidth() * 0.5F);
                        ViewHelper.setPivotY(view, (float)view.getMeasuredHeight() * 0.5F);
                        ViewHelper.setTranslationX(view, mTrans);
                        ViewHelper.setRotationY(view, mRot);
                    }
                }
                if (view1 != null)
                {
                    manageLayer(view1, true);
                    mRot = -180F * (1.0F - f);
                    if (mRot >= -90F)
                    {
                        break label0;
                    }
                    view1.setVisibility(4);
                }
            }
            return;
        }
        if (view1.getVisibility() == 4)
        {
            view1.setVisibility(0);
        }
        mTrans = (-getWidth() - getPageMargin()) + i;
        ViewHelper.setPivotX(view1, (float)view1.getMeasuredWidth() * 0.5F);
        ViewHelper.setPivotY(view1, (float)view1.getMeasuredHeight() * 0.5F);
        ViewHelper.setTranslationX(view1, mTrans);
        ViewHelper.setRotationY(view1, mRot);
    }

    private void animateFlipVertical(View view, View view1, float f, int i)
    {
label0:
        {
            if (mState != State.IDLE)
            {
                if (view != null)
                {
                    manageLayer(view, true);
                    mRot = 180F * f;
                    if (mRot > 90F)
                    {
                        view.setVisibility(4);
                    } else
                    {
                        if (view.getVisibility() == 4)
                        {
                            view.setVisibility(0);
                        }
                        mTrans = i;
                        ViewHelper.setPivotX(view, (float)view.getMeasuredWidth() * 0.5F);
                        ViewHelper.setPivotY(view, (float)view.getMeasuredHeight() * 0.5F);
                        ViewHelper.setTranslationX(view, mTrans);
                        ViewHelper.setRotationX(view, mRot);
                    }
                }
                if (view1 != null)
                {
                    manageLayer(view1, true);
                    mRot = -180F * (1.0F - f);
                    if (mRot >= -90F)
                    {
                        break label0;
                    }
                    view1.setVisibility(4);
                }
            }
            return;
        }
        if (view1.getVisibility() == 4)
        {
            view1.setVisibility(0);
        }
        mTrans = (-getWidth() - getPageMargin()) + i;
        ViewHelper.setPivotX(view1, (float)view1.getMeasuredWidth() * 0.5F);
        ViewHelper.setPivotY(view1, (float)view1.getMeasuredHeight() * 0.5F);
        ViewHelper.setTranslationX(view1, mTrans);
        ViewHelper.setRotationX(view1, mRot);
    }

    private void animateRotate(View view, View view1, float f, boolean flag)
    {
        if (mState != State.IDLE)
        {
            int i;
            if (view != null)
            {
                manageLayer(view, true);
                if (flag)
                {
                    i = 1;
                } else
                {
                    i = -1;
                }
                mRot = (float)i * (15F * f);
                if (flag)
                {
                    i = -1;
                } else
                {
                    i = 1;
                }
                mTrans = (float)i * (float)((double)getMeasuredHeight() - (double)getMeasuredHeight() * Math.cos(((double)mRot * 3.1415926535897931D) / 180D));
                ViewHelper.setPivotX(view, (float)view.getMeasuredWidth() * 0.5F);
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = view.getMeasuredHeight();
                }
                ViewHelper.setPivotY(view, i);
                ViewHelper.setTranslationY(view, mTrans);
                ViewHelper.setRotation(view, mRot);
            }
            if (view1 != null)
            {
                manageLayer(view1, true);
                if (flag)
                {
                    i = 1;
                } else
                {
                    i = -1;
                }
                mRot = (float)i * (-15F + 15F * f);
                if (flag)
                {
                    i = -1;
                } else
                {
                    i = 1;
                }
                mTrans = (float)i * (float)((double)getMeasuredHeight() - (double)getMeasuredHeight() * Math.cos(((double)mRot * 3.1415926535897931D) / 180D));
                ViewHelper.setPivotX(view1, (float)view1.getMeasuredWidth() * 0.5F);
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = view1.getMeasuredHeight();
                }
                ViewHelper.setPivotY(view1, i);
                ViewHelper.setTranslationY(view1, mTrans);
                ViewHelper.setRotation(view1, mRot);
            }
        }
    }

    private void animateZoom(View view, View view1, float f, boolean flag)
    {
        if (mState != State.IDLE)
        {
            if (view != null)
            {
                manageLayer(view, true);
                float f1;
                if (flag)
                {
                    f1 = (1.0F - f) * 0.5F + 0.5F;
                } else
                {
                    f1 = 1.5F - (1.0F - f) * 0.5F;
                }
                mScale = f1;
                ViewHelper.setPivotX(view, (float)view.getMeasuredWidth() * 0.5F);
                ViewHelper.setPivotY(view, (float)view.getMeasuredHeight() * 0.5F);
                ViewHelper.setScaleX(view, mScale);
                ViewHelper.setScaleY(view, mScale);
            }
            if (view1 != null)
            {
                manageLayer(view1, true);
                if (flag)
                {
                    f = 0.5F * f + 0.5F;
                } else
                {
                    f = 1.5F - 0.5F * f;
                }
                mScale = f;
                ViewHelper.setPivotX(view1, (float)view1.getMeasuredWidth() * 0.5F);
                ViewHelper.setPivotY(view1, (float)view1.getMeasuredHeight() * 0.5F);
                ViewHelper.setScaleX(view1, mScale);
                ViewHelper.setScaleY(view1, mScale);
            }
        }
    }

    private void disableHardwareLayer()
    {
        if (API_11)
        {
            int i = 0;
            while (i < getChildCount()) 
            {
                View view = getChildAt(i);
                if (view.getLayerType() != 0)
                {
                    view.setLayerType(0, null);
                }
                i++;
            }
        }
    }

    private boolean isSmall(float f)
    {
        return (double)Math.abs(f) < 0.0001D;
    }

    private void logState(View view, String s)
    {
        Log.v("JazzyViewPager", (new StringBuilder(String.valueOf(s))).append(": ROT (").append(ViewHelper.getRotation(view)).append(", ").append(ViewHelper.getRotationX(view)).append(", ").append(ViewHelper.getRotationY(view)).append("), TRANS (").append(ViewHelper.getTranslationX(view)).append(", ").append(ViewHelper.getTranslationY(view)).append("), SCALE (").append(ViewHelper.getScaleX(view)).append(", ").append(ViewHelper.getScaleY(view)).append("), ALPHA ").append(ViewHelper.getAlpha(view)).toString());
    }

    private void manageLayer(View view, boolean flag)
    {
        if (API_11)
        {
            byte byte0;
            if (flag)
            {
                byte0 = 2;
            } else
            {
                byte0 = 0;
            }
            if (byte0 != view.getLayerType())
            {
                view.setLayerType(byte0, null);
                return;
            }
        }
    }

    private View wrapChild(View view)
    {
        if (!mOutlineEnabled || (view instanceof OutlineContainer))
        {
            return view;
        } else
        {
            OutlineContainer outlinecontainer = new OutlineContainer(getContext());
            outlinecontainer.setLayoutParams(generateDefaultLayoutParams());
            view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            outlinecontainer.addView(view);
            return outlinecontainer;
        }
    }

    private void wrapWithOutlines()
    {
        int i = 0;
        do
        {
            if (i >= getChildCount())
            {
                return;
            }
            View view = getChildAt(i);
            if (!(view instanceof OutlineContainer))
            {
                removeView(view);
                super.addView(wrapChild(view), i);
            }
            i++;
        } while (true);
    }

    public void addView(View view)
    {
        super.addView(wrapChild(view));
    }

    public void addView(View view, int i)
    {
        super.addView(wrapChild(view), i);
    }

    public void addView(View view, int i, int j)
    {
        super.addView(wrapChild(view), i, j);
    }

    public void addView(View view, int i, android.support.v4.view.ViewPager.LayoutParams layoutparams)
    {
        super.addView(wrapChild(view), i, layoutparams);
    }

    public void addView(View view, android.support.v4.view.ViewPager.LayoutParams layoutparams)
    {
        super.addView(wrapChild(view), layoutparams);
    }

    protected void animateFade(View view, View view1, float f)
    {
        if (view != null)
        {
            ViewHelper.setAlpha(view, 1.0F - f);
        }
        if (view1 != null)
        {
            ViewHelper.setAlpha(view1, f);
        }
    }

    protected void animateOutline(View view, View view1)
    {
        if (view instanceof OutlineContainer) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (mState == State.IDLE)
        {
            break; /* Loop/switch isn't completed */
        }
        if (view != null)
        {
            manageLayer(view, true);
            ((OutlineContainer)view).setOutlineAlpha(1.0F);
        }
        if (view1 != null)
        {
            manageLayer(view1, true);
            ((OutlineContainer)view1).setOutlineAlpha(1.0F);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (view != null)
        {
            ((OutlineContainer)view).start();
        }
        if (view1 != null)
        {
            ((OutlineContainer)view1).start();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void animateScroll(int i, float f)
    {
        if (mState != State.IDLE)
        {
            mRot = ((float)(1.0D - Math.cos(6.2831853071795862D * (double)f)) / 2.0F) * 30F;
            if (mState == State.GOING_RIGHT)
            {
                f = mRot;
            } else
            {
                f = -mRot;
            }
            ViewHelper.setRotationY(this, f);
            ViewHelper.setPivotX(this, (float)getMeasuredWidth() * 0.5F);
            ViewHelper.setPivotY(this, (float)getMeasuredHeight() * 0.5F);
        }
    }

    protected void animateStack(View view, View view1, float f, int i)
    {
        if (mState != State.IDLE)
        {
            if (view1 != null)
            {
                manageLayer(view1, true);
                mScale = 0.5F * f + 0.5F;
                mTrans = (-getWidth() - getPageMargin()) + i;
                ViewHelper.setScaleX(view1, mScale);
                ViewHelper.setScaleY(view1, mScale);
                ViewHelper.setTranslationX(view1, mTrans);
            }
            if (view != null)
            {
                view.bringToFront();
            }
        }
    }

    protected void animateTablet(View view, View view1, float f)
    {
        if (mState != State.IDLE)
        {
            if (view != null)
            {
                manageLayer(view, true);
                mRot = 30F * f;
                mTrans = getOffsetXForRotation(mRot, view.getMeasuredWidth(), view.getMeasuredHeight());
                ViewHelper.setPivotX(view, view.getMeasuredWidth() / 2);
                ViewHelper.setPivotY(view, view.getMeasuredHeight() / 2);
                ViewHelper.setTranslationX(view, mTrans);
                ViewHelper.setRotationY(view, mRot);
                logState(view, "Left");
            }
            if (view1 != null)
            {
                manageLayer(view1, true);
                mRot = -30F * (1.0F - f);
                mTrans = getOffsetXForRotation(mRot, view1.getMeasuredWidth(), view1.getMeasuredHeight());
                ViewHelper.setPivotX(view1, (float)view1.getMeasuredWidth() * 0.5F);
                ViewHelper.setPivotY(view1, (float)view1.getMeasuredHeight() * 0.5F);
                ViewHelper.setTranslationX(view1, mTrans);
                ViewHelper.setRotationY(view1, mRot);
                logState(view1, "Right");
            }
        }
    }

    public View findViewFromObject(int i)
    {
        Object obj = mObjs.get(Integer.valueOf(i));
        if (obj != null) goto _L2; else goto _L1
_L1:
        View view = null;
_L4:
        return view;
_L2:
        PagerAdapter pageradapter = getAdapter();
        i = 0;
        do
        {
            if (i >= getChildCount())
            {
                return null;
            }
            View view1 = getChildAt(i);
            view = view1;
            if (pageradapter.isViewFromObject(view1, obj))
            {
                continue;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean getFadeEnabled()
    {
        return mFadeEnabled;
    }

    protected float getOffsetXForRotation(float f, int i, int j)
    {
        mMatrix.reset();
        mCamera.save();
        mCamera.rotateY(Math.abs(f));
        mCamera.getMatrix(mMatrix);
        mCamera.restore();
        mMatrix.preTranslate((float)(-i) * 0.5F, (float)(-j) * 0.5F);
        mMatrix.postTranslate((float)i * 0.5F, (float)j * 0.5F);
        mTempFloat2[0] = i;
        mTempFloat2[1] = j;
        mMatrix.mapPoints(mTempFloat2);
        float f1 = i;
        float f2 = mTempFloat2[0];
        if (f > 0.0F)
        {
            f = 1.0F;
        } else
        {
            f = -1F;
        }
        return f * (f1 - f2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (mEnabled)
        {
            return super.onInterceptTouchEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        float f1;
        boolean flag;
        if (mState == State.IDLE && f > 0.0F)
        {
            oldPage = getCurrentItem();
            State state;
            if (i == oldPage)
            {
                state = State.GOING_RIGHT;
            } else
            {
                state = State.GOING_LEFT;
            }
            mState = state;
        }
        if (i == oldPage)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mState == State.GOING_RIGHT && !flag)
        {
            mState = State.GOING_LEFT;
        } else
        if (mState == State.GOING_LEFT && flag)
        {
            mState = State.GOING_RIGHT;
        }
        if (isSmall(f))
        {
            f1 = 0.0F;
        } else
        {
            f1 = f;
        }
        mLeft = findViewFromObject(i);
        mRight = findViewFromObject(i + 1);
        if (mFadeEnabled)
        {
            animateFade(mLeft, mRight, f1);
        }
        if (mOutlineEnabled)
        {
            animateOutline(mLeft, mRight);
        }
        $SWITCH_TABLE$com$aio$downloader$pager$JazzyViewPager$TransitionEffect()[mEffect.ordinal()];
        JVM INSTR tableswitch 1 12: default 220
    //                   1 220
    //                   2 291
    //                   3 308
    //                   4 326
    //                   5 344
    //                   6 361
    //                   7 376
    //                   8 394
    //                   9 412
    //                   10 430
    //                   11 448
    //                   12 466;
           goto _L1 _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        super.onPageScrolled(i, f, j);
        if (f1 == 0.0F)
        {
            disableHardwareLayer();
            mState = State.IDLE;
        }
        return;
_L2:
        animateTablet(mLeft, mRight, f1);
        continue; /* Loop/switch isn't completed */
_L3:
        animateCube(mLeft, mRight, f1, true);
        continue; /* Loop/switch isn't completed */
_L4:
        animateCube(mLeft, mRight, f1, false);
        continue; /* Loop/switch isn't completed */
_L5:
        animateFlipVertical(mLeft, mRight, f, j);
        continue; /* Loop/switch isn't completed */
_L6:
        animateFlipHorizontal(mLeft, mRight, f1, j);
_L7:
        animateStack(mLeft, mRight, f1, j);
        continue; /* Loop/switch isn't completed */
_L8:
        animateZoom(mLeft, mRight, f1, true);
        continue; /* Loop/switch isn't completed */
_L9:
        animateZoom(mLeft, mRight, f1, false);
        continue; /* Loop/switch isn't completed */
_L10:
        animateRotate(mLeft, mRight, f1, true);
        continue; /* Loop/switch isn't completed */
_L11:
        animateRotate(mLeft, mRight, f1, false);
        continue; /* Loop/switch isn't completed */
_L12:
        animateAccordion(mLeft, mRight, f1);
        if (true) goto _L1; else goto _L13
_L13:
    }

    public void setFadeEnabled(boolean flag)
    {
        mFadeEnabled = flag;
    }

    public void setObjectForPosition(Object obj, int i)
    {
        mObjs.put(Integer.valueOf(i), obj);
    }

    public void setOutlineColor(int i)
    {
        sOutlineColor = i;
    }

    public void setOutlineEnabled(boolean flag)
    {
        mOutlineEnabled = flag;
        wrapWithOutlines();
    }

    public void setPagingEnabled(boolean flag)
    {
        mEnabled = flag;
    }

    public void setTransitionEffect(TransitionEffect transitioneffect)
    {
        mEffect = transitioneffect;
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        API_11 = flag;
    }
}

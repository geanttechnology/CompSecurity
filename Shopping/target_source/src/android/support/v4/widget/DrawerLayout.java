// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.a.a;
import android.support.v4.view.ai;
import android.support.v4.view.av;
import android.support.v4.view.e;
import android.support.v4.view.g;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.v4.widget:
//            f, x

public class DrawerLayout extends ViewGroup
    implements android.support.v4.widget.f
{
    public static interface f
    {

        public abstract void a(int i1);

        public abstract void a(View view);

        public abstract void a(View view, float f1);

        public abstract void b(View view);
    }


    private static final boolean ALLOW_EDGE_LOCK = false;
    private static final boolean CAN_HIDE_DESCENDANTS;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = 0x99000000;
    static final c IMPL;
    private static final int LAYOUT_ATTRS[] = {
        0x10100b3
    };
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final float TOUCH_SLOP_SENSITIVITY = 1F;
    private final b mChildAccessibilityDelegate;
    private boolean mChildrenCanceledTouch;
    private boolean mDisallowInterceptRequested;
    private boolean mDrawStatusBarBackground;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final h mLeftCallback;
    private final x mLeftDragger;
    private f mListener;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mMinDrawerMargin;
    private final h mRightCallback;
    private final x mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowLeft;
    private Drawable mShadowRight;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    public DrawerLayout(Context context)
    {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
    /* block-local class not found */
    class b {}

        mChildAccessibilityDelegate = new b();
        mScrimColor = 0x99000000;
        mScrimPaint = new Paint();
        mFirstLayout = true;
        setDescendantFocusability(0x40000);
        float f1 = getResources().getDisplayMetrics().density;
        mMinDrawerMargin = (int)(64F * f1 + 0.5F);
        f1 *= 400F;
    /* block-local class not found */
    class h {}

        mLeftCallback = new h(3);
        mRightCallback = new h(5);
        mLeftDragger = android.support.v4.widget.x.a(this, 1.0F, mLeftCallback);
        mLeftDragger.a(1);
        mLeftDragger.a(f1);
        mLeftCallback.a(mLeftDragger);
        mRightDragger = android.support.v4.widget.x.a(this, 1.0F, mRightCallback);
        mRightDragger.a(2);
        mRightDragger.a(f1);
        mRightCallback.a(mRightDragger);
        setFocusableInTouchMode(true);
        ai.c(this, 1);
    /* block-local class not found */
    class a {}

        ai.a(this, new a());
        av.a(this, false);
        if (ai.w(this))
        {
    /* block-local class not found */
    class c {}

            IMPL.a(this);
            mStatusBarBackground = IMPL.a(context);
        }
    }

    static View a(DrawerLayout drawerlayout)
    {
        return drawerlayout.h();
    }

    private void a(View view, boolean flag)
    {
        int j1 = getChildCount();
        int i1 = 0;
        while (i1 < j1) 
        {
            View view1 = getChildAt(i1);
            if (!flag && !g(view1) || flag && view1 == view)
            {
                ai.c(view1, 1);
            } else
            {
                ai.c(view1, 4);
            }
            i1++;
        }
    }

    static String c(int i1)
    {
        if ((i1 & 3) == 3)
        {
            return "LEFT";
        }
        if ((i1 & 5) == 5)
        {
            return "RIGHT";
        } else
        {
            return Integer.toHexString(i1);
        }
    }

    static int[] d()
    {
        return LAYOUT_ATTRS;
    }

    static boolean e()
    {
        return CAN_HIDE_DESCENDANTS;
    }

    private boolean f()
    {
        int j1 = getChildCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
    /* block-local class not found */
    class g {}

            if (((g)getChildAt(i1).getLayoutParams()).c)
            {
                return true;
            }
        }

        return false;
    }

    private boolean g()
    {
        return h() != null;
    }

    private View h()
    {
        int j1 = getChildCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view = getChildAt(i1);
            if (g(view) && k(view))
            {
                return view;
            }
        }

        return null;
    }

    static boolean l(View view)
    {
        return n(view);
    }

    private static boolean m(View view)
    {
        boolean flag1 = false;
        view = view.getBackground();
        boolean flag = flag1;
        if (view != null)
        {
            flag = flag1;
            if (view.getOpacity() == -1)
            {
                flag = true;
            }
        }
        return flag;
    }

    private static boolean n(View view)
    {
        return ai.e(view) != 4 && ai.e(view) != 2;
    }

    public int a(View view)
    {
        int i1 = e(view);
        if (i1 == 3)
        {
            return mLockModeLeft;
        }
        if (i1 == 5)
        {
            return mLockModeRight;
        } else
        {
            return 0;
        }
    }

    View a()
    {
        int j1 = getChildCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view = getChildAt(i1);
            if (((g)view.getLayoutParams()).d)
            {
                return view;
            }
        }

        return null;
    }

    public CharSequence a(int i1)
    {
        i1 = android.support.v4.view.e.a(i1, ai.h(this));
        if (i1 == 3)
        {
            return mTitleLeft;
        }
        if (i1 == 5)
        {
            return mTitleRight;
        } else
        {
            return null;
        }
    }

    public void a(int i1, int j1)
    {
        a(getResources().getDrawable(i1), j1);
    }

    void a(int i1, int j1, View view)
    {
        g g1;
        boolean flag = true;
        int k1 = mLeftDragger.a();
        int l1 = mRightDragger.a();
        i1 = ((flag) ? 1 : 0);
        if (k1 != 1)
        {
            if (l1 == 1)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            if (k1 == 2 || l1 == 2)
            {
                i1 = 2;
            } else
            {
                i1 = 0;
            }
        }
        if (view == null || j1 != 0) goto _L2; else goto _L1
_L1:
        g1 = (g)view.getLayoutParams();
        if (g1.b != 0.0F) goto _L4; else goto _L3
_L3:
        b(view);
_L2:
        if (i1 != mDrawerState)
        {
            mDrawerState = i1;
            if (mListener != null)
            {
                mListener.a(i1);
            }
        }
        return;
_L4:
        if (g1.b == 1.0F)
        {
            c(view);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void a(Drawable drawable, int i1)
    {
        i1 = android.support.v4.view.e.a(i1, ai.h(this));
        if ((i1 & 3) == 3)
        {
            mShadowLeft = drawable;
            invalidate();
        }
        if ((i1 & 5) == 5)
        {
            mShadowRight = drawable;
            invalidate();
        }
    }

    void a(View view, float f1)
    {
        if (mListener != null)
        {
            mListener.a(view, f1);
        }
    }

    public void a(Object obj, boolean flag)
    {
        mLastInsets = obj;
        mDrawStatusBarBackground = flag;
        if (!flag && getBackground() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        requestLayout();
    }

    void a(boolean flag)
    {
        int k1 = getChildCount();
        int i1 = 0;
        boolean flag1 = false;
        while (i1 < k1) 
        {
            View view = getChildAt(i1);
            g g1 = (g)view.getLayoutParams();
            int j1 = ((flag1) ? 1 : 0);
            if (g(view))
            {
                if (flag && !g1.c)
                {
                    j1 = ((flag1) ? 1 : 0);
                } else
                {
                    j1 = view.getWidth();
                    if (a(view, 3))
                    {
                        flag1 |= mLeftDragger.a(view, -j1, view.getTop());
                    } else
                    {
                        flag1 |= mRightDragger.a(view, getWidth(), view.getTop());
                    }
                    g1.c = false;
                    j1 = ((flag1) ? 1 : 0);
                }
            }
            i1++;
            flag1 = j1;
        }
        mLeftCallback.a();
        mRightCallback.a();
        if (flag1)
        {
            invalidate();
        }
    }

    boolean a(View view, int i1)
    {
        return (e(view) & i1) == i1;
    }

    public void addView(View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.addView(view, i1, layoutparams);
        if (a() != null || g(view))
        {
            ai.c(view, 4);
        } else
        {
            ai.c(view, 1);
        }
        if (!CAN_HIDE_DESCENDANTS)
        {
            ai.a(view, mChildAccessibilityDelegate);
        }
    }

    View b(int i1)
    {
        int j1 = android.support.v4.view.e.a(i1, ai.h(this));
        int k1 = getChildCount();
        for (i1 = 0; i1 < k1; i1++)
        {
            View view = getChildAt(i1);
            if ((e(view) & 7) == (j1 & 7))
            {
                return view;
            }
        }

        return null;
    }

    public void b()
    {
        a(false);
    }

    public void b(int i1, int j1)
    {
        j1 = android.support.v4.view.e.a(j1, ai.h(this));
        if (j1 == 3)
        {
            mLockModeLeft = i1;
        } else
        if (j1 == 5)
        {
            mLockModeRight = i1;
        }
        if (i1 != 0)
        {
            x x1;
            if (j1 == 3)
            {
                x1 = mLeftDragger;
            } else
            {
                x1 = mRightDragger;
            }
            x1.e();
        }
        i1;
        JVM INSTR tableswitch 1 2: default 60
    //                   1 98
    //                   2 82;
           goto _L1 _L2 _L3
_L1:
        View view;
        return;
_L3:
        if ((view = b(j1)) != null)
        {
            h(view);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if ((view = b(j1)) != null)
        {
            i(view);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    void b(View view)
    {
        g g1 = (g)view.getLayoutParams();
        if (g1.d)
        {
            g1.d = false;
            if (mListener != null)
            {
                mListener.b(view);
            }
            a(view, false);
            if (hasWindowFocus())
            {
                view = getRootView();
                if (view != null)
                {
                    view.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void b(View view, float f1)
    {
        g g1 = (g)view.getLayoutParams();
        if (f1 == g1.b)
        {
            return;
        } else
        {
            g1.b = f1;
            a(view, f1);
            return;
        }
    }

    void c()
    {
        int i1 = 0;
        if (!mChildrenCanceledTouch)
        {
            long l1 = SystemClock.uptimeMillis();
            MotionEvent motionevent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
            for (int j1 = getChildCount(); i1 < j1; i1++)
            {
                getChildAt(i1).dispatchTouchEvent(motionevent);
            }

            motionevent.recycle();
            mChildrenCanceledTouch = true;
        }
    }

    void c(View view)
    {
        g g1 = (g)view.getLayoutParams();
        if (!g1.d)
        {
            g1.d = true;
            if (mListener != null)
            {
                mListener.a(view);
            }
            a(view, true);
            if (hasWindowFocus())
            {
                sendAccessibilityEvent(32);
            }
            view.requestFocus();
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof g) && super.checkLayoutParams(layoutparams);
    }

    public void computeScroll()
    {
        int j1 = getChildCount();
        float f1 = 0.0F;
        for (int i1 = 0; i1 < j1; i1++)
        {
            f1 = Math.max(f1, ((g)getChildAt(i1).getLayoutParams()).b);
        }

        mScrimOpacity = f1;
        if (mLeftDragger.a(true) | mRightDragger.a(true))
        {
            ai.d(this);
        }
    }

    float d(View view)
    {
        return ((g)view.getLayoutParams()).b;
    }

    public void d(int i1)
    {
        View view = b(i1);
        if (view == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No drawer view found with gravity ").append(c(i1)).toString());
        } else
        {
            h(view);
            return;
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long l1)
    {
        int i1;
        int j1;
        int k1;
        int i2;
        int i3;
        int j3;
        int k3;
        boolean flag1;
        i3 = getHeight();
        flag1 = f(view);
        k1 = 0;
        boolean flag = false;
        i1 = getWidth();
        j3 = canvas.save();
        j1 = i1;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        k3 = getChildCount();
        i2 = 0;
        k1 = ((flag) ? 1 : 0);
_L2:
        if (i2 >= k3)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        View view1 = getChildAt(i2);
        if (view1 == view || view1.getVisibility() != 0 || !m(view1) || !g(view1))
        {
            break; /* Loop/switch isn't completed */
        }
        int k2;
        if (view1.getHeight() < i3)
        {
            k2 = k1;
            j1 = i1;
        } else
        {
label0:
            {
                if (!a(view1, 3))
                {
                    break label0;
                }
                j1 = view1.getRight();
                float f1;
                int j2;
                int l2;
                boolean flag2;
                if (j1 <= k1)
                {
                    j1 = k1;
                }
                k2 = j1;
                j1 = i1;
            }
        }
_L3:
        i2++;
        i1 = j1;
        k1 = k2;
        if (true) goto _L2; else goto _L1
        l2 = view1.getLeft();
        j1 = l2;
        k2 = k1;
        if (l2 < i1) goto _L3; else goto _L1
_L1:
        j1 = i1;
        k2 = k1;
          goto _L3
        canvas.clipRect(k1, 0, i1, getHeight());
        j1 = i1;
        flag2 = super.drawChild(canvas, view, l1);
        canvas.restoreToCount(j3);
        if (mScrimOpacity > 0.0F && flag1)
        {
            i1 = (int)((float)((mScrimColor & 0xff000000) >>> 24) * mScrimOpacity);
            j2 = mScrimColor;
            mScrimPaint.setColor(i1 << 24 | j2 & 0xffffff);
            canvas.drawRect(k1, 0.0F, j1, getHeight(), mScrimPaint);
        } else
        {
            if (mShadowLeft != null && a(view, 3))
            {
                i1 = mShadowLeft.getIntrinsicWidth();
                j1 = view.getRight();
                k1 = mLeftDragger.b();
                f1 = Math.max(0.0F, Math.min((float)j1 / (float)k1, 1.0F));
                mShadowLeft.setBounds(j1, view.getTop(), i1 + j1, view.getBottom());
                mShadowLeft.setAlpha((int)(255F * f1));
                mShadowLeft.draw(canvas);
                return flag2;
            }
            if (mShadowRight != null && a(view, 5))
            {
                i1 = mShadowRight.getIntrinsicWidth();
                j1 = view.getLeft();
                k1 = getWidth();
                j2 = mRightDragger.b();
                f1 = Math.max(0.0F, Math.min((float)(k1 - j1) / (float)j2, 1.0F));
                mShadowRight.setBounds(j1 - i1, view.getTop(), j1, view.getBottom());
                mShadowRight.setAlpha((int)(255F * f1));
                mShadowRight.draw(canvas);
                return flag2;
            }
        }
        return flag2;
    }

    int e(View view)
    {
        return android.support.v4.view.e.a(((g)view.getLayoutParams()).a, ai.h(this));
    }

    public void e(int i1)
    {
        View view = b(i1);
        if (view == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No drawer view found with gravity ").append(c(i1)).toString());
        } else
        {
            i(view);
            return;
        }
    }

    public boolean f(int i1)
    {
        View view = b(i1);
        if (view != null)
        {
            return j(view);
        } else
        {
            return false;
        }
    }

    boolean f(View view)
    {
        return ((g)view.getLayoutParams()).a == 0;
    }

    public boolean g(int i1)
    {
        View view = b(i1);
        if (view != null)
        {
            return k(view);
        } else
        {
            return false;
        }
    }

    boolean g(View view)
    {
        return (android.support.v4.view.e.a(((g)view.getLayoutParams()).a, ai.h(view)) & 7) != 0;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new g(-1, -1);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new g(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof g)
        {
            return new g((g)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new g((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new g(layoutparams);
        }
    }

    public Drawable getStatusBarBackgroundDrawable()
    {
        return mStatusBarBackground;
    }

    public void h(View view)
    {
        if (!g(view))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("View ").append(view).append(" is not a sliding drawer").toString());
        }
        if (mFirstLayout)
        {
            g g1 = (g)view.getLayoutParams();
            g1.b = 1.0F;
            g1.d = true;
            a(view, true);
        } else
        if (a(view, 3))
        {
            mLeftDragger.a(view, 0, view.getTop());
        } else
        {
            mRightDragger.a(view, getWidth() - view.getWidth(), view.getTop());
        }
        invalidate();
    }

    public void i(View view)
    {
        if (!g(view))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("View ").append(view).append(" is not a sliding drawer").toString());
        }
        if (mFirstLayout)
        {
            view = (g)view.getLayoutParams();
            view.b = 0.0F;
            view.d = false;
        } else
        if (a(view, 3))
        {
            mLeftDragger.a(view, -view.getWidth(), view.getTop());
        } else
        {
            mRightDragger.a(view, getWidth(), view.getTop());
        }
        invalidate();
    }

    public boolean j(View view)
    {
        if (!g(view))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("View ").append(view).append(" is not a drawer").toString());
        } else
        {
            return ((g)view.getLayoutParams()).d;
        }
    }

    public boolean k(View view)
    {
        if (!g(view))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("View ").append(view).append(" is not a drawer").toString());
        }
        return ((g)view.getLayoutParams()).b > 0.0F;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mFirstLayout = true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mFirstLayout = true;
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mDrawStatusBarBackground && mStatusBarBackground != null)
        {
            int i1 = IMPL.a(mLastInsets);
            if (i1 > 0)
            {
                mStatusBarBackground.setBounds(0, 0, getWidth(), i1);
                mStatusBarBackground.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        flag1 = false;
        i1 = t.a(motionevent);
        flag2 = mLeftDragger.a(motionevent);
        flag3 = mRightDragger.a(motionevent);
        i1;
        JVM INSTR tableswitch 0 3: default 60
    //                   0 96
    //                   1 196
    //                   2 165
    //                   3 196;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        boolean flag = false;
_L8:
        if (flag2 | flag3 || flag || f() || mChildrenCanceledTouch)
        {
            flag1 = true;
        }
        return flag1;
_L2:
        float f1;
        float f2;
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        mInitialMotionX = f1;
        mInitialMotionY = f2;
        if (mScrimOpacity <= 0.0F) goto _L6; else goto _L5
_L5:
        motionevent = mLeftDragger.d((int)f1, (int)f2);
        if (motionevent == null || !f(motionevent)) goto _L6; else goto _L7
_L7:
        flag = true;
_L10:
        mDisallowInterceptRequested = false;
        mChildrenCanceledTouch = false;
          goto _L8
_L4:
        if (!mLeftDragger.d(3)) goto _L1; else goto _L9
_L9:
        mLeftCallback.a();
        mRightCallback.a();
        flag = false;
          goto _L8
_L3:
        a(true);
        mDisallowInterceptRequested = false;
        mChildrenCanceledTouch = false;
          goto _L1
_L6:
        flag = false;
          goto _L10
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && g())
        {
            android.support.v4.view.g.b(keyevent);
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            keyevent = h();
            if (keyevent != null && a(keyevent) == 0)
            {
                b();
            }
            return keyevent != null;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        int k2;
        int l2;
        mInLayout = true;
        k2 = k1 - i1;
        l2 = getChildCount();
        k1 = 0;
_L2:
        View view;
        if (k1 >= l2)
        {
            break MISSING_BLOCK_LABEL_450;
        }
        view = getChildAt(k1);
        if (view.getVisibility() != 8)
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        k1++;
        if (true) goto _L2; else goto _L1
_L1:
        g g1;
label0:
        {
            g1 = (g)view.getLayoutParams();
            if (!f(view))
            {
                break label0;
            }
            view.layout(g1.leftMargin, g1.topMargin, g1.leftMargin + view.getMeasuredWidth(), g1.topMargin + view.getMeasuredHeight());
        }
          goto _L3
        int i2;
        int i3;
        int j3;
        i3 = view.getMeasuredWidth();
        j3 = view.getMeasuredHeight();
        float f1;
        boolean flag1;
        if (a(view, 3))
        {
            i1 = -i3;
            i2 = (int)((float)i3 * g1.b) + i1;
            f1 = (float)(i3 + i2) / (float)i3;
        } else
        {
            i2 = k2 - (int)((float)i3 * g1.b);
            f1 = (float)(k2 - i2) / (float)i3;
        }
        if (f1 != g1.b)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        g1.a & 0x70;
        JVM INSTR lookupswitch 2: default 216
    //                   16: 360
    //                   80: 320;
           goto _L4 _L5 _L6
_L5:
        break MISSING_BLOCK_LABEL_360;
_L4:
        view.layout(i2, g1.topMargin, i3 + i2, j3 + g1.topMargin);
_L7:
        if (flag1)
        {
            b(view, f1);
        }
        int j2;
        int k3;
        if (g1.b > 0.0F)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        if (view.getVisibility() != i1)
        {
            view.setVisibility(i1);
        }
          goto _L3
_L6:
        i1 = l1 - j1;
        view.layout(i2, i1 - g1.bottomMargin - view.getMeasuredHeight(), i3 + i2, i1 - g1.bottomMargin);
          goto _L7
        k3 = l1 - j1;
        j2 = (k3 - j3) / 2;
        if (j2 < g1.topMargin)
        {
            i1 = g1.topMargin;
        } else
        {
            i1 = j2;
            if (j2 + j3 > k3 - g1.bottomMargin)
            {
                i1 = k3 - g1.bottomMargin - j3;
            }
        }
        view.layout(i2, i1, i3 + i2, j3 + i1);
          goto _L7
        mInLayout = false;
        mFirstLayout = false;
        return;
          goto _L3
    }

    protected void onMeasure(int i1, int j1)
    {
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        i2 = 300;
        l2 = android.view.View.MeasureSpec.getMode(i1);
        k2 = android.view.View.MeasureSpec.getMode(j1);
        l1 = android.view.View.MeasureSpec.getSize(i1);
        j2 = android.view.View.MeasureSpec.getSize(j1);
        if (l2 != 0x40000000) goto _L2; else goto _L1
_L1:
        int k1 = l1;
        if (k2 == 0x40000000) goto _L3; else goto _L2
_L2:
        if (!isInEditMode()) goto _L5; else goto _L4
_L4:
        if (l2 != 0x80000000) goto _L7; else goto _L6
_L6:
        k1 = l1;
_L11:
        if (k2 == 0x80000000)
        {
            l1 = j2;
            i2 = k1;
            break MISSING_BLOCK_LABEL_84;
        }
        l1 = i2;
        i2 = k1;
          goto _L8
_L7:
        k1 = l1;
        if (l2 == 0)
        {
            k1 = 300;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (k2 == 0) goto _L9; else goto _L3
_L3:
        l1 = j2;
        i2 = k1;
          goto _L9
_L5:
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
_L9:
        setMeasuredDimension(i2, l1);
        if (mLastInsets != null && ai.w(this))
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        k2 = ai.h(this);
        l2 = getChildCount();
        j2 = 0;
        while (j2 < l2) 
        {
            View view = getChildAt(j2);
            if (view.getVisibility() != 8)
            {
                g g1 = (g)view.getLayoutParams();
                if (k1 != 0)
                {
                    int i3 = android.support.v4.view.e.a(g1.a, k2);
                    if (ai.w(view))
                    {
                        IMPL.a(view, mLastInsets, i3);
                    } else
                    {
                        IMPL.a(g1, mLastInsets, i3);
                    }
                }
                if (f(view))
                {
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i2 - g1.leftMargin - g1.rightMargin, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(l1 - g1.topMargin - g1.bottomMargin, 0x40000000));
                } else
                if (g(view))
                {
                    int j3 = e(view) & 7;
                    if ((0 & j3) != 0)
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Child drawer has absolute gravity ").append(c(j3)).append(" but this ").append("DrawerLayout").append(" already has a ").append("drawer view along that edge").toString());
                    }
                    view.measure(getChildMeasureSpec(i1, mMinDrawerMargin + g1.leftMargin + g1.rightMargin, g1.width), getChildMeasureSpec(j1, g1.topMargin + g1.bottomMargin, g1.height));
                } else
                {
                    throw new IllegalStateException((new StringBuilder()).append("Child ").append(view).append(" at index ").append(j2).append(" does not have a valid layout_gravity - must be Gravity.LEFT, ").append("Gravity.RIGHT or Gravity.NO_GRAVITY").toString());
                }
            }
            j2++;
        }
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
    /* block-local class not found */
    class SavedState {}

        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        if (((SavedState) (parcelable)).a != 0)
        {
            View view = b(((SavedState) (parcelable)).a);
            if (view != null)
            {
                h(view);
            }
        }
        b(((SavedState) (parcelable)).b, 3);
        b(((SavedState) (parcelable)).c, 5);
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        View view = a();
        if (view != null)
        {
            savedstate.a = ((g)view.getLayoutParams()).a;
        }
        savedstate.b = mLockModeLeft;
        savedstate.c = mLockModeRight;
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        mLeftDragger.b(motionevent);
        mRightDragger.b(motionevent);
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 3: default 56
    //                   0 58
    //                   1 90
    //                   2 56
    //                   3 204;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        return true;
_L2:
        float f1 = motionevent.getX();
        float f3 = motionevent.getY();
        mInitialMotionX = f1;
        mInitialMotionY = f3;
        mDisallowInterceptRequested = false;
        mChildrenCanceledTouch = false;
        return true;
_L3:
        float f2;
        float f4;
        f4 = motionevent.getX();
        f2 = motionevent.getY();
        motionevent = mLeftDragger.d((int)f4, (int)f2);
        if (motionevent == null || !f(motionevent)) goto _L6; else goto _L5
_L5:
        int i1;
        f4 -= mInitialMotionX;
        f2 -= mInitialMotionY;
        i1 = mLeftDragger.d();
        if (f4 * f4 + f2 * f2 >= (float)(i1 * i1)) goto _L6; else goto _L7
_L7:
        motionevent = a();
        if (motionevent == null) goto _L6; else goto _L8
_L8:
        boolean flag;
        if (a(motionevent) == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L10:
        a(flag);
        mDisallowInterceptRequested = false;
        return true;
_L4:
        a(true);
        mDisallowInterceptRequested = false;
        mChildrenCanceledTouch = false;
        return true;
_L6:
        flag = true;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        super.requestDisallowInterceptTouchEvent(flag);
        mDisallowInterceptRequested = flag;
        if (flag)
        {
            a(true);
        }
    }

    public void requestLayout()
    {
        if (!mInLayout)
        {
            super.requestLayout();
        }
    }

    public void setDrawerListener(f f1)
    {
        mListener = f1;
    }

    public void setDrawerLockMode(int i1)
    {
        b(i1, 3);
        b(i1, 5);
    }

    public void setScrimColor(int i1)
    {
        mScrimColor = i1;
        invalidate();
    }

    public void setStatusBarBackground(int i1)
    {
        Drawable drawable;
        if (i1 != 0)
        {
            drawable = android.support.v4.a.a.a(getContext(), i1);
        } else
        {
            drawable = null;
        }
        mStatusBarBackground = drawable;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable)
    {
        mStatusBarBackground = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i1)
    {
        mStatusBarBackground = new ColorDrawable(i1);
        invalidate();
    }

    static 
    {
        boolean flag = true;
    /* block-local class not found */
    class d {}

        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            flag = false;
        }
        CAN_HIDE_DESCENDANTS = flag;
    /* block-local class not found */
    class e {}

        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            IMPL = new d();
        } else
        {
            IMPL = new e();
        }
    }

    // Unreferenced inner class android/support/v4/widget/DrawerLayout$EdgeGravity
    /* block-local class not found */
    class EdgeGravity {}


    // Unreferenced inner class android/support/v4/widget/DrawerLayout$LockMode
    /* block-local class not found */
    class LockMode {}


    // Unreferenced inner class android/support/v4/widget/DrawerLayout$State
    /* block-local class not found */
    class State {}

}

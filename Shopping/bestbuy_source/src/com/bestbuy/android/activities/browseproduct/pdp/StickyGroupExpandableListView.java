// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import bz;
import fd;
import np;

public class StickyGroupExpandableListView extends ExpandableListView
{

    private static final int a[];
    private static final int b[] = {
        0x10100a8
    };
    private static final int c[] = {
        0x10100a9
    };
    private static final int d[] = {
        0x10100a8, 0x10100a9
    };
    private static final int e[][];
    private Runnable A;
    private Runnable B;
    private final Rect C;
    private fd f;
    private DataSetObserver g;
    private android.widget.AbsListView.OnScrollListener h;
    private boolean i;
    private View j;
    private int k;
    private int l;
    private bz m;
    private android.widget.ExpandableListView.OnGroupClickListener n;
    private int o;
    private Object p;
    private boolean q;
    private boolean r;
    private Runnable s;
    private GestureDetector t;
    private boolean u;
    private boolean v;
    private boolean w;
    private Drawable x;
    private int y;
    private final Rect z;

    public StickyGroupExpandableListView(Context context)
    {
        super(context);
        i = true;
        z = new Rect();
        C = new Rect();
        a();
    }

    public StickyGroupExpandableListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        i = true;
        z = new Rect();
        C = new Rect();
        a();
    }

    public StickyGroupExpandableListView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        i = true;
        z = new Rect();
        C = new Rect();
        a();
    }

    static View a(StickyGroupExpandableListView stickygroupexpandablelistview, View view)
    {
        stickygroupexpandablelistview.j = view;
        return view;
    }

    static android.widget.AbsListView.OnScrollListener a(StickyGroupExpandableListView stickygroupexpandablelistview)
    {
        return stickygroupexpandablelistview.h;
    }

    private void a()
    {
        super.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            final StickyGroupExpandableListView a;

            public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
            {
                if (StickyGroupExpandableListView.a(a) != null)
                {
                    StickyGroupExpandableListView.a(a).onScroll(abslistview, i1, j1, k1);
                }
                if (StickyGroupExpandableListView.b(a) && StickyGroupExpandableListView.c(a) != null && StickyGroupExpandableListView.c(a).getGroupCount() > 0 && j1 > 0)
                {
                    StickyGroupExpandableListView.a(a, i1);
                }
            }

            public void onScrollStateChanged(AbsListView abslistview, int i1)
            {
                if (StickyGroupExpandableListView.a(a) != null)
                {
                    StickyGroupExpandableListView.a(a).onScrollStateChanged(abslistview, i1);
                }
            }

            
            {
                a = StickyGroupExpandableListView.this;
                super();
            }
        });
        s = new Runnable() {

            final StickyGroupExpandableListView a;

            public void run()
            {
                boolean flag;
                if (StickyGroupExpandableListView.d(a) != null)
                {
                    if (!StickyGroupExpandableListView.d(a).onGroupClick(a, StickyGroupExpandableListView.e(a), StickyGroupExpandableListView.f(a), StickyGroupExpandableListView.c(a).getGroupId(StickyGroupExpandableListView.f(a))))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                } else
                {
                    flag = true;
                }
                if (flag)
                {
                    if (StickyGroupExpandableListView.c(a).a(StickyGroupExpandableListView.f(a)))
                    {
                        a.collapseGroup(StickyGroupExpandableListView.f(a));
                    } else
                    {
                        a.expandGroup(StickyGroupExpandableListView.f(a));
                    }
                    a.setSelectedGroup(StickyGroupExpandableListView.f(a));
                }
            }

            
            {
                a = StickyGroupExpandableListView.this;
                super();
            }
        };
        A = new Runnable() {

            final StickyGroupExpandableListView a;

            public void run()
            {
                StickyGroupExpandableListView.g(a);
                a.setPressed(true);
                if (StickyGroupExpandableListView.e(a) != null)
                {
                    StickyGroupExpandableListView.e(a).setPressed(true);
                }
            }

            
            {
                a = StickyGroupExpandableListView.this;
                super();
            }
        };
        B = new Runnable() {

            final StickyGroupExpandableListView a;

            public void run()
            {
                a.setPressed(false);
                if (StickyGroupExpandableListView.e(a) != null)
                {
                    StickyGroupExpandableListView.e(a).setPressed(false);
                }
                a.invalidate();
            }

            
            {
                a = StickyGroupExpandableListView.this;
                super();
            }
        };
        t = new GestureDetector(getContext(), new android.view.GestureDetector.SimpleOnGestureListener() {

            final StickyGroupExpandableListView a;

            public void onLongPress(MotionEvent motionevent)
            {
                if (StickyGroupExpandableListView.e(a) != null && !StickyGroupExpandableListView.e(a).isLongClickable())
                {
                    motionevent = new android.widget.ExpandableListView.ExpandableListContextMenuInfo(StickyGroupExpandableListView.e(a), ExpandableListView.getPackedPositionForGroup(StickyGroupExpandableListView.f(a)), StickyGroupExpandableListView.c(a).getGroupId(StickyGroupExpandableListView.f(a)));
                    np.a(android/widget/AbsListView, "mContextMenuInfo", a, motionevent);
                    a.showContextMenu();
                }
            }

            
            {
                a = StickyGroupExpandableListView.this;
                super();
            }
        });
    }

    private void a(int i1)
    {
        int j2;
        j2 = 0;
        j = null;
        k = getPackedPositionGroup(getExpandableListPosition(i1));
        for (int j1 = 0; j1 < getChildCount(); j1++)
        {
            View view = getChildAt(j1);
            Object obj1 = view.getTag(0x7f0c0008);
            if ((obj1 instanceof Boolean) && ((Boolean)obj1).booleanValue())
            {
                view.setVisibility(0);
                view.setTag(0x7f0c0008, null);
            }
        }

        if (i) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k1 = getFlatListPosition(getPackedPositionForGroup(k)) - i1;
        if (k1 < 0 || k1 >= getChildCount())
        {
            break; /* Loop/switch isn't completed */
        }
        View view1 = getChildAt(k1);
        if (view1.getTop() >= getPaddingTop())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (view1.getTop() < getPaddingTop() && view1.getVisibility() == 0)
        {
            view1.setVisibility(4);
            view1.setTag(0x7f0c0008, Boolean.valueOf(true));
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        if (k >= 0)
        {
            j = f.getGroupView(k, f.a(k), j, this);
            Object obj;
            android.widget.AbsListView.LayoutParams layoutparams;
            int l1;
            int k2;
            int l2;
            if (!j.isClickable())
            {
                u = true;
                j.setOnClickListener(new android.view.View.OnClickListener() {

                    final StickyGroupExpandableListView a;

                    public void onClick(View view2)
                    {
                        a.postDelayed(StickyGroupExpandableListView.h(a), ViewConfiguration.getPressedStateDuration());
                    }

            
            {
                a = StickyGroupExpandableListView.this;
                super();
            }
                });
            } else
            {
                u = false;
            }
            b();
            a(j);
        }
        if (j != null)
        {
            layoutparams = (android.widget.AbsListView.LayoutParams)j.getLayoutParams();
            obj = layoutparams;
            if (layoutparams == null)
            {
                obj = new android.widget.AbsListView.LayoutParams(-1, -2, 0);
                j.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            }
            k2 = ViewGroup.getChildMeasureSpec(o, getPaddingLeft() + getPaddingRight(), ((android.widget.AbsListView.LayoutParams) (obj)).width);
            l1 = ((android.widget.AbsListView.LayoutParams) (obj)).height;
            int i2;
            if (l1 > 0)
            {
                i2 = android.view.View.MeasureSpec.makeMeasureSpec(l1, 0x40000000);
            } else
            {
                i2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            j.measure(k2, i2);
            i2 = getFlatListPosition(getPackedPositionForGroup(k + 1)) - i1;
            i1 = j2;
            if (i2 >= 0)
            {
                i1 = j2;
                if (i2 < getChildCount())
                {
                    obj = getChildAt(i2);
                    i1 = j2;
                    if (obj != null)
                    {
                        i1 = j2;
                        if (((View) (obj)).getTop() < getPaddingTop() + j.getMeasuredHeight() + getDividerHeight())
                        {
                            i1 = ((View) (obj)).getTop() - (getPaddingTop() + j.getMeasuredHeight() + getDividerHeight());
                        }
                    }
                }
            }
            i2 = getPaddingLeft();
            j2 = getPaddingTop() + i1;
            k2 = j.getMeasuredWidth();
            l2 = j.getMeasuredHeight();
            j.layout(i2, j2, k2 + i2, l2 + j2);
            l = i1;
            if (m != null)
            {
                m.a(j, l);
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void a(Canvas canvas)
    {
        int i1 = y - getFirstVisiblePosition();
        if (i1 >= 0 && i1 < getChildCount() && z != null && !z.isEmpty())
        {
            int j1 = getFlatListPosition(getPackedPositionForGroup(k));
            if (j == null || y != j1)
            {
                c(canvas);
            }
        }
    }

    private void a(View view)
    {
        if (view != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (p != null)
        {
            np.a(android/view/View, "mAttachInfo", view, p);
        }
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int i1 = 0;
            while (i1 < view.getChildCount()) 
            {
                a(view.getChildAt(i1));
                i1++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    static void a(StickyGroupExpandableListView stickygroupexpandablelistview, int i1)
    {
        stickygroupexpandablelistview.a(i1);
    }

    private void b()
    {
        if (p == null)
        {
            p = np.a(android/view/View, "mAttachInfo", this);
        }
    }

    private void b(Canvas canvas)
    {
        if (z != null && !z.isEmpty())
        {
            int i1 = getFlatListPosition(getPackedPositionForGroup(k));
            if (y == i1)
            {
                z.set(j.getLeft(), j.getTop(), j.getRight(), j.getBottom());
                c(canvas);
            }
        }
    }

    static boolean b(StickyGroupExpandableListView stickygroupexpandablelistview)
    {
        return stickygroupexpandablelistview.i;
    }

    static fd c(StickyGroupExpandableListView stickygroupexpandablelistview)
    {
        return stickygroupexpandablelistview.f;
    }

    private void c()
    {
        if (v && j != null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                int i1 = getFlatListPosition(getPackedPositionForGroup(k));
                Class class1 = Integer.TYPE;
                View view1 = j;
                np.a(android/widget/AbsListView, "positionSelector", new Class[] {
                    class1, android/view/View
                }, this, new Object[] {
                    Integer.valueOf(i1), view1
                });
            } else
            {
                View view = j;
                np.a(android/widget/AbsListView, "positionSelector", new Class[] {
                    android/view/View
                }, this, new Object[] {
                    view
                });
            }
            invalidate();
        }
        v = false;
        removeCallbacks(A);
    }

    private void c(Canvas canvas)
    {
        canvas.save();
        canvas.clipRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (isPressed())
        {
            x.setState(getDrawableState());
        } else
        {
            x.setState(a);
        }
        x.setBounds(z);
        x.draw(canvas);
        canvas.restore();
    }

    static android.widget.ExpandableListView.OnGroupClickListener d(StickyGroupExpandableListView stickygroupexpandablelistview)
    {
        return stickygroupexpandablelistview.n;
    }

    private void d(Canvas canvas)
    {
        int j1 = 0;
        Drawable drawable = (Drawable)np.a(android/widget/ExpandableListView, "mGroupIndicator", this);
        if (drawable != null)
        {
            int i1;
            if (f.a(k))
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (f.getChildrenCount(k) > 0)
            {
                j1 = 2;
            }
            drawable.setState(e[i1 | j1]);
            i1 = ((Integer)np.a(android/widget/ExpandableListView, "mIndicatorLeft", this)).intValue();
            j1 = ((Integer)np.a(android/widget/ExpandableListView, "mIndicatorRight", this)).intValue();
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                C.set(i1 + getPaddingLeft(), j.getTop(), j1 + getPaddingLeft(), j.getBottom());
            } else
            {
                C.set(i1, j.getTop(), j1, j.getBottom());
            }
            drawable.setBounds(C);
            drawable.draw(canvas);
        }
    }

    static View e(StickyGroupExpandableListView stickygroupexpandablelistview)
    {
        return stickygroupexpandablelistview.j;
    }

    static int f(StickyGroupExpandableListView stickygroupexpandablelistview)
    {
        return stickygroupexpandablelistview.k;
    }

    static void g(StickyGroupExpandableListView stickygroupexpandablelistview)
    {
        stickygroupexpandablelistview.c();
    }

    static Runnable h(StickyGroupExpandableListView stickygroupexpandablelistview)
    {
        return stickygroupexpandablelistview.s;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            y = ((Integer)np.a(android/widget/AbsListView, "mSelectorPosition", this)).intValue();
        } else
        {
            y = ((Integer)np.a(android/widget/AbsListView, "mMotionPosition", this)).intValue();
        }
        z.set((Rect)np.a(android/widget/AbsListView, "mSelectorRect", this));
        if (!w)
        {
            a(canvas);
        }
        super.dispatchDraw(canvas);
        if (i && j != null)
        {
            if (!w)
            {
                b(canvas);
            }
            canvas.save();
            canvas.clipRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            if (j.getVisibility() == 0)
            {
                drawChild(canvas, j, getDrawingTime());
            }
            d(canvas);
            canvas.restore();
            if (w)
            {
                a(canvas);
                b(canvas);
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        int i1;
        i1 = motionevent.getAction() & 0xff;
        if (i1 == 0 || i1 == 3)
        {
            q = false;
            r = false;
            v = false;
        }
        if (q || r || j == null) goto _L2; else goto _L1
_L1:
        int ai[];
        ai = new int[2];
        getLocationInWindow(ai);
        if (!(new RectF(ai[0] + j.getLeft(), ai[1] + j.getTop(), ai[0] + j.getRight(), ai[1] + j.getBottom())).contains(motionevent.getRawX(), motionevent.getRawY())) goto _L2; else goto _L3
_L3:
        if (!u) goto _L5; else goto _L4
_L4:
        i1;
        JVM INSTR tableswitch 0 1: default 164
    //                   0 192
    //                   1 222;
           goto _L5 _L6 _L7
_L5:
        if (j.dispatchTouchEvent(motionevent))
        {
            t.onTouchEvent(motionevent);
            onInterceptTouchEvent(motionevent);
            return true;
        }
        break; /* Loop/switch isn't completed */
_L6:
        v = true;
        removeCallbacks(A);
        postDelayed(A, ViewConfiguration.getTapTimeout());
        continue; /* Loop/switch isn't completed */
_L7:
        c();
        setPressed(true);
        if (j != null)
        {
            j.setPressed(true);
        }
        removeCallbacks(B);
        postDelayed(B, ViewConfiguration.getPressedStateDuration());
        if (true) goto _L5; else goto _L2
_L2:
        return super.dispatchTouchEvent(motionevent);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (f != null && g != null)
        {
            f.unregisterDataSetObserver(g);
            g = null;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        q = super.onInterceptTouchEvent(motionevent);
        return q;
    }

    protected void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        o = i1;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        r = super.onTouchEvent(motionevent);
        return r;
    }

    public void setAdapter(ExpandableListAdapter expandablelistadapter)
    {
        if (!(expandablelistadapter instanceof fd))
        {
            throw new IllegalArgumentException("The adapter must be an instance of WrapperExpandableListAdapter");
        } else
        {
            setAdapter((fd)expandablelistadapter);
            return;
        }
    }

    public void setAdapter(fd fd1)
    {
        super.setAdapter(fd1);
        if (f != null && g != null)
        {
            f.unregisterDataSetObserver(g);
            g = null;
        }
        f = fd1;
        if (f != null && g == null)
        {
            g = new DataSetObserver() {

                final StickyGroupExpandableListView a;

                public void onChanged()
                {
                    StickyGroupExpandableListView.a(a, null);
                }

                public void onInvalidated()
                {
                    StickyGroupExpandableListView.a(a, null);
                }

            
            {
                a = StickyGroupExpandableListView.this;
                super();
            }
            };
            f.registerDataSetObserver(g);
        }
    }

    public void setDrawSelectorOnTop(boolean flag)
    {
        super.setDrawSelectorOnTop(flag);
        w = flag;
    }

    public void setOnGroupClickListener(android.widget.ExpandableListView.OnGroupClickListener ongroupclicklistener)
    {
        super.setOnGroupClickListener(ongroupclicklistener);
        n = ongroupclicklistener;
    }

    public void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        h = onscrolllistener;
    }

    public void setOnScrollStickyGroupListener(bz bz1)
    {
        m = bz1;
    }

    public void setSelector(Drawable drawable)
    {
        super.setSelector(new ColorDrawable(0));
        if (x != null)
        {
            x.setCallback(null);
            unscheduleDrawable(x);
        }
        x = drawable;
        x.setCallback(this);
    }

    public void setStickyGroupEnabled(boolean flag)
    {
        i = flag;
    }

    static 
    {
        a = new int[0];
        e = (new int[][] {
            a, b, c, d
        });
    }
}

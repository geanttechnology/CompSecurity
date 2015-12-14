// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.ListView;

// Referenced classes of package com.mobeta.android.dslv:
//            j, DragSortListView

public class a extends j
    implements android.view.GestureDetector.OnGestureListener, android.view.View.OnTouchListener
{

    private DragSortListView A;
    private int B;
    private android.view.GestureDetector.OnGestureListener C;
    public int a;
    public boolean b;
    public boolean c;
    public int d;
    private int i;
    private boolean j;
    private GestureDetector k;
    private GestureDetector l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q[];
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private float w;
    private int x;
    private int y;
    private boolean z;

    public a(DragSortListView dragsortlistview)
    {
        this(dragsortlistview, (byte)0);
    }

    private a(DragSortListView dragsortlistview, byte byte0)
    {
        this(dragsortlistview, 0, 0, 1);
    }

    private a(DragSortListView dragsortlistview, int i1, int j1, int k1)
    {
        this(dragsortlistview, 0, 0, 1, 0, 0);
    }

    public a(DragSortListView dragsortlistview, int i1, int j1, int k1, int l1, int i2)
    {
        super(dragsortlistview);
        a = 0;
        b = true;
        c = false;
        j = false;
        n = -1;
        o = -1;
        p = -1;
        q = new int[2];
        v = false;
        w = 500F;
        C = new _cls1();
        A = dragsortlistview;
        k = new GestureDetector(dragsortlistview.getContext(), this);
        l = new GestureDetector(dragsortlistview.getContext(), C);
        l.setIsLongpressEnabled(false);
        m = ViewConfiguration.get(dragsortlistview.getContext()).getScaledTouchSlop();
        d = i1;
        x = l1;
        y = i2;
        i = k1;
        a = j1;
    }

    private int a(MotionEvent motionevent, int i1)
    {
        int j1 = (int)motionevent.getX();
        int k1 = (int)motionevent.getY();
        j1 = A.pointToPosition(j1, k1);
        k1 = A.getHeaderViewsCount();
        int i2 = A.getFooterViewsCount();
        int k2 = A.getCount();
        if (j1 != -1 && j1 >= k1 && j1 < k2 - i2)
        {
            View view = A.getChildAt(j1 - A.getFirstVisiblePosition());
            int j2 = (int)motionevent.getRawX();
            int l1 = (int)motionevent.getRawY();
            if (i1 == 0)
            {
                motionevent = view;
            } else
            {
                motionevent = view.findViewById(i1);
            }
            if (motionevent != null)
            {
                motionevent.getLocationOnScreen(q);
                if (j2 > q[0] && l1 > q[1] && j2 < q[0] + motionevent.getWidth())
                {
                    i1 = q[1];
                    if (l1 < motionevent.getHeight() + i1)
                    {
                        r = view.getLeft();
                        s = view.getTop();
                        return j1;
                    }
                }
            }
        }
        return -1;
    }

    private boolean a(int i1, int j1, int k1)
    {
        boolean flag1 = false;
        Object obj;
        DragSortListView dragsortlistview;
        View view;
        int l1;
        boolean flag;
        if (b && !j)
        {
            l1 = 12;
        } else
        {
            l1 = 0;
        }
        if (c && j)
        {
            l1 = l1 | 1 | 2;
        }
        dragsortlistview = A;
        i1 -= A.getHeaderViewsCount();
        flag = flag1;
        if (!dragsortlistview.b) goto _L2; else goto _L1
_L1:
        if (dragsortlistview.c != null) goto _L4; else goto _L3
_L3:
        flag = flag1;
_L2:
        v = flag;
        return v;
_L4:
        obj = dragsortlistview.c;
        view = ((j) (obj)).h.getChildAt((((j) (obj)).h.getHeaderViewsCount() + i1) - ((j) (obj)).h.getFirstVisiblePosition());
        if (view == null)
        {
            obj = null;
        } else
        {
            view.setPressed(false);
            view.setDrawingCacheEnabled(true);
            obj.e = Bitmap.createBitmap(view.getDrawingCache());
            view.setDrawingCacheEnabled(false);
            if (((j) (obj)).f == null)
            {
                obj.f = new ImageView(((j) (obj)).h.getContext());
            }
            ((j) (obj)).f.setBackgroundColor(((j) (obj)).g);
            ((j) (obj)).f.setPadding(0, 0, 0, 0);
            ((j) (obj)).f.setImageBitmap(((j) (obj)).e);
            ((j) (obj)).f.setLayoutParams(new android.view.ViewGroup.LayoutParams(view.getWidth(), view.getHeight()));
            obj = ((j) (obj)).f;
        }
        flag = flag1;
        if (obj != null)
        {
            flag = dragsortlistview.a(i1, ((View) (obj)), l1, j1, k1);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    static boolean a(a a1)
    {
        return a1.c;
    }

    static boolean b(a a1)
    {
        return a1.j;
    }

    static DragSortListView c(a a1)
    {
        return a1.A;
    }

    static float d(a a1)
    {
        return a1.w;
    }

    static int e(a a1)
    {
        return a1.B;
    }

    static boolean f(a a1)
    {
        a1.j = false;
        return false;
    }

    public int a(MotionEvent motionevent)
    {
        return b(motionevent);
    }

    public final void a(Point point)
    {
        if (c && j)
        {
            B = point.x;
        }
    }

    public final int b(MotionEvent motionevent)
    {
        return a(motionevent, d);
    }

    public boolean onDown(MotionEvent motionevent)
    {
        int i1 = -1;
        if (c && i == 0)
        {
            p = a(motionevent, x);
        }
        n = a(motionevent);
        if (n != -1 && a == 0)
        {
            a(n, (int)motionevent.getX() - r, (int)motionevent.getY() - s);
        }
        j = false;
        z = true;
        B = 0;
        if (i == 1)
        {
            i1 = a(motionevent, y);
        }
        o = i1;
        return true;
    }

    public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
    {
        return false;
    }

    public void onLongPress(MotionEvent motionevent)
    {
        if (n != -1 && a == 2)
        {
            A.performHapticFeedback(0);
            a(n, t - r, u - s);
        }
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
    {
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        i1 = (int)motionevent.getX();
        j1 = (int)motionevent.getY();
        k1 = (int)motionevent1.getX();
        l1 = (int)motionevent1.getY();
        i2 = k1 - r;
        j2 = l1 - s;
        if (!z || v || n == -1 && o == -1) goto _L2; else goto _L1
_L1:
        if (n == -1) goto _L4; else goto _L3
_L3:
        if (a != 1 || Math.abs(l1 - j1) <= m || !b) goto _L6; else goto _L5
_L5:
        a(n, i2, j2);
_L2:
        return false;
_L6:
        if (a != 0 && Math.abs(k1 - i1) > m && c)
        {
            j = true;
            a(o, i2, j2);
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (o != -1)
        {
            if (Math.abs(k1 - i1) > m && c)
            {
                j = true;
                a(o, i2, j2);
                return false;
            }
            if (Math.abs(l1 - j1) > m)
            {
                z = false;
                return false;
            }
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        if (c && i == 0 && p != -1)
        {
            motionevent = A;
            int i1 = p;
            int j1 = A.getHeaderViewsCount();
            motionevent.d = false;
            motionevent.a(i1 - j1, 0.0F);
        }
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (!A.a || A.e)
        {
            return false;
        }
        k.onTouchEvent(motionevent);
        if (c && v && i == 1)
        {
            l.onTouchEvent(motionevent);
        }
        switch (motionevent.getAction() & 0xff)
        {
        case 2: // '\002'
        default:
            return false;

        case 3: // '\003'
            break;

        case 0: // '\0'
            t = (int)motionevent.getX();
            u = (int)motionevent.getY();
            return false;

        case 1: // '\001'
            if (c && j)
            {
                int i1;
                if (B >= 0)
                {
                    i1 = B;
                } else
                {
                    i1 = -B;
                }
                if (i1 > A.getWidth() / 2)
                {
                    A.a(0.0F);
                }
            }
            break;
        }
        j = false;
        v = false;
        return false;
    }

    /* member class not found */
    class _cls1 {}

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class k extends ListView
{
    private static class a extends android.support.v7.c.a.a
    {

        private boolean a;

        void a(boolean flag)
        {
            a = flag;
        }

        public void draw(Canvas canvas)
        {
            if (a)
            {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f1, float f2)
        {
            if (a)
            {
                super.setHotspot(f1, f2);
            }
        }

        public void setHotspotBounds(int i, int j, int l, int i1)
        {
            if (a)
            {
                super.setHotspotBounds(i, j, l, i1);
            }
        }

        public boolean setState(int ai[])
        {
            if (a)
            {
                return super.setState(ai);
            } else
            {
                return false;
            }
        }

        public boolean setVisible(boolean flag, boolean flag1)
        {
            if (a)
            {
                return super.setVisible(flag, flag1);
            } else
            {
                return false;
            }
        }

        public a(Drawable drawable)
        {
            super(drawable);
            a = true;
        }
    }


    private static final int f[] = {
        0
    };
    final Rect a = new Rect();
    int b;
    int c;
    int d;
    int e;
    private Field g;
    private a h;

    public k(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        try
        {
            g = android/widget/AbsListView.getDeclaredField("mIsChildViewEnabled");
            g.setAccessible(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public int a(int i, int j, int l, int i1, int j1)
    {
        Object obj;
        ListAdapter listadapter;
        int k1;
        j = getListPaddingTop();
        k1 = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        l = getDividerHeight();
        obj = getDivider();
        listadapter = getAdapter();
        if (listadapter != null) goto _L2; else goto _L1
_L1:
        i = j + k1;
_L4:
        return i;
_L2:
        j = k1 + j;
        int i2;
        int j2;
        int l2;
        if (l <= 0 || obj == null)
        {
            l = 0;
        }
        i2 = 0;
        obj = null;
        j2 = 0;
        l2 = listadapter.getCount();
        for (int l1 = 0; l1 < l2;)
        {
            int k2 = listadapter.getItemViewType(l1);
            if (k2 != j2)
            {
                obj = null;
                j2 = k2;
            }
            obj = listadapter.getView(l1, ((View) (obj)), this);
            android.view.ViewGroup.LayoutParams layoutparams = ((View) (obj)).getLayoutParams();
            if (layoutparams != null && layoutparams.height > 0)
            {
                k2 = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.height, 0x40000000);
            } else
            {
                k2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            ((View) (obj)).measure(i, k2);
            if (l1 > 0)
            {
                j += l;
            }
            j += ((View) (obj)).getMeasuredHeight();
            if (j >= i1)
            {
                i = i1;
                if (j1 >= 0)
                {
                    i = i1;
                    if (l1 > j1)
                    {
                        i = i1;
                        if (i2 > 0)
                        {
                            i = i1;
                            if (j != i1)
                            {
                                return i2;
                            }
                        }
                    }
                }
                continue; /* Loop/switch isn't completed */
            }
            k2 = i2;
            if (j1 >= 0)
            {
                k2 = i2;
                if (l1 >= j1)
                {
                    k2 = j;
                }
            }
            l1++;
            i2 = k2;
        }

        return j;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void a()
    {
        Drawable drawable = getSelector();
        if (drawable != null && b())
        {
            drawable.setState(getDrawableState());
        }
    }

    protected void a(int i, View view)
    {
        boolean flag1 = true;
        Drawable drawable = getSelector();
        boolean flag;
        if (drawable != null && i != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            drawable.setVisible(false, false);
        }
        b(i, view);
        if (flag)
        {
            view = a;
            float f1 = view.exactCenterX();
            float f2 = view.exactCenterY();
            if (getVisibility() != 0)
            {
                flag1 = false;
            }
            drawable.setVisible(flag1, false);
            android.support.v4.b.a.a.a(drawable, f1, f2);
        }
    }

    protected void a(int i, View view, float f1, float f2)
    {
        a(i, view);
        view = getSelector();
        if (view != null && i != -1)
        {
            android.support.v4.b.a.a.a(view, f1, f2);
        }
    }

    protected void a(Canvas canvas)
    {
        if (!a.isEmpty())
        {
            Drawable drawable = getSelector();
            if (drawable != null)
            {
                drawable.setBounds(a);
                drawable.draw(canvas);
            }
        }
    }

    protected void b(int i, View view)
    {
        Rect rect = a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left = rect.left - b;
        rect.top = rect.top - c;
        rect.right = rect.right + d;
        rect.bottom = rect.bottom + e;
        boolean flag;
        flag = g.getBoolean(this);
        if (view.isEnabled() == flag)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        view = g;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            view.set(this, Boolean.valueOf(flag));
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return;
        }
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        refreshDrawableState();
    }

    protected boolean b()
    {
        return c() && isPressed();
    }

    protected boolean c()
    {
        return false;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        a(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        a();
    }

    public void setSelector(Drawable drawable)
    {
        Object obj;
        if (drawable != null)
        {
            obj = new a(drawable);
        } else
        {
            obj = null;
        }
        h = ((a) (obj));
        super.setSelector(h);
        obj = new Rect();
        if (drawable != null)
        {
            drawable.getPadding(((Rect) (obj)));
        }
        b = ((Rect) (obj)).left;
        c = ((Rect) (obj)).top;
        d = ((Rect) (obj)).right;
        e = ((Rect) (obj)).bottom;
    }

    protected void setSelectorEnabled(boolean flag)
    {
        if (h != null)
        {
            h.a(flag);
        }
    }

}

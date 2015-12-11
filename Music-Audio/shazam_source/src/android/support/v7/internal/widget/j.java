// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class j extends ListView
{
    private static final class a extends android.support.v7.c.a.a
    {

        boolean a;

        public final void draw(Canvas canvas)
        {
            if (a)
            {
                super.draw(canvas);
            }
        }

        public final void setHotspot(float f1, float f2)
        {
            if (a)
            {
                super.setHotspot(f1, f2);
            }
        }

        public final void setHotspotBounds(int i, int k, int l, int i1)
        {
            if (a)
            {
                super.setHotspotBounds(i, k, l, i1);
            }
        }

        public final boolean setState(int ai[])
        {
            if (a)
            {
                return super.setState(ai);
            } else
            {
                return false;
            }
        }

        public final boolean setVisible(boolean flag, boolean flag1)
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


    private static final int g[] = {
        0
    };
    public final Rect a = new Rect();
    public int b;
    public int c;
    public int d;
    public int e;
    public Field f;
    private a h;

    public j(Context context, int i)
    {
        super(context, null, i);
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        try
        {
            f = android/widget/AbsListView.getDeclaredField("mIsChildViewEnabled");
            f.setAccessible(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public final int a(int i, int k)
    {
        Object obj;
        ListAdapter listadapter;
        int l;
        int i1;
        int j1;
        l = getListPaddingTop();
        j1 = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        i1 = getDividerHeight();
        obj = getDivider();
        listadapter = getAdapter();
        if (listadapter != null) goto _L2; else goto _L1
_L1:
        l += j1;
_L4:
        return l;
_L2:
        l = j1 + l;
        int k1;
        int i2;
        if (i1 <= 0 || obj == null)
        {
            i1 = 0;
        }
        i2 = listadapter.getCount();
        j1 = 0;
        k1 = 0;
        obj = null;
        do
        {
label0:
            {
                if (j1 >= i2)
                {
                    break label0;
                }
                int l1 = listadapter.getItemViewType(j1);
                if (l1 != k1)
                {
                    k1 = l1;
                    obj = null;
                }
                obj = listadapter.getView(j1, ((View) (obj)), this);
                android.view.ViewGroup.LayoutParams layoutparams = ((View) (obj)).getLayoutParams();
                if (layoutparams != null && layoutparams.height > 0)
                {
                    l1 = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.height, 0x40000000);
                } else
                {
                    l1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                }
                ((View) (obj)).measure(i, l1);
                if (j1 > 0)
                {
                    l += i1;
                }
                l1 = ((View) (obj)).getMeasuredHeight() + l;
                l = k;
                if (l1 >= k)
                {
                    continue; /* Loop/switch isn't completed */
                }
                j1++;
                l = l1;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return l;
    }

    public boolean a()
    {
        return false;
    }

    protected void dispatchDraw(Canvas canvas)
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
        super.dispatchDraw(canvas);
    }

    public void drawableStateChanged()
    {
        boolean flag = true;
        super.drawableStateChanged();
        setSelectorEnabled(true);
        Drawable drawable = getSelector();
        if (drawable != null)
        {
            if (!a() || !isPressed())
            {
                flag = false;
            }
            if (flag)
            {
                drawable.setState(getDrawableState());
            }
        }
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

    public void setSelectorEnabled(boolean flag)
    {
        if (h != null)
        {
            h.a = flag;
        }
    }

}

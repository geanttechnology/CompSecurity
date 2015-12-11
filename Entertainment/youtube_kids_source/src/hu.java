// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import java.lang.reflect.Field;

public class hu extends ListView
{

    public hv a;
    private Rect b;
    private int c;
    private int d;
    private int e;
    private int f;
    private Field g;

    public hu(Context context, AttributeSet attributeset, int i)
    {
        super(context, null, i);
        b = new Rect();
        c = 0;
        d = 0;
        e = 0;
        f = 0;
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

    private void a(int i, View view)
    {
        Rect rect = b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left = rect.left - c;
        rect.top = rect.top - d;
        rect.right = rect.right + e;
        rect.bottom = rect.bottom + f;
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

    public final void a(int i, View view, float f1, float f2)
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
        a(i, view);
        if (flag)
        {
            view = b;
            float f3 = view.exactCenterX();
            float f4 = view.exactCenterY();
            if (getVisibility() != 0)
            {
                flag1 = false;
            }
            drawable.setVisible(flag1, false);
            ca.a(drawable, f3, f4);
        }
        view = getSelector();
        if (view != null && i != -1)
        {
            ca.a(view, f1, f2);
        }
    }

    public boolean a()
    {
        return false;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        if (!b.isEmpty())
        {
            Drawable drawable = getSelector();
            drawable.setBounds(b);
            drawable.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public void drawableStateChanged()
    {
        boolean flag = true;
        super.drawableStateChanged();
        a.a = true;
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
        a = new hv(drawable);
        super.setSelector(a);
        Rect rect = new Rect();
        drawable.getPadding(rect);
        c = rect.left;
        d = rect.top;
        e = rect.right;
        f = rect.bottom;
    }

}

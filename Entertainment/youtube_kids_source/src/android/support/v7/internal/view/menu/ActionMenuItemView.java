// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import dz;
import gl;
import gm;
import gq;
import gr;
import gu;
import gv;
import ha;
import hr;
import ku;
import lb;

public class ActionMenuItemView extends hr
    implements android.view.View.OnClickListener, android.view.View.OnLongClickListener, ha, ku
{

    public gu a;
    public gr b;
    private gv c;
    private CharSequence d;
    private Drawable e;
    private lb f;
    private boolean g;
    private int h;
    private int i;
    private int j;

    public ActionMenuItemView(Context context)
    {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        Resources resources = context.getResources();
        g = resources.getBoolean(0x7f120004);
        attributeset = context.obtainStyledAttributes(attributeset, gl.c, k, 0);
        h = attributeset.getDimensionPixelSize(0, 0);
        attributeset.recycle();
        j = (int)(resources.getDisplayMetrics().density * 32F + 0.5F);
        setOnClickListener(this);
        setOnLongClickListener(this);
        setTransformationMethod(new gm(context));
        i = -1;
    }

    public static gr a(ActionMenuItemView actionmenuitemview)
    {
        return actionmenuitemview.b;
    }

    public static gu b(ActionMenuItemView actionmenuitemview)
    {
        return actionmenuitemview.a;
    }

    public static gv c(ActionMenuItemView actionmenuitemview)
    {
        return actionmenuitemview.c;
    }

    private void e()
    {
        CharSequence charsequence;
label0:
        {
            boolean flag3 = false;
            boolean flag;
            if (!TextUtils.isEmpty(d))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (e != null)
            {
                boolean flag1;
                boolean flag2;
                if ((c.d & 4) == 4)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag2 = flag3;
                if (!flag1)
                {
                    break label0;
                }
                flag2 = flag3;
                if (!g)
                {
                    break label0;
                }
            }
            flag2 = true;
        }
        if (flag & flag2)
        {
            charsequence = d;
        } else
        {
            charsequence = null;
        }
        setText(charsequence);
    }

    public final void a(gv gv1, int k)
    {
        c = gv1;
        Drawable drawable = gv1.getIcon();
        e = drawable;
        if (drawable != null)
        {
            int j1 = drawable.getIntrinsicWidth();
            int i1 = drawable.getIntrinsicHeight();
            int l = i1;
            k = j1;
            if (j1 > j)
            {
                float f1 = (float)j / (float)j1;
                k = j;
                l = (int)((float)i1 * f1);
            }
            j1 = l;
            i1 = k;
            if (l > j)
            {
                float f2 = (float)j / (float)l;
                j1 = j;
                i1 = (int)((float)k * f2);
            }
            drawable.setBounds(0, 0, i1, j1);
        }
        setCompoundDrawables(drawable, null, null, null);
        e();
        d = gv1.a(this);
        setContentDescription(d);
        e();
        setId(gv1.getItemId());
        if (gv1.isVisible())
        {
            k = 0;
        } else
        {
            k = 8;
        }
        setVisibility(k);
        setEnabled(gv1.isEnabled());
        if (gv1.hasSubMenu() && f == null)
        {
            f = new gq(this);
        }
    }

    public final boolean a()
    {
        return true;
    }

    public final boolean b()
    {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean c()
    {
        return b() && c.getIcon() == null;
    }

    public final boolean d()
    {
        return b();
    }

    public void onClick(View view)
    {
        if (a != null)
        {
            a.a(c);
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        g = getContext().getResources().getBoolean(0x7f120004);
        e();
    }

    public boolean onLongClick(View view)
    {
        if (b())
        {
            return false;
        }
        int ai[] = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(ai);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int k = getWidth();
        int i1 = getHeight();
        int j1 = ai[1];
        int k1 = i1 / 2;
        int l = ai[0] + k / 2;
        k = l;
        if (dz.a(view) == 0)
        {
            k = context.getResources().getDisplayMetrics().widthPixels - l;
        }
        view = Toast.makeText(context, c.getTitle(), 0);
        if (j1 + k1 < rect.height())
        {
            view.setGravity(0x800035, k, i1);
        } else
        {
            view.setGravity(81, 0, i1);
        }
        view.show();
        return true;
    }

    protected void onMeasure(int k, int l)
    {
        boolean flag = b();
        if (flag && i >= 0)
        {
            super.setPadding(i, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(k, l);
        int i1 = android.view.View.MeasureSpec.getMode(k);
        k = android.view.View.MeasureSpec.getSize(k);
        int j1 = getMeasuredWidth();
        if (i1 == 0x80000000)
        {
            k = Math.min(k, h);
        } else
        {
            k = h;
        }
        if (i1 != 0x40000000 && h > 0 && j1 < k)
        {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000), l);
        }
        if (!flag && e != null)
        {
            super.setPadding((getMeasuredWidth() - e.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (c.hasSubMenu() && f != null && f.onTouch(this, motionevent))
        {
            return true;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public void setPadding(int k, int l, int i1, int j1)
    {
        i = k;
        super.setPadding(k, l, i1, j1);
    }
}

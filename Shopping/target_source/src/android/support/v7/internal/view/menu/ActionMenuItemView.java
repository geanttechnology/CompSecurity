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
import android.support.v4.view.ai;
import android.support.v7.widget.k;
import android.support.v7.widget.v;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

// Referenced classes of package android.support.v7.internal.view.menu:
//            h

public class ActionMenuItemView extends k
    implements m.a, android.support.v7.widget.ActionMenuView.a, android.view.View.OnClickListener, android.view.View.OnLongClickListener
{
    private class a extends android.support.v7.widget.v.b
    {

        final ActionMenuItemView a;

        public v a()
        {
            if (ActionMenuItemView.a(a) != null)
            {
                return ActionMenuItemView.a(a).a();
            } else
            {
                return null;
            }
        }

        protected boolean b()
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (ActionMenuItemView.b(a) != null)
            {
                flag = flag1;
                if (ActionMenuItemView.b(a).a(ActionMenuItemView.c(a)))
                {
                    v v1 = a();
                    flag = flag1;
                    if (v1 != null)
                    {
                        flag = flag1;
                        if (v1.b())
                        {
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        }

        protected boolean c()
        {
            v v1 = a();
            if (v1 != null)
            {
                v1.a();
                return true;
            } else
            {
                return false;
            }
        }

        public a()
        {
            a = ActionMenuItemView.this;
            super(ActionMenuItemView.this);
        }
    }

    public static abstract class b
    {

        public abstract v a();

        public b()
        {
        }
    }


    private h a;
    private CharSequence b;
    private Drawable c;
    private f.b d;
    private android.support.v7.widget.v.b e;
    private b f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private int k;

    public ActionMenuItemView(Context context)
    {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeset, int l)
    {
        super(context, attributeset, l);
        Resources resources = context.getResources();
        g = resources.getBoolean(android.support.v7.a.a.b.abc_config_allowActionMenuItemTextWithIcon);
        context = context.obtainStyledAttributes(attributeset, android.support.v7.a.a.k.ActionMenuItemView, l, 0);
        i = context.getDimensionPixelSize(android.support.v7.a.a.k.ActionMenuItemView_android_minWidth, 0);
        context.recycle();
        k = (int)(resources.getDisplayMetrics().density * 32F + 0.5F);
        setOnClickListener(this);
        setOnLongClickListener(this);
        j = -1;
    }

    static b a(ActionMenuItemView actionmenuitemview)
    {
        return actionmenuitemview.f;
    }

    static f.b b(ActionMenuItemView actionmenuitemview)
    {
        return actionmenuitemview.d;
    }

    static h c(ActionMenuItemView actionmenuitemview)
    {
        return actionmenuitemview.a;
    }

    private void e()
    {
        CharSequence charsequence;
label0:
        {
            boolean flag2 = false;
            boolean flag;
            boolean flag1;
            if (!TextUtils.isEmpty(b))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (c != null)
            {
                flag1 = flag2;
                if (!a.m())
                {
                    break label0;
                }
                if (!g)
                {
                    flag1 = flag2;
                    if (!h)
                    {
                        break label0;
                    }
                }
            }
            flag1 = true;
        }
        if (flag & flag1)
        {
            charsequence = b;
        } else
        {
            charsequence = null;
        }
        setText(charsequence);
    }

    public void a(h h1, int l)
    {
        a = h1;
        setIcon(h1.getIcon());
        setTitle(h1.a(this));
        setId(h1.getItemId());
        if (h1.isVisible())
        {
            l = 0;
        } else
        {
            l = 8;
        }
        setVisibility(l);
        setEnabled(h1.isEnabled());
        if (h1.hasSubMenu() && e == null)
        {
            e = new a();
        }
    }

    public boolean a()
    {
        return true;
    }

    public boolean b()
    {
        return !TextUtils.isEmpty(getText());
    }

    public boolean c()
    {
        return b() && a.getIcon() == null;
    }

    public boolean d()
    {
        return b();
    }

    public h getItemData()
    {
        return a;
    }

    public void onClick(View view)
    {
        if (d != null)
        {
            d.a(a);
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        g = getContext().getResources().getBoolean(android.support.v7.a.a.b.abc_config_allowActionMenuItemTextWithIcon);
        e();
    }

    public boolean onLongClick(View view)
    {
        if (b())
        {
            return false;
        }
        int ai1[] = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(ai1);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int l = getWidth();
        int j1 = getHeight();
        int k1 = ai1[1];
        int l1 = j1 / 2;
        int i1 = ai1[0] + l / 2;
        l = i1;
        if (ai.h(view) == 0)
        {
            l = context.getResources().getDisplayMetrics().widthPixels - i1;
        }
        view = Toast.makeText(context, a.getTitle(), 0);
        if (k1 + l1 < rect.height())
        {
            view.setGravity(0x800035, l, j1);
        } else
        {
            view.setGravity(81, 0, j1);
        }
        view.show();
        return true;
    }

    protected void onMeasure(int l, int i1)
    {
        boolean flag = b();
        if (flag && j >= 0)
        {
            super.setPadding(j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(l, i1);
        int j1 = android.view.View.MeasureSpec.getMode(l);
        l = android.view.View.MeasureSpec.getSize(l);
        int k1 = getMeasuredWidth();
        if (j1 == 0x80000000)
        {
            l = Math.min(l, i);
        } else
        {
            l = i;
        }
        if (j1 != 0x40000000 && i > 0 && k1 < l)
        {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(l, 0x40000000), i1);
        }
        if (!flag && c != null)
        {
            super.setPadding((getMeasuredWidth() - c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (a.hasSubMenu() && e != null && e.onTouch(this, motionevent))
        {
            return true;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public void setCheckable(boolean flag)
    {
    }

    public void setChecked(boolean flag)
    {
    }

    public void setExpandedFormat(boolean flag)
    {
        if (h != flag)
        {
            h = flag;
            if (a != null)
            {
                a.h();
            }
        }
    }

    public void setIcon(Drawable drawable)
    {
        c = drawable;
        if (drawable != null)
        {
            int k1 = drawable.getIntrinsicWidth();
            int j1 = drawable.getIntrinsicHeight();
            int i1 = j1;
            int l = k1;
            if (k1 > k)
            {
                float f1 = (float)k / (float)k1;
                l = k;
                i1 = (int)((float)j1 * f1);
            }
            k1 = i1;
            j1 = l;
            if (i1 > k)
            {
                float f2 = (float)k / (float)i1;
                k1 = k;
                j1 = (int)((float)l * f2);
            }
            drawable.setBounds(0, 0, j1, k1);
        }
        setCompoundDrawables(drawable, null, null, null);
        e();
    }

    public void setItemInvoker(f.b b1)
    {
        d = b1;
    }

    public void setPadding(int l, int i1, int j1, int k1)
    {
        j = l;
        super.setPadding(l, i1, j1, k1);
    }

    public void setPopupCallback(b b1)
    {
        f = b1;
    }

    public void setTitle(CharSequence charsequence)
    {
        b = charsequence;
        setContentDescription(b);
        e();
    }
}

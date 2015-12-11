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
import android.support.v4.view.w;
import android.support.v7.widget.l;
import android.support.v7.widget.s;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

// Referenced classes of package android.support.v7.internal.view.menu:
//            h, f

public class ActionMenuItemView extends l
    implements m.a, android.support.v7.widget.ActionMenuView.a, android.view.View.OnClickListener, android.view.View.OnLongClickListener
{
    private final class a extends android.support.v7.widget.s.b
    {

        final ActionMenuItemView a;

        public final s a()
        {
            if (ActionMenuItemView.a(a) != null)
            {
                return ActionMenuItemView.a(a).a();
            } else
            {
                return null;
            }
        }

        protected final boolean b()
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (ActionMenuItemView.b(a) != null)
            {
                flag = flag1;
                if (ActionMenuItemView.b(a).a(ActionMenuItemView.c(a)))
                {
                    s s1 = a();
                    flag = flag1;
                    if (s1 != null)
                    {
                        flag = flag1;
                        if (s1.b.isShowing())
                        {
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        }

        public a()
        {
            a = ActionMenuItemView.this;
            super(ActionMenuItemView.this);
        }
    }

    public static abstract class b
    {

        public abstract s a();

        public b()
        {
        }
    }


    private h a;
    private CharSequence b;
    private Drawable c;
    private f.b d;
    private android.support.v7.widget.s.b e;
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

    public ActionMenuItemView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        Resources resources = context.getResources();
        g = resources.getBoolean(android.support.v7.b.a.b.abc_config_allowActionMenuItemTextWithIcon);
        context = context.obtainStyledAttributes(attributeset, android.support.v7.b.a.k.ActionMenuItemView, i1, 0);
        i = context.getDimensionPixelSize(android.support.v7.b.a.k.ActionMenuItemView_android_minWidth, 0);
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
            boolean flag3 = false;
            boolean flag;
            if (!TextUtils.isEmpty(b))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (c != null)
            {
                boolean flag1;
                boolean flag2;
                if ((a.c & 4) == 4)
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
                if (!g)
                {
                    flag2 = flag3;
                    if (!h)
                    {
                        break label0;
                    }
                }
            }
            flag2 = true;
        }
        if (flag & flag2)
        {
            charsequence = b;
        } else
        {
            charsequence = null;
        }
        setText(charsequence);
    }

    public final void a(h h1)
    {
        a = h1;
        setIcon(h1.getIcon());
        setTitle(h1.a(this));
        setId(h1.getItemId());
        int i1;
        if (h1.isVisible())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        setVisibility(i1);
        setEnabled(h1.isEnabled());
        if (h1.hasSubMenu() && e == null)
        {
            e = new a();
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
        return b() && a.getIcon() == null;
    }

    public final boolean d()
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
        g = getContext().getResources().getBoolean(android.support.v7.b.a.b.abc_config_allowActionMenuItemTextWithIcon);
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
        int i1 = getWidth();
        int k1 = getHeight();
        int l1 = ai[1];
        int i2 = k1 / 2;
        int j1 = ai[0] + i1 / 2;
        i1 = j1;
        if (w.h(view) == 0)
        {
            i1 = context.getResources().getDisplayMetrics().widthPixels - j1;
        }
        view = Toast.makeText(context, a.getTitle(), 0);
        if (l1 + i2 < rect.height())
        {
            view.setGravity(0x800035, i1, k1);
        } else
        {
            view.setGravity(81, 0, k1);
        }
        view.show();
        return true;
    }

    protected void onMeasure(int i1, int j1)
    {
        boolean flag = b();
        if (flag && j >= 0)
        {
            super.setPadding(j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i1, j1);
        int k1 = android.view.View.MeasureSpec.getMode(i1);
        i1 = android.view.View.MeasureSpec.getSize(i1);
        int l1 = getMeasuredWidth();
        if (k1 == 0x80000000)
        {
            i1 = Math.min(i1, i);
        } else
        {
            i1 = i;
        }
        if (k1 != 0x40000000 && i > 0 && l1 < i1)
        {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000), j1);
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
                a.b.g();
            }
        }
    }

    public void setIcon(Drawable drawable)
    {
        c = drawable;
        if (drawable != null)
        {
            int l1 = drawable.getIntrinsicWidth();
            int k1 = drawable.getIntrinsicHeight();
            int j1 = k1;
            int i1 = l1;
            if (l1 > k)
            {
                float f1 = (float)k / (float)l1;
                i1 = k;
                j1 = (int)((float)k1 * f1);
            }
            l1 = j1;
            k1 = i1;
            if (j1 > k)
            {
                float f2 = (float)k / (float)j1;
                l1 = k;
                k1 = (int)((float)i1 * f2);
            }
            drawable.setBounds(0, 0, k1, l1);
        }
        setCompoundDrawables(drawable, null, null, null);
        e();
    }

    public void setItemInvoker(f.b b1)
    {
        d = b1;
    }

    public void setPadding(int i1, int j1, int k1, int l1)
    {
        j = i1;
        super.setPadding(i1, j1, k1, l1);
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

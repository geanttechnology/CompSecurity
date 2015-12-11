// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

// Referenced classes of package android.support.v7.internal.view.menu:
//            aa, m

public class ListMenuItemView extends LinearLayout
    implements aa
{

    private m a;
    private ImageView b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private Drawable g;
    private int h;
    private Context i;
    private boolean j;
    private Context k;
    private LayoutInflater l;
    private boolean m;

    public ListMenuItemView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ListMenuItemView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset);
        k = context;
        attributeset = context.obtainStyledAttributes(attributeset, android.support.v7.appcompat.R.styleable.MenuView, i1, 0);
        g = attributeset.getDrawable(android.support.v7.appcompat.R.styleable.MenuView_android_itemBackground);
        h = attributeset.getResourceId(android.support.v7.appcompat.R.styleable.MenuView_android_itemTextAppearance, -1);
        j = attributeset.getBoolean(android.support.v7.appcompat.R.styleable.MenuView_preserveIconSpacing, false);
        i = context;
        attributeset.recycle();
    }

    private void b()
    {
        c = (RadioButton)getInflater().inflate(android.support.v7.appcompat.R.layout.abc_list_menu_item_radio, this, false);
        addView(c);
    }

    private void c()
    {
        e = (CheckBox)getInflater().inflate(android.support.v7.appcompat.R.layout.abc_list_menu_item_checkbox, this, false);
        addView(e);
    }

    private LayoutInflater getInflater()
    {
        if (l == null)
        {
            l = LayoutInflater.from(k);
        }
        return l;
    }

    private void setShortcut$25d965e(boolean flag)
    {
        char c1;
        Object obj;
        TextView textview;
        int i1;
        if (flag && a.e())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        textview = f;
        c1 = a.d();
        if (c1 != 0) goto _L4; else goto _L3
_L3:
        obj = "";
_L10:
        textview.setText(((CharSequence) (obj)));
_L2:
        if (f.getVisibility() != i1)
        {
            f.setVisibility(i1);
        }
        return;
_L4:
        obj = new StringBuilder(null);
        c1;
        JVM INSTR lookupswitch 3: default 124
    //                   8: 147
    //                   10: 138
    //                   32: 156;
           goto _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_156;
_L7:
        break; /* Loop/switch isn't completed */
_L5:
        ((StringBuilder) (obj)).append(c1);
_L11:
        obj = ((StringBuilder) (obj)).toString();
        if (true) goto _L10; else goto _L9
_L9:
        ((StringBuilder) (obj)).append(null);
          goto _L11
_L6:
        ((StringBuilder) (obj)).append(null);
          goto _L11
        ((StringBuilder) (obj)).append(null);
          goto _L11
    }

    public final void a(m m1, int i1)
    {
        char c1;
        Object obj;
        boolean flag = false;
        a = m1;
        TextView textview;
        boolean flag1;
        if (m1.isVisible())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        setVisibility(i1);
        setTitle(m1.a(this));
        setCheckable(m1.isCheckable());
        flag1 = m1.e();
        m1.d();
        if (flag1 && a.e())
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 8;
        }
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        textview = f;
        c1 = a.d();
        if (c1 != 0) goto _L4; else goto _L3
_L3:
        obj = "";
_L10:
        textview.setText(((CharSequence) (obj)));
_L2:
        if (f.getVisibility() != i1)
        {
            f.setVisibility(i1);
        }
        setIcon(m1.getIcon());
        setEnabled(m1.isEnabled());
        return;
_L4:
        obj = new StringBuilder(null);
        c1;
        JVM INSTR lookupswitch 3: default 196
    //                   8: 223
    //                   10: 213
    //                   32: 233;
           goto _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_233;
_L7:
        break; /* Loop/switch isn't completed */
_L5:
        ((StringBuilder) (obj)).append(c1);
_L11:
        obj = ((StringBuilder) (obj)).toString();
        if (true) goto _L10; else goto _L9
_L9:
        ((StringBuilder) (obj)).append(null);
          goto _L11
_L6:
        ((StringBuilder) (obj)).append(null);
          goto _L11
        ((StringBuilder) (obj)).append(null);
          goto _L11
    }

    public final boolean a()
    {
        return false;
    }

    public m getItemData()
    {
        return a;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        setBackgroundDrawable(g);
        d = (TextView)findViewById(android.support.v7.appcompat.R.id.title);
        if (h != -1)
        {
            d.setTextAppearance(i, h);
        }
        f = (TextView)findViewById(android.support.v7.appcompat.R.id.shortcut);
    }

    protected void onMeasure(int i1, int j1)
    {
        if (b != null && j)
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            android.widget.LinearLayout.LayoutParams layoutparams1 = (android.widget.LinearLayout.LayoutParams)b.getLayoutParams();
            if (layoutparams.height > 0 && layoutparams1.width <= 0)
            {
                layoutparams1.width = layoutparams.height;
            }
        }
        super.onMeasure(i1, j1);
    }

    public void setCheckable(boolean flag)
    {
        if (flag || c != null || e != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        Object obj1;
        if (a.f())
        {
            if (c == null)
            {
                b();
            }
            obj = c;
            obj1 = e;
        } else
        {
            if (e == null)
            {
                c();
            }
            obj = e;
            obj1 = c;
        }
        if (flag)
        {
            ((CompoundButton) (obj)).setChecked(a.isChecked());
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            if (((CompoundButton) (obj)).getVisibility() != i1)
            {
                ((CompoundButton) (obj)).setVisibility(i1);
            }
            if (obj1 != null && ((CompoundButton) (obj1)).getVisibility() != 8)
            {
                ((CompoundButton) (obj1)).setVisibility(8);
                return;
            }
            if (true)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        if (e != null)
        {
            e.setVisibility(8);
        }
        if (c != null)
        {
            c.setVisibility(8);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void setChecked(boolean flag)
    {
        Object obj;
        if (a.f())
        {
            if (c == null)
            {
                b();
            }
            obj = c;
        } else
        {
            if (e == null)
            {
                c();
            }
            obj = e;
        }
        ((CompoundButton) (obj)).setChecked(flag);
    }

    public void setForceShowIcon(boolean flag)
    {
        m = flag;
        j = flag;
    }

    public void setIcon(Drawable drawable)
    {
        boolean flag;
        if (a.h() || m)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        break MISSING_BLOCK_LABEL_19;
        if ((flag || j) && (b != null || drawable != null || j))
        {
            if (b == null)
            {
                b = (ImageView)getInflater().inflate(android.support.v7.appcompat.R.layout.abc_list_menu_item_icon, this, false);
                addView(b, 0);
            }
            if (drawable != null || j)
            {
                ImageView imageview = b;
                if (!flag)
                {
                    drawable = null;
                }
                imageview.setImageDrawable(drawable);
                if (b.getVisibility() != 0)
                {
                    b.setVisibility(0);
                    return;
                }
            } else
            {
                b.setVisibility(8);
                return;
            }
        }
        return;
    }

    public void setTitle(CharSequence charsequence)
    {
        if (charsequence != null)
        {
            d.setText(charsequence);
            if (d.getVisibility() != 0)
            {
                d.setVisibility(0);
            }
        } else
        if (d.getVisibility() != 8)
        {
            d.setVisibility(8);
            return;
        }
    }
}

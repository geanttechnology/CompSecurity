// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.internal.widget.CompatTextView;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class dk extends LinearLayoutCompat
    implements android.view.View.OnLongClickListener
{

    final ScrollingTabContainerView a;
    private final int b[] = {
        0x10100d4
    };
    private b c;
    private TextView d;
    private ImageView e;
    private View f;

    public dk(ScrollingTabContainerView scrollingtabcontainerview, Context context, b b1, boolean flag)
    {
        a = scrollingtabcontainerview;
        super(context, null, r.actionBarTabStyle);
        c = b1;
        scrollingtabcontainerview = dx.a(context, null, b, r.actionBarTabStyle, 0);
        if (scrollingtabcontainerview.d(0))
        {
            setBackgroundDrawable(scrollingtabcontainerview.a(0));
        }
        scrollingtabcontainerview.b();
        if (flag)
        {
            setGravity(0x800013);
        }
        a();
    }

    public void a()
    {
        Object obj = c;
        Object obj1 = ((b) (obj)).c();
        if (obj1 != null)
        {
            obj = ((View) (obj1)).getParent();
            if (obj != this)
            {
                if (obj != null)
                {
                    ((ViewGroup)obj).removeView(((View) (obj1)));
                }
                addView(((View) (obj1)));
            }
            f = ((View) (obj1));
            if (d != null)
            {
                d.setVisibility(8);
            }
            if (e != null)
            {
                e.setVisibility(8);
                e.setImageDrawable(null);
            }
            return;
        }
        if (f != null)
        {
            removeView(f);
            f = null;
        }
        android.graphics.drawable.Drawable drawable = ((b) (obj)).a();
        obj1 = ((b) (obj)).b();
        boolean flag;
        if (drawable != null)
        {
            if (e == null)
            {
                ImageView imageview = new ImageView(getContext());
                android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutparams1 = new android.support.v7.widget.LinearLayoutCompat.LayoutParams(-2, -2);
                layoutparams1.h = 16;
                imageview.setLayoutParams(layoutparams1);
                addView(imageview, 0);
                e = imageview;
            }
            e.setImageDrawable(drawable);
            e.setVisibility(0);
        } else
        if (e != null)
        {
            e.setVisibility(8);
            e.setImageDrawable(null);
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (d == null)
            {
                CompatTextView compattextview = new CompatTextView(getContext(), null, r.actionBarTabTextStyle);
                compattextview.setEllipsize(android.text.TextUtils.TruncateAt.END);
                android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutparams = new android.support.v7.widget.LinearLayoutCompat.LayoutParams(-2, -2);
                layoutparams.h = 16;
                compattextview.setLayoutParams(layoutparams);
                addView(compattextview);
                d = compattextview;
            }
            d.setText(((CharSequence) (obj1)));
            d.setVisibility(0);
        } else
        if (d != null)
        {
            d.setVisibility(8);
            d.setText(null);
        }
        if (e != null)
        {
            e.setContentDescription(((b) (obj)).e());
        }
        if (!flag && !TextUtils.isEmpty(((b) (obj)).e()))
        {
            setOnLongClickListener(this);
            return;
        } else
        {
            setOnLongClickListener(null);
            setLongClickable(false);
            return;
        }
    }

    public void a(b b1)
    {
        c = b1;
        a();
    }

    public b b()
    {
        return c;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(b.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            accessibilitynodeinfo.setClassName(b.getName());
        }
    }

    public boolean onLongClick(View view)
    {
        view = new int[2];
        getLocationOnScreen(view);
        Object obj = getContext();
        int i = getWidth();
        int j = getHeight();
        int k = ((Context) (obj)).getResources().getDisplayMetrics().widthPixels;
        obj = Toast.makeText(((Context) (obj)), c.e(), 0);
        ((Toast) (obj)).setGravity(49, (view[0] + i / 2) - k / 2, j);
        ((Toast) (obj)).show();
        return true;
    }

    public void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (a.mMaxTabWidth > 0 && getMeasuredWidth() > a.mMaxTabWidth)
        {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(a.mMaxTabWidth, 0x40000000), j);
        }
    }

    public void setSelected(boolean flag)
    {
        boolean flag1;
        if (isSelected() != flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        super.setSelected(flag);
        if (flag1 && flag)
        {
            sendAccessibilityEvent(4);
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wishabi.flipp.app.FlippApplication;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.widget:
//            du, dt, dv

public class ShoppingListZeroCaseView extends LinearLayout
{

    private List a;
    private dv b;

    public ShoppingListZeroCaseView(Context context)
    {
        this(context, null);
    }

    public ShoppingListZeroCaseView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ShoppingListZeroCaseView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setOrientation(1);
        setGravity(1);
    }

    static dv a(ShoppingListZeroCaseView shoppinglistzerocaseview)
    {
        return shoppinglistzerocaseview.b;
    }

    static void a(ShoppingListZeroCaseView shoppinglistzerocaseview, int i, int j)
    {
        shoppinglistzerocaseview.removeAllViews();
        LayoutInflater layoutinflater = LayoutInflater.from(shoppinglistzerocaseview.getContext());
        int k = android.view.View.MeasureSpec.makeMeasureSpec(i, 0x80000000);
        int l = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int i1 = (int)TypedValue.applyDimension(1, 45F, shoppinglistzerocaseview.getContext().getResources().getDisplayMetrics());
        int j1 = (int)TypedValue.applyDimension(1, 45F, shoppinglistzerocaseview.getContext().getResources().getDisplayMetrics());
        i = (int)TypedValue.applyDimension(1, 7F, shoppinglistzerocaseview.getContext().getResources().getDisplayMetrics());
        Object obj1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj1.topMargin = i1;
        Object obj = new TextView(shoppinglistzerocaseview.getContext());
        ((TextView) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        ((TextView) (obj)).setTextSize(20F);
        ((TextView) (obj)).setText(0x7f0e0130);
        ((TextView) (obj)).measure(k, l);
        shoppinglistzerocaseview.addView(((android.view.View) (obj)), 0);
        obj1 = (TextView)layoutinflater.inflate(0x7f030057, shoppinglistzerocaseview, false);
        ((TextView) (obj1)).setText("DUMMY");
        ((TextView) (obj1)).measure(k, l);
        j = (j - i1 - j1 - ((TextView) (obj)).getMeasuredHeight()) / (((TextView) (obj1)).getMeasuredHeight() + i);
        obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj.topMargin = i;
        if (shoppinglistzerocaseview.a != null && shoppinglistzerocaseview.a.size() >= j)
        {
            i = 0;
            while (i < j) 
            {
                TextView textview = (TextView)layoutinflater.inflate(0x7f030057, shoppinglistzerocaseview, false);
                textview.setText((CharSequence)shoppinglistzerocaseview.a.get(i));
                if (shoppinglistzerocaseview.b != null)
                {
                    textview.setOnClickListener(new du(shoppinglistzerocaseview));
                }
                shoppinglistzerocaseview.addView(textview, i + 1, ((android.view.ViewGroup.LayoutParams) (obj)));
                i++;
            }
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (a == null)
        {
            return;
        } else
        {
            FlippApplication.a(new dt(this, i, j));
            return;
        }
    }

    public void setItems(List list)
    {
        a = list;
    }

    public void setListener(dv dv)
    {
        b = dv;
    }
}

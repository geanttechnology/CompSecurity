// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.service.b;
import com.target.ui.util.aj;
import com.target.ui.util.al;
import com.target.ui.util.q;

public class CartBadgeView extends FrameLayout
    implements com.target.ui.service.b.a
{

    public static final String TAG = com/target/ui/view/CartBadgeView.getSimpleName();
    private TextView mCartQuantityView;

    public CartBadgeView(Context context)
    {
        super(context);
        a(context);
    }

    public CartBadgeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public CartBadgeView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a()
    {
        aj.a(this).start();
    }

    private void a(Context context)
    {
        inflate(context, 0x7f030103, this);
        setupCartQuantity(this);
        int i = getCurrentQuantity();
        if (i > 0)
        {
            setContentDescription(getResources().getQuantityString(0x7f110000, i, new Object[] {
                Integer.valueOf(i)
            }));
            return;
        } else
        {
            setContentDescription(getResources().getString(0x7f0900f1));
            return;
        }
    }

    private void b(int i)
    {
        if (i > 0)
        {
            al.a(mCartQuantityView, String.valueOf(i));
            setContentDescription(getResources().getQuantityString(0x7f110000, i, new Object[] {
                Integer.valueOf(i)
            }));
            return;
        } else
        {
            al.c(mCartQuantityView);
            return;
        }
    }

    private int getCurrentQuantity()
    {
        String s = mCartQuantityView.getText().toString();
        if (!o.g(s))
        {
            return 0;
        }
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            q.a(TAG, (new StringBuilder()).append("Exception while trying to parse current cart badge quantity : ").append(numberformatexception.getMessage()).toString());
            return 0;
        }
        return i;
    }

    private void setupCartQuantity(View view)
    {
        mCartQuantityView = (TextView)view.findViewById(0x7f100303);
        b(com.target.ui.service.b.a().c());
    }

    public void a(int i)
    {
        q.d(TAG, (new StringBuilder()).append("Quantity updated : ").append(i).toString());
        if (getCurrentQuantity() != i)
        {
            a();
        }
        b(i);
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        com.target.ui.service.b.a().a(this);
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        com.target.ui.service.b.a().b(this);
    }

}

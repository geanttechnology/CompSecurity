// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

public abstract class hc extends ViewGroup
{

    public ActionMenuView a;
    public int b;
    public ep c;

    hc(Context context)
    {
        this(context, null);
    }

    hc(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public hc(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        new hd(this);
        attributeset = new TypedValue();
        if (context.getTheme().resolveAttribute(0x7f01008e, attributeset, true) && ((TypedValue) (attributeset)).resourceId != 0)
        {
            new ContextThemeWrapper(context, ((TypedValue) (attributeset)).resourceId);
        }
    }

    public void a(int i)
    {
        b = i;
        requestLayout();
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        configuration = getContext().obtainStyledAttributes(null, gl.a, 0x7f01008f, 0);
        a(configuration.getLayoutDimension(1, 0));
        configuration.recycle();
    }

    static 
    {
        new DecelerateInterpolator();
    }
}

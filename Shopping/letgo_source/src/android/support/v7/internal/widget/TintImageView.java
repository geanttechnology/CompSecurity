// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

// Referenced classes of package android.support.v7.internal.widget:
//            q, p

public class TintImageView extends ImageView
{

    private static final int TINT_ATTRS[] = {
        0x10100d4, 0x1010119
    };
    private final p mTintManager;

    public TintImageView(Context context)
    {
        this(context, null);
    }

    public TintImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public TintImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = q.a(getContext(), attributeset, TINT_ATTRS, i, 0);
        if (context.a() > 0)
        {
            if (context.e(0))
            {
                setBackgroundDrawable(context.a(0));
            }
            if (context.e(1))
            {
                setImageDrawable(context.a(1));
            }
        }
        context.b();
        mTintManager = context.c();
    }

    public void setImageResource(int i)
    {
        setImageDrawable(mTintManager.a(i));
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ad.a;

import android.content.Context;
import android.widget.LinearLayout;

// Referenced classes of package com.shazam.android.ad.a:
//            f

public class e extends LinearLayout
{

    private f a;
    private boolean b;

    public e(Context context)
    {
        super(context);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        b = true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        b = false;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (a != null && j != l && b)
        {
            a.a(j);
        }
    }

    public void setSizeChangedListener(f f1)
    {
        a = f1;
    }
}

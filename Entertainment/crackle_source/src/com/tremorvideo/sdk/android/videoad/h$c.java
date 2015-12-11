// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.widget.RelativeLayout;
import com.tremorvideo.sdk.android.richmedia.b.d;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            h

private class c
    implements Runnable
{

    final h a;
    private int b;
    private android.widget.tiveLayout.LayoutParams c;

    private void a()
    {
        if (a.h != null)
        {
            if (a.h.getParent() == a.g)
            {
                a.g.removeView(a.h);
            }
            a.h.clearView();
        }
    }

    private void a(android.widget.tiveLayout.LayoutParams layoutparams)
    {
        boolean flag = false;
        if (a.h != null)
        {
            a.h.setVisibility(0);
            if (a.g == a.h.getParent())
            {
                flag = true;
            }
            if (!flag)
            {
                a.g.addView(a.h, layoutparams);
            } else
            {
                a.h.setLayoutParams(layoutparams);
                a.h.requestLayout();
            }
            a.g.requestLayout();
        }
    }

    public void run()
    {
        if (b == 1)
        {
            a(c);
        } else
        if (b == 2)
        {
            a();
            return;
        }
    }

    public ms(h h1, int i, android.widget.tiveLayout.LayoutParams layoutparams)
    {
        a = h1;
        super();
        b = i;
        c = layoutparams;
    }
}

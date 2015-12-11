// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package android.support.v4.view:
//            ViewPager, t

public class f extends ViewPager
{

    private int a;

    public f(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = -1;
    }

    final void a()
    {
        if (a != -1)
        {
            a(a);
            a = -1;
            return;
        } else
        {
            super.a();
            return;
        }
    }

    public void a(t t, boolean flag)
    {
        if (flag)
        {
            a = getCurrentItem();
        }
        super.setAdapter(t);
    }
}

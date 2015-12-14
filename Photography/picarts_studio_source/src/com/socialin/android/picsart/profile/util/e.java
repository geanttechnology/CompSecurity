// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.util;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.socialin.android.picsart.profile.util:
//            CardVisibilityTracker, d, f

final class e
    implements Runnable
{

    private final ArrayList a = new ArrayList();
    private final ArrayList b = new ArrayList();
    private CardVisibilityTracker c;

    e(CardVisibilityTracker cardvisibilitytracker)
    {
        c = cardvisibilitytracker;
        super();
    }

    public final void run()
    {
        CardVisibilityTracker.a(c);
        Iterator iterator = CardVisibilityTracker.b(c).iterator();
        do
        {
            if (iterator.hasNext())
            {
                View view = (View)iterator.next();
                int ai[] = CardVisibilityTracker._cls2.a;
                Object obj = CardVisibilityTracker.d(c);
                int i = CardVisibilityTracker.c(c);
                boolean flag;
                if (view == null || view.getVisibility() != 0 || view.getParent() == null)
                {
                    flag = true;
                } else
                if (!view.getGlobalVisibleRect(((d) (obj)).a))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    obj = CardVisibilityTracker.ViewState.INVISIBLE;
                } else
                {
                    long l = ((d) (obj)).a.height();
                    long l1 = ((d) (obj)).a.width();
                    long l2 = (long)view.getHeight() * (long)view.getWidth();
                    if (l2 <= 0L)
                    {
                        obj = CardVisibilityTracker.ViewState.INVISIBLE;
                    } else
                    if (l * l1 * 100L >= (long)i * l2)
                    {
                        obj = CardVisibilityTracker.ViewState.VISIBLE_FOR_MIN_PERCENTAGE;
                    } else
                    {
                        obj = CardVisibilityTracker.ViewState.VISIBLE_JUST;
                    }
                }
                switch (ai[((CardVisibilityTracker.ViewState) (obj)).ordinal()])
                {
                case 1: // '\001'
                    a.add(view);
                    break;

                case 2: // '\002'
                    b.add(view);
                    break;
                }
                continue;
            }
            if (CardVisibilityTracker.e(c) != null)
            {
                CardVisibilityTracker.e(c).a(a, b);
            }
            a.clear();
            b.clear();
            break;
        } while (true);
    }
}

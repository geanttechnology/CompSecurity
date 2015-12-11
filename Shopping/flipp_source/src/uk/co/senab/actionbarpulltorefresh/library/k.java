// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.actionbarpulltorefresh.library;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

// Referenced classes of package uk.co.senab.actionbarpulltorefresh.library:
//            j

final class k
    implements Runnable
{

    final ViewGroup a;
    final j b;

    k(j j1, ViewGroup viewgroup)
    {
        b = j1;
        a = viewgroup;
        super();
    }

    public final void run()
    {
        if (a.getWindowToken() != null)
        {
            j j1 = b;
            View view = b.d;
            j1.c.getWindow().getDecorView().getWindowVisibleDisplayFrame(j1.o);
            int i = -1;
            int l = -2;
            Object obj = view.getLayoutParams();
            if (obj != null)
            {
                i = ((android.view.ViewGroup.LayoutParams) (obj)).width;
                l = ((android.view.ViewGroup.LayoutParams) (obj)).height;
            }
            obj = new android.view.WindowManager.LayoutParams(i, l, 1000, 280, -3);
            obj.x = 0;
            obj.y = j1.o.top;
            obj.gravity = 48;
            view.setTag(obj);
            j1.c.getWindowManager().addView(view, ((android.view.ViewGroup.LayoutParams) (obj)));
            return;
        } else
        {
            a.post(this);
            return;
        }
    }
}

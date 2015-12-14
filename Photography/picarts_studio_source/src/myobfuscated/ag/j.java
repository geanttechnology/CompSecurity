// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ag;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package myobfuscated.ag:
//            g, k

final class j
{

    final View a;
    final List b = new ArrayList();
    k c;
    private Point d;

    public j(View view)
    {
        a = view;
    }

    private int a(int i, boolean flag)
    {
        Object obj;
label0:
        {
            int k = i;
            if (i == -2)
            {
                if (d == null)
                {
                    obj = ((WindowManager)a.getContext().getSystemService("window")).getDefaultDisplay();
                    if (android.os.Build.VERSION.SDK_INT >= 13)
                    {
                        d = new Point();
                        ((Display) (obj)).getSize(d);
                    } else
                    {
                        d = new Point(((Display) (obj)).getWidth(), ((Display) (obj)).getHeight());
                    }
                }
                obj = d;
                if (!flag)
                {
                    break label0;
                }
                k = ((Point) (obj)).y;
            }
            return k;
        }
        return ((Point) (obj)).x;
    }

    static void a(j j1)
    {
        int i;
        int k;
label0:
        {
            if (!j1.b.isEmpty())
            {
                i = j1.c();
                k = j1.b();
                if (a(i) && a(k))
                {
                    break label0;
                }
            }
            return;
        }
        for (Iterator iterator = j1.b.iterator(); iterator.hasNext(); ((g)iterator.next()).a(i, k)) { }
        j1.a();
    }

    static boolean a(int i)
    {
        return i > 0 || i == -2;
    }

    final void a()
    {
        ViewTreeObserver viewtreeobserver = a.getViewTreeObserver();
        if (viewtreeobserver.isAlive())
        {
            viewtreeobserver.removeOnPreDrawListener(c);
        }
        c = null;
        b.clear();
    }

    final int b()
    {
        android.view.ViewGroup.LayoutParams layoutparams = a.getLayoutParams();
        if (a(a.getHeight()))
        {
            return a.getHeight();
        }
        if (layoutparams != null)
        {
            return a(layoutparams.height, true);
        } else
        {
            return 0;
        }
    }

    final int c()
    {
        int i = 0;
        android.view.ViewGroup.LayoutParams layoutparams = a.getLayoutParams();
        if (a(a.getWidth()))
        {
            i = a.getWidth();
        } else
        if (layoutparams != null)
        {
            return a(layoutparams.width, false);
        }
        return i;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.melnykov.fab;

import android.view.ViewTreeObserver;

// Referenced classes of package com.melnykov.fab:
//            FloatingActionButton

final class b
    implements android.view.rawListener
{

    private boolean a;
    private boolean b;
    private FloatingActionButton c;

    public final boolean onPreDraw()
    {
        ViewTreeObserver viewtreeobserver = c.getViewTreeObserver();
        if (viewtreeobserver.isAlive())
        {
            viewtreeobserver.removeOnPreDrawListener(this);
        }
        FloatingActionButton.a(c, a, b);
        return true;
    }

    istener(FloatingActionButton floatingactionbutton, boolean flag, boolean flag1)
    {
        c = floatingactionbutton;
        a = flag;
        b = flag1;
        super();
    }
}

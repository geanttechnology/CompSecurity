// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v7.internal.view.menu.a;
import android.support.v7.widget.Toolbar;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            t

class b
    implements android.view..OnClickListener
{

    final a a;
    final t b;

    public void onClick(View view)
    {
        if (t.c(b) != null && t.d(b))
        {
            t.c(b).onMenuItemSelected(0, a);
        }
    }

    (t t1)
    {
        b = t1;
        super();
        a = new a(android.support.v7.internal.widget.t.a(b).getContext(), 0, 0x102002c, 0, 0, t.b(b));
    }
}

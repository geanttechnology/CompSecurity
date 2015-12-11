// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v7.internal.view.menu.a;
import android.support.v7.widget.Toolbar;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            r

class b
    implements android.view..OnClickListener
{

    final a a;
    final r b;

    public void onClick(View view)
    {
        if (r.c(b) != null && r.d(b))
        {
            r.c(b).onMenuItemSelected(0, a);
        }
    }

    (r r1)
    {
        b = r1;
        super();
        a = new a(android.support.v7.internal.widget.r.a(b).getContext(), 0, 0x102002c, 0, 0, r.b(b));
    }
}

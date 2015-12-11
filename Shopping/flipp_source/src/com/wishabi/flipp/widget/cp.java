// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;
import android.widget.TextView;
import com.wishabi.flipp.util.g;

// Referenced classes of package com.wishabi.flipp.widget:
//            cn

final class cp
    implements android.view.View.OnFocusChangeListener
{

    final cn a;

    cp(cn cn1)
    {
        a = cn1;
        super();
    }

    public final void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            a.k.setActivated(true);
            return;
        } else
        {
            a.k.setActivated(false);
            g.a(view);
            return;
        }
    }
}

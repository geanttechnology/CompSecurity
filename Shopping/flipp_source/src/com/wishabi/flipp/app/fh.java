// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.View;
import android.widget.CheckBox;

// Referenced classes of package com.wishabi.flipp.app:
//            fg

final class fh
    implements android.view.View.OnClickListener
{

    final View a;
    final fg b;

    fh(fg fg1, View view)
    {
        b = fg1;
        a = view;
        super();
    }

    public final void onClick(View view)
    {
        view = a;
        int i;
        if (fg.a(b).isChecked())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }
}

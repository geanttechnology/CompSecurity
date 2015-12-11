// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.app;

import android.widget.ImageButton;

// Referenced classes of package com.helpshift.app:
//            ActionBarHelperBase

class a
    implements com.helpshift.j._cls3
{

    final ImageButton a;
    final ActionBarHelperBase b;

    public void a(boolean flag)
    {
        if (flag)
        {
            a.setVisibility(0);
            return;
        } else
        {
            a.setVisibility(8);
            return;
        }
    }

    (ActionBarHelperBase actionbarhelperbase, ImageButton imagebutton)
    {
        b = actionbarhelperbase;
        a = imagebutton;
        super();
    }
}

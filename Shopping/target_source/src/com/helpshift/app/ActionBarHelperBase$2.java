// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.app;

import android.app.Activity;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package com.helpshift.app:
//            ActionBarHelperBase

class a
    implements android.view.se._cls2
{

    final MenuItem a;
    final ActionBarHelperBase b;

    public void onClick(View view)
    {
        b.a.onMenuItemSelected(0, a);
    }

    (ActionBarHelperBase actionbarhelperbase, MenuItem menuitem)
    {
        b = actionbarhelperbase;
        a = menuitem;
        super();
    }
}

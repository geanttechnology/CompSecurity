// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.app.Activity;
import android.support.v7.hh;
import android.view.View;

// Referenced classes of package com.abtnprojects.ambatana.ui.widgets:
//            b

class a
    implements android.view..OnClickListener
{

    final Activity a;
    final b b;

    public void onClick(View view)
    {
        com.abtnprojects.ambatana.ui.widgets.b.a(b).d(a);
        b.dismiss();
    }

    (b b1, Activity activity)
    {
        b = b1;
        a = activity;
        super();
    }
}

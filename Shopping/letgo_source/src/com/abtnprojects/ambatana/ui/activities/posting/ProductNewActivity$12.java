// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.posting;

import android.content.DialogInterface;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.posting:
//            ProductNewActivity

class a
    implements android.content.kListener
{

    final ProductNewActivity a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == 0)
        {
            ProductNewActivity.e(a);
        } else
        if (i == 1)
        {
            ProductNewActivity.f(a);
            return;
        }
    }

    (ProductNewActivity productnewactivity)
    {
        a = productnewactivity;
        super();
    }
}

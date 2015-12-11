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
        switch (i)
        {
        default:
            throw new IllegalArgumentException("Option is not implemented");

        case 0: // '\0'
            ProductNewActivity.e(a);
            return;

        case 1: // '\001'
            ProductNewActivity.f(a);
            return;

        case 2: // '\002'
            ProductNewActivity.g(a);
            break;
        }
    }

    (ProductNewActivity productnewactivity)
    {
        a = productnewactivity;
        super();
    }
}

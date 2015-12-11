// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.support.v7.iu;
import android.view.View;
import com.parse.ParseUser;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            ProductActivity

class a
    implements android.view.er
{

    final ProductActivity a;

    public void onClick(View view)
    {
        if (iu.c(ParseUser.getCurrentUser()))
        {
            ProductActivity.a(a, ProductActivity.c(a));
            return;
        } else
        {
            ProductActivity.a(a, "question");
            return;
        }
    }

    (ProductActivity productactivity)
    {
        a = productactivity;
        super();
    }
}

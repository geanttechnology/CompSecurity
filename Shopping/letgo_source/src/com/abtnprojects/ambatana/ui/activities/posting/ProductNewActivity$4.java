// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.posting;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.posting:
//            ProductNewActivity

class a
    implements android.widget.ectedListener
{

    final String a[];
    final ProductNewActivity b;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        ProductNewActivity.c(b, a[i]);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    (ProductNewActivity productnewactivity, String as[])
    {
        b = productnewactivity;
        a = as;
        super();
    }
}

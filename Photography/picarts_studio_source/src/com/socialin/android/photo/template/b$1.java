// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.socialin.android.photo.template:
//            b

final class a
    implements android.widget.terView.OnItemClickListener
{

    private Activity a;
    private b b;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = a.findViewById(0x7f100169);
        if (adapterview != null && (adapterview instanceof ViewPager))
        {
            ((ViewPager)adapterview).setCurrentItem(1, true);
        }
        if (com.socialin.android.photo.template.b.a() != i)
        {
            com.socialin.android.photo.template.b.a(b, i);
        }
    }

    stener(b b1, Activity activity)
    {
        b = b1;
        a = activity;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import myobfuscated.cb.a;
import myobfuscated.cb.c;

// Referenced classes of package com.socialin.android.photo.clipart:
//            f

final class a
    implements android.widget.terView.OnItemClickListener
{

    private Activity a;
    private f b;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (com.socialin.android.photo.clipart.f.a(b).a(i).i && com.socialin.android.photo.clipart.f.a(b).a(i).w == 0 || !com.socialin.android.photo.clipart.f.a(b).a(i).i)
        {
            adapterview = a.findViewById(0x7f100169);
            if (adapterview != null && (adapterview instanceof ViewPager))
            {
                ((ViewPager)adapterview).setCurrentItem(1, true);
            }
            if (f.b() != i || f.b(b))
            {
                com.socialin.android.photo.clipart.f.c(b);
                com.socialin.android.photo.clipart.f.a(b, i);
            }
            com.socialin.android.photo.clipart.f.a(i);
            com.socialin.android.photo.clipart.f.a(b).c = f.b();
            com.socialin.android.photo.clipart.f.a(b).notifyDataSetChanged();
            return;
        } else
        {
            com.socialin.android.photo.clipart.f.a(b, a, com.socialin.android.photo.clipart.f.a(b).a(i));
            return;
        }
    }

    istener(f f1, Activity activity)
    {
        b = f1;
        a = activity;
        super();
    }
}

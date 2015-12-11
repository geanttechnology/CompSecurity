// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.wishabi.flipp.content.af;
import com.wishabi.flipp.util.q;

// Referenced classes of package com.wishabi.flipp.app:
//            de, ItemDetailsActivity

final class cw
    implements de
{

    final ItemDetailsActivity a;

    cw(ItemDetailsActivity itemdetailsactivity)
    {
        a = itemdetailsactivity;
        super();
    }

    public final void a(af af1)
    {
        ActionBar actionbar = a.getActionBar();
        View view;
        if (actionbar != null)
        {
            if ((view = a.getLayoutInflater().inflate(0x7f030053, null)) != null)
            {
                ((TextView)view.findViewById(0x7f0b0143)).setText(af1.d);
                TextView textview = (TextView)view.findViewById(0x7f0b0144);
                String s = q.a(af1.q, af1.p);
                af1 = s;
                if (TextUtils.isEmpty(s))
                {
                    af1 = ItemDetailsActivity.a(a);
                }
                textview.setText(af1);
                actionbar.setDisplayShowTitleEnabled(false);
                actionbar.setDisplayShowCustomEnabled(true);
                actionbar.setDisplayHomeAsUpEnabled(true);
                actionbar.setCustomView(view);
                return;
            }
        }
    }
}

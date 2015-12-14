// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.ExtraDownloadActivity;
import com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity;
import com.cyberlink.youcammakeup.clflurry.YMKRatingCardEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bd;
import com.pf.common.utility.m;
import w.a.a;

public class ad extends a
{

    private View a;
    private View b;
    private ImageView c;
    private AnimationDrawable d;
    private Activity e;
    private TextView f;
    private TextView g;

    public ad(Activity activity, boolean flag)
    {
        super(activity, flag);
        e = activity;
    }

    static Activity a(ad ad1)
    {
        return ad1.e;
    }

    private void b()
    {
        if (d != null && !d.isRunning())
        {
            c.setVisibility(0);
            d.setVisible(true, true);
            d.start();
        }
    }

    protected int a()
    {
        return 0x7f03018a;
    }

    protected void a(View view)
    {
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKRatingCardEvent(com.cyberlink.youcammakeup.clflurry.YMKRatingCardEvent.Operation.a));
        f = (TextView)view.findViewById(0x7f0c0570);
        g = (TextView)view.findViewById(0x7f0c056d);
        if (!(e instanceof EditViewActivity)) goto _L2; else goto _L1
_L1:
        f.setText(e.getString(0x7f0706b3));
        g.setText(e.getString(0x7f0706b0));
_L4:
        c = (ImageView)view.findViewById(0x7f0c06c0);
        d = (AnimationDrawable)c.getDrawable();
        a = view.findViewById(0x7f0c056e);
        b = view.findViewById(0x7f0c056f);
        a.setOnClickListener(new android.view.View.OnClickListener() {

            final ad a;

            public void onClick(View view1)
            {
                a.dismiss();
            }

            
            {
                a = ad.this;
                super();
            }
        });
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final ad a;

            public void onClick(View view1)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKRatingCardEvent(com.cyberlink.youcammakeup.clflurry.YMKRatingCardEvent.Operation.b));
                a.dismiss();
                boolean flag = bd.a(com.cyberlink.youcammakeup.widgetpool.dialogs.ad.a(a));
                if (flag)
                {
                    z.a("HAS_RATE_THIS_APP", Boolean.valueOf(flag), Globals.d());
                    return;
                } else
                {
                    m.e("[PromoteUserRatingDialog] RateUsButton#onClick", "startActivity exception");
                    return;
                }
            }

            
            {
                a = ad.this;
                super();
            }
        });
        b();
        return;
_L2:
        if ((e instanceof ExtraDownloadCategoryActivity) || (e instanceof ExtraDownloadActivity))
        {
            f.setText(e.getString(0x7f0706b4));
            g.setText(e.getString(0x7f0706b1));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}

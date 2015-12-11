// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.player;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v4.app.m;
import com.shazam.android.activities.c;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.fragment.player.a;
import com.shazam.android.widget.p.q;
import com.shazam.i.b.ay.j.b;
import com.shazam.i.b.ay.j.d;
import com.shazam.model.tooltip.PlayerOverlayToolTip;
import com.shazam.model.tooltip.TooltipDisplayStrategy;
import com.shazam.model.tooltip.TooltipInfo;

public class PlayerActivity extends BaseAppCompatActivity
    implements android.support.v4.app.k.a, c
{

    private final TooltipDisplayStrategy a = com.shazam.i.b.ay.j.b.b();
    private final q b = d.a();
    private final TooltipInfo c = new PlayerOverlayToolTip();

    public PlayerActivity()
    {
    }

    public final void a()
    {
        k k1 = getSupportFragmentManager();
        if (k1.e() == 0)
        {
            k1.a(0x7f1100f6).setUserVisibleHint(true);
        }
    }

    public void finish()
    {
        super.finish();
        overridePendingTransition(0x7f04000a, 0x7f04000e);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030029);
        k k1 = getSupportFragmentManager();
        Fragment fragment = k1.a(0x7f1100f6);
        if (bundle == null)
        {
            boolean flag = a.a(c);
            if (flag)
            {
                b.a(c);
                k1.a().a(0x7f1100f6, com.shazam.android.fragment.player.a.a(), "PlayerOverlayHelpFragment").a("PlayerOverlayHelpFragment").a();
            }
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            fragment.setUserVisibleHint(flag);
            overridePendingTransition(0x7f04000d, 0x7f040015);
        }
        k1.a(this);
    }
}

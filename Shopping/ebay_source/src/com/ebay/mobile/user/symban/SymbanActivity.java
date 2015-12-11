// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import android.app.FragmentManager;
import android.os.Bundle;
import com.ebay.mobile.activities.BaseActivity;

// Referenced classes of package com.ebay.mobile.user.symban:
//            SymbanFragment

public class SymbanActivity extends BaseActivity
{

    private SymbanFragment frag;

    public SymbanActivity()
    {
    }

    public String getTrackingEventName()
    {
        return "BadgeNotificationAction";
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030263);
        frag = (SymbanFragment)getFragmentManager().findFragmentById(0x7f100825);
    }

    protected void onDestroy()
    {
        if (isFinishing())
        {
            frag.markAllRead();
        }
        super.onDestroy();
    }
}

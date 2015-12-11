// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import com.abtnprojects.ambatana.ui.activities.b;
import com.abtnprojects.ambatana.ui.fragments.c;

public class NotificationPreferenceActivity extends b
{

    public NotificationPreferenceActivity()
    {
    }

    protected void a(Bundle bundle, boolean flag)
    {
        a(0x7f0200d1);
        Object obj = getFragmentManager();
        if ((com.abtnprojects.ambatana.ui.fragments.b)((FragmentManager) (obj)).findFragmentByTag("notif") == null)
        {
            bundle = (new c(android.os.Build.VERSION.SDK_INT)).a();
            obj = ((FragmentManager) (obj)).beginTransaction();
            ((FragmentTransaction) (obj)).replace(0x7f10009b, bundle, "notif");
            ((FragmentTransaction) (obj)).commit();
        }
    }

    protected void k()
    {
        setContentView(0x7f040022);
    }

    protected boolean m()
    {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }
}

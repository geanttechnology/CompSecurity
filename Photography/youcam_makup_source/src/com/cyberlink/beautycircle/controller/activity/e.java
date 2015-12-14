// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.cyberlink.beautycircle.controller.fragment.f;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity, d

class e
{

    public final com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.Tab a;
    public final Class b;
    public final d c;
    final MainActivity d;
    private f e;

    public e(MainActivity mainactivity, com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.Tab tab, Class class1, d d1, Bundle bundle)
    {
        d = mainactivity;
        super();
        e = null;
        if (!com/cyberlink/beautycircle/controller/fragment/f.isAssignableFrom(class1))
        {
            throw new RuntimeException();
        }
        a = tab;
        b = class1;
        c = d1;
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        e = (f)mainactivity.getSupportFragmentManager().getFragment(bundle, class1.getName());
        return;
        mainactivity;
        e = null;
        return;
    }

    public f a()
    {
        if (e != null)
        {
            return e;
        }
        try
        {
            e = (f)b.newInstance();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return e;
    }

    public boolean b()
    {
        return e != null;
    }
}

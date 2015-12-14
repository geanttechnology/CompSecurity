// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import junit.framework.Assert;

// Referenced classes of package com.socialin.android.photo.template:
//            b, d

final class g extends FragmentPagerAdapter
{

    private Fragment a[];

    public g(FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
        a = new Fragment[getCount()];
    }

    public final int getCount()
    {
        return 2;
    }

    public final Fragment getItem(int i)
    {
        Object obj = null;
        if (i != 0) goto _L2; else goto _L1
_L1:
        if (a[0] == null)
        {
            obj = new Bundle();
            a[0] = new b();
            a[0].setArguments(((Bundle) (obj)));
        }
        obj = a[0];
_L4:
        Assert.assertNotNull(obj);
        ((Fragment) (obj)).setRetainInstance(false);
        return ((Fragment) (obj));
_L2:
        if (i == 1)
        {
            if (a[1] == null)
            {
                a[1] = new d();
            }
            Fragment fragment = a[1];
            b b1 = (b)getItem(0);
            obj = fragment;
            if (b1.a != fragment)
            {
                b1.a((d)fragment);
                obj = fragment;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}

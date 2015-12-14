// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import com.socialin.android.photo.template.b;
import com.socialin.android.photo.template.d;
import junit.framework.Assert;

// Referenced classes of package com.picsart.collages:
//            SelectCollageActivity

final class h extends FragmentPagerAdapter
{

    private Fragment a[];
    private SelectCollageActivity b;

    public h(SelectCollageActivity selectcollageactivity, FragmentManager fragmentmanager)
    {
        b = selectcollageactivity;
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
            ((d)fragment).a = SelectCollageActivity.a(b);
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

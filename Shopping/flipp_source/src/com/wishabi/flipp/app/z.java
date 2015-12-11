// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.wishabi.flipp.app:
//            dl

public class z extends dl
{

    public z()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        bundle = getActivity();
        if (bundle == null)
        {
            return null;
        }
        if (a())
        {
            layoutinflater = layoutinflater.inflate(0x7f030020, viewgroup, false);
        } else
        {
            layoutinflater = layoutinflater.inflate(0x7f03001f, viewgroup, false);
        }
        b(bundle.getString(0x7f0e007e));
        return layoutinflater;
    }
}

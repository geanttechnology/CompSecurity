// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.shazam.android.aspects.c.b.b;
import com.shazam.android.widget.tagging.j;
import com.shazam.android.widget.tagging.n;
import com.shazam.android.widget.tagging.o;

// Referenced classes of package com.shazam.android.aspects.fragments:
//            ShazamCustomFragmentAspect

public class ShazamFloatingButtonFragmentAspect extends ShazamCustomFragmentAspect
{

    private final n lifecycleManager = new n();

    public ShazamFloatingButtonFragmentAspect()
    {
    }

    public void onActivityCreated(b b, Bundle bundle)
    {
        n.a(b, j.a(b));
    }

    public void onConfigurationChanged(b b, Configuration configuration)
    {
        if (n.a(n.a(b)))
        {
            b = n.b(b.getActivity());
            if (configuration.orientation == 2)
            {
                b.b();
            } else
            if (configuration.orientation == 1)
            {
                b.a();
                return;
            }
        }
    }

    public void onPause(b b)
    {
        n.b(b);
    }

    public void onResume(b b)
    {
        n.a(b);
    }

    public void onUnselected(b b)
    {
        if (b.getActivity() != null)
        {
            n.a(b.getActivity(), b);
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import android.view.View;

// Referenced classes of package com.picsart.studio.activity:
//            MapActivity

final class a
    implements Runnable
{

    private boolean a;
    private MapActivity b;

    public final void run()
    {
        View view = MapActivity.g(b);
        int i;
        if (a)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    (MapActivity mapactivity, boolean flag)
    {
        b = mapactivity;
        a = flag;
        super();
    }
}

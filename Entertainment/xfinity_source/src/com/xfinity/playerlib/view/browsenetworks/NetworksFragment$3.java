// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsenetworks;

import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.xfinity.playerlib.view.browsenetworks:
//            NetworksFragment

class this._cls0
    implements Runnable
{

    final NetworksFragment this$0;

    public void run()
    {
        if (NetworksFragment.access$1000(NetworksFragment.this).getScrollY() < NetworksFragment.access$1100(NetworksFragment.this).getHeight())
        {
            NetworksFragment.access$1300(NetworksFragment.this).scrollTo(NetworksFragment.access$1200(NetworksFragment.this).getScrollX(), 0);
        }
    }

    ()
    {
        this$0 = NetworksFragment.this;
        super();
    }
}

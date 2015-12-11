// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.map;

import android.support.v4.app.f;

// Referenced classes of package com.target.ui.fragment.map:
//            StoreMapFragment

class this._cls0
    implements Runnable
{

    final StoreMapFragment this$0;

    public void run()
    {
        if (getActivity() != null && !Z())
        {
            getActivity().onBackPressed();
        }
    }

    ()
    {
        this$0 = StoreMapFragment.this;
        super();
    }
}

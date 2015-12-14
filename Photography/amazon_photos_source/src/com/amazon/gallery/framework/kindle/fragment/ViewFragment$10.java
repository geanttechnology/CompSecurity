// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import com.amazon.gallery.framework.kindle.recyclerview.RecyclerAdapter;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ViewFragment

class this._cls0
    implements Runnable
{

    final ViewFragment this$0;

    public void run()
    {
        mAdapter.notifyDataSetChanged();
    }

    ter()
    {
        this$0 = ViewFragment.this;
        super();
    }
}

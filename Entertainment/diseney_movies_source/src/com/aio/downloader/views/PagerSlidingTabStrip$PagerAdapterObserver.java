// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.database.DataSetObserver;

// Referenced classes of package com.aio.downloader.views:
//            PagerSlidingTabStrip

private class <init> extends DataSetObserver
{

    private boolean attached;
    final PagerSlidingTabStrip this$0;

    public boolean isAttached()
    {
        return attached;
    }

    public void onChanged()
    {
        notifyDataSetChanged();
    }

    public void setAttached(boolean flag)
    {
        attached = flag;
    }

    private ()
    {
        this$0 = PagerSlidingTabStrip.this;
        super();
        attached = false;
    }

    attached(attached attached1)
    {
        this();
    }
}

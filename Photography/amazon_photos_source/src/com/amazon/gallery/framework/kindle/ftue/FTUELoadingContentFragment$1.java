// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;


// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            FTUELoadingContentFragment

class this._cls0
    implements com.amazon.gallery.framework.data.dao.sqlite.mediastore.mpletedListener
{

    final FTUELoadingContentFragment this$0;

    public void onSyncCompleted()
    {
        FTUELoadingContentFragment.access$000(FTUELoadingContentFragment.this);
    }

    Provider.SyncCompletedListener()
    {
        this$0 = FTUELoadingContentFragment.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.Loader;
import com.groupon.loader.ThanksDealListLoaderCallbacks;
import com.groupon.util.PendingAdapterWrapper;
import commonlib.adapter.JavaAdapter;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            AbstractThanks

class  extends ThanksDealListLoaderCallbacks
{

    final AbstractThanks this$0;

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        super.onLoadFinished(loader, list);
        afterDealListLoaded(list);
    }

    (Context context, JavaAdapter javaadapter, PendingAdapterWrapper pendingadapterwrapper)
    {
        this$0 = AbstractThanks.this;
        super(context, javaadapter, pendingadapterwrapper);
    }
}

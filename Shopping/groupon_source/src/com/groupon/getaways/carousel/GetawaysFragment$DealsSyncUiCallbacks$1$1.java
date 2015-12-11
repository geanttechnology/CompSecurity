// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.support.v4.widget.SwipeRefreshLayout;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.LoaderCallbacksUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.getaways.carousel:
//            GetawaysFragment, EndlessRecyclerViewAdapter

class this._cls2
    implements Function2
{

    final ._cls0 this$2;

    public volatile void execute(Object obj, Object obj1)
        throws Exception
    {
        execute((Runnable)obj, (Exception)obj1);
    }

    public void execute(Runnable runnable, Exception exception)
    {
        GetawaysFragment.access$1400(_fld0).log(exception);
        GetawaysFragment.access$1502(_fld0, false);
        GetawaysFragment.access$1600(_fld0).set(false);
        GetawaysFragment.access$1700(_fld0).setProgressViewVisible(false);
        if (!GetawaysFragment.access$1800(_fld0).get() && swipeRefreshLayout != null)
        {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    is._cls1()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/groupon/getaways/carousel/GetawaysFragment$DealsSyncUiCallbacks$1

/* anonymous class */
    class GetawaysFragment.DealsSyncUiCallbacks._cls1
        implements Function2
    {

        final GetawaysFragment.DealsSyncUiCallbacks this$1;

        public volatile void execute(Object obj, Object obj1)
            throws Exception
        {
            execute((Runnable)obj, (Exception)obj1);
        }

        public void execute(Runnable runnable, Exception exception)
        {
            LoaderCallbacksUtil.showGenericErrorMessage(runnable, exception, getActivity(), (DialogManager)GetawaysFragment.access$1300(this$0).get(), GetawaysFragment.access$1100(this$0), null, new GetawaysFragment.DealsSyncUiCallbacks._cls1._cls1());
        }

            
            {
                this$1 = GetawaysFragment.DealsSyncUiCallbacks.this;
                super();
            }
    }

}

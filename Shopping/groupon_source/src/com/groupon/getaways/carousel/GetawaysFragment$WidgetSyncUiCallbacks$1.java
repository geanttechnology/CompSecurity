// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.support.v4.widget.SwipeRefreshLayout;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.LoaderCallbacksUtil;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.getaways.carousel:
//            GetawaysFragment, GetawaysWidgetRecyclerViewAdapter

class this._cls1
    implements Function2
{

    final is._cls0 this$1;

    public volatile void execute(Object obj, Object obj1)
        throws Exception
    {
        execute((Runnable)obj, (Exception)obj1);
    }

    public void execute(Runnable runnable, Exception exception)
    {
        LoaderCallbacksUtil.showGenericErrorMessage(runnable, exception, getActivity(), (DialogManager)GetawaysFragment.access$1300(_fld0).get(), GetawaysFragment.access$1900(_fld0), null, new Function2() {

            final GetawaysFragment.WidgetSyncUiCallbacks._cls1 this$2;

            public volatile void execute(Object obj, Object obj1)
                throws Exception
            {
                execute((Runnable)obj, (Exception)obj1);
            }

            public void execute(Runnable runnable1, Exception exception1)
            {
                GetawaysFragment.access$1400(this$0).log(exception1);
                GetawaysFragment.access$2000(this$0).setDeals(Collections.emptyList());
                GetawaysFragment.access$1800(this$0).set(false);
                if (!GetawaysFragment.access$1600(this$0).get())
                {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }

            
            {
                this$2 = GetawaysFragment.WidgetSyncUiCallbacks._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }
}

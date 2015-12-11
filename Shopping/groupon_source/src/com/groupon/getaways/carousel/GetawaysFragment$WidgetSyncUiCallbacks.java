// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.support.v4.widget.SwipeRefreshLayout;
import com.groupon.activity.IntentFactory;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CountryUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.LoaderCallbacksUtil;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.getaways.carousel:
//            GetawaysFragment, GetawaysWidgetRecyclerViewAdapter

private class <init>
    implements commonlib.manager.UiCallbacks
{

    final GetawaysFragment this$0;

    public void enableSyncProgressIndicator(boolean flag)
    {
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            LoaderCallbacksUtil.handleSyncError(runnable, exception, getActivity(), (LoginService)GetawaysFragment.access$800(GetawaysFragment.this).get(), (CountryUtil)GetawaysFragment.access$900(GetawaysFragment.this).get(), GetawaysFragment.access$1000(GetawaysFragment.this).getCurrentCountry(), GetawaysFragment.access$1900(GetawaysFragment.this), (IntentFactory)GetawaysFragment.access$1200(GetawaysFragment.this).get(), new Function2() {

                final GetawaysFragment.WidgetSyncUiCallbacks this$1;

                public volatile void execute(Object obj, Object obj1)
                    throws Exception
                {
                    execute((Runnable)obj, (Exception)obj1);
                }

                public void execute(Runnable runnable1, Exception exception1)
                {
                    LoaderCallbacksUtil.showGenericErrorMessage(runnable1, exception1, getActivity(), (DialogManager)GetawaysFragment.access$1300(this$0).get(), GetawaysFragment.access$1900(this$0), null, new Function2() {

                        final _cls1 this$2;

                        public volatile void execute(Object obj, Object obj1)
                            throws Exception
                        {
                            execute((Runnable)obj, (Exception)obj1);
                        }

                        public void execute(Runnable runnable, Exception exception)
                        {
                            GetawaysFragment.access$1400(this$0).log(exception);
                            GetawaysFragment.access$2000(this$0).setDeals(Collections.emptyList());
                            GetawaysFragment.access$1800(this$0).set(false);
                            if (!GetawaysFragment.access$1600(this$0).get())
                            {
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                }

            
            {
                this$1 = GetawaysFragment.WidgetSyncUiCallbacks.this;
                super();
            }
            });
            return;
        }
    }

    private _cls1.this._cls1()
    {
        this$0 = GetawaysFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

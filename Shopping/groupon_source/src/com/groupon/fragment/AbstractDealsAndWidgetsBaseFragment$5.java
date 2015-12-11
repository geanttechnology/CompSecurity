// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.LoaderCallbacksUtil;
import com.groupon.view.GrouponSwipeRefreshLayout;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            AbstractDealsAndWidgetsBaseFragment

class this._cls0
    implements Function2
{

    final AbstractDealsAndWidgetsBaseFragment this$0;

    public volatile void execute(Object obj, Object obj1)
        throws Exception
    {
        execute((Runnable)obj, (Exception)obj1);
    }

    public void execute(Runnable runnable, Exception exception)
    {
        LoaderCallbacksUtil.showGenericErrorMessage(runnable, exception, activity, (DialogManager)dialogManager.get(), getBaseSyncManager(), new Function2() {

            final AbstractDealsAndWidgetsBaseFragment._cls5 this$1;

            public volatile void execute(Object obj, Object obj1)
                throws Exception
            {
                execute((Runnable)obj, (Exception)obj1);
            }

            public void execute(Runnable runnable1, Exception exception1)
            {
                if (swipeLayout != null && swipeLayout.isEnabled())
                {
                    swipeLayout.setRefreshing(true);
                }
            }

            
            {
                this$1 = AbstractDealsAndWidgetsBaseFragment._cls5.this;
                super();
            }
        }, new Function2() {

            final AbstractDealsAndWidgetsBaseFragment._cls5 this$1;

            public volatile void execute(Object obj, Object obj1)
                throws Exception
            {
                execute((Runnable)obj, (Exception)obj1);
            }

            public void execute(Runnable runnable1, Exception exception1)
            {
                handleSyncErrorCancellation(runnable1, exception1);
            }

            
            {
                this$1 = AbstractDealsAndWidgetsBaseFragment._cls5.this;
                super();
            }
        });
    }

    _cls2.this._cls1()
    {
        this$0 = AbstractDealsAndWidgetsBaseFragment.this;
        super();
    }
}

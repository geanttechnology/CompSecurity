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

class this._cls1
    implements Function2
{

    final leSyncErrorCancellation this$1;

    public volatile void execute(Object obj, Object obj1)
        throws Exception
    {
        execute((Runnable)obj, (Exception)obj1);
    }

    public void execute(Runnable runnable, Exception exception)
    {
        handleSyncErrorCancellation(runnable, exception);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/fragment/AbstractDealsAndWidgetsBaseFragment$5

/* anonymous class */
    class AbstractDealsAndWidgetsBaseFragment._cls5
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
            LoaderCallbacksUtil.showGenericErrorMessage(runnable, exception, activity, (DialogManager)dialogManager.get(), getBaseSyncManager(), new AbstractDealsAndWidgetsBaseFragment._cls5._cls1(), new AbstractDealsAndWidgetsBaseFragment._cls5._cls2());
        }

            
            {
                this$0 = AbstractDealsAndWidgetsBaseFragment.this;
                super();
            }

        // Unreferenced inner class com/groupon/fragment/AbstractDealsAndWidgetsBaseFragment$5$1

/* anonymous class */
        class AbstractDealsAndWidgetsBaseFragment._cls5._cls1
            implements Function2
        {

            final AbstractDealsAndWidgetsBaseFragment._cls5 this$1;

            public volatile void execute(Object obj, Object obj1)
                throws Exception
            {
                execute((Runnable)obj, (Exception)obj1);
            }

            public void execute(Runnable runnable, Exception exception)
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
        }

    }

}

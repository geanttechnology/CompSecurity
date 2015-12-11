// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment.mygroupons;

import android.content.Context;
import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.LoaderCallbacksUtil;
import com.groupon.view.GrouponSwipeRefreshLayout;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment.mygroupons:
//            BaseMyGrouponsFragment

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
        BaseMyGrouponsFragment.access$000(_fld0, runnable, exception);
    }

    l.context()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/fragment/mygroupons/BaseMyGrouponsFragment$6

/* anonymous class */
    class BaseMyGrouponsFragment._cls6
        implements Function2
    {

        final BaseMyGrouponsFragment this$0;
        final Context val$context;

        public volatile void execute(Object obj, Object obj1)
            throws Exception
        {
            execute((Runnable)obj, (Exception)obj1);
        }

        public void execute(Runnable runnable, Exception exception)
        {
            LoaderCallbacksUtil.showGenericErrorMessage(runnable, exception, context, (DialogManager)dialogManager.get(), getSyncManager(), new BaseMyGrouponsFragment._cls6._cls1(), new BaseMyGrouponsFragment._cls6._cls2());
        }

            
            {
                this$0 = final_basemygrouponsfragment;
                context = Context.this;
                super();
            }

        // Unreferenced inner class com/groupon/fragment/mygroupons/BaseMyGrouponsFragment$6$1

/* anonymous class */
        class BaseMyGrouponsFragment._cls6._cls1
            implements Function2
        {

            final BaseMyGrouponsFragment._cls6 this$1;

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
                        this$1 = BaseMyGrouponsFragment._cls6.this;
                        super();
                    }
        }

    }

}

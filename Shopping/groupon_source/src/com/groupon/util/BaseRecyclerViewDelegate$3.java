// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.db.models.Pagination;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.GrouponSwipeRefreshLayoutV3;
import java.util.List;

// Referenced classes of package com.groupon.util:
//            Function2, BaseRecyclerViewDelegate, LoaderCallbacksUtil

class val.context
    implements Function2
{

    final BaseRecyclerViewDelegate this$0;
    final Context val$context;

    public volatile void execute(Object obj, Object obj1)
        throws Exception
    {
        execute((Runnable)obj, (Exception)obj1);
    }

    public void execute(Runnable runnable, Exception exception)
    {
        if (!BaseRecyclerViewDelegate.access$300(BaseRecyclerViewDelegate.this))
        {
            LoaderCallbacksUtil.showGenericErrorMessage(runnable, exception, val$context, BaseRecyclerViewDelegate.access$400(BaseRecyclerViewDelegate.this), BaseRecyclerViewDelegate.access$500(BaseRecyclerViewDelegate.this), new Function2() {

                final BaseRecyclerViewDelegate._cls3 this$1;

                public volatile void execute(Object obj, Object obj1)
                    throws Exception
                {
                    execute((Runnable)obj, (Exception)obj1);
                }

                public void execute(Runnable runnable1, Exception exception1)
                {
                    if (BaseRecyclerViewDelegate.access$600(this$0) != null && BaseRecyclerViewDelegate.access$600(this$0).isEnabled())
                    {
                        BaseRecyclerViewDelegate.access$600(this$0).setRefreshing(true);
                    }
                    BaseRecyclerViewDelegate.access$702(this$0, false);
                }

            
            {
                this$1 = BaseRecyclerViewDelegate._cls3.this;
                super();
            }
            }, new Function2() {

                final BaseRecyclerViewDelegate._cls3 this$1;

                public volatile void execute(Object obj, Object obj1)
                    throws Exception
                {
                    execute((Runnable)obj, (Exception)obj1);
                }

                public void execute(Runnable runnable1, Exception exception1)
                {
                    runnable1 = BaseRecyclerViewDelegate.access$000(this$0).getList();
                    if (runnable1.size() > 0)
                    {
                        int i = runnable1.size() - 1;
                        if (runnable1.get(i) instanceof Pagination)
                        {
                            runnable1.remove(i);
                        }
                        BaseRecyclerViewDelegate.access$000(this$0).setList(runnable1);
                    }
                    BaseRecyclerViewDelegate.access$702(this$0, false);
                }

            
            {
                this$1 = BaseRecyclerViewDelegate._cls3.this;
                super();
            }
            });
        }
    }

    _cls2.this._cls1()
    {
        this$0 = final_baserecyclerviewdelegate;
        val$context = Context.this;
        super();
    }
}

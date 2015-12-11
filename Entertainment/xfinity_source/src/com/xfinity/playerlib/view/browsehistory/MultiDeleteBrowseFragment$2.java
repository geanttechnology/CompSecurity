// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import android.content.Context;
import android.widget.AbsListView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.model.provider.RetryingTaskExecutionListener;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            MultiDeleteBrowseFragment

class this._cls0 extends RetryingTaskExecutionListener
{

    final MultiDeleteBrowseFragment this$0;

    public void onPostExecute(Object obj)
    {
        onResourceFetched(obj);
        if (MultiDeleteBrowseFragment.access$000(MultiDeleteBrowseFragment.this))
        {
            int i;
            for (obj = MultiDeleteBrowseFragment.access$100(MultiDeleteBrowseFragment.this).iterator(); ((Iterator) (obj)).hasNext(); MultiDeleteBrowseFragment.access$200(MultiDeleteBrowseFragment.this).setItemChecked(i, true))
            {
                i = ((Integer)((Iterator) (obj)).next()).intValue();
            }

            MultiDeleteBrowseFragment.access$300(MultiDeleteBrowseFragment.this);
        }
        alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.LOADED);
    }

    public void onPreAsynchronousExecute()
    {
        alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib..speakManagedMessage);
    }

    (TaskExecutor taskexecutor, Context context, ErrorDialogFactory errordialogfactory, android.content.ener ener)
    {
        this$0 = MultiDeleteBrowseFragment.this;
        super(taskexecutor, context, errordialogfactory, ener);
    }
}

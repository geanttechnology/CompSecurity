// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            NetworkCollectionsFragment

class nit> extends DefaultTaskExecutionListener
{

    final NetworkCollectionsFragment this$0;

    public void onError(TaskExecutionException taskexecutionexception)
    {
        getLoadingViewDelegate().onLoadingFailed();
    }

    public void onPostExecute(VideoEntitlement videoentitlement)
    {
        NetworkCollectionsFragment.access$302(NetworkCollectionsFragment.this, videoentitlement);
        NetworkCollectionsFragment.access$400(NetworkCollectionsFragment.this);
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((VideoEntitlement)obj);
    }

    ()
    {
        this$0 = NetworkCollectionsFragment.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            NetworkCollectionsFragment

class nit> extends DefaultTaskExecutionListener
{

    final NetworkCollectionsFragment this$0;

    public void onError(TaskExecutionException taskexecutionexception)
    {
        getLoadingViewDelegate().onLoadingFailed();
    }

    public void onPostExecute(Tuple tuple)
    {
        NetworkCollectionsFragment.access$502(NetworkCollectionsFragment.this, ((TagsRoot)tuple.e1).getNetworkByCompanyId(NetworkCollectionsFragment.access$600(NetworkCollectionsFragment.this)));
        tuple = (DibicResource)tuple.e2;
        NetworkCollectionsFragment.access$702(NetworkCollectionsFragment.this, NetworkCollectionsFragment.access$500(NetworkCollectionsFragment.this).getCategories());
        NetworkCollectionsFragment.access$802(NetworkCollectionsFragment.this, tuple.getProgramsMatchingGenresAndNetwork(NetworkCollectionsFragment.access$700(NetworkCollectionsFragment.this), NetworkCollectionsFragment.access$500(NetworkCollectionsFragment.this)));
        if (!NetworkCollectionsFragment.access$500(NetworkCollectionsFragment.this).isPremium() || NetworkCollectionsFragment.access$700(NetworkCollectionsFragment.this).size() == 0)
        {
            NetworkCollectionsFragment.access$702(NetworkCollectionsFragment.this, new ArrayList());
            NetworkCollectionsFragment.access$700(NetworkCollectionsFragment.this).addAll(NetworkCollectionsFragment.access$800(NetworkCollectionsFragment.this).keySet());
        }
        NetworkCollectionsFragment.access$400(NetworkCollectionsFragment.this);
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((Tuple)obj);
    }

    ()
    {
        this$0 = NetworkCollectionsFragment.this;
        super();
    }
}
